package com.sipgate.li.lib.x1.server.handler.task;

import com.sipgate.li.lib.x1.server.DeliveryTypeCompatibleValidator;
import com.sipgate.li.lib.x1.server.entity.TaskFactory;
import com.sipgate.li.lib.x1.server.handler.X1RequestHandler;
import com.sipgate.li.lib.x1.server.listener.TaskListener;
import com.sipgate.li.lib.x1.server.repository.TaskRepository;
import org.etsi.uri._03221.x1._2017._10.ModifyTaskRequest;
import org.etsi.uri._03221.x1._2017._10.ModifyTaskResponse;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;

public class ModifyTaskHandler implements X1RequestHandler<ModifyTaskRequest, ModifyTaskResponse> {

  private final TaskRepository taskRepository;
  private final DeliveryTypeCompatibleValidator deliveryTypeCompatibleValidator;
  private final TaskListener taskListener;

  public ModifyTaskHandler(
    final TaskRepository taskRepository,
    final DeliveryTypeCompatibleValidator deliveryTypeCompatibleValidator,
    final TaskListener taskListener
  ) {
    this.taskRepository = taskRepository;
    this.deliveryTypeCompatibleValidator = deliveryTypeCompatibleValidator;
    this.taskListener = taskListener;
  }

  @Override
  public ModifyTaskResponse handle(final ModifyTaskRequest request) {
    final var task = TaskFactory.create(request.getTaskDetails());
    deliveryTypeCompatibleValidator.validate(task);

    taskListener.onTaskModifyRequest(task);
    taskRepository.update(task);
    taskListener.onTaskModified(task);

    final var resp = new ModifyTaskResponse();
    resp.setOK(OK.ACKNOWLEDGED_AND_COMPLETED);
    return resp;
  }

  @Override
  public Class<? extends X1RequestMessage> getRequestClass() {
    return ModifyTaskRequest.class;
  }
}
