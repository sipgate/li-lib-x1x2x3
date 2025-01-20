/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.protocol;

import com.sipgate.util.Either;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.xml.transform.stream.StreamSource;
import org.etsi.uri._03221.x1._2017._10.ObjectFactory;
import org.etsi.uri._03221.x1._2017._10.RequestContainer;
import org.etsi.uri._03221.x1._2017._10.ResponseContainer;
import org.etsi.uri._03221.x1._2017._10.TopLevelErrorResponse;

public class Converter {

  private final JAXBContext context;
  private final ObjectFactory objectFactory;

  public Converter() throws JAXBException {
    context = JAXBContext.newInstance(ObjectFactory.class);
    objectFactory = new ObjectFactory();
  }

  public RequestContainer parseRequest(final String xml) throws JAXBException {
    return parseRequest(xml, StandardCharsets.UTF_8);
  }

  public RequestContainer parseRequest(final String xml, final Charset charset) throws JAXBException {
    final var unmarshaller = context.createUnmarshaller();
    unmarshaller.setEventHandler(new jakarta.xml.bind.helpers.DefaultValidationEventHandler());

    final var source = new StreamSource(new ByteArrayInputStream(xml.getBytes(charset)));
    final var jaxbElement = unmarshaller.unmarshal(source, RequestContainer.class);
    return jaxbElement.getValue();
  }

  public Either<TopLevelErrorResponse, ResponseContainer> parseResponse(final String xml) throws JAXBException {
    return parseResponse(xml, StandardCharsets.UTF_8);
  }

  public Either<TopLevelErrorResponse, ResponseContainer> parseResponse(final String xml, final Charset charset)
    throws JAXBException {
    final var unmarshaller = context.createUnmarshaller();
    unmarshaller.setEventHandler(new jakarta.xml.bind.helpers.DefaultValidationEventHandler());

    final var source = new StreamSource(new ByteArrayInputStream(xml.getBytes(charset)));
    final var jaxbElement = (JAXBElement<?>) unmarshaller.unmarshal(source);
    final var value = Objects.requireNonNull(jaxbElement.getValue());
    return switch (value) {
      case final ResponseContainer response -> Either.right(response);
      case final TopLevelErrorResponse error -> Either.left(error);
      default -> throw new IllegalArgumentException("Unexpected response type: " + value.getClass());
    };
  }

  public String toXml(final RequestContainer request) throws JAXBException {
    final var marshaller = context.createMarshaller();
    final var writer = new StringWriter();
    marshaller.marshal(objectFactory.createX1Request(request), writer);
    return writer.toString();
  }

  public String toXml(final ResponseContainer response) throws JAXBException {
    final var marshaller = context.createMarshaller();
    final var writer = new StringWriter();
    marshaller.marshal(objectFactory.createX1Response(response), writer);
    return writer.toString();
  }

  public String toXml(final TopLevelErrorResponse err) throws JAXBException {
    final var marshaller = context.createMarshaller();
    final var writer = new StringWriter();
    marshaller.marshal(objectFactory.createX1TopLevelErrorResponse(err), writer);
    return writer.toString();
  }
}
