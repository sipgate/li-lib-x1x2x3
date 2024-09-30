package com.sipgate.li.lib.x2x3;

import java.util.UUID;

public record PduObject(
  short majorVersion, // 0
  short minorVersion, // 5
  PduType pduType,
  // implicit: long headerLength,
  // implicit: long payloadLength,
  PayloadFormat payloadFormat,
  PayloadDirection payloadDirection,
  UUID xid,
  byte[] correlationID,
  byte[] conditionalAttributeFields,
  byte[] payload
) {
  public PduObject {
    if (majorVersion != MAJOR_VERSION) {
      throw new PduValidationException("Must be " + MAJOR_VERSION, "majorVersion");
    }
    if (minorVersion != MINOR_VERSION) {
      throw new PduValidationException("Must be " + MINOR_VERSION, "minorVersion");
    }
    if (pduType == PduType.X2_PDU && !payloadFormat.x2allowed) {
      throw new PduValidationException("Must be X2 compatible", "payloadFormat");
    }
    if (pduType == PduType.X3_PDU && !payloadFormat.x3allowed) {
      throw new PduValidationException("Must be X3 compatible", "payloadFormat");
    }
    if (correlationID.length != CORRELATION_ID_LENGTH) {
      throw new PduValidationException("Must exactly 8 bytes long", "correlationID");
    }
  }

  public static final int MINOR_VERSION = 5;
  public static final int MAJOR_VERSION = 0;
  public static final int MANDATORY_HEADER_LENGTH = 40;
  public static final int CORRELATION_ID_LENGTH = 8;
}
