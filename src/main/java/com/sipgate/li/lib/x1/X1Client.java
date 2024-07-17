package com.sipgate.li.lib.x1;

import jakarta.xml.bind.JAXBException;
import org.etsi.uri._03221.x1._2017._10.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class X1Client {

    private final URI target;
    private final HttpClient httpClient;
    private final Converter converter;

    public X1Client(final URI target, final HttpClient httpClient) throws JAXBException {
        this.target = target;
        this.httpClient = httpClient;

        this.converter = new Converter();
    }

    public X1ResponseMessage request(final X1RequestMessage request) throws IOException, InterruptedException, JAXBException {
        final var x1requestContainer = new RequestContainer();
        x1requestContainer.getX1RequestMessage().add(request);

        final var body = converter.toXml(x1requestContainer);
        final var req = HttpRequest.newBuilder(target).POST(HttpRequest.BodyPublishers.ofString(body)).build();
        final var resp = httpClient.send(req, HttpResponse.BodyHandlers.ofString());

        final var either = converter.parseResponse(resp.body());

        if (either.isLeft()) {
            throw new IOException("Request " + request.getX1TransactionId() + " returned TopLevelErrorResponse.");
        }

        if (either.right().getX1ResponseMessage().size() != 1) {
            throw new IOException("Did not receive expected number of responses in Container. Expected 1, received " + either.right().getX1ResponseMessage().size());
        }

        return either.right().getX1ResponseMessage().getFirst();
    }

}
