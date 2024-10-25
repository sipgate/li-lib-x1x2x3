package com.sipgate.li.lib.x1.server.repository;

import com.sipgate.li.lib.x1.server.entity.Destination;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DestinationRepository {
  void insert(Destination destination);

  Optional<Destination> findByDID(UUID uuid);

  void update(Destination destination);

  void deleteByDID(UUID uuid);

  List<Destination> getAllDestinations();
}
