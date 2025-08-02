package g2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.alibaba.pdns.f;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.o;
import com.facebook.t;
import com.facebook.w;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;
import q5.d0;
import q5.p0;

public final class e {

    /* renamed from: e  reason: collision with root package name */
    private static final String f21670e;

    /* renamed from: f  reason: collision with root package name */
    private static e f21671f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f21672g = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Handler f21673a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference f21674b;

    /* renamed from: c  reason: collision with root package name */
    private Timer f21675c;

    /* renamed from: d  reason: collision with root package name */
    private String f21676d = null;

    public static final class a {

        /* renamed from: g2.e$a$a  reason: collision with other inner class name */
        static final class C0282a implements GraphRequest.b {

            /* renamed from: a  reason: collision with root package name */
            public static final C0282a f21677a = new C0282a();

            C0282a() {
            }

            public final void a(t tVar) {
                m.f(tVar, "it");
                d0.f23283f.b(w.APP_EVENTS, e.d(), "App index sent to FB!");
            }
        }

        private a() {
        }

        public final GraphRequest a(String str, AccessToken accessToken, String str2, String str3) {
            m.f(str3, "requestType");
            if (str == null) {
                return null;
            }
            GraphRequest.c cVar = GraphRequest.f19541t;
            b0 b0Var = b0.f709a;
            String format = String.format(Locale.US, "%s/app_indexing", Arrays.copyOf(new Object[]{str2}, 1));
            m.e(format, "java.lang.String.format(locale, format, *args)");
            GraphRequest x10 = cVar.x(accessToken, format, (JSONObject) null, (GraphRequest.b) null);
            Bundle s10 = x10.s();
            if (s10 == null) {
                s10 = new Bundle();
            }
            s10.putString("tree", str);
            s10.putString("app_version", l2.b.d());
            s10.putString("platform", f.f17924q);
            s10.putString("request_type", str3);
            if (m.b(str3, "app_indexing")) {
                s10.putString("device_session_id", b.h());
            }
            x10.F(s10);
            x10.B(C0282a.f21677a);
            return x10;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class b implements Callable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference f21678a;

        public b(View view) {
            m.f(view, "rootView");
            this.f21678a = new WeakReference(view);
        }

        /* renamed from: a */
        public String call() {
            View view = (View) this.f21678a.get();
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                return "";
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
            String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            m.e(encodeToString, "Base64.encodeToString(ou…eArray(), Base64.NO_WRAP)");
            return encodeToString;
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f21679a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TimerTask f21680b;

        c(e eVar, TimerTask timerTask) {
            this.f21679a = eVar;
            this.f21680b = timerTask;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    Timer b10 = e.b(this.f21679a);
                    if (b10 != null) {
                        b10.cancel();
                    }
                    e.h(this.f21679a, (String) null);
                    Timer timer = new Timer();
                    timer.scheduleAtFixedRate(this.f21680b, 0, (long) 1000);
                    e.g(this.f21679a, timer);
                } catch (Exception e10) {
                    Log.e(e.d(), "Error scheduling indexing job", e10);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    public static final class d extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f21681a;

        d(e eVar) {
            this.f21681a = eVar;
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0082 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                g2.e r0 = r7.f21681a     // Catch:{ Exception -> 0x0034 }
                java.lang.ref.WeakReference r0 = g2.e.a(r0)     // Catch:{ Exception -> 0x0034 }
                java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0034 }
                android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ Exception -> 0x0034 }
                android.view.View r1 = l2.b.e(r0)     // Catch:{ Exception -> 0x0034 }
                if (r0 == 0) goto L_0x009a
                if (r1 != 0) goto L_0x0016
                goto L_0x009a
            L_0x0016:
                java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x0034 }
                java.lang.String r0 = r0.getSimpleName()     // Catch:{ Exception -> 0x0034 }
                java.lang.String r2 = "activity.javaClass.simpleName"
                kotlin.jvm.internal.m.e(r0, r2)     // Catch:{ Exception -> 0x0034 }
                boolean r2 = g2.b.i()     // Catch:{ Exception -> 0x0034 }
                if (r2 != 0) goto L_0x002a
                return
            L_0x002a:
                boolean r2 = q5.b0.b()     // Catch:{ Exception -> 0x0034 }
                if (r2 == 0) goto L_0x0036
                h2.e.a()     // Catch:{ Exception -> 0x0034 }
                return
            L_0x0034:
                r0 = move-exception
                goto L_0x009b
            L_0x0036:
                java.util.concurrent.FutureTask r2 = new java.util.concurrent.FutureTask     // Catch:{ Exception -> 0x0034 }
                g2.e$b r3 = new g2.e$b     // Catch:{ Exception -> 0x0034 }
                r3.<init>(r1)     // Catch:{ Exception -> 0x0034 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x0034 }
                g2.e r3 = r7.f21681a     // Catch:{ Exception -> 0x0034 }
                android.os.Handler r3 = g2.e.e(r3)     // Catch:{ Exception -> 0x0034 }
                r3.post(r2)     // Catch:{ Exception -> 0x0034 }
                java.lang.String r3 = ""
                java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x0057 }
                r5 = 1
                java.lang.Object r2 = r2.get(r5, r4)     // Catch:{ Exception -> 0x0057 }
                java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0057 }
                r3 = r2
                goto L_0x0061
            L_0x0057:
                r2 = move-exception
                java.lang.String r4 = g2.e.d()     // Catch:{ Exception -> 0x0034 }
                java.lang.String r5 = "Failed to take screenshot."
                android.util.Log.e(r4, r5, r2)     // Catch:{ Exception -> 0x0034 }
            L_0x0061:
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0034 }
                r2.<init>()     // Catch:{ Exception -> 0x0034 }
                java.lang.String r4 = "screenname"
                r2.put(r4, r0)     // Catch:{ JSONException -> 0x0082 }
                java.lang.String r0 = "screenshot"
                r2.put(r0, r3)     // Catch:{ JSONException -> 0x0082 }
                org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0082 }
                r0.<init>()     // Catch:{ JSONException -> 0x0082 }
                org.json.JSONObject r1 = h2.f.d(r1)     // Catch:{ JSONException -> 0x0082 }
                r0.put(r1)     // Catch:{ JSONException -> 0x0082 }
                java.lang.String r1 = "view"
                r2.put(r1, r0)     // Catch:{ JSONException -> 0x0082 }
                goto L_0x008b
            L_0x0082:
                java.lang.String r0 = g2.e.d()     // Catch:{ Exception -> 0x0034 }
                java.lang.String r1 = "Failed to create JSONObject"
                android.util.Log.e(r0, r1)     // Catch:{ Exception -> 0x0034 }
            L_0x008b:
                java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0034 }
                java.lang.String r1 = "viewTree.toString()"
                kotlin.jvm.internal.m.e(r0, r1)     // Catch:{ Exception -> 0x0034 }
                g2.e r1 = r7.f21681a     // Catch:{ Exception -> 0x0034 }
                g2.e.f(r1, r0)     // Catch:{ Exception -> 0x0034 }
                goto L_0x00a4
            L_0x009a:
                return
            L_0x009b:
                java.lang.String r1 = g2.e.d()
                java.lang.String r2 = "UI Component tree indexing failure!"
                android.util.Log.e(r1, r2, r0)
            L_0x00a4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.e.d.run():void");
        }
    }

    /* renamed from: g2.e$e  reason: collision with other inner class name */
    static final class C0283e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f21682a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f21683b;

        C0283e(e eVar, String str) {
            this.f21682a = eVar;
            this.f21683b = str;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    String j02 = p0.j0(this.f21683b);
                    AccessToken e10 = AccessToken.N0.e();
                    if (j02 == null || !m.b(j02, e.c(this.f21682a))) {
                        this.f21682a.i(e.f21672g.a(this.f21683b, e10, o.g(), "app_indexing"), j02);
                    }
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static {
        String canonicalName = e.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "";
        }
        m.e(canonicalName, "ViewIndexer::class.java.canonicalName ?: \"\"");
        f21670e = canonicalName;
    }

    public e(Activity activity) {
        m.f(activity, "activity");
        this.f21674b = new WeakReference(activity);
        f21671f = this;
    }

    public static final /* synthetic */ WeakReference a(e eVar) {
        Class<e> cls = e.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return eVar.f21674b;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Timer b(e eVar) {
        Class<e> cls = e.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return eVar.f21675c;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ String c(e eVar) {
        Class<e> cls = e.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return eVar.f21676d;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ String d() {
        Class<e> cls = e.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f21670e;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Handler e(e eVar) {
        Class<e> cls = e.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return eVar.f21673a;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void f(e eVar, String str) {
        Class<e> cls = e.class;
        if (!v5.a.d(cls)) {
            try {
                eVar.k(str);
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final /* synthetic */ void g(e eVar, Timer timer) {
        Class<e> cls = e.class;
        if (!v5.a.d(cls)) {
            try {
                eVar.f21675c = timer;
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final /* synthetic */ void h(e eVar, String str) {
        Class<e> cls = e.class;
        if (!v5.a.d(cls)) {
            try {
                eVar.f21676d = str;
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private final void k(String str) {
        if (!v5.a.d(this)) {
            try {
                o.p().execute(new C0283e(this, str));
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public final void i(GraphRequest graphRequest, String str) {
        if (!v5.a.d(this) && graphRequest != null) {
            try {
                t i10 = graphRequest.i();
                JSONObject c10 = i10.c();
                if (c10 != null) {
                    if (m.b("true", c10.optString(FirebaseAnalytics.Param.SUCCESS))) {
                        d0.f23283f.b(w.APP_EVENTS, f21670e, "Successfully send UI component tree to server");
                        this.f21676d = str;
                    }
                    if (c10.has("is_app_indexing_enabled")) {
                        b.n(c10.getBoolean("is_app_indexing_enabled"));
                        return;
                    }
                    return;
                }
                String str2 = f21670e;
                Log.e(str2, "Error sending UI component tree to Facebook: " + i10.b());
            } catch (JSONException e10) {
                Log.e(f21670e, "Error decoding server response.", e10);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public final void j() {
        if (!v5.a.d(this)) {
            try {
                o.p().execute(new c(this, new d(this)));
            } catch (RejectedExecutionException e10) {
                Log.e(f21670e, "Error scheduling indexing job", e10);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public final void l() {
        if (!v5.a.d(this)) {
            try {
                if (((Activity) this.f21674b.get()) != null) {
                    Timer timer = this.f21675c;
                    if (timer != null) {
                        timer.cancel();
                    }
                    this.f21675c = null;
                }
            } catch (Exception e10) {
                Log.e(f21670e, "Error unscheduling indexing job", e10);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }
}
