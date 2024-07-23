package com.sipgate.li.lib.x1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.net.URI;
import java.nio.file.Path;
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
    final var x1Client = X1ClientBuilder.newBuilder()
      .withTarget(target)
      .build();

    // THEN
    assertValidX1Client(x1Client);
  }

  @Test
  void it_creates_a_client_with_only_a_custom_keystore() {
    // GIVEN
    final var target = URI.create("https://localhost/X1/NE");
    final var pathToKeyStore = Path.of(
      getClass().getClassLoader().getResource("keystore.pfx").getPath()
    );
    final var keyStorePassword = "password";

    // WHEN
    final var x1Client = X1ClientBuilder.newBuilder()
      .withTarget(target)
      .withKeyStore(pathToKeyStore, keyStorePassword)
      .build();

    // THEN
    assertValidX1Client(x1Client);
  }

  @Test
  void it_creates_a_client_with_only_a_custom_truststore() {
    // GIVEN
    final var target = URI.create("https://localhost/X1/NE");
    final var pathToKeyStore = Path.of(
      getClass().getClassLoader().getResource("keystore.pfx").getPath()
    );
    final var keyStorePassword = "password";

    // WHEN
    final var x1Client = X1ClientBuilder.newBuilder()
      .withTarget(target)
      .withTrustStore(pathToKeyStore, keyStorePassword)
      .build();

    // THEN
    assertValidX1Client(x1Client);
  }

  @Test
  void it_creates_a_client_with_both_a_custom_keystore_and_truststore() {
    // GIVEN
    final var target = URI.create("https://localhost/X1/NE");
    final var path = Path.of(
      getClass().getClassLoader().getResource("keystore.pfx").getPath()
    );
    final var password = "password";

    // WHEN
    final var x1Client = X1ClientBuilder.newBuilder()
      .withTarget(target)
      .withKeyStore(path, password)
      .withTrustStore(path, password)
      .build();

    // THEN
    assertValidX1Client(x1Client);
  }

  @Test
  void it_creates_a_client_with_a_custom_ssl_protocol() {
    // GIVEN
    final var target = URI.create("https://localhost/X1/NE");
    final var sslProtocol = "TLSv1.2";

    // WHEN
    final var x1Client = X1ClientBuilder.newBuilder()
      .withTarget(target)
      .withSslProtocol(sslProtocol)
      .build();

    // THEN
    assertValidX1Client(x1Client, sslProtocol);
  }

  @Test
  void it_throws_when_the_keystore_path_is_invalid() {
    // GIVEN
    final var target = URI.create("https://localhost/X1/NE");
    final var pathString = "invalid/path/to/keystore.pfx";
    final var pathToKeyStore = Path.of(pathString);
    final var keyStorePassword = "password";

    // WHEN + THEN
    assertThatThrownBy(() ->
      X1ClientBuilder.newBuilder()
        .withTarget(target)
        .withKeyStore(pathToKeyStore, keyStorePassword)
        .build()
    )
      .isInstanceOf(X1ClientBuilderException.class)
      .hasRootCauseInstanceOf(IllegalArgumentException.class)
      .hasRootCauseMessage("Invalid keystore path: " + pathString);
  }

  @Test
  void it_throws_when_the_truststore_path_is_invalid() {
    // GIVEN
    final var target = URI.create("https://localhost/X1/NE");
    final var pathString = "invalid/path/to/truststore.pfx";
    final var pathToTrustStore = Path.of(pathString);
    final var trustStorePassword = "password";

    // WHEN + THEN
    assertThatThrownBy(() ->
      X1ClientBuilder.newBuilder()
        .withTarget(target)
        .withTrustStore(pathToTrustStore, trustStorePassword)
        .build()
    )
      .isInstanceOf(X1ClientBuilderException.class)
      .hasRootCauseInstanceOf(IllegalArgumentException.class)
      .hasRootCauseMessage("Invalid truststore path: " + pathString);
  }

  @Test
  void it_throws_when_both_truststore_and_keystore_paths_are_invalid() {
    // GIVEN
    final var target = URI.create("https://localhost/X1/NE");
    final var path = Path.of("invalid/path/to/keystore.pfx");
    final var password = "password";

    // WHEN + THEN
    assertThatThrownBy(() ->
      X1ClientBuilder.newBuilder()
        .withTarget(target)
        .withKeyStore(path, password)
        .withTrustStore(path, password)
        .build()
    )
      .isInstanceOf(X1ClientBuilderException.class)
      .hasRootCauseInstanceOf(IllegalArgumentException.class);
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

  private void assertValidX1Client(final X1Client client) {
    assertValidX1Client(client, "TLSv1.3");
  }

  private void assertValidX1Client(
    final X1Client client,
    final String sslProtocol
  ) {
    assertThat(client.httpClient.sslContext().getProtocol()).isEqualTo(
      sslProtocol
    );
  }
}
