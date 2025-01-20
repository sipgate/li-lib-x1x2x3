/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.server.handler.destination;

import com.sipgate.li.lib.x1.protocol.error.DIDDoesNotExistException;
import com.sipgate.li.lib.x1.protocol.error.GenericModifyDestinationFailureException;
import com.sipgate.li.lib.x1.server.entity.DestinationFactory;
import com.sipgate.li.lib.x1.server.handler.X1RequestHandler;
import com.sipgate.li.lib.x1.server.listener.DestinationListener;
import com.sipgate.li.lib.x1.server.repository.DestinationRepository;
import org.etsi.uri._03221.x1._2017._10.ModifyDestinationRequest;
import org.etsi.uri._03221.x1._2017._10.ModifyDestinationResponse;
import org.etsi.uri._03221.x1._2017._10.OK;
import org.etsi.uri._03221.x1._2017._10.X1RequestMessage;

public class ModifyDestinationHandler implements X1RequestHandler<ModifyDestinationRequest, ModifyDestinationResponse> {

  private final DestinationRepository destinationRepository;
  private final DestinationListener destinationListener;

  public ModifyDestinationHandler(
    final DestinationRepository destinationRepository,
    final DestinationListener destinationListener
  ) {
    this.destinationRepository = destinationRepository;
    this.destinationListener = destinationListener;
  }

  @Override
  public ModifyDestinationResponse handle(final ModifyDestinationRequest request)
    throws DIDDoesNotExistException, GenericModifyDestinationFailureException {
    try {
      final var destination = DestinationFactory.create(request.getDestinationDetails());
      destinationListener.onDestinationModifyRequest(destination);
      destinationRepository.update(destination);
      destinationListener.onDestinationModified(destination);

      return ModifyDestinationResponse.builder().withOK(OK.ACKNOWLEDGED_AND_COMPLETED).build();
    } catch (final RuntimeException e) {
      throw new GenericModifyDestinationFailureException(e);
    }
  }

  @Override
  public Class<? extends X1RequestMessage> getRequestClass() {
    return ModifyDestinationRequest.class;
  }
}
