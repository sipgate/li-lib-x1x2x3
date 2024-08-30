package com.sipgate.li.lib.x1;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.etsi.uri._03221.x1._2017._10.ActivateTaskRequest;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class X1RequestFactoryTest {

  private static final String ADMF_ID = "admf-id";
  private static final String NE_ID = "ne-id";

  @Test
  void it_produces_request_object_with_default_values()
    throws DatatypeConfigurationException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    // GIVEN
    final var factory = new X1RequestFactory(DatatypeFactory.newInstance(), NE_ID, ADMF_ID);

    // WHEN
    final var request = factory.builder(ActivateTaskRequest.builder()).build();

    // THEN
    assertThat(request.getAdmfIdentifier()).isEqualTo(ADMF_ID);
    assertThat(request.getNeIdentifier()).isEqualTo(NE_ID);
    assertThat(request.getMessageTimestamp()).isNotNull();
    assertThat(request.getVersion()).isNotEmpty();

    // Does not place request-specific things
    assertThat(request.getTaskDetails()).isNull();
  }
}
