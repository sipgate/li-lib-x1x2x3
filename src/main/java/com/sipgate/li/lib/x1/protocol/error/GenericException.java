package com.sipgate.li.lib.x1.protocol.error;

import java.math.BigInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class GenericException extends X1ErrorException {

  private static final Logger LOGGER = LoggerFactory.getLogger(GenericException.class);

  protected GenericException(final BigInteger errorCode, final Exception e) {
    // don't expose possibly confidential information from generic exception
    super(errorCode);
    // but write everything to the log so developers can debug
    LOGGER.error("generic error", e);
  }
}
