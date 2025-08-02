package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;

public class AsyncTimeout extends Timeout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long IDLE_TIMEOUT_MILLIS;
    /* access modifiers changed from: private */
    public static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    /* access modifiers changed from: private */
    public static AsyncTimeout head;
    private boolean inQueue;
    /* access modifiers changed from: private */
    public AsyncTimeout next;
    /* access modifiers changed from: private */
    public long timeoutAt;

    public static final class Companion {
        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
            synchronized (AsyncTimeout.class) {
                for (AsyncTimeout access$getHead$cp = AsyncTimeout.head; access$getHead$cp != null; access$getHead$cp = access$getHead$cp.next) {
                    if (access$getHead$cp.next == asyncTimeout) {
                        access$getHead$cp.next = asyncTimeout.next;
                        asyncTimeout.next = null;
                        return false;
                    }
                }
                return true;
            }
        }

        /* access modifiers changed from: private */
        public final void scheduleTimeout(AsyncTimeout asyncTimeout, long j10, boolean z10) {
            synchronized (AsyncTimeout.class) {
                try {
                    if (AsyncTimeout.head == null) {
                        AsyncTimeout.head = new AsyncTimeout();
                        new Watchdog().start();
                    }
                    long nanoTime = System.nanoTime();
                    int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
                    if (i10 != 0 && z10) {
                        asyncTimeout.timeoutAt = Math.min(j10, asyncTimeout.deadlineNanoTime() - nanoTime) + nanoTime;
                    } else if (i10 != 0) {
                        asyncTimeout.timeoutAt = j10 + nanoTime;
                    } else if (z10) {
                        asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
                    } else {
                        throw new AssertionError();
                    }
                    long access$remainingNanos = asyncTimeout.remainingNanos(nanoTime);
                    AsyncTimeout access$getHead$cp = AsyncTimeout.head;
                    m.c(access$getHead$cp);
                    while (true) {
                        if (access$getHead$cp.next == null) {
                            break;
                        }
                        AsyncTimeout access$getNext$p = access$getHead$cp.next;
                        m.c(access$getNext$p);
                        if (access$remainingNanos < access$getNext$p.remainingNanos(nanoTime)) {
                            break;
                        }
                        access$getHead$cp = access$getHead$cp.next;
                        m.c(access$getHead$cp);
                    }
                    asyncTimeout.next = access$getHead$cp.next;
                    access$getHead$cp.next = asyncTimeout;
                    if (access$getHead$cp == AsyncTimeout.head) {
                        AsyncTimeout.class.notify();
                    }
                    Unit unit = Unit.f12577a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final AsyncTimeout awaitTimeout$okio() throws InterruptedException {
            AsyncTimeout access$getHead$cp = AsyncTimeout.head;
            m.c(access$getHead$cp);
            AsyncTimeout access$getNext$p = access$getHead$cp.next;
            Class<AsyncTimeout> cls = AsyncTimeout.class;
            if (access$getNext$p == null) {
                long nanoTime = System.nanoTime();
                cls.wait(AsyncTimeout.IDLE_TIMEOUT_MILLIS);
                AsyncTimeout access$getHead$cp2 = AsyncTimeout.head;
                m.c(access$getHead$cp2);
                if (access$getHead$cp2.next != null || System.nanoTime() - nanoTime < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return AsyncTimeout.head;
            }
            long access$remainingNanos = access$getNext$p.remainingNanos(System.nanoTime());
            if (access$remainingNanos > 0) {
                long j10 = access$remainingNanos / 1000000;
                cls.wait(j10, (int) (access$remainingNanos - (1000000 * j10)));
                return null;
            }
            AsyncTimeout access$getHead$cp3 = AsyncTimeout.head;
            m.c(access$getHead$cp3);
            access$getHead$cp3.next = access$getNext$p.next;
            access$getNext$p.next = null;
            return access$getNext$p;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001a, code lost:
            if (r1 == null) goto L_0x0000;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x001c, code lost:
            r1.timedOut();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<okio.AsyncTimeout> r0 = okio.AsyncTimeout.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                okio.AsyncTimeout$Companion r1 = okio.AsyncTimeout.Companion     // Catch:{ all -> 0x0015 }
                okio.AsyncTimeout r1 = r1.awaitTimeout$okio()     // Catch:{ all -> 0x0015 }
                okio.AsyncTimeout r2 = okio.AsyncTimeout.head     // Catch:{ all -> 0x0015 }
                if (r1 != r2) goto L_0x0017
                r1 = 0
                okio.AsyncTimeout.head = r1     // Catch:{ all -> 0x0015 }
                monitor-exit(r0)     // Catch:{ InterruptedException -> 0x0000 }
                return
            L_0x0015:
                r1 = move-exception
                goto L_0x0020
            L_0x0017:
                kotlin.Unit r2 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0015 }
                monitor-exit(r0)     // Catch:{ InterruptedException -> 0x0000 }
                if (r1 == 0) goto L_0x0000
                r1.timedOut()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0020:
                monitor-exit(r0)     // Catch:{ InterruptedException -> 0x0000 }
                throw r1     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.Watchdog.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* access modifiers changed from: private */
    public final long remainingNanos(long j10) {
        return this.timeoutAt - j10;
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void enter() {
        if (!this.inQueue) {
            long timeoutNanos = timeoutNanos();
            boolean hasDeadline = hasDeadline();
            if (timeoutNanos != 0 || hasDeadline) {
                this.inQueue = true;
                Companion.scheduleTimeout(this, timeoutNanos, hasDeadline);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit".toString());
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return Companion.cancelScheduledTimeout(this);
    }

    /* access modifiers changed from: protected */
    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(Sink sink) {
        m.f(sink, "sink");
        return new AsyncTimeout$sink$1(this, sink);
    }

    public final Source source(Source source) {
        m.f(source, "source");
        return new AsyncTimeout$source$1(this, source);
    }

    /* access modifiers changed from: protected */
    public void timedOut() {
    }

    public final <T> T withTimeout(Function0<? extends T> function0) {
        m.f(function0, "block");
        enter();
        try {
            T invoke = function0.invoke();
            k.b(1);
            if (!exit()) {
                k.a(1);
                return invoke;
            }
            throw access$newTimeoutException((IOException) null);
        } catch (IOException e10) {
            e = e10;
            if (exit()) {
                e = access$newTimeoutException(e);
            }
            throw e;
        } catch (Throwable th) {
            k.b(1);
            exit();
            k.a(1);
            throw th;
        }
    }
}
