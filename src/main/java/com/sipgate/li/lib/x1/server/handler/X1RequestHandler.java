package com.sipgate.li.lib.x1.server.handler;

import com.sipgate.li.lib.x1.protocol.error.X1ErrorException;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;
import org.etsi.uri._03221.x1._2017._10.X1ResponseMessage;

public interface X1RequestHandler<REQ extends X1RequestMessage, RESP extends X1ResponseMessage> {
  RESP handle(REQ request) throws X1ErrorException;

  Class<? extends X1RequestMessage> getRequestClass();
}
