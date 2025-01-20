/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.protocol.error;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class DestinationInUseException extends ErrorResponseException {

  public DestinationInUseException(final Set<UUID> xIDs) {
    super(DESTINATION_IN_USE, String.join(", ", xIDs.stream().map(UUID::toString).collect(Collectors.toSet())));
  }
}
