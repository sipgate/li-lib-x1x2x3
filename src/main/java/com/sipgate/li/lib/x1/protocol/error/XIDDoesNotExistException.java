package com.sipgate.li.lib.x1.protocol.error;

import java.util.UUID;

public class XIDDoesNotExistException extends ErrorResponseException {

  public XIDDoesNotExistException(final UUID xID) {
    super(XID_DOES_NOT_EXIST, xID.toString());
  }
}
