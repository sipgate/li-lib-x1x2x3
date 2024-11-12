package com.sipgate.li.lib.x1.server.handler.task;

import com.sipgate.li.lib.x1.server.entity.TaskFactory;
import com.sipgate.li.lib.x1.server.handler.X1RequestHandler;
import com.sipgate.li.lib.x1.server.repository.TaskRepository;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.GetTaskDetailsRequest;
import org.etsi.uri._03221.x1._2017._10.GetTaskDetailsResponse;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;

public class GetTaskDetailsHandler implements X1RequestHandler<GetTaskDetailsRequest, GetTaskDetailsResponse> {

  private final TaskRepository taskRepository;

  public GetTaskDetailsHandler(final TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public GetTaskDetailsResponse handle(final GetTaskDetailsRequest request) {
    final var maybeTask = taskRepository.findByXID(UUID.fromString(request.getXId()));

    if (maybeTask.isEmpty()) {
      throw new NoSuchElementException("Task not found: " + request.getXId());
    }

    final var task = maybeTask.get();

    final var response = new GetTaskDetailsResponse();
    response.setTaskResponseDetails(TaskFactory.create(task));

    return response;
  }

  @Override
  public Class<? extends X1RequestMessage> getRequestClass() {
    return GetTaskDetailsRequest.class;
  }
}