package com.sipgate.li.lib.x2x3;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.ssl.SslHandler;
import java.net.InetSocketAddress;
import java.util.function.Consumer;
import javax.net.ssl.SSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class X2X3Server {

  private static final Logger LOGGER = LoggerFactory.getLogger(X2X3Server.class);

  private final X2X3InboundHandlerAdapter x2x3inboundHandlerAdapter = new X2X3InboundHandlerAdapter();
  private final SSLContext sslContext;
  private final X2X3Decoder x2X3Decoder;

  private EventLoopGroup bossGroup;
  private EventLoopGroup workerGroup;

  public X2X3Server(final X2X3Decoder x2X3Decoder, final SSLContext simulatorSslContext) {
    this.sslContext = simulatorSslContext;
    this.x2X3Decoder = x2X3Decoder;
  }

  public X2X3Server start(final InetSocketAddress bindAddress) {
    if (bossGroup != null || workerGroup != null) {
      throw new IllegalStateException("Server already started");
    }

    bossGroup = new NioEventLoopGroup();
    workerGroup = new NioEventLoopGroup();

    final var serverBootstrap = new ServerBootstrap();
    serverBootstrap
      .group(bossGroup, workerGroup)
      .channel(NioServerSocketChannel.class)
      .childHandler(
        new ChannelInitializer<SocketChannel>() {
          @Override
          public void initChannel(final SocketChannel ch) {
            ch
              .pipeline()
              .addLast(getSslHandler())
              .addLast(new X2X3NettyDecoder(x2X3Decoder))
              .addLast(x2x3inboundHandlerAdapter);
          }
        }
      )
      .option(ChannelOption.SO_BACKLOG, 128) // max pending connections
      .childOption(ChannelOption.SO_KEEPALIVE, true);

    // Bind and start to accept incoming connections.
    LOGGER.info("Listening socket on port {}", bindAddress.getPort());
    serverBootstrap.bind(bindAddress).syncUninterruptibly();
    return this;
  }

  public X2X3Server stop() {
    LOGGER.debug("Stopping server...");
    if (workerGroup != null) {
      workerGroup.shutdownGracefully().syncUninterruptibly();
      workerGroup = null;
    }

    if (bossGroup != null) {
      bossGroup.shutdownGracefully().syncUninterruptibly();
      bossGroup = null;
    }

    LOGGER.debug("Stopped...");
    return this;
  }

  public X2X3Server addConsumer(final Consumer<PduObject> consumer) {
    this.x2x3inboundHandlerAdapter.addConsumer(consumer);
    return this;
  }

  public X2X3Server removeConsumer(final Consumer<PduObject> consumer) {
    this.x2x3inboundHandlerAdapter.removeConsumer(consumer);
    return this;
  }

  private SslHandler getSslHandler() {
    final var sslEngine = sslContext.createSSLEngine();
    sslEngine.setUseClientMode(false);
    sslEngine.setNeedClientAuth(true);
    return new SslHandler(sslEngine);
  }
}
