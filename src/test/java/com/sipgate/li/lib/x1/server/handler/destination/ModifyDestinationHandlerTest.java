/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.server.handler.destination;

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

import com.sipgate.li.lib.x1.protocol.error.DIDDoesNotExistException;
import com.sipgate.li.lib.x1.protocol.error.GenericModifyDestinationFailureException;
import com.sipgate.li.lib.x1.server.entity.Destination;
import com.sipgate.li.lib.x1.server.entity.DestinationFactory;
import com.sipgate.li.lib.x1.server.listener.DestinationListener;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.DeliveryType;
import org.etsi.uri._03221.x1._2017._10.DestinationDetails;
import org.etsi.uri._03221.x1._2017._10.ModifyDestinationRequest;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ModifyDestinationHandlerTest {

  private static final UUID D_ID = UUID.randomUUID();
  private static final String FRIENDLY_NAME = "FriendlyName";
  private static final DeliveryType DELIVERY_TYPE = DeliveryType.X_2_AND_X_3;
  private static final String IP_ADDRESS = "2001:db8::1";
  private static final int PORT = 31337;

  @Mock
  private DestinationRepository destinationRepository;

  @InjectMocks
  private ModifyDestinationHandler underTest;

  @Mock
  private DestinationListener destinationListener;

  @Test
  void it_modifies_destination() throws DIDDoesNotExistException, GenericModifyDestinationFailureException {
    try (final var factory = Mockito.mockStatic(DestinationFactory.class)) {
      // GIVEN
      final var request = mock(ModifyDestinationRequest.class);
      final var destinationDetails = mock(DestinationDetails.class);
      when(request.getDestinationDetails()).thenReturn(destinationDetails);

      final var destination = mock(Destination.class);
      factory.when(() -> DestinationFactory.create(destinationDetails)).thenReturn(destination);

      // WHEN
      final var response = underTest.handle(request);

      // THEN
      final var order = inOrder(destinationListener, destinationRepository);

      // - Event order is important here: The listener should be notified before and after the repository is updated
      order.verify(destinationListener).onDestinationModifyRequest(destination);
      order.verify(destinationRepository).update(destination);
      order.verify(destinationListener).onDestinationModified(destination);

      assertThat(response.getOK()).isEqualTo(OK.ACKNOWLEDGED_AND_COMPLETED);
    }
  }

  @Test
  void it_does_not_update_when_listener_throws() {
    try (final var factory = Mockito.mockStatic(DestinationFactory.class)) {
      // GIVEN
      final var request = mock(ModifyDestinationRequest.class);
      final var destinationDetails = mock(DestinationDetails.class);
      when(request.getDestinationDetails()).thenReturn(destinationDetails);

      final var destination = mock(Destination.class);
      factory.when(() -> DestinationFactory.create(destinationDetails)).thenReturn(destination);
      doThrow(new RuntimeException()).when(destinationListener).onDestinationModifyRequest(destination);

      // WHEN
      assertThatThrownBy(() -> underTest.handle(request)).isInstanceOf(GenericModifyDestinationFailureException.class);

      // THEN
      verifyNoInteractions(destinationRepository);
      verifyNoMoreInteractions(destinationListener);
    }
  }

  @Test
  void it_does_not_call_listener_when_repository_throws() throws DIDDoesNotExistException {
    try (final var factory = Mockito.mockStatic(DestinationFactory.class)) {
      // GIVEN
      final var request = mock(ModifyDestinationRequest.class);
      final var destinationDetails = mock(DestinationDetails.class);
      when(request.getDestinationDetails()).thenReturn(destinationDetails);

      final var destination = new Destination(UUID.randomUUID(), null, null, null, 0);
      factory.when(() -> DestinationFactory.create(destinationDetails)).thenReturn(destination);

      // WHEN
      final var exception = new DIDDoesNotExistException(destination.dID());
      doThrow(exception).when(destinationRepository).update(destination);

      // WHEN
      assertThatThrownBy(() -> underTest.handle(request)).isEqualTo(exception);

      // THEN
      verify(destinationListener, never()).onDestinationModified(any());
    }
  }
}
