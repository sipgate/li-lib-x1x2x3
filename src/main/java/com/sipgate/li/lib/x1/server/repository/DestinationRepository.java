/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.server.repository;

import com.sipgate.li.lib.x1.protocol.error.DIDAlreadyExistsException;
import com.sipgate.li.lib.x1.protocol.error.DIDDoesNotExistException;
import com.sipgate.li.lib.x1.protocol.error.DestinationInUseException;
import com.sipgate.li.lib.x1.server.entity.Destination;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface DestinationRepository {
  void insert(Destination destination) throws DIDAlreadyExistsException;

  Optional<Destination> findByDID(UUID dId);

  Set<Destination> findByDIDs(Set<UUID> dIds);

  void update(Destination destination) throws DIDDoesNotExistException;

  void deleteByDID(UUID uuid) throws DIDDoesNotExistException, DestinationInUseException;

  Set<Destination> getAllDestinations();
}
