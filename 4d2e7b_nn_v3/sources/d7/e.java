package d7;

import android.os.Handler;
import android.os.Looper;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public final class e extends WebSocketListener {

    /* renamed from: i  reason: collision with root package name */
    private static final String f11883i = "e";

    /* renamed from: a  reason: collision with root package name */
    private final String f11884a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f11885b;

    /* renamed from: c  reason: collision with root package name */
    private final OkHttpClient f11886c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11887d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11888e;

    /* renamed from: f  reason: collision with root package name */
    private WebSocket f11889f;

    /* renamed from: g  reason: collision with root package name */
    private c f11890g;

    /* renamed from: h  reason: collision with root package name */
    private b f11891h;

    class a implements Runnable {
        a() {
        }

        public void run() {
            e.this.f();
        }
    }

    public interface b {
        void a();

        void b();
    }

    public interface c {
        void a(ByteString byteString);

        void onMessage(String str);
    }

    public e(String str, c cVar, b bVar) {
        this.f11884a = str;
        this.f11890g = cVar;
        this.f11891h = bVar;
        this.f11885b = new Handler(Looper.getMainLooper());
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f11886c = builder.connectTimeout(10, timeUnit).writeTimeout(10, timeUnit).readTimeout(0, TimeUnit.MINUTES).build();
    }

    private void b(String str, Throwable th) {
        String str2 = f11883i;
        z2.a.k(str2, "Error occurred, shutting down websocket connection: " + str, th);
        d();
    }

    private void d() {
        WebSocket webSocket = this.f11889f;
        if (webSocket != null) {
            try {
                webSocket.close(1000, "End of session");
            } catch (Exception unused) {
            }
            this.f11889f = null;
        }
    }

    /* access modifiers changed from: private */
    public synchronized void f() {
        if (!this.f11887d) {
            e();
        }
    }

    private void g() {
        if (!this.f11887d) {
            if (!this.f11888e) {
                String str = f11883i;
                z2.a.G(str, "Couldn't connect to \"" + this.f11884a + "\", will silently retry");
                this.f11888e = true;
            }
            this.f11885b.postDelayed(new a(), 2000);
            return;
        }
        throw new IllegalStateException("Can't reconnect closed client");
    }

    public void c() {
        this.f11887d = true;
        d();
        this.f11890g = null;
        b bVar = this.f11891h;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void e() {
        if (!this.f11887d) {
            this.f11886c.newWebSocket(new Request.Builder().url(this.f11884a).build(), this);
            return;
        }
        throw new IllegalStateException("Can't connect closed client");
    }

    public synchronized void h(String str) {
        WebSocket webSocket = this.f11889f;
        if (webSocket != null) {
            webSocket.send(str);
        } else {
            throw new ClosedChannelException();
        }
    }

    public synchronized void onClosed(WebSocket webSocket, int i10, String str) {
        try {
            this.f11889f = null;
            if (!this.f11887d) {
                b bVar = this.f11891h;
                if (bVar != null) {
                    bVar.b();
                }
                g();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void onFailure(WebSocket webSocket, Throwable th, Response response) {
        try {
            if (this.f11889f != null) {
                b("Websocket exception", th);
            }
            if (!this.f11887d) {
                b bVar = this.f11891h;
                if (bVar != null) {
                    bVar.b();
                }
                g();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void onMessage(WebSocket webSocket, String str) {
        c cVar = this.f11890g;
        if (cVar != null) {
            cVar.onMessage(str);
        }
    }

    public synchronized void onOpen(WebSocket webSocket, Response response) {
        this.f11889f = webSocket;
        this.f11888e = false;
        b bVar = this.f11891h;
        if (bVar != null) {
            bVar.a();
        }
    }

    public synchronized void onMessage(WebSocket webSocket, ByteString byteString) {
        c cVar = this.f11890g;
        if (cVar != null) {
            cVar.a(byteString);
        }
    }
}
