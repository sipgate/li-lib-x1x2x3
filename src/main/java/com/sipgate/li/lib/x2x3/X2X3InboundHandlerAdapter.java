package com.sipgate.li.lib.x2x3;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

@ChannelHandler.Sharable
public class X2X3InboundHandlerAdapter extends ChannelInboundHandlerAdapter {

  private static final Logger LOGGER = LoggerFactory.getLogger(X2X3InboundHandlerAdapter.class);

  private final Set<Consumer<PduObject>> consumers = new HashSet<>();

  @Override
  public void channelRead(final ChannelHandlerContext ctx, final Object msg) throws Exception {
    try {
      LOGGER.debug("Received message: {}", msg);
      if (!(msg instanceof final PduObject pduObject)) {
        throw new IllegalArgumentException("Received message is not an instance of X2X3PduObject");
      }

      consumers.forEach(consumer -> {
        try {
          consumer.accept(pduObject);
        } catch (final Exception e) {
          LOGGER.error("Error while calling X2/X3 consumer: {}. Ignoring...", e.getMessage());
        }
      });

    } finally {
      ReferenceCountUtil.release(msg);
    }
  }

  public void addConsumer(final Consumer<PduObject> consumer) {
    consumers.add(consumer);
  }

  public void removeConsumer(final Consumer<PduObject> consumer) {
    consumers.remove(consumer);
  }
}
