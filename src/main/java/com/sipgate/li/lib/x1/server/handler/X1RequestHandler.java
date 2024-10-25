package com.sipgate.li.lib.x1.server.handler;

import java.util.Optional;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;
import org.etsi.uri._03221.x1._2017._10.X1ResponseMessage;

/** common interfaces for all handlers to allow spring service discovery */
public interface X1RequestHandler<REQ extends X1RequestMessage, RESP extends X1ResponseMessage> {
  RESP handle(REQ request);

  Class<? extends X1RequestMessage> getRequestClass();
}
