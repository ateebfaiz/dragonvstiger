package okio;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.m;

public final class Timeout$Companion$NONE$1 extends Timeout {
    Timeout$Companion$NONE$1() {
    }

    public Timeout deadlineNanoTime(long j10) {
        return this;
    }

    public void throwIfReached() {
    }

    public Timeout timeout(long j10, TimeUnit timeUnit) {
        m.f(timeUnit, "unit");
        return this;
    }
}
