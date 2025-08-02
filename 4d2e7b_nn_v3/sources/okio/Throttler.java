package okio;

import kotlin.Unit;
import kotlin.jvm.internal.m;

public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private long maxByteCount;
    private long waitByteCount;

    public Throttler(long j10) {
        this.allocatedUntil = j10;
        this.waitByteCount = 8192;
        this.maxByteCount = 262144;
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler throttler, long j10, long j11, long j12, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j11 = throttler.waitByteCount;
        }
        long j13 = j11;
        if ((i10 & 4) != 0) {
            j12 = throttler.maxByteCount;
        }
        throttler.bytesPerSecond(j10, j13, j12);
    }

    private final long bytesToNanos(long j10) {
        return (j10 * 1000000000) / this.bytesPerSecond;
    }

    private final long nanosToBytes(long j10) {
        return (j10 * this.bytesPerSecond) / 1000000000;
    }

    private final void waitNanos(long j10) {
        long j11 = j10 / 1000000;
        wait(j11, (int) (j10 - (1000000 * j11)));
    }

    public final long byteCountOrWaitNanos$okio(long j10, long j11) {
        if (this.bytesPerSecond == 0) {
            return j11;
        }
        long max = Math.max(this.allocatedUntil - j10, 0);
        long nanosToBytes = this.maxByteCount - nanosToBytes(max);
        if (nanosToBytes >= j11) {
            this.allocatedUntil = j10 + max + bytesToNanos(j11);
            return j11;
        }
        long j12 = this.waitByteCount;
        if (nanosToBytes >= j12) {
            this.allocatedUntil = j10 + bytesToNanos(this.maxByteCount);
            return nanosToBytes;
        }
        long min = Math.min(j12, j11);
        long bytesToNanos = max + bytesToNanos(min - this.maxByteCount);
        if (bytesToNanos != 0) {
            return -bytesToNanos;
        }
        this.allocatedUntil = j10 + bytesToNanos(this.maxByteCount);
        return min;
    }

    public final void bytesPerSecond(long j10) {
        bytesPerSecond$default(this, j10, 0, 0, 6, (Object) null);
    }

    public final Sink sink(Sink sink) {
        m.f(sink, "sink");
        return new Throttler$sink$1(this, sink, sink);
    }

    public final Source source(Source source) {
        m.f(source, "source");
        return new Throttler$source$1(this, source, source);
    }

    public final long take$okio(long j10) {
        boolean z10;
        long byteCountOrWaitNanos$okio;
        if (j10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            synchronized (this) {
                while (true) {
                    byteCountOrWaitNanos$okio = byteCountOrWaitNanos$okio(System.nanoTime(), j10);
                    if (byteCountOrWaitNanos$okio < 0) {
                        waitNanos(-byteCountOrWaitNanos$okio);
                    }
                }
            }
            return byteCountOrWaitNanos$okio;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void bytesPerSecond(long j10, long j11) {
        bytesPerSecond$default(this, j10, j11, 0, 4, (Object) null);
    }

    public final void bytesPerSecond(long j10, long j11, long j12) {
        synchronized (this) {
            boolean z10 = false;
            if (j10 >= 0) {
                if (j11 > 0) {
                    if (j12 >= j11) {
                        z10 = true;
                    }
                    if (z10) {
                        this.bytesPerSecond = j10;
                        this.waitByteCount = j11;
                        this.maxByteCount = j12;
                        notifyAll();
                        Unit unit = Unit.f12577a;
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
    }

    public Throttler() {
        this(System.nanoTime());
    }
}
