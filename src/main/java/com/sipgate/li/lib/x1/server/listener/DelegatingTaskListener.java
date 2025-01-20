/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.server.listener;

import com.sipgate.li.lib.x1.server.entity.Task;
import java.util.UUID;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DelegatingTaskListener implements TaskListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(DelegatingTaskListener.class);

  private TaskListener delegate = new NoopTaskListener();

  public DelegatingTaskListener setDelegate(final TaskListener delegate) {
    this.delegate = delegate;
    return this;
  }

  @Override
  public void onTaskActivated(final Task task) {
    callDelegate(delegate::onTaskActivated, task);
  }

  @Override
  public void onTaskDeactivated(final UUID uuid) {
    callDelegate(delegate::onTaskDeactivated, uuid);
  }

  @Override
  public void onTaskModified(final Task task) {
    callDelegate(delegate::onTaskModified, task);
  }

  @Override
  public void onTaskActivateRequest(final Task task) {
    delegate.onTaskActivateRequest(task);
  }

  @Override
  public void onTaskDeactivateRequest(final UUID uuid) {
    delegate.onTaskDeactivateRequest(uuid);
  }

  @Override
  public void onTaskModifyRequest(final Task task) {
    delegate.onTaskModifyRequest(task);
  }

  private <T> void callDelegate(final Consumer<T> consumer, final T value) {
    try {
      consumer.accept(value);
    } catch (final Exception e) {
      LOGGER.error("Ignoring exception from TaskListener", e);
    }
  }

  private static class NoopTaskListener implements TaskListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoopTaskListener.class);

    @Override
    public void onTaskActivated(final Task task) {
      LOGGER.trace("Task activated: {}", task);
    }

    @Override
    public void onTaskDeactivated(final UUID uuid) {
      LOGGER.trace("Task deactivated: {}", uuid);
    }

    @Override
    public void onTaskModified(final Task task) {
      LOGGER.trace("Task modified: {}", task);
    }

    @Override
    public void onTaskActivateRequest(final Task task) {
      LOGGER.trace("Task activation request: {}", task);
    }

    @Override
    public void onTaskDeactivateRequest(final UUID uuid) {
      LOGGER.trace("Task deactivation request: {}", uuid);
    }

    @Override
    public void onTaskModifyRequest(final Task task) {
      LOGGER.trace("Task modification request: {}", task);
    }
  }
}
