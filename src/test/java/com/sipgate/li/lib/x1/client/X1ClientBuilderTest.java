/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import com.sipgate.util.SSLContextBuilder;
import java.io.IOException;
import java.net.URI;
import java.security.*;
import java.security.cert.CertificateException;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class X1ClientBuilderTest {

  @Test
  void it_creates_a_client_with_only_a_target_uri() {
    // GIVEN
    final var target = URI.create("https://localhost/X1/NE");

    // WHEN
    final var x1Client = X1ClientBuilder.newBuilder().withTarget(target).build();

    // THEN
    assertValidX1Client(x1Client, "Default");
  }

  @Test
  void it_creates_a_client_with_a_valid_sslcontext()
    throws UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, NoSuchProviderException, KeyManagementException {
    // GIVEN
    final var target = URI.create("https://localhost/X1/NE");
    final var sslContext = SSLContextBuilder.newBuilder().build();

    // WHEN
    final var x1Client = X1ClientBuilder.newBuilder().withTarget(target).withContext(sslContext).build();

    // THEN
    assertValidX1Client(x1Client, "TLSv1.3");
  }

  @Test
  void it_fails_to_create_a_client_without_a_target() {
    // GIVEN
    final var expectedCause = IllegalArgumentException.class;
    final var expectedMessage = "Target URI is required";

    // WHEN + THEN
    assertThatThrownBy(() -> X1ClientBuilder.newBuilder().build())
      .isInstanceOf(X1ClientBuilderException.class)
      .hasCauseInstanceOf(expectedCause)
      .hasRootCauseMessage(expectedMessage);
  }

  private void assertValidX1Client(final X1Client client, final String sslProtocol) {
    assertThat(client.httpClient.sslContext().getProtocol()).isEqualTo(sslProtocol);
  }
}
