package com.sipgate.li.lib.x1.protocol.error;

public class GenericRemoveDestinationFailureException extends GenericException {

  public GenericRemoveDestinationFailureException(final Exception e) {
    super(GENERIC_REMOVEDESTINATION_FAILURE, e);
  }
}
