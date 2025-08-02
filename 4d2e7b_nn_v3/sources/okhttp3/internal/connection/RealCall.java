package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Unit;
import kotlin.jvm.internal.m;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;

public final class RealCall implements Call {
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    private volatile RealConnection connectionToCancel;
    private final EventListener eventListener;
    private volatile Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private final AtomicBoolean executed = new AtomicBoolean();
    private boolean expectMoreExchanges = true;
    private final boolean forWebSocket;
    private Exchange interceptorScopedExchange;
    private final Request originalRequest;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    /* access modifiers changed from: private */
    public final RealCall$timeout$1 timeout;
    private boolean timeoutEarlyExit;

    public final class AsyncCall implements Runnable {
        private volatile AtomicInteger callsPerHost = new AtomicInteger(0);
        private final Callback responseCallback;
        final /* synthetic */ RealCall this$0;

        public AsyncCall(RealCall realCall, Callback callback) {
            m.f(callback, "responseCallback");
            this.this$0 = realCall;
            this.responseCallback = callback;
        }

        public final void executeOn(ExecutorService executorService) {
            m.f(executorService, "executorService");
            Dispatcher dispatcher = this.this$0.getClient().dispatcher();
            if (!Util.assertionsEnabled || !Thread.holdsLock(dispatcher)) {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e10) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e10);
                    this.this$0.noMoreExchanges$okhttp(interruptedIOException);
                    this.responseCallback.onFailure(this.this$0, interruptedIOException);
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                } catch (Throwable th) {
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                    throw th;
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Thread ");
                Thread currentThread = Thread.currentThread();
                m.e(currentThread, "Thread.currentThread()");
                sb2.append(currentThread.getName());
                sb2.append(" MUST NOT hold lock on ");
                sb2.append(dispatcher);
                throw new AssertionError(sb2.toString());
            }
        }

        public final RealCall getCall() {
            return this.this$0;
        }

        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        public final String getHost() {
            return this.this$0.getOriginalRequest().url().host();
        }

        public final Request getRequest() {
            return this.this$0.getOriginalRequest();
        }

        public final void reuseCallsPerHostFrom(AsyncCall asyncCall) {
            m.f(asyncCall, "other");
            this.callsPerHost = asyncCall.callsPerHost;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0066 A[Catch:{ all -> 0x0087, all -> 0x004e }] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x008c A[Catch:{ all -> 0x0087, all -> 0x004e }] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00ae A[Catch:{ all -> 0x0087, all -> 0x004e }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "OkHttp "
                r0.append(r1)
                okhttp3.internal.connection.RealCall r1 = r7.this$0
                java.lang.String r1 = r1.redactedUrl$okhttp()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                java.lang.String r2 = "currentThread"
                kotlin.jvm.internal.m.e(r1, r2)
                java.lang.String r2 = r1.getName()
                r1.setName(r0)
                okhttp3.internal.connection.RealCall r0 = r7.this$0     // Catch:{ all -> 0x004e }
                okhttp3.internal.connection.RealCall$timeout$1 r0 = r0.timeout     // Catch:{ all -> 0x004e }
                r0.enter()     // Catch:{ all -> 0x004e }
                r0 = 0
                okhttp3.internal.connection.RealCall r3 = r7.this$0     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
                okhttp3.Response r0 = r3.getResponseWithInterceptorChain$okhttp()     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
                r3 = 1
                okhttp3.Callback r4 = r7.responseCallback     // Catch:{ IOException -> 0x0053, all -> 0x0051 }
                okhttp3.internal.connection.RealCall r5 = r7.this$0     // Catch:{ IOException -> 0x0053, all -> 0x0051 }
                r4.onResponse(r5, r0)     // Catch:{ IOException -> 0x0053, all -> 0x0051 }
                okhttp3.internal.connection.RealCall r0 = r7.this$0     // Catch:{ all -> 0x004e }
                okhttp3.OkHttpClient r0 = r0.getClient()     // Catch:{ all -> 0x004e }
                okhttp3.Dispatcher r0 = r0.dispatcher()     // Catch:{ all -> 0x004e }
            L_0x0049:
                r0.finished$okhttp((okhttp3.internal.connection.RealCall.AsyncCall) r7)     // Catch:{ all -> 0x004e }
                goto L_0x00c0
            L_0x004e:
                r0 = move-exception
                goto L_0x00d2
            L_0x0051:
                r0 = move-exception
                goto L_0x005f
            L_0x0053:
                r0 = move-exception
                goto L_0x008a
            L_0x0055:
                r3 = move-exception
                r6 = r3
                r3 = r0
                r0 = r6
                goto L_0x005f
            L_0x005a:
                r3 = move-exception
                r6 = r3
                r3 = r0
                r0 = r6
                goto L_0x008a
            L_0x005f:
                okhttp3.internal.connection.RealCall r4 = r7.this$0     // Catch:{ all -> 0x0087 }
                r4.cancel()     // Catch:{ all -> 0x0087 }
                if (r3 != 0) goto L_0x0089
                java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0087 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
                r4.<init>()     // Catch:{ all -> 0x0087 }
                java.lang.String r5 = "canceled due to "
                r4.append(r5)     // Catch:{ all -> 0x0087 }
                r4.append(r0)     // Catch:{ all -> 0x0087 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0087 }
                r3.<init>(r4)     // Catch:{ all -> 0x0087 }
                kotlin.b.a(r3, r0)     // Catch:{ all -> 0x0087 }
                okhttp3.Callback r4 = r7.responseCallback     // Catch:{ all -> 0x0087 }
                okhttp3.internal.connection.RealCall r5 = r7.this$0     // Catch:{ all -> 0x0087 }
                r4.onFailure(r5, r3)     // Catch:{ all -> 0x0087 }
                goto L_0x0089
            L_0x0087:
                r0 = move-exception
                goto L_0x00c4
            L_0x0089:
                throw r0     // Catch:{ all -> 0x0087 }
            L_0x008a:
                if (r3 == 0) goto L_0x00ae
                okhttp3.internal.platform.Platform$Companion r3 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x0087 }
                okhttp3.internal.platform.Platform r3 = r3.get()     // Catch:{ all -> 0x0087 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
                r4.<init>()     // Catch:{ all -> 0x0087 }
                java.lang.String r5 = "Callback failure for "
                r4.append(r5)     // Catch:{ all -> 0x0087 }
                okhttp3.internal.connection.RealCall r5 = r7.this$0     // Catch:{ all -> 0x0087 }
                java.lang.String r5 = r5.toLoggableString()     // Catch:{ all -> 0x0087 }
                r4.append(r5)     // Catch:{ all -> 0x0087 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0087 }
                r5 = 4
                r3.log(r4, r5, r0)     // Catch:{ all -> 0x0087 }
                goto L_0x00b5
            L_0x00ae:
                okhttp3.Callback r3 = r7.responseCallback     // Catch:{ all -> 0x0087 }
                okhttp3.internal.connection.RealCall r4 = r7.this$0     // Catch:{ all -> 0x0087 }
                r3.onFailure(r4, r0)     // Catch:{ all -> 0x0087 }
            L_0x00b5:
                okhttp3.internal.connection.RealCall r0 = r7.this$0     // Catch:{ all -> 0x004e }
                okhttp3.OkHttpClient r0 = r0.getClient()     // Catch:{ all -> 0x004e }
                okhttp3.Dispatcher r0 = r0.dispatcher()     // Catch:{ all -> 0x004e }
                goto L_0x0049
            L_0x00c0:
                r1.setName(r2)
                return
            L_0x00c4:
                okhttp3.internal.connection.RealCall r3 = r7.this$0     // Catch:{ all -> 0x004e }
                okhttp3.OkHttpClient r3 = r3.getClient()     // Catch:{ all -> 0x004e }
                okhttp3.Dispatcher r3 = r3.dispatcher()     // Catch:{ all -> 0x004e }
                r3.finished$okhttp((okhttp3.internal.connection.RealCall.AsyncCall) r7)     // Catch:{ all -> 0x004e }
                throw r0     // Catch:{ all -> 0x004e }
            L_0x00d2:
                r1.setName(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.AsyncCall.run():void");
        }
    }

    public static final class CallReference extends WeakReference<RealCall> {
        private final Object callStackTrace;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CallReference(RealCall realCall, Object obj) {
            super(realCall);
            m.f(realCall, "referent");
            this.callStackTrace = obj;
        }

        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    public RealCall(OkHttpClient okHttpClient, Request request, boolean z10) {
        m.f(okHttpClient, "client");
        m.f(request, "originalRequest");
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z10;
        this.connectionPool = okHttpClient.connectionPool().getDelegate$okhttp();
        this.eventListener = okHttpClient.eventListenerFactory().create(this);
        RealCall$timeout$1 realCall$timeout$1 = new RealCall$timeout$1(this);
        realCall$timeout$1.timeout((long) okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        Unit unit = Unit.f12577a;
        this.timeout = realCall$timeout$1;
    }

    private final <E extends IOException> E callDone(E e10) {
        Socket releaseConnectionNoEvents$okhttp;
        boolean z10;
        boolean z11 = Util.assertionsEnabled;
        if (!z11 || !Thread.holdsLock(this)) {
            RealConnection realConnection = this.connection;
            if (realConnection != null) {
                if (!z11 || !Thread.holdsLock(realConnection)) {
                    synchronized (realConnection) {
                        releaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
                    }
                    if (this.connection == null) {
                        if (releaseConnectionNoEvents$okhttp != null) {
                            Util.closeQuietly(releaseConnectionNoEvents$okhttp);
                        }
                        this.eventListener.connectionReleased(this, realConnection);
                    } else {
                        if (releaseConnectionNoEvents$okhttp == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (!z10) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Thread ");
                    Thread currentThread = Thread.currentThread();
                    m.e(currentThread, "Thread.currentThread()");
                    sb2.append(currentThread.getName());
                    sb2.append(" MUST NOT hold lock on ");
                    sb2.append(realConnection);
                    throw new AssertionError(sb2.toString());
                }
            }
            E timeoutExit = timeoutExit(e10);
            if (e10 != null) {
                EventListener eventListener2 = this.eventListener;
                m.c(timeoutExit);
                eventListener2.callFailed(this, timeoutExit);
            } else {
                this.eventListener.callEnd(this);
            }
            return timeoutExit;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Thread ");
        Thread currentThread2 = Thread.currentThread();
        m.e(currentThread2, "Thread.currentThread()");
        sb3.append(currentThread2.getName());
        sb3.append(" MUST NOT hold lock on ");
        sb3.append(this);
        throw new AssertionError(sb3.toString());
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    private final Address createAddress(HttpUrl httpUrl) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (httpUrl.isHttps()) {
            sSLSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private final <E extends IOException> E timeoutExit(E e10) {
        if (this.timeoutEarlyExit || !this.timeout.exit()) {
            return e10;
        }
        E interruptedIOException = new InterruptedIOException("timeout");
        if (e10 != null) {
            interruptedIOException.initCause(e10);
        }
        return interruptedIOException;
    }

    /* access modifiers changed from: private */
    public final String toLoggableString() {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        if (isCanceled()) {
            str = "canceled ";
        } else {
            str = "";
        }
        sb2.append(str);
        if (this.forWebSocket) {
            str2 = "web socket";
        } else {
            str2 = NotificationCompat.CATEGORY_CALL;
        }
        sb2.append(str2);
        sb2.append(" to ");
        sb2.append(redactedUrl$okhttp());
        return sb2.toString();
    }

    public final void acquireConnectionNoEvents(RealConnection realConnection) {
        boolean z10;
        m.f(realConnection, "connection");
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnection)) {
            if (this.connection == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.connection = realConnection;
                realConnection.getCalls().add(new CallReference(this, this.callStackTrace));
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
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

    public void cancel() {
        if (!this.canceled) {
            this.canceled = true;
            Exchange exchange2 = this.exchange;
            if (exchange2 != null) {
                exchange2.cancel();
            }
            RealConnection realConnection = this.connectionToCancel;
            if (realConnection != null) {
                realConnection.cancel();
            }
            this.eventListener.canceled(this);
        }
    }

    public void enqueue(Callback callback) {
        m.f(callback, "responseCallback");
        if (this.executed.compareAndSet(false, true)) {
            callStart();
            this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, callback));
            return;
        }
        throw new IllegalStateException("Already Executed".toString());
    }

    public final void enterNetworkInterceptorExchange(Request request, boolean z10) {
        boolean z11;
        m.f(request, "request");
        if (this.interceptorScopedExchange == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            synchronized (this) {
                if (!(!this.responseBodyOpen)) {
                    throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                } else if (!this.requestBodyOpen) {
                    Unit unit = Unit.f12577a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
            if (z10) {
                this.exchangeFinder = new ExchangeFinder(this.connectionPool, createAddress(request.url()), this, this.eventListener);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public Response execute() {
        if (this.executed.compareAndSet(false, true)) {
            this.timeout.enter();
            callStart();
            try {
                this.client.dispatcher().executed$okhttp(this);
                return getResponseWithInterceptorChain$okhttp();
            } finally {
                this.client.dispatcher().finished$okhttp(this);
            }
        } else {
            throw new IllegalStateException("Already Executed".toString());
        }
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean z10) {
        Exchange exchange2;
        synchronized (this) {
            if (this.expectMoreExchanges) {
                Unit unit = Unit.f12577a;
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z10 && (exchange2 = this.exchange) != null) {
            exchange2.detachWithViolence();
        }
        this.interceptorScopedExchange = null;
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    public final RealConnection getConnection() {
        return this.connection;
    }

    public final RealConnection getConnectionToCancel() {
        return this.connectionToCancel;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okhttp3.Response getResponseWithInterceptorChain$okhttp() throws java.io.IOException {
        /*
            r11 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            okhttp3.OkHttpClient r0 = r11.client
            java.util.List r0 = r0.interceptors()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            kotlin.collections.r.z(r2, r0)
            okhttp3.internal.http.RetryAndFollowUpInterceptor r0 = new okhttp3.internal.http.RetryAndFollowUpInterceptor
            okhttp3.OkHttpClient r1 = r11.client
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.http.BridgeInterceptor r0 = new okhttp3.internal.http.BridgeInterceptor
            okhttp3.OkHttpClient r1 = r11.client
            okhttp3.CookieJar r1 = r1.cookieJar()
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.cache.CacheInterceptor r0 = new okhttp3.internal.cache.CacheInterceptor
            okhttp3.OkHttpClient r1 = r11.client
            okhttp3.Cache r1 = r1.cache()
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.connection.ConnectInterceptor r0 = okhttp3.internal.connection.ConnectInterceptor.INSTANCE
            r2.add(r0)
            boolean r0 = r11.forWebSocket
            if (r0 != 0) goto L_0x004a
            okhttp3.OkHttpClient r0 = r11.client
            java.util.List r0 = r0.networkInterceptors()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            kotlin.collections.r.z(r2, r0)
        L_0x004a:
            okhttp3.internal.http.CallServerInterceptor r0 = new okhttp3.internal.http.CallServerInterceptor
            boolean r1 = r11.forWebSocket
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.http.RealInterceptorChain r9 = new okhttp3.internal.http.RealInterceptorChain
            okhttp3.Request r5 = r11.originalRequest
            okhttp3.OkHttpClient r0 = r11.client
            int r6 = r0.connectTimeoutMillis()
            okhttp3.OkHttpClient r0 = r11.client
            int r7 = r0.readTimeoutMillis()
            okhttp3.OkHttpClient r0 = r11.client
            int r8 = r0.writeTimeoutMillis()
            r3 = 0
            r4 = 0
            r0 = r9
            r1 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            r1 = 0
            okhttp3.Request r2 = r11.originalRequest     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            okhttp3.Response r2 = r9.proceed(r2)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            boolean r3 = r11.isCanceled()     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            if (r3 != 0) goto L_0x0083
            r11.noMoreExchanges$okhttp(r0)
            return r2
        L_0x0083:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            throw r2     // Catch:{ IOException -> 0x0090, all -> 0x008e }
        L_0x008e:
            r2 = move-exception
            goto L_0x00a6
        L_0x0090:
            r1 = move-exception
            r2 = 1
            java.io.IOException r1 = r11.noMoreExchanges$okhttp(r1)     // Catch:{ all -> 0x00a0 }
            if (r1 != 0) goto L_0x00a5
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ all -> 0x00a0 }
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Throwable"
            r1.<init>(r3)     // Catch:{ all -> 0x00a0 }
            throw r1     // Catch:{ all -> 0x00a0 }
        L_0x00a0:
            r1 = move-exception
            r10 = r2
            r2 = r1
            r1 = r10
            goto L_0x00a6
        L_0x00a5:
            throw r1     // Catch:{ all -> 0x00a0 }
        L_0x00a6:
            if (r1 != 0) goto L_0x00ab
            r11.noMoreExchanges$okhttp(r0)
        L_0x00ab:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.getResponseWithInterceptorChain$okhttp():okhttp3.Response");
    }

    public final Exchange initExchange$okhttp(RealInterceptorChain realInterceptorChain) {
        m.f(realInterceptorChain, "chain");
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            } else if (!(!this.responseBodyOpen)) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (!this.requestBodyOpen) {
                Unit unit = Unit.f12577a;
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        ExchangeFinder exchangeFinder2 = this.exchangeFinder;
        m.c(exchangeFinder2);
        Exchange exchange2 = new Exchange(this, this.eventListener, exchangeFinder2, exchangeFinder2.find(this.client, realInterceptorChain));
        this.interceptorScopedExchange = exchange2;
        this.exchange = exchange2;
        synchronized (this) {
            this.requestBodyOpen = true;
            this.responseBodyOpen = true;
        }
        if (!this.canceled) {
            return exchange2;
        }
        throw new IOException("Canceled");
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public boolean isExecuted() {
        return this.executed.get();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0023 A[Catch:{ all -> 0x0019 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0027 A[Catch:{ all -> 0x0019 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0031 A[Catch:{ all -> 0x0019 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0033 A[Catch:{ all -> 0x0019 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x003e A[Catch:{ all -> 0x0019 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x003f A[Catch:{ all -> 0x0019 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <E extends java.io.IOException> E messageDone$okhttp(okhttp3.internal.connection.Exchange r3, boolean r4, boolean r5, E r6) {
        /*
            r2 = this;
            java.lang.String r0 = "exchange"
            kotlin.jvm.internal.m.f(r3, r0)
            okhttp3.internal.connection.Exchange r0 = r2.exchange
            boolean r3 = kotlin.jvm.internal.m.b(r3, r0)
            r0 = 1
            r3 = r3 ^ r0
            if (r3 == 0) goto L_0x0010
            return r6
        L_0x0010:
            monitor-enter(r2)
            r3 = 0
            if (r4 == 0) goto L_0x001b
            boolean r1 = r2.requestBodyOpen     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x0021
            goto L_0x001b
        L_0x0019:
            r3 = move-exception
            goto L_0x005a
        L_0x001b:
            if (r5 == 0) goto L_0x0042
            boolean r1 = r2.responseBodyOpen     // Catch:{ all -> 0x0019 }
            if (r1 == 0) goto L_0x0042
        L_0x0021:
            if (r4 == 0) goto L_0x0025
            r2.requestBodyOpen = r3     // Catch:{ all -> 0x0019 }
        L_0x0025:
            if (r5 == 0) goto L_0x0029
            r2.responseBodyOpen = r3     // Catch:{ all -> 0x0019 }
        L_0x0029:
            boolean r4 = r2.requestBodyOpen     // Catch:{ all -> 0x0019 }
            if (r4 != 0) goto L_0x0033
            boolean r5 = r2.responseBodyOpen     // Catch:{ all -> 0x0019 }
            if (r5 != 0) goto L_0x0033
            r5 = r0
            goto L_0x0034
        L_0x0033:
            r5 = r3
        L_0x0034:
            if (r4 != 0) goto L_0x003f
            boolean r4 = r2.responseBodyOpen     // Catch:{ all -> 0x0019 }
            if (r4 != 0) goto L_0x003f
            boolean r4 = r2.expectMoreExchanges     // Catch:{ all -> 0x0019 }
            if (r4 != 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r0 = r3
        L_0x0040:
            r3 = r5
            goto L_0x0043
        L_0x0042:
            r0 = r3
        L_0x0043:
            kotlin.Unit r4 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0019 }
            monitor-exit(r2)
            if (r3 == 0) goto L_0x0052
            r3 = 0
            r2.exchange = r3
            okhttp3.internal.connection.RealConnection r3 = r2.connection
            if (r3 == 0) goto L_0x0052
            r3.incrementSuccessCount$okhttp()
        L_0x0052:
            if (r0 == 0) goto L_0x0059
            java.io.IOException r3 = r2.callDone(r6)
            return r3
        L_0x0059:
            return r6
        L_0x005a:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.messageDone$okhttp(okhttp3.internal.connection.Exchange, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    public final IOException noMoreExchanges$okhttp(IOException iOException) {
        boolean z10;
        synchronized (this) {
            try {
                z10 = false;
                if (this.expectMoreExchanges) {
                    this.expectMoreExchanges = false;
                    if (!this.requestBodyOpen && !this.responseBodyOpen) {
                        z10 = true;
                    }
                }
                Unit unit = Unit.f12577a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z10) {
            return callDone(iOException);
        }
        return iOException;
    }

    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection realConnection = this.connection;
        m.c(realConnection);
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnection)) {
            List<Reference<RealCall>> calls = realConnection.getCalls();
            Iterator<Reference<RealCall>> it = calls.iterator();
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i10 = -1;
                    break;
                } else if (m.b((RealCall) it.next().get(), this)) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 != -1) {
                z10 = true;
            }
            if (z10) {
                calls.remove(i10);
                this.connection = null;
                if (calls.isEmpty()) {
                    realConnection.setIdleAtNs$okhttp(System.nanoTime());
                    if (this.connectionPool.connectionBecameIdle(realConnection)) {
                        return realConnection.socket();
                    }
                }
                return null;
            }
            throw new IllegalStateException("Check failed.".toString());
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

    public Request request() {
        return this.originalRequest;
    }

    public final boolean retryAfterFailure() {
        ExchangeFinder exchangeFinder2 = this.exchangeFinder;
        m.c(exchangeFinder2);
        return exchangeFinder2.retryAfterFailure();
    }

    public final void setConnectionToCancel(RealConnection realConnection) {
        this.connectionToCancel = realConnection;
    }

    public final void timeoutEarlyExit() {
        if (!this.timeoutEarlyExit) {
            this.timeoutEarlyExit = true;
            this.timeout.exit();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public AsyncTimeout timeout() {
        return this.timeout;
    }

    public RealCall clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
