package com.sipgate.li.lib.x1.server.listener;

import com.sipgate.li.lib.x1.server.entity.Task;
import java.util.UUID;

public interface TaskListener {
  /**
   * This method is called when a task is requested to be activated but is not yet inserted in to the repository.
   * You may throw an exception to reject the task activation.
   *
   * @param task The task that is requested to be activated.
   */
  void onTaskActivateRequest(final Task task);

  /**
   * This method is called when a task is activated. Exceptions will be ignored.
   *
   * @param task The task that is activated.
   */
  void onTaskActivated(Task task);

  /**
   * This method is called when a task is requested to be deactivated but is not yet removed from the repository.
   * You may throw an exception to reject the task deactivation.
   *
   * @param xId The task that is requested to be deactivated.
   */
  void onTaskDeactivateRequest(final UUID xId);

  /**
   * This method is called when a task is deactivated. Exceptions will be ignored.
   *
   * @param xId The task that is deactivated.
   */
  void onTaskDeactivated(UUID xId);

  /**
   * This method is called when a task is requested to be modified but is not yet updated in the repository.
   * You may throw an exception to reject the task modification.
   *
   * @param task The task that is requested to be modified.
   */
  void onTaskModifyRequest(final Task task);

  /**
   * This method is called when a task is modified. Exceptions will be ignored.
   *
   * @param task The task that is modified.
   */
  void onTaskModified(Task task);
}
