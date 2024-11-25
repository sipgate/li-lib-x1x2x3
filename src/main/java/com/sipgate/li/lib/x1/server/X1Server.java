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

  private final X1NetworkElementHandler x1NetworkElementHandler;

  /**
   * @param sslContext SSLContext or null to disable SSL
   * @param x1NetworkElementHandler The handler to use for incoming HTTP requests
   */
  public X1Server(final SSLContext sslContext, final X1NetworkElementHandler x1NetworkElementHandler) {
    super(sslContext);
    this.x1NetworkElementHandler = x1NetworkElementHandler;
  }

  /**
   * Creates a new X1Server instance
   *
   * @param sslContext            SSLContext or null to disable SSL
   * @param destinationRepository The repository to use for destination management
   * @param taskRepository        The repository to use for task management
   * @param neIdentifier          The name of this network element for X1
   * @return A new X1Server instance
   */
  public static X1Server createNetworkElement(
    final SSLContext sslContext,
    final DestinationRepository destinationRepository,
    final TaskRepository taskRepository,
    final String neIdentifier
  ) {
    try {
      return new X1Server(
        sslContext,
        new X1NetworkElementHandler(
          new Converter(),
          destinationRepository,
          taskRepository,
          DatatypeFactory.newInstance(),
          neIdentifier
        )
      );
    } catch (final Exception e) {
      throw new RuntimeException(e);
    }
  }

  public X1Server setTaskListener(final TaskListener taskListener) {
    x1NetworkElementHandler.setTaskListener(taskListener);
    return this;
  }

  public X1Server setDestinationListener(final DestinationListener destinationListener) {
    x1NetworkElementHandler.setDestinationListener(destinationListener);
    return this;
  }

  public X1Server setMetricsService(final MetricsService metricsService) {
    x1NetworkElementHandler.setMetricsService(metricsService);
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
      .addLast(x1NetworkElementHandler);
  }
}
