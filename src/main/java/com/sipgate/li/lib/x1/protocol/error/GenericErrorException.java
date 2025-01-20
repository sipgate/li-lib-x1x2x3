/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.protocol.error;

public class GenericErrorException extends GenericBaseException {

  public GenericErrorException(final Exception e) {
    super(GENERIC_ERROR, e);
  }
}
