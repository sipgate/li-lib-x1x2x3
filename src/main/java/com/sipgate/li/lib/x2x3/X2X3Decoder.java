package com.sipgate.li.lib.x2x3;

import static com.sipgate.li.lib.x2x3.PduObject.MANDATORY_HEADER_LENGTH;

import io.netty.buffer.ByteBuf;
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
      LOGGER.debug("- too short");
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
      LOGGER.debug("- still too short");
      return;
    }
    final int condAttrLength = (int) (in.readableBytes() - payloadLength - MANDATORY_HEADER_LENGTH);
    final var pdu = makePduObject(
      in.readUnsignedByte(), // 1 major version
      in.readUnsignedByte(), // 1 minor version
      in.readUnsignedShort(), // 2 pduType
      in.readUnsignedInt(), // 4 headerLength
      in.readUnsignedInt(), // 4 payloadLength
      in.readUnsignedShort(), // 2 payloadFormat
      in.readUnsignedShort(), // 2 payloadDirection
      in.readLong(), // 8 xid high
      in.readLong(), // 8 xid low
      getCopiedBytes(in, 8), // 8 correlationID
      getCopiedBytes(in, condAttrLength), // var conditionalAttributes
      getCopiedBytes(in, (int) payloadLength) // var
    );
    out.add(pdu);
    LOGGER.debug("- decoded: {}", pdu);
  }

  private static byte[] getCopiedBytes(final ByteBuf in, final int length) {
    final var buff = in.readBytes(length);
    // buff.array() does not work, because it is not a direct buffer ant thus throws an exception.
    final byte[] data = new byte[buff.readableBytes()];
    buff.readBytes(data);
    return data;
  }

  private PduObject makePduObject(
    final short majorVersion,
    final short minorVersion,
    final int pduType,
    final long headerLength,
    final long payloadLength,
    final int payloadFormat,
    final int payloadDirection,
    final long xidHigh,
    final long xidLow,
    final byte[] corrId,
    final byte[] condAttrs,
    final byte[] payload
  ) {
    return new PduObject(
      majorVersion,
      minorVersion,
      PduType.fromValue(pduType),
      (int) headerLength,
      (int) payloadLength,
      PayloadFormat.fromValue(payloadFormat),
      PayloadDirection.fromValue(payloadDirection),
      new UUID(xidHigh, xidLow),
      corrId,
      condAttrs,
      payload
    );
  }
}
