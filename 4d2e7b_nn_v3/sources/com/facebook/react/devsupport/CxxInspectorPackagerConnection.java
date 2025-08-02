package com.facebook.react.devsupport;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.facebook.jni.HybridData;
import java.io.Closeable;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

class CxxInspectorPackagerConnection implements i0 {
    @d6.a
    private final HybridData mHybridData;

    private static class DelegateImpl {

        /* renamed from: a  reason: collision with root package name */
        private final OkHttpClient f2951a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f2952b;

        class a extends WebSocketListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ WebSocketDelegate f2953a;

            a(WebSocketDelegate webSocketDelegate) {
                this.f2953a = webSocketDelegate;
            }

            public void onClosed(WebSocket webSocket, int i10, String str) {
                this.f2953a.didClose();
                this.f2953a.close();
            }

            public void onFailure(WebSocket webSocket, Throwable th, Response response) {
                String message = th.getMessage();
                WebSocketDelegate webSocketDelegate = this.f2953a;
                if (message == null) {
                    message = "<Unknown error>";
                }
                webSocketDelegate.didFailWithError((Integer) null, message);
                this.f2953a.close();
            }

            public void onMessage(WebSocket webSocket, String str) {
                this.f2953a.didReceiveMessage(str);
            }
        }

        class b implements a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ WebSocket f2955a;

            b(WebSocket webSocket) {
                this.f2955a = webSocket;
            }

            public void close() {
                this.f2955a.close(1000, "End of session");
            }
        }

        @d6.a
        public a connectWebSocket(String str, WebSocketDelegate webSocketDelegate) {
            return new b(this.f2951a.newWebSocket(new Request.Builder().url(str).build(), new a(webSocketDelegate)));
        }

        @d6.a
        public void scheduleCallback(Runnable runnable, long j10) {
            this.f2952b.postDelayed(runnable, j10);
        }

        private DelegateImpl() {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.f2951a = builder.connectTimeout(10, timeUnit).writeTimeout(10, timeUnit).readTimeout(0, TimeUnit.MINUTES).build();
            this.f2952b = new Handler(Looper.getMainLooper());
        }
    }

    @d6.a
    private static class WebSocketDelegate implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        private final HybridData f2957a;

        @d6.a
        private WebSocketDelegate(HybridData hybridData) {
            this.f2957a = hybridData;
        }

        public void close() {
            this.f2957a.resetNative();
        }

        public native void didClose();

        public native void didFailWithError(@Nullable Integer num, String str);

        public native void didReceiveMessage(String str);
    }

    private interface a extends Closeable {
    }

    static {
        f0.a();
    }

    public CxxInspectorPackagerConnection(String str, String str2) {
        this.mHybridData = initHybrid(str, str2, new DelegateImpl());
    }

    private static native HybridData initHybrid(String str, String str2, DelegateImpl delegateImpl);

    public native void closeQuietly();

    public native void connect();

    public native void sendEventToAllConnections(String str);
}
