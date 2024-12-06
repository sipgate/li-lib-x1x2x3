package com.sipgate.li.lib.x1.protocol.error;

import java.util.Optional;
import org.etsi.uri._03221.x1._2017._10.ActivateTaskRequest;
import org.etsi.uri._03221.x1._2017._10.CreateDestinationRequest;
import org.etsi.uri._03221.x1._2017._10.CreateObjectRequest;
import org.etsi.uri._03221.x1._2017._10.DeactivateAllTasksRequest;
import org.etsi.uri._03221.x1._2017._10.DeactivateTaskRequest;
import org.etsi.uri._03221.x1._2017._10.DeleteAllObjectsRequest;
import org.etsi.uri._03221.x1._2017._10.DeleteObjectRequest;
import org.etsi.uri._03221.x1._2017._10.ErrorInformation;
import org.etsi.uri._03221.x1._2017._10.ErrorResponse;
import org.etsi.uri._03221.x1._2017._10.GetAllDestinationDetailsRequest;
import org.etsi.uri._03221.x1._2017._10.GetAllDetailsRequest;
import org.etsi.uri._03221.x1._2017._10.GetAllGenericObjectDetailsRequest;
import org.etsi.uri._03221.x1._2017._10.GetAllTaskDetailsRequest;
import org.etsi.uri._03221.x1._2017._10.GetDestinationDetailsRequest;
import org.etsi.uri._03221.x1._2017._10.GetNEStatusRequest;
import org.etsi.uri._03221.x1._2017._10.GetObjectRequest;
import org.etsi.uri._03221.x1._2017._10.GetTaskDetailsRequest;
import org.etsi.uri._03221.x1._2017._10.KeepaliveRequest;
import org.etsi.uri._03221.x1._2017._10.ListAllDetailsRequest;
import org.etsi.uri._03221.x1._2017._10.ListObjectsOfTypeRequest;
import org.etsi.uri._03221.x1._2017._10.ModifyDestinationRequest;
import org.etsi.uri._03221.x1._2017._10.ModifyObjectRequest;
import org.etsi.uri._03221.x1._2017._10.ModifyTaskRequest;
import org.etsi.uri._03221.x1._2017._10.PingRequest;
import org.etsi.uri._03221.x1._2017._10.RemoveAllDestinationsRequest;
import org.etsi.uri._03221.x1._2017._10.RemoveDestinationRequest;
import org.etsi.uri._03221.x1._2017._10.ReportDestinationIssueRequest;
import org.etsi.uri._03221.x1._2017._10.ReportNEIssueRequest;
import org.etsi.uri._03221.x1._2017._10.ReportTaskIssueRequest;
import org.etsi.uri._03221.x1._2017._10.RequestMessageType;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;

public class ErrorResponseFactory {

  private ErrorResponseFactory() {}

  public static ErrorResponse makeErrorResponse(
    final ErrorResponseException exception,
    final X1RequestMessage requestMessage
  ) {
    return ErrorResponse.builder()
      .withErrorInformation(
        ErrorInformation.builder()
          .withErrorCode(exception.getErrorCode())
          .withErrorDescription(exception.getErrorDescription())
          .build()
      )
      .withRequestMessageType(getRequestMessageType(requestMessage))
      .build();
  }

  private static RequestMessageType getRequestMessageType(final X1RequestMessage requestMessage) {
    return switch (requestMessage) {
      case final ActivateTaskRequest ignore -> RequestMessageType.ACTIVATE_TASK;
      case final ModifyTaskRequest ignore -> RequestMessageType.MODIFY_TASK;
      case final DeactivateTaskRequest ignore -> RequestMessageType.DEACTIVATE_TASK;
      case final DeactivateAllTasksRequest ignore -> RequestMessageType.DEACTIVATE_ALL_TASKS;
      case final GetTaskDetailsRequest ignore -> RequestMessageType.GET_TASK_DETAILS;
      case final CreateDestinationRequest ignore -> RequestMessageType.CREATE_DESTINATION;
      case final ModifyDestinationRequest ignore -> RequestMessageType.MODIFY_DESTINATION;
      case final RemoveDestinationRequest ignore -> RequestMessageType.REMOVE_DESTINATION;
      case final RemoveAllDestinationsRequest ignore -> RequestMessageType.REMOVE_ALL_DESTINATIONS;
      case final GetDestinationDetailsRequest ignore -> RequestMessageType.GET_DESTINATION_DETAILS;
      case final GetNEStatusRequest ignore -> RequestMessageType.GET_NE_STATUS;
      case final GetAllDetailsRequest ignore -> RequestMessageType.GET_ALL_DETAILS;
      case final GetAllTaskDetailsRequest ignore -> RequestMessageType.GET_ALL_TASK_DETAILS;
      case final GetAllDestinationDetailsRequest ignore -> RequestMessageType.GET_ALL_DESTINATION_DETAILS;
      case final GetAllGenericObjectDetailsRequest ignore -> RequestMessageType.GET_ALL_GENERIC_OBJECT_DETAILS;
      case final ListAllDetailsRequest ignore -> RequestMessageType.LIST_ALL_DETAILS;
      case final ReportTaskIssueRequest ignore -> RequestMessageType.REPORT_TASK_ISSUE;
      case final ReportDestinationIssueRequest ignore -> RequestMessageType.REPORT_DESTINATION_ISSUE;
      case final ReportNEIssueRequest ignore -> RequestMessageType.REPORT_NE_ISSUE;
      case final PingRequest ignore -> RequestMessageType.PING;
      case final KeepaliveRequest ignore -> RequestMessageType.KEEPALIVE;
      case final CreateObjectRequest ignore -> RequestMessageType.CREATE_OBJECT;
      case final ModifyObjectRequest ignore -> RequestMessageType.MODIFY_OBJECT;
      case final GetObjectRequest ignore -> RequestMessageType.GET_OBJECT;
      case final DeleteObjectRequest ignore -> RequestMessageType.DELETE_OBJECT;
      case final ListObjectsOfTypeRequest ignore -> RequestMessageType.LIST_OBJECTS_OF_TYPE;
      case final DeleteAllObjectsRequest ignore -> RequestMessageType.DELETE_ALL_OBJECTS;
      default -> null;
    };
  }
}
