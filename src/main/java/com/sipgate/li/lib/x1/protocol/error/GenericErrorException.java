package com.sipgate.li.lib.x1.protocol.error;

public class GenericErrorException extends GenericException {

  public GenericErrorException(final Exception e) {
    super(GENERIC_ERROR, e);
  }
}
