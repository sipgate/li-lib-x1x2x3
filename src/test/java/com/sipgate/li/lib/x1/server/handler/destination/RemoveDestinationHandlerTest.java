package com.sipgate.li.lib.x1.server.handler.destination;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import com.sipgate.li.lib.x1.protocol.error.DIDDoesNotExistException;
import com.sipgate.li.lib.x1.protocol.error.DestinationInUseException;
import com.sipgate.li.lib.x1.protocol.error.GenericRemoveDestinationFailureException;
import com.sipgate.li.lib.x1.server.handler.destination.RemoveDestinationHandler;
import com.sipgate.li.lib.x1.server.listener.DestinationListener;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.etsi.uri._03221.x1._2017._10.RemoveDestinationRequest;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class RemoveDestinationHandlerTest {

  public static final UUID D_ID = UUID.randomUUID();

  @Mock
  private DestinationRepository destinationRepository;

  @InjectMocks
  RemoveDestinationHandler underTest;

  @Mock
  private DestinationListener destinationListener;

  @Test
  void returns_ok_when_removed_correctly()
    throws DIDDoesNotExistException, GenericRemoveDestinationFailureException, DestinationInUseException {
    //GIVEN
    final var request = createRemoveDestinationRequest();
    //WHEN
    final var actual = underTest.handle(request);
    //THEN
    assertThat(actual.getOK()).isEqualTo(OK.ACKNOWLEDGED_AND_COMPLETED);

    // - Event order is important here: The listener should be notified before and after the repository is updated
    final var order = inOrder(destinationRepository, destinationListener);
    order.verify(destinationListener).onDestinationRemoveRequest(D_ID);
    order.verify(destinationRepository).deleteByDID(D_ID);
    order.verify(destinationListener).onDestinationRemoved(D_ID);
  }

  @Test
  void it_does_not_insert_when_listener_throws_exception() {
    //GIVEN
    final var request = createRemoveDestinationRequest();
    doThrow(new RuntimeException()).when(destinationListener).onDestinationRemoveRequest(D_ID);

    //WHEN
    assertThatThrownBy(() -> underTest.handle(request)).isInstanceOf(RuntimeException.class);

    //THEN
    verifyNoInteractions(destinationRepository);
    verifyNoMoreInteractions(destinationListener);
  }

  private RemoveDestinationRequest createRemoveDestinationRequest() {
    final var request = new RemoveDestinationRequest();
    request.setDId(D_ID.toString());
    return request;
  }
}
