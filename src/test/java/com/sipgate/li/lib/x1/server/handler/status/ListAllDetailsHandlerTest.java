package com.sipgate.li.lib.x1.server.handler.status;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.sipgate.li.lib.x1.server.entity.Destination;
import com.sipgate.li.lib.x1.server.entity.Task;
import com.sipgate.li.lib.x1.server.handler.status.ListAllDetailsHandler;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import com.sipgate.li.lib.x1.server.repository.TaskRepository;
import java.util.List;
import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.ListAllDetailsResponse;
import org.etsi.uri._03221.x1._2017._10.ListOfDids;
import org.etsi.uri._03221.x1._2017._10.ListOfXids;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class ListAllDetailsHandlerTest {

  @Mock
  private TaskRepository taskRepository;

  @Mock
  private DestinationRepository destinationRepository;

  @InjectMocks
  private ListAllDetailsHandler underTest;

  @Test
  void it_returns_all_tasks_that_were_provided_and_the_provided_DID() {
    // GIVEN
    // only the UUID is relevant for the return value that is under test
    final var tasksList = List.of(
      new Task(UUID.randomUUID(), null, null, null),
      new Task(UUID.randomUUID(), null, null, null)
    );
    when(taskRepository.getAllTasks()).thenReturn(tasksList);

    // only the UUID is relevant for the return value that is under test
    final var destinationsList = List.of(
      new Destination(UUID.randomUUID(), null, null, null, 0),
      new Destination(UUID.randomUUID(), null, null, null, 0)
    );
    when(destinationRepository.getAllDestinations()).thenReturn(destinationsList);

    // WHEN
    final var actual = underTest.handle(null);

    // THEN
    final var expected = new ListAllDetailsResponse();
    expected.setListOfXIDs(new ListOfXids());
    expected.getListOfXIDs().getXId().addAll(tasksList.stream().map(Task::xID).map(UUID::toString).toList());
    expected.setListOfDIDs(new ListOfDids());
    expected
      .getListOfDIDs()
      .getDId()
      .addAll(destinationsList.stream().map(Destination::dID).map(UUID::toString).toList());

    assertThat(actual).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(expected);
  }

  @Test
  void it_throws_when_persistence_layer_throws() {
    // GIVEN
    when(taskRepository.getAllTasks()).thenThrow(new RuntimeException("something is bad with the DB"));

    // WHEN
    assertThrows(RuntimeException.class, () -> underTest.handle(null));
  }
}
