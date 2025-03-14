/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.server;

import static com.sipgate.li.lib.x1.protocol.X1Version.VERSION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.sipgate.li.lib.x1.protocol.Converter;
import com.sipgate.li.lib.x1.protocol.error.DIDDoesNotExistException;
import com.sipgate.li.lib.x1.protocol.error.ErrorResponseException;
import com.sipgate.li.lib.x1.protocol.error.ErrorResponseFactory;
import com.sipgate.li.lib.x1.protocol.error.GenericActivateTaskFailureException;
import com.sipgate.li.lib.x1.protocol.error.GenericErrorException;
import com.sipgate.li.lib.x1.protocol.error.InvalidCombinationOfDeliveryTypeAndDestinationsException;
import com.sipgate.li.lib.x1.protocol.error.SyntaxSchemaErrorException;
import com.sipgate.li.lib.x1.protocol.error.UnsupportedRequestException;
import com.sipgate.li.lib.x1.protocol.error.UnsupportedVersionException;
import com.sipgate.li.lib.x1.protocol.error.XIDAlreadyExistsException;
import com.sipgate.li.lib.x1.server.handler.X1RequestHandler;
import com.sipgate.li.lib.x1.server.handler.task.ActivateTaskHandler;
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
import java.util.UUID;
import java.util.stream.Stream;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.etsi.uri._03221.x1._2017._10.ActivateTaskRequest;
import org.etsi.uri._03221.x1._2017._10.ErrorResponse;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.etsi.uri._03221.x1._2017._10.PingResponse;
import org.etsi.uri._03221.x1._2017._10.RequestContainer;
import org.etsi.uri._03221.x1._2017._10.ResponseContainer;
import org.etsi.uri._03221.x1._2017._10.TopLevelErrorResponse;
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
class X1NetworkElementHandlerTest {

  private static final String NE_IDENTIFIER = "i-am-a-network-element";

  private X1NetworkElementHandler underTest;

  private Converter converter;

  @Mock
  private DestinationRepository destinationRepository;

  @Mock
  private TaskRepository taskRepository;

  @BeforeEach
  void setup() throws JAXBException, DatatypeConfigurationException {
    converter = new Converter();
    final var datatypeFactory = DatatypeFactory.newInstance();

    underTest = new X1NetworkElementHandler(
      converter,
      destinationRepository,
      taskRepository,
      datatypeFactory,
      NE_IDENTIFIER
    );
  }

  @Test
  void itReturnsOkAndWithTLER_onBadXml() throws Exception {
    // WHEN
    final var response = postBytes("this is not xml".getBytes(StandardCharsets.UTF_8));

    // THEN
    assertThat(response.status()).isEqualTo(HttpResponseStatus.OK);

    final var responseXml = response.content().toString(StandardCharsets.UTF_8);
    final var contentOrError = converter.parseResponse(responseXml);
    assertTLER(contentOrError.left());
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
    assertTLER(contentOrError.left());
  }

  @Test
  void itReturnsUnsupportedVersionErrorResponse() throws Exception {
    // GIVEN
    final var requestXml = loadRequestFromFile("X1HttpServerHandlerTest/BadVersionRequest_example.xml");
    final var request = converter.parseRequest(requestXml);
    final var requestMessage = request.getX1RequestMessage().getFirst();
    final var startTimeInMillis = Instant.now().toEpochMilli();

    // WHEN
    final var response = postBytes(requestXml.getBytes(StandardCharsets.UTF_8));

    // THEN
    assertThat(response.status()).isEqualTo(HttpResponseStatus.OK);

    final var responseXml = response.content().toString(StandardCharsets.UTF_8);
    final var contentOrError = converter.parseResponse(responseXml);
    assertThat(contentOrError.isRight()).isTrue();

    final var responseContainer = contentOrError.right();
    final var errorResponse = (ErrorResponse) responseContainer.getX1ResponseMessage().getFirst();

    assertErrorReseponse(
      ErrorResponseFactory.makeErrorResponse(new UnsupportedVersionException(VERSION), requestMessage),
      errorResponse
    );

    assertCommonFields(request.getX1RequestMessage().getFirst(), errorResponse, startTimeInMillis);
  }

  @Test
  void itReturnsHandlerErrorResponse()
    throws JAXBException, IOException, GenericActivateTaskFailureException, SyntaxSchemaErrorException, XIDAlreadyExistsException, DIDDoesNotExistException, InvalidCombinationOfDeliveryTypeAndDestinationsException, NoSuchFieldException, IllegalAccessException {
    // GIVEN: single activate task request
    final var requestXml = loadRequestFromFile("ActivateTaskRequest_example.xml");
    final var request = converter.parseRequest(requestXml);
    final var requestMessage = request.getX1RequestMessage().getFirst();
    final var startTimeInMillis = Instant.now().toEpochMilli();

    // GIVEN: handler throws
    final var handler = mock(ActivateTaskHandler.class);
    final var exception = new XIDAlreadyExistsException(UUID.fromString("29f28e1c-f230-486a-a860-f5a784ab9172"));
    doThrow(exception).when(handler).handle(any());

    // GIVEN: X1HttpServerHandler with mocked handlers
    setField(underTest, "handlers", Map.of(ActivateTaskRequest.class, handler));

    // WHEN
    final var response = postBytes(requestXml.getBytes(StandardCharsets.UTF_8));

    // THEN
    assertThat(response.status()).isEqualTo(HttpResponseStatus.OK);

    final var responseXml = response.content().toString(StandardCharsets.UTF_8);
    final var contentOrError = converter.parseResponse(responseXml);
    assertThat(contentOrError.isRight()).isTrue();

    final var responseContainer = contentOrError.right();
    final var errorResponse = (ErrorResponse) responseContainer.getX1ResponseMessage().getFirst();

    assertErrorReseponse(ErrorResponseFactory.makeErrorResponse(exception, requestMessage), errorResponse);

    assertCommonFields(request.getX1RequestMessage().getFirst(), errorResponse, startTimeInMillis);
  }

  @Test
  void itReturnsGenericErrorResponse()
    throws JAXBException, IOException, GenericActivateTaskFailureException, SyntaxSchemaErrorException, XIDAlreadyExistsException, DIDDoesNotExistException, InvalidCombinationOfDeliveryTypeAndDestinationsException, NoSuchFieldException, IllegalAccessException {
    // GIVEN: single activate task request
    final var requestXml = loadRequestFromFile("ActivateTaskRequest_example.xml");
    final var request = converter.parseRequest(requestXml);
    final var requestMessage = request.getX1RequestMessage().getFirst();
    final var startTimeInMillis = Instant.now().toEpochMilli();

    // GIVEN: handler throws
    final var handler = mock(ActivateTaskHandler.class);
    final var runtimeException = new RuntimeException();
    final var exception = new GenericErrorException(runtimeException);
    doThrow(runtimeException).when(handler).handle(any());

    // GIVEN: X1HttpServerHandler with mocked handlers
    setField(underTest, "handlers", Map.of(ActivateTaskRequest.class, handler));

    // WHEN
    final var response = postBytes(requestXml.getBytes(StandardCharsets.UTF_8));

    // THEN
    assertThat(response.status()).isEqualTo(HttpResponseStatus.OK);

    final var responseXml = response.content().toString(StandardCharsets.UTF_8);
    final var contentOrError = converter.parseResponse(responseXml);
    assertThat(contentOrError.isRight()).isTrue();

    final var responseContainer = contentOrError.right();
    final var errorResponse = (ErrorResponse) responseContainer.getX1ResponseMessage().getFirst();

    assertErrorReseponse(ErrorResponseFactory.makeErrorResponse(exception, requestMessage), errorResponse);

    assertCommonFields(request.getX1RequestMessage().getFirst(), errorResponse, startTimeInMillis);
  }

  @Test
  void itReturnsUnnsupportedRequestErrorResponse()
    throws JAXBException, IOException, NoSuchFieldException, IllegalAccessException {
    // GIVEN: single activate task request
    final var requestXml = loadRequestFromFile("ActivateTaskRequest_example.xml");
    final var request = converter.parseRequest(requestXml);
    final var requestMessage = request.getX1RequestMessage().getFirst();
    final var startTimeInMillis = Instant.now().toEpochMilli();

    // GIVEN: X1HttpServerHandler without handlers
    setField(underTest, "handlers", Map.of());

    // WHEN
    final var response = postBytes(requestXml.getBytes(StandardCharsets.UTF_8));

    // THEN
    assertThat(response.status()).isEqualTo(HttpResponseStatus.OK);

    final var responseXml = response.content().toString(StandardCharsets.UTF_8);
    final var contentOrError = converter.parseResponse(responseXml);
    assertThat(contentOrError.isRight()).isTrue();

    final var responseContainer = contentOrError.right();
    final var errorResponse = (ErrorResponse) responseContainer.getX1ResponseMessage().getFirst();

    assertErrorReseponse(
      ErrorResponseFactory.makeErrorResponse(new UnsupportedRequestException(), requestMessage),
      errorResponse
    );

    assertCommonFields(request.getX1RequestMessage().getFirst(), errorResponse, startTimeInMillis);
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
    throws JAXBException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException, ErrorResponseException {
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

  private void assertErrorReseponse(final ErrorResponse expected, final ErrorResponse actual) {
    assertThat(actual.getRequestMessageType()).isEqualTo(expected.getRequestMessageType());
    assertThat(actual.getErrorInformation()).usingRecursiveComparison().isEqualTo(expected.getErrorInformation());
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
    assertThat(timeinMillis).isGreaterThanOrEqualTo(startTimeInMillis);
  }

  private void assertTLER(final TopLevelErrorResponse tler) {
    assertThat(tler).isNotNull();
    assertThat(tler.getNeIdentifier()).isEqualTo(NE_IDENTIFIER);
    // This is the case when there is no SSL. For SSL, we use an E2E test.
    assertThat(tler.getAdmfIdentifier()).isEqualTo("without-tls-i-cannot-figure-out-who-you-are");
  }
}
