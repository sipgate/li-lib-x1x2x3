package com.sipgate.util;

import java.util.Arrays;

public abstract class ArrayUtils {

  public static byte[] concat(final byte[] first, final byte[] second) {
    final var result = Arrays.copyOf(first, first.length + second.length);
    System.arraycopy(second, 0, result, first.length, second.length);
    return result;
  }
}
