/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.protocol;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class QualifiedMicrosecondDateTimeTest {

  private DatatypeFactory datatypeFactory;

  @BeforeEach
  void setUp() throws DatatypeConfigurationException {
    datatypeFactory = DatatypeFactory.newInstance();
  }

  @Test
  void it_keeps_six_fractional_digits_when_they_are_all_zero() {
    // WHEN
    final var timestamp = QualifiedMicrosecondDateTime.of(datatypeFactory, Instant.ofEpochSecond(0));

    // THEN
    assertThat(timestamp.toXMLFormat()).isEqualTo("1970-01-01T00:00:00.000000Z");
  }

  @Test
  void it_truncates_to_microseconds() {
    // WHEN
    final var timestamp = QualifiedMicrosecondDateTime.of(datatypeFactory, Instant.ofEpochSecond(0, 123_456_789));

    // THEN
    assertThat(timestamp.toXMLFormat()).isEqualTo("1970-01-01T00:00:00.123456Z");
  }
}
