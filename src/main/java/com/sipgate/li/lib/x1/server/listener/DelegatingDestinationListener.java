/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.x1.server.listener;

import com.sipgate.li.lib.x1.server.entity.Destination;
import java.util.UUID;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DelegatingDestinationListener implements DestinationListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(DelegatingDestinationListener.class);

  private DestinationListener delegate = new NoopDestinationListener();

  public DelegatingDestinationListener setDelegate(final DestinationListener delegate) {
    this.delegate = delegate;
    return this;
  }

  @Override
  public void onDestinationCreated(final Destination destination) {
    callDelegate(delegate::onDestinationCreated, destination);
  }

  @Override
  public void onDestinationRemoved(final UUID dId) {
    callDelegate(delegate::onDestinationRemoved, dId);
  }

  @Override
  public void onDestinationModified(final Destination destination) {
    callDelegate(delegate::onDestinationModified, destination);
  }

  @Override
  public void onDestinationCreateRequest(final Destination destination) {
    delegate.onDestinationCreateRequest(destination);
  }

  @Override
  public void onDestinationRemoveRequest(final UUID dId) {
    delegate.onDestinationRemoveRequest(dId);
  }

  @Override
  public void onDestinationModifyRequest(final Destination destination) {
    delegate.onDestinationModifyRequest(destination);
  }

  private <T> void callDelegate(final Consumer<T> consumer, final T value) {
    try {
      consumer.accept(value);
    } catch (final Exception e) {
      LOGGER.error("Ignoring exception from DestinationListener", e);
    }
  }

  private static class NoopDestinationListener implements DestinationListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoopDestinationListener.class);

    @Override
    public void onDestinationCreated(final Destination destination) {
      LOGGER.trace("Destination activated: {}", destination);
    }

    @Override
    public void onDestinationRemoved(final UUID dId) {
      LOGGER.trace("Destination deactivated: {}", dId);
    }

    @Override
    public void onDestinationModified(final Destination destination) {
      LOGGER.trace("Destination modified: {}", destination);
    }

    @Override
    public void onDestinationCreateRequest(final Destination destination) {
      LOGGER.trace("Destination activation request: {}", destination);
    }

    @Override
    public void onDestinationRemoveRequest(final UUID dId) {
      LOGGER.trace("Destination deactivation request: {}", dId);
    }

    @Override
    public void onDestinationModifyRequest(final Destination destination) {
      LOGGER.trace("Destination modification request: {}", destination);
    }
  }
}
