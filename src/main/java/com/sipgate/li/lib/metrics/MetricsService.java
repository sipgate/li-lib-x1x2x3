package com.sipgate.li.lib.metrics;

public interface MetricsService {
  /**
   * Increment a named counter by one (1).
   *
   * @param counterName The name of the metric
   * @param tags Array of key-value pairs
   */
  MetricsService incrementCounter(final String counterName, final String... tags);
}
