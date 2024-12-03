package com.sipgate.li.lib.x1.server.handler.destination;

import com.sipgate.li.lib.x1.protocol.error.DIDAlreadyExistsException;
import com.sipgate.li.lib.x1.protocol.error.GenericCreateDestinationFailureException;
import com.sipgate.li.lib.x1.server.entity.DestinationFactory;
import com.sipgate.li.lib.x1.server.handler.X1RequestHandler;
import com.sipgate.li.lib.x1.server.listener.DestinationListener;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import org.etsi.uri._03221.x1._2017._10.CreateDestinationRequest;
import org.etsi.uri._03221.x1._2017._10.CreateDestinationResponse;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;

public class CreateDestinationHandler implements X1RequestHandler<CreateDestinationRequest, CreateDestinationResponse> {

  private final DestinationRepository destinationRepository;
  private final DestinationListener destinationListener;

  public CreateDestinationHandler(
    final DestinationRepository destinationRepository,
    final DestinationListener destinationListener
  ) {
    this.destinationRepository = destinationRepository;
    this.destinationListener = destinationListener;
  }

  @Override
  public CreateDestinationResponse handle(final CreateDestinationRequest request)
    throws DIDAlreadyExistsException, GenericCreateDestinationFailureException {
    try {
      final var destination = DestinationFactory.create(request.getDestinationDetails());
      destinationListener.onDestinationCreateRequest(destination);
      destinationRepository.insert(destination);
      destinationListener.onDestinationCreated(destination);

      final var response = new CreateDestinationResponse();
      response.setOK(OK.ACKNOWLEDGED_AND_COMPLETED);
      return response;
    } catch (final RuntimeException e) {
      throw new GenericCreateDestinationFailureException(e);
    }
  }

  @Override
  public Class<? extends X1RequestMessage> getRequestClass() {
    return CreateDestinationRequest.class;
  }
}
