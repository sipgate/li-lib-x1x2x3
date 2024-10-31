package com.sipgate.li.lib.x1.server;

import com.sipgate.li.lib.x1.server.entity.Task;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import java.util.NoSuchElementException;
import org.etsi.uri._03221.x1._2017._10.DeliveryType;

public class DeliveryTypeCompatibleValidator {

  private final DestinationRepository destinationRepository;

  public DeliveryTypeCompatibleValidator(final DestinationRepository destinationRepository) {
    this.destinationRepository = destinationRepository;
  }

  public void validate(final Task t) {
    // TODO: Validate based on delivery type of the task and the delivery type of its destination.
  }

  static boolean isValid(final DeliveryType destinationDeliveryType, final DeliveryType taskDeliveryType) {
    return switch (destinationDeliveryType) {
      case X_2_AND_X_3 -> true;
      default -> destinationDeliveryType.equals(taskDeliveryType);
    };
  }
}
