/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.client;

import java.net.URI;
import java.net.http.HttpClient;
import javax.net.ssl.*;

public class X1ClientBuilder {

  private URI target;
  private SSLContext context;

  private X1ClientBuilder() {}

  public static X1ClientBuilder newBuilder() {
    return new X1ClientBuilder();
  }

  public X1ClientBuilder withTarget(final URI target) {
    this.target = target;
    return this;
  }

  public X1ClientBuilder withContext(final SSLContext context) {
    this.context = context;
    return this;
  }

  private HttpClient buildHttpClient() {
    return HttpClient.newBuilder().sslContext(context).build();
  }

  public X1Client build() {
    try {
      if (target == null) {
        throw new IllegalArgumentException("Target URI is required");
      }

      if (context == null) {
        context = SSLContext.getDefault();
      }

      return new X1Client(target, buildHttpClient());
    } catch (final Exception e) {
      throw new X1ClientBuilderException("Failed to build X1Client", e);
    }
  }
}
