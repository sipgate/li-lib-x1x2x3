package com.sipgate.li.lib.x2x3.protocol;

import com.sipgate.li.lib.x2x3.protocol.tlv.SequenceNumberTLV;
import com.sipgate.li.lib.x2x3.protocol.tlv.TLV;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Optional;
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
  TLV[] conditionalAttributeFields,
  byte[] payload
) {
  public static final int MINOR_VERSION = 5;
  public static final int MAJOR_VERSION = 0;
  public static final int MANDATORY_HEADER_LENGTH = 40;
  public static final int CORRELATION_ID_LENGTH = 8;

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
      throw new PduValidationException("Must be exactly 8 bytes long", "correlationID");
    }
  }

  public void writeTo(final DataOutputStream outputStream) throws IOException {
    // serialize all conditional attribute first, to get their size
    final var attributesBytes = new ByteArrayOutputStream();
    final var attributesData = new DataOutputStream(attributesBytes);
    for (final var tlv : conditionalAttributeFields) {
      // serialize value first, to get its size
      final var contentBytes = new ByteArrayOutputStream();
      tlv.writeValueTo(new DataOutputStream(contentBytes));

      // serialize TLV header and content to list of serialized TLVs
      attributesData.writeShort(tlv.getType());
      attributesData.writeShort(contentBytes.size());
      contentBytes.writeTo(attributesBytes);
    }

    outputStream.write(majorVersion);
    outputStream.write(minorVersion);
    outputStream.writeShort(pduType.value);
    outputStream.writeInt(MANDATORY_HEADER_LENGTH + attributesBytes.size());
    outputStream.writeInt(payload.length);
    outputStream.writeShort(payloadFormat.value);
    outputStream.writeShort(payloadDirection.value);
    outputStream.writeLong(xid.getMostSignificantBits());
    outputStream.writeLong(xid.getLeastSignificantBits());
    outputStream.write(correlationID);
    attributesBytes.writeTo(outputStream);
    outputStream.write(payload);
  }

  public Optional<Integer> findSequenceNumber() {
    for (final var tlv : conditionalAttributeFields) {
      if (tlv.getType() == 8) {
        final SequenceNumberTLV sequenceNumberTLV = (SequenceNumberTLV) tlv;
        return Optional.of(sequenceNumberTLV.sequenceNumber());
      }
    }
    return Optional.empty();
  }
}
