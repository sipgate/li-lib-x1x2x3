package com.sipgate.li.lib.metrics;

import java.util.function.Supplier;

public interface MetricsService {
  /**
   * Increment a named counter by one (1).
   *
   * @param counterName The name of the metric
   * @param tags Array of key-value pairs
   */
  MetricsService incrementCounter(final String counterName, final String... tags);

  /**
   * Record the time for the execution of supplier
   * @param timerName The name of the counter
   * @param supplier The supplier to execute
   * @param tags Array of key-value pairs
   * @return the return value of the supplier
   * @param <T> the return type of the supplier
   */
  <T> T recordTime(final String timerName, Supplier<T> supplier, final String... tags);
}
