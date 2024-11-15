package com.sipgate.li.lib.x1.protocol.error;

public class GenericDeactivateTaskFailureException extends GenericException {

  public GenericDeactivateTaskFailureException(final Exception e) {
    super(GENERIC_DEACTIVATETASK_FAILURE, e);
  }
}
