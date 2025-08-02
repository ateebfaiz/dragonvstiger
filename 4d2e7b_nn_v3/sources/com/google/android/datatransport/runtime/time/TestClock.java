package com.google.android.datatransport.runtime.time;

import java.util.concurrent.atomic.AtomicLong;

public class TestClock implements Clock {
    private final AtomicLong timestamp;

    public TestClock(long j10) {
        this.timestamp = new AtomicLong(j10);
    }

    public void advance(long j10) {
        if (j10 >= 0) {
            this.timestamp.addAndGet(j10);
            return;
        }
        throw new IllegalArgumentException("cannot advance time backwards.");
    }

    public long getTime() {
        return this.timestamp.get();
    }

    public void tick() {
        advance(1);
    }
}
