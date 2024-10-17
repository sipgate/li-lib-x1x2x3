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
import com.sipgate.li.lib.x1.server.handler.destination.CreateDestinationHandler;
import com.sipgate.li.lib.x1.server.listener.DestinationListener;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import org.etsi.uri._03221.x1._2017._10.CreateDestinationRequest;
import org.etsi.uri._03221.x1._2017._10.DestinationDetails;
import org.etsi.uri._03221.x1._2017._10.OK;
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
  void it_creates_destination() {
    try (final var factory = Mockito.mockStatic(DestinationFactory.class)) {
      // GIVEN
      final var request = mock(CreateDestinationRequest.class);
      final var destinationDetails = mock(DestinationDetails.class);
      final var destination = mock(Destination.class);
      factory.when(() -> DestinationFactory.create(destinationDetails)).thenReturn(destination);
      when(request.getDestinationDetails()).thenReturn(destinationDetails);

      // WHEN
      final var response = underTest.handle(request);

      // THEN
      final InOrder order = inOrder(destinationListener, destinationRepository);

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
      assertThatThrownBy(() -> underTest.handle(request)).isInstanceOf(RuntimeException.class);

      // THEN
      verifyNoInteractions(destinationRepository);
      verifyNoMoreInteractions(destinationListener);
    }
  }
}
