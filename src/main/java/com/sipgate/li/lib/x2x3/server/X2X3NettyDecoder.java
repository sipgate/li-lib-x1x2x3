package com.sipgate.li.lib.x2x3.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class X2X3NettyDecoder extends ByteToMessageDecoder {

  private static final Logger LOGGER = LoggerFactory.getLogger(X2X3NettyDecoder.class);

  private final X2X3Decoder x2x3Decoder;

  public X2X3NettyDecoder(final X2X3Decoder x2x3decoder) {
    this.x2x3Decoder = x2x3decoder;
  }

  @Override
  protected void decode(
    final ChannelHandlerContext channelHandlerContext,
    final ByteBuf byteBuf,
    final List<Object> out
  ) {
    LOGGER.debug("Child handler decoding message: {}", byteBuf);
    x2x3Decoder.decode(byteBuf).ifPresent(out::add);
  }

  @Override
  public void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause) {
    LOGGER.error("Invalid X2/X3 message received. Error: {}. Closing connection.", cause.getMessage());
    ctx.close();
  }
}
