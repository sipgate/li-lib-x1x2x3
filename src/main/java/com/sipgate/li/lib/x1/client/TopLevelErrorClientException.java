package com.sipgate.li.lib.x1.client;

import org.etsi.uri._03221.x1._2017._10.TopLevelErrorResponse;

public class TopLevelErrorClientException extends X1ClientException {

  private final TopLevelErrorResponse topLevelErrorResponse;

  public TopLevelErrorClientException(final TopLevelErrorResponse topLevelErrorResponse) {
    this.topLevelErrorResponse = topLevelErrorResponse;
  }

  public TopLevelErrorResponse getTopLevelErrorResponse() {
    return topLevelErrorResponse;
  }
}
