package org.cocos2dx.okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class Timeout {
    public static final Timeout NONE = new a();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    class a extends Timeout {
        a() {
        }

        public Timeout deadlineNanoTime(long j10) {
            return this;
        }

        public void throwIfReached() {
        }

        public Timeout timeout(long j10, TimeUnit timeUnit) {
            return this;
        }
    }

    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public Timeout clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    public final Timeout deadline(long j10, TimeUnit timeUnit) {
        if (j10 <= 0) {
            throw new IllegalArgumentException("duration <= 0: " + j10);
        } else if (timeUnit != null) {
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j10));
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public Timeout timeout(long j10, TimeUnit timeUnit) {
        if (j10 < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j10);
        } else if (timeUnit != null) {
            this.timeoutNanos = timeUnit.toNanos(j10);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object obj) throws InterruptedIOException {
        try {
            boolean hasDeadline2 = hasDeadline();
            long timeoutNanos2 = timeoutNanos();
            long j10 = 0;
            if (hasDeadline2 || timeoutNanos2 != 0) {
                long nanoTime = System.nanoTime();
                if (hasDeadline2 && timeoutNanos2 != 0) {
                    timeoutNanos2 = Math.min(timeoutNanos2, deadlineNanoTime() - nanoTime);
                } else if (hasDeadline2) {
                    timeoutNanos2 = deadlineNanoTime() - nanoTime;
                }
                if (timeoutNanos2 > 0) {
                    long j11 = timeoutNanos2 / 1000000;
                    Long.signum(j11);
                    obj.wait(j11, (int) (timeoutNanos2 - (1000000 * j11)));
                    j10 = System.nanoTime() - nanoTime;
                }
                if (j10 >= timeoutNanos2) {
                    throw new InterruptedIOException("timeout");
                }
                return;
            }
            obj.wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public Timeout deadlineNanoTime(long j10) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j10;
        return this;
    }
}
