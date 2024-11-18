package com.sipgate.li.lib.x1.protocol.error;

public class GenericModifyTaskFailureException extends GenericBaseException {

  public GenericModifyTaskFailureException(final Exception e) {
    super(GENERIC_MODIFYTASK_FAILURE, e);
  }
}
