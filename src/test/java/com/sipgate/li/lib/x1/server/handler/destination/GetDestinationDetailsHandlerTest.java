/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.server.handler.destination;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.sipgate.li.lib.x1.protocol.error.DIDDoesNotExistException;
import com.sipgate.li.lib.x1.server.entity.Destination;
import com.sipgate.li.lib.x1.server.entity.DestinationFactory;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import java.util.Optional;
import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.DeliveryType;
import org.etsi.uri._03221.x1._2017._10.GetDestinationDetailsRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetDestinationDetailsHandlerTest {

  @Mock
  DestinationRepository destinationRepository;

  @InjectMocks
  GetDestinationDetailsHandler underTest;

  @Test
  void it_returns_destination_details() throws DIDDoesNotExistException {
    // GIVEN
    final var destination = new Destination(UUID.randomUUID(), "friendly", DeliveryType.X_2_AND_X_3, "192.0.2.2", 1100);
    when(destinationRepository.findByDID(any())).thenReturn(Optional.of(destination));

    // WHEN
    final var request = new GetDestinationDetailsRequest();
    request.setDId(destination.dID().toString());

    final var response = underTest.handle(request);

    // THEN
    assertThat(response.getDestinationResponseDetails())
      .usingRecursiveComparison()
      .isEqualTo(DestinationFactory.create(destination));
  }

  @Test
  void it_throws_when_destination_unknown() {
    // GIVEN
    when(destinationRepository.findByDID(any())).thenReturn(Optional.empty());

    final var request = new GetDestinationDetailsRequest();
    final var dID = UUID.randomUUID();
    request.setDId(dID.toString());

    // WHEN
    assertThatThrownBy(() -> underTest.handle(request))
      .isInstanceOf(DIDDoesNotExistException.class)
      .hasMessage(dID.toString());
  }
}
