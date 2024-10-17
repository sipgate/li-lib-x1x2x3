package com.sipgate.li.lib.x1.protocol;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class X1VersionTest {

  @Test
  void test_own_version() {
    assertTrue(X1Version.isCompatible(X1Version.VERSION));
  }

  @ParameterizedTest
  @ValueSource(strings = { "v1.1.1", "v1.2.3", "v1.234.0" })
  void test_positive(final String candidate) {
    assertTrue(X1Version.isCompatible(candidate));
  }

  @ParameterizedTest
  @ValueSource(strings = { "v0.1.2", "v2.2", "v42.234.1" })
  void test_negative(final String candidate) {
    assertFalse(X1Version.isCompatible(candidate));
  }

  @ParameterizedTest
  @ValueSource(strings = { "v0", "BAD VERSION", "v22341" })
  @NullAndEmptySource
  void test_invalid_semver(final String candidate) {
    assertFalse(X1Version.isCompatible(candidate));
  }
}
