package com.sipgate.li.lib.x1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.GregorianCalendar;
import java.util.Objects;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.assertj.core.api.Condition;
import org.etsi.uri._03221.x1._2017._10.ActivateTaskResponse;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.etsi.uri._03221.x1._2017._10.PingRequest;
import org.etsi.uri._03221.x1._2017._10.PingResponse;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;
import org.etsi.uri._03221.x1._2017._10.X1ResponseMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class X1ClientTest {

  private URI target;
  private HttpClient httpClient;
  private X1Client underTest;

  @BeforeEach
  void setUp() throws URISyntaxException, JAXBException {
    target = new URI("https://ne.example.com/X1/NE");
    httpClient = mock(HttpClient.class);

    underTest = new X1Client(target, httpClient);
  }

  @Test
  void it_returns_positive_response() throws Exception {
    // GIVEN
    final var pingRequest = createPingRequest();

    final var httpResponse = mock(HttpResponse.class);
    when(httpResponse.body()).thenReturn(readResource("PingResponse_example.xml"));

    final var bodyPublisher = HttpRequest.BodyPublishers.ofString(readResource("PingRequest_example.xml"));
    when(
      httpClient.send(
        eq(HttpRequest.newBuilder(target).POST(bodyPublisher).build()),
        any(HttpResponse.BodyHandler.class)
      )
    ).thenReturn(httpResponse);

    // WHEN
    final var resp = underTest.request(pingRequest, PingResponse.class);

    // THEN
    assertThat(resp).isInstanceOf(PingResponse.class);
    assertThat(resp.getOK()).isEqualTo(OK.ACKNOWLEDGED_AND_COMPLETED);
  }

  @Test
  void it_throws_when_response_is_invalid_xml() throws Exception {
    // GIVEN
    final var pingRequest = createPingRequest();

    final var httpResponse = mock(HttpResponse.class);
    when(httpResponse.body()).thenReturn("INVALID XML");

    final var bodyPublisher = HttpRequest.BodyPublishers.ofString(readResource("PingRequest_example.xml"));
    when(
      httpClient.send(
        eq(HttpRequest.newBuilder(target).POST(bodyPublisher).build()),
        any(HttpResponse.BodyHandler.class)
      )
    ).thenReturn(httpResponse);

    // WHEN + THEN
    assertThrows(X1ClientException.class, () -> underTest.request(pingRequest, PingResponse.class));
  }

  @Test
  void it_throws_when_there_are_more_than_one_response() throws Exception {
    // GIVEN
    final var pingRequest = createPingRequest();

    final var httpResponse = mock(HttpResponse.class);
    when(httpResponse.body()).thenReturn(readResource("MultipleResponses_example.xml"));

    final var bodyPublisher = HttpRequest.BodyPublishers.ofString(readResource("PingRequest_example.xml"));
    when(
      httpClient.send(
        eq(HttpRequest.newBuilder(target).POST(bodyPublisher).build()),
        any(HttpResponse.BodyHandler.class)
      )
    ).thenReturn(httpResponse);

    // WHEN + THEN
    assertThrows(X1ClientException.class, () -> underTest.request(pingRequest, PingResponse.class));
  }

  @Test
  void it_throws_when_there_is_no_response_in_container() throws Exception {
    // GIVEN
    final var pingRequest = createPingRequest();

    final var httpResponse = mock(HttpResponse.class);
    when(httpResponse.body()).thenReturn(readResource("NoResponsesInResponseContainer_example.xml"));

    final var bodyPublisher = HttpRequest.BodyPublishers.ofString(readResource("PingRequest_example.xml"));
    when(
      httpClient.send(
        eq(HttpRequest.newBuilder(target).POST(bodyPublisher).build()),
        any(HttpResponse.BodyHandler.class)
      )
    ).thenReturn(httpResponse);

    // WHEN + THEN
    assertThrows(X1ClientException.class, () -> underTest.request(pingRequest, PingResponse.class));
  }

  @Test
  void it_throws_when_there_is_a_top_level_error_response() throws Exception {
    // GIVEN
    final var pingRequest = createPingRequest();

    final var httpResponse = mock(HttpResponse.class);
    when(httpResponse.body()).thenReturn(readResource("TopLevelErrorResponse_example.xml"));

    final var bodyPublisher = HttpRequest.BodyPublishers.ofString(readResource("PingRequest_example.xml"));
    when(
      httpClient.send(
        eq(HttpRequest.newBuilder(target).POST(bodyPublisher).build()),
        any(HttpResponse.BodyHandler.class)
      )
    ).thenReturn(httpResponse);

    // WHEN + THEN
    assertThatThrownBy(() -> underTest.request(pingRequest, PingResponse.class))
      .isInstanceOf(X1ClientException.class)
      .has(
        new Condition<>(e -> ((X1ClientException) e).getTopLevelErrorResponse() != null, "toplevel error response set!")
      );
  }

  @Test
  void it_throws_when_response_is_not_expected_type() throws Exception {
    // GIVEN
    final var pingRequest = createPingRequest();

    final var httpResponse = mock(HttpResponse.class);
    when(httpResponse.body()).thenReturn(readResource("ActivateTaskResponse_example.xml"));

    final var bodyPublisher = HttpRequest.BodyPublishers.ofString(readResource("PingRequest_example.xml"));
    when(
      httpClient.send(
        eq(HttpRequest.newBuilder(target).POST(bodyPublisher).build()),
        any(HttpResponse.BodyHandler.class)
      )
    ).thenReturn(httpResponse);

    // WHEN + THEN
    assertThrows(IOException.class, () -> underTest.request(pingRequest, PingResponse.class));
  }

  @Test
  void it_returns_super_response_class() throws Exception {
    // GIVEN
    final var pingRequest = createPingRequest();

    final var httpResponse = mock(HttpResponse.class);
    when(httpResponse.body()).thenReturn(readResource("ActivateTaskResponse_example.xml"));

    final var bodyPublisher = HttpRequest.BodyPublishers.ofString(readResource("PingRequest_example.xml"));
    when(
      httpClient.send(
        eq(HttpRequest.newBuilder(target).POST(bodyPublisher).build()),
        any(HttpResponse.BodyHandler.class)
      )
    ).thenReturn(httpResponse);

    // WHEN
    final var resp = underTest.request(pingRequest, X1ResponseMessage.class);
    assertThat(resp).isInstanceOf(ActivateTaskResponse.class);
  }

  private static PingRequest createPingRequest() throws DatatypeConfigurationException {
    final var dataTypeFactory = DatatypeFactory.newInstance();
    final var factory = new X1RequestFactory(dataTypeFactory, "NE", "ADMF");
    return factory.builder(PingRequest.builder()).withX1TransactionId("3741800e-971b-4aa9-85f4-466d2b1adc7f").build();
  }

  private String readResource(final String name) throws IOException {
    try (final var is = getClass().getClassLoader().getResourceAsStream(name)) {
      Objects.requireNonNull(is);
      return new String(is.readAllBytes(), StandardCharsets.UTF_8);
    }
  }
}
