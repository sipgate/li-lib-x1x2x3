package com.sipgate.li.lib.x1.protocol.error;

public class UnsupportedRequestException extends X1ErrorException {

  public UnsupportedRequestException() {
    super(UNSUPPORTED_REQUEST);
  }
}
