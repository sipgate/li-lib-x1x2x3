package com.sipgate.li.lib.x1.server.handler.destination;

import com.sipgate.li.lib.x1.server.entity.DestinationFactory;
import com.sipgate.li.lib.x1.server.handler.X1RequestHandler;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.etsi.uri._03221.x1._2017._10.GetDestinationDetailsRequest;
import org.etsi.uri._03221.x1._2017._10.GetDestinationDetailsResponse;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;

public class GetDestinationDetailsHandler
  implements X1RequestHandler<GetDestinationDetailsRequest, GetDestinationDetailsResponse> {

  private final DestinationRepository destinationRepository;

  public GetDestinationDetailsHandler(final DestinationRepository destinationRepository) {
    this.destinationRepository = destinationRepository;
  }

  @Override
  public GetDestinationDetailsResponse handle(final GetDestinationDetailsRequest request) {
    final var maybeDestination = destinationRepository.findByDID(UUID.fromString(request.getDId()));

    if (maybeDestination.isEmpty()) {
      throw new NoSuchElementException("Destination not found: " + request.getDId());
    }

    final var response = new GetDestinationDetailsResponse();
    response.setDestinationResponseDetails(DestinationFactory.create(maybeDestination.get()));

    return response;
  }

  @Override
  public Class<? extends X1RequestMessage> getRequestClass() {
    return GetDestinationDetailsRequest.class;
  }
}
