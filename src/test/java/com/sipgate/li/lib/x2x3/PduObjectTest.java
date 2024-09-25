package com.sipgate.li.lib.x2x3;

import static com.sipgate.li.lib.x2x3.PduObject.MANDATORY_HEADER_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class PduObjectTest {

  static final byte[] EMPTY = new byte[0];
  static final byte[] CID = { 1, 2, 3, 4, 5, 6, 7, 8 };

  @Test
  void it_throws_on_wrong_major_version() {
    final var exception = assertThrows(PduValidationException.class, () ->
      new PduObject(
        (short) 666,
        (short) 5,
        PduType.X2_PDU,
        MANDATORY_HEADER_LENGTH,
        0,
        PayloadFormat.SIP,
        PayloadDirection.SENT_FROM_TARGET,
        UUID.randomUUID(),
        CID,
        EMPTY,
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
        MANDATORY_HEADER_LENGTH,
        0,
        PayloadFormat.SIP,
        PayloadDirection.SENT_FROM_TARGET,
        UUID.randomUUID(),
        CID,
        EMPTY,
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
        MANDATORY_HEADER_LENGTH,
        0,
        PayloadFormat.GTP_U,
        PayloadDirection.SENT_FROM_TARGET,
        UUID.randomUUID(),
        CID,
        EMPTY,
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
        MANDATORY_HEADER_LENGTH,
        0,
        PayloadFormat.SIP,
        PayloadDirection.SENT_FROM_TARGET,
        UUID.randomUUID(),
        CID,
        EMPTY,
        EMPTY
      )
    );
    assertThat(exception.getFieldName()).isEqualTo("payloadFormat");
  }

  @Test
  void it_throws_with_illegal_payload_and_length_combination() throws Exception {
    final var exception = assertThrows(PduValidationException.class, () ->
      new PduObject(
        (short) 0,
        (short) 5,
        PduType.X2_PDU,
        MANDATORY_HEADER_LENGTH,
        3,
        PayloadFormat.SIP,
        PayloadDirection.SENT_FROM_TARGET,
        UUID.randomUUID(),
        CID,
        EMPTY,
        new byte[4]
      )
    );
    assertThat(exception.getFieldName()).isEqualTo("payloadLength");
  }

  @Test
  void it_throws_with_illegal_header_and_length_combination() throws Exception {
    final var exception = assertThrows(PduValidationException.class, () ->
      new PduObject(
        (short) 0,
        (short) 5,
        PduType.X2_PDU,
        MANDATORY_HEADER_LENGTH + 3,
        0,
        PayloadFormat.SIP,
        PayloadDirection.SENT_FROM_TARGET,
        UUID.randomUUID(),
        CID,
        new byte[4],
        EMPTY
      )
    );
    assertThat(exception.getFieldName()).isEqualTo("headerLength");
  }

  @Test
  void it_throws_with_illegal_correlation_id_length() throws Exception {
    final var exception = assertThrows(PduValidationException.class, () ->
      new PduObject(
        (short) 0,
        (short) 5,
        PduType.X2_PDU,
        MANDATORY_HEADER_LENGTH,
        0,
        PayloadFormat.SIP,
        PayloadDirection.SENT_FROM_TARGET,
        UUID.randomUUID(),
        new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 },
        EMPTY,
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
      MANDATORY_HEADER_LENGTH,
      0,
      PayloadFormat.SIP,
      PayloadDirection.SENT_FROM_TARGET,
      UUID.randomUUID(),
      CID,
      EMPTY,
      EMPTY
    );
  }
}
