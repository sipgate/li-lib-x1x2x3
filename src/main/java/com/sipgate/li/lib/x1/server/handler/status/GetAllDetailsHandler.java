package com.sipgate.li.lib.x1.server.handler.status;

import com.sipgate.li.lib.x1.server.entity.DestinationFactory;
import com.sipgate.li.lib.x1.server.entity.TaskFactory;
import com.sipgate.li.lib.x1.server.handler.X1RequestHandler;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import com.sipgate.li.lib.x1.server.repository.TaskRepository;
import org.etsi.uri._03221.x1._2017._10.GetAllDetailsRequest;
import org.etsi.uri._03221.x1._2017._10.GetAllDetailsResponse;
import org.etsi.uri._03221.x1._2017._10.ListOfDestinationResponseDetails;
import org.etsi.uri._03221.x1._2017._10.ListOfGenericObjectResponseDetails;
import org.etsi.uri._03221.x1._2017._10.ListOfTaskResponseDetails;
import org.etsi.uri._03221.x1._2017._10.NeStatus;
import org.etsi.uri._03221.x1._2017._10.NeStatusDetails;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;

public class GetAllDetailsHandler implements X1RequestHandler<GetAllDetailsRequest, GetAllDetailsResponse> {

  private final TaskRepository taskRepository;
  private final DestinationRepository destinationRepository;
  private final TaskFactory taskFactory;

  public GetAllDetailsHandler(
    final TaskRepository taskRepository,
    final DestinationRepository destinationRepository,
    final TaskFactory taskFactory
  ) {
    this.taskRepository = taskRepository;
    this.destinationRepository = destinationRepository;
    this.taskFactory = taskFactory;
  }

  @Override
  public GetAllDetailsResponse handle(final GetAllDetailsRequest request) {
    return GetAllDetailsResponse.builder()
      .withNeStatusDetails(NeStatusDetails.builder().withNeStatus(NeStatus.OK).build())
      .withListOfTaskResponseDetails(
        ListOfTaskResponseDetails.builder()
          .withTaskResponseDetails(taskRepository.getAllTasks().stream().map(TaskFactory::create).toList())
          .build()
      )
      .withListOfGenericObjectResponseDetails(new ListOfGenericObjectResponseDetails())
      .withListOfDestinationResponseDetails(
        ListOfDestinationResponseDetails.builder()
          .withDestinationResponseDetails(
            destinationRepository.getAllDestinations().stream().map(DestinationFactory::create).toList()
          )
          .build()
      )
      .build();
  }

  @Override
  public Class<? extends X1RequestMessage> getRequestClass() {
    return GetAllDetailsRequest.class;
  }
}
