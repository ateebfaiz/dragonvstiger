package org.cocos2dx.okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class AsyncTimeout extends Timeout {
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    class a implements Sink {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Sink f1764a;

        a(Sink sink) {
            this.f1764a = sink;
        }

        public void close() {
            AsyncTimeout.this.enter();
            try {
                this.f1764a.close();
                AsyncTimeout.this.exit(true);
            } catch (IOException e10) {
                throw AsyncTimeout.this.exit(e10);
            } catch (Throwable th) {
                AsyncTimeout.this.exit(false);
                throw th;
            }
        }

        public void flush() {
            AsyncTimeout.this.enter();
            try {
                this.f1764a.flush();
                AsyncTimeout.this.exit(true);
            } catch (IOException e10) {
                throw AsyncTimeout.this.exit(e10);
            } catch (Throwable th) {
                AsyncTimeout.this.exit(false);
                throw th;
            }
        }

        public Timeout timeout() {
            return AsyncTimeout.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f1764a + ")";
        }

        public void write(Buffer buffer, long j10) {
            g.b(buffer.size, 0, j10);
            while (true) {
                long j11 = 0;
                if (j10 > 0) {
                    d dVar = buffer.head;
                    while (true) {
                        if (j11 >= 65536) {
                            break;
                        }
                        j11 += (long) (dVar.f1791c - dVar.f1790b);
                        if (j11 >= j10) {
                            j11 = j10;
                            break;
                        }
                        dVar = dVar.f1794f;
                    }
                    AsyncTimeout.this.enter();
                    try {
                        this.f1764a.write(buffer, j11);
                        j10 -= j11;
                        AsyncTimeout.this.exit(true);
                    } catch (IOException e10) {
                        throw AsyncTimeout.this.exit(e10);
                    } catch (Throwable th) {
                        AsyncTimeout.this.exit(false);
                        throw th;
                    }
                } else {
                    return;
                }
            }
        }
    }

    class b implements Source {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Source f1766a;

        b(Source source) {
            this.f1766a = source;
        }

        public void close() {
            try {
                this.f1766a.close();
                AsyncTimeout.this.exit(true);
            } catch (IOException e10) {
                throw AsyncTimeout.this.exit(e10);
            } catch (Throwable th) {
                AsyncTimeout.this.exit(false);
                throw th;
            }
        }

        public long read(Buffer buffer, long j10) {
            AsyncTimeout.this.enter();
            try {
                long read = this.f1766a.read(buffer, j10);
                AsyncTimeout.this.exit(true);
                return read;
            } catch (IOException e10) {
                throw AsyncTimeout.this.exit(e10);
            } catch (Throwable th) {
                AsyncTimeout.this.exit(false);
                throw th;
            }
        }

        public Timeout timeout() {
            return AsyncTimeout.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f1766a + ")";
        }
    }

    private static final class c extends Thread {
        c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r1.timedOut();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<org.cocos2dx.okio.AsyncTimeout> r0 = org.cocos2dx.okio.AsyncTimeout.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                org.cocos2dx.okio.AsyncTimeout r1 = org.cocos2dx.okio.AsyncTimeout.awaitTimeout()     // Catch:{ all -> 0x000b }
                if (r1 != 0) goto L_0x000d
                monitor-exit(r0)     // Catch:{ all -> 0x000b }
                goto L_0x0000
            L_0x000b:
                r1 = move-exception
                goto L_0x001b
            L_0x000d:
                org.cocos2dx.okio.AsyncTimeout r2 = org.cocos2dx.okio.AsyncTimeout.head     // Catch:{ all -> 0x000b }
                if (r1 != r2) goto L_0x0016
                r1 = 0
                org.cocos2dx.okio.AsyncTimeout.head = r1     // Catch:{ all -> 0x000b }
                monitor-exit(r0)     // Catch:{ all -> 0x000b }
                return
            L_0x0016:
                monitor-exit(r0)     // Catch:{ all -> 0x000b }
                r1.timedOut()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x001b:
                monitor-exit(r0)     // Catch:{ all -> 0x000b }
                throw r1     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okio.AsyncTimeout.c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    static AsyncTimeout awaitTimeout() throws InterruptedException {
        AsyncTimeout asyncTimeout = head.next;
        Class<AsyncTimeout> cls = AsyncTimeout.class;
        if (asyncTimeout == null) {
            long nanoTime = System.nanoTime();
            cls.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || System.nanoTime() - nanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long remainingNanos = asyncTimeout.remainingNanos(System.nanoTime());
        if (remainingNanos > 0) {
            long j10 = remainingNanos / 1000000;
            cls.wait(j10, (int) (remainingNanos - (1000000 * j10)));
            return null;
        }
        head.next = asyncTimeout.next;
        asyncTimeout.next = null;
        return asyncTimeout;
    }

    private static synchronized boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
        synchronized (AsyncTimeout.class) {
            AsyncTimeout asyncTimeout2 = head;
            while (asyncTimeout2 != null) {
                AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                if (asyncTimeout3 == asyncTimeout) {
                    asyncTimeout2.next = asyncTimeout.next;
                    asyncTimeout.next = null;
                    return false;
                }
                asyncTimeout2 = asyncTimeout3;
            }
            return true;
        }
    }

    private long remainingNanos(long j10) {
        return this.timeoutAt - j10;
    }

    private static synchronized void scheduleTimeout(AsyncTimeout asyncTimeout, long j10, boolean z10) {
        synchronized (AsyncTimeout.class) {
            try {
                if (head == null) {
                    head = new AsyncTimeout();
                    new c().start();
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
                long remainingNanos = asyncTimeout.remainingNanos(nanoTime);
                AsyncTimeout asyncTimeout2 = head;
                while (true) {
                    AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                    if (asyncTimeout3 == null) {
                        break;
                    } else if (remainingNanos < asyncTimeout3.remainingNanos(nanoTime)) {
                        break;
                    } else {
                        asyncTimeout2 = asyncTimeout2.next;
                    }
                }
                asyncTimeout.next = asyncTimeout2.next;
                asyncTimeout2.next = asyncTimeout;
                if (asyncTimeout2 == head) {
                    AsyncTimeout.class.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void enter() {
        if (!this.inQueue) {
            long timeoutNanos = timeoutNanos();
            boolean hasDeadline = hasDeadline();
            if (timeoutNanos != 0 || hasDeadline) {
                this.inQueue = true;
                scheduleTimeout(this, timeoutNanos, hasDeadline);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
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
        return new a(sink);
    }

    public final Source source(Source source) {
        return new b(source);
    }

    /* access modifiers changed from: protected */
    public void timedOut() {
    }

    /* access modifiers changed from: package-private */
    public final void exit(boolean z10) throws IOException {
        if (exit() && z10) {
            throw newTimeoutException((IOException) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final IOException exit(IOException iOException) throws IOException {
        if (!exit()) {
            return iOException;
        }
        return newTimeoutException(iOException);
    }
}
