package com.sipgate.li.lib.x1.client;

import java.io.IOException;
import org.etsi.uri._03221.x1._2017._10.TopLevelErrorResponse;

public class X1ClientException extends IOException {

  private final TopLevelErrorResponse topLevelErrorResponse;

  public X1ClientException(final String message) {
    super(message);
    topLevelErrorResponse = null;
  }

  public X1ClientException(final String message, final Throwable cause) {
    super(message, cause);
    topLevelErrorResponse = null;
  }

  public X1ClientException(final String message, final TopLevelErrorResponse topLevelErrorResponse) {
    super(message);
    this.topLevelErrorResponse = topLevelErrorResponse;
  }

  public TopLevelErrorResponse getTopLevelErrorResponse() {
    return topLevelErrorResponse;
  }
}
