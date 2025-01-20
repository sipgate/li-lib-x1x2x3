/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.protocol.error;

public class UnsupportedRequestException extends ErrorResponseException {

  public UnsupportedRequestException() {
    super(UNSUPPORTED_REQUEST);
  }
}
