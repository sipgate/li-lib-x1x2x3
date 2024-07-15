package com.sipgate.li.lib.x1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class X1RequestTest {

    private ObjectMapper underTest = new XmlMapper();

    @Test
    void itValidatesMessages() {
        assertThrows(NullPointerException.class, () -> new X1Request(null));
        assertThrows(IllegalArgumentException.class, () -> new X1Request(List.of()));
    }

    @Test
    void itDeserializesFromXml() throws JsonProcessingException {
        final var xml = """
            <?xml version="1.0" encoding="UTF-8"?>
            <ns1:X1Request xmlns:ns1="http://uri.etsi.org/03221/X1/2017/10" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                <ns1:x1RequestMessage xsi:type="ns1:ActivateTaskRequest">
                    <ns1:admfIdentifier>simulator-id</ns1:admfIdentifier>
                    <ns1:neIdentifier>dev-mediation-id</ns1:neIdentifier>
                    <ns1:messageTimestamp>2017-10-06T18:46:21.247432Z</ns1:messageTimestamp>
                    <ns1:version>v1.6.1</ns1:version>
                    <ns1:x1TransactionId>3741800e-971b-4aa9-85f4-466d2b1adc7f</ns1:x1TransactionId>
                    <ns1:taskDetails>
                        <ns1:xId>some-random-id</ns1:xId>
                        <ns1:targetIdentifiers>
                            <ns1:targetIdentifier>
                                <ns1:e164Number>49441123456</ns1:e164Number>
                            </ns1:targetIdentifier>
                        </ns1:targetIdentifiers>
                        <ns1:deliveryType>X2andX3</ns1:deliveryType>
                        <ns1:listOfDIDs>
                            <ns1:dId>19867c20-8c94-473e-b9cd-8b72b7b05fd4</ns1:dId>
                        </ns1:listOfDIDs>
                    </ns1:taskDetails>
                </ns1:x1RequestMessage>
            </ns1:X1Request>
        """;


        final var requestContainer = underTest.readValue(xml, X1Request.class);

        assertEquals(List.of(new Bar("foo")), requestContainer.messages());
    }
}