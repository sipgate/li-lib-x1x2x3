package com.sipgate.li.lib.x1.protocol.error;

import java.util.UUID;

public class DIDAlreadyExistsException extends X1ErrorException {

  public DIDAlreadyExistsException(final UUID dID) {
    super(DID_ALREADY_EXISTS, dID.toString());
  }
}
