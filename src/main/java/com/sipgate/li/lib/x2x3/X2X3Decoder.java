package com.sipgate.li.lib.x2x3;

import static com.sipgate.li.lib.x2x3.PduObject.MANDATORY_HEADER_LENGTH;

import com.sipgate.li.lib.x2x3.tlv.GenericTLV;
import com.sipgate.li.lib.x2x3.tlv.TLV;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;
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

  /** usage pattern see {@link ByteToMessageDecoder} of netty. */
  public void decode(final ByteBuf in, final List<Object> out) throws Exception {
    LOGGER.debug("Decoding message: {}", in);
    if (in.readableBytes() < 12) { // version:2, pduType:2, headerLength:4, payloadLength:4 == 12
      LOGGER.trace("- too short");
      return;
    }
    in.skipBytes(4); // version:2, pduType:2
    final var headerLength = in.readUnsignedInt();
    final var payloadLength = in.readUnsignedInt();
    if (headerLength > maxHeaderLength) {
      throw new IllegalArgumentException("Header length exceeds maximum allowed length: " + headerLength);
    }
    if (payloadLength > maxPayloadLength) {
      throw new IllegalArgumentException("Payload length exceeds maximum allowed length: " + payloadLength);
    }

    final var expectedLength = headerLength + payloadLength;
    in.resetReaderIndex();
    if (in.readableBytes() < expectedLength) {
      LOGGER.trace("- still too short");
      return;
    }
    final int condAttrLength = (int) (in.readableBytes() - payloadLength - MANDATORY_HEADER_LENGTH);
    final var builder = new PduObjectBuilder()
      .majorVersion(in.readUnsignedByte()) // 1 major version
      .minorVersion(in.readUnsignedByte()); // 1 minor version

    final var pduType = PduType.fromValue(in.readUnsignedShort()); // 2 pduType
    in.skipBytes(8); // length of headerLength and payloadLength
    final var payloadFormat = PayloadFormat.fromValue(in.readUnsignedShort()); // 2 payloadFormat

    builder
      .pduTypeAndFormat(pduType, payloadFormat)
      .payloadDirection(PayloadDirection.fromValue(in.readUnsignedShort())) // 2 payloadDirection
      .xid(new UUID(in.readLong(), in.readLong())) // 8+8 xid
      .correlationID(getCopiedBytes(in, 8)) // 8 correlationID
      .conditionalAttributeFields(decodeTlv(in, condAttrLength)) // var conditionalAttributes
      .payload(getCopiedBytes(in, (int) payloadLength)); // var

    out.add(builder.build());
    LOGGER.trace("- decoded: {}", builder);
  }

  private static byte[] getCopiedBytes(final ByteBuf in, final int length) {
    final var buff = in.readBytes(length);
    // buff.array() does not work, because it is not a direct buffer ant thus throws an exception.
    final byte[] data = new byte[buff.readableBytes()];
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
