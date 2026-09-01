/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.protocol;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.ZoneOffset;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Builds a TS 103 280 {@code QualifiedMicrosecondDateTime}, as carried in the
 * {@code messageTimestamp} of every X1 message.
 *
 * <p>The schema constrains it to exactly six fractional digits:
 *
 * <pre>
 * \.[0-9]{6}(Z|[+-][0-9]{2}:[0-9]{2})
 * </pre>
 *
 * <p>A {@link java.util.GregorianCalendar} only carries milliseconds, so JAXB
 * renders three and the timestamp fails schema validation. The fractional
 * second is therefore set at scale six so trailing zeros are kept.
 */
public final class QualifiedMicrosecondDateTime {

  private QualifiedMicrosecondDateTime() {}

  /** The current time, in UTC. */
  public static XMLGregorianCalendar now(final DatatypeFactory datatypeFactory) {
    return of(datatypeFactory, Instant.now());
  }

  /** The given instant in UTC, truncated to microseconds. */
  public static XMLGregorianCalendar of(final DatatypeFactory datatypeFactory, final Instant instant) {
    final var utc = instant.atOffset(ZoneOffset.UTC);
    final var fractionalSecond = BigDecimal.valueOf(instant.getNano(), 9).setScale(6, RoundingMode.DOWN);
    return datatypeFactory.newXMLGregorianCalendar(
      BigInteger.valueOf(utc.getYear()),
      utc.getMonthValue(),
      utc.getDayOfMonth(),
      utc.getHour(),
      utc.getMinute(),
      utc.getSecond(),
      fractionalSecond,
      0 // UTC
    );
  }
}
