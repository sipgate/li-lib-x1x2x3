package com.sipgate.li.lib.x1.server.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.DeliveryType;
import org.etsi.uri._03221.x1._2017._10.ListOfDids;
import org.etsi.uri._03221.x1._2017._10.ListOfTargetIdentifiers;
import org.etsi.uri._03221.x1._2017._10.ProvisioningStatus;
import org.etsi.uri._03221.x1._2017._10.TargetIdentifier;
import org.etsi.uri._03221.x1._2017._10.TaskDetails;
import org.junit.jupiter.api.Test;

class TaskFactoryTest {

  private static final UUID X_ID = UUID.randomUUID();
  private static final UUID D_ID = UUID.randomUUID();
  private static final String E_164_NUMBER = "49211123";
  private static final DeliveryType DELIVERY_TYPE = DeliveryType.X_2_ONLY;

  @Test
  void it_creates_valid_task_response_details() {
    // GIVEN
    final var did = UUID.randomUUID();
    final var task = new Task(
      UUID.randomUUID(),
      did,
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
    assertThat(taskDetails.getListOfDIDs().getDId().getFirst()).isEqualTo(did.toString());

    assertThat(taskStatus.getNumberOfModifications()).isEqualTo(5);
    assertThat(taskStatus.getProvisioningStatus()).isEqualTo(ProvisioningStatus.AWAITING_PROVISIONING);
  }

  @Test
  void it_creates_task_from_task_details() {
    // GIVEN
    final var taskDetails = createTaskDetails();

    // WHEN
    final var actual = TaskFactory.create(taskDetails);

    // THEN
    assertThat(actual).isEqualTo(new Task(X_ID, D_ID, E_164_NUMBER, DELIVERY_TYPE));
  }

  @Test
  void throws_when_no_dIDs_are_present() {
    //GIVEN
    final var taskDetails = createTaskDetails();
    taskDetails.getListOfDIDs().getDId().clear();

    //WHEN THEN
    assertThrows(IllegalArgumentException.class, () -> TaskFactory.create(taskDetails));
  }

  @Test
  void throws_when_multiple_dIDs_are_present() {
    //GIVEN
    final var taskDetails = createTaskDetails();
    taskDetails.getListOfDIDs().getDId().addAll(List.of("a", "b"));

    //WHEN THEN
    assertThrows(IllegalArgumentException.class, () -> TaskFactory.create(taskDetails));
  }

  private static TaskDetails createTaskDetails() {
    final var taskDetails = new TaskDetails();
    taskDetails.setXId(X_ID.toString());
    taskDetails.setDeliveryType(DELIVERY_TYPE);
    taskDetails.setListOfDIDs(new ListOfDids());
    taskDetails.getListOfDIDs().getDId().add(D_ID.toString());
    taskDetails.setTargetIdentifiers(new ListOfTargetIdentifiers());
    final var target = new TargetIdentifier();
    target.setE164Number(E_164_NUMBER);
    taskDetails.getTargetIdentifiers().getTargetIdentifier().add(target);
    return taskDetails;
  }
}
