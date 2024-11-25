package com.sipgate.li.lib.x1.client;

import java.io.IOException;

/*

X1 Client Exceptions
---------------------
The X1 Client exceptions are organized under the primary category:

- X1ClientException
  Represents any exception occurring in the X1 Client.

  Subcategories:
  1. TopLevelErrorClientException
     Containing TopLevelErrorResponse

  2. ErrorResponseClientException
     Containing ErrorResponse

 */
public class X1ClientException extends IOException {

  public X1ClientException() {}

  public X1ClientException(final String message) {
    super(message);
  }

  public X1ClientException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
