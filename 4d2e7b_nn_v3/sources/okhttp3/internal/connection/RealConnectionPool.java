package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;

public final class RealConnectionPool {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final TaskQueue cleanupQueue;
    private final RealConnectionPool$cleanupTask$1 cleanupTask = new RealConnectionPool$cleanupTask$1(this, Util.okHttpName + " ConnectionPool");
    private final ConcurrentLinkedQueue<RealConnection> connections = new ConcurrentLinkedQueue<>();
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    public static final class Companion {
        private Companion() {
        }

        public final RealConnectionPool get(ConnectionPool connectionPool) {
            m.f(connectionPool, "connectionPool");
            return connectionPool.getDelegate$okhttp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RealConnectionPool(TaskRunner taskRunner, int i10, long j10, TimeUnit timeUnit) {
        boolean z10;
        m.f(taskRunner, "taskRunner");
        m.f(timeUnit, "timeUnit");
        this.maxIdleConnections = i10;
        this.keepAliveDurationNs = timeUnit.toNanos(j10);
        this.cleanupQueue = taskRunner.newQueue();
        if (j10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("keepAliveDuration <= 0: " + j10).toString());
        }
    }

    private final int pruneAndGetAllocationCount(RealConnection realConnection, long j10) {
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnection)) {
            List<Reference<RealCall>> calls = realConnection.getCalls();
            int i10 = 0;
            while (i10 < calls.size()) {
                Reference reference = calls.get(i10);
                if (reference.get() != null) {
                    i10++;
                } else {
                    Platform.Companion.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. " + "Did you forget to close a response body?", ((RealCall.CallReference) reference).getCallStackTrace());
                    calls.remove(i10);
                    realConnection.setNoNewExchanges(true);
                    if (calls.isEmpty()) {
                        realConnection.setIdleAtNs$okhttp(j10 - this.keepAliveDurationNs);
                        return 0;
                    }
                }
            }
            return calls.size();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        m.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(realConnection);
        throw new AssertionError(sb2.toString());
    }

    public final boolean callAcquirePooledConnection(Address address, RealCall realCall, List<Route> list, boolean z10) {
        m.f(address, "address");
        m.f(realCall, NotificationCompat.CATEGORY_CALL);
        Iterator<RealConnection> it = this.connections.iterator();
        while (it.hasNext()) {
            RealConnection next = it.next();
            m.e(next, "connection");
            synchronized (next) {
                if (z10) {
                    try {
                        if (!next.isMultiplexed$okhttp()) {
                            Unit unit = Unit.f12577a;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (next.isEligible$okhttp(address, list)) {
                    realCall.acquireConnectionNoEvents(next);
                    return true;
                }
                Unit unit2 = Unit.f12577a;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x007e, code lost:
        okhttp3.internal.Util.closeQuietly(r4.socket());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008b, code lost:
        if (r11.connections.isEmpty() == false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x008d, code lost:
        r11.cleanupQueue.cancelAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0092, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long cleanup(long r12) {
        /*
            r11 = this;
            r0 = 1
            java.util.concurrent.ConcurrentLinkedQueue<okhttp3.internal.connection.RealConnection> r1 = r11.connections
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
            r3 = 0
            r4 = -9223372036854775808
            r5 = r4
            r4 = r3
            r3 = r2
        L_0x000e:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x0040
            java.lang.Object r7 = r1.next()
            okhttp3.internal.connection.RealConnection r7 = (okhttp3.internal.connection.RealConnection) r7
            java.lang.String r8 = "connection"
            kotlin.jvm.internal.m.e(r7, r8)
            monitor-enter(r7)
            int r8 = r11.pruneAndGetAllocationCount(r7, r12)     // Catch:{ all -> 0x0038 }
            if (r8 <= 0) goto L_0x0028
            int r3 = r3 + r0
            goto L_0x003c
        L_0x0028:
            int r2 = r2 + r0
            long r8 = r7.getIdleAtNs$okhttp()     // Catch:{ all -> 0x0038 }
            long r8 = r12 - r8
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 <= 0) goto L_0x003a
            kotlin.Unit r4 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0038 }
            r4 = r7
            r5 = r8
            goto L_0x003c
        L_0x0038:
            r12 = move-exception
            goto L_0x003e
        L_0x003a:
            kotlin.Unit r8 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0038 }
        L_0x003c:
            monitor-exit(r7)
            goto L_0x000e
        L_0x003e:
            monitor-exit(r7)
            throw r12
        L_0x0040:
            long r7 = r11.keepAliveDurationNs
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x0055
            int r1 = r11.maxIdleConnections
            if (r2 <= r1) goto L_0x004b
            goto L_0x0055
        L_0x004b:
            if (r2 <= 0) goto L_0x004f
            long r7 = r7 - r5
            return r7
        L_0x004f:
            if (r3 <= 0) goto L_0x0052
            return r7
        L_0x0052:
            r12 = -1
            return r12
        L_0x0055:
            kotlin.jvm.internal.m.c(r4)
            monitor-enter(r4)
            java.util.List r1 = r4.getCalls()     // Catch:{ all -> 0x0093 }
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x0093 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0093 }
            r1 = r1 ^ r0
            r2 = 0
            if (r1 == 0) goto L_0x006a
            monitor-exit(r4)
            return r2
        L_0x006a:
            long r7 = r4.getIdleAtNs$okhttp()     // Catch:{ all -> 0x0093 }
            long r7 = r7 + r5
            int r12 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r12 == 0) goto L_0x0075
            monitor-exit(r4)
            return r2
        L_0x0075:
            r4.setNoNewExchanges(r0)     // Catch:{ all -> 0x0093 }
            java.util.concurrent.ConcurrentLinkedQueue<okhttp3.internal.connection.RealConnection> r12 = r11.connections     // Catch:{ all -> 0x0093 }
            r12.remove(r4)     // Catch:{ all -> 0x0093 }
            monitor-exit(r4)
            java.net.Socket r12 = r4.socket()
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r12)
            java.util.concurrent.ConcurrentLinkedQueue<okhttp3.internal.connection.RealConnection> r12 = r11.connections
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x0092
            okhttp3.internal.concurrent.TaskQueue r12 = r11.cleanupQueue
            r12.cancelAll()
        L_0x0092:
            return r2
        L_0x0093:
            r12 = move-exception
            monitor-exit(r4)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnectionPool.cleanup(long):long");
    }

    public final boolean connectionBecameIdle(RealConnection realConnection) {
        m.f(realConnection, "connection");
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread = Thread.currentThread();
            m.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST hold lock on ");
            sb2.append(realConnection);
            throw new AssertionError(sb2.toString());
        } else if (realConnection.getNoNewExchanges() || this.maxIdleConnections == 0) {
            realConnection.setNoNewExchanges(true);
            this.connections.remove(realConnection);
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            return true;
        } else {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, (Object) null);
            return false;
        }
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        Socket socket;
        Iterator<RealConnection> it = this.connections.iterator();
        m.e(it, "connections.iterator()");
        while (it.hasNext()) {
            RealConnection next = it.next();
            m.e(next, "connection");
            synchronized (next) {
                if (next.getCalls().isEmpty()) {
                    it.remove();
                    next.setNoNewExchanges(true);
                    socket = next.socket();
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                Util.closeQuietly(socket);
            }
        }
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
    }

    public final int idleConnectionCount() {
        boolean isEmpty;
        ConcurrentLinkedQueue<RealConnection> concurrentLinkedQueue = this.connections;
        int i10 = 0;
        if (!(concurrentLinkedQueue instanceof Collection) || !concurrentLinkedQueue.isEmpty()) {
            for (RealConnection realConnection : concurrentLinkedQueue) {
                m.e(realConnection, "it");
                synchronized (realConnection) {
                    isEmpty = realConnection.getCalls().isEmpty();
                }
                if (isEmpty && (i10 = i10 + 1) < 0) {
                    r.t();
                }
            }
        }
        return i10;
    }

    public final void put(RealConnection realConnection) {
        m.f(realConnection, "connection");
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnection)) {
            this.connections.add(realConnection);
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, (Object) null);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        m.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(realConnection);
        throw new AssertionError(sb2.toString());
    }
}
