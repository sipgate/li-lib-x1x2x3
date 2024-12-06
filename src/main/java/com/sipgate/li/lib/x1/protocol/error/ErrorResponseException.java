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
  public static final long GENERIC_ERROR = 1000L;
  public static final long SYNTAX_SCHEMA_ERROR = 1010L;
  public static final long UNSUPPORTED_VERSION = 1020L;
  public static final long ADMF_IDENTIFIER_DOES_NOT_MATCH_CERTIFICATE_DETAILS = 1030L;
  public static final long UNEXPECTED_ADMF_IDENTIFIER = 1040L;
  public static final long NE_IDENTIFIER_DOES_NOT_MATCH_CERTIFICATE_DETAILS = 1050L;
  public static final long UNEXPECTED_NE_IDENTIFIER = 1060L;
  public static final long KEEPALIVE_NOT_SUPPORTED = 1070L;
  public static final long UNSUPPORTED_REQUEST = 1080L;

  public static final long XID_ALREADY_EXISTS = 2010L;
  public static final long XID_DOES_NOT_EXIST = 2020L;
  public static final long DID_ALREADY_EXISTS = 2030L;
  public static final long DID_DOES_NOT_EXIST = 2040L;
  public static final long GENERICOBJECTID_ALREADY_EXISTS = 2050L;
  public static final long GENERICOBJECTID_DOES_NOT_EXIST = 2060L;

  public static final long GENERIC_ACTIVATETASK_FAILURE = 3000L;
  public static final long GENERIC_MODIFYTASK_FAILURE = 3001L;
  public static final long UNSUPPORTED_TARGETIDENTIFIER_TYPE = 3010L;
  public static final long UNSUPPORTED_COMBINATION_OF_TARGETIDENTIFIERS = 3020L;
  public static final long MULTIPLE_DESTINATIONS_NOT_SUPPORTED = 3030L;
  public static final long INVALID_COMBINATION_OF_DELIVERYTYPE_AND_DESTINATIONS = 3040L;

  public static final long UNSUPPORTED_SERVICETYPE = 3050L;

  public static final long GENERIC_DEACTIVATETASK_FAILURE = 4000L;

  public static final long GENERIC_DEACTIVEALLTASKS_FAILURE = 5000L;
  public static final long DEACTIVATEALLTASKS_NOT_ENABLED = 5010L;

  public static final long GENERIC_CREATEDESTINATION_FAILURE = 6000L;
  public static final long GENERIC_MODIFYDESTINATION_FAILURE = 6001L;
  public static final long UNSUPPORTED_DELIVERYADDRESS_TYPE = 6020L;

  public static final long GENERIC_REMOVEDESTINATION_FAILURE = 7000L;
  public static final long DESTINATION_IN_USE = 7010L;

  public static final long GENERIC_REMOVEALLDESTINATIONS_FAILURE = 8000L;
  public static final long DESTINATIONS_IN_USE = 8010L;
  public static final long REMOVEALLDESTINATIONS_NOT_ENABLED = 8020L;

  public static final long GENERIC_CREATEOBJECT_FAILURE = 8500L;
  public static final long GENERIC_MODIFYOBJECT_FAILURE = 8510L;
  public static final long GENERIC_DELETEOBJECT_FAILURE = 8530L;
  public static final long GENERIC_DELETEALLOBJECTS_FAILURE = 8540L;
  public static final long DELETEALLOBJECTS_NOT_ENABLED = 8550L;

  public static final long ERROR_CLEARED = 9000L;
  public static final long GENERIC_WARNING = 9010L;
  public static final long GENERIC_NON_TERMINATING_FAULT = 9020L;
  public static final long TERMINATING_FAULT = 9030L;
  public static final long REQUEST_ACTIONED = 9040L;
  public static final long KEEPALIVES_NOT_RECEIVED = 9050L;

  public static final long DATABASE_CLEARED = 10000L;

  private final long errorCode;
  private final String errorDescription;

  protected ErrorResponseException(final long errorCode) {
    this(errorCode, null);
  }

  protected ErrorResponseException(final long errorCode, final String errorDescription) {
    super(errorDescription);
    this.errorCode = errorCode;
    this.errorDescription = errorDescription;
  }

  public long getErrorCode() {
    return errorCode;
  }

  public String getErrorDescription() {
    return errorDescription;
  }
}
