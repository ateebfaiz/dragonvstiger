package org.cocos2dx.okhttp3;

import androidx.core.app.NotificationCompat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import org.cocos2dx.okhttp3.internal.NamedRunnable;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.cache.CacheInterceptor;
import org.cocos2dx.okhttp3.internal.connection.ConnectInterceptor;
import org.cocos2dx.okhttp3.internal.connection.RealConnection;
import org.cocos2dx.okhttp3.internal.connection.StreamAllocation;
import org.cocos2dx.okhttp3.internal.http.BridgeInterceptor;
import org.cocos2dx.okhttp3.internal.http.CallServerInterceptor;
import org.cocos2dx.okhttp3.internal.http.HttpCodec;
import org.cocos2dx.okhttp3.internal.http.RealInterceptorChain;
import org.cocos2dx.okhttp3.internal.http.RetryAndFollowUpInterceptor;
import org.cocos2dx.okhttp3.internal.platform.Platform;
import org.cocos2dx.okio.AsyncTimeout;
import org.cocos2dx.okio.Timeout;

final class a implements Call {

    /* renamed from: a  reason: collision with root package name */
    final OkHttpClient f1551a;

    /* renamed from: b  reason: collision with root package name */
    final RetryAndFollowUpInterceptor f1552b;

    /* renamed from: c  reason: collision with root package name */
    final AsyncTimeout f1553c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public EventListener f1554d;

    /* renamed from: e  reason: collision with root package name */
    final Request f1555e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f1556f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1557g;

    /* renamed from: org.cocos2dx.okhttp3.a$a  reason: collision with other inner class name */
    class C0025a extends AsyncTimeout {
        C0025a() {
        }

        /* access modifiers changed from: protected */
        public void timedOut() {
            a.this.cancel();
        }
    }

    final class b extends NamedRunnable {

        /* renamed from: a  reason: collision with root package name */
        private final Callback f1559a;

        b(Callback callback) {
            super("OkHttp %s", a.this.f());
            this.f1559a = callback;
        }

        /* access modifiers changed from: package-private */
        public void e(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e10) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e10);
                a.this.f1554d.callFailed(a.this, interruptedIOException);
                this.f1559a.onFailure(a.this, interruptedIOException);
                a.this.f1551a.dispatcher().finished(this);
            } catch (Throwable th) {
                a.this.f1551a.dispatcher().finished(this);
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0038 A[Catch:{ all -> 0x0056 }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0061 A[Catch:{ all -> 0x0056 }] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0081 A[Catch:{ all -> 0x0056 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r5 = this;
                org.cocos2dx.okhttp3.a r0 = org.cocos2dx.okhttp3.a.this
                org.cocos2dx.okio.AsyncTimeout r0 = r0.f1553c
                r0.enter()
                r0 = 0
                org.cocos2dx.okhttp3.a r1 = org.cocos2dx.okhttp3.a.this     // Catch:{ IOException -> 0x002c, all -> 0x0027 }
                org.cocos2dx.okhttp3.Response r0 = r1.d()     // Catch:{ IOException -> 0x002c, all -> 0x0027 }
                r1 = 1
                org.cocos2dx.okhttp3.Callback r2 = r5.f1559a     // Catch:{ IOException -> 0x0025, all -> 0x0023 }
                org.cocos2dx.okhttp3.a r3 = org.cocos2dx.okhttp3.a.this     // Catch:{ IOException -> 0x0025, all -> 0x0023 }
                r2.onResponse(r3, r0)     // Catch:{ IOException -> 0x0025, all -> 0x0023 }
            L_0x0016:
                org.cocos2dx.okhttp3.a r0 = org.cocos2dx.okhttp3.a.this
                org.cocos2dx.okhttp3.OkHttpClient r0 = r0.f1551a
                org.cocos2dx.okhttp3.Dispatcher r0 = r0.dispatcher()
                r0.finished((org.cocos2dx.okhttp3.a.b) r5)
                goto L_0x0094
            L_0x0023:
                r0 = move-exception
                goto L_0x0031
            L_0x0025:
                r0 = move-exception
                goto L_0x0059
            L_0x0027:
                r1 = move-exception
                r4 = r1
                r1 = r0
                r0 = r4
                goto L_0x0031
            L_0x002c:
                r1 = move-exception
                r4 = r1
                r1 = r0
                r0 = r4
                goto L_0x0059
            L_0x0031:
                org.cocos2dx.okhttp3.a r2 = org.cocos2dx.okhttp3.a.this     // Catch:{ all -> 0x0056 }
                r2.cancel()     // Catch:{ all -> 0x0056 }
                if (r1 != 0) goto L_0x0058
                java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0056 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0056 }
                r2.<init>()     // Catch:{ all -> 0x0056 }
                java.lang.String r3 = "canceled due to "
                r2.append(r3)     // Catch:{ all -> 0x0056 }
                r2.append(r0)     // Catch:{ all -> 0x0056 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0056 }
                r1.<init>(r2)     // Catch:{ all -> 0x0056 }
                org.cocos2dx.okhttp3.Callback r2 = r5.f1559a     // Catch:{ all -> 0x0056 }
                org.cocos2dx.okhttp3.a r3 = org.cocos2dx.okhttp3.a.this     // Catch:{ all -> 0x0056 }
                r2.onFailure(r3, r1)     // Catch:{ all -> 0x0056 }
                goto L_0x0058
            L_0x0056:
                r0 = move-exception
                goto L_0x0095
            L_0x0058:
                throw r0     // Catch:{ all -> 0x0056 }
            L_0x0059:
                org.cocos2dx.okhttp3.a r2 = org.cocos2dx.okhttp3.a.this     // Catch:{ all -> 0x0056 }
                java.io.IOException r0 = r2.h(r0)     // Catch:{ all -> 0x0056 }
                if (r1 == 0) goto L_0x0081
                org.cocos2dx.okhttp3.internal.platform.Platform r1 = org.cocos2dx.okhttp3.internal.platform.Platform.get()     // Catch:{ all -> 0x0056 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0056 }
                r2.<init>()     // Catch:{ all -> 0x0056 }
                java.lang.String r3 = "Callback failure for "
                r2.append(r3)     // Catch:{ all -> 0x0056 }
                org.cocos2dx.okhttp3.a r3 = org.cocos2dx.okhttp3.a.this     // Catch:{ all -> 0x0056 }
                java.lang.String r3 = r3.i()     // Catch:{ all -> 0x0056 }
                r2.append(r3)     // Catch:{ all -> 0x0056 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0056 }
                r3 = 4
                r1.log(r3, r2, r0)     // Catch:{ all -> 0x0056 }
                goto L_0x0016
            L_0x0081:
                org.cocos2dx.okhttp3.a r1 = org.cocos2dx.okhttp3.a.this     // Catch:{ all -> 0x0056 }
                org.cocos2dx.okhttp3.EventListener r1 = r1.f1554d     // Catch:{ all -> 0x0056 }
                org.cocos2dx.okhttp3.a r2 = org.cocos2dx.okhttp3.a.this     // Catch:{ all -> 0x0056 }
                r1.callFailed(r2, r0)     // Catch:{ all -> 0x0056 }
                org.cocos2dx.okhttp3.Callback r1 = r5.f1559a     // Catch:{ all -> 0x0056 }
                org.cocos2dx.okhttp3.a r2 = org.cocos2dx.okhttp3.a.this     // Catch:{ all -> 0x0056 }
                r1.onFailure(r2, r0)     // Catch:{ all -> 0x0056 }
                goto L_0x0016
            L_0x0094:
                return
            L_0x0095:
                org.cocos2dx.okhttp3.a r1 = org.cocos2dx.okhttp3.a.this
                org.cocos2dx.okhttp3.OkHttpClient r1 = r1.f1551a
                org.cocos2dx.okhttp3.Dispatcher r1 = r1.dispatcher()
                r1.finished((org.cocos2dx.okhttp3.a.b) r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.a.b.execute():void");
        }

        /* access modifiers changed from: package-private */
        public a f() {
            return a.this;
        }

        /* access modifiers changed from: package-private */
        public String g() {
            return a.this.f1555e.url().host();
        }
    }

    private a(OkHttpClient okHttpClient, Request request, boolean z10) {
        this.f1551a = okHttpClient;
        this.f1555e = request;
        this.f1556f = z10;
        this.f1552b = new RetryAndFollowUpInterceptor(okHttpClient, z10);
        C0025a aVar = new C0025a();
        this.f1553c = aVar;
        aVar.timeout((long) okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    private void b() {
        this.f1552b.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    static a e(OkHttpClient okHttpClient, Request request, boolean z10) {
        a aVar = new a(okHttpClient, request, z10);
        aVar.f1554d = okHttpClient.eventListenerFactory().create(aVar);
        return aVar;
    }

    /* renamed from: c */
    public a clone() {
        return e(this.f1551a, this.f1555e, this.f1556f);
    }

    public void cancel() {
        this.f1552b.cancel();
    }

    /* access modifiers changed from: package-private */
    public Response d() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f1551a.interceptors());
        arrayList.add(this.f1552b);
        arrayList.add(new BridgeInterceptor(this.f1551a.cookieJar()));
        arrayList.add(new CacheInterceptor(this.f1551a.internalCache()));
        arrayList.add(new ConnectInterceptor(this.f1551a));
        if (!this.f1556f) {
            arrayList.addAll(this.f1551a.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.f1556f));
        Response proceed = new RealInterceptorChain(arrayList, (StreamAllocation) null, (HttpCodec) null, (RealConnection) null, 0, this.f1555e, this, this.f1554d, this.f1551a.connectTimeoutMillis(), this.f1551a.readTimeoutMillis(), this.f1551a.writeTimeoutMillis()).proceed(this.f1555e);
        if (!this.f1552b.isCanceled()) {
            return proceed;
        }
        Util.closeQuietly((Closeable) proceed);
        throw new IOException("Canceled");
    }

    public void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.f1557g) {
                this.f1557g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        b();
        this.f1554d.callStart(this);
        this.f1551a.dispatcher().enqueue(new b(callback));
    }

    public Response execute() {
        synchronized (this) {
            if (!this.f1557g) {
                this.f1557g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        b();
        this.f1553c.enter();
        this.f1554d.callStart(this);
        try {
            this.f1551a.dispatcher().executed(this);
            Response d10 = d();
            if (d10 != null) {
                this.f1551a.dispatcher().finished(this);
                return d10;
            }
            throw new IOException("Canceled");
        } catch (IOException e10) {
            IOException h10 = h(e10);
            this.f1554d.callFailed(this, h10);
            throw h10;
        } catch (Throwable th) {
            this.f1551a.dispatcher().finished(this);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public String f() {
        return this.f1555e.url().redact();
    }

    /* access modifiers changed from: package-private */
    public StreamAllocation g() {
        return this.f1552b.streamAllocation();
    }

    /* access modifiers changed from: package-private */
    public IOException h(IOException iOException) {
        if (!this.f1553c.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* access modifiers changed from: package-private */
    public String i() {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        if (isCanceled()) {
            str = "canceled ";
        } else {
            str = "";
        }
        sb2.append(str);
        if (this.f1556f) {
            str2 = "web socket";
        } else {
            str2 = NotificationCompat.CATEGORY_CALL;
        }
        sb2.append(str2);
        sb2.append(" to ");
        sb2.append(f());
        return sb2.toString();
    }

    public boolean isCanceled() {
        return this.f1552b.isCanceled();
    }

    public synchronized boolean isExecuted() {
        return this.f1557g;
    }

    public Request request() {
        return this.f1555e;
    }

    public Timeout timeout() {
        return this.f1553c;
    }
}
