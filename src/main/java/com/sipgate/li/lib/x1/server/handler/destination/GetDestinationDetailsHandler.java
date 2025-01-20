/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.server.handler.destination;

import com.sipgate.li.lib.x1.protocol.error.DIDDoesNotExistException;
import com.sipgate.li.lib.x1.server.entity.DestinationFactory;
import com.sipgate.li.lib.x1.server.handler.X1RequestHandler;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
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
  public GetDestinationDetailsResponse handle(final GetDestinationDetailsRequest request)
    throws DIDDoesNotExistException {
    final var dID = UUID.fromString(request.getDId());
    final var maybeDestination = destinationRepository.findByDID(dID);

    if (maybeDestination.isEmpty()) {
      throw new DIDDoesNotExistException(dID);
    }

    return GetDestinationDetailsResponse.builder()
      .withDestinationResponseDetails(DestinationFactory.create(maybeDestination.get()))
      .build();
  }

  @Override
  public Class<? extends X1RequestMessage> getRequestClass() {
    return GetDestinationDetailsRequest.class;
  }
}
