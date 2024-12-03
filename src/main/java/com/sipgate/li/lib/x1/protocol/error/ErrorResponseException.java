package com.sipgate.li.lib.x1.protocol.error;

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
  public static final Integer GENERIC_ERROR = 1000;
  public static final Integer SYNTAX_SCHEMA_ERROR = 1010;
  public static final Integer UNSUPPORTED_VERSION = 1020;
  public static final Integer ADMF_IDENTIFIER_DOES_NOT_MATCH_CERTIFICATE_DETAILS = 1030;
  public static final Integer UNEXPECTED_ADMF_IDENTIFIER = 1040;
  public static final Integer NE_IDENTIFIER_DOES_NOT_MATCH_CERTIFICATE_DETAILS = 1050;
  public static final Integer UNEXPECTED_NE_IDENTIFIER = 1060;
  public static final Integer KEEPALIVE_NOT_SUPPORTED = 1070;
  public static final Integer UNSUPPORTED_REQUEST = 1080;

  public static final Integer XID_ALREADY_EXISTS = 2010;
  public static final Integer XID_DOES_NOT_EXIST = 2020;
  public static final Integer DID_ALREADY_EXISTS = 2030;
  public static final Integer DID_DOES_NOT_EXIST = 2040;
  public static final Integer GENERICOBJECTID_ALREADY_EXISTS = 2050;
  public static final Integer GENERICOBJECTID_DOES_NOT_EXIST = 2060;

  public static final Integer GENERIC_ACTIVATETASK_FAILURE = 3000;
  public static final Integer GENERIC_MODIFYTASK_FAILURE = 3001;
  public static final Integer UNSUPPORTED_TARGETIDENTIFIER_TYPE = 3010;
  public static final Integer UNSUPPORTED_COMBINATION_OF_TARGETIDENTIFIERS = 3020;
  public static final Integer MULTIPLE_DESTINATIONS_NOT_SUPPORTED = 3030;
  public static final Integer INVALID_COMBINATION_OF_DELIVERYTYPE_AND_DESTINATIONS = 3040;

  public static final Integer UNSUPPORTED_SERVICETYPE = 3050;

  public static final Integer GENERIC_DEACTIVATETASK_FAILURE = 4000;

  public static final Integer GENERIC_DEACTIVEALLTASKS_FAILURE = 5000;
  public static final Integer DEACTIVATEALLTASKS_NOT_ENABLED = 5010;

  public static final Integer GENERIC_CREATEDESTINATION_FAILURE = 6000;
  public static final Integer GENERIC_MODIFYDESTINATION_FAILURE = 6001;
  public static final Integer UNSUPPORTED_DELIVERYADDRESS_TYPE = 6020;

  public static final Integer GENERIC_REMOVEDESTINATION_FAILURE = 7000;
  public static final Integer DESTINATION_IN_USE = 7010;

  public static final Integer GENERIC_REMOVEALLDESTINATIONS_FAILURE = 8000;
  public static final Integer DESTINATIONS_IN_USE = 8010;
  public static final Integer REMOVEALLDESTINATIONS_NOT_ENABLED = 8020;

  public static final Integer GENERIC_CREATEOBJECT_FAILURE = 8500;
  public static final Integer GENERIC_MODIFYOBJECT_FAILURE = 8510;
  public static final Integer GENERIC_DELETEOBJECT_FAILURE = 8530;
  public static final Integer GENERIC_DELETEALLOBJECTS_FAILURE = 8540;
  public static final Integer DELETEALLOBJECTS_NOT_ENABLED = 8550;

  public static final Integer ERROR_CLEARED = 9000;
  public static final Integer GENERIC_WARNING = 9010;
  public static final Integer GENERIC_NON_TERMINATING_FAULT = 9020;
  public static final Integer TERMINATING_FAULT = 9030;
  public static final Integer REQUEST_ACTIONED = 9040;
  public static final Integer KEEPALIVES_NOT_RECEIVED = 9050;

  public static final Integer DATABASE_CLEARED = 10000;

  private final Integer errorCode;
  private final String errorDescription;

  protected ErrorResponseException(final Integer errorCode) {
    this(errorCode, null);
  }

  protected ErrorResponseException(final Integer errorCode, final String errorDescription) {
    super(errorDescription);
    this.errorCode = errorCode;
    this.errorDescription = errorDescription;
  }

  public Integer getErrorCode() {
    return errorCode;
  }

  public String getErrorDescription() {
    return errorDescription;
  }
}
