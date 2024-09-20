package com.sipgate.li.lib.x2x3;

import java.util.List;
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
    if (pduType == PduType.X2_PDU && !payloadFormat().x2allowed) {
      throw new IllegalArgumentException(
        "X2_PDU does not allow payload format " + payloadFormat
      );
    }
    if (pduType == PduType.X3_PDU && !payloadFormat().x3allowed) {
      throw new IllegalArgumentException(
        "X3_PDU does not allow payload format " + payloadFormat
      );
    }
  }
}
