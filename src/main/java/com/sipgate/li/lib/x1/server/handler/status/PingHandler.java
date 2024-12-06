package com.sipgate.li.lib.x1.server.handler.status;

import com.sipgate.li.lib.x1.server.handler.X1RequestHandler;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.etsi.uri._03221.x1._2017._10.PingRequest;
import org.etsi.uri._03221.x1._2017._10.PingResponse;

public class PingHandler implements X1RequestHandler<PingRequest, PingResponse> {

  @Override
  public PingResponse handle(final PingRequest request) {
    final var result = new PingResponse();
    result.setOK(OK.ACKNOWLEDGED_AND_COMPLETED);
    return result;
  }

  @Override
  public Class<PingRequest> getRequestClass() {
    return PingRequest.class;
  }
}
