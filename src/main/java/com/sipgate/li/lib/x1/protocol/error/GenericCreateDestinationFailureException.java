/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.protocol.error;

public class GenericCreateDestinationFailureException extends GenericBaseException {

  public GenericCreateDestinationFailureException(final Exception e) {
    super(GENERIC_CREATEDESTINATION_FAILURE, e);
  }
}
