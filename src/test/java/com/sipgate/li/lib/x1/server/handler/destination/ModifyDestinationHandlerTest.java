package com.sipgate.li.lib.x1.server.handler.destination;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import com.sipgate.li.lib.x1.server.entity.Destination;
import com.sipgate.li.lib.x1.server.entity.DestinationFactory;
import com.sipgate.li.lib.x1.server.handler.destination.ModifyDestinationHandler;
import com.sipgate.li.lib.x1.server.listener.DestinationListener;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.DeliveryType;
import org.etsi.uri._03221.x1._2017._10.DestinationDetails;
import org.etsi.uri._03221.x1._2017._10.ModifyDestinationRequest;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
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
  void it_modifies_destination() {
    try (final var factory = Mockito.mockStatic(DestinationFactory.class)) {
      // GIVEN
      final var request = mock(ModifyDestinationRequest.class);
      final var destinationDetails = mock(DestinationDetails.class);
      final var destination = mock(Destination.class);
      factory.when(() -> DestinationFactory.create(destinationDetails)).thenReturn(destination);
      when(request.getDestinationDetails()).thenReturn(destinationDetails);

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
      final var destination = mock(Destination.class);
      factory.when(() -> DestinationFactory.create(destinationDetails)).thenReturn(destination);
      when(request.getDestinationDetails()).thenReturn(destinationDetails);
      doThrow(new RuntimeException()).when(destinationListener).onDestinationModifyRequest(destination);

      // WHEN
      assertThatThrownBy(() -> underTest.handle(request)).isInstanceOf(RuntimeException.class);

      // THEN
      verifyNoInteractions(destinationRepository);
      verifyNoMoreInteractions(destinationListener);
    }
  }
}
