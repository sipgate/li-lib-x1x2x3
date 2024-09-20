package com.sipgate.li.lib.x2x3;

public enum PduType {
  X2_PDU(1),
  X3_PDU(2),
  KEEPALIVE(3),
  KEEPALIVE_ACK(4);

  final int value;

  PduType(final int value) {
    this.value = value;
  }

  public static PduType fromValue(final int value) {
    for (final var pduType : values()) {
      if (pduType.value == value) {
        return pduType;
      }
    }
    throw new IllegalArgumentException("Unknown PDU type: " + value);
  }
}
