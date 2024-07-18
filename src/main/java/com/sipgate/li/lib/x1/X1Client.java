package com.sipgate.li.lib.x1;

import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.etsi.uri._03221.x1._2017._10.*;

public class X1Client {

  private final URI target;
  private final HttpClient httpClient;
  private final Converter converter;

  public X1Client(final URI target, final HttpClient httpClient)
    throws JAXBException {
    this.target = target;
    this.httpClient = httpClient;

    this.converter = new Converter();
  }

  public <R extends X1ResponseMessage> R request(
    final X1RequestMessage x1Request,
    final Class<R> responseType
  ) throws IOException, InterruptedException {
    try {
      final var x1requestContainer = new RequestContainer();
      x1requestContainer.getX1RequestMessage().add(x1Request);

      final var body = converter.toXml(x1requestContainer);
      final var httpRequest = HttpRequest.newBuilder(target)
        .POST(HttpRequest.BodyPublishers.ofString(body))
        .build();
      final var httpResponse = httpClient.send(
        httpRequest,
        HttpResponse.BodyHandlers.ofString()
      );

      final var either = converter.parseResponse(httpResponse.body());

      if (either.isLeft()) {
        throw new IOException(
          "Request " +
          x1Request.getX1TransactionId() +
          " returned TopLevelErrorResponse."
        );
      }

      if (either.right().getX1ResponseMessage().size() != 1) {
        throw new IOException(
          "Did not receive expected number of responses in Container. Expected 1, received " +
          either.right().getX1ResponseMessage().size()
        );
      }

      final var x1Response = either.right().getX1ResponseMessage().getFirst();
      if (!responseType.isAssignableFrom(x1Response.getClass())) {
        throw new IOException(
          String.format(
            "%s did not respond with %s, received %s",
            x1Request.getClass().getSimpleName(),
            responseType.getSimpleName(),
            x1Response.getClass().getSimpleName()
          )
        );
      }

      return responseType.cast(x1Response);
    } catch (final IOException | InterruptedException e) {
      throw e;
    } catch (final Exception e) {
      throw new IOException("Failed to send request", e);
    }
  }
}
