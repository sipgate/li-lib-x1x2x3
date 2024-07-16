package com.sipgate.li.lib.x1;

import jakarta.xml.bind.JAXBException;
import org.etsi.uri._03221.x1._2017._10.ActivateTaskRequest;
import org.etsi.uri._03221.x1._2017._10.DeliveryType;
import org.etsi.uri._03221.x1._2017._10.ListOfDids;
import org.etsi.uri._03221.x1._2017._10.ListOfTargetIdentifiers;
import org.etsi.uri._03221.x1._2017._10.RequestContainer;
import org.etsi.uri._03221.x1._2017._10.TargetIdentifier;
import org.etsi.uri._03221.x1._2017._10.TaskDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterTest {

    private Converter underTest;

    @BeforeEach
    void setUp() throws JAXBException {
        underTest = new Converter();
    }

    @Test
    void itParsesRequest() throws IOException, JAXBException, DatatypeConfigurationException {
        // GIVEN
        final var xml = readResource("ActivateTaskRequest.xml");


        // WHEN
        final var actual = underTest.parseRequest(xml);

        // THEN
        final var activateTaskRequest = new ActivateTaskRequest();
        activateTaskRequest.setAdmfIdentifier("simulator-id");
        activateTaskRequest.setNeIdentifier("dev-mediation-id");
        final var calendar = DatatypeFactory.newInstance()
                .newXMLGregorianCalendar(BigInteger.valueOf(2017L), 10, 6, 18, 46, 21, BigDecimal.valueOf(247432, 6), 0);

        activateTaskRequest.setMessageTimestamp(calendar);
        activateTaskRequest.setVersion("v1.6.1");
        activateTaskRequest.setX1TransactionId("3741800e-971b-4aa9-85f4-466d2b1adc7f");

        final var details = new TaskDetails();
        details.setXId("19867c20-8c94-473e-b9cd-8b72b7b05fd4");

        final var listOfTargetIdentifiers = new ListOfTargetIdentifiers();
        final var targetIdentifier = new TargetIdentifier();
        targetIdentifier.setE164Number("49441123456");
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

    private String readResource(final String name) throws IOException {
        try (final var is = getClass().getClassLoader().getResourceAsStream(name)) {
            Objects.requireNonNull(is);
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}