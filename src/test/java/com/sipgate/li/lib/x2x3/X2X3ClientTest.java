package com.sipgate.li.lib.x2x3;

import static com.sipgate.li.lib.x2x3.PduObject.MANDATORY_HEADER_LENGTH;
import static com.sipgate.li.lib.x2x3.PduObjectTest.CID;
import static com.sipgate.li.lib.x2x3.PduObjectTest.EMPTY;

import java.util.UUID;
import javax.net.SocketFactory;

public class X2X3ClientTest {

  public static void main(final String[] args) throws Exception {
    try (final X2X3Client client = new X2X3Client(SocketFactory.getDefault(), "localhost", 9998)) {
      client.send(
        new PduObject(
          (short) 0,
          (short) 5,
          PduType.X2_PDU,
          MANDATORY_HEADER_LENGTH,
          0,
          PayloadFormat.SIP,
          PayloadDirection.SENT_FROM_TARGET,
          UUID.randomUUID(),
          CID,
          EMPTY,
          EMPTY
        )
      );
    }
  }
}
