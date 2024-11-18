package com.sipgate.li.lib.x1.protocol.error;

import java.math.BigInteger;

public abstract class ErrorResponseException extends Exception {

  public static final BigInteger GENERIC_ERROR = BigInteger.valueOf(1000);
  public static final BigInteger SYNTAX_SCHEMA_ERROR = BigInteger.valueOf(1010);
  public static final BigInteger UNSUPPORTED_VERSION = BigInteger.valueOf(1020);
  public static final BigInteger UNSUPPORTED_REQUEST = BigInteger.valueOf(1080);

  public static final BigInteger XID_ALREADY_EXISTS = BigInteger.valueOf(2010);
  public static final BigInteger XID_DOES_NOT_EXIST = BigInteger.valueOf(2020);
  public static final BigInteger DID_ALREADY_EXISTS = BigInteger.valueOf(2030);
  public static final BigInteger DID_DOES_NOT_EXIST = BigInteger.valueOf(2040);

  public static final BigInteger GENERIC_ACTIVATETASK_FAILURE = BigInteger.valueOf(3000);
  public static final BigInteger GENERIC_MODIFYTASK_FAILURE = BigInteger.valueOf(3001);
  public static final BigInteger INVALID_COMBINATION_OF_DELIVERYTYPE_AND_DESTINATIONS = BigInteger.valueOf(3040);

  public static final BigInteger GENERIC_DEACTIVATETASK_FAILURE = BigInteger.valueOf(4000);

  public static final BigInteger GENERIC_CREATEDESTINATION_FAILURE = BigInteger.valueOf(6000);
  public static final BigInteger GENERIC_MODIFYDESTINATION_FAILURE = BigInteger.valueOf(6001);

  public static final BigInteger GENERIC_REMOVEDESTINATION_FAILURE = BigInteger.valueOf(7000);
  public static final BigInteger DESTINATION_IN_USE = BigInteger.valueOf(7010);

  private final BigInteger errorCode;
  private final String errorDescription;

  protected ErrorResponseException(final BigInteger errorCode) {
    this(errorCode, null);
  }

  protected ErrorResponseException(final BigInteger errorCode, final String errorDescription) {
    super(errorDescription);
    this.errorCode = errorCode;
    this.errorDescription = errorDescription;
  }

  public BigInteger getErrorCode() {
    return errorCode;
  }

  public String getErrorDescription() {
    return errorDescription;
  }
}
