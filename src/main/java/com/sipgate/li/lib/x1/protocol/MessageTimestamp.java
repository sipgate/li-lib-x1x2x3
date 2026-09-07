/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.protocol;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Builds the {@code messageTimestamp} carried on every X1 message.
 *
 * <p>TS 103 280 constrains {@code QualifiedMicrosecondDateTime} to exactly six
 * fractional digits:
 *
 * <pre>
 * \.[0-9]{6}(Z|[+-][0-9]{2}:[0-9]{2})
 * </pre>
 *
 * <p>A {@link GregorianCalendar} only carries milliseconds, so JAXB renders
 * three and the timestamp fails schema validation. The fractional second is
 * therefore set explicitly, at scale six so trailing zeros are kept, which also
 * preserves the sub-millisecond precision {@link Instant#toEpochMilli()}
 * discards.
 */
public final class MessageTimestamp {

  private MessageTimestamp() {}

  /** The current time, as a schema-valid {@code QualifiedMicrosecondDateTime}. */
  public static XMLGregorianCalendar now(final DatatypeFactory datatypeFactory) {
    return of(datatypeFactory, Instant.now());
  }

  /** A given instant, as a schema-valid {@code QualifiedMicrosecondDateTime}. */
  public static XMLGregorianCalendar of(final DatatypeFactory datatypeFactory, final Instant instant) {
    final var calendar = new GregorianCalendar();
    calendar.setTimeInMillis(instant.toEpochMilli());
    final var timestamp = datatypeFactory.newXMLGregorianCalendar(calendar);
    timestamp.setFractionalSecond(BigDecimal.valueOf(instant.getNano(), 9).setScale(6, RoundingMode.DOWN));
    return timestamp;
  }
}
