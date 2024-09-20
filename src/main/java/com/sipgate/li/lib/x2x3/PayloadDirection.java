package com.sipgate.li.lib.x2x3;

public enum PayloadDirection {
  RESERVED_FOR_KEEPALIVE(0),
  UNKNOWN(1),
  SENT_TO_TARGET(2),
  SENT_FROM_TARGET(3),
  MORE_THAN_ONE_DIRECTION(4),
  NOT_APPLICABLE(5);

  private final int value;

  PayloadDirection(final int value) {
    this.value = value;
  }

  public static PayloadDirection fromValue(final int value) {
    for (final var payloadDirection : values()) {
      if (payloadDirection.value == value) {
        return payloadDirection;
      }
    }
    throw new IllegalArgumentException("Unknown payload direction: " + value);
  }
}
