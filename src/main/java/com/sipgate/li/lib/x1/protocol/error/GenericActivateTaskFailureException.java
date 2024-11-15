package com.sipgate.li.lib.x1.protocol.error;

public class GenericActivateTaskFailureException extends GenericException {

  public GenericActivateTaskFailureException(final Exception e) {
    super(GENERIC_ACTIVATETASK_FAILURE, e);
  }
}
