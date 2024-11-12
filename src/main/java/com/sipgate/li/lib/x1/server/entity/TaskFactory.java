package com.sipgate.li.lib.x1.server.entity;

import com.sipgate.li.lib.x1.protocol.error.DIDDoesNotExistException;
import com.sipgate.li.lib.x1.protocol.error.InvalidCombinationOfDeliveryTypeAndDestinationsException;
import com.sipgate.li.lib.x1.protocol.error.SyntaxSchemaErrorException;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import org.etsi.uri._03221.x1._2017._10.DeliveryType;
import org.etsi.uri._03221.x1._2017._10.ListOfDids;
import org.etsi.uri._03221.x1._2017._10.ListOfFaults;
import org.etsi.uri._03221.x1._2017._10.ListOfTargetIdentifiers;
import org.etsi.uri._03221.x1._2017._10.TargetIdentifier;
import org.etsi.uri._03221.x1._2017._10.TaskDetails;
import org.etsi.uri._03221.x1._2017._10.TaskResponseDetails;
import org.etsi.uri._03221.x1._2017._10.TaskStatus;

public class TaskFactory {

  private final DestinationRepository destinationRepository;

  public TaskFactory(final DestinationRepository repository) {
    this.destinationRepository = repository;
  }

  public static TaskResponseDetails create(final Task task) {
    final var targetIdentifier = new TargetIdentifier();
    targetIdentifier.setE164Number(task.e164Number());

    final var listOfTargetIdentifiers = new ListOfTargetIdentifiers();
    listOfTargetIdentifiers.getTargetIdentifier().add(targetIdentifier);

    final var taskDetails = new TaskDetails();
    taskDetails.setXId(task.xID().toString());
    taskDetails.setTargetIdentifiers(listOfTargetIdentifiers);
    taskDetails.setDeliveryType(task.deliveryType());

    final var listOfDIDs = new ListOfDids();
    task.destinations().stream().map(Destination::dID).map(UUID::toString).forEach(listOfDIDs.getDId()::add);
    taskDetails.setListOfDIDs(listOfDIDs);

    final var taskStatus = new TaskStatus();
    taskStatus.setProvisioningStatus(task.provisioningStatus());
    taskStatus.setNumberOfModifications(BigInteger.valueOf(task.numberOfModifications()));
    taskStatus.setListOfFaults(new ListOfFaults());

    final var taskResponseDetails = new TaskResponseDetails();
    taskResponseDetails.setTaskDetails(taskDetails);
    taskResponseDetails.setTaskStatus(taskStatus);

    return taskResponseDetails;
  }

  public Task create(final TaskDetails details)
    throws DIDDoesNotExistException, InvalidCombinationOfDeliveryTypeAndDestinationsException, SyntaxSchemaErrorException {
    final var requestedDIDs = details
      .getListOfDIDs()
      .getDId()
      .stream()
      .map(UUID::fromString)
      .collect(Collectors.toSet());

    if (requestedDIDs.isEmpty()) {
      throw new SyntaxSchemaErrorException("List of DIDs must contain at least one DID");
    }

    final var destinations = destinationRepository.findByDIDs(requestedDIDs);
    final var foundDIDs = destinations.stream().map(Destination::dID).collect(Collectors.toSet());
    final var maybeMissingDID = requestedDIDs.stream().filter(foundDIDs::contains).findAny();
    if (maybeMissingDID.isPresent()) {
      throw new DIDDoesNotExistException(maybeMissingDID.get());
    }

    if (!hasAllWantedDeliveryTypes(details.getDeliveryType(), destinations)) {
      throw new InvalidCombinationOfDeliveryTypeAndDestinationsException();
    }

    final var xId = UUID.fromString(details.getXId());
    final var e164number = details.getTargetIdentifiers().getTargetIdentifier().getFirst().getE164Number();
    final var deliveryType = details.getDeliveryType();
    return new Task(xId, destinations, e164number, deliveryType);
  }

  private static boolean hasAllWantedDeliveryTypes(final DeliveryType wanted, final Set<Destination> destinations) {
    if (DeliveryType.X_2_AND_X_3.equals(wanted)) {
      return isOffered(DeliveryType.X_2_ONLY, destinations) && isOffered(DeliveryType.X_3_ONLY, destinations);
    }

    return isOffered(wanted, destinations);
  }

  private static boolean isOffered(final DeliveryType wanted, final Set<Destination> destinations) {
    return destinations
      .stream()
      .map(Destination::deliveryType)
      .anyMatch(deliveryType -> isCompatible(wanted, deliveryType));
  }

  private static boolean isCompatible(final DeliveryType wanted, final DeliveryType offered) {
    return Objects.equals(wanted, offered) || DeliveryType.X_2_AND_X_3.equals(offered);
  }
}
