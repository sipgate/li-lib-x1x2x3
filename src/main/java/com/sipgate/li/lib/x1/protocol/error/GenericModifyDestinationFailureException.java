package com.sipgate.li.lib.x1.protocol.error;

public class GenericModifyDestinationFailureException extends GenericException {

  public GenericModifyDestinationFailureException(final Exception e) {
    super(GENERIC_MODIFYDESTINATION_FAILURE, e);
  }
}
