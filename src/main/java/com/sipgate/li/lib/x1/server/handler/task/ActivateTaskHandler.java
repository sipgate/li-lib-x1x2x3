/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.server.handler.task;

import com.sipgate.li.lib.x1.protocol.error.DIDDoesNotExistException;
import com.sipgate.li.lib.x1.protocol.error.GenericActivateTaskFailureException;
import com.sipgate.li.lib.x1.protocol.error.InvalidCombinationOfDeliveryTypeAndDestinationsException;
import com.sipgate.li.lib.x1.protocol.error.SyntaxSchemaErrorException;
import com.sipgate.li.lib.x1.protocol.error.XIDAlreadyExistsException;
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
  private final TaskListener taskListener;
  private final TaskFactory taskFactory;

  public ActivateTaskHandler(
    final TaskRepository taskRepository,
    final TaskListener taskListener,
    final TaskFactory taskFactory
  ) {
    this.taskRepository = taskRepository;
    this.taskListener = taskListener;
    this.taskFactory = taskFactory;
  }

  @Override
  public ActivateTaskResponse handle(final ActivateTaskRequest request)
    throws GenericActivateTaskFailureException, DIDDoesNotExistException, InvalidCombinationOfDeliveryTypeAndDestinationsException, SyntaxSchemaErrorException, XIDAlreadyExistsException {
    try {
      final var task = taskFactory.create(request.getTaskDetails());
      taskListener.onTaskActivateRequest(task);
      taskRepository.insert(task);
      taskListener.onTaskActivated(task);

      final var response = new ActivateTaskResponse();
      response.setOK(OK.ACKNOWLEDGED_AND_COMPLETED);
      return response;
    } catch (final RuntimeException e) {
      throw new GenericActivateTaskFailureException(e);
    }
  }

  @Override
  public Class<? extends X1RequestMessage> getRequestClass() {
    return ActivateTaskRequest.class;
  }
}
