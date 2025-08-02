package okio;

import java.io.IOException;
import kotlin.jvm.internal.m;

public abstract class ForwardingSink implements Sink {
    private final Sink delegate;

    public ForwardingSink(Sink sink) {
        m.f(sink, "delegate");
        this.delegate = sink;
    }

    /* renamed from: -deprecated_delegate  reason: not valid java name */
    public final Sink m146deprecated_delegate() {
        return this.delegate;
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final Sink delegate() {
        return this.delegate;
    }

    public void flush() throws IOException {
        this.delegate.flush();
    }

    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    public void write(Buffer buffer, long j10) throws IOException {
        m.f(buffer, "source");
        this.delegate.write(buffer, j10);
    }
}
