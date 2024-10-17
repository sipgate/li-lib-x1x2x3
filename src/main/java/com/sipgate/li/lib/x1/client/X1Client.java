package com.sipgate.li.lib.x1.client;

import com.sipgate.li.lib.x1.protocol.Converter;
import jakarta.xml.bind.JAXBException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;
import org.etsi.uri._03221.x1._2017._10.RequestContainer;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;
import org.etsi.uri._03221.x1._2017._10.X1ResponseMessage;

public class X1Client {

  private final URI target;
  protected final HttpClient httpClient;
  private final Converter converter;

  X1Client(final URI target, final HttpClient httpClient) throws JAXBException {
    this.target = Objects.requireNonNull(target, "target uri must not be null");
    this.httpClient = Objects.requireNonNull(httpClient, "httpClient must not be null");

    this.converter = new Converter();
  }

  public <R extends X1ResponseMessage> R request(final X1RequestMessage x1Request, final Class<R> responseType)
    throws X1ClientException, InterruptedException {
    try {
      final var x1requestContainer = new RequestContainer();
      x1requestContainer.getX1RequestMessage().add(x1Request);

      final var body = converter.toXml(x1requestContainer);
      final var httpRequest = HttpRequest.newBuilder(target).POST(HttpRequest.BodyPublishers.ofString(body)).build();
      final var httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

      final var either = converter.parseResponse(httpResponse.body());

      if (either.isLeft()) {
        throw new X1ClientException(
          "Request " + x1Request.getX1TransactionId() + " returned TopLevelErrorResponse.",
          either.left()
        );
      }

      if (either.right().getX1ResponseMessage().size() != 1) {
        throw new X1ClientException(
          "Did not receive expected number of responses in Container. Expected 1, received " +
          either.right().getX1ResponseMessage().size()
        );
      }

      final var x1Response = either.right().getX1ResponseMessage().getFirst();
      if (!responseType.isAssignableFrom(x1Response.getClass())) {
        throw new X1ClientException(
          String.format(
            "%s did not respond with %s, received %s",
            x1Request.getClass().getSimpleName(),
            responseType.getSimpleName(),
            x1Response.getClass().getSimpleName()
          )
        );
      }

      return responseType.cast(x1Response);
    } catch (final InterruptedException | X1ClientException e) {
      throw e;
    } catch (final Exception e) {
      throw new X1ClientException("Failed to send request", e);
    }
  }
}
