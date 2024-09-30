package com.sipgate.li.lib.x2x3;

import java.util.UUID;

public class PduObjectBuilder {

  private Short majorVersion;
  private Short minorVersion;
  private PduType pduType;
  private Long headerLength;
  private Long payloadLength;
  private PayloadFormat payloadFormat;
  private PayloadDirection payloadDirection;
  private UUID xid;
  private byte[] correlationID;
  private byte[] conditionalAttributeFields;
  private byte[] payload;

  public PduObjectBuilder setMajorVersion(final Short majorVersion) {
    this.majorVersion = majorVersion;
    return this;
  }

  public PduObjectBuilder setMinorVersion(final Short minorVersion) {
    this.minorVersion = minorVersion;
    return this;
  }

  public PduObjectBuilder setPduType(final PduType pduType) {
    this.pduType = pduType;
    return this;
  }

  public PduObjectBuilder setHeaderLength(final Long headerLength) {
    this.headerLength = headerLength;
    return this;
  }

  public PduObjectBuilder setPayloadLength(final Long payloadLength) {
    this.payloadLength = payloadLength;
    return this;
  }

  public PduObjectBuilder setPayloadFormat(final PayloadFormat payloadFormat) {
    this.payloadFormat = payloadFormat;
    return this;
  }

  public PduObjectBuilder setPayloadDirection(final PayloadDirection payloadDirection) {
    this.payloadDirection = payloadDirection;
    return this;
  }

  public PduObjectBuilder setXid(final UUID xid) {
    this.xid = xid;
    return this;
  }

  public PduObjectBuilder setCorrelationID(final byte[] correlationID) {
    this.correlationID = correlationID;
    return this;
  }

  public PduObjectBuilder setConditionalAttributeFields(final byte[] conditionalAttributeFields) {
    this.conditionalAttributeFields = conditionalAttributeFields;
    return this;
  }

  public PduObjectBuilder setPayload(final byte[] payload) {
    this.payload = payload;
    return this;
  }

  public PduObject build() {
    final byte[] conditionalAttributeFields = this.conditionalAttributeFields != null
      ? this.conditionalAttributeFields
      : new byte[0];
    final byte[] payload = this.payload != null ? this.payload : new byte[0];
    return new PduObject(
      this.majorVersion != null ? this.majorVersion : PduObject.MAJOR_VERSION,
      this.minorVersion != null ? this.minorVersion : PduObject.MINOR_VERSION,
      this.pduType != null ? this.pduType : PduType.X2_PDU,
      this.headerLength != null
        ? this.headerLength
        : PduObject.MANDATORY_HEADER_LENGTH + conditionalAttributeFields.length,
      this.payloadLength != null ? this.payloadLength : payload.length,
      this.payloadFormat != null ? this.payloadFormat : PayloadFormat.SIP,
      this.payloadDirection != null ? this.payloadDirection : PayloadDirection.SENT_FROM_TARGET,
      this.xid != null ? this.xid : UUID.randomUUID(),
      this.correlationID != null ? this.correlationID : new byte[PduObject.CORRELATION_ID_LENGTH],
      conditionalAttributeFields,
      payload
    );
  }

  public PduObject buildSip() {
    this.pduType = PduType.X2_PDU;
    this.payloadFormat = PayloadFormat.SIP;
    return build();
  }
}
