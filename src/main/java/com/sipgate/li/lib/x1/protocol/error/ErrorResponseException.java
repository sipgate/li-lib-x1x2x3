package com.sipgate.li.lib.x1.protocol.error;

import java.math.BigInteger;

/*

================================================================================
X1 Exception Hierarchy
================================================================================

X1 Server Exceptions
---------------------
The X1 Server exceptions are organized under the primary category:

- ErrorResponseException
  Represents business-related exceptions occurring in the X1 Server.

  Subcategories:
  1. GenericBaseException
     General-purpose exceptions that are not highly specific.

     - Generic*XYZ*Exception:
       Specific to a topic but does not describe precise causes.
       Indicates "something went wrong in a specific area" without exact details.
       Example: GenericCreateDestinationFailureException

     - GenericErrorException:
       Non-specific errors originating from standard exceptions.
       Indicates "something went wrong" but provides no detail about "where" or "what."

  2. *SPECIFIC*Exception
     Highly specific exceptions, often providing helpful details such as IDs or
     exact causes. These indicate both "where" and "what" went wrong.
     Example: InvalidCombinationOfDeliveryTypeAndDestinationsException

For client exceptions see X1ClientException.

*/
public abstract class ErrorResponseException extends Exception {

  // We've only implemented the exceptions that our implementation uses. Feel free to add more if required.
  // Check for the suggested details in ETSI TS 103 221-1, Table 46: Error codes
  public static final BigInteger GENERIC_ERROR = BigInteger.valueOf(1000);
  public static final BigInteger SYNTAX_SCHEMA_ERROR = BigInteger.valueOf(1010);
  public static final BigInteger UNSUPPORTED_VERSION = BigInteger.valueOf(1020);
  public static final BigInteger ADMF_IDENTIFIER_DOES_NOT_MATCH_CERTIFICATE_DETAILS = BigInteger.valueOf(1030);
  public static final BigInteger UNEXPECTED_ADMF_IDENTIFIER = BigInteger.valueOf(1040);
  public static final BigInteger NE_IDENTIFIER_DOES_NOT_MATCH_CERTIFICATE_DETAILS = BigInteger.valueOf(1050);
  public static final BigInteger UNEXPECTED_NE_IDENTIFIER = BigInteger.valueOf(1060);
  public static final BigInteger KEEPALIVE_NOT_SUPPORTED = BigInteger.valueOf(1070);
  public static final BigInteger UNSUPPORTED_REQUEST = BigInteger.valueOf(1080);

  public static final BigInteger XID_ALREADY_EXISTS = BigInteger.valueOf(2010);
  public static final BigInteger XID_DOES_NOT_EXIST = BigInteger.valueOf(2020);
  public static final BigInteger DID_ALREADY_EXISTS = BigInteger.valueOf(2030);
  public static final BigInteger DID_DOES_NOT_EXIST = BigInteger.valueOf(2040);
  public static final BigInteger GENERICOBJECTID_ALREADY_EXISTS = BigInteger.valueOf(2050);
  public static final BigInteger GENERICOBJECTID_DOES_NOT_EXIST = BigInteger.valueOf(2060);

  public static final BigInteger GENERIC_ACTIVATETASK_FAILURE = BigInteger.valueOf(3000);
  public static final BigInteger GENERIC_MODIFYTASK_FAILURE = BigInteger.valueOf(3001);
  public static final BigInteger UNSUPPORTED_TARGETIDENTIFIER_TYPE = BigInteger.valueOf(3010);
  public static final BigInteger UNSUPPORTED_COMBINATION_OF_TARGETIDENTIFIERS = BigInteger.valueOf(3020);
  public static final BigInteger MULTIPLE_DESTINATIONS_NOT_SUPPORTED = BigInteger.valueOf(3030);
  public static final BigInteger INVALID_COMBINATION_OF_DELIVERYTYPE_AND_DESTINATIONS = BigInteger.valueOf(3040);

  public static final BigInteger UNSUPPORTED_SERVICETYPE = BigInteger.valueOf(3050);

  public static final BigInteger GENERIC_DEACTIVATETASK_FAILURE = BigInteger.valueOf(4000);

  public static final BigInteger GENERIC_DEACTIVEALLTASKS_FAILURE = BigInteger.valueOf(5000);
  public static final BigInteger DEACTIVATEALLTASKS_NOT_ENABLED = BigInteger.valueOf(5010);

  public static final BigInteger GENERIC_CREATEDESTINATION_FAILURE = BigInteger.valueOf(6000);
  public static final BigInteger GENERIC_MODIFYDESTINATION_FAILURE = BigInteger.valueOf(6001);
  public static final BigInteger UNSUPPORTED_DELIVERYADDRESS_TYPE = BigInteger.valueOf(6020);

  public static final BigInteger GENERIC_REMOVEDESTINATION_FAILURE = BigInteger.valueOf(7000);
  public static final BigInteger DESTINATION_IN_USE = BigInteger.valueOf(7010);

  public static final BigInteger GENERIC_REMOVEALLDESTINATIONS_FAILURE = BigInteger.valueOf(8000);
  public static final BigInteger DESTINATIONS_IN_USE = BigInteger.valueOf(8010);
  public static final BigInteger REMOVEALLDESTINATIONS_NOT_ENABLED = BigInteger.valueOf(8020);

  public static final BigInteger GENERIC_CREATEOBJECT_FAILURE = BigInteger.valueOf(8500);
  public static final BigInteger GENERIC_MODIFYOBJECT_FAILURE = BigInteger.valueOf(8510);
  public static final BigInteger GENERIC_DELETEOBJECT_FAILURE = BigInteger.valueOf(8530);
  public static final BigInteger GENERIC_DELETEALLOBJECTS_FAILURE = BigInteger.valueOf(8540);
  public static final BigInteger DELETEALLOBJECTS_NOT_ENABLED = BigInteger.valueOf(8550);

  public static final BigInteger ERROR_CLEARED = BigInteger.valueOf(9000);
  public static final BigInteger GENERIC_WARNING = BigInteger.valueOf(9010);
  public static final BigInteger GENERIC_NON_TERMINATING_FAULT = BigInteger.valueOf(9020);
  public static final BigInteger TERMINATING_FAULT = BigInteger.valueOf(9030);
  public static final BigInteger REQUEST_ACTIONED = BigInteger.valueOf(9040);
  public static final BigInteger KEEPALIVES_NOT_RECEIVED = BigInteger.valueOf(9050);

  public static final BigInteger DATABASE_CLEARED = BigInteger.valueOf(10000);

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
