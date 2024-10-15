package com.sipgate.li.lib.x2x3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.sipgate.li.lib.x2x3.tlv.*;
import io.netty.buffer.Unpooled;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PduObjectTest {

  public static final byte[] EMPTY = new byte[0];
  public static final byte[] CID = { 1, 2, 3, 4, 5, 6, 7, 8 };

  @Test
  void it_throws_on_wrong_major_version() {
    final var exception = assertThrows(PduValidationException.class, () ->
      new PduObject(
        (short) 666,
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
    assertThat(exception.getFieldName()).isEqualTo("majorVersion");
  }

  @Test
  void it_throws_on_wrong_minor_version() throws Exception {
    final var exception = assertThrows(PduValidationException.class, () ->
      new PduObject(
        (short) 0,
        (short) 666,
        PduType.X2_PDU,
        PayloadFormat.SIP,
        PayloadDirection.SENT_FROM_TARGET,
        UUID.randomUUID(),
        CID,
        new TLV[0],
        EMPTY
      )
    );
    assertThat(exception.getFieldName()).isEqualTo("minorVersion");
  }

  @Test
  void it_throws_with_illegal_x2pdu_payload_combination() throws Exception {
    final var exception = assertThrows(PduValidationException.class, () ->
      new PduObject(
        (short) 0,
        (short) 5,
        PduType.X2_PDU,
        PayloadFormat.GTP_U,
        PayloadDirection.SENT_FROM_TARGET,
        UUID.randomUUID(),
        CID,
        new TLV[0],
        EMPTY
      )
    );
    assertThat(exception.getFieldName()).isEqualTo("payloadFormat");
  }

  @Test
  void it_throws_with_illegal_x3pdu_payload_combination() throws Exception {
    final var exception = assertThrows(PduValidationException.class, () ->
      new PduObject(
        (short) 0,
        (short) 5,
        PduType.X3_PDU,
        PayloadFormat.SIP,
        PayloadDirection.SENT_FROM_TARGET,
        UUID.randomUUID(),
        CID,
        new TLV[0],
        EMPTY
      )
    );
    assertThat(exception.getFieldName()).isEqualTo("payloadFormat");
  }

  @Test
  void it_throws_with_illegal_correlation_id_length() throws Exception {
    final var exception = assertThrows(PduValidationException.class, () ->
      new PduObject(
        (short) 0,
        (short) 5,
        PduType.X2_PDU,
        PayloadFormat.SIP,
        PayloadDirection.SENT_FROM_TARGET,
        UUID.randomUUID(),
        new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 },
        new TLV[0],
        EMPTY
      )
    );
    assertThat(exception.getFieldName()).isEqualTo("correlationID");
  }

  @Test
  void it_creates_a_pdu_object() throws Exception {
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
    );
  }

  @ParameterizedTest
  @MethodSource("provideTLVs")
  void it_writes_tlv(final TLV tlvToEncode, final byte[] expectedContent, final int expectedType) throws Exception {
    // GIVEN
    final var byteArrayOutputStream = new ByteArrayOutputStream();
    final var dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    final var underTest = new PduObject(
      (short) 0,
      (short) 5,
      PduType.X2_PDU,
      PayloadFormat.SIP,
      PayloadDirection.SENT_FROM_TARGET,
      UUID.randomUUID(),
      CID,
      new TLV[] { tlvToEncode },
      EMPTY
    );

    // WHEN
    underTest.writeTo(dataOutputStream);

    // THEN
    final var byteBuf = Unpooled.wrappedBuffer(byteArrayOutputStream.toByteArray());
    final var pduObject = new X2X3Decoder(1024, 1024).decode(byteBuf).get();

    final var tlvs = pduObject.conditionalAttributeFields();
    assertThat(tlvs).hasSize(1);
    final var tlv = (GenericTLV) tlvs[0];
    assertThat(tlv.type()).isEqualTo(expectedType);
    assertThat(tlv.contents()).isEqualTo(expectedContent);
  }

  public static Stream<Arguments> provideTLVs() throws UnknownHostException {
    return Stream.of(
      Arguments.of(
        new SequenceNumberTLV(32),
        new byte[] { 0, 0, 0, 0x20 },
        8,
        new SourceIpv4TLV((Inet4Address) Inet4Address.getByName("172.168.4.2")),
        new byte[] { (byte) 0xac, (byte) 0xa8, 0x04, 0x02 },
        10,
        new TimestampTLV(Instant.ofEpochMilli(42)),
        new byte[] { 0x0, 0x0, 0x0, 0x2a, 0x0, 0x0, 0x0, 0x0 },
        9,
        new GenericTLV(5, "nase".getBytes()),
        "nase".getBytes(),
        5 //mocks DID
      )
    );
  }
}
