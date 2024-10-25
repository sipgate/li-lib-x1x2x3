package com.sipgate.li.lib.x1.protocol;

public class X1Version {

  private static final String MAJOR_VERSION = "v1";
  public static final String VERSION = MAJOR_VERSION + ".15.1";

  /**
   * Only major version changes break compatibility. See: TS 103.221-1, Section 4.5 Release Management.
   */
  public static boolean isCompatible(final String candidateVersion) {
    if (null == candidateVersion || !candidateVersion.contains(".")) {
      return false;
    }

    final var majorVersion = (candidateVersion.substring(0, candidateVersion.indexOf(".")));

    return MAJOR_VERSION.equals(majorVersion);
  }
}
