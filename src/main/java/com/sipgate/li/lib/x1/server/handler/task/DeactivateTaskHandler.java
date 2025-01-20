/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.server.handler.task;

import com.sipgate.li.lib.x1.protocol.error.GenericDeactivateTaskFailureException;
import com.sipgate.li.lib.x1.protocol.error.XIDDoesNotExistException;
import com.sipgate.li.lib.x1.server.handler.X1RequestHandler;
import com.sipgate.li.lib.x1.server.listener.TaskListener;
import com.sipgate.li.lib.x1.server.repository.TaskRepository;
import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.DeactivateTaskRequest;
import org.etsi.uri._03221.x1._2017._10.DeactivateTaskResponse;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;

public class DeactivateTaskHandler implements X1RequestHandler<DeactivateTaskRequest, DeactivateTaskResponse> {

  private final TaskRepository taskRepository;
  private final TaskListener taskListener;

  public DeactivateTaskHandler(final TaskRepository taskRepository, final TaskListener taskListener) {
    this.taskRepository = taskRepository;
    this.taskListener = taskListener;
  }

  @Override
  public DeactivateTaskResponse handle(final DeactivateTaskRequest request)
    throws XIDDoesNotExistException, GenericDeactivateTaskFailureException {
    try {
      final var response = new DeactivateTaskResponse();

      final var xId = UUID.fromString(request.getXId());
      taskListener.onTaskDeactivateRequest(xId);
      taskRepository.deleteByXID(xId);
      taskListener.onTaskDeactivated(xId);

      response.setOK(OK.ACKNOWLEDGED_AND_COMPLETED);
      return response;
    } catch (final RuntimeException e) {
      throw new GenericDeactivateTaskFailureException(e);
    }
  }

  @Override
  public Class<? extends X1RequestMessage> getRequestClass() {
    return DeactivateTaskRequest.class;
  }
}
