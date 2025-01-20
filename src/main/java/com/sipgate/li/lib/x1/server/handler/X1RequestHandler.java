/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.server.handler;

import com.sipgate.li.lib.x1.protocol.error.ErrorResponseException;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;
import org.etsi.uri._03221.x1._2017._10.X1ResponseMessage;

public interface X1RequestHandler<REQ extends X1RequestMessage, RESP extends X1ResponseMessage> {
  RESP handle(REQ request) throws ErrorResponseException;

  Class<? extends X1RequestMessage> getRequestClass();
}
