package com.sipgate.li.lib.x1.server.handler.status;

import static org.assertj.core.api.Assertions.assertThat;

import com.sipgate.li.lib.x1.server.handler.status.PingHandler;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.etsi.uri._03221.x1._2017._10.PingResponse;
import org.junit.jupiter.api.Test;

class PingHandlerTest {

  final PingHandler underTest = new PingHandler();

  @Test
  void itReturnsPingOk() {
    // WHEN
    final PingResponse actual = underTest.handle(null);
    // THEN
    assertThat(actual.getOK()).isEqualTo(OK.ACKNOWLEDGED_AND_COMPLETED);
  }
}
