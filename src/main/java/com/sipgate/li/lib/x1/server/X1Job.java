package com.sipgate.li.lib.x1.server;

import static com.sipgate.li.lib.x1.protocol.X1Version.VERSION;

import java.time.Instant;
import java.util.GregorianCalendar;
import java.util.function.Supplier;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;
import org.etsi.uri._03221.x1._2017._10.X1ResponseMessage;

record X1Job(X1RequestMessage request, Supplier<X1ResponseMessage> handler) {
  static final DatatypeFactory datatypeFactory;

  static {
    try {
      datatypeFactory = DatatypeFactory.newInstance();
    } catch (final DatatypeConfigurationException e) {
      throw new RuntimeException(e);
    }
  }

  public X1ResponseMessage act() {
    final var response = this.handler().get();

    response.setAdmfIdentifier(request().getAdmfIdentifier());
    response.setNeIdentifier(request().getNeIdentifier());
    response.setVersion(VERSION);
    response.setX1TransactionId(request().getX1TransactionId());

    final var gcal = new GregorianCalendar();
    gcal.setTimeInMillis(Instant.now().toEpochMilli());
    response.setMessageTimestamp(datatypeFactory.newXMLGregorianCalendar(gcal));

    return response;
  }
}
