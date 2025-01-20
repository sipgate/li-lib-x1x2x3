/*
 * SPDX-License-Identifier: MIT
 */
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

import com.sipgate.li.lib.x1.protocol.error.GenericDeactivateTaskFailureException;
import com.sipgate.li.lib.x1.protocol.error.XIDDoesNotExistException;
import com.sipgate.li.lib.x1.server.listener.TaskListener;
import com.sipgate.li.lib.x1.server.repository.TaskRepository;
import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.DeactivateTaskRequest;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
public class DeactivateTaskHandlerTest {

  public static final UUID X_ID = UUID.randomUUID();

  @Mock
  private TaskRepository taskRepository;

  @Mock
  private TaskListener taskListener;

  private DeactivateTaskHandler underTest;

  @BeforeEach
  void setup() {
    underTest = new DeactivateTaskHandler(taskRepository, taskListener);
  }

  @Test
  void it_returns_ok_when_removed_correctly() throws GenericDeactivateTaskFailureException, XIDDoesNotExistException {
    // GIVEN
    final var request = mock(DeactivateTaskRequest.class);
    when(request.getXId()).thenReturn(X_ID.toString());

    //WHEN
    final var response = underTest.handle(request);

    //THEN
    assertThat(response.getOK()).isEqualTo(OK.ACKNOWLEDGED_AND_COMPLETED);

    // - We need to verify that the task is validated before it is inserted and events need to be fired in the right order
    final var order = inOrder(taskListener, taskRepository);
    order.verify(taskListener).onTaskDeactivateRequest(X_ID);
    order.verify(taskRepository).deleteByXID(X_ID);
    order.verify(taskListener).onTaskDeactivated(X_ID);
  }

  @Test
  void it_does_not_remove_when_listener_throws() {
    //GIVEN
    final var request = mock(DeactivateTaskRequest.class);
    when(request.getXId()).thenReturn(X_ID.toString());

    doThrow(new RuntimeException()).when(taskListener).onTaskDeactivateRequest(X_ID);

    //WHEN
    assertThatThrownBy(() -> underTest.handle(request)).isInstanceOf(GenericDeactivateTaskFailureException.class);

    //THEN
    verifyNoInteractions(taskRepository);
    verifyNoMoreInteractions(taskListener);
  }

  @Test
  void it_does_not_call_listener_when_repository_throws_exception() throws XIDDoesNotExistException {
    // GIVEN
    final var request = mock(DeactivateTaskRequest.class);
    when(request.getXId()).thenReturn(X_ID.toString());

    final var exception = new XIDDoesNotExistException(X_ID);
    doThrow(exception).when(taskRepository).deleteByXID(X_ID);

    // WHEN
    assertThatThrownBy(() -> underTest.handle(request)).isEqualTo(exception);

    // THEN
    verify(taskListener, never()).onTaskDeactivated(any());
  }
}
