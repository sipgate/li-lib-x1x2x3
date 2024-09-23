package com.sipgate.li.lib.x2x3;

import java.util.UUID;

public record PduObject(
  short majorVersion, // 0
  short minorVersion, // 5
  PduType pduType,
  long headerLength,
  long payloadLength,
  PayloadFormat payloadFormat,
  PayloadDirection payloadDirection,
  UUID xid,
  byte[] correlationID,
  byte[] conditionalAttributeFields,
  byte[] payload
) {
  public PduObject {
    if (majorVersion != 0) {
      throw new PduValidationException("Must be 0", "majorVersion");
    }
    if (minorVersion != 5) {
      throw new PduValidationException("Must be 5", "minorVersion");
    }
    if (pduType == PduType.X2_PDU && !payloadFormat.x2allowed) {
      throw new PduValidationException("Must be X2 compatible", "payloadFormat");
    }
    if (pduType == PduType.X3_PDU && !payloadFormat.x3allowed) {
      throw new PduValidationException("Must be X3 compatible", "payloadFormat");
    }
    if (payloadLength != payload.length) {
      throw new PduValidationException("Must match number of bytes provided", "payloadLength");
    }
    if (headerLength != MANDATORY_HEADER_LENGTH + conditionalAttributeFields.length) {
      throw new PduValidationException("Must match number of bytes provided", "headerLength");
    }
  }

  public static final int MANDATORY_HEADER_LENGTH = 40;
}
