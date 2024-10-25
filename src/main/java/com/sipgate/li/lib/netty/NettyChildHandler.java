package com.sipgate.li.lib.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.OptionalSslHandler;
import io.netty.handler.ssl.SslHandler;
import java.net.InetSocketAddress;
import java.util.Optional;
import javax.net.ssl.SSLContext;

public abstract class NettyChildHandler<T extends NettyChildHandler<T>> extends ChannelInitializer<SocketChannel> {

  private final SSLContext sslContext;
  private final NettyServer nettyServer;

  protected NettyChildHandler(final SSLContext sslContext) {
    this.sslContext = sslContext;
    this.nettyServer = new NettyServer(this);
  }

  public T start(final InetSocketAddress bindAddress) {
    nettyServer.start(bindAddress);
    //noinspection unchecked - https://stackoverflow.com/a/69146546
    return (T) this;
  }

  public T stop() {
    nettyServer.stop();
    //noinspection unchecked - https://stackoverflow.com/a/69146546
    return (T) this;
  }

  protected Optional<SslHandler> getSslHandler() {
    if (sslContext == null) {
      return Optional.empty();
    }

    final var sslEngine = sslContext.createSSLEngine();
    sslEngine.setUseClientMode(false);
    sslEngine.setNeedClientAuth(true);
    return Optional.of(new SslHandler(sslEngine));
  }
}
