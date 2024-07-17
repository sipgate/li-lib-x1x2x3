package com.sipgate.li.lib.x1;

import org.etsi.uri._03221.x1._2017._10.ActivateTaskRequest;
import org.junit.jupiter.api.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThat;

class X1RequestFactoryTest {

    public static final String ADMF_ID = "admf-id";
    public static final String NE_ID = "ne-id";

    @Test
    void itProducesRequestObjectWithDefaultValues() throws DatatypeConfigurationException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // GIVEN
        final var factory = new X1RequestFactory(DatatypeFactory.newInstance(), NE_ID, ADMF_ID);

        // WHEN
        final var request = factory.create(ActivateTaskRequest.class);

        // THEN
        assertThat(request.getAdmfIdentifier()).isEqualTo(ADMF_ID);
        assertThat(request.getNeIdentifier()).isEqualTo(NE_ID);
        assertThat(request.getMessageTimestamp()).isNotNull();
        assertThat(request.getVersion()).isNotEmpty();

        // Does not place request-specific things
        assertThat(request.getTaskDetails()).isNull();
    }
}