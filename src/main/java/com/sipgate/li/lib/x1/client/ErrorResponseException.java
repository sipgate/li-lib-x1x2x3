package com.sipgate.li.lib.x1.client;

import org.etsi.uri._03221.x1._2017._10.ErrorResponse;

public class ErrorResponseException extends X1ClientException {

  private final ErrorResponse errorResponse;

  public ErrorResponseException(final ErrorResponse errorResponse) {
    this.errorResponse = errorResponse;
  }

  public ErrorResponse getErrorResponse() {
    return errorResponse;
  }
}
