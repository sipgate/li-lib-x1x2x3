package com.sipgate.li.lib.x1.server.handler.status;

import com.sipgate.li.lib.x1.server.handler.X1RequestHandler;
import org.etsi.uri._03221.x1._2017._10.KeepaliveRequest;
import org.etsi.uri._03221.x1._2017._10.KeepaliveResponse;
import org.etsi.uri._03221.x1._2017._10.OK;

public class KeepaliveHandler implements X1RequestHandler<KeepaliveRequest, KeepaliveResponse> {

  @Override
  public KeepaliveResponse handle(final KeepaliveRequest request) {
    return KeepaliveResponse.builder().withOK(OK.ACKNOWLEDGED_AND_COMPLETED).build();
  }

  /** this will be used as a key in the map of handlers in X1Server */
  @Override
  public Class<KeepaliveRequest> getRequestClass() {
    return KeepaliveRequest.class;
  }
}
