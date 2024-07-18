package com.sipgate.li.lib.x1;

import jakarta.xml.bind.JAXBException;
import org.etsi.uri._03221.x1._2017._10.ActivateTaskResponse;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.etsi.uri._03221.x1._2017._10.PingRequest;
import org.etsi.uri._03221.x1._2017._10.PingResponse;
import org.etsi.uri._03221.x1._2017._10.X1ResponseMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

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
    void itReturnsPositiveResponse() throws Exception {
        // GIVEN
        final var pingRequest = createPingRequest();

        final var httpResponse = mock(HttpResponse.class);
        when(httpResponse.body()).thenReturn(readResource("PingResponse_example.xml"));

        final var bodyPublisher = HttpRequest.BodyPublishers.ofString(readResource("PingRequest_example.xml"));
        when(httpClient
                .send(eq(HttpRequest.newBuilder(target).POST(bodyPublisher).build()),
                        any(HttpResponse.BodyHandler.class)))
                .thenReturn(httpResponse);

        // WHEN
        final var resp = underTest.request(pingRequest, PingResponse.class);

        // THEN
        assertThat(resp).isInstanceOf(PingResponse.class);
        assertThat(resp.getOK()).isEqualTo(OK.ACKNOWLEDGED_AND_COMPLETED);
    }


    @Test
    void itThrowsWhenResponseIsInvalidXml() throws Exception {
        // GIVEN
        final var pingRequest = createPingRequest();

        final var httpResponse = mock(HttpResponse.class);
        when(httpResponse.body()).thenReturn("INVALID XML");

        final var bodyPublisher = HttpRequest.BodyPublishers.ofString(readResource("PingRequest_example.xml"));
        when(httpClient
                .send(eq(HttpRequest.newBuilder(target).POST(bodyPublisher).build()),
                        any(HttpResponse.BodyHandler.class)))
                .thenReturn(httpResponse);

        // WHEN + THEN
        assertThrows(JAXBException.class, () -> underTest.request(pingRequest, PingResponse.class));
    }

    @Test
    void itThrowsWhenThereAreMoreThanOneResponse() throws Exception {
        // GIVEN
        final var pingRequest = createPingRequest();

        final var httpResponse = mock(HttpResponse.class);
        when(httpResponse.body()).thenReturn(readResource("MultipleResponses_example.xml"));

        final var bodyPublisher = HttpRequest.BodyPublishers.ofString(readResource("PingRequest_example.xml"));
        when(httpClient
                .send(eq(HttpRequest.newBuilder(target).POST(bodyPublisher).build()),
                        any(HttpResponse.BodyHandler.class)))
                .thenReturn(httpResponse);

        // WHEN + THEN
        assertThrows(IOException.class, () -> underTest.request(pingRequest, PingResponse.class));
    }

    @Test
    void itThrowsWhenThereIsNoResponseInContainer() throws Exception {
        // GIVEN
        final var pingRequest = createPingRequest();

        final var httpResponse = mock(HttpResponse.class);
        when(httpResponse.body()).thenReturn(readResource("NoResponsesInResponseContainer_example.xml"));

        final var bodyPublisher = HttpRequest.BodyPublishers.ofString(readResource("PingRequest_example.xml"));
        when(httpClient
                .send(eq(HttpRequest.newBuilder(target).POST(bodyPublisher).build()),
                        any(HttpResponse.BodyHandler.class)))
                .thenReturn(httpResponse);

        // WHEN + THEN
        assertThrows(IOException.class, () -> underTest.request(pingRequest, PingResponse.class));
    }

    @Test
    void itThrowsWhenThereIsATopLevelErrorResponse() throws Exception {
        // GIVEN
        final var pingRequest = createPingRequest();

        final var httpResponse = mock(HttpResponse.class);
        when(httpResponse.body()).thenReturn(readResource("TopLevelErrorResponse_example.xml"));

        final var bodyPublisher = HttpRequest.BodyPublishers.ofString(readResource("PingRequest_example.xml"));
        when(httpClient
                .send(eq(HttpRequest.newBuilder(target).POST(bodyPublisher).build()),
                        any(HttpResponse.BodyHandler.class)))
                .thenReturn(httpResponse);

        // WHEN + THEN
        assertThrows(IOException.class, () -> underTest.request(pingRequest, PingResponse.class));
    }

    @Test
    void itThrowsWhenResponseIsNotExpectedType() throws Exception {
        // GIVEN
        final var pingRequest = createPingRequest();

        final var httpResponse = mock(HttpResponse.class);
        when(httpResponse.body()).thenReturn(readResource("ActivateTaskResponse_example.xml"));

        final var bodyPublisher = HttpRequest.BodyPublishers.ofString(readResource("PingRequest_example.xml"));
        when(httpClient
                .send(eq(HttpRequest.newBuilder(target).POST(bodyPublisher).build()),
                        any(HttpResponse.BodyHandler.class)))
                .thenReturn(httpResponse);

        // WHEN + THEN
        assertThrows(IOException.class, () -> underTest.request(pingRequest, PingResponse.class));
    }

    @Test
    void itReturnsSuperResponseClass() throws Exception {
        // GIVEN
        final var pingRequest = createPingRequest();

        final var httpResponse = mock(HttpResponse.class);
        when(httpResponse.body()).thenReturn(readResource("ActivateTaskResponse_example.xml"));

        final var bodyPublisher = HttpRequest.BodyPublishers.ofString(readResource("PingRequest_example.xml"));
        when(httpClient
                .send(eq(HttpRequest.newBuilder(target).POST(bodyPublisher).build()),
                        any(HttpResponse.BodyHandler.class)))
                .thenReturn(httpResponse);

        // WHEN
        final var resp = underTest.request(pingRequest, X1ResponseMessage.class);
        assertThat(resp).isInstanceOf(ActivateTaskResponse.class);
    }

    private static PingRequest createPingRequest() throws DatatypeConfigurationException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final var dataTypeFactory = DatatypeFactory.newInstance();
        final var pingRequest = new X1RequestFactory(dataTypeFactory, "NE", "ADMF")
                .create(PingRequest.class);

        pingRequest.setMessageTimestamp(dataTypeFactory.newXMLGregorianCalendar(new GregorianCalendar()));
        pingRequest.setX1TransactionId("3741800e-971b-4aa9-85f4-466d2b1adc7f");
        return pingRequest;
    }

    private String readResource(final String name) throws IOException {
        try (final var is = getClass().getClassLoader().getResourceAsStream(name)) {
            Objects.requireNonNull(is);
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}