package com.sipgate.li.lib.x1.server;

import static com.sipgate.li.lib.x1.protocol.X1Version.VERSION;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.etsi.uri._03221.x1._2017._10.PingResponse;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;
import org.junit.jupiter.api.Test;

class X1JobTest {

  public static final String ANY_ADMFID = "admfid";
  public static final String ANY_NEID = "neid";
  public static final String ANY_X1TRANSID = "x1transid";

  @Test
  public void itSetsHeaderFields() throws DatatypeConfigurationException {
    // ARRANGE
    final var df = DatatypeFactory.newInstance();
    final var cal = new GregorianCalendar();
    cal.setTimeInMillis(42L); // _not_ the current time
    final var inThePast = df.newXMLGregorianCalendar(cal);

    final var requestMessage = new X1RequestMessage();
    requestMessage.setVersion("any_version");
    requestMessage.setAdmfIdentifier(ANY_ADMFID);
    requestMessage.setNeIdentifier(ANY_NEID);
    requestMessage.setX1TransactionId(ANY_X1TRANSID);
    requestMessage.setMessageTimestamp(inThePast);
    // ACT
    //    final var underTest = new X1Job(requestMessage, PingResponse::new);
    //    final var actual = underTest.act();
    //
    //    // ASSERT
    //    assertThat(actual.getAdmfIdentifier()).isEqualTo(ANY_ADMFID);
    //    assertThat(actual.getNeIdentifier()).isEqualTo(ANY_NEID);
    //    assertThat(actual.getX1TransactionId()).isEqualTo(ANY_X1TRANSID);
    //    assertThat(actual.getVersion()).isEqualTo(VERSION);
    //    final var actualTs = actual.getMessageTimestamp().toGregorianCalendar().getTimeInMillis();
    //    assertThat(actualTs).isGreaterThan(42L);
  }
}
