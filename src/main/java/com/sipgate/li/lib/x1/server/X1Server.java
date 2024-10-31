package com.sipgate.li.lib.x1.server;

import com.sipgate.li.lib.metrics.MetricsService;
import com.sipgate.li.lib.netty.NettyChildHandler;
import com.sipgate.li.lib.x1.protocol.Converter;
import com.sipgate.li.lib.x1.server.listener.DestinationListener;
import com.sipgate.li.lib.x1.server.listener.TaskListener;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import com.sipgate.li.lib.x1.server.repository.TaskRepository;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import javax.net.ssl.SSLContext;
import javax.xml.datatype.DatatypeFactory;

public class X1Server extends NettyChildHandler<X1Server> {

  private static final int MAX_CONTENT_LENGTH_BYTES = 1024 * 1024; // 1 MiB

  private final X1HttpServerHandler x1HttpServerHandler;

  /**
   * @param sslContext SSLContext or null to disable SSL
   * @param x1HttpServerHandler The handler to use for incoming HTTP requests
   */
  public X1Server(final SSLContext sslContext, final X1HttpServerHandler x1HttpServerHandler) {
    super(sslContext);
    this.x1HttpServerHandler = x1HttpServerHandler;
  }

  /**
   * Creates a new X1Server instance
   *
   * @param sslContext SSLContext or null to disable SSL
   * @param destinationRepository The repository to use for destination management
   * @param taskRepository The repository to use for task management
   * @return A new X1Server instance
   */
  public static X1Server create(
    final SSLContext sslContext,
    final DestinationRepository destinationRepository,
    final TaskRepository taskRepository
  ) {
    try {
      return new X1Server(
        sslContext,
        new X1HttpServerHandler(new Converter(), destinationRepository, taskRepository, DatatypeFactory.newInstance())
      );
    } catch (final Exception e) {
      throw new RuntimeException(e);
    }
  }

  public X1Server setTaskListener(final TaskListener taskListener) {
    x1HttpServerHandler.setTaskListener(taskListener);
    return this;
  }

  public X1Server setDestinationListener(final DestinationListener destinationListener) {
    x1HttpServerHandler.setDestinationListener(destinationListener);
    return this;
  }

  public X1Server setMetricsService(final MetricsService metricsService) {
    x1HttpServerHandler.setMetricsService(metricsService);
    return this;
  }

  @Override
  public void initChannel(final SocketChannel ch) {
    final var pipeline = ch.pipeline();
    getSslHandler().ifPresent(pipeline::addLast);
    pipeline
      .addLast(new HttpRequestDecoder())
      .addLast(new HttpResponseEncoder())
      .addLast(new HttpObjectAggregator(MAX_CONTENT_LENGTH_BYTES))
      .addLast(x1HttpServerHandler);
  }
}
