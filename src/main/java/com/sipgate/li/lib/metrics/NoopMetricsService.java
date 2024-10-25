package com.sipgate.li.lib.metrics;

public class NoopMetricsService implements MetricsService {

  public NoopMetricsService incrementCounter(final String counterName, final String... tags) {
    return this;
  }
}
