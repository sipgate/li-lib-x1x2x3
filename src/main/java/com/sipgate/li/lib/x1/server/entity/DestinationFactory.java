package com.sipgate.li.lib.x1.server.entity;

import java.util.Objects;
import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.DeliveryAddress;
import org.etsi.uri._03221.x1._2017._10.DestinationDetails;
import org.etsi.uri._03221.x1._2017._10.DestinationResponseDetails;
import org.etsi.uri._03280.common._2017._07.IPAddress;
import org.etsi.uri._03280.common._2017._07.IPAddressPort;
import org.etsi.uri._03280.common._2017._07.Port;

public class DestinationFactory {

  private DestinationFactory() {}

  public static DestinationResponseDetails create(final Destination destination) {
    final var destinationDetails = new DestinationDetails();
    destinationDetails.setDId(destination.dID().toString());
    destinationDetails.setFriendlyName(destination.friendlyName());
    destinationDetails.setDeliveryType(destination.deliveryType());

    final var ipAddress = new IPAddress();
    if (destination.deliveryAddress().contains(":")) {
      ipAddress.setIPv6Address(destination.deliveryAddress());
    } else {
      ipAddress.setIPv4Address(destination.deliveryAddress());
    }

    final var port = new Port();
    port.setTCPPort(destination.deliveryPort());

    final var ipAddressPort = new IPAddressPort();
    ipAddressPort.setAddress(ipAddress);
    ipAddressPort.setPort(port);

    final var deliveryAddress = new DeliveryAddress();
    deliveryAddress.setIpAddressAndPort(ipAddressPort);
    destinationDetails.setDeliveryAddress(deliveryAddress);

    final var destinationResponseDetails = new DestinationResponseDetails();
    destinationResponseDetails.setDestinationDetails(destinationDetails);
    return destinationResponseDetails;
  }

  public static Destination create(final DestinationDetails destinationDetails) {
    return new Destination(
      UUID.fromString(destinationDetails.getDId()),
      destinationDetails.getFriendlyName(),
      destinationDetails.getDeliveryType(),
      getIpAddress(destinationDetails),
      getPort(destinationDetails)
    );
  }

  private static String getIpAddress(final DestinationDetails destinationDetails) {
    final var address = destinationDetails.getDeliveryAddress().getIpAddressAndPort().getAddress();

    if (address.getIPv6Address() != null) {
      return address.getIPv6Address();
    }

    return address.getIPv4Address();
  }

  private static int getPort(final DestinationDetails destinationDetails) {
    return Objects.requireNonNull(
      destinationDetails.getDeliveryAddress().getIpAddressAndPort().getPort().getTCPPort(),
      "TCP port must be set."
    );
  }
}
