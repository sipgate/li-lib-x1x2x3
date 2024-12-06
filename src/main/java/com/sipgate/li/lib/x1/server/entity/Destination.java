package com.sipgate.li.lib.x1.server.entity;

import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.DeliveryType;

public record Destination(
  UUID dID,
  String friendlyName,
  DeliveryType deliveryType,
  String deliveryAddress,
  int deliveryPort
) {}
