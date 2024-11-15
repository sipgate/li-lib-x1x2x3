package com.sipgate.li.lib.x1.server.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.sipgate.li.lib.x1.protocol.error.DIDDoesNotExistException;
import com.sipgate.li.lib.x1.protocol.error.InvalidCombinationOfDeliveryTypeAndDestinationsException;
import com.sipgate.li.lib.x1.protocol.error.SyntaxSchemaErrorException;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.etsi.uri._03221.x1._2017._10.DeliveryType;
import org.etsi.uri._03221.x1._2017._10.ListOfDids;
import org.etsi.uri._03221.x1._2017._10.ListOfTargetIdentifiers;
import org.etsi.uri._03221.x1._2017._10.ProvisioningStatus;
import org.etsi.uri._03221.x1._2017._10.TargetIdentifier;
import org.etsi.uri._03221.x1._2017._10.TaskDetails;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TaskFactoryTest {

  private static final UUID X_ID = UUID.randomUUID();
  private static final UUID D_ID = UUID.randomUUID();
  private static final String E_164_NUMBER = "49211123";
  private static final DeliveryType DELIVERY_TYPE = DeliveryType.X_2_ONLY;

  @InjectMocks
  private TaskFactory underTest;

  @Mock
  private DestinationRepository destinationRepository;

  @Test
  void it_creates_valid_task_response_details() {
    // GIVEN
    final var dids = Set.of("64f16d45-cd52-4fbe-9778-9748ad72dc7b", "ad528c71-b674-444c-9e98-9817ffd15862");
    final var task = new Task(
      UUID.randomUUID(),
      dids.stream().map(did -> new Destination(UUID.fromString(did), "", null, "", 0)).collect(Collectors.toSet()),
      "4912345",
      DeliveryType.X_2_ONLY,
      ProvisioningStatus.AWAITING_PROVISIONING,
      5
    );

    // WHEN
    final var taskResponseDetails = TaskFactory.create(task);
    final var taskDetails = taskResponseDetails.getTaskDetails();
    final var taskStatus = taskResponseDetails.getTaskStatus();

    // THEN
    assertThat(taskDetails.getXId()).isEqualTo(task.xID().toString());
    assertThat(taskDetails.getDeliveryType()).isEqualTo(DeliveryType.X_2_ONLY);
    assertThat(taskDetails.getTargetIdentifiers().getTargetIdentifier().getFirst().getE164Number()).isEqualTo(
      "4912345"
    );
    assertThat(taskDetails.getListOfDIDs().getDId()).containsAll(dids);

    assertThat(taskStatus.getNumberOfModifications()).isEqualTo(5);
    assertThat(taskStatus.getProvisioningStatus()).isEqualTo(ProvisioningStatus.AWAITING_PROVISIONING);
  }

  @ParameterizedTest
  @MethodSource("provideTaskDetails")
  void it_creates_task_from_task_details(final TaskDetails taskDetails, final Set<Destination> destinations)
    throws SyntaxSchemaErrorException, DIDDoesNotExistException, InvalidCombinationOfDeliveryTypeAndDestinationsException {
    // GIVEN
    when(
      destinationRepository.findByDIDs(destinations.stream().map(Destination::dID).collect(Collectors.toSet()))
    ).thenReturn(destinations);

    // WHEN
    final var actual = underTest.create(taskDetails);

    // THEN
    assertThat(actual).isEqualTo(new Task(X_ID, destinations, E_164_NUMBER, taskDetails.getDeliveryType()));
  }

  private static Stream<Arguments> provideTaskDetails() {
    return Stream.of(
      Arguments.of(createTaskDetails(), Set.of(new Destination(D_ID, null, DeliveryType.X_2_ONLY, null, 0))),
      Arguments.of(createTaskDetails(), Set.of(new Destination(D_ID, null, DeliveryType.X_2_AND_X_3, null, 0))),
      Arguments.of(
        createTaskDetails(DeliveryType.X_3_ONLY),
        Set.of(new Destination(D_ID, null, DeliveryType.X_3_ONLY, null, 0))
      ),
      Arguments.of(
        createTaskDetails(DeliveryType.X_3_ONLY),
        Set.of(new Destination(D_ID, null, DeliveryType.X_2_AND_X_3, null, 0))
      ),
      Arguments.of(
        createTaskDetails(DeliveryType.X_2_AND_X_3),
        Set.of(new Destination(D_ID, null, DeliveryType.X_2_AND_X_3, null, 0))
      ),
      Arguments.of(
        createTaskDetails(
          DeliveryType.X_2_AND_X_3,
          "64f16d45-cd52-4fbe-9778-9748ad72dc7b",
          "ad528c71-b674-444c-9e98-9817ffd15862"
        ),
        Set.of(
          new Destination(
            UUID.fromString("64f16d45-cd52-4fbe-9778-9748ad72dc7b"),
            null,
            DeliveryType.X_2_ONLY,
            null,
            0
          ),
          new Destination(UUID.fromString("ad528c71-b674-444c-9e98-9817ffd15862"), null, DeliveryType.X_3_ONLY, null, 0)
        )
      )
    );
  }

  @Test
  void throws_when_no_dIDs_are_present() {
    //GIVEN
    final var taskDetails = createTaskDetails();
    taskDetails.getListOfDIDs().getDId().clear();

    //WHEN THEN
    assertThrows(IllegalArgumentException.class, () -> underTest.create(taskDetails));
  }

  @Test
  void throws_when_one_dID_is_unknown() {
    //GIVEN
    final var taskDetails = createTaskDetails();
    taskDetails
      .getListOfDIDs()
      .getDId()
      .addAll(List.of("64f16d45-cd52-4fbe-9778-9748ad72dc7b", "ad528c71-b674-444c-9e98-9817ffd15862"));

    // only one of the two given destinations is in the database
    when(destinationRepository.findByDIDs(any())).thenReturn(
      Set.of(new Destination(UUID.fromString("ad528c71-b674-444c-9e98-9817ffd15862"), null, null, null, 0))
    );

    //WHEN THEN
    assertThrows(IllegalArgumentException.class, () -> underTest.create(taskDetails));
  }

  @ParameterizedTest
  @MethodSource("provideIncompatibleDestinationTypes")
  void throws_when_destinations_are_incompatible(final TaskDetails taskDetails, final Set<Destination> destinations) {
    // GIVEN
    when(destinationRepository.findByDIDs(any())).thenReturn(destinations);

    // WHEN + THEN
    assertThrows(IllegalArgumentException.class, () -> underTest.create(taskDetails));
  }

  private static Stream<Arguments> provideIncompatibleDestinationTypes() {
    return Stream.of(
      // X2 task but no X2 destination
      Arguments.of(
        createTaskDetails(DeliveryType.X_2_ONLY),
        Set.of(new Destination(null, null, DeliveryType.X_3_ONLY, null, 0))
      ),
      // X3 task but no X3 destination
      Arguments.of(
        createTaskDetails(DeliveryType.X_3_ONLY),
        Set.of(new Destination(null, null, DeliveryType.X_2_ONLY, null, 0))
      ),
      // X2_AND_X3 task but no X3 destination
      Arguments.of(
        createTaskDetails(
          DeliveryType.X_2_AND_X_3,
          "64f16d45-cd52-4fbe-9778-9748ad72dc7b",
          "ad528c71-b674-444c-9e98-9817ffd15862"
        ),
        Set.of(
          new Destination(
            UUID.fromString("64f16d45-cd52-4fbe-9778-9748ad72dc7b"),
            null,
            DeliveryType.X_2_ONLY,
            null,
            0
          ),
          new Destination(UUID.fromString("ad528c71-b674-444c-9e98-9817ffd15862"), null, DeliveryType.X_2_ONLY, null, 0)
        )
      ),
      // X2_AND_X3 task but no X2 destination
      Arguments.of(
        createTaskDetails(
          DeliveryType.X_2_AND_X_3,
          "64f16d45-cd52-4fbe-9778-9748ad72dc7b",
          "ad528c71-b674-444c-9e98-9817ffd15862"
        ),
        Set.of(
          new Destination(
            UUID.fromString("64f16d45-cd52-4fbe-9778-9748ad72dc7b"),
            null,
            DeliveryType.X_3_ONLY,
            null,
            0
          ),
          new Destination(UUID.fromString("ad528c71-b674-444c-9e98-9817ffd15862"), null, DeliveryType.X_3_ONLY, null, 0)
        )
      )
    );
  }

  private static TaskDetails createTaskDetails() {
    return createTaskDetails(DELIVERY_TYPE);
  }

  private static TaskDetails createTaskDetails(final DeliveryType deliveryType) {
    return createTaskDetails(deliveryType, D_ID.toString());
  }

  private static TaskDetails createTaskDetails(final DeliveryType deliveryType, final String... dIds) {
    final var taskDetails = new TaskDetails();
    taskDetails.setXId(X_ID.toString());
    taskDetails.setDeliveryType(deliveryType);
    taskDetails.setListOfDIDs(new ListOfDids());
    taskDetails.getListOfDIDs().getDId().addAll(List.of(dIds));
    taskDetails.setTargetIdentifiers(new ListOfTargetIdentifiers());
    final var target = new TargetIdentifier();
    target.setE164Number(E_164_NUMBER);
    taskDetails.getTargetIdentifiers().getTargetIdentifier().add(target);
    return taskDetails;
  }
}
