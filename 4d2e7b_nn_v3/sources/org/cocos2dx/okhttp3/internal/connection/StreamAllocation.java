package org.cocos2dx.okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import org.cocos2dx.okhttp3.Address;
import org.cocos2dx.okhttp3.Call;
import org.cocos2dx.okhttp3.ConnectionPool;
import org.cocos2dx.okhttp3.EventListener;
import org.cocos2dx.okhttp3.Interceptor;
import org.cocos2dx.okhttp3.OkHttpClient;
import org.cocos2dx.okhttp3.Route;
import org.cocos2dx.okhttp3.internal.Internal;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.connection.RouteSelector;
import org.cocos2dx.okhttp3.internal.http.HttpCodec;

public final class StreamAllocation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Address address;
    public final Call call;
    private final Object callStackTrace;
    private boolean canceled;
    private HttpCodec codec;
    private RealConnection connection;
    private final ConnectionPool connectionPool;
    public final EventListener eventListener;
    private int refusedStreamCount;
    private boolean released;
    private boolean reportedAcquired;
    private Route route;
    private RouteSelector.Selection routeSelection;
    private final RouteSelector routeSelector;

    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final Object callStackTrace;

        StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.callStackTrace = obj;
        }
    }

    public StreamAllocation(ConnectionPool connectionPool2, Address address2, Call call2, EventListener eventListener2, Object obj) {
        this.connectionPool = connectionPool2;
        this.address = address2;
        this.call = call2;
        this.eventListener = eventListener2;
        this.routeSelector = new RouteSelector(address2, routeDatabase(), call2, eventListener2);
        this.callStackTrace = obj;
    }

    private Socket deallocate(boolean z10, boolean z11, boolean z12) {
        Socket socket;
        if (z12) {
            this.codec = null;
        }
        if (z11) {
            this.released = true;
        }
        RealConnection realConnection = this.connection;
        if (realConnection == null) {
            return null;
        }
        if (z10) {
            realConnection.noNewStreams = true;
        }
        if (this.codec != null) {
            return null;
        }
        if (!this.released && !realConnection.noNewStreams) {
            return null;
        }
        release(realConnection);
        if (this.connection.allocations.isEmpty()) {
            this.connection.idleAtNanos = System.nanoTime();
            if (Internal.instance.connectionBecameIdle(this.connectionPool, this.connection)) {
                socket = this.connection.socket();
                this.connection = null;
                return socket;
            }
        }
        socket = null;
        this.connection = null;
        return socket;
    }

    private RealConnection findConnection(int i10, int i11, int i12, int i13, boolean z10) throws IOException {
        RealConnection realConnection;
        Socket releaseIfNoNewStreams;
        RealConnection realConnection2;
        Socket socket;
        boolean z11;
        Route route2;
        boolean z12;
        RouteSelector.Selection selection;
        synchronized (this.connectionPool) {
            try {
                if (this.released) {
                    throw new IllegalStateException("released");
                } else if (this.codec != null) {
                    throw new IllegalStateException("codec != null");
                } else if (!this.canceled) {
                    realConnection = this.connection;
                    releaseIfNoNewStreams = releaseIfNoNewStreams();
                    realConnection2 = this.connection;
                    socket = null;
                    if (realConnection2 != null) {
                        realConnection = null;
                    } else {
                        realConnection2 = null;
                    }
                    if (!this.reportedAcquired) {
                        realConnection = null;
                    }
                    if (realConnection2 == null) {
                        Internal.instance.get(this.connectionPool, this.address, this, (Route) null);
                        RealConnection realConnection3 = this.connection;
                        if (realConnection3 != null) {
                            z11 = true;
                            realConnection2 = realConnection3;
                            route2 = null;
                        } else {
                            route2 = this.route;
                        }
                    } else {
                        route2 = null;
                    }
                    z11 = false;
                } else {
                    throw new IOException("Canceled");
                }
            } finally {
            }
        }
        Util.closeQuietly(releaseIfNoNewStreams);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z11) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
        }
        if (realConnection2 != null) {
            this.route = this.connection.route();
            return realConnection2;
        }
        if (route2 != null || ((selection = this.routeSelection) != null && selection.hasNext())) {
            z12 = false;
        } else {
            this.routeSelection = this.routeSelector.next();
            z12 = true;
        }
        synchronized (this.connectionPool) {
            try {
                if (!this.canceled) {
                    if (z12) {
                        List<Route> all = this.routeSelection.getAll();
                        int size = all.size();
                        int i14 = 0;
                        while (true) {
                            if (i14 >= size) {
                                break;
                            }
                            Route route3 = all.get(i14);
                            Internal.instance.get(this.connectionPool, this.address, this, route3);
                            RealConnection realConnection4 = this.connection;
                            if (realConnection4 != null) {
                                this.route = route3;
                                z11 = true;
                                realConnection2 = realConnection4;
                                break;
                            }
                            i14++;
                        }
                    }
                    if (!z11) {
                        if (route2 == null) {
                            route2 = this.routeSelection.next();
                        }
                        this.route = route2;
                        this.refusedStreamCount = 0;
                        realConnection2 = new RealConnection(this.connectionPool, route2);
                        acquire(realConnection2, false);
                    }
                } else {
                    throw new IOException("Canceled");
                }
            } finally {
            }
        }
        if (z11) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
            return realConnection2;
        }
        realConnection2.connect(i10, i11, i12, i13, z10, this.call, this.eventListener);
        routeDatabase().connected(realConnection2.route());
        synchronized (this.connectionPool) {
            try {
                this.reportedAcquired = true;
                Internal.instance.put(this.connectionPool, realConnection2);
                if (realConnection2.isMultiplexed()) {
                    socket = Internal.instance.deduplicate(this.connectionPool, this.address, this);
                    realConnection2 = this.connection;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        Util.closeQuietly(socket);
        this.eventListener.connectionAcquired(this.call, realConnection2);
        return realConnection2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        if (r0.isHealthy(r9) != false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.cocos2dx.okhttp3.internal.connection.RealConnection findHealthyConnection(int r4, int r5, int r6, int r7, boolean r8, boolean r9) throws java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            org.cocos2dx.okhttp3.internal.connection.RealConnection r0 = r3.findConnection(r4, r5, r6, r7, r8)
            org.cocos2dx.okhttp3.ConnectionPool r1 = r3.connectionPool
            monitor-enter(r1)
            int r2 = r0.successCount     // Catch:{ all -> 0x0013 }
            if (r2 != 0) goto L_0x0015
            boolean r2 = r0.isMultiplexed()     // Catch:{ all -> 0x0013 }
            if (r2 != 0) goto L_0x0015
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
            return r0
        L_0x0013:
            r4 = move-exception
            goto L_0x0021
        L_0x0015:
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
            boolean r1 = r0.isHealthy(r9)
            if (r1 != 0) goto L_0x0020
            r3.noNewStreams()
            goto L_0x0000
        L_0x0020:
            return r0
        L_0x0021:
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.connection.StreamAllocation.findHealthyConnection(int, int, int, int, boolean, boolean):org.cocos2dx.okhttp3.internal.connection.RealConnection");
    }

    private Socket releaseIfNoNewStreams() {
        RealConnection realConnection = this.connection;
        if (realConnection == null || !realConnection.noNewStreams) {
            return null;
        }
        return deallocate(false, false, true);
    }

    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }

    public void acquire(RealConnection realConnection, boolean z10) {
        if (this.connection == null) {
            this.connection = realConnection;
            this.reportedAcquired = z10;
            realConnection.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
            return;
        }
        throw new IllegalStateException();
    }

    public void cancel() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        synchronized (this.connectionPool) {
            this.canceled = true;
            httpCodec = this.codec;
            realConnection = this.connection;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public HttpCodec codec() {
        HttpCodec httpCodec;
        synchronized (this.connectionPool) {
            httpCodec = this.codec;
        }
        return httpCodec;
    }

    public synchronized RealConnection connection() {
        return this.connection;
    }

    public boolean hasMoreRoutes() {
        RouteSelector.Selection selection;
        if (this.route != null || (((selection = this.routeSelection) != null && selection.hasNext()) || this.routeSelector.hasNext())) {
            return true;
        }
        return false;
    }

    public HttpCodec newStream(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z10) {
        try {
            HttpCodec newCodec = findHealthyConnection(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z10).newCodec(okHttpClient, chain, this);
            synchronized (this.connectionPool) {
                this.codec = newCodec;
            }
            return newCodec;
        } catch (IOException e10) {
            throw new RouteException(e10);
        }
    }

    public void noNewStreams() {
        RealConnection realConnection;
        Socket deallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            deallocate = deallocate(true, false, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    public void release() {
        RealConnection realConnection;
        Socket deallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            deallocate = deallocate(false, true, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            Internal.instance.timeoutExit(this.call, (IOException) null);
            this.eventListener.connectionReleased(this.call, realConnection);
            this.eventListener.callEnd(this.call);
        }
    }

    public Socket releaseAndAcquire(RealConnection realConnection) {
        if (this.codec == null && this.connection.allocations.size() == 1) {
            Socket deallocate = deallocate(true, false, false);
            this.connection = realConnection;
            realConnection.allocations.add(this.connection.allocations.get(0));
            return deallocate;
        }
        throw new IllegalStateException();
    }

    public Route route() {
        return this.route;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0053 A[Catch:{ all -> 0x001c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void streamFailed(java.io.IOException r7) {
        /*
            r6 = this;
            org.cocos2dx.okhttp3.ConnectionPool r0 = r6.connectionPool
            monitor-enter(r0)
            boolean r1 = r7 instanceof org.cocos2dx.okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x001c }
            r2 = 0
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0025
            org.cocos2dx.okhttp3.internal.http2.StreamResetException r7 = (org.cocos2dx.okhttp3.internal.http2.StreamResetException) r7     // Catch:{ all -> 0x001c }
            org.cocos2dx.okhttp3.internal.http2.ErrorCode r7 = r7.errorCode     // Catch:{ all -> 0x001c }
            org.cocos2dx.okhttp3.internal.http2.ErrorCode r1 = org.cocos2dx.okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x001c }
            if (r7 != r1) goto L_0x001e
            int r7 = r6.refusedStreamCount     // Catch:{ all -> 0x001c }
            int r7 = r7 + r3
            r6.refusedStreamCount = r7     // Catch:{ all -> 0x001c }
            if (r7 <= r3) goto L_0x0048
            r6.route = r2     // Catch:{ all -> 0x001c }
            goto L_0x0046
        L_0x001c:
            r7 = move-exception
            goto L_0x0067
        L_0x001e:
            org.cocos2dx.okhttp3.internal.http2.ErrorCode r1 = org.cocos2dx.okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ all -> 0x001c }
            if (r7 == r1) goto L_0x0048
            r6.route = r2     // Catch:{ all -> 0x001c }
            goto L_0x0046
        L_0x0025:
            org.cocos2dx.okhttp3.internal.connection.RealConnection r1 = r6.connection     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x0048
            boolean r1 = r1.isMultiplexed()     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x0033
            boolean r1 = r7 instanceof org.cocos2dx.okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x0048
        L_0x0033:
            org.cocos2dx.okhttp3.internal.connection.RealConnection r1 = r6.connection     // Catch:{ all -> 0x001c }
            int r1 = r1.successCount     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0046
            org.cocos2dx.okhttp3.Route r1 = r6.route     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x0044
            if (r7 == 0) goto L_0x0044
            org.cocos2dx.okhttp3.internal.connection.RouteSelector r5 = r6.routeSelector     // Catch:{ all -> 0x001c }
            r5.connectFailed(r1, r7)     // Catch:{ all -> 0x001c }
        L_0x0044:
            r6.route = r2     // Catch:{ all -> 0x001c }
        L_0x0046:
            r7 = r3
            goto L_0x0049
        L_0x0048:
            r7 = r4
        L_0x0049:
            org.cocos2dx.okhttp3.internal.connection.RealConnection r1 = r6.connection     // Catch:{ all -> 0x001c }
            java.net.Socket r7 = r6.deallocate(r7, r4, r3)     // Catch:{ all -> 0x001c }
            org.cocos2dx.okhttp3.internal.connection.RealConnection r3 = r6.connection     // Catch:{ all -> 0x001c }
            if (r3 != 0) goto L_0x0059
            boolean r3 = r6.reportedAcquired     // Catch:{ all -> 0x001c }
            if (r3 != 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r2 = r1
        L_0x0059:
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            org.cocos2dx.okhttp3.internal.Util.closeQuietly((java.net.Socket) r7)
            if (r2 == 0) goto L_0x0066
            org.cocos2dx.okhttp3.EventListener r7 = r6.eventListener
            org.cocos2dx.okhttp3.Call r0 = r6.call
            r7.connectionReleased(r0, r2)
        L_0x0066:
            return
        L_0x0067:
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.connection.StreamAllocation.streamFailed(java.io.IOException):void");
    }

    public void streamFinished(boolean z10, HttpCodec httpCodec, long j10, IOException iOException) {
        RealConnection realConnection;
        Socket deallocate;
        boolean z11;
        this.eventListener.responseBodyEnd(this.call, j10);
        synchronized (this.connectionPool) {
            if (httpCodec != null) {
                try {
                    if (httpCodec == this.codec) {
                        if (!z10) {
                            this.connection.successCount++;
                        }
                        realConnection = this.connection;
                        deallocate = deallocate(z10, false, true);
                        if (this.connection != null) {
                            realConnection = null;
                        }
                        z11 = this.released;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IllegalStateException("expected " + this.codec + " but was " + httpCodec);
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (iOException != null) {
            this.eventListener.callFailed(this.call, Internal.instance.timeoutExit(this.call, iOException));
        } else if (z11) {
            Internal.instance.timeoutExit(this.call, (IOException) null);
            this.eventListener.callEnd(this.call);
        }
    }

    public String toString() {
        RealConnection connection2 = connection();
        if (connection2 != null) {
            return connection2.toString();
        }
        return this.address.toString();
    }

    private void release(RealConnection realConnection) {
        int size = realConnection.allocations.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (realConnection.allocations.get(i10).get() == this) {
                realConnection.allocations.remove(i10);
                return;
            }
        }
        throw new IllegalStateException();
    }
}
