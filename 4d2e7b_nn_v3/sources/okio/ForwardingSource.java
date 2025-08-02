package okio;

import java.io.IOException;
import kotlin.jvm.internal.m;

public abstract class ForwardingSource implements Source {
    private final Source delegate;

    public ForwardingSource(Source source) {
        m.f(source, "delegate");
        this.delegate = source;
    }

    /* renamed from: -deprecated_delegate  reason: not valid java name */
    public final Source m147deprecated_delegate() {
        return this.delegate;
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final Source delegate() {
        return this.delegate;
    }

    public long read(Buffer buffer, long j10) throws IOException {
        m.f(buffer, "sink");
        return this.delegate.read(buffer, j10);
    }

    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
