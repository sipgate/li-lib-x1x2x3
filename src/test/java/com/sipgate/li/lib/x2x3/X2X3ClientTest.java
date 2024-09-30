package com.sipgate.li.lib.x2x3;

import static com.sipgate.li.lib.x2x3.PduObject.MANDATORY_HEADER_LENGTH;
import static com.sipgate.li.lib.x2x3.PduObjectTest.CID;
import static com.sipgate.li.lib.x2x3.PduObjectTest.EMPTY;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.UUID;
import javax.net.SocketFactory;
import org.junit.jupiter.api.Test;

public class X2X3ClientTest {

  public static final byte[] DUMMY_INVITE = "INVITE myself".getBytes();

  // keep for later reference maybe?
  public static void main(final String[] args) throws Exception {
    try (final X2X3Client client = new X2X3Client(SocketFactory.getDefault(), "localhost", 9998)) {
      client.send(
        new PduObject(
          (short) 0,
          (short) 5,
          PduType.X2_PDU,
          PayloadFormat.SIP,
          PayloadDirection.SENT_FROM_TARGET,
          UUID.randomUUID(),
          CID,
          EMPTY,
          EMPTY
        )
      );
    }
  }

  @Test
  void it_encodes_a_pduObject() throws IOException {
    final var os = new ByteArrayOutputStream();

    final var socketFactory = new SocketFactory() {
      @Override
      public Socket createSocket() throws IOException {
        throw new IllegalStateException("Not implemented");
      }

      @Override
      public Socket createSocket(final String host, final int port) throws IOException {
        return new Socket() {
          @Override
          public OutputStream getOutputStream() throws IOException {
            return os;
          }
        };
      }

      @Override
      public Socket createSocket(final String host, final int port, final InetAddress localHost, final int localPort)
        throws IOException {
        throw new IllegalStateException("Not implemented");
      }

      @Override
      public Socket createSocket(final InetAddress host, final int port) throws IOException {
        throw new IllegalStateException("Not implemented");
      }

      @Override
      public Socket createSocket(
        final InetAddress address,
        final int port,
        final InetAddress localAddress,
        final int localPort
      ) throws IOException {
        throw new IllegalStateException("Not implemented");
      }
    };

    final var underTest = new X2X3Client(socketFactory, "wurst", -1);

    final PduObject pduObject = new PduObject(
      (short) 0,
      (short) 5,
      PduType.X2_PDU,
      PayloadFormat.SIP,
      PayloadDirection.SENT_FROM_TARGET,
      UUID.fromString("12345678-9abc-def0-1234-56789abcdef0"),
      CID,
      EMPTY,
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
      0, 0, 0, 40, // header length
      0, 0, 0, (byte) DUMMY_INVITE.length, // payload length (attention when greater than 255!)
      0, 9, // payload format
      0, 3, // payload direction
      18,52,86,120,-102,-68,-34,-16,18,52,86,120,-102,-68,-34,-16, // xid
      1,2,3,4,5,6,7,8, // correlation id
      // no conditional attributes
    };
    //@formatter:on

    final var expected = concat(expectedHeader, DUMMY_INVITE);

    // THEN
    assertThat(actual).isEqualTo(expected);
  }

  public static byte[] concat(final byte[] first, final byte[] second) {
    final byte[] result = Arrays.copyOf(first, first.length + second.length);
    System.arraycopy(second, 0, result, first.length, second.length);
    return result;
  }
}
