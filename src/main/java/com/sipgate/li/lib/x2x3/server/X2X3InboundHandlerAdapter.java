/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x2x3.server;

import com.sipgate.li.lib.x2x3.protocol.PduObject;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ChannelHandler.Sharable
public class X2X3InboundHandlerAdapter extends SimpleChannelInboundHandler<PduObject> {

  private static final Logger LOGGER = LoggerFactory.getLogger(X2X3InboundHandlerAdapter.class);

  private final Set<Consumer<PduObject>> consumers = new HashSet<>();

  @Override
  public void channelRead0(final ChannelHandlerContext ctx, final PduObject pduObject) {
    LOGGER.debug("Received message: {}", pduObject);
    consumers.forEach(consumer -> consumer.accept(pduObject));
  }

  @Override
  public void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause) {
    LOGGER.error("Exception while processing PDU: {}. Closing connection.", cause.getMessage());
    ctx.close();
  }

  public void addConsumer(final Consumer<PduObject> consumer) {
    consumers.add(consumer);
  }

  public void removeConsumer(final Consumer<PduObject> consumer) {
    consumers.remove(consumer);
  }
}
