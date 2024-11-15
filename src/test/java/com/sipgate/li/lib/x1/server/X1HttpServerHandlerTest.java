package com.sipgate.li.lib.x1.server;

import static com.sipgate.li.lib.x1.protocol.X1Version.VERSION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.sipgate.li.lib.x1.protocol.Converter;
import com.sipgate.li.lib.x1.protocol.error.X1ErrorException;
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
import java.time.Instant;
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
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;
import org.etsi.uri._03221.x1._2017._10.X1ResponseMessage;
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
  private DestinationRepository destinationRepository;

  @Mock
  private TaskRepository taskRepository;

  @BeforeEach
  void setup() throws JAXBException, DatatypeConfigurationException {
    converter = new Converter();
    final var datatypeFactory = DatatypeFactory.newInstance();

    underTest = new X1HttpServerHandler(converter, destinationRepository, taskRepository, datatypeFactory);
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
    final var requestXml = loadRequestFromFile("PingRequest_example.xml");
    final var request = converter.parseRequest(requestXml);
    final var startTimeInMillis = Instant.now().toEpochMilli();

    // WHEN
    final var response = postBytes(requestXml.getBytes(StandardCharsets.UTF_8));

    // THEN
    assertThat(response.status()).isEqualTo(HttpResponseStatus.OK);

    final var responseXml = response.content().toString(StandardCharsets.UTF_8);
    final var contentOrError = converter.parseResponse(responseXml);
    assertThat(contentOrError.isRight()).isTrue();

    final var responseContainer = contentOrError.right();
    assertThat(responseContainer.getX1ResponseMessage()).hasSize(1);
    final var responseMessage = (PingResponse) responseContainer.getX1ResponseMessage().getFirst();
    assertThat(responseMessage.getOK()).isEqualTo(OK.ACKNOWLEDGED_AND_COMPLETED);

    assertCommonFields(request.getX1RequestMessage().getFirst(), responseMessage, startTimeInMillis);
  }

  @Test
  void itCallsPingHandlerTwiceOnMultiRequest() throws Exception {
    // GIVEN
    final var requestXml = loadRequestFromFile("MultiRequest_example.xml");
    final var request = converter.parseRequest(requestXml);
    final var startTimeInMillis = Instant.now().toEpochMilli();

    // WHEN
    final var response = postBytes(requestXml.getBytes(StandardCharsets.UTF_8));

    // THEN
    assertThat(response.status()).isEqualTo(HttpResponseStatus.OK);

    final var responseXml = response.content().toString(StandardCharsets.UTF_8);
    final var contentOrError = converter.parseResponse(responseXml);
    assertThat(contentOrError.isRight()).isTrue();

    final var actualContainer = contentOrError.right();
    assertThat(actualContainer.getX1ResponseMessage()).hasSize(2);
    final var first = (PingResponse) actualContainer.getX1ResponseMessage().getFirst();
    assertThat(first.getOK()).isEqualTo(OK.ACKNOWLEDGED_AND_COMPLETED);
    assertCommonFields(request.getX1RequestMessage().getFirst(), first, startTimeInMillis);

    final var second = (PingResponse) actualContainer.getX1ResponseMessage().get(1);
    assertThat(second.getOK()).isEqualTo(OK.ACKNOWLEDGED_AND_COMPLETED);
    assertCommonFields(request.getX1RequestMessage().get(1), second, startTimeInMillis);
  }

  @ParameterizedTest
  @MethodSource("provideHandler")
  void it_has_a_case_for_every_implemented_handler(final X1RequestHandler<?, ?> handler)
    throws JAXBException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException, X1ErrorException {
    // GIVEN: a request container with a single request
    final var requestMessageType = handler.getRequestClass();
    final var requestMessage = mock(requestMessageType);
    when(requestMessage.getVersion()).thenReturn(VERSION);

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
    return postBytes(loadRequestFromFile(file).getBytes(StandardCharsets.UTF_8));
  }

  private String loadRequestFromFile(final String file) throws IOException {
    try (final var requestInputStream = this.getClass().getClassLoader().getResourceAsStream(file)) {
      if (requestInputStream == null) {
        throw new IOException("resource not found: " + file);
      }

      return new String(requestInputStream.readAllBytes(), StandardCharsets.UTF_8);
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

  private static void assertCommonFields(
    final X1RequestMessage requestMessage,
    final X1ResponseMessage responseMessage,
    final long startTimeInMillis
  ) {
    assertThat(responseMessage.getAdmfIdentifier()).isEqualTo(requestMessage.getAdmfIdentifier());
    assertThat(responseMessage.getNeIdentifier()).isEqualTo(requestMessage.getNeIdentifier());
    assertThat(responseMessage.getX1TransactionId()).isEqualTo(requestMessage.getX1TransactionId());
    assertThat(responseMessage.getVersion()).isEqualTo(VERSION);

    final var timeinMillis = responseMessage.getMessageTimestamp().toGregorianCalendar().getTimeInMillis();
    assertThat(timeinMillis).isGreaterThan(startTimeInMillis);
  }
}
