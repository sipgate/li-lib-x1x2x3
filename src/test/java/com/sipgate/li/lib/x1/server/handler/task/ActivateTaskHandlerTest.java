package com.sipgate.li.lib.x1.server.handler.task;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import com.sipgate.li.lib.x1.protocol.error.DIDDoesNotExistException;
import com.sipgate.li.lib.x1.protocol.error.GenericActivateTaskFailureException;
import com.sipgate.li.lib.x1.protocol.error.InvalidCombinationOfDeliveryTypeAndDestinationsException;
import com.sipgate.li.lib.x1.protocol.error.SyntaxSchemaErrorException;
import com.sipgate.li.lib.x1.protocol.error.XIDAlreadyExistsException;
import com.sipgate.li.lib.x1.server.entity.Task;
import com.sipgate.li.lib.x1.server.entity.TaskFactory;
import com.sipgate.li.lib.x1.server.listener.TaskListener;
import com.sipgate.li.lib.x1.server.repository.TaskRepository;
import org.etsi.uri._03221.x1._2017._10.ActivateTaskRequest;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.etsi.uri._03221.x1._2017._10.TaskDetails;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class ActivateTaskHandlerTest {

  @Mock
  private TaskRepository taskRepository;

  @Mock
  private TaskListener taskListener;

  @Mock
  private TaskFactory taskFactory;

  @InjectMocks
  private ActivateTaskHandler underTest;

  @Test
  void it_returns_ok_when_stored_correctly()
    throws SyntaxSchemaErrorException, DIDDoesNotExistException, InvalidCombinationOfDeliveryTypeAndDestinationsException, GenericActivateTaskFailureException, XIDAlreadyExistsException {
    //GIVEN
    final var request = mock(ActivateTaskRequest.class);
    final var task = mock(Task.class);
    final var taskDetails = mock(TaskDetails.class);
    when(request.getTaskDetails()).thenReturn(taskDetails);
    when(taskFactory.create(taskDetails)).thenReturn(task);

    //WHEN
    final var response = underTest.handle(request);

    //THEN
    assertThat(response.getOK()).isEqualTo(OK.ACKNOWLEDGED_AND_COMPLETED);

    // - We need to verify that the task is validated before it is inserted and events need to be fired in the right order
    final var order = inOrder(taskFactory, taskListener, taskRepository);
    order.verify(taskFactory).create(taskDetails);
    order.verify(taskListener).onTaskActivateRequest(task);
    order.verify(taskRepository).insert(task);
    order.verify(taskListener).onTaskActivated(task);
  }

  @Test
  void it_rejects_invalid_requests()
    throws SyntaxSchemaErrorException, DIDDoesNotExistException, InvalidCombinationOfDeliveryTypeAndDestinationsException {
    //GIVEN
    final var request = mock(ActivateTaskRequest.class);
    final var taskDetails = mock(TaskDetails.class);
    when(request.getTaskDetails()).thenReturn(taskDetails);
    doThrow(new IllegalArgumentException()).when(taskFactory).create(taskDetails);

    //WHEN
    assertThatThrownBy(() -> underTest.handle(request)).isInstanceOf(GenericActivateTaskFailureException.class);

    //THEN
    verifyNoInteractions(taskRepository, taskListener);
  }

  @Test
  void it_does_not_insert_when_listener_throws()
    throws SyntaxSchemaErrorException, DIDDoesNotExistException, InvalidCombinationOfDeliveryTypeAndDestinationsException {
    //GIVEN
    final var request = mock(ActivateTaskRequest.class);
    final var task = mock(Task.class);
    final var taskDetails = mock(TaskDetails.class);
    when(request.getTaskDetails()).thenReturn(taskDetails);
    when(taskFactory.create(taskDetails)).thenReturn(task);

    doThrow(new RuntimeException()).when(taskListener).onTaskActivateRequest(task);

    //WHEN
    assertThatThrownBy(() -> underTest.handle(request)).isInstanceOf(GenericActivateTaskFailureException.class);

    //THEN
    verifyNoInteractions(taskRepository);
    verifyNoMoreInteractions(taskListener);
  }

  @Test
  void it_does_not_throw_when_repository_throws()
    throws SyntaxSchemaErrorException, DIDDoesNotExistException, InvalidCombinationOfDeliveryTypeAndDestinationsException {
    //GIVEN
    final var request = mock(ActivateTaskRequest.class);
    final var taskDetails = mock(TaskDetails.class);
    when(request.getTaskDetails()).thenReturn(taskDetails);

    final var exception = new InvalidCombinationOfDeliveryTypeAndDestinationsException();
    when(taskFactory.create(taskDetails)).thenThrow(exception);

    //WHEN
    assertThatThrownBy(() -> underTest.handle(request)).isEqualTo(exception);

    //THEN
    verify(taskListener, never()).onTaskActivated(any());
  }
}
