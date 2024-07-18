package com.sipgate.li.lib.x1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.UnmarshalException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.etsi.uri._03221.x1._2017._10.ActivateTaskRequest;
import org.etsi.uri._03221.x1._2017._10.ActivateTaskResponse;
import org.etsi.uri._03221.x1._2017._10.DeliveryType;
import org.etsi.uri._03221.x1._2017._10.ListOfDids;
import org.etsi.uri._03221.x1._2017._10.ListOfTargetIdentifiers;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.etsi.uri._03221.x1._2017._10.RequestContainer;
import org.etsi.uri._03221.x1._2017._10.ResponseContainer;
import org.etsi.uri._03221.x1._2017._10.TargetIdentifier;
import org.etsi.uri._03221.x1._2017._10.TaskDetails;
import org.etsi.uri._03221.x1._2017._10.TopLevelErrorResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConverterTest {

  private Converter underTest;

  @BeforeEach
  void setUp() throws JAXBException {
    underTest = new Converter();
  }

  @Test
  void itParsesRequest()
    throws IOException, JAXBException, DatatypeConfigurationException {
    // GIVEN
    final var xml = readResource("ActivateTaskRequest_example.xml");

    // WHEN
    final var actual = underTest.parseRequest(xml);

    // THEN
    final var activateTaskRequest = new ActivateTaskRequest();
    activateTaskRequest.setAdmfIdentifier("admfID");
    activateTaskRequest.setNeIdentifier("neID");
    final var calendar = DatatypeFactory.newInstance()
      .newXMLGregorianCalendar(
        BigInteger.valueOf(2017L),
        10,
        6,
        18,
        46,
        21,
        BigDecimal.valueOf(247432, 6),
        0
      );

    activateTaskRequest.setMessageTimestamp(calendar);
    activateTaskRequest.setVersion("v1.6.1");
    activateTaskRequest.setX1TransactionId(
      "3741800e-971b-4aa9-85f4-466d2b1adc7f"
    );

    final var details = new TaskDetails();
    details.setXId("29f28e1c-f230-486a-a860-f5a784ab9172");

    final var listOfTargetIdentifiers = new ListOfTargetIdentifiers();
    final var targetIdentifier = new TargetIdentifier();
    targetIdentifier.setE164Number("447700900000");
    listOfTargetIdentifiers.getTargetIdentifier().add((targetIdentifier));
    details.setTargetIdentifiers(listOfTargetIdentifiers);

    details.setDeliveryType(DeliveryType.X_2_AND_X_3);

    final var listOfDids = new ListOfDids();
    listOfDids.getDId().add("19867c20-8c94-473e-b9cd-8b72b7b05fd4");
    details.setListOfDIDs(listOfDids);

    activateTaskRequest.setTaskDetails(details);

    final var expected = new RequestContainer();
    expected.getX1RequestMessage().add(activateTaskRequest);

    assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void itParsesPositiveResponse()
    throws IOException, JAXBException, DatatypeConfigurationException {
    // GIVEN
    final var xml = readResource("ActivateTaskResponse_example.xml");

    // WHEN
    final var actual = underTest.parseResponse(xml).right();

    // THEN
    final var response = new ActivateTaskResponse();
    response.setAdmfIdentifier("admfID");
    response.setNeIdentifier("neID");
    final var calendar = DatatypeFactory.newInstance()
      .newXMLGregorianCalendar(
        BigInteger.valueOf(2017L),
        10,
        6,
        18,
        46,
        21,
        BigDecimal.valueOf(401571, 6),
        0
      );

    response.setMessageTimestamp(calendar);
    response.setVersion("v1.6.1");
    response.setX1TransactionId("3741800e-971b-4aa9-85f4-466d2b1adc7f");
    response.setOK(OK.ACKNOWLEDGED_AND_COMPLETED);

    final var expected = new ResponseContainer();
    expected.getX1ResponseMessage().add(response);
    assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void itParsesNegativeResponse()
    throws IOException, JAXBException, DatatypeConfigurationException {
    // GIVEN
    final var xml = readResource("TopLevelErrorResponse_example.xml");

    // WHEN
    final var actual = underTest.parseResponse(xml).left();

    // THEN
    final var expected = new TopLevelErrorResponse();
    expected.setAdmfIdentifier("admfID");
    expected.setNeIdentifier("neID");
    final var calendar = DatatypeFactory.newInstance()
      .newXMLGregorianCalendar(
        BigInteger.valueOf(2017L),
        10,
        6,
        18,
        46,
        21,
        BigDecimal.valueOf(401571, 6),
        0
      );

    expected.setMessageTimestamp(calendar);
    expected.setVersion("v1.6.1");

    assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void itProtectsFromXxe() throws IOException {
    // GIVEN
    final var xml = readResource("xxe.xml");

    // WHEN + THEN
    assertThatThrownBy(() -> underTest.parseResponse(xml)).isInstanceOf(
      UnmarshalException.class
    );
  }

  private String readResource(final String name) throws IOException {
    try (final var is = getClass().getClassLoader().getResourceAsStream(name)) {
      Objects.requireNonNull(is);
      return new String(is.readAllBytes(), StandardCharsets.UTF_8);
    }
  }
}
