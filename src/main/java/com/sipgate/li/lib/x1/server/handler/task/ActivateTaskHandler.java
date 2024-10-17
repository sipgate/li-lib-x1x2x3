package com.sipgate.li.lib.x1.server.handler.task;

import com.sipgate.li.lib.x1.server.DeliveryTypeCompatibleValidator;
import com.sipgate.li.lib.x1.server.entity.TaskFactory;
import com.sipgate.li.lib.x1.server.handler.X1RequestHandler;
import com.sipgate.li.lib.x1.server.listener.TaskListener;
import com.sipgate.li.lib.x1.server.repository.TaskRepository;
import org.etsi.uri._03221.x1._2017._10.ActivateTaskRequest;
import org.etsi.uri._03221.x1._2017._10.ActivateTaskResponse;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;

public class ActivateTaskHandler implements X1RequestHandler<ActivateTaskRequest, ActivateTaskResponse> {

  private final TaskRepository taskRepository;
  private final DeliveryTypeCompatibleValidator deliveryTypeCompatibleValidator;
  private final TaskListener taskListener;

  public ActivateTaskHandler(
    final TaskRepository taskRepository,
    final DeliveryTypeCompatibleValidator deliveryTypeCompatibleValidator,
    final TaskListener taskListener
  ) {
    this.taskRepository = taskRepository;
    this.deliveryTypeCompatibleValidator = deliveryTypeCompatibleValidator;
    this.taskListener = taskListener;
  }

  @Override
  public ActivateTaskResponse handle(final ActivateTaskRequest request) {
    final var task = TaskFactory.create(request.getTaskDetails());

    deliveryTypeCompatibleValidator.validate(task);

    taskListener.onTaskActivateRequest(task);
    taskRepository.insert(task);
    taskListener.onTaskActivated(task);

    final var response = new ActivateTaskResponse();
    response.setOK(OK.ACKNOWLEDGED_AND_COMPLETED);
    return response;
  }

  @Override
  public Class<? extends X1RequestMessage> getRequestClass() {
    return ActivateTaskRequest.class;
  }
}
