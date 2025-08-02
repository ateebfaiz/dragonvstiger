package okio;

import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.k;

public final class Pipe {
    private final Buffer buffer = new Buffer();
    private boolean canceled;
    private Sink foldedSink;
    private final long maxBufferSize;
    private final Sink sink;
    private boolean sinkClosed;
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long j10) {
        boolean z10;
        this.maxBufferSize = j10;
        if (j10 >= 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.sink = new Pipe$sink$1(this);
            this.source = new Pipe$source$1(this);
            return;
        }
        throw new IllegalArgumentException(("maxBufferSize < 1: " + j10).toString());
    }

    /* access modifiers changed from: private */
    public final void forward(Sink sink2, Function1<? super Sink, Unit> function1) {
        Timeout timeout = sink2.timeout();
        Timeout timeout2 = sink().timeout();
        long timeoutNanos = timeout.timeoutNanos();
        long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout.timeout(minTimeout, timeUnit);
        if (timeout.hasDeadline()) {
            long deadlineNanoTime = timeout.deadlineNanoTime();
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
            }
            try {
                function1.invoke(sink2);
                k.b(1);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                k.a(1);
            } catch (Throwable th) {
                k.b(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                k.a(1);
                throw th;
            }
        } else {
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
            }
            try {
                function1.invoke(sink2);
                k.b(1);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
                k.a(1);
            } catch (Throwable th2) {
                k.b(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
                k.a(1);
                throw th2;
            }
        }
    }

    /* renamed from: -deprecated_sink  reason: not valid java name */
    public final Sink m151deprecated_sink() {
        return this.sink;
    }

    /* renamed from: -deprecated_source  reason: not valid java name */
    public final Source m152deprecated_source() {
        return this.source;
    }

    public final void cancel() {
        synchronized (this.buffer) {
            this.canceled = true;
            this.buffer.clear();
            Buffer buffer2 = this.buffer;
            if (buffer2 != null) {
                buffer2.notifyAll();
                Unit unit = Unit.f12577a;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r8.write(r3, r3.size());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
        if (r1 == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0049, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004d, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004f, code lost:
        r8.flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0055, code lost:
        monitor-enter(r7.buffer);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r7.sourceClosed = true;
        r1 = r7.buffer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005a, code lost:
        if (r1 == null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0063, code lost:
        throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.Object");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0064, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0066, code lost:
        r1.notifyAll();
        r1 = kotlin.Unit.f12577a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x006c, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006e, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void fold(okio.Sink r8) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.m.f(r8, r0)
        L_0x0005:
            okio.Buffer r0 = r7.buffer
            monitor-enter(r0)
            okio.Sink r1 = r7.foldedSink     // Catch:{ all -> 0x0024 }
            r2 = 1
            if (r1 != 0) goto L_0x000f
            r1 = r2
            goto L_0x0010
        L_0x000f:
            r1 = 0
        L_0x0010:
            if (r1 == 0) goto L_0x0081
            boolean r1 = r7.canceled     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x0077
            okio.Buffer r1 = r7.buffer     // Catch:{ all -> 0x0024 }
            boolean r1 = r1.exhausted()     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0026
            r7.sourceClosed = r2     // Catch:{ all -> 0x0024 }
            r7.foldedSink = r8     // Catch:{ all -> 0x0024 }
            monitor-exit(r0)
            return
        L_0x0024:
            r8 = move-exception
            goto L_0x008d
        L_0x0026:
            boolean r1 = r7.sinkClosed     // Catch:{ all -> 0x0024 }
            okio.Buffer r3 = new okio.Buffer     // Catch:{ all -> 0x0024 }
            r3.<init>()     // Catch:{ all -> 0x0024 }
            okio.Buffer r4 = r7.buffer     // Catch:{ all -> 0x0024 }
            long r5 = r4.size()     // Catch:{ all -> 0x0024 }
            r3.write((okio.Buffer) r4, (long) r5)     // Catch:{ all -> 0x0024 }
            okio.Buffer r4 = r7.buffer     // Catch:{ all -> 0x0024 }
            if (r4 == 0) goto L_0x006f
            r4.notifyAll()     // Catch:{ all -> 0x0024 }
            kotlin.Unit r4 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0024 }
            monitor-exit(r0)
            long r4 = r3.size()     // Catch:{ all -> 0x004d }
            r8.write(r3, r4)     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x004f
            r8.close()     // Catch:{ all -> 0x004d }
            goto L_0x0005
        L_0x004d:
            r8 = move-exception
            goto L_0x0053
        L_0x004f:
            r8.flush()     // Catch:{ all -> 0x004d }
            goto L_0x0005
        L_0x0053:
            okio.Buffer r0 = r7.buffer
            monitor-enter(r0)
            r7.sourceClosed = r2     // Catch:{ all -> 0x0064 }
            okio.Buffer r1 = r7.buffer     // Catch:{ all -> 0x0064 }
            if (r1 != 0) goto L_0x0066
            java.lang.NullPointerException r8 = new java.lang.NullPointerException     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.Object"
            r8.<init>(r1)     // Catch:{ all -> 0x0064 }
            throw r8     // Catch:{ all -> 0x0064 }
        L_0x0064:
            r8 = move-exception
            goto L_0x006d
        L_0x0066:
            r1.notifyAll()     // Catch:{ all -> 0x0064 }
            kotlin.Unit r1 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0064 }
            monitor-exit(r0)
            throw r8
        L_0x006d:
            monitor-exit(r0)
            throw r8
        L_0x006f:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException     // Catch:{ all -> 0x0024 }
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.Object"
            r8.<init>(r1)     // Catch:{ all -> 0x0024 }
            throw r8     // Catch:{ all -> 0x0024 }
        L_0x0077:
            r7.foldedSink = r8     // Catch:{ all -> 0x0024 }
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0024 }
            java.lang.String r1 = "canceled"
            r8.<init>(r1)     // Catch:{ all -> 0x0024 }
            throw r8     // Catch:{ all -> 0x0024 }
        L_0x0081:
            java.lang.String r8 = "sink already folded"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0024 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0024 }
            r1.<init>(r8)     // Catch:{ all -> 0x0024 }
            throw r1     // Catch:{ all -> 0x0024 }
        L_0x008d:
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Pipe.fold(okio.Sink):void");
    }

    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean z10) {
        this.canceled = z10;
    }

    public final void setFoldedSink$okio(Sink sink2) {
        this.foldedSink = sink2;
    }

    public final void setSinkClosed$okio(boolean z10) {
        this.sinkClosed = z10;
    }

    public final void setSourceClosed$okio(boolean z10) {
        this.sourceClosed = z10;
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }
}
