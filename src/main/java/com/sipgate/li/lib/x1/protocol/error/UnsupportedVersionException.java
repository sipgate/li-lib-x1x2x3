/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.protocol.error;

public class UnsupportedVersionException extends ErrorResponseException {

  public UnsupportedVersionException(final String supportedVersion) {
    super(UNSUPPORTED_VERSION, supportedVersion);
  }
}
