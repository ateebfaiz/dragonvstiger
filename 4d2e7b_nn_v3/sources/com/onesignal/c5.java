package com.onesignal;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.onesignal.a;
import com.onesignal.d0;
import com.onesignal.o3;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

class c5 extends a.b {

    /* renamed from: k  reason: collision with root package name */
    private static final String f10458k = "com.onesignal.c5";

    /* renamed from: l  reason: collision with root package name */
    private static final int f10459l = m3.b(24);

    /* renamed from: m  reason: collision with root package name */
    protected static c5 f10460m = null;

    /* renamed from: a  reason: collision with root package name */
    private final Object f10461a = new b();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public OSWebView f10462b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public d0 f10463c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Activity f10464d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public q1 f10465e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public n1 f10466f;

    /* renamed from: g  reason: collision with root package name */
    private String f10467g = null;

    /* renamed from: h  reason: collision with root package name */
    private Integer f10468h = null;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f10469i = false;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f10470j = false;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10471a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.onesignal.c5$m[] r0 = com.onesignal.c5.m.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10471a = r0
                com.onesignal.c5$m r1 = com.onesignal.c5.m.TOP_BANNER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10471a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.onesignal.c5$m r1 = com.onesignal.c5.m.BOTTOM_BANNER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.c5.a.<clinit>():void");
        }
    }

    class b {
        b() {
        }
    }

    class c implements l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f10473a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q1 f10474b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ n1 f10475c;

        c(Activity activity, q1 q1Var, n1 n1Var) {
            this.f10473a = activity;
            this.f10474b = q1Var;
            this.f10475c = n1Var;
        }

        public void onComplete() {
            c5.f10460m = null;
            c5.B(this.f10473a, this.f10474b, this.f10475c);
        }
    }

    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q1 f10476a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n1 f10477b;

        d(q1 q1Var, n1 n1Var) {
            this.f10476a = q1Var;
            this.f10477b = n1Var;
        }

        public void run() {
            c5.I(this.f10476a, this.f10477b);
        }
    }

    class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f10479b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f10480c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ n1 f10481d;

        e(Activity activity, String str, n1 n1Var) {
            this.f10479b = activity;
            this.f10480c = str;
            this.f10481d = n1Var;
        }

        public void run() {
            try {
                c5.this.H(this.f10479b, this.f10480c, this.f10481d.g());
            } catch (Exception e10) {
                if (e10.getMessage() == null || !e10.getMessage().contains("No WebView installed")) {
                    throw e10;
                }
                o3.b(o3.v.ERROR, "Error setting up WebView: ", e10);
            }
        }
    }

    class f implements Runnable {
        f() {
        }

        public void run() {
            int[] c10 = m3.c(c5.this.f10464d);
            c5.this.f10462b.evaluateJavascript(String.format("setSafeAreaInsets(%s)", new Object[]{String.format("{\n   top: %d,\n   bottom: %d,\n   right: %d,\n   left: %d,\n}", new Object[]{Integer.valueOf(c10[0]), Integer.valueOf(c10[1]), Integer.valueOf(c10[2]), Integer.valueOf(c10[3])})}), (ValueCallback) null);
        }
    }

    class g implements Runnable {

        class a implements ValueCallback {
            a() {
            }

            /* renamed from: a */
            public void onReceiveValue(String str) {
                try {
                    c5 c5Var = c5.this;
                    c5.this.J(Integer.valueOf(c5Var.C(c5Var.f10464d, new JSONObject(str))));
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            }
        }

        g() {
        }

        public void run() {
            c5 c5Var = c5.this;
            c5Var.G(c5Var.f10464d);
            if (c5.this.f10466f.g()) {
                c5.this.K();
            }
            c5.this.f10462b.evaluateJavascript("getPageMetaData()", new a());
        }
    }

    class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f10485a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f10486b;

        h(Activity activity, String str) {
            this.f10485a = activity;
            this.f10486b = str;
        }

        public void run() {
            c5.this.G(this.f10485a);
            c5.this.f10462b.loadData(this.f10486b, "text/html; charset=utf-8", "base64");
        }
    }

    class i implements d0.j {
        i() {
        }

        public void a() {
            o3.c0().a0(c5.this.f10465e);
            c5.this.D();
        }

        public void b() {
            o3.c0().g0(c5.this.f10465e);
        }

        public void c() {
            o3.c0().h0(c5.this.f10465e);
        }
    }

    class j implements l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f10489a;

        j(l lVar) {
            this.f10489a = lVar;
        }

        public void onComplete() {
            boolean unused = c5.this.f10469i = false;
            c5.this.F((d0) null);
            l lVar = this.f10489a;
            if (lVar != null) {
                lVar.onComplete();
            }
        }
    }

    class k {
        k() {
        }

        private m a(JSONObject jSONObject) {
            m mVar = m.FULL_SCREEN;
            try {
                if (!jSONObject.has("displayLocation") || jSONObject.get("displayLocation").equals("")) {
                    return mVar;
                }
                return m.valueOf(jSONObject.optString("displayLocation", "FULL_SCREEN").toUpperCase());
            } catch (JSONException e10) {
                e10.printStackTrace();
                return mVar;
            }
        }

        private boolean b(JSONObject jSONObject) {
            try {
                return jSONObject.getBoolean("dragToDismissDisabled");
            } catch (JSONException unused) {
                return false;
            }
        }

        private int c(JSONObject jSONObject) {
            try {
                c5 c5Var = c5.this;
                return c5Var.C(c5Var.f10464d, jSONObject.getJSONObject("pageMetaData"));
            } catch (JSONException unused) {
                return -1;
            }
        }

        private void d(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("body");
            String optString = jSONObject2.optString("id", (String) null);
            boolean unused = c5.this.f10470j = jSONObject2.getBoolean("close");
            if (c5.this.f10465e.f10982k) {
                o3.c0().d0(c5.this.f10465e, jSONObject2);
            } else if (optString != null) {
                o3.c0().c0(c5.this.f10465e, jSONObject2);
            }
            if (c5.this.f10470j) {
                c5.this.w((l) null);
            }
        }

        private void e(JSONObject jSONObject) {
            o3.c0().j0(c5.this.f10465e, jSONObject);
        }

        private void f(JSONObject jSONObject) {
            int i10;
            m a10 = a(jSONObject);
            if (a10 == m.FULL_SCREEN) {
                i10 = -1;
            } else {
                i10 = c(jSONObject);
            }
            boolean b10 = b(jSONObject);
            c5.this.f10466f.i(a10);
            c5.this.f10466f.j(i10);
            c5.this.v(b10);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        @android.webkit.JavascriptInterface
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void postMessage(java.lang.String r5) {
            /*
                r4 = this;
                com.onesignal.o3$v r0 = com.onesignal.o3.v.DEBUG     // Catch:{ JSONException -> 0x0035 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0035 }
                r1.<init>()     // Catch:{ JSONException -> 0x0035 }
                java.lang.String r2 = "OSJavaScriptInterface:postMessage: "
                r1.append(r2)     // Catch:{ JSONException -> 0x0035 }
                r1.append(r5)     // Catch:{ JSONException -> 0x0035 }
                java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0035 }
                com.onesignal.o3.d1(r0, r1)     // Catch:{ JSONException -> 0x0035 }
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0035 }
                r0.<init>(r5)     // Catch:{ JSONException -> 0x0035 }
                java.lang.String r5 = "type"
                java.lang.String r5 = r0.getString(r5)     // Catch:{ JSONException -> 0x0035 }
                int r1 = r5.hashCode()     // Catch:{ JSONException -> 0x0035 }
                r2 = 3
                r3 = 1
                switch(r1) {
                    case -1484226720: goto L_0x004b;
                    case -934437708: goto L_0x0041;
                    case 42998156: goto L_0x0037;
                    case 1851145598: goto L_0x002b;
                    default: goto L_0x002a;
                }     // Catch:{ JSONException -> 0x0035 }
            L_0x002a:
                goto L_0x0055
            L_0x002b:
                java.lang.String r1 = "action_taken"
                boolean r5 = r5.equals(r1)     // Catch:{ JSONException -> 0x0035 }
                if (r5 == 0) goto L_0x0055
                r5 = r3
                goto L_0x0056
            L_0x0035:
                r5 = move-exception
                goto L_0x0075
            L_0x0037:
                java.lang.String r1 = "rendering_complete"
                boolean r5 = r5.equals(r1)     // Catch:{ JSONException -> 0x0035 }
                if (r5 == 0) goto L_0x0055
                r5 = 0
                goto L_0x0056
            L_0x0041:
                java.lang.String r1 = "resize"
                boolean r5 = r5.equals(r1)     // Catch:{ JSONException -> 0x0035 }
                if (r5 == 0) goto L_0x0055
                r5 = 2
                goto L_0x0056
            L_0x004b:
                java.lang.String r1 = "page_change"
                boolean r5 = r5.equals(r1)     // Catch:{ JSONException -> 0x0035 }
                if (r5 == 0) goto L_0x0055
                r5 = r2
                goto L_0x0056
            L_0x0055:
                r5 = -1
            L_0x0056:
                if (r5 == 0) goto L_0x0071
                if (r5 == r3) goto L_0x0061
                if (r5 == r2) goto L_0x005d
                goto L_0x0078
            L_0x005d:
                r4.e(r0)     // Catch:{ JSONException -> 0x0035 }
                goto L_0x0078
            L_0x0061:
                com.onesignal.c5 r5 = com.onesignal.c5.this     // Catch:{ JSONException -> 0x0035 }
                com.onesignal.d0 r5 = r5.f10463c     // Catch:{ JSONException -> 0x0035 }
                boolean r5 = r5.O()     // Catch:{ JSONException -> 0x0035 }
                if (r5 != 0) goto L_0x0078
                r4.d(r0)     // Catch:{ JSONException -> 0x0035 }
                goto L_0x0078
            L_0x0071:
                r4.f(r0)     // Catch:{ JSONException -> 0x0035 }
                goto L_0x0078
            L_0x0075:
                r5.printStackTrace()
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.c5.k.postMessage(java.lang.String):void");
        }
    }

    interface l {
        void onComplete();
    }

    enum m {
        TOP_BANNER,
        BOTTOM_BANNER,
        CENTER_MODAL,
        FULL_SCREEN;

        /* access modifiers changed from: package-private */
        public boolean b() {
            int i10 = a.f10471a[ordinal()];
            if (i10 == 1 || i10 == 2) {
                return true;
            }
            return false;
        }
    }

    protected c5(q1 q1Var, Activity activity, n1 n1Var) {
        this.f10465e = q1Var;
        this.f10464d = activity;
        this.f10466f = n1Var;
    }

    private int A(Activity activity) {
        int i10;
        if (this.f10466f.g()) {
            i10 = 0;
        } else {
            i10 = f10459l * 2;
        }
        return m3.e(activity) - i10;
    }

    /* access modifiers changed from: private */
    public static void B(Activity activity, q1 q1Var, n1 n1Var) {
        if (n1Var.g()) {
            E(n1Var, activity);
        }
        try {
            String encodeToString = Base64.encodeToString(n1Var.a().getBytes("UTF-8"), 2);
            c5 c5Var = new c5(q1Var, activity, n1Var);
            f10460m = c5Var;
            OSUtils.S(new e(activity, encodeToString, n1Var));
        } catch (UnsupportedEncodingException e10) {
            o3.b(o3.v.ERROR, "Catch on initInAppMessage: ", e10);
            e10.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public int C(Activity activity, JSONObject jSONObject) {
        try {
            int b10 = m3.b(jSONObject.getJSONObject("rect").getInt(Snapshot.HEIGHT));
            o3.v vVar = o3.v.DEBUG;
            o3.d1(vVar, "getPageHeightData:pxHeight: " + b10);
            int A = A(activity);
            if (b10 <= A) {
                return b10;
            }
            o3.a(vVar, "getPageHeightData:pxHeight is over screen max: " + A);
            return A;
        } catch (JSONException e10) {
            o3.b(o3.v.ERROR, "pageRectToViewHeight could not get page height", e10);
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public void D() {
        a b10 = b.b();
        if (b10 != null) {
            b10.r(f10458k + this.f10465e.f10768a);
        }
    }

    private static void E(n1 n1Var, Activity activity) {
        String a10 = n1Var.a();
        int[] c10 = m3.c(activity);
        String format = String.format("\n\n<script>\n    setSafeAreaInsets(%s);\n</script>", new Object[]{String.format("{\n   top: %d,\n   bottom: %d,\n   right: %d,\n   left: %d,\n}", new Object[]{Integer.valueOf(c10[0]), Integer.valueOf(c10[1]), Integer.valueOf(c10[2]), Integer.valueOf(c10[3])})});
        n1Var.h(a10 + format);
    }

    /* access modifiers changed from: private */
    public void F(d0 d0Var) {
        synchronized (this.f10461a) {
            this.f10463c = d0Var;
        }
    }

    /* access modifiers changed from: private */
    public void G(Activity activity) {
        this.f10462b.layout(0, 0, z(activity), A(activity));
    }

    /* access modifiers changed from: private */
    public void H(Activity activity, String str, boolean z10) {
        y();
        OSWebView oSWebView = new OSWebView(activity);
        this.f10462b = oSWebView;
        oSWebView.setOverScrollMode(2);
        this.f10462b.setVerticalScrollBarEnabled(false);
        this.f10462b.setHorizontalScrollBarEnabled(false);
        this.f10462b.getSettings().setJavaScriptEnabled(true);
        this.f10462b.addJavascriptInterface(new k(), "OSAndroid");
        if (z10) {
            this.f10462b.setSystemUiVisibility(3074);
            if (Build.VERSION.SDK_INT >= 30) {
                this.f10462b.setFitsSystemWindows(false);
            }
        }
        t(this.f10462b);
        m3.a(activity, new h(activity, str));
    }

    static void I(q1 q1Var, n1 n1Var) {
        Activity Q = o3.Q();
        o3.v vVar = o3.v.DEBUG;
        o3.d1(vVar, "in app message showMessageContent on currentActivity: " + Q);
        if (Q != null) {
            c5 c5Var = f10460m;
            if (c5Var == null || !q1Var.f10982k) {
                B(Q, q1Var, n1Var);
            } else {
                c5Var.w(new c(Q, q1Var, n1Var));
            }
        } else {
            Looper.prepare();
            new Handler().postDelayed(new d(q1Var, n1Var), 200);
        }
    }

    /* access modifiers changed from: private */
    public void J(Integer num) {
        synchronized (this.f10461a) {
            try {
                if (this.f10463c == null) {
                    o3.a(o3.v.WARN, "No messageView found to update a with a new height.");
                    return;
                }
                o3.v vVar = o3.v.DEBUG;
                o3.a(vVar, "In app message, showing first one with height: " + num);
                this.f10463c.U(this.f10462b);
                if (num != null) {
                    this.f10468h = num;
                    this.f10463c.Z(num.intValue());
                }
                this.f10463c.X(this.f10464d);
                this.f10463c.B();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public void K() {
        OSUtils.S(new f());
    }

    private void t(WebView webView) {
    }

    private void u() {
        d0 d0Var = this.f10463c;
        if (d0Var != null) {
            if (d0Var.M() != m.FULL_SCREEN || this.f10466f.g()) {
                o3.a(o3.v.DEBUG, "In app message new activity, calculate height and show ");
                m3.a(this.f10464d, new g());
                return;
            }
            J((Integer) null);
        }
    }

    /* access modifiers changed from: private */
    public void v(boolean z10) {
        this.f10468h = Integer.valueOf(this.f10466f.d());
        F(new d0(this.f10462b, this.f10466f, z10));
        this.f10463c.R(new i());
        a b10 = b.b();
        if (b10 != null) {
            b10.c(f10458k + this.f10465e.f10768a, this);
        }
    }

    static void x() {
        o3.v vVar = o3.v.DEBUG;
        o3.d1(vVar, "WebViewManager IAM dismissAndAwaitNextMessage lastInstance: " + f10460m);
        c5 c5Var = f10460m;
        if (c5Var != null) {
            c5Var.w((l) null);
        }
    }

    private static void y() {
        if (o3.B(o3.v.DEBUG)) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    private int z(Activity activity) {
        if (this.f10466f.g()) {
            return m3.d(activity);
        }
        return m3.h(activity) - (f10459l * 2);
    }

    /* access modifiers changed from: package-private */
    public void a(Activity activity) {
        String str = this.f10467g;
        this.f10464d = activity;
        this.f10467g = activity.getLocalClassName();
        o3.v vVar = o3.v.DEBUG;
        o3.a(vVar, "In app message activity available currentActivityName: " + this.f10467g + " lastActivityName: " + str);
        if (str == null) {
            J((Integer) null);
        } else if (str.equals(this.f10467g)) {
            u();
        } else if (!this.f10470j) {
            d0 d0Var = this.f10463c;
            if (d0Var != null) {
                d0Var.P();
            }
            J(this.f10468h);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Activity activity) {
        o3.v vVar = o3.v.DEBUG;
        o3.a(vVar, "In app message activity stopped, cleaning views, currentActivityName: " + this.f10467g + "\nactivity: " + this.f10464d + "\nmessageView: " + this.f10463c);
        if (this.f10463c != null && activity.getLocalClassName().equals(this.f10467g)) {
            this.f10463c.P();
        }
    }

    /* access modifiers changed from: protected */
    public void w(l lVar) {
        d0 d0Var = this.f10463c;
        if (d0Var != null && !this.f10469i) {
            if (!(this.f10465e == null || d0Var == null)) {
                o3.c0().h0(this.f10465e);
            }
            this.f10463c.K(new j(lVar));
            this.f10469i = true;
        } else if (lVar != null) {
            lVar.onComplete();
        }
    }
}
