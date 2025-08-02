package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.m;

public final class Pipe$sink$1 implements Sink {
    final /* synthetic */ Pipe this$0;
    private final Timeout timeout = new Timeout();

    Pipe$sink$1(Pipe pipe) {
        this.this$0 = pipe;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        r0 = r12.this$0;
        r2 = r1.timeout();
        r0 = r0.sink().timeout();
        r3 = r2.timeoutNanos();
        r5 = okio.Timeout.Companion.minTimeout(r0.timeoutNanos(), r2.timeoutNanos());
        r7 = java.util.concurrent.TimeUnit.NANOSECONDS;
        r2.timeout(r5, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007e, code lost:
        if (r2.hasDeadline() == false) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0080, code lost:
        r5 = r2.deadlineNanoTime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0088, code lost:
        if (r0.hasDeadline() == false) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008a, code lost:
        r2.deadlineNanoTime(java.lang.Math.min(r2.deadlineNanoTime(), r0.deadlineNanoTime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009c, code lost:
        r2.timeout(r3, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a3, code lost:
        if (r0.hasDeadline() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a5, code lost:
        r2.deadlineNanoTime(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a9, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00aa, code lost:
        r2.timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b3, code lost:
        if (r0.hasDeadline() != false) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b5, code lost:
        r2.deadlineNanoTime(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b8, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bd, code lost:
        if (r0.hasDeadline() == false) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bf, code lost:
        r2.deadlineNanoTime(r0.deadlineNanoTime());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c9, code lost:
        r2.timeout(r3, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d0, code lost:
        if (r0.hasDeadline() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d2, code lost:
        r2.clearDeadline();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d6, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d7, code lost:
        r2.timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e0, code lost:
        if (r0.hasDeadline() != false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e2, code lost:
        r2.clearDeadline();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e5, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r12 = this;
            okio.Pipe r0 = r12.this$0
            okio.Buffer r0 = r0.getBuffer$okio()
            monitor-enter(r0)
            okio.Pipe r1 = r12.this$0     // Catch:{ all -> 0x003b }
            boolean r1 = r1.getSinkClosed$okio()     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0011
            monitor-exit(r0)
            return
        L_0x0011:
            okio.Pipe r1 = r12.this$0     // Catch:{ all -> 0x003b }
            okio.Sink r1 = r1.getFoldedSink$okio()     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x001a
            goto L_0x0050
        L_0x001a:
            okio.Pipe r1 = r12.this$0     // Catch:{ all -> 0x003b }
            boolean r1 = r1.getSourceClosed$okio()     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x003e
            okio.Pipe r1 = r12.this$0     // Catch:{ all -> 0x003b }
            okio.Buffer r1 = r1.getBuffer$okio()     // Catch:{ all -> 0x003b }
            long r1 = r1.size()     // Catch:{ all -> 0x003b }
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0033
            goto L_0x003e
        L_0x0033:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x003b }
            java.lang.String r2 = "source is closed"
            r1.<init>(r2)     // Catch:{ all -> 0x003b }
            throw r1     // Catch:{ all -> 0x003b }
        L_0x003b:
            r1 = move-exception
            goto L_0x00ef
        L_0x003e:
            okio.Pipe r1 = r12.this$0     // Catch:{ all -> 0x003b }
            r2 = 1
            r1.setSinkClosed$okio(r2)     // Catch:{ all -> 0x003b }
            okio.Pipe r1 = r12.this$0     // Catch:{ all -> 0x003b }
            okio.Buffer r1 = r1.getBuffer$okio()     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x00e7
            r1.notifyAll()     // Catch:{ all -> 0x003b }
            r1 = 0
        L_0x0050:
            kotlin.Unit r2 = kotlin.Unit.f12577a     // Catch:{ all -> 0x003b }
            monitor-exit(r0)
            if (r1 == 0) goto L_0x00e6
            okio.Pipe r0 = r12.this$0
            okio.Timeout r2 = r1.timeout()
            okio.Sink r0 = r0.sink()
            okio.Timeout r0 = r0.timeout()
            long r3 = r2.timeoutNanos()
            okio.Timeout$Companion r5 = okio.Timeout.Companion
            long r6 = r0.timeoutNanos()
            long r8 = r2.timeoutNanos()
            long r5 = r5.minTimeout(r6, r8)
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.NANOSECONDS
            r2.timeout(r5, r7)
            boolean r5 = r2.hasDeadline()
            if (r5 == 0) goto L_0x00b9
            long r5 = r2.deadlineNanoTime()
            boolean r8 = r0.hasDeadline()
            if (r8 == 0) goto L_0x0099
            long r8 = r2.deadlineNanoTime()
            long r10 = r0.deadlineNanoTime()
            long r8 = java.lang.Math.min(r8, r10)
            r2.deadlineNanoTime(r8)
        L_0x0099:
            r1.close()     // Catch:{ all -> 0x00a9 }
            r2.timeout(r3, r7)
            boolean r0 = r0.hasDeadline()
            if (r0 == 0) goto L_0x00e6
            r2.deadlineNanoTime(r5)
            goto L_0x00e6
        L_0x00a9:
            r1 = move-exception
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.NANOSECONDS
            r2.timeout(r3, r7)
            boolean r0 = r0.hasDeadline()
            if (r0 == 0) goto L_0x00b8
            r2.deadlineNanoTime(r5)
        L_0x00b8:
            throw r1
        L_0x00b9:
            boolean r5 = r0.hasDeadline()
            if (r5 == 0) goto L_0x00c6
            long r5 = r0.deadlineNanoTime()
            r2.deadlineNanoTime(r5)
        L_0x00c6:
            r1.close()     // Catch:{ all -> 0x00d6 }
            r2.timeout(r3, r7)
            boolean r0 = r0.hasDeadline()
            if (r0 == 0) goto L_0x00e6
            r2.clearDeadline()
            goto L_0x00e6
        L_0x00d6:
            r1 = move-exception
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS
            r2.timeout(r3, r5)
            boolean r0 = r0.hasDeadline()
            if (r0 == 0) goto L_0x00e5
            r2.clearDeadline()
        L_0x00e5:
            throw r1
        L_0x00e6:
            return
        L_0x00e7:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ all -> 0x003b }
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.Object"
            r1.<init>(r2)     // Catch:{ all -> 0x003b }
            throw r1     // Catch:{ all -> 0x003b }
        L_0x00ef:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Pipe$sink$1.close():void");
    }

    public void flush() {
        Sink foldedSink$okio;
        synchronized (this.this$0.getBuffer$okio()) {
            try {
                if (!(!this.this$0.getSinkClosed$okio())) {
                    throw new IllegalStateException("closed".toString());
                } else if (!this.this$0.getCanceled$okio()) {
                    foldedSink$okio = this.this$0.getFoldedSink$okio();
                    if (foldedSink$okio == null) {
                        if (this.this$0.getSourceClosed$okio()) {
                            if (this.this$0.getBuffer$okio().size() > 0) {
                                throw new IOException("source is closed");
                            }
                        }
                        foldedSink$okio = null;
                    }
                    Unit unit = Unit.f12577a;
                } else {
                    throw new IOException("canceled");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (foldedSink$okio != null) {
            Pipe pipe = this.this$0;
            Timeout timeout2 = foldedSink$okio.timeout();
            Timeout timeout3 = pipe.sink().timeout();
            long timeoutNanos = timeout2.timeoutNanos();
            long minTimeout = Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos());
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            timeout2.timeout(minTimeout, timeUnit);
            if (timeout2.hasDeadline()) {
                long deadlineNanoTime = timeout2.deadlineNanoTime();
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                }
                try {
                    foldedSink$okio.flush();
                    timeout2.timeout(timeoutNanos, timeUnit);
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(deadlineNanoTime);
                    }
                } catch (Throwable th2) {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(deadlineNanoTime);
                    }
                    throw th2;
                }
            } else {
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                }
                try {
                    foldedSink$okio.flush();
                    timeout2.timeout(timeoutNanos, timeUnit);
                    if (timeout3.hasDeadline()) {
                        timeout2.clearDeadline();
                    }
                } catch (Throwable th3) {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.clearDeadline();
                    }
                    throw th3;
                }
            }
        }
    }

    public Timeout timeout() {
        return this.timeout;
    }

    public void write(Buffer buffer, long j10) {
        Sink sink;
        m.f(buffer, "source");
        synchronized (this.this$0.getBuffer$okio()) {
            try {
                if (!(!this.this$0.getSinkClosed$okio())) {
                    throw new IllegalStateException("closed".toString());
                } else if (!this.this$0.getCanceled$okio()) {
                    while (true) {
                        if (j10 <= 0) {
                            sink = null;
                            break;
                        }
                        sink = this.this$0.getFoldedSink$okio();
                        if (sink != null) {
                            break;
                        } else if (!this.this$0.getSourceClosed$okio()) {
                            long maxBufferSize$okio = this.this$0.getMaxBufferSize$okio() - this.this$0.getBuffer$okio().size();
                            if (maxBufferSize$okio == 0) {
                                this.timeout.waitUntilNotified(this.this$0.getBuffer$okio());
                                if (this.this$0.getCanceled$okio()) {
                                    throw new IOException("canceled");
                                }
                            } else {
                                long min = Math.min(maxBufferSize$okio, j10);
                                this.this$0.getBuffer$okio().write(buffer, min);
                                j10 -= min;
                                Buffer buffer$okio = this.this$0.getBuffer$okio();
                                if (buffer$okio != null) {
                                    buffer$okio.notifyAll();
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                                }
                            }
                        } else {
                            throw new IOException("source is closed");
                        }
                    }
                    Unit unit = Unit.f12577a;
                } else {
                    throw new IOException("canceled");
                }
            } finally {
            }
        }
        if (sink != null) {
            Pipe pipe = this.this$0;
            Timeout timeout2 = sink.timeout();
            Timeout timeout3 = pipe.sink().timeout();
            long timeoutNanos = timeout2.timeoutNanos();
            long minTimeout = Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos());
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            timeout2.timeout(minTimeout, timeUnit);
            if (timeout2.hasDeadline()) {
                long deadlineNanoTime = timeout2.deadlineNanoTime();
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                }
                try {
                    sink.write(buffer, j10);
                    timeout2.timeout(timeoutNanos, timeUnit);
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(deadlineNanoTime);
                    }
                } catch (Throwable th) {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(deadlineNanoTime);
                    }
                    throw th;
                }
            } else {
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                }
                try {
                    sink.write(buffer, j10);
                    timeout2.timeout(timeoutNanos, timeUnit);
                    if (timeout3.hasDeadline()) {
                        timeout2.clearDeadline();
                    }
                } catch (Throwable th2) {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.clearDeadline();
                    }
                    throw th2;
                }
            }
        }
    }
}
