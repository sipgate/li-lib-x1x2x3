package com.sipgate.li.lib.x2x3.server;

import static com.sipgate.util.ArrayUtils.concat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.sipgate.li.lib.x2x3.protocol.PayloadDirection;
import com.sipgate.li.lib.x2x3.protocol.PayloadFormat;
import com.sipgate.li.lib.x2x3.protocol.PduType;
import com.sipgate.li.lib.x2x3.protocol.tlv.GenericTLV;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class X2X3DecoderTest {

  private static final int MAJOR_VERSION_INDEX = 0;
  private static final int MINOR_VERSION_INDEX = MAJOR_VERSION_INDEX + 1;
  private static final int PDU_TYPE_INDEX = MINOR_VERSION_INDEX + 1;
  private static final int HEADER_LENGTH_INDEX = PDU_TYPE_INDEX + 2;
  private static final int PAYLOAD_LENGTH_INDEX = HEADER_LENGTH_INDEX + 4;

  final X2X3Decoder underTest = new X2X3Decoder(120, 1492);

  @Test
  void it_parses_x2_packet_correctly() throws Exception {
    // GIVEN
    final var pduBytes = getPduBytesFromPcapFile("x2-demo-01.pcap");
    // Run test with two pdu packets because, in real life, the buffer might contain the remainder of future packets
    // at the end.
    final var inputByteStream = concat(pduBytes, pduBytes);

    final var in = Unpooled.wrappedBuffer(inputByteStream);

    // WHEN

    final var pdu = underTest.decode(in).get();

    // THEN
    assertThat(pdu.majorVersion()).isEqualTo((short) 0);
    assertThat(pdu.minorVersion()).isEqualTo((short) 5);
    assertThat(pdu.pduType()).isEqualTo(PduType.X2_PDU);
    assertThat(pdu.payloadFormat()).isEqualTo(PayloadFormat.SIP);
    assertThat(pdu.payloadDirection()).isEqualTo(PayloadDirection.SENT_FROM_TARGET);
    assertThat(pdu.payload().length).isEqualTo(539);
    assertThat(pdu.conditionalAttributeFields()).hasSize(1);

    final var actualTlv = (GenericTLV) pdu.conditionalAttributeFields()[0];
    assertThat(actualTlv.type()).isEqualTo(17);
    assertThat(actualTlv.contents()).isEqualTo(
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
    );
  }

  @Test
  void it_throws_on_x2_with_illegal_headerLength() throws Exception {
    // GIVEN
    final var data = getPduBytesFromPcapFile("x2-demo-01.pcap");
    data[HEADER_LENGTH_INDEX] = 0x7f; // <<< too high
    final ByteBuf in = Unpooled.wrappedBuffer(data);

    // WHEN-THEN
    assertThrows(IllegalArgumentException.class, () -> underTest.decode(in));
  }

  @Test
  void it_throws_on_x2_with_illegal_payloadLength() throws Exception {
    // GIVEN
    final var data = getPduBytesFromPcapFile("x2-demo-01.pcap");
    data[PAYLOAD_LENGTH_INDEX] = 0x7f; // <<< too high
    final ByteBuf in = Unpooled.wrappedBuffer(data);

    // WHEN-THEN
    assertThrows(IllegalArgumentException.class, () -> underTest.decode(in));
  }

  private byte[] getPduBytesFromPcapFile(final String pcapFilename) throws IOException {
    final var inputStream = getClass().getClassLoader().getResourceAsStream(pcapFilename);
    final var skipped = inputStream.skip(106);
    assert skipped == 106;
    final var data = inputStream.readAllBytes();
    return data;
  }
}
