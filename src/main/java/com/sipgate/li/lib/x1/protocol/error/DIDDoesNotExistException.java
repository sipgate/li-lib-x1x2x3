package com.sipgate.li.lib.x1.protocol.error;

import java.util.UUID;

public class DIDDoesNotExistException extends X1ErrorException {

  public DIDDoesNotExistException(final UUID dID) {
    super(DID_DOES_NOT_EXIST, dID.toString());
  }
}
