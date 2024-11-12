package com.sipgate.li.lib.x1.protocol.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericErrorException extends X1ErrorException {

  private static final Logger LOGGER = LoggerFactory.getLogger(GenericErrorException.class);

  public GenericErrorException(final Exception e) {
    // don't expose possibly confidential information from generic exception
    super(GENERIC_ERROR);
    // but write everything to the log so developers can debug
    LOGGER.error("generic error", e);
  }
}
