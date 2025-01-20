/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x2x3.protocol;

public enum PayloadFormat {
  RESERVED(0, false, false),
  ETSI_102_232_1(1, true, true),
  _3GPP_33_128(2, true, true),
  _3GPP_33_108(3, true, true),
  PROPRIETARY(4, true, true),
  IP_V4(5, true, true),
  IP_V6(6, true, true),
  ETHERNET(7, false, true),
  RTP(8, false, true),
  SIP(9, true, false),
  DHCP(10, true, false),
  RADIUS(11, true, false),
  GTP_U(12, false, true),
  MSRP(13, false, true),
  _3GPPP_33_108_EPS_IRI_CONTENT(14, true, false),
  MIME(15, true, true),
  _3GPP_UNSTRUCTURED_PDU(16, false, true);

  public final int value;

  public final boolean x2allowed;
  public final boolean x3allowed;

  PayloadFormat(final int value, final boolean x2allowed, final boolean x3allowed) {
    this.value = value;
    this.x2allowed = x2allowed;
    this.x3allowed = x3allowed;
  }

  public static PayloadFormat fromValue(final int value) {
    for (final var payloadFormat : values()) {
      if (payloadFormat.value == value) {
        return payloadFormat;
      }
    }
    throw new IllegalArgumentException("Unknown payload format: " + value);
  }
}
