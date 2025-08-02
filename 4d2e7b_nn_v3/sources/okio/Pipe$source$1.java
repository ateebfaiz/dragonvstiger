package okio;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.m;

public final class Pipe$source$1 implements Source {
    final /* synthetic */ Pipe this$0;
    private final Timeout timeout = new Timeout();

    Pipe$source$1(Pipe pipe) {
        this.this$0 = pipe;
    }

    public void close() {
        synchronized (this.this$0.getBuffer$okio()) {
            this.this$0.setSourceClosed$okio(true);
            Buffer buffer$okio = this.this$0.getBuffer$okio();
            if (buffer$okio != null) {
                buffer$okio.notifyAll();
                Unit unit = Unit.f12577a;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
            }
        }
    }

    public long read(Buffer buffer, long j10) {
        m.f(buffer, "sink");
        synchronized (this.this$0.getBuffer$okio()) {
            try {
                if (!(!this.this$0.getSourceClosed$okio())) {
                    throw new IllegalStateException("closed".toString());
                } else if (!this.this$0.getCanceled$okio()) {
                    while (this.this$0.getBuffer$okio().size() == 0) {
                        if (this.this$0.getSinkClosed$okio()) {
                            return -1;
                        }
                        this.timeout.waitUntilNotified(this.this$0.getBuffer$okio());
                        if (this.this$0.getCanceled$okio()) {
                            throw new IOException("canceled");
                        }
                    }
                    long read = this.this$0.getBuffer$okio().read(buffer, j10);
                    Buffer buffer$okio = this.this$0.getBuffer$okio();
                    if (buffer$okio != null) {
                        buffer$okio.notifyAll();
                        return read;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                } else {
                    throw new IOException("canceled");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Timeout timeout() {
        return this.timeout;
    }
}
