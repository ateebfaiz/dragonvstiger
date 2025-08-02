package com.facebook.react.devsupport;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Inspector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j0 implements i0 {

    /* renamed from: a  reason: collision with root package name */
    private final b f3116a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Map f3117b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final String f3118c;

    class a implements Inspector.RemoteConnection {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f3119a;

        a(String str) {
            this.f3119a = str;
        }

        public void onDisconnect() {
            try {
                j0.this.f3117b.remove(this.f3119a);
                j0 j0Var = j0.this;
                j0Var.l("disconnect", j0Var.k(this.f3119a));
            } catch (JSONException e10) {
                z2.a.H("InspectorPackagerConnection", "Couldn't send event to packager", e10);
            }
        }

        public void onMessage(String str) {
            try {
                j0.this.m(this.f3119a, str);
            } catch (JSONException e10) {
                z2.a.H("InspectorPackagerConnection", "Couldn't send event to packager", e10);
            }
        }
    }

    private class b extends WebSocketListener {

        /* renamed from: a  reason: collision with root package name */
        private final String f3121a;

        /* renamed from: b  reason: collision with root package name */
        private OkHttpClient f3122b;

        /* renamed from: c  reason: collision with root package name */
        private WebSocket f3123c;

        /* renamed from: d  reason: collision with root package name */
        private final Handler f3124d = new Handler(Looper.getMainLooper());
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f3125e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f3126f;

        class a implements Runnable {
            a() {
            }

            public void run() {
                if (!b.this.f3125e) {
                    b.this.e();
                }
            }
        }

        /* renamed from: com.facebook.react.devsupport.j0$b$b  reason: collision with other inner class name */
        class C0051b extends AsyncTask {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ JSONObject f3129a;

            C0051b(JSONObject jSONObject) {
                this.f3129a = jSONObject;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Void doInBackground(WebSocket... webSocketArr) {
                if (!(webSocketArr == null || webSocketArr.length == 0)) {
                    try {
                        webSocketArr[0].send(this.f3129a.toString());
                    } catch (Exception e10) {
                        z2.a.H("InspectorPackagerConnection", "Couldn't send event to packager", e10);
                    }
                }
                return null;
            }
        }

        public b(String str) {
            this.f3121a = str;
        }

        private void b(String str, Throwable th) {
            z2.a.k("InspectorPackagerConnection", "Error occurred, shutting down websocket connection: " + str, th);
            j0.this.e();
            d();
        }

        private void d() {
            WebSocket webSocket = this.f3123c;
            if (webSocket != null) {
                try {
                    webSocket.close(1000, "End of session");
                } catch (Exception unused) {
                }
                this.f3123c = null;
            }
        }

        private void f() {
            if (!this.f3125e) {
                if (!this.f3126f) {
                    z2.a.G("InspectorPackagerConnection", "Couldn't connect to packager, will silently retry");
                    this.f3126f = true;
                }
                this.f3124d.postDelayed(new a(), 2000);
                return;
            }
            throw new IllegalStateException("Can't reconnect closed client");
        }

        public void c() {
            this.f3125e = true;
            WebSocket webSocket = this.f3123c;
            if (webSocket != null) {
                try {
                    webSocket.close(1000, "End of session");
                } catch (Exception unused) {
                }
                this.f3123c = null;
            }
        }

        public void e() {
            if (!this.f3125e) {
                if (this.f3122b == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    this.f3122b = builder.connectTimeout(10, timeUnit).writeTimeout(10, timeUnit).readTimeout(0, TimeUnit.MINUTES).build();
                }
                this.f3122b.newWebSocket(new Request.Builder().url(this.f3121a).build(), this);
                return;
            }
            throw new IllegalStateException("Can't connect closed client");
        }

        public void g(JSONObject jSONObject) {
            new C0051b(jSONObject).execute(new WebSocket[]{this.f3123c});
        }

        public void onClosed(WebSocket webSocket, int i10, String str) {
            this.f3123c = null;
            j0.this.e();
            if (!this.f3125e) {
                f();
            }
        }

        public void onFailure(WebSocket webSocket, Throwable th, Response response) {
            if (this.f3123c != null) {
                b("Websocket exception", th);
            }
            if (!this.f3125e) {
                f();
            }
        }

        public void onMessage(WebSocket webSocket, String str) {
            try {
                j0.this.i(new JSONObject(str));
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }

        public void onOpen(WebSocket webSocket, Response response) {
            this.f3123c = webSocket;
        }
    }

    public j0(String str, String str2) {
        this.f3116a = new b(str);
        this.f3118c = str2;
    }

    private JSONArray f() {
        List<Inspector.Page> pages = Inspector.getPages();
        JSONArray jSONArray = new JSONArray();
        for (Inspector.Page next : pages) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", String.valueOf(next.getId()));
            jSONObject.put("title", next.getTitle());
            jSONObject.put("app", this.f3118c);
            jSONObject.put("vm", next.getVM());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    private void g(JSONObject jSONObject) {
        String string = jSONObject.getString("pageId");
        if (((Inspector.LocalConnection) this.f3117b.remove(string)) == null) {
            try {
                this.f3117b.put(string, Inspector.connect(Integer.parseInt(string), new a(string)));
            } catch (Exception e10) {
                z2.a.H("InspectorPackagerConnection", "Failed to open page: " + string, e10);
                l("disconnect", k(string));
            }
        } else {
            throw new IllegalStateException("Already connected: " + string);
        }
    }

    private void h(JSONObject jSONObject) {
        Inspector.LocalConnection localConnection = (Inspector.LocalConnection) this.f3117b.remove(jSONObject.getString("pageId"));
        if (localConnection != null) {
            localConnection.disconnect();
        }
    }

    private void j(JSONObject jSONObject) {
        String string = jSONObject.getString("pageId");
        String string2 = jSONObject.getString("wrappedEvent");
        Inspector.LocalConnection localConnection = (Inspector.LocalConnection) this.f3117b.get(string);
        if (localConnection == null) {
            z2.a.G("InspectorPackagerConnection", "PageID " + string + " is disconnected. Dropping event: " + string2);
            return;
        }
        localConnection.sendMessage(string2);
    }

    /* access modifiers changed from: private */
    public JSONObject k(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pageId", str);
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public void l(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, str);
        jSONObject.put("payload", obj);
        this.f3116a.g(jSONObject);
    }

    /* access modifiers changed from: private */
    public void m(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pageId", str);
        jSONObject.put("wrappedEvent", str2);
        l("wrappedEvent", jSONObject);
    }

    public void closeQuietly() {
        this.f3116a.c();
    }

    public void connect() {
        this.f3116a.e();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        for (Map.Entry value : this.f3117b.entrySet()) {
            ((Inspector.LocalConnection) value.getValue()).disconnect();
        }
        this.f3117b.clear();
    }

    /* access modifiers changed from: package-private */
    public void i(JSONObject jSONObject) {
        String string = jSONObject.getString(NotificationCompat.CATEGORY_EVENT);
        string.hashCode();
        char c10 = 65535;
        switch (string.hashCode()) {
            case 530405532:
                if (string.equals("disconnect")) {
                    c10 = 0;
                    break;
                }
                break;
            case 951351530:
                if (string.equals("connect")) {
                    c10 = 1;
                    break;
                }
                break;
            case 1328613653:
                if (string.equals("wrappedEvent")) {
                    c10 = 2;
                    break;
                }
                break;
            case 1962251790:
                if (string.equals("getPages")) {
                    c10 = 3;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                h(jSONObject.getJSONObject("payload"));
                return;
            case 1:
                g(jSONObject.getJSONObject("payload"));
                return;
            case 2:
                j(jSONObject.getJSONObject("payload"));
                return;
            case 3:
                l("getPages", f());
                return;
            default:
                throw new IllegalArgumentException("Unknown event: " + string);
        }
    }

    public void sendEventToAllConnections(String str) {
        for (Map.Entry value : this.f3117b.entrySet()) {
            ((Inspector.LocalConnection) value.getValue()).sendMessage(str);
        }
    }
}
