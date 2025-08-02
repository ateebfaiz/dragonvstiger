package org.cocos2dx.okhttp3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.connection.RealConnection;
import org.cocos2dx.okhttp3.internal.connection.RouteDatabase;
import org.cocos2dx.okhttp3.internal.connection.StreamAllocation;
import org.cocos2dx.okhttp3.internal.platform.Platform;

public final class ConnectionPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Executor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    private final Runnable cleanupRunnable;
    boolean cleanupRunning;
    private final Deque<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    final RouteDatabase routeDatabase;

    class a implements Runnable {
        a() {
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
            L_0x0000:
                org.cocos2dx.okhttp3.ConnectionPool r0 = org.cocos2dx.okhttp3.ConnectionPool.this
                long r1 = java.lang.System.nanoTime()
                long r0 = r0.cleanup(r1)
                r2 = -1
                int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r2 != 0) goto L_0x0011
                return
            L_0x0011:
                r2 = 0
                int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r2 <= 0) goto L_0x0000
                r2 = 1000000(0xf4240, double:4.940656E-318)
                long r4 = r0 / r2
                long r2 = r2 * r4
                long r0 = r0 - r2
                org.cocos2dx.okhttp3.ConnectionPool r2 = org.cocos2dx.okhttp3.ConnectionPool.this
                monitor-enter(r2)
                org.cocos2dx.okhttp3.ConnectionPool r3 = org.cocos2dx.okhttp3.ConnectionPool.this     // Catch:{ InterruptedException -> 0x002a }
                int r0 = (int) r0     // Catch:{ InterruptedException -> 0x002a }
                r3.wait(r4, r0)     // Catch:{ InterruptedException -> 0x002a }
                goto L_0x002a
            L_0x0028:
                r0 = move-exception
                goto L_0x002c
            L_0x002a:
                monitor-exit(r2)     // Catch:{ all -> 0x0028 }
                goto L_0x0000
            L_0x002c:
                monitor-exit(r2)     // Catch:{ all -> 0x0028 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.ConnectionPool.a.run():void");
        }
    }

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }

    private int pruneAndGetAllocationCount(RealConnection realConnection, long j10) {
        List<Reference<StreamAllocation>> list = realConnection.allocations;
        int i10 = 0;
        while (i10 < list.size()) {
            Reference reference = list.get(i10);
            if (reference.get() != null) {
                i10++;
            } else {
                Platform.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((StreamAllocation.StreamAllocationReference) reference).callStackTrace);
                list.remove(i10);
                realConnection.noNewStreams = true;
                if (list.isEmpty()) {
                    realConnection.idleAtNanos = j10 - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return list.size();
    }

    /* access modifiers changed from: package-private */
    public long cleanup(long j10) {
        synchronized (this) {
            try {
                RealConnection realConnection = null;
                long j11 = Long.MIN_VALUE;
                int i10 = 0;
                int i11 = 0;
                for (RealConnection next : this.connections) {
                    if (pruneAndGetAllocationCount(next, j10) > 0) {
                        i11++;
                    } else {
                        i10++;
                        long j12 = j10 - next.idleAtNanos;
                        if (j12 > j11) {
                            realConnection = next;
                            j11 = j12;
                        }
                    }
                }
                long j13 = this.keepAliveDurationNs;
                if (j11 < j13) {
                    if (i10 <= this.maxIdleConnections) {
                        if (i10 > 0) {
                            long j14 = j13 - j11;
                            return j14;
                        } else if (i11 > 0) {
                            return j13;
                        } else {
                            this.cleanupRunning = false;
                            return -1;
                        }
                    }
                }
                this.connections.remove(realConnection);
                Util.closeQuietly(realConnection.socket());
                return 0;
            } finally {
                while (true) {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean connectionBecameIdle(RealConnection realConnection) {
        if (realConnection.noNewStreams || this.maxIdleConnections == 0) {
            this.connections.remove(realConnection);
            return true;
        }
        notifyAll();
        return false;
    }

    public synchronized int connectionCount() {
        return this.connections.size();
    }

    /* access modifiers changed from: package-private */
    public Socket deduplicate(Address address, StreamAllocation streamAllocation) {
        for (RealConnection next : this.connections) {
            if (next.isEligible(address, (Route) null) && next.isMultiplexed() && next != streamAllocation.connection()) {
                return streamAllocation.releaseAndAcquire(next);
            }
        }
        return null;
    }

    public void evictAll() {
        ArrayList<RealConnection> arrayList = new ArrayList<>();
        synchronized (this) {
            try {
                Iterator<RealConnection> it = this.connections.iterator();
                while (it.hasNext()) {
                    RealConnection next = it.next();
                    if (next.allocations.isEmpty()) {
                        next.noNewStreams = true;
                        arrayList.add(next);
                        it.remove();
                    }
                }
            } finally {
                while (true) {
                }
            }
        }
        for (RealConnection socket : arrayList) {
            Util.closeQuietly(socket.socket());
        }
    }

    /* access modifiers changed from: package-private */
    public RealConnection get(Address address, StreamAllocation streamAllocation, Route route) {
        for (RealConnection next : this.connections) {
            if (next.isEligible(address, route)) {
                streamAllocation.acquire(next, true);
                return next;
            }
        }
        return null;
    }

    public synchronized int idleConnectionCount() {
        int i10;
        i10 = 0;
        for (RealConnection realConnection : this.connections) {
            if (realConnection.allocations.isEmpty()) {
                i10++;
            }
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public void put(RealConnection realConnection) {
        if (!this.cleanupRunning) {
            this.cleanupRunning = true;
            executor.execute(this.cleanupRunnable);
        }
        this.connections.add(realConnection);
    }

    public ConnectionPool(int i10, long j10, TimeUnit timeUnit) {
        this.cleanupRunnable = new a();
        this.connections = new ArrayDeque();
        this.routeDatabase = new RouteDatabase();
        this.maxIdleConnections = i10;
        this.keepAliveDurationNs = timeUnit.toNanos(j10);
        if (j10 <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j10);
        }
    }
}
