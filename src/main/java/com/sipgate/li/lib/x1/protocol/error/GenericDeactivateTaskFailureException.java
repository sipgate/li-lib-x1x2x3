package com.sipgate.li.lib.x1.protocol.error;

public class GenericDeactivateTaskFailureException extends GenericBaseException {

  public GenericDeactivateTaskFailureException(final Exception e) {
    super(GENERIC_DEACTIVATETASK_FAILURE, e);
  }
}
