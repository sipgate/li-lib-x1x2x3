/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.server.handler.destination;

import static com.sipgate.li.lib.x1.protocol.CreateDestinationRequestFixture.createDestinationRequest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import com.sipgate.li.lib.x1.protocol.error.DIDAlreadyExistsException;
import com.sipgate.li.lib.x1.protocol.error.DIDDoesNotExistException;
import com.sipgate.li.lib.x1.protocol.error.DestinationInUseException;
import com.sipgate.li.lib.x1.protocol.error.GenericCreateDestinationFailureException;
import com.sipgate.li.lib.x1.server.entity.Destination;
import com.sipgate.li.lib.x1.server.entity.DestinationFactory;
import com.sipgate.li.lib.x1.server.listener.DestinationListener;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.CreateDestinationRequest;
import org.etsi.uri._03221.x1._2017._10.DeliveryAddress;
import org.etsi.uri._03221.x1._2017._10.DeliveryType;
import org.etsi.uri._03221.x1._2017._10.DestinationDetails;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.etsi.uri._03280.common._2017._07.IPAddress;
import org.etsi.uri._03280.common._2017._07.IPAddressPort;
import org.etsi.uri._03280.common._2017._07.Port;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateDestinationHandlerTest {

  @Mock
  private DestinationRepository destinationRepository;

  @InjectMocks
  private CreateDestinationHandler underTest;

  @Mock
  private DestinationListener destinationListener;

  @Test
  void it_creates_destination() throws DIDAlreadyExistsException, GenericCreateDestinationFailureException {
    try (final var factory = Mockito.mockStatic(DestinationFactory.class)) {
      // GIVEN
      final var request = createDestinationRequest();
      final var destination = mock(Destination.class);
      factory.when(() -> DestinationFactory.create(request.getDestinationDetails())).thenReturn(destination);

      // WHEN
      final var response = underTest.handle(request);

      // THEN
      final var order = inOrder(destinationListener, destinationRepository);

      // - Event order is important here: The listener should be notified before and after the repository is updated
      order.verify(destinationListener).onDestinationCreateRequest(destination);
      order.verify(destinationRepository).insert(destination);
      order.verify(destinationListener).onDestinationCreated(destination);

      assertThat(response.getOK()).isEqualTo(OK.ACKNOWLEDGED_AND_COMPLETED);
    }
  }

  @Test
  void it_does_not_insert_when_listener_throws() {
    try (final var factory = Mockito.mockStatic(DestinationFactory.class)) {
      // GIVEN
      final var request = mock(CreateDestinationRequest.class);
      final var destinationDetails = mock(DestinationDetails.class);
      final var destination = mock(Destination.class);
      factory.when(() -> DestinationFactory.create(destinationDetails)).thenReturn(destination);
      when(request.getDestinationDetails()).thenReturn(destinationDetails);
      doThrow(new RuntimeException()).when(destinationListener).onDestinationCreateRequest(destination);

      // WHEN
      assertThatThrownBy(() -> underTest.handle(request)).isInstanceOf(GenericCreateDestinationFailureException.class);

      // THEN
      verifyNoInteractions(destinationRepository);
      verifyNoMoreInteractions(destinationListener);
    }
  }

  @Test
  void it_does_not_call_listener_when_repository_throws_exception() throws DIDAlreadyExistsException {
    //GIVEN
    final var request = createDestinationRequest();

    final var exception = new DIDAlreadyExistsException(UUID.randomUUID());
    doThrow(exception).when(destinationRepository).insert(any());

    //WHEN
    assertThatThrownBy(() -> underTest.handle(request)).isEqualTo(exception);

    //THEN
    verify(destinationListener, never()).onDestinationCreated(any());
  }
}
