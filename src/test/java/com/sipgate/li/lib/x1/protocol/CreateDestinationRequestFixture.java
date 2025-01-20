/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.protocol;

import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.CreateDestinationRequest;
import org.etsi.uri._03221.x1._2017._10.DeliveryAddress;
import org.etsi.uri._03221.x1._2017._10.DestinationDetails;
import org.etsi.uri._03280.common._2017._07.IPAddress;
import org.etsi.uri._03280.common._2017._07.IPAddressPort;
import org.etsi.uri._03280.common._2017._07.Port;

public class CreateDestinationRequestFixture {

  private CreateDestinationRequestFixture() {}

  public static CreateDestinationRequest createDestinationRequest() {
    final var address = new IPAddress();
    address.setIPv4Address("1.2.3.4");

    final var port = new Port();
    port.setTCPPort(31337L);

    final var ipAddressAndPort = new IPAddressPort();
    ipAddressAndPort.setAddress(address);
    ipAddressAndPort.setPort(port);

    final var deliveryAddress = new DeliveryAddress();
    deliveryAddress.setIpAddressAndPort(ipAddressAndPort);

    final var destinationDetails = new DestinationDetails();
    destinationDetails.setDId(UUID.randomUUID().toString());
    destinationDetails.setDeliveryAddress(deliveryAddress);

    final var request = new CreateDestinationRequest();
    request.setDestinationDetails(destinationDetails);
    return request;
  }
}
