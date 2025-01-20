/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.security.NoSuchProviderException;
import javax.net.ssl.SSLContext;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SSLContextBuilderTest {

  @Test
  void it_creates_a_context_with_only_a_custom_keystore() throws Exception {
    // GIVEN
    final var pathToKeyStore = Path.of(getClass().getClassLoader().getResource("keystore.pfx").getPath());
    final var keyStorePassword = "password";

    // WHEN
    final var sslContext = SSLContextBuilder.newBuilder().withKeyStore(pathToKeyStore, keyStorePassword).build();

    // THEN
    assertValidSSLContext(sslContext);
  }

  @Test
  void it_creates_a_context_with_only_a_custom_truststore() throws Exception {
    // GIVEN
    final var pathToKeyStore = Path.of(getClass().getClassLoader().getResource("keystore.pfx").getPath());
    final var keyStorePassword = "password";

    // WHEN
    final var sslContext = SSLContextBuilder.newBuilder().withTrustStore(pathToKeyStore, keyStorePassword).build();

    // THEN
    assertValidSSLContext(sslContext);
  }

  @Test
  void it_creates_a_context_with_both_a_custom_truststore_and_keystore() throws Exception {
    // GIVEN
    final var path = Path.of(getClass().getClassLoader().getResource("keystore.pfx").getPath());
    final var password = "password";

    // WHEN
    final var sslContext = SSLContextBuilder.newBuilder()
      .withTrustStore(path, password)
      .withKeyStore(path, password)
      .build();

    // THEN
    assertValidSSLContext(sslContext);
  }

  @Test
  void it_creates_a_context_with_a_custom_ssl_protocol() throws Exception {
    // GIVEN
    final var sslProtocol = "TLSv1.2";

    // WHEN
    final var sslContext = SSLContextBuilder.newBuilder().withSslProtocol(sslProtocol).build();

    // THEN
    assertThat(sslContext.getProtocol()).isEqualTo(sslProtocol);
  }

  @Test
  void it_throws_when_the_keystore_path_is_invalid() {
    // GIVEN
    final var pathString = "invalid/path/to/keystore.pfx";
    final var pathToKeyStore = Path.of(pathString);
    final var keyStorePassword = "password";

    // WHEN
    assertThatThrownBy(() -> SSLContextBuilder.newBuilder().withKeyStore(pathToKeyStore, keyStorePassword).build())
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Invalid keystore path: " + pathString);
  }

  @Test
  void it_throws_when_the_truststore_path_is_invalid() {
    // GIVEN
    final var pathString = "invalid/path/to/keystore.pfx";
    final var pathToTrustStore = Path.of(pathString);
    final var trustStorePassword = "password";

    // WHEN
    assertThatThrownBy(() -> SSLContextBuilder.newBuilder().withTrustStore(pathToTrustStore, trustStorePassword).build()
    )
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Invalid truststore path: " + pathString);
  }

  @Test
  void it_throws_when_both_the_truststore_path_and_the_keystore_path_are_invalid() {
    // GIVEN
    final var pathString = "invalid/path/to/keystore.pfx";
    final var path = Path.of(pathString);
    final var password = "password";

    // WHEN
    assertThatThrownBy(() ->
      SSLContextBuilder.newBuilder().withTrustStore(path, password).withKeyStore(path, password).build()
    )
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Invalid keystore path: " + pathString);
  }

  @Test
  void it_fails_when_a_unknown_key_store_provider_is_given() {
    // GIVEN
    final var path = Path.of(getClass().getClassLoader().getResource("keystore.pfx").getPath());
    final var password = "password";

    // WHEN
    assertThatThrownBy(() ->
      SSLContextBuilder.newBuilder()
        .withTrustStore(path, password)
        .withKeyStore(path, password)
        .withKeyStoreProvider("kaputt")
        .build()
    ).isInstanceOf(NoSuchProviderException.class);
  }

  @Test
  void it_fails_when_a_unknown_trust_store_provider_is_given() {
    // GIVEN
    final var path = Path.of(getClass().getClassLoader().getResource("keystore.pfx").getPath());
    final var password = "password";

    // WHEN
    assertThatThrownBy(() ->
      SSLContextBuilder.newBuilder()
        .withTrustStore(path, password)
        .withKeyStore(path, password)
        .withTrustStoreProvider("kaputt")
        .build()
    ).isInstanceOf(NoSuchProviderException.class);
  }

  private void assertValidSSLContext(final SSLContext sslContext) {
    assertNotNull(sslContext);
    assertThat(sslContext.getProtocol()).isEqualTo("TLSv1.3");
  }
}
