package com.sipgate.li.lib.x1.server.handler.destination;

import com.sipgate.li.lib.x1.server.handler.X1RequestHandler;
import com.sipgate.li.lib.x1.server.listener.DestinationListener;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.etsi.uri._03221.x1._2017._10.RemoveDestinationRequest;
import org.etsi.uri._03221.x1._2017._10.RemoveDestinationResponse;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;

public class RemoveDestinationHandler implements X1RequestHandler<RemoveDestinationRequest, RemoveDestinationResponse> {

  private final DestinationRepository destinationRepository;
  private final DestinationListener destinationListener;

  public RemoveDestinationHandler(
    final DestinationRepository destinationRepository,
    final DestinationListener destinationListener
  ) {
    this.destinationRepository = destinationRepository;
    this.destinationListener = destinationListener;
  }

  @Override
  public RemoveDestinationResponse handle(final RemoveDestinationRequest request) {
    final var dId = UUID.fromString(request.getDId());
    destinationListener.onDestinationRemoveRequest(dId);
    destinationRepository.deleteByDID(dId);
    destinationListener.onDestinationRemoved(dId);

    final var response = new RemoveDestinationResponse();
    response.setOK(OK.ACKNOWLEDGED_AND_COMPLETED);
    return response;
  }

  @Override
  public Class<? extends X1RequestMessage> getRequestClass() {
    return RemoveDestinationRequest.class;
  }
}