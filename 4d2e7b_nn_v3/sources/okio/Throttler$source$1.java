package okio;

import java.io.InterruptedIOException;
import kotlin.jvm.internal.m;

public final class Throttler$source$1 extends ForwardingSource {
    final /* synthetic */ Source $source;
    final /* synthetic */ Throttler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Throttler$source$1(Throttler throttler, Source source, Source source2) {
        super(source2);
        this.this$0 = throttler;
        this.$source = source;
    }

    public long read(Buffer buffer, long j10) {
        m.f(buffer, "sink");
        try {
            return super.read(buffer, this.this$0.take$okio(j10));
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}
