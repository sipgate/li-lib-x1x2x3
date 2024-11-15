package com.sipgate.li.lib.x1.protocol.error;

public class GenericCreateDestinationFailureException extends GenericException {

  public GenericCreateDestinationFailureException(final Exception e) {
    super(GENERIC_CREATEDESTINATION_FAILURE, e);
  }
}
