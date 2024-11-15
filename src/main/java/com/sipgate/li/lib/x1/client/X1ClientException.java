package com.sipgate.li.lib.x1.client;

import java.io.IOException;

public class X1ClientException extends IOException {

  public X1ClientException() {}

  public X1ClientException(final String message) {
    super(message);
  }

  public X1ClientException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
