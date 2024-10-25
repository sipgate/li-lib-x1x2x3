package com.sipgate.li.lib.x1.server.handler.task;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import com.sipgate.li.lib.x1.server.DeliveryTypeCompatibleValidator;
import com.sipgate.li.lib.x1.server.entity.Task;
import com.sipgate.li.lib.x1.server.entity.TaskFactory;
import com.sipgate.li.lib.x1.server.handler.task.ActivateTaskHandler;
import com.sipgate.li.lib.x1.server.listener.TaskListener;
import com.sipgate.li.lib.x1.server.repository.TaskRepository;
import org.etsi.uri._03221.x1._2017._10.ActivateTaskRequest;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.etsi.uri._03221.x1._2017._10.TaskDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class ActivateTaskHandlerTest {

  @Mock
  private TaskRepository taskRepository;

  @Mock
  private DeliveryTypeCompatibleValidator deliveryTypeCompatibleValidator;

  @Mock
  private TaskListener taskListener;

  private ActivateTaskHandler underTest;

  @BeforeEach
  void setup() {
    underTest = new ActivateTaskHandler(taskRepository, deliveryTypeCompatibleValidator, taskListener);
  }

  @Test
  void it_returns_ok_when_stored_correctly() {
    try (final var factory = mockStatic(TaskFactory.class)) {
      //GIVEN
      final var request = mock(ActivateTaskRequest.class);
      final var task = mock(Task.class);
      final var taskDetails = mock(TaskDetails.class);
      when(request.getTaskDetails()).thenReturn(taskDetails);
      factory.when(() -> TaskFactory.create(taskDetails)).thenReturn(task);

      //WHEN
      final var response = underTest.handle(request);

      //THEN
      assertThat(response.getOK()).isEqualTo(OK.ACKNOWLEDGED_AND_COMPLETED);

      // - We need to verify that the task is validated before it is inserted and events need to be fired in the right order
      final var order = inOrder(deliveryTypeCompatibleValidator, taskListener, taskRepository);
      order.verify(deliveryTypeCompatibleValidator).validate(task);
      order.verify(taskListener).onTaskActivateRequest(task);
      order.verify(taskRepository).insert(task);
      order.verify(taskListener).onTaskActivated(task);
    }
  }

  @Test
  void it_rejects_invalid_requests() {
    try (final var factory = mockStatic(TaskFactory.class)) {
      //GIVEN
      final var request = mock(ActivateTaskRequest.class);
      final var task = mock(Task.class);
      final var taskDetails = mock(TaskDetails.class);
      when(request.getTaskDetails()).thenReturn(taskDetails);
      factory.when(() -> TaskFactory.create(taskDetails)).thenReturn(task);

      doThrow(new IllegalArgumentException()).when(deliveryTypeCompatibleValidator).validate(task);

      //WHEN
      assertThatThrownBy(() -> underTest.handle(request)).isInstanceOf(IllegalArgumentException.class);

      //THEN
      verifyNoInteractions(taskRepository, taskListener);
    }
  }

  @Test
  void it_does_not_insert_when_listener_throws() {
    try (final var factory = mockStatic(TaskFactory.class)) {
      //GIVEN
      final var request = mock(ActivateTaskRequest.class);
      final var task = mock(Task.class);
      final var taskDetails = mock(TaskDetails.class);
      when(request.getTaskDetails()).thenReturn(taskDetails);
      factory.when(() -> TaskFactory.create(taskDetails)).thenReturn(task);

      doThrow(new RuntimeException()).when(taskListener).onTaskActivateRequest(task);

      //WHEN
      assertThatThrownBy(() -> underTest.handle(request)).isInstanceOf(RuntimeException.class);

      //THEN
      verifyNoInteractions(taskRepository);
      verifyNoMoreInteractions(taskListener);
    }
  }
}
