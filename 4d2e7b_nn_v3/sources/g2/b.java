package g2;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.o;
import g2.f;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;
import q5.p0;
import q5.r;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final f f21636a = new f();

    /* renamed from: b  reason: collision with root package name */
    private static SensorManager f21637b;

    /* renamed from: c  reason: collision with root package name */
    private static e f21638c;

    /* renamed from: d  reason: collision with root package name */
    private static String f21639d;

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicBoolean f21640e = new AtomicBoolean(true);

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicBoolean f21641f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    private static volatile boolean f21642g;

    /* renamed from: h  reason: collision with root package name */
    public static final b f21643h = new b();

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f21644a;

        a(String str) {
            this.f21644a = str;
        }

        public final void run() {
            String str;
            boolean z10 = true;
            String str2 = "0";
            if (!v5.a.d(this)) {
                try {
                    GraphRequest.c cVar = GraphRequest.f19541t;
                    b0 b0Var = b0.f709a;
                    String format = String.format(Locale.US, "%s/app_indexing_session", Arrays.copyOf(new Object[]{this.f21644a}, 1));
                    m.e(format, "java.lang.String.format(locale, format, *args)");
                    GraphRequest x10 = cVar.x((AccessToken) null, format, (JSONObject) null, (GraphRequest.b) null);
                    Bundle s10 = x10.s();
                    if (s10 == null) {
                        s10 = new Bundle();
                    }
                    q5.b e10 = q5.b.f23250h.e(o.f());
                    JSONArray jSONArray = new JSONArray();
                    String str3 = Build.MODEL;
                    if (str3 == null) {
                        str3 = "";
                    }
                    jSONArray.put(str3);
                    if (e10 != null) {
                        str = e10.h();
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        jSONArray.put(e10.h());
                    } else {
                        jSONArray.put("");
                    }
                    jSONArray.put(str2);
                    if (l2.b.f()) {
                        str2 = "1";
                    }
                    jSONArray.put(str2);
                    Locale y10 = p0.y();
                    jSONArray.put(y10.getLanguage() + "_" + y10.getCountry());
                    String jSONArray2 = jSONArray.toString();
                    m.e(jSONArray2, "extInfoArray.toString()");
                    s10.putString("device_session_id", b.h());
                    s10.putString("extinfo", jSONArray2);
                    x10.F(s10);
                    JSONObject c10 = x10.i().c();
                    b bVar = b.f21643h;
                    AtomicBoolean b10 = b.b(bVar);
                    if (c10 == null || !c10.optBoolean("is_app_indexing_enabled", false)) {
                        z10 = false;
                    }
                    b10.set(z10);
                    if (!b.b(bVar).get()) {
                        b.d(bVar, (String) null);
                    } else {
                        e a10 = b.a(bVar);
                        if (a10 != null) {
                            a10.j();
                        }
                    }
                    b.c(bVar, false);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    /* renamed from: g2.b$b  reason: collision with other inner class name */
    static final class C0280b implements f.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f21645a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f21646b;

        C0280b(r rVar, String str) {
            this.f21645a = rVar;
            this.f21646b = str;
        }

        public final void a() {
            boolean z10;
            r rVar = this.f21645a;
            if (rVar == null || !rVar.b()) {
                z10 = false;
            } else {
                z10 = true;
            }
            boolean o10 = o.o();
            if (z10 && o10) {
                b.e(this.f21646b);
            }
        }
    }

    private b() {
    }

    public static final /* synthetic */ e a(b bVar) {
        Class<b> cls = b.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f21638c;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ AtomicBoolean b(b bVar) {
        Class<b> cls = b.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f21641f;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void c(b bVar, boolean z10) {
        Class<b> cls = b.class;
        if (!v5.a.d(cls)) {
            try {
                f21642g = z10;
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final /* synthetic */ void d(b bVar, String str) {
        Class<b> cls = b.class;
        if (!v5.a.d(cls)) {
            try {
                f21639d = str;
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final void e(String str) {
        Class<b> cls = b.class;
        if (!v5.a.d(cls)) {
            try {
                if (!f21642g) {
                    f21642g = true;
                    o.p().execute(new a(str));
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final void f() {
        Class<b> cls = b.class;
        if (!v5.a.d(cls)) {
            try {
                f21640e.set(false);
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final void g() {
        Class<b> cls = b.class;
        if (!v5.a.d(cls)) {
            try {
                f21640e.set(true);
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final String h() {
        Class<b> cls = b.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            if (f21639d == null) {
                f21639d = UUID.randomUUID().toString();
            }
            String str = f21639d;
            if (str != null) {
                return str;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final boolean i() {
        Class<b> cls = b.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            return f21641f.get();
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }

    public static final boolean j() {
        v5.a.d(b.class);
        return false;
    }

    public static final void k(Activity activity) {
        Class<b> cls = b.class;
        if (!v5.a.d(cls)) {
            try {
                m.f(activity, "activity");
                c.f21649h.a().f(activity);
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final void l(Activity activity) {
        Class<b> cls = b.class;
        if (!v5.a.d(cls)) {
            try {
                m.f(activity, "activity");
                if (f21640e.get()) {
                    c.f21649h.a().h(activity);
                    e eVar = f21638c;
                    if (eVar != null) {
                        eVar.l();
                    }
                    SensorManager sensorManager = f21637b;
                    if (sensorManager != null) {
                        sensorManager.unregisterListener(f21636a);
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (j() != false) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m(android.app.Activity r7) {
        /*
            java.lang.Class<g2.b> r0 = g2.b.class
            boolean r1 = v5.a.d(r0)
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r1 = "activity"
            kotlin.jvm.internal.m.f(r7, r1)     // Catch:{ all -> 0x0036 }
            java.util.concurrent.atomic.AtomicBoolean r1 = f21640e     // Catch:{ all -> 0x0036 }
            boolean r1 = r1.get()     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x0017
            return
        L_0x0017:
            g2.c$a r1 = g2.c.f21649h     // Catch:{ all -> 0x0036 }
            g2.c r1 = r1.a()     // Catch:{ all -> 0x0036 }
            r1.e(r7)     // Catch:{ all -> 0x0036 }
            android.content.Context r1 = r7.getApplicationContext()     // Catch:{ all -> 0x0036 }
            java.lang.String r2 = com.facebook.o.g()     // Catch:{ all -> 0x0036 }
            q5.r r3 = q5.s.j(r2)     // Catch:{ all -> 0x0036 }
            r4 = 1
            if (r3 == 0) goto L_0x0039
            boolean r5 = r3.b()     // Catch:{ all -> 0x0036 }
            if (r5 == r4) goto L_0x003f
            goto L_0x0039
        L_0x0036:
            r7 = move-exception
            goto L_0x00ad
        L_0x0039:
            boolean r5 = j()     // Catch:{ all -> 0x0036 }
            if (r5 == 0) goto L_0x009b
        L_0x003f:
            java.lang.String r5 = "sensor"
            java.lang.Object r1 = r1.getSystemService(r5)     // Catch:{ all -> 0x0036 }
            android.hardware.SensorManager r1 = (android.hardware.SensorManager) r1     // Catch:{ all -> 0x0036 }
            f21637b = r1     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x004c
            return
        L_0x004c:
            java.lang.String r5 = "Required value was null."
            if (r1 == 0) goto L_0x0091
            android.hardware.Sensor r1 = r1.getDefaultSensor(r4)     // Catch:{ all -> 0x0036 }
            g2.e r4 = new g2.e     // Catch:{ all -> 0x0036 }
            r4.<init>(r7)     // Catch:{ all -> 0x0036 }
            f21638c = r4     // Catch:{ all -> 0x0036 }
            g2.f r7 = f21636a     // Catch:{ all -> 0x0036 }
            g2.b$b r4 = new g2.b$b     // Catch:{ all -> 0x0036 }
            r4.<init>(r3, r2)     // Catch:{ all -> 0x0036 }
            r7.a(r4)     // Catch:{ all -> 0x0036 }
            android.hardware.SensorManager r4 = f21637b     // Catch:{ all -> 0x0036 }
            if (r4 == 0) goto L_0x0087
            r6 = 2
            r4.registerListener(r7, r1, r6)     // Catch:{ all -> 0x0036 }
            if (r3 == 0) goto L_0x009b
            boolean r7 = r3.b()     // Catch:{ all -> 0x0036 }
            if (r7 == 0) goto L_0x009b
            g2.e r7 = f21638c     // Catch:{ all -> 0x0036 }
            if (r7 == 0) goto L_0x007d
            r7.j()     // Catch:{ all -> 0x0036 }
            goto L_0x009b
        L_0x007d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0036 }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x0036 }
            r7.<init>(r1)     // Catch:{ all -> 0x0036 }
            throw r7     // Catch:{ all -> 0x0036 }
        L_0x0087:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0036 }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x0036 }
            r7.<init>(r1)     // Catch:{ all -> 0x0036 }
            throw r7     // Catch:{ all -> 0x0036 }
        L_0x0091:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0036 }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x0036 }
            r7.<init>(r1)     // Catch:{ all -> 0x0036 }
            throw r7     // Catch:{ all -> 0x0036 }
        L_0x009b:
            boolean r7 = j()     // Catch:{ all -> 0x0036 }
            if (r7 == 0) goto L_0x00ac
            java.util.concurrent.atomic.AtomicBoolean r7 = f21641f     // Catch:{ all -> 0x0036 }
            boolean r7 = r7.get()     // Catch:{ all -> 0x0036 }
            if (r7 != 0) goto L_0x00ac
            e(r2)     // Catch:{ all -> 0x0036 }
        L_0x00ac:
            return
        L_0x00ad:
            v5.a.b(r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.b.m(android.app.Activity):void");
    }

    public static final void n(boolean z10) {
        Class<b> cls = b.class;
        if (!v5.a.d(cls)) {
            try {
                f21641f.set(z10);
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }
}
