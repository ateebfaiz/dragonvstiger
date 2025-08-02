package com.facebook.react.bridge;

import java.util.Map;

interface PerformanceCounter {
    Map<String, Long> getPerformanceCounters();

    void profileNextBatch();
}
