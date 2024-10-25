package com.sipgate.li.lib.x1.server.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.etsi.uri._03221.x1._2017._10.DeliveryType.X_2_AND_X_3;

import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.DeliveryAddress;
import org.etsi.uri._03221.x1._2017._10.DestinationDetails;
import org.etsi.uri._03221.x1._2017._10.DestinationResponseDetails;
import org.etsi.uri._03280.common._2017._07.IPAddress;
import org.etsi.uri._03280.common._2017._07.IPAddressPort;
import org.etsi.uri._03280.common._2017._07.Port;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DestinationFactoryTest {

  @Nested
  class FromDestinationDetails {

    @Test
    void it_creates_ipv4_destination() {
      // GIVEN
      final var someUuid = UUID.randomUUID();
      final var destinationDetails = makeDestinationDetails(someUuid);
      destinationDetails.getDeliveryAddress().getIpAddressAndPort().getAddress().setIPv4Address("1.2.3.4");

      // WHEN
      final var actual = DestinationFactory.create(destinationDetails);

      // THEN
      final var expected = new Destination(someUuid, "name", X_2_AND_X_3, "1.2.3.4", 1234);
      assertThat(actual).isEqualTo(expected);
    }

    @Test
    void it_creates_ipv6_destination() {
      // GIVEN
      final var someUuid = UUID.randomUUID();
      final var destinationDetails = makeDestinationDetails(someUuid);
      destinationDetails
        .getDeliveryAddress()
        .getIpAddressAndPort()
        .getAddress()
        .setIPv6Address("2001:0db8:85a3:0000:0000:8a2e:0370:7334");

      // WHEN
      final var actual = DestinationFactory.create(destinationDetails);

      // THEN
      final var expected = new Destination(
        someUuid,
        "name",
        X_2_AND_X_3,
        "2001:0db8:85a3:0000:0000:8a2e:0370:7334",
        1234
      );
      assertThat(actual).isEqualTo(expected);
    }
  }

  @Nested
  class FromDestination {

    @Test
    void it_creates_ipv4_destination_details() {
      // GIVEN
      final var someUuid = UUID.randomUUID();
      final var destination = makeDestination(someUuid, "2001:0db8:85a3:0000:0000:8a2e:0370:7334");

      // WHEN
      final var actual = DestinationFactory.create(destination);

      // THEN
      final var expected = new DestinationResponseDetails();
      expected.setDestinationDetails(makeDestinationDetails(someUuid));
      expected
        .getDestinationDetails()
        .getDeliveryAddress()
        .getIpAddressAndPort()
        .getAddress()
        .setIPv6Address("2001:0db8:85a3:0000:0000:8a2e:0370:7334");
      assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void it_creates_ipv6_destination_details() {
      // GIVEN
      final var someUuid = UUID.randomUUID();
      final var destination = makeDestination(someUuid, "1.2.3.4");

      // WHEN
      final var actual = DestinationFactory.create(destination);

      // THEN
      final var expected = new DestinationResponseDetails();
      expected.setDestinationDetails(makeDestinationDetails(someUuid));
      expected
        .getDestinationDetails()
        .getDeliveryAddress()
        .getIpAddressAndPort()
        .getAddress()
        .setIPv4Address("1.2.3.4");
      assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
  }

  private static DestinationDetails makeDestinationDetails(final UUID someUuid) {
    final var destinationDetails = new DestinationDetails();
    destinationDetails.setDId(someUuid.toString());
    destinationDetails.setFriendlyName("name");
    destinationDetails.setDeliveryType(X_2_AND_X_3);
    final var deliveryAddress = new DeliveryAddress();
    final var ipAddressPort = new IPAddressPort();
    final var address = new IPAddress();
    // outside: address.setIPv4Address("1.2.3.4");
    ipAddressPort.setAddress(address);
    final var port = new Port();
    port.setTCPPort(1234);
    ipAddressPort.setPort(port);
    deliveryAddress.setIpAddressAndPort(ipAddressPort);
    destinationDetails.setDeliveryAddress(deliveryAddress);
    return destinationDetails;
  }

  private static Destination makeDestination(final UUID someUuid, final String ipAddress) {
    return new Destination(someUuid, "name", X_2_AND_X_3, ipAddress, 1234);
  }
}
