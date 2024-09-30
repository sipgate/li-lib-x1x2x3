package com.sipgate.li.lib.x2x3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class X2X3DecoderTest {

  final X2X3Decoder underTest = new X2X3Decoder(120, 1492);

  @Test
  void it_parses_x2_packet_correctly() throws Exception {
    // GIVEN
    final var data = getPduBytesFromPcapFile("x2-demo-01.pcap");
    final ByteBuf in = Unpooled.wrappedBuffer(data);

    // WHEN
    final List<Object> out = new ArrayList<>();
    underTest.decode(in, out);

    // THEN
    assertThat(out).hasSize(1);
    final PduObject pdu0 = (PduObject) out.getFirst();
    assertThat(pdu0.majorVersion()).isEqualTo((short) 0);
    assertThat(pdu0.minorVersion()).isEqualTo((short) 5);
    assertThat(pdu0.pduType()).isEqualTo(PduType.X2_PDU);
    assertThat(pdu0.payloadFormat()).isEqualTo(PayloadFormat.SIP);
    assertThat(pdu0.payloadDirection()).isEqualTo(PayloadDirection.SENT_FROM_TARGET);
    assertThat(pdu0.payload().length).isEqualTo(539);
    assertThat(pdu0.conditionalAttributeFields().length).isEqualTo(41);
  }

  static final int MAJOR_VERSION_INDEX = 0;
  static final int MINOR_VERSION_INDEX = MAJOR_VERSION_INDEX + 1;
  static final int PDU_TYPE_INDEX = MINOR_VERSION_INDEX + 1;
  static final int HEADER_LENGTH_INDEX = PDU_TYPE_INDEX + 2;
  static final int PAYLOAD_LENGTH_INDEX = HEADER_LENGTH_INDEX + 4;

  @Test
  void it_throws_on_x2_with_illegal_headerLength() throws Exception {
    // GIVEN
    final var data = getPduBytesFromPcapFile("x2-demo-01.pcap");
    data[HEADER_LENGTH_INDEX] = 0x7f; // <<< too high
    final ByteBuf in = Unpooled.wrappedBuffer(data);
    final List<Object> out = new ArrayList<>();

    // WHEN-THEN
    assertThrows(IllegalArgumentException.class, () -> underTest.decode(in, out));
  }

  @Test
  void it_throws_on_x2_with_illegal_payloadLength() throws Exception {
    // GIVEN
    final var data = getPduBytesFromPcapFile("x2-demo-01.pcap");
    data[PAYLOAD_LENGTH_INDEX] = 0x7f; // <<< too high
    final ByteBuf in = Unpooled.wrappedBuffer(data);
    final List<Object> out = new ArrayList<>();

    // WHEN-THEN
    assertThrows(IllegalArgumentException.class, () -> underTest.decode(in, out));
  }

  private byte[] getPduBytesFromPcapFile(final String pcapFilename) throws IOException {
    final var inputStream = getClass().getClassLoader().getResourceAsStream(pcapFilename);
    final var skipped = inputStream.skip(106); // TODO: do we want to just skip PCAP header or do we want to get away with it beforehand?
    assert skipped == 106;
    final var data = inputStream.readAllBytes();
    return data;
  }
}
