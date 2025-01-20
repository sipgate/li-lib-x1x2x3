/*
 * SPDX-License-Identifier: MIT
 */
package com.sipgate.li.lib.metrics;

import java.util.function.Supplier;

public class NoopMetricsService implements MetricsService {

  public NoopMetricsService incrementCounter(final String counterName, final String... tags) {
    return this;
  }

  @Override
  public <T> T recordTime(final String timerName, final Supplier<T> supplier, final String... tags) {
    return supplier.get();
  }
}
