/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.client;

import java.time.Instant;
import java.util.GregorianCalendar;
import java.util.UUID;
import javax.xml.datatype.DatatypeFactory;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;

public class X1RequestFactory {

  public static final String X1_VERSION_STRING = "v1.6.1";

  private final DatatypeFactory dataTypeFactory;
  private final String neId;
  private final String admfId;

  public X1RequestFactory(final DatatypeFactory dataTypeFactory, final String neId, final String admfId) {
    this.dataTypeFactory = dataTypeFactory;
    this.neId = neId;
    this.admfId = admfId;
  }

  @SuppressWarnings("unchecked")
  public <P, B extends X1RequestMessage.Builder<P>> B builder(final B builder) {
    try {
      final var gregorianCalendar = new GregorianCalendar();
      gregorianCalendar.setTimeInMillis(Instant.now().toEpochMilli());
      final var b = builder
        .withAdmfIdentifier(admfId)
        .withNeIdentifier(neId)
        .withX1TransactionId(UUID.randomUUID().toString())
        .withVersion(X1_VERSION_STRING)
        .withMessageTimestamp(dataTypeFactory.newXMLGregorianCalendar(gregorianCalendar));
      return (B) b; // cast up to derived builder
    } catch (final Exception e) {
      throw new IllegalArgumentException("Could not create X1RequestMessage.Builder", e);
    }
  }
}
