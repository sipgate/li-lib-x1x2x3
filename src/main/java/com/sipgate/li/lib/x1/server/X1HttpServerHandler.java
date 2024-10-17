package com.sipgate.li.lib.x1.server;

import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import com.sipgate.li.lib.metrics.MetricsService;
import com.sipgate.li.lib.metrics.NoopMetricsService;
import com.sipgate.li.lib.x1.protocol.Converter;
import com.sipgate.li.lib.x1.protocol.X1Version;
import com.sipgate.li.lib.x1.server.handler.X1RequestHandler;
import com.sipgate.li.lib.x1.server.handler.destination.CreateDestinationHandler;
import com.sipgate.li.lib.x1.server.handler.destination.GetDestinationDetailsHandler;
import com.sipgate.li.lib.x1.server.handler.destination.ModifyDestinationHandler;
import com.sipgate.li.lib.x1.server.handler.destination.RemoveDestinationHandler;
import com.sipgate.li.lib.x1.server.handler.status.GetAllDetailsHandler;
import com.sipgate.li.lib.x1.server.handler.status.KeepaliveHandler;
import com.sipgate.li.lib.x1.server.handler.status.ListAllDetailsHandler;
import com.sipgate.li.lib.x1.server.handler.status.PingHandler;
import com.sipgate.li.lib.x1.server.handler.task.ActivateTaskHandler;
import com.sipgate.li.lib.x1.server.handler.task.DeactivateTaskHandler;
import com.sipgate.li.lib.x1.server.handler.task.GetTaskDetailsHandler;
import com.sipgate.li.lib.x1.server.handler.task.ModifyTaskHandler;
import com.sipgate.li.lib.x1.server.listener.DelegatingDestinationListener;
import com.sipgate.li.lib.x1.server.listener.DelegatingTaskListener;
import com.sipgate.li.lib.x1.server.listener.DestinationListener;
import com.sipgate.li.lib.x1.server.listener.TaskListener;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import com.sipgate.li.lib.x1.server.repository.TaskRepository;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import jakarta.xml.bind.JAXBException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Supplier;
import javax.xml.datatype.DatatypeFactory;
import org.etsi.uri._03221.x1._2017._10.ActivateTaskRequest;
import org.etsi.uri._03221.x1._2017._10.CreateDestinationRequest;
import org.etsi.uri._03221.x1._2017._10.DeactivateTaskRequest;
import org.etsi.uri._03221.x1._2017._10.GetAllDetailsRequest;
import org.etsi.uri._03221.x1._2017._10.GetDestinationDetailsRequest;
import org.etsi.uri._03221.x1._2017._10.GetTaskDetailsRequest;
import org.etsi.uri._03221.x1._2017._10.KeepaliveRequest;
import org.etsi.uri._03221.x1._2017._10.ListAllDetailsRequest;
import org.etsi.uri._03221.x1._2017._10.ModifyDestinationRequest;
import org.etsi.uri._03221.x1._2017._10.ModifyTaskRequest;
import org.etsi.uri._03221.x1._2017._10.PingRequest;
import org.etsi.uri._03221.x1._2017._10.RemoveDestinationRequest;
import org.etsi.uri._03221.x1._2017._10.RequestContainer;
import org.etsi.uri._03221.x1._2017._10.ResponseContainer;
import org.etsi.uri._03221.x1._2017._10.TopLevelErrorResponse;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;
import org.etsi.uri._03221.x1._2017._10.X1ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ChannelHandler.Sharable
public class X1HttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

  private static final Logger LOGGER = LoggerFactory.getLogger(X1HttpServerHandler.class);

  private final Map<Class<? extends X1RequestMessage>, X1RequestHandler<?, ?>> handlers = new HashMap<>();

  private final Converter converter;
  private final DatatypeFactory datatypeFactory;
  private final DelegatingTaskListener delegatingTaskListener = new DelegatingTaskListener();
  private final DelegatingDestinationListener delegatingDestinationListener = new DelegatingDestinationListener();

  private MetricsService metricsService = new NoopMetricsService();

  public X1HttpServerHandler(
    final Converter converter,
    final DeliveryTypeCompatibleValidator validator,
    final DestinationRepository destinationRepository,
    final TaskRepository taskRepository,
    final DatatypeFactory datatypeFactory
  ) {
    this.converter = converter;
    this.datatypeFactory = datatypeFactory;

    this.handlers.put(PingRequest.class, new PingHandler());
    this.handlers.put(KeepaliveRequest.class, new KeepaliveHandler());
    this.handlers.put(
        ActivateTaskRequest.class,
        new ActivateTaskHandler(taskRepository, validator, delegatingTaskListener)
      );
    this.handlers.put(DeactivateTaskRequest.class, new DeactivateTaskHandler(taskRepository, delegatingTaskListener));
    this.handlers.put(ListAllDetailsRequest.class, new ListAllDetailsHandler(taskRepository, destinationRepository));
    this.handlers.put(
        ModifyTaskRequest.class,
        new ModifyTaskHandler(taskRepository, validator, delegatingTaskListener)
      );
    this.handlers.put(GetTaskDetailsRequest.class, new GetTaskDetailsHandler(taskRepository));
    this.handlers.put(
        CreateDestinationRequest.class,
        new CreateDestinationHandler(destinationRepository, delegatingDestinationListener)
      );
    this.handlers.put(GetDestinationDetailsRequest.class, new GetDestinationDetailsHandler(destinationRepository));
    this.handlers.put(
        ModifyDestinationRequest.class,
        new ModifyDestinationHandler(destinationRepository, delegatingDestinationListener)
      );
    this.handlers.put(
        RemoveDestinationRequest.class,
        new RemoveDestinationHandler(destinationRepository, delegatingDestinationListener)
      );
    this.handlers.put(GetAllDetailsRequest.class, new GetAllDetailsHandler(taskRepository, destinationRepository));
  }

  public X1HttpServerHandler setTaskListener(final TaskListener delegatingTaskListener) {
    this.delegatingTaskListener.setDelegate(delegatingTaskListener);
    return this;
  }

  public X1HttpServerHandler setDestinationListener(final DestinationListener delegatingDestinationListener) {
    this.delegatingDestinationListener.setDelegate(delegatingDestinationListener);
    return this;
  }

  public X1HttpServerHandler setMetricsService(final MetricsService metricsService) {
    this.metricsService = metricsService;
    return this;
  }

  @Override
  protected void channelRead0(final ChannelHandlerContext channelHandlerContext, final FullHttpRequest fullHttpRequest)
    throws Exception {
    final var response = handleHttpRequest(fullHttpRequest);

    response.headers().setInt(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());

    final var keepAlive = HttpUtil.isKeepAlive(fullHttpRequest);
    if (keepAlive) {
      HttpUtil.setKeepAlive(response, true);
      channelHandlerContext.writeAndFlush(response);
      return;
    }

    channelHandlerContext.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
  }

  @Override
  public void exceptionCaught(final ChannelHandlerContext channelHandlerContext, final Throwable throwable)
    throws Exception {
    metricsService.incrementCounter("li_x1_exception", "type", throwable.getClass().getSimpleName());
    LOGGER.error("Caught exception, responding with TopLevelErrorResponse.", throwable);

    // channel could already be closed because of SSL exceptions
    if (!channelHandlerContext.channel().isWritable()) {
      return;
    }

    final var tler = new TopLevelErrorResponse();

    // TODO
    // If the X1 Request could not be parsed
    // then the response shall be constructed with an ADMF and NE Identifier
    // (extracting the identifier of the Requester from the X.509 certificate if necessary)

    tler.setAdmfIdentifier("todo");
    tler.setNeIdentifier("todo");
    // TODO
    final var calendar = new GregorianCalendar();
    calendar.setTimeInMillis(Instant.now().toEpochMilli());
    tler.setMessageTimestamp(datatypeFactory.newXMLGregorianCalendar(calendar));
    tler.setVersion(X1Version.VERSION);

    final var xml = converter.toXml(tler);
    final var response = new DefaultFullHttpResponse(
      HTTP_1_1,
      HttpResponseStatus.OK,
      Unpooled.wrappedBuffer(xml.getBytes(StandardCharsets.UTF_8))
    );

    HttpUtil.setContentLength(response, response.content().readableBytes());

    // Don't handle keep alive here because there was an error and we can't recover from it.
    channelHandlerContext.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
  }

  private FullHttpResponse handleHttpRequest(final FullHttpRequest fullHttpRequest) throws JAXBException {
    final var httpVersion = fullHttpRequest.protocolVersion();
    if (httpVersion.majorVersion() > 1) {
      // ETSI TS 103 221-1 V1.18.1 (2024-07), section 7.2.2.3 Profile
      // > HTTP version 1.1 or HTTP/2 shall be used.
      // But at the time of writing we didn't want to implement HTTP2.
      LOGGER.warn("invalid HTTP version {}", httpVersion);
      return new DefaultFullHttpResponse(HTTP_1_1, HttpResponseStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    if (!fullHttpRequest.uri().equals("/X1/NE")) {
      LOGGER.debug("invalid URI {}", fullHttpRequest.uri());
      return new DefaultFullHttpResponse(HTTP_1_1, HttpResponseStatus.NOT_FOUND, Unpooled.EMPTY_BUFFER);
    }

    if (!fullHttpRequest.method().equals(HttpMethod.POST)) {
      LOGGER.warn("invalid method {}", fullHttpRequest.method());
      return new DefaultFullHttpResponse(HTTP_1_1, HttpResponseStatus.METHOD_NOT_ALLOWED, Unpooled.EMPTY_BUFFER);
    }

    final var charset = HttpUtil.getCharset(fullHttpRequest);
    return handlePost(fullHttpRequest.content().toString(charset));
  }

  public FullHttpResponse handlePost(final String requestXml) throws JAXBException {
    final var request = converter.parseRequest(requestXml);
    final var responseContainer = handleRequestContainer(request);
    final var responseXml = converter.toXml(responseContainer);

    final var response = new DefaultFullHttpResponse(
      HTTP_1_1,
      HttpResponseStatus.OK,
      Unpooled.wrappedBuffer(responseXml.getBytes(StandardCharsets.UTF_8))
    );

    response.headers().set(HttpHeaderNames.CONTENT_TYPE, "application/xml; charset=UTF-8");
    return response;
  }

  final ResponseContainer handleRequestContainer(final RequestContainer requestContainer) {
    final var requestMessages = requestContainer.getX1RequestMessage();
    if (requestMessages.isEmpty()) {
      throw new IllegalArgumentException("request container must have at least 1 request message");
    }

    final List<X1Job> jobs = new ArrayList<>();
    for (final var requestMessage : requestMessages) {
      final var requestMessageClassName = requestMessage.getClass().getSimpleName();
      metricsService.incrementCounter(
        "li_x1_requestMessage",
        "type",
        requestMessageClassName,
        "version",
        Objects.requireNonNullElse(requestMessage.getVersion(), "null")
      );

      if (!X1Version.isCompatible(requestMessage.getVersion())) {
        throw new IllegalArgumentException("version mismatch, got " + requestMessage.getVersion());
      }

      final Supplier<X1ResponseMessage> handler =
        switch (requestMessage) {
          case final PingRequest r -> () -> handle(PingHandler.class, r);
          case final KeepaliveRequest r -> () -> handle(KeepaliveHandler.class, r);
          case final ActivateTaskRequest r -> () -> handle(ActivateTaskHandler.class, r);
          case final DeactivateTaskRequest r -> () -> handle(DeactivateTaskHandler.class, r);
          case final ListAllDetailsRequest r -> () -> handle(ListAllDetailsHandler.class, r);
          case final ModifyTaskRequest r -> () -> handle(ModifyTaskHandler.class, r);
          case final GetTaskDetailsRequest r -> () -> handle(GetTaskDetailsHandler.class, r);
          case final CreateDestinationRequest r -> () -> handle(CreateDestinationHandler.class, r);
          case final GetDestinationDetailsRequest r -> () -> handle(GetDestinationDetailsHandler.class, r);
          case final ModifyDestinationRequest r -> () -> handle(ModifyDestinationHandler.class, r);
          case final RemoveDestinationRequest r -> () -> handle(RemoveDestinationHandler.class, r);
          case final GetAllDetailsRequest r -> () -> handle(GetAllDetailsHandler.class, r);
          default -> {
            // If any of the x1RequestMessages are not matching, we will not execute any of the
            // requests in the container, but respond with a top level error.
            metricsService.incrementCounter("li_x1_requestError", "type", "unknown_message_type");
            throw new NoSuchElementException("no handler known for " + requestMessageClassName);
          }
        };

      jobs.add(new X1Job(requestMessage, handler));
    }

    final var responseContainer = new ResponseContainer();
    jobs.stream().map(X1Job::act).forEach(response -> responseContainer.getX1ResponseMessage().add(response));
    return responseContainer;
  }

  private <REQ extends X1RequestMessage> X1ResponseMessage handle(
    final Class<? extends X1RequestHandler<REQ, ? extends X1ResponseMessage>> handlerClass,
    final REQ requestMessage
  ) {
    final var handler = handlerClass.cast(handlers.get(requestMessage.getClass()));
    return handler.handle(requestMessage);
  }
}
