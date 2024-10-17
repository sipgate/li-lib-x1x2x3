package com.sipgate.li.lib.x1.server.repository;

import com.sipgate.li.lib.x1.server.entity.Task;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository {
  List<Task> getAllTasks();

  void insert(Task task);

  void deleteByXID(UUID xID);

  Optional<Task> findByXID(UUID uuid);

  void update(Task task);
}
