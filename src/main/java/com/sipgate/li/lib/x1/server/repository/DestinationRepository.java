package com.sipgate.li.lib.x1.server.repository;

import com.sipgate.li.lib.x1.server.entity.Destination;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface DestinationRepository {
  void insert(Destination destination);

  Optional<Destination> findByDID(UUID dId);

  Set<Destination> findByDIDs(Set<UUID> dIds);

  void update(Destination destination);

  void deleteByDID(UUID uuid);

  Set<Destination> getAllDestinations();
}
