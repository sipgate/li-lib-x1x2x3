package com.sipgate.li.lib.x1.server.handler.task;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import com.sipgate.li.lib.x1.protocol.error.XIDDoesNotExistException;
import com.sipgate.li.lib.x1.server.entity.Destination;
import com.sipgate.li.lib.x1.server.entity.Task;
import com.sipgate.li.lib.x1.server.entity.TaskFactory;
import com.sipgate.li.lib.x1.server.repository.TaskRepository;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.DeliveryType;
import org.etsi.uri._03221.x1._2017._10.GetTaskDetailsRequest;
import org.etsi.uri._03221.x1._2017._10.GetTaskDetailsResponse;
import org.etsi.uri._03221.x1._2017._10.ListOfFaults;
import org.etsi.uri._03221.x1._2017._10.ProvisioningStatus;
import org.etsi.uri._03221.x1._2017._10.TaskStatus;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class GetTaskDetailsHandlerTest {

  @Mock
  private TaskRepository taskRepository;

  @InjectMocks
  private GetTaskDetailsHandler underTest;

  @Test
  void returns_task_response_when_modified_correctly() throws XIDDoesNotExistException {
    final var request = createGetTaskDetails();
    final var task = createValidTask();
    when(taskRepository.findByXID(UUID.fromString(request.getXId()))).thenReturn(Optional.of(task));

    // WHEN
    final var actualResponse = underTest.handle(request);

    // THEN
    final var status = new TaskStatus();
    status.setNumberOfModifications(task.numberOfModifications());
    status.setProvisioningStatus(task.provisioningStatus());
    status.setListOfFaults(new ListOfFaults());

    final var details = TaskFactory.create(task);
    details.setTaskStatus(status);

    final var expectedResponse = new GetTaskDetailsResponse();
    expectedResponse.setTaskResponseDetails(details);

    assertThat(actualResponse).usingRecursiveComparison().isEqualTo(expectedResponse);
  }

  @Test
  void returns_error_when_task_is_not_in_db() {
    //GIVEN
    final var request = createGetTaskDetails();
    when(taskRepository.findByXID(UUID.fromString(request.getXId()))).thenReturn(Optional.empty());
    //WHEN
    //THEN
    assertThatThrownBy(() -> underTest.handle(request))
      .isInstanceOf(XIDDoesNotExistException.class)
      .hasMessage(request.getXId());
  }

  @Test
  void returns_error_when_db_is_broken() {
    //GIVEN
    final var request = createGetTaskDetails();
    doThrow(new RuntimeException("Database is not at home"))
      .when(taskRepository)
      .findByXID(UUID.fromString(request.getXId()));
    //WHEN
    //THEN
    assertThrows(RuntimeException.class, () -> underTest.handle(request));
  }

  private GetTaskDetailsRequest createGetTaskDetails() {
    final var request = new GetTaskDetailsRequest();
    request.setXId(UUID.randomUUID().toString());
    return request;
  }

  private Task createValidTask() {
    return new Task(
      UUID.randomUUID(),
      Set.of(new Destination(UUID.randomUUID(), null, null, null, 0)),
      "4963721673",
      DeliveryType.X_2_AND_X_3,
      ProvisioningStatus.AWAITING_PROVISIONING,
      5
    );
  }
}
