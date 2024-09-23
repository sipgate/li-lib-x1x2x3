package com.sipgate.li.lib.x2x3;

public class PduValidationException extends IllegalArgumentException {

  private final String fieldName;

  public PduValidationException(final String message, final String fieldName) {
    super(message + ": " + fieldName);
    this.fieldName = fieldName;
  }

  public String getFieldName() {
    return fieldName;
  }
}
