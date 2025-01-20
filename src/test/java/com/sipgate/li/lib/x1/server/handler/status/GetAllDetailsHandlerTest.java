/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.server.handler.status;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.sipgate.li.lib.x1.server.entity.Destination;
import com.sipgate.li.lib.x1.server.entity.DestinationFactory;
import com.sipgate.li.lib.x1.server.entity.Task;
import com.sipgate.li.lib.x1.server.entity.TaskFactory;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import com.sipgate.li.lib.x1.server.repository.TaskRepository;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.DeliveryType;
import org.etsi.uri._03221.x1._2017._10.NeStatus;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class GetAllDetailsHandlerTest {

  @Mock
  private TaskRepository taskRepository;

  @Mock
  private DestinationRepository destinationRepository;

  @Mock
  private TaskFactory taskFactory;

  @InjectMocks
  private GetAllDetailsHandler underTest;

  @Test
  void it_returns_positive_ne_status() {
    // WHEN
    final var response = underTest.handle(null);

    // THEN
    assertThat(response.getNeStatusDetails().getNeStatus()).isEqualTo(NeStatus.OK);
  }

  @Test
  void it_returns_list_of_tasks() {
    // GIVEN
    final var taskList = List.of(
      new Task(
        UUID.randomUUID(),
        Set.of(new Destination(UUID.randomUUID(), null, null, null, 0)),
        "49123",
        DeliveryType.X_2_ONLY
      ),
      new Task(
        UUID.randomUUID(),
        Set.of(new Destination(UUID.randomUUID(), null, null, null, 0)),
        "49124",
        DeliveryType.X_3_ONLY
      )
    );
    when(taskRepository.getAllTasks()).thenReturn(taskList);

    // WHEN
    final var response = underTest.handle(null);

    // THEN
    assertThat(response.getListOfTaskResponseDetails().getTaskResponseDetails()).hasSize(2);
    assertThat(response.getListOfTaskResponseDetails().getTaskResponseDetails())
      .usingRecursiveFieldByFieldElementComparator()
      .hasSameElementsAs(taskList.stream().map(TaskFactory::create).toList());
  }

  @Test
  void it_returns_empty_list_of_generic_objects() {
    // WHEN
    final var response = underTest.handle(null);

    // THEN
    assertThat(response.getListOfGenericObjectResponseDetails().getGenericObjectResponseDetails()).isEmpty();
  }

  @Test
  void it_returns_list_of_destinations() {
    // GIVEN
    final var destinations = Set.of(
      new Destination(UUID.randomUUID(), "friendly-name-1", DeliveryType.X_2_ONLY, "any-1", 0),
      new Destination(UUID.randomUUID(), "friendly-name-2", DeliveryType.X_3_ONLY, "any-2", 1)
    );

    when(destinationRepository.getAllDestinations()).thenReturn(destinations);

    // WHEN
    final var response = underTest.handle(null);

    // THEN
    assertThat(response.getListOfDestinationResponseDetails().getDestinationResponseDetails()).hasSize(2);
    assertThat(response.getListOfDestinationResponseDetails().getDestinationResponseDetails())
      .usingRecursiveFieldByFieldElementComparator()
      .hasSameElementsAs(destinations.stream().map(DestinationFactory::create).toList());
  }
}
