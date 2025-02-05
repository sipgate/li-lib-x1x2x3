/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x2x3.server;

import static com.sipgate.li.lib.x2x3.protocol.PduObject.MANDATORY_HEADER_LENGTH;

import com.sipgate.li.lib.x2x3.protocol.PayloadDirection;
import com.sipgate.li.lib.x2x3.protocol.PayloadFormat;
import com.sipgate.li.lib.x2x3.protocol.PduObject;
import com.sipgate.li.lib.x2x3.protocol.PduObjectBuilder;
import com.sipgate.li.lib.x2x3.protocol.PduType;
import com.sipgate.li.lib.x2x3.protocol.tlv.GenericTLV;
import com.sipgate.li.lib.x2x3.protocol.tlv.TLV;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class X2X3Decoder {

  private static final Logger LOGGER = LoggerFactory.getLogger(X2X3Decoder.class);

  private final int maxHeaderLength;
  private final int maxPayloadLength;

  public X2X3Decoder(final int maxHeaderLength, final int maxPayloadLength) {
    this.maxHeaderLength = maxHeaderLength;
    this.maxPayloadLength = maxPayloadLength;
  }

  public Optional<PduObject> decode(final ByteBuf in) {
    LOGGER.debug("Decoding message:{}", in);
    if (in.readableBytes() < 12) { // version:2, pduType:2, headerLength:4, payloadLength:4 == 12
      LOGGER.trace("- too short");
      return Optional.empty();
    }

    in.markReaderIndex();
    final var headerVersion = in.readUnsignedShort();
    final var headerPduType = in.readUnsignedShort();
    LOGGER.trace("- reading from header version: {}, pduType: {}", headerVersion, headerPduType);
    final var headerLength = in.readUnsignedInt();
    final var payloadLength = in.readUnsignedInt();
    in.resetReaderIndex();
    if (headerLength > maxHeaderLength) {
      throw new IllegalArgumentException("Header length exceeds maximum allowed length: " + headerLength);
    }
    if (payloadLength > maxPayloadLength) {
      throw new IllegalArgumentException("Payload length exceeds maximum allowed length: " + payloadLength);
    }

    final var expectedLength = headerLength + payloadLength;
    if (in.readableBytes() < expectedLength) {
      LOGGER.trace("- still too short");
      return Optional.empty();
    }

    final var condAttrLength = (int) (headerLength - MANDATORY_HEADER_LENGTH);

    final var builder = new PduObjectBuilder()
      .majorVersion(in.readUnsignedByte()) // 1 major version
      .minorVersion(in.readUnsignedByte()); // 1 minor version

    final var pduType = PduType.fromValue(in.readUnsignedShort()); // 2 pduType
    in.skipBytes(8); // length of headerLength and payloadLength
    final var payloadFormat = PayloadFormat.fromValue(in.readUnsignedShort()); // 2 payloadFormat

    LOGGER.trace("- inside header byteBuf:{}", in);
    builder
      .pduTypeAndFormat(pduType, payloadFormat)
      .payloadDirection(PayloadDirection.fromValue(in.readUnsignedShort())) // 2 payloadDirection
      .xid(new UUID(in.readLong(), in.readLong())) // 8+8 xid
      .correlationID(getCopiedBytes(in, 8)) // 8 correlationID
      .conditionalAttributeFields(decodeTlv(in, condAttrLength)) // var conditionalAttributes
      .payload(getCopiedBytes(in, (int) payloadLength)); // var

    final var pdu = builder.build();
    LOGGER.trace("- decoded:{}, byteBuf:{}", pdu, in);
    return Optional.of(pdu);
  }

  private static byte[] getCopiedBytes(final ByteBuf in, final int length) {
    final var buff = in.readBytes(length);
    // buff.array() does not work, because it is not a direct buffer ant thus throws an exception.
    final var data = new byte[buff.readableBytes()];
    buff.readBytes(data);
    return data;
  }

  private static List<TLV> decodeTlv(final ByteBuf in, int length) {
    final var tlvList = new ArrayList<TLV>();
    while (length > 0) {
      final var type = in.readUnsignedShort();
      final var contentLength = in.readUnsignedShort();

      final var content = getCopiedBytes(in, contentLength);
      tlvList.add(new GenericTLV(type, content));
      length -= 4 + contentLength; // 2 bytes for type + 2 bytes for contentLength
    }
    return tlvList;
  }
}
