/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.protocol.error;

public class GenericModifyDestinationFailureException extends GenericBaseException {

  public GenericModifyDestinationFailureException(final Exception e) {
    super(GENERIC_MODIFYDESTINATION_FAILURE, e);
  }
}
