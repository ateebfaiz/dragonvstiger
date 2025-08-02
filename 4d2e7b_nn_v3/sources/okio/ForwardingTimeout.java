package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.m;

public class ForwardingTimeout extends Timeout {
    private Timeout delegate;

    public ForwardingTimeout(Timeout timeout) {
        m.f(timeout, "delegate");
        this.delegate = timeout;
    }

    public Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    public Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    public final Timeout delegate() {
        return this.delegate;
    }

    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    public void throwIfReached() throws IOException {
        this.delegate.throwIfReached();
    }

    public Timeout timeout(long j10, TimeUnit timeUnit) {
        m.f(timeUnit, "unit");
        return this.delegate.timeout(j10, timeUnit);
    }

    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }

    public Timeout deadlineNanoTime(long j10) {
        return this.delegate.deadlineNanoTime(j10);
    }

    public final ForwardingTimeout setDelegate(Timeout timeout) {
        m.f(timeout, "delegate");
        this.delegate = timeout;
        return this;
    }
}
