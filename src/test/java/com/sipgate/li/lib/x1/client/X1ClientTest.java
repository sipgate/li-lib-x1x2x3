/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.client;

import static com.sipgate.li.lib.x1.protocol.error.ErrorResponseException.GENERIC_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import jakarta.xml.bind.JAXBException;
import java.io.IOException;
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
import org.etsi.uri._03221.x1._2017._10.ActivateTaskResponse;
import org.etsi.uri._03221.x1._2017._10.ErrorResponse;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.etsi.uri._03221.x1._2017._10.PingRequest;
import org.etsi.uri._03221.x1._2017._10.PingResponse;
import org.etsi.uri._03221.x1._2017._10.RequestMessageType;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;
import org.etsi.uri._03221.x1._2017._10.X1ResponseMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

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

    respondWith(200, readResource("PingResponse_example.xml"));

    // WHEN
    final var responseMessage = underTest.request(pingRequest, PingResponse.class);

    // THEN
    assertThat(responseMessage).isInstanceOf(PingResponse.class);
    assertThat(responseMessage.getOK()).isEqualTo(OK.ACKNOWLEDGED_AND_COMPLETED);
  }

  @Test
  void it_throws_error_response() throws DatatypeConfigurationException, IOException, InterruptedException {
    // GIVEN
    final var pingRequest = createPingRequest();

    respondWith(200, readResource("ErrorResponse_example.xml"));

    // WHEN + THEN
    assertThatThrownBy(() -> underTest.request(pingRequest, PingResponse.class))
      .isInstanceOf(ErrorResponseClientException.class)
      .satisfies(e -> {
        final var errorResponse = ((ErrorResponseClientException) e).getErrorResponse();
        assertThat(errorResponse).isInstanceOf(ErrorResponse.class);
        assertThat(errorResponse.getRequestMessageType()).isEqualTo(RequestMessageType.PING);
        assertThat(errorResponse.getErrorInformation().getErrorCode()).isEqualTo(GENERIC_ERROR);
        assertThat(errorResponse.getErrorInformation().getErrorDescription()).isEqualTo("generic error");
      });
  }

  @Test
  void it_throws_when_response_is_invalid_xml() throws Exception {
    // GIVEN
    final var pingRequest = createPingRequest();

    respondWith(200, "INVALID XML");

    // WHEN + THEN
    assertThrows(X1ClientException.class, () -> underTest.request(pingRequest, PingResponse.class));
  }

  @Test
  void it_throws_when_there_are_more_than_one_response() throws Exception {
    // GIVEN
    final var pingRequest = createPingRequest();

    respondWith(200, readResource("MultipleResponses_example.xml"));

    // WHEN + THEN
    assertThrows(X1ClientException.class, () -> underTest.request(pingRequest, PingResponse.class));
  }

  @Test
  void it_throws_when_there_is_no_response_in_container() throws Exception {
    // GIVEN
    final var pingRequest = createPingRequest();

    respondWith(200, readResource("NoResponsesInResponseContainer_example.xml"));

    // WHEN + THEN
    assertThrows(X1ClientException.class, () -> underTest.request(pingRequest, PingResponse.class));
  }

  @Test
  void it_throws_when_there_is_a_top_level_error_response() throws Exception {
    // GIVEN
    final var pingRequest = createPingRequest();

    respondWith(200, readResource("TopLevelErrorResponse_example.xml"));

    // WHEN + THEN
    assertThatThrownBy(() -> underTest.request(pingRequest, PingResponse.class)).isInstanceOf(
      TopLevelErrorClientException.class
    );
  }

  @Test
  void it_throws_when_response_is_not_expected_type() throws Exception {
    // GIVEN
    final var pingRequest = createPingRequest();

    respondWith(200, readResource("ActivateTaskResponse_example.xml"));

    // WHEN + THEN
    assertThrows(IOException.class, () -> underTest.request(pingRequest, PingResponse.class));
  }

  @Test
  void it_returns_super_response_class() throws Exception {
    // GIVEN
    final var pingRequest = createPingRequest();

    respondWith(200, readResource("ActivateTaskResponse_example.xml"));

    // WHEN
    final var responseMessage = underTest.request(pingRequest, X1ResponseMessage.class);
    assertThat(responseMessage).isInstanceOf(ActivateTaskResponse.class);
  }

  @Test
  void it_posts_with_xml_content_type() throws Exception {
    respondWith(200, readResource("PingResponse_example.xml"));

    underTest.request(createPingRequest(), PingResponse.class);

    final var request = ArgumentCaptor.forClass(HttpRequest.class);
    verify(httpClient).send(request.capture(), any(HttpResponse.BodyHandler.class));
    assertThat(request.getValue().method()).isEqualTo("POST");
    assertThat(request.getValue().headers().firstValue("Content-Type")).contains("application/xml; charset=UTF-8");
  }

  @Test
  void it_throws_on_non_200_status_without_parsing_the_body() throws Exception {
    respondWith(500, "<html>Internal Server Error</html>");

    assertThatThrownBy(() -> underTest.request(createPingRequest(), PingResponse.class))
      .isExactlyInstanceOf(X1ClientException.class)
      .hasMessageContaining("500");
  }

  @Test
  void it_throws_when_response_transaction_id_does_not_match_request() throws Exception {
    respondWith(200, readResource("PingResponse_example.xml"));
    final var pingRequest = createPingRequest();
    pingRequest.setX1TransactionId("00000000-0000-4000-8000-000000000000");

    assertThatThrownBy(() -> underTest.request(pingRequest, PingResponse.class))
      .isExactlyInstanceOf(X1ClientException.class)
      .hasMessageContaining("00000000-0000-4000-8000-000000000000")
      .hasMessageContaining("3741800e-971b-4aa9-85f4-466d2b1adc7f");
  }

  @Test
  void it_throws_when_error_response_transaction_id_does_not_match_request() throws Exception {
    respondWith(200, readResource("ErrorResponse_example.xml"));
    final var pingRequest = createPingRequest();
    pingRequest.setX1TransactionId("00000000-0000-4000-8000-000000000000");

    assertThatThrownBy(() -> underTest.request(pingRequest, PingResponse.class)).isExactlyInstanceOf(
      X1ClientException.class
    );
  }

  private void respondWith(final int statusCode, final String body) throws IOException, InterruptedException {
    final var httpResponse = mock(HttpResponse.class);
    when(httpResponse.statusCode()).thenReturn(statusCode);
    when(httpResponse.body()).thenReturn(body);
    when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(httpResponse);
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
