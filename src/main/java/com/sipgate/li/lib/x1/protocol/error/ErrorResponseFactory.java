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
    final var errorInformation = new ErrorInformation();
    errorInformation.setErrorCode(exception.getErrorCode());
    errorInformation.setErrorDescription(exception.getErrorDescription());

    final var errorResponse = new ErrorResponse();
    errorResponse.setErrorInformation(errorInformation);
    getRequestMessageType(requestMessage).ifPresent(errorResponse::setRequestMessageType);
    return errorResponse;
  }

  private static Optional<RequestMessageType> getRequestMessageType(final X1RequestMessage requestMessage) {
    return switch (requestMessage) {
      case final ActivateTaskRequest ignore -> Optional.of(RequestMessageType.ACTIVATE_TASK);
      case final ModifyTaskRequest ignore -> Optional.of(RequestMessageType.MODIFY_TASK);
      case final DeactivateTaskRequest ignore -> Optional.of(RequestMessageType.DEACTIVATE_TASK);
      case final DeactivateAllTasksRequest ignore -> Optional.of(RequestMessageType.DEACTIVATE_ALL_TASKS);
      case final GetTaskDetailsRequest ignore -> Optional.of(RequestMessageType.GET_TASK_DETAILS);
      case final CreateDestinationRequest ignore -> Optional.of(RequestMessageType.CREATE_DESTINATION);
      case final ModifyDestinationRequest ignore -> Optional.of(RequestMessageType.MODIFY_DESTINATION);
      case final RemoveDestinationRequest ignore -> Optional.of(RequestMessageType.REMOVE_DESTINATION);
      case final RemoveAllDestinationsRequest ignore -> Optional.of(RequestMessageType.REMOVE_ALL_DESTINATIONS);
      case final GetDestinationDetailsRequest ignore -> Optional.of(RequestMessageType.GET_DESTINATION_DETAILS);
      case final GetNEStatusRequest ignore -> Optional.of(RequestMessageType.GET_NE_STATUS);
      case final GetAllDetailsRequest ignore -> Optional.of(RequestMessageType.GET_ALL_DETAILS);
      case final GetAllTaskDetailsRequest ignore -> Optional.of(RequestMessageType.GET_ALL_TASK_DETAILS);
      case final GetAllDestinationDetailsRequest ignore -> Optional.of(RequestMessageType.GET_ALL_DESTINATION_DETAILS);
      case final GetAllGenericObjectDetailsRequest ignore -> Optional.of(
        RequestMessageType.GET_ALL_GENERIC_OBJECT_DETAILS
      );
      case final ListAllDetailsRequest ignore -> Optional.of(RequestMessageType.LIST_ALL_DETAILS);
      case final ReportTaskIssueRequest ignore -> Optional.of(RequestMessageType.REPORT_TASK_ISSUE);
      case final ReportDestinationIssueRequest ignore -> Optional.of(RequestMessageType.REPORT_DESTINATION_ISSUE);
      case final ReportNEIssueRequest ignore -> Optional.of(RequestMessageType.REPORT_NE_ISSUE);
      case final PingRequest ignore -> Optional.of(RequestMessageType.PING);
      case final KeepaliveRequest ignore -> Optional.of(RequestMessageType.KEEPALIVE);
      case final CreateObjectRequest ignore -> Optional.of(RequestMessageType.CREATE_OBJECT);
      case final ModifyObjectRequest ignore -> Optional.of(RequestMessageType.MODIFY_OBJECT);
      case final GetObjectRequest ignore -> Optional.of(RequestMessageType.GET_OBJECT);
      case final DeleteObjectRequest ignore -> Optional.of(RequestMessageType.DELETE_OBJECT);
      case final ListObjectsOfTypeRequest ignore -> Optional.of(RequestMessageType.LIST_OBJECTS_OF_TYPE);
      case final DeleteAllObjectsRequest ignore -> Optional.of(RequestMessageType.DELETE_ALL_OBJECTS);
      default -> Optional.empty();
    };
  }
}
