/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.server.listener;

import com.sipgate.li.lib.x1.server.entity.Destination;
import java.util.UUID;

public interface DestinationListener {
  /**
   * This method is called when a destination is requested to be created but is not yet inserted in to the repository.
   * You may throw an exception to reject the destination creation.
   *
   * @param destination The destination that is requested to be created.
   */
  void onDestinationCreateRequest(Destination destination);

  /**
   * This method is called when a destination is created. Exceptions will be ignored.
   *
   * @param destination The destination that is created.
   */
  void onDestinationCreated(Destination destination);

  /**
   * This method is called when a destination is requested to be removed but is not yet removed from the repository.
   * You may throw an exception to reject the destination removal.
   *
   * @param dId The destination that is requested to be removed.
   */
  void onDestinationRemoveRequest(UUID dId);

  /**
   * This method is called when a destination is removed. Exceptions will be ignored.
   *
   * @param dId The destination that is removed.
   */
  void onDestinationRemoved(UUID dId);

  /**
   * This method is called when a destination is requested to be modified but is not yet updated in the repository.
   * You may throw an exception to reject the destination modification.
   *
   * @param destination The destination that is requested to be modified.
   */
  void onDestinationModifyRequest(Destination destination);

  /**
   * This method is called when a destination is modified. Exceptions will be ignored.
   *
   * @param destination The destination that is modified.
   */
  void onDestinationModified(Destination destination);
}
