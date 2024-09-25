package com.sipgate.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Objects;
import javax.net.ssl.*;

public class SSLContextBuilder {

  private String keyStoreProvider;
  private Path pathToKeyStore;
  private String keyStorePassword;

  private String trustStoreProvider;
  private Path pathToTrustStore;
  private String trustStorePassword;

  private String sslProtocol = "TLSv1.3";

  private SSLContextBuilder() {}

  public static SSLContextBuilder newBuilder() {
    return new SSLContextBuilder();
  }

  public SSLContextBuilder withKeyStoreProvider(final String keyStoreProvider) {
    this.keyStoreProvider = keyStoreProvider;
    return this;
  }

  public SSLContextBuilder withKeyStore(final Path pathToKeyStore, final String keyStorePassword) {
    this.pathToKeyStore = pathToKeyStore;
    this.keyStorePassword = keyStorePassword;
    return this;
  }

  public SSLContextBuilder withTrustStoreProvider(final String trustStoreProvider) {
    this.trustStoreProvider = trustStoreProvider;
    return this;
  }

  public SSLContextBuilder withTrustStore(final Path pathToTrustStore, final String trustStorePassword) {
    this.pathToTrustStore = pathToTrustStore;
    this.trustStorePassword = trustStorePassword;
    return this;
  }

  public SSLContextBuilder withSslProtocol(final String sslProtocol) {
    this.sslProtocol = sslProtocol;
    return this;
  }

  public SSLContext build()
    throws KeyManagementException, UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, NoSuchProviderException {
    final var context = SSLContext.getInstance(sslProtocol);

    final var keyManagers = getKeyManagers();
    final var trustManagers = getTrustManagers();

    // Context initialization expects null for default key and trustmanagers if system key- or truststore should be used
    context.init(
      keyManagers.length == 0 ? null : keyManagers,
      trustManagers.length == 0 ? null : trustManagers,
      new SecureRandom()
    );

    return context;
  }

  private KeyManager[] getKeyManagers()
    throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException, UnrecoverableKeyException, NoSuchProviderException {
    if (pathToKeyStore == null) {
      return new KeyManager[] {};
    }
    final File keystoreFile = pathToKeyStore.toFile();

    if (!keystoreFile.exists() || !keystoreFile.canRead() || !keystoreFile.isFile()) {
      throw new IllegalArgumentException(String.format("Invalid keystore path: %s", pathToKeyStore));
    }

    final var keyStore = KeyStore.getInstance(
      KeyStore.getDefaultType(),
      Objects.requireNonNullElse(keyStoreProvider, "SUN")
    );

    try (final var keyStoreFileStream = new FileInputStream(keystoreFile)) {
      keyStore.load(keyStoreFileStream, keyStorePassword.toCharArray());
    }

    final KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("PKIX");
    keyManagerFactory.init(keyStore, keyStorePassword.toCharArray());
    return keyManagerFactory.getKeyManagers();
  }

  private TrustManager[] getTrustManagers()
    throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, NoSuchProviderException {
    if (pathToTrustStore == null) {
      return new TrustManager[] {};
    }
    final File trustStoreFile = pathToTrustStore.toFile();

    if (!trustStoreFile.exists() || !trustStoreFile.canRead() || !trustStoreFile.isFile()) {
      throw new IllegalArgumentException(String.format("Invalid truststore path: %s", pathToTrustStore));
    }

    final var trustStore = KeyStore.getInstance(
      KeyStore.getDefaultType(),
      Objects.requireNonNullElse(trustStoreProvider, "SUN")
    );

    try (final var trustStoreFileStream = new FileInputStream(trustStoreFile)) {
      trustStore.load(trustStoreFileStream, trustStorePassword.toCharArray());
    }

    final var trustManagerFactory = TrustManagerFactory.getInstance("PKIX");
    trustManagerFactory.init(trustStore);
    return trustManagerFactory.getTrustManagers();
  }
}
