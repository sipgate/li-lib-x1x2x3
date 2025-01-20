/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.protocol.error;

import java.util.UUID;

public class XIDAlreadyExistsException extends ErrorResponseException {

  public XIDAlreadyExistsException(final UUID xID) {
    super(XID_ALREADY_EXISTS, xID.toString());
  }
}
