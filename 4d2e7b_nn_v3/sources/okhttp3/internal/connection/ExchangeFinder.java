package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import kotlin.jvm.internal.m;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

public final class ExchangeFinder {
    private final Address address;
    private final RealCall call;
    private final RealConnectionPool connectionPool;
    private int connectionShutdownCount;
    private final EventListener eventListener;
    private Route nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;

    public ExchangeFinder(RealConnectionPool realConnectionPool, Address address2, RealCall realCall, EventListener eventListener2) {
        m.f(realConnectionPool, "connectionPool");
        m.f(address2, "address");
        m.f(realCall, NotificationCompat.CATEGORY_CALL);
        m.f(eventListener2, "eventListener");
        this.connectionPool = realConnectionPool;
        this.address = address2;
        this.call = realCall;
        this.eventListener = eventListener2;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final okhttp3.internal.connection.RealConnection findConnection(int r15, int r16, int r17, int r18, boolean r19) throws java.io.IOException {
        /*
            r14 = this;
            r1 = r14
            okhttp3.internal.connection.RealCall r0 = r1.call
            boolean r0 = r0.isCanceled()
            if (r0 != 0) goto L_0x0179
            okhttp3.internal.connection.RealCall r0 = r1.call
            okhttp3.internal.connection.RealConnection r2 = r0.getConnection()
            r0 = 1
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x0065
            monitor-enter(r2)
            boolean r5 = r2.getNoNewExchanges()     // Catch:{ all -> 0x0030 }
            if (r5 != 0) goto L_0x0032
            okhttp3.Route r5 = r2.route()     // Catch:{ all -> 0x0030 }
            okhttp3.Address r5 = r5.address()     // Catch:{ all -> 0x0030 }
            okhttp3.HttpUrl r5 = r5.url()     // Catch:{ all -> 0x0030 }
            boolean r5 = r14.sameHostAndPort(r5)     // Catch:{ all -> 0x0030 }
            if (r5 != 0) goto L_0x002e
            goto L_0x0032
        L_0x002e:
            r5 = r4
            goto L_0x0038
        L_0x0030:
            r0 = move-exception
            goto L_0x0063
        L_0x0032:
            okhttp3.internal.connection.RealCall r5 = r1.call     // Catch:{ all -> 0x0030 }
            java.net.Socket r5 = r5.releaseConnectionNoEvents$okhttp()     // Catch:{ all -> 0x0030 }
        L_0x0038:
            kotlin.Unit r6 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0030 }
            monitor-exit(r2)
            okhttp3.internal.connection.RealCall r6 = r1.call
            okhttp3.internal.connection.RealConnection r6 = r6.getConnection()
            if (r6 == 0) goto L_0x0056
            if (r5 != 0) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            r0 = r3
        L_0x0047:
            if (r0 == 0) goto L_0x004a
            return r2
        L_0x004a:
            java.lang.String r0 = "Check failed."
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        L_0x0056:
            if (r5 == 0) goto L_0x005b
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r5)
        L_0x005b:
            okhttp3.EventListener r5 = r1.eventListener
            okhttp3.internal.connection.RealCall r6 = r1.call
            r5.connectionReleased(r6, r2)
            goto L_0x0065
        L_0x0063:
            monitor-exit(r2)
            throw r0
        L_0x0065:
            r1.refusedStreamCount = r3
            r1.connectionShutdownCount = r3
            r1.otherFailureCount = r3
            okhttp3.internal.connection.RealConnectionPool r2 = r1.connectionPool
            okhttp3.Address r5 = r1.address
            okhttp3.internal.connection.RealCall r6 = r1.call
            boolean r2 = r2.callAcquirePooledConnection(r5, r6, r4, r3)
            if (r2 == 0) goto L_0x0088
            okhttp3.internal.connection.RealCall r0 = r1.call
            okhttp3.internal.connection.RealConnection r0 = r0.getConnection()
            kotlin.jvm.internal.m.c(r0)
            okhttp3.EventListener r2 = r1.eventListener
            okhttp3.internal.connection.RealCall r3 = r1.call
            r2.connectionAcquired(r3, r0)
            return r0
        L_0x0088:
            okhttp3.Route r2 = r1.nextRouteToTry
            if (r2 == 0) goto L_0x0093
            kotlin.jvm.internal.m.c(r2)
            r1.nextRouteToTry = r4
        L_0x0091:
            r5 = r4
            goto L_0x00f8
        L_0x0093:
            okhttp3.internal.connection.RouteSelector$Selection r2 = r1.routeSelection
            if (r2 == 0) goto L_0x00aa
            kotlin.jvm.internal.m.c(r2)
            boolean r2 = r2.hasNext()
            if (r2 == 0) goto L_0x00aa
            okhttp3.internal.connection.RouteSelector$Selection r2 = r1.routeSelection
            kotlin.jvm.internal.m.c(r2)
            okhttp3.Route r2 = r2.next()
            goto L_0x0091
        L_0x00aa:
            okhttp3.internal.connection.RouteSelector r2 = r1.routeSelector
            if (r2 != 0) goto L_0x00c5
            okhttp3.internal.connection.RouteSelector r2 = new okhttp3.internal.connection.RouteSelector
            okhttp3.Address r5 = r1.address
            okhttp3.internal.connection.RealCall r6 = r1.call
            okhttp3.OkHttpClient r6 = r6.getClient()
            okhttp3.internal.connection.RouteDatabase r6 = r6.getRouteDatabase()
            okhttp3.internal.connection.RealCall r7 = r1.call
            okhttp3.EventListener r8 = r1.eventListener
            r2.<init>(r5, r6, r7, r8)
            r1.routeSelector = r2
        L_0x00c5:
            okhttp3.internal.connection.RouteSelector$Selection r2 = r2.next()
            r1.routeSelection = r2
            java.util.List r5 = r2.getRoutes()
            okhttp3.internal.connection.RealCall r6 = r1.call
            boolean r6 = r6.isCanceled()
            if (r6 != 0) goto L_0x0171
            okhttp3.internal.connection.RealConnectionPool r6 = r1.connectionPool
            okhttp3.Address r7 = r1.address
            okhttp3.internal.connection.RealCall r8 = r1.call
            boolean r3 = r6.callAcquirePooledConnection(r7, r8, r5, r3)
            if (r3 == 0) goto L_0x00f4
            okhttp3.internal.connection.RealCall r0 = r1.call
            okhttp3.internal.connection.RealConnection r0 = r0.getConnection()
            kotlin.jvm.internal.m.c(r0)
            okhttp3.EventListener r2 = r1.eventListener
            okhttp3.internal.connection.RealCall r3 = r1.call
            r2.connectionAcquired(r3, r0)
            return r0
        L_0x00f4:
            okhttp3.Route r2 = r2.next()
        L_0x00f8:
            okhttp3.internal.connection.RealConnection r3 = new okhttp3.internal.connection.RealConnection
            okhttp3.internal.connection.RealConnectionPool r6 = r1.connectionPool
            r3.<init>(r6, r2)
            okhttp3.internal.connection.RealCall r6 = r1.call
            r6.setConnectionToCancel(r3)
            okhttp3.internal.connection.RealCall r12 = r1.call     // Catch:{ all -> 0x016a }
            okhttp3.EventListener r13 = r1.eventListener     // Catch:{ all -> 0x016a }
            r6 = r3
            r7 = r15
            r8 = r16
            r9 = r17
            r10 = r18
            r11 = r19
            r6.connect(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x016a }
            okhttp3.internal.connection.RealCall r6 = r1.call
            r6.setConnectionToCancel(r4)
            okhttp3.internal.connection.RealCall r4 = r1.call
            okhttp3.OkHttpClient r4 = r4.getClient()
            okhttp3.internal.connection.RouteDatabase r4 = r4.getRouteDatabase()
            okhttp3.Route r6 = r3.route()
            r4.connected(r6)
            okhttp3.internal.connection.RealConnectionPool r4 = r1.connectionPool
            okhttp3.Address r6 = r1.address
            okhttp3.internal.connection.RealCall r7 = r1.call
            boolean r0 = r4.callAcquirePooledConnection(r6, r7, r5, r0)
            if (r0 == 0) goto L_0x0151
            okhttp3.internal.connection.RealCall r0 = r1.call
            okhttp3.internal.connection.RealConnection r0 = r0.getConnection()
            kotlin.jvm.internal.m.c(r0)
            r1.nextRouteToTry = r2
            java.net.Socket r2 = r3.socket()
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r2)
            okhttp3.EventListener r2 = r1.eventListener
            okhttp3.internal.connection.RealCall r3 = r1.call
            r2.connectionAcquired(r3, r0)
            return r0
        L_0x0151:
            monitor-enter(r3)
            okhttp3.internal.connection.RealConnectionPool r0 = r1.connectionPool     // Catch:{ all -> 0x0167 }
            r0.put(r3)     // Catch:{ all -> 0x0167 }
            okhttp3.internal.connection.RealCall r0 = r1.call     // Catch:{ all -> 0x0167 }
            r0.acquireConnectionNoEvents(r3)     // Catch:{ all -> 0x0167 }
            kotlin.Unit r0 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0167 }
            monitor-exit(r3)
            okhttp3.EventListener r0 = r1.eventListener
            okhttp3.internal.connection.RealCall r2 = r1.call
            r0.connectionAcquired(r2, r3)
            return r3
        L_0x0167:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x016a:
            r0 = move-exception
            okhttp3.internal.connection.RealCall r2 = r1.call
            r2.setConnectionToCancel(r4)
            throw r0
        L_0x0171:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "Canceled"
            r0.<init>(r2)
            throw r0
        L_0x0179:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "Canceled"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ExchangeFinder.findConnection(int, int, int, int, boolean):okhttp3.internal.connection.RealConnection");
    }

    private final RealConnection findHealthyConnection(int i10, int i11, int i12, int i13, boolean z10, boolean z11) throws IOException {
        boolean z12;
        while (true) {
            RealConnection findConnection = findConnection(i10, i11, i12, i13, z10);
            if (findConnection.isHealthy(z11)) {
                return findConnection;
            }
            findConnection.noNewExchanges$okhttp();
            if (this.nextRouteToTry == null) {
                RouteSelector.Selection selection = this.routeSelection;
                boolean z13 = true;
                if (selection != null) {
                    z12 = selection.hasNext();
                } else {
                    z12 = true;
                }
                if (!z12) {
                    RouteSelector routeSelector2 = this.routeSelector;
                    if (routeSelector2 != null) {
                        z13 = routeSelector2.hasNext();
                    }
                    if (!z13) {
                        throw new IOException("exhausted all routes");
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private final Route retryRoute() {
        RealConnection connection;
        if (this.refusedStreamCount > 1 || this.connectionShutdownCount > 1 || this.otherFailureCount > 0 || (connection = this.call.getConnection()) == null) {
            return null;
        }
        synchronized (connection) {
            if (connection.getRouteFailureCount$okhttp() != 0) {
                return null;
            }
            if (!Util.canReuseConnectionFor(connection.route().address().url(), this.address.url())) {
                return null;
            }
            Route route = connection.route();
            return route;
        }
    }

    public final ExchangeCodec find(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain) {
        m.f(okHttpClient, "client");
        m.f(realInterceptorChain, "chain");
        try {
            return findHealthyConnection(realInterceptorChain.getConnectTimeoutMillis$okhttp(), realInterceptorChain.getReadTimeoutMillis$okhttp(), realInterceptorChain.getWriteTimeoutMillis$okhttp(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), !m.b(realInterceptorChain.getRequest$okhttp().method(), "GET")).newCodec$okhttp(okHttpClient, realInterceptorChain);
        } catch (RouteException e10) {
            trackFailure(e10.getLastConnectException());
            throw e10;
        } catch (IOException e11) {
            trackFailure(e11);
            throw new RouteException(e11);
        }
    }

    public final Address getAddress$okhttp() {
        return this.address;
    }

    public final boolean retryAfterFailure() {
        RouteSelector routeSelector2;
        if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
            return false;
        }
        if (this.nextRouteToTry != null) {
            return true;
        }
        Route retryRoute = retryRoute();
        if (retryRoute != null) {
            this.nextRouteToTry = retryRoute;
            return true;
        }
        RouteSelector.Selection selection = this.routeSelection;
        if ((selection == null || !selection.hasNext()) && (routeSelector2 = this.routeSelector) != null) {
            return routeSelector2.hasNext();
        }
        return true;
    }

    public final boolean sameHostAndPort(HttpUrl httpUrl) {
        m.f(httpUrl, ImagesContract.URL);
        HttpUrl url = this.address.url();
        if (httpUrl.port() != url.port() || !m.b(httpUrl.host(), url.host())) {
            return false;
        }
        return true;
    }

    public final void trackFailure(IOException iOException) {
        m.f(iOException, "e");
        this.nextRouteToTry = null;
        if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
            this.refusedStreamCount++;
        } else if (iOException instanceof ConnectionShutdownException) {
            this.connectionShutdownCount++;
        } else {
            this.otherFailureCount++;
        }
    }
}
