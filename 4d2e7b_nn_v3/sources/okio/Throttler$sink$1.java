package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import kotlin.jvm.internal.m;

public final class Throttler$sink$1 extends ForwardingSink {
    final /* synthetic */ Sink $sink;
    final /* synthetic */ Throttler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Throttler$sink$1(Throttler throttler, Sink sink, Sink sink2) {
        super(sink2);
        this.this$0 = throttler;
        this.$sink = sink;
    }

    public void write(Buffer buffer, long j10) throws IOException {
        m.f(buffer, "source");
        while (j10 > 0) {
            try {
                long take$okio = this.this$0.take$okio(j10);
                super.write(buffer, take$okio);
                j10 -= take$okio;
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException("interrupted");
            }
        }
    }
}
