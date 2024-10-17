package com.sipgate.li.lib.x2x3.server;

import com.sipgate.li.lib.netty.NettyChildHandler;
import com.sipgate.li.lib.x2x3.protocol.PduObject;
import io.netty.channel.socket.SocketChannel;
import java.util.function.Consumer;
import javax.net.ssl.SSLContext;

public class X2X3Server extends NettyChildHandler<X2X3Server> {

  private final X2X3InboundHandlerAdapter x2x3inboundHandlerAdapter = new X2X3InboundHandlerAdapter();
  private final X2X3Decoder x2X3Decoder;

  public X2X3Server(final SSLContext sslContext, final X2X3Decoder x2X3Decoder) {
    super(sslContext);
    this.x2X3Decoder = x2X3Decoder;
  }

  public X2X3Server addConsumer(final Consumer<PduObject> consumer) {
    this.x2x3inboundHandlerAdapter.addConsumer(consumer);
    return this;
  }

  public X2X3Server removeConsumer(final Consumer<PduObject> consumer) {
    this.x2x3inboundHandlerAdapter.removeConsumer(consumer);
    return this;
  }

  @Override
  public void initChannel(final SocketChannel ch) {
    ch
      .pipeline()
      .addLast(getSslHandler())
      .addLast(new X2X3NettyDecoder(x2X3Decoder))
      .addLast(x2x3inboundHandlerAdapter);
  }
}
