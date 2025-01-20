/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.server.repository;

import com.sipgate.li.lib.x1.protocol.error.DIDDoesNotExistException;
import com.sipgate.li.lib.x1.protocol.error.XIDAlreadyExistsException;
import com.sipgate.li.lib.x1.protocol.error.XIDDoesNotExistException;
import com.sipgate.li.lib.x1.server.entity.Task;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository {
  List<Task> getAllTasks();

  void insert(Task task) throws XIDAlreadyExistsException, DIDDoesNotExistException;

  void deleteByXID(UUID xID) throws XIDDoesNotExistException;

  Optional<Task> findByXID(UUID uuid);

  void update(Task task) throws XIDDoesNotExistException, DIDDoesNotExistException;
}
