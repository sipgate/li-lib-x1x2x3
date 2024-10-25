package com.sipgate.li.lib.x1.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.sipgate.li.lib.x1.protocol.Converter;
import com.sipgate.li.lib.x1.protocol.X1Version;
import com.sipgate.li.lib.x1.server.handler.X1RequestHandler;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import com.sipgate.li.lib.x1.server.repository.TaskRepository;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.etsi.uri._03221.x1._2017._10.PingResponse;
import org.etsi.uri._03221.x1._2017._10.RequestContainer;
import org.etsi.uri._03221.x1._2017._10.ResponseContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

@ExtendWith(MockitoExtension.class)
class X1HttpServerHandlerTest {

  private X1HttpServerHandler underTest;

  private Converter converter;

  @Mock
  private DeliveryTypeCompatibleValidator validator;

  @Mock
  private DestinationRepository destinationRepository;

  @Mock
  private TaskRepository taskRepository;

  @BeforeEach
  void setup() throws JAXBException, DatatypeConfigurationException {
    converter = new Converter();
    final var datatypeFactory = DatatypeFactory.newInstance();

    underTest = new X1HttpServerHandler(converter, validator, destinationRepository, taskRepository, datatypeFactory);
  }

  @Test
  void itReturnsOkAndWithTLER_onBadXml() throws Exception {
    // WHEN
    final var response = postBytes("this is not xml".getBytes(StandardCharsets.UTF_8));

    // THEN
    assertThat(response.status()).isEqualTo(HttpResponseStatus.OK);

    final var responseXml = response.content().toString(StandardCharsets.UTF_8);
    final var contentOrError = converter.parseResponse(responseXml);
    assertThat(contentOrError.isLeft()).isTrue();

    final var tler = contentOrError.left();
    assertThat(tler).isNotNull(); // TODO: fill this with more checks against content, eg IDs.
  }

  @Test
  void itReturnsOkAndWithTLER_onEmptyRequest() throws Exception {
    // GIVEN

    // WHEN
    final var response = postFile("X1HttpServerHandlerTest/EmptyRequest_example.xml");

    // THEN
    assertThat(response.status()).isEqualTo(HttpResponseStatus.OK);

    final var responseXml = response.content().toString(StandardCharsets.UTF_8);
    final var contentOrError = converter.parseResponse(responseXml);
    assertThat(contentOrError.isLeft()).isTrue();

    final var tler = contentOrError.left();
    assertThat(tler).isNotNull(); // TODO: fill this with more checks against content, eg IDs.
  }

  @Test
  void itReturnsOkAndWithTLER_onBadVersionRequest() throws Exception {
    // GIVEN

    // WHEN
    final var response = postFile("X1HttpServerHandlerTest/BadVersionRequest_example.xml");

    // THEN
    assertThat(response.status()).isEqualTo(HttpResponseStatus.OK);

    final var responseXml = response.content().toString(StandardCharsets.UTF_8);
    final var contentOrError = converter.parseResponse(responseXml);
    assertThat(contentOrError.isLeft()).isTrue();

    final var tler = contentOrError.left();
    assertThat(tler).isNotNull(); // TODO: fill this with more checks against content, eg IDs.
  }

  @Test
  void itCallsPingHandler() throws Exception {
    // GIVEN

    // WHEN
    final var response = postFile("PingRequest_example.xml");

    // THEN
    assertThat(response.status()).isEqualTo(HttpResponseStatus.OK);

    final var responseXml = response.content().toString(StandardCharsets.UTF_8);
    final var contentOrError = converter.parseResponse(responseXml);
    assertThat(contentOrError.isRight()).isTrue();

    final var actualContainer = contentOrError.right();
    assertThat(actualContainer.getX1ResponseMessage()).hasSize(1);
    final var first = (PingResponse) actualContainer.getX1ResponseMessage().getFirst();
    assertThat(first.getOK()).isEqualTo(OK.ACKNOWLEDGED_AND_COMPLETED);
  }

  @Test
  void itCallsPingHandlerTwiceOnMultiRequest() throws Exception {
    // GIVEN

    // WHEN
    final var response = postFile("MultiRequest_example.xml");

    // THEN
    assertThat(response.status()).isEqualTo(HttpResponseStatus.OK);

    final var responseXml = response.content().toString(StandardCharsets.UTF_8);
    final var contentOrError = converter.parseResponse(responseXml);
    assertThat(contentOrError.isRight()).isTrue();

    final var actualContainer = contentOrError.right();
    assertThat(actualContainer.getX1ResponseMessage()).hasSize(2);
    final var first = (PingResponse) actualContainer.getX1ResponseMessage().getFirst();
    assertThat(first.getOK()).isEqualTo(OK.ACKNOWLEDGED_AND_COMPLETED);

    final var second = (PingResponse) actualContainer.getX1ResponseMessage().get(1);
    assertThat(second.getOK()).isEqualTo(OK.ACKNOWLEDGED_AND_COMPLETED);
  }

  @ParameterizedTest
  @MethodSource("provideHandler")
  void it_knows_all_handlers(final X1RequestHandler<?, ?> handler) throws IllegalAccessException, NoSuchFieldException {
    // GIVEN
    final var requestMessageType = handler.getRequestClass();

    // WHEN X1HttpServerHandler is constructed

    // THEN it knows the handler
    final var field = underTest.getClass().getDeclaredField("handlers");
    field.setAccessible(true);
    final var handlers = (Map<?, ?>) field.get(underTest);
    assertThat(handlers.get(requestMessageType)).isInstanceOf(handler.getClass());
  }

  @ParameterizedTest
  @MethodSource("provideHandler")
  void it_has_a_case_for_every_implemented_handler(final X1RequestHandler<?, ?> handler)
    throws JAXBException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
    // GIVEN: a request container with a single request
    final var requestMessageType = handler.getRequestClass();
    final var requestMessage = mock(requestMessageType);
    when(requestMessage.getVersion()).thenReturn(X1Version.VERSION);

    final var requestContainer = new RequestContainer();
    requestContainer.getX1RequestMessage().add(requestMessage);

    // GIVEN: XML can be parsed
    final var requestBody = "request-body";
    final var converter = mock(Converter.class);
    when(converter.parseRequest(requestBody)).thenReturn(requestContainer);

    // GIVEN: handling is successful
    final var responseMessageType = getResponseMessageType(handler);
    doAnswer(ignored -> mock(responseMessageType)).when(handler).handle(any());

    // GIVEN: XML can be serialized
    final var responseBody = "response-body";
    when(converter.toXml(any(ResponseContainer.class))).thenReturn(responseBody);

    // GIVEN: X1HttpServerHandler with mocked handlers
    setField(underTest, "converter", converter);
    setField(underTest, "handlers", Map.of(requestMessageType, handler));

    // WHEN
    final var response = postBytes(requestBody.getBytes(StandardCharsets.UTF_8));

    // THEN
    assertThat(response.status()).isEqualTo(HttpResponseStatus.OK);
    assertThat(response.content().toString(StandardCharsets.UTF_8)).isEqualTo(responseBody);
  }

  private static void setField(final Object object, final String fieldName, final Object value)
    throws NoSuchFieldException, IllegalAccessException {
    final var field = object.getClass().getDeclaredField(fieldName);
    field.setAccessible(true);
    field.set(object, value);
  }

  private static Stream<Arguments> provideHandler() {
    // GIVEN: all implemented handlers
    final var reflections = new Reflections(
      "com.sipgate.li.lib.x1.server.handler",
      Scanners.SubTypes.filterResultsBy(ignored -> true)
    );
    final var subTypes = reflections.getSubTypesOf(X1RequestHandler.class);
    final List<Arguments> handlers = new ArrayList<>();
    subTypes.forEach(subType -> {
      final var m = Mockito.mock(subType);
      when(m.getRequestClass()).thenCallRealMethod();
      handlers.add(Arguments.of(m));
    });

    return handlers.stream();
  }

  private static Class<?> getResponseMessageType(final X1RequestHandler<?, ?> handler) throws NoSuchMethodException {
    final var handlerType = handler.getClass();
    final var requestMessageType = handler.getRequestClass();
    return handlerType.getMethod("handle", requestMessageType).getReturnType();
  }

  private FullHttpResponse postFile(final String file) throws IOException {
    try (final var requestInputStream = this.getClass().getClassLoader().getResourceAsStream(file)) {
      if (requestInputStream == null) {
        throw new IOException("resource not found: " + file);
      }

      return postBytes(requestInputStream.readAllBytes());
    }
  }

  private FullHttpResponse postBytes(final byte[] requestBytes) {
    final var embeddedChannel = new EmbeddedChannel(underTest);
    final var fullHttpRequest = new DefaultFullHttpRequest(
      HttpVersion.HTTP_1_1,
      HttpMethod.POST,
      "/X1/NE",
      Unpooled.wrappedBuffer(requestBytes)
    );

    embeddedChannel.writeInbound(fullHttpRequest);
    return embeddedChannel.readOutbound();
  }
}
