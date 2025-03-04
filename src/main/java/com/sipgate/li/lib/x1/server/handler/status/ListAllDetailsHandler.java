/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.server.handler.status;

import com.sipgate.li.lib.x1.server.entity.Destination;
import com.sipgate.li.lib.x1.server.entity.Task;
import com.sipgate.li.lib.x1.server.handler.X1RequestHandler;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import com.sipgate.li.lib.x1.server.repository.TaskRepository;
import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.ListAllDetailsRequest;
import org.etsi.uri._03221.x1._2017._10.ListAllDetailsResponse;
import org.etsi.uri._03221.x1._2017._10.ListOfDids;
import org.etsi.uri._03221.x1._2017._10.ListOfXids;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;

public class ListAllDetailsHandler implements X1RequestHandler<ListAllDetailsRequest, ListAllDetailsResponse> {

  private final TaskRepository taskRepository;
  private final DestinationRepository destinationRepository;

  public ListAllDetailsHandler(final TaskRepository taskRepository, final DestinationRepository destinationRepository) {
    this.taskRepository = taskRepository;
    this.destinationRepository = destinationRepository;
  }

  @Override
  public ListAllDetailsResponse handle(final ListAllDetailsRequest request) {
    return ListAllDetailsResponse.builder()
      .withListOfXIDs(
        ListOfXids.builder()
          .withXId(taskRepository.getAllTasks().stream().map(Task::xID).map(UUID::toString).toList())
          .build()
      )
      .withListOfDIDs(
        ListOfDids.builder()
          .withDId(
            destinationRepository.getAllDestinations().stream().map(Destination::dID).map(UUID::toString).toList()
          )
          .build()
      )
      .build();
  }

  @Override
  public Class<? extends X1RequestMessage> getRequestClass() {
    return ListAllDetailsRequest.class;
  }
}
