package okio;

import kotlin.jvm.internal.m;

final class BlackholeSink implements Sink {
    public void close() {
    }

    public void flush() {
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public void write(Buffer buffer, long j10) {
        m.f(buffer, "source");
        buffer.skip(j10);
    }
}
