package com.sipgate.li.lib.x1.protocol.error;

public class UnsupportedVersionException extends X1ErrorException {

  public UnsupportedVersionException(final String supportedVersion) {
    super(UNSUPPORTED_VERSION, supportedVersion);
  }
}
