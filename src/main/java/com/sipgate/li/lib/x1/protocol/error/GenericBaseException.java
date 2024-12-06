package com.sipgate.li.lib.x1.protocol.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class GenericBaseException extends ErrorResponseException {

  private static final Logger LOGGER = LoggerFactory.getLogger(GenericBaseException.class);

  protected GenericBaseException(final long errorCode, final Exception e) {
    // don't expose possibly confidential information from generic exception
    super(errorCode);
    // but write everything to the log so developers can debug
    LOGGER.error("generic error", e);
  }
}
