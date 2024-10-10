package com.sipgate.li.lib.x2x3;

import static com.sipgate.li.lib.x2x3.PduObjectTest.CID;
import static com.sipgate.li.lib.x2x3.PduObjectTest.EMPTY;
import static com.sipgate.util.ArrayUtils.concat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.sipgate.li.lib.x2x3.tlv.GenericTLV;
import com.sipgate.li.lib.x2x3.tlv.TLV;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.UUID;
import javax.net.SocketFactory;
import org.junit.jupiter.api.Test;

public class X2X3ClientTest {

  public static final byte[] DUMMY_INVITE = "INVITE myself".getBytes();

  // keep for later reference maybe?
  public static void main(final String[] args) throws Exception {
    try (final var client = new X2X3Client(SocketFactory.getDefault(), "localhost", 9998)) {
      client.send(
        new PduObject(
          (short) 0,
          (short) 5,
          PduType.X2_PDU,
          PayloadFormat.SIP,
          PayloadDirection.SENT_FROM_TARGET,
          UUID.randomUUID(),
          CID,
          new TLV[0],
          EMPTY
        )
      );
    }
  }

  @Test
  void it_encodes_a_pduObject() throws IOException {
    // GIVEN
    final var ipAddress = "wurst";
    final var port = -1;

    final var os = new ByteArrayOutputStream();
    final var socketFactory = mock(SocketFactory.class);
    final var socket = mock(Socket.class);
    when(socketFactory.createSocket(ipAddress, port)).thenReturn(socket);
    when(socket.getOutputStream()).thenReturn(os);

    final var underTest = new X2X3Client(socketFactory, ipAddress, port);

    final var pduObject = new PduObject(
      (short) 0,
      (short) 5,
      PduType.X2_PDU,
      PayloadFormat.SIP,
      PayloadDirection.SENT_FROM_TARGET,
      UUID.fromString("12345678-9abc-def0-1234-56789abcdef0"),
      CID,
      new TLV[] {
        new GenericTLV(
          17,
          new byte[] {
            0x3c,
            0x45,
            0x31,
            0x36,
            0x34,
            0x4e,
            0x75,
            0x6d,
            0x62,
            0x65,
            0x72,
            0x3e,
            0x34,
            0x39,
            0x34,
            0x30,
            0x31,
            0x32,
            0x33,
            0x34,
            0x35,
            0x36,
            0x37,
            0x38,
            0x3c,
            0x2f,
            0x45,
            0x31,
            0x36,
            0x34,
            0x4e,
            0x75,
            0x6d,
            0x62,
            0x65,
            0x72,
            0x3e,
          }
        ),
      },
      DUMMY_INVITE
    );

    // WHEN
    underTest.send(pduObject);
    final var actual = os.toByteArray();

    //@formatter:off
    // prettier-ignore
    final var expectedHeader = new byte[] {
      0, // major version
      5, // minor version
      0, 1, // pdu type
      0, 0, 0, 81, // header length
      0, 0, 0, (byte) DUMMY_INVITE.length, // payload length (attention when greater than 255!)
      0, 9, // payload format
      0, 3, // payload direction
      18,52,86,120,-102,-68,-34,-16,18,52,86,120,-102,-68,-34,-16, // xid
      1,2,3,4,5,6,7,8, // correlation id
      // TLV type (2 bytes), length (2 bytes), content
      0, 17, 0, 37, 0x3c,0x45,0x31,0x36,0x34,0x4e,0x75,0x6d,0x62,0x65,0x72,0x3e,0x34,0x39,0x34,0x30,0x31,0x32,0x33,0x34,0x35,0x36,0x37,0x38,0x3c,0x2f,0x45,0x31,0x36,0x34,0x4e,0x75,0x6d,0x62,0x65,0x72,0x3e
    };
    //@formatter:on

    final var expected = concat(expectedHeader, DUMMY_INVITE);

    // THEN
    assertThat(actual).isEqualTo(expected);
  }
}
