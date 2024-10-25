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

  public GetAllDetailsHandler(final TaskRepository taskRepository, final DestinationRepository destinationRepository) {
    this.taskRepository = taskRepository;
    this.destinationRepository = destinationRepository;
  }

  @Override
  public GetAllDetailsResponse handle(final GetAllDetailsRequest request) {
    final var taskResponseDetailsList = taskRepository.getAllTasks().stream().map(TaskFactory::create).toList();
    final var listOfTaskResponseDetails = new ListOfTaskResponseDetails();
    listOfTaskResponseDetails.getTaskResponseDetails().addAll(taskResponseDetailsList);

    final var destinationResponseDetailsList = destinationRepository
      .getAllDestinations()
      .stream()
      .map(DestinationFactory::create)
      .toList();
    final var listOfDestinationResponseDetails = new ListOfDestinationResponseDetails();
    listOfDestinationResponseDetails.getDestinationResponseDetails().addAll(destinationResponseDetailsList);

    final var neStatusDetails = new NeStatusDetails();
    neStatusDetails.setNeStatus(NeStatus.OK);

    final var response = new GetAllDetailsResponse();
    response.setNeStatusDetails(neStatusDetails);
    response.setListOfTaskResponseDetails(listOfTaskResponseDetails);
    response.setListOfGenericObjectResponseDetails(new ListOfGenericObjectResponseDetails());
    response.setListOfDestinationResponseDetails(listOfDestinationResponseDetails);
    return response;
  }

  @Override
  public Class<? extends X1RequestMessage> getRequestClass() {
    return GetAllDetailsRequest.class;
  }
}
