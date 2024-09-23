package com.sipgate.li.lib.x2x3;

import io.netty.buffer.ByteBuf;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class X2X3Decoder {

  private static Logger LOGGER = LoggerFactory.getLogger(X2X3Decoder.class);

  public static final int MANDATORY_HEADER_LENGTH = 40;

  /** usage pattern see {@link ByteToMessageDecoder} of netty. */
  public void decode(final ByteBuf in, final List<Object> out)
    throws Exception {
    LOGGER.debug("Decoding message: {}", in);
    if (in.readableBytes() < 12) { // version:2, pduType:2, headerLength:4, payloadLength:4 == 12
      LOGGER.debug("- too short");
      return;
    }
    in.skipBytes(4); // version:2, pduType:2
    final var headerLength = in.readUnsignedInt();
    final var payloadLength = in.readUnsignedInt();
    final var expectedLength = headerLength + payloadLength;
    in.resetReaderIndex();
    if (in.readableBytes() < expectedLength) {
      LOGGER.debug("- still too short");
      return;
    }
    final int condAttrLength = (int) (in.readableBytes() -
      payloadLength -
      MANDATORY_HEADER_LENGTH);
    final var pdu = makePduObject(
      in.readUnsignedByte(), // 1 major version
      in.readUnsignedByte(), // 2 minor version
      in.readUnsignedShort(), // 2 pduType
      in.readUnsignedInt(), // 4 headerLength
      in.readUnsignedInt(), // 4 payloadLength
      in.readUnsignedShort(), // 2 payloadFormat
      in.readUnsignedShort(), // 2 payloadDirection
      in.readLong(), // 8 xid high
      in.readLong(), // 8 xid low
      in.readBytes(8).array(), // 8 correlationID
      in.readBytes(condAttrLength).array(), // var conditionalAttributes
      in.readBytes((int) payloadLength).array() // var
    );
    out.add(pdu);
    LOGGER.debug("- decoded: {}", pdu);
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
