package com.sipgate.li.lib.x1.server.entity;

import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.DeliveryType;
import org.etsi.uri._03221.x1._2017._10.ProvisioningStatus;

public record Task(
  UUID xID,
  UUID dID,
  String e164Number,
  DeliveryType deliveryType,
  ProvisioningStatus provisioningStatus,
  int numberOfModifications
) {
  public Task(final UUID xID, final UUID dID, final String e164number, final DeliveryType deliveryType) {
    this(xID, dID, e164number, deliveryType, ProvisioningStatus.AWAITING_PROVISIONING, 0);
  }
}
