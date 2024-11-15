package com.sipgate.li.lib.x1.protocol.error;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class DIDDoesNotExistException extends X1ErrorException {

  public DIDDoesNotExistException(final UUID dID) {
    super(DID_DOES_NOT_EXIST, dID.toString());
  }

  public DIDDoesNotExistException(final Collection<UUID> dIDs) {
    super(DID_DOES_NOT_EXIST, String.join(",", dIDs.stream().map(UUID::toString).collect(Collectors.toSet())));
  }
}
