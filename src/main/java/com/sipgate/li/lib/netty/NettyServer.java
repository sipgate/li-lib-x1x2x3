/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.net.InetSocketAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyServer {

  private static final Logger LOGGER = LoggerFactory.getLogger(NettyServer.class);

  private final ChannelInitializer<SocketChannel> childHandler;

  private EventLoopGroup bossGroup;
  private EventLoopGroup workerGroup;

  public NettyServer(final ChannelInitializer<SocketChannel> childHandler) {
    this.childHandler = childHandler;
  }

  public void start(final InetSocketAddress bindAddress) {
    if (bossGroup != null || workerGroup != null) {
      throw new IllegalStateException("Server already started");
    }

    bossGroup = new NioEventLoopGroup();
    workerGroup = new NioEventLoopGroup();

    final var serverBootstrap = new ServerBootstrap();
    serverBootstrap
      .group(bossGroup, workerGroup)
      .channel(NioServerSocketChannel.class)
      .childHandler(childHandler)
      .option(ChannelOption.SO_BACKLOG, 128) // max pending connections
      .childOption(ChannelOption.SO_KEEPALIVE, true);

    // Bind and start to accept incoming connections.
    LOGGER.info("Listening socket on port {}", bindAddress.getPort());
    serverBootstrap.bind(bindAddress).syncUninterruptibly();
  }

  public void stop() {
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
  }
}
