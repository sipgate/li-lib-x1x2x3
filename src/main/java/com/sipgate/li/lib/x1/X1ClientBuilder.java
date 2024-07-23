package com.sipgate.li.lib.x1;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.nio.file.Path;
import java.security.*;
import java.security.cert.CertificateException;
import javax.net.ssl.*;

public class X1ClientBuilder {

  private Path pathToKeyStore;
  private String keyStorePassword;

  private Path pathToTrustStore;
  private String trustStorePassword;

  private String sslProtocol = "TLSv1.3";
  private URI target;

  private X1ClientBuilder() {}

  public static X1ClientBuilder newBuilder() {
    return new X1ClientBuilder();
  }

  public X1ClientBuilder withTarget(final URI target) {
    this.target = target;
    return this;
  }

  public X1ClientBuilder withKeyStore(
    final Path pathToKeyStore,
    final String keyStorePassword
  ) {
    this.pathToKeyStore = pathToKeyStore;
    this.keyStorePassword = keyStorePassword;
    return this;
  }

  public X1ClientBuilder withTrustStore(
    final Path pathToTrustStore,
    final String trustStorePassword
  ) {
    this.pathToTrustStore = pathToTrustStore;
    this.trustStorePassword = trustStorePassword;
    return this;
  }

  public X1ClientBuilder withSslProtocol(final String sslProtocol) {
    this.sslProtocol = sslProtocol;
    return this;
  }

  private HttpClient buildHttpClient()
    throws UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
    final var context = SSLContext.getInstance(sslProtocol);
    final var keyManagers = getKeyManagers();
    final var trustManagers = getTrustManagers();

    // Context initialization expects null for default key and trustmanagers if system key- or truststore should be used
    context.init(
      keyManagers.length == 0 ? null : keyManagers,
      trustManagers.length == 0 ? null : trustManagers,
      new SecureRandom()
    );

    return HttpClient.newBuilder().sslContext(context).build();
  }

  public X1Client build() {
    try {
      if (target == null) {
        throw new IllegalArgumentException("Target URI is required");
      }

      return new X1Client(target, buildHttpClient());
    } catch (final Exception e) {
      throw new X1ClientBuilderException("Failed to build X1Client", e);
    }
  }

  private KeyManager[] getKeyManagers()
    throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException, UnrecoverableKeyException {
    if (pathToKeyStore == null) {
      return new KeyManager[] {};
    }
    final File keystoreFile = pathToKeyStore.toFile();

    if (
      !keystoreFile.exists() ||
      !keystoreFile.canRead() ||
      !keystoreFile.isFile()
    ) {
      throw new IllegalArgumentException(
        String.format("Invalid keystore path: %s", pathToKeyStore)
      );
    }

    final var keyStore = KeyStore.getInstance(
      keystoreFile,
      keyStorePassword.toCharArray()
    );
    final KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(
      "PKIX"
    );
    keyManagerFactory.init(keyStore, keyStorePassword.toCharArray());
    return keyManagerFactory.getKeyManagers();
  }

  private TrustManager[] getTrustManagers()
    throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
    if (pathToTrustStore == null) {
      return new TrustManager[] {};
    }
    final File trustStoreFile = pathToTrustStore.toFile();

    if (
      !trustStoreFile.exists() ||
      !trustStoreFile.canRead() ||
      !trustStoreFile.isFile()
    ) {
      throw new IllegalArgumentException(
        String.format("Invalid truststore path: %s", pathToTrustStore)
      );
    }

    final var trustStore = KeyStore.getInstance(
      trustStoreFile,
      trustStorePassword.toCharArray()
    );
    final var trustManagerFactory = TrustManagerFactory.getInstance("PKIX");
    trustManagerFactory.init(trustStore);
    return trustManagerFactory.getTrustManagers();
  }
}
