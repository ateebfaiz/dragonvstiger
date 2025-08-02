package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import com.facebook.GraphRequest;
import com.facebook.Profile;
import e2.g;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.collections.r0;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import l2.c;
import org.json.JSONException;
import org.json.JSONObject;
import q5.c0;
import q5.i0;
import q5.n;
import q5.p0;
import q5.q0;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20672a = o.class.getCanonicalName();

    /* renamed from: b  reason: collision with root package name */
    private static final HashSet f20673b = r0.e(w.DEVELOPER_ERRORS);

    /* renamed from: c  reason: collision with root package name */
    private static Executor f20674c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static volatile String f20675d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile String f20676e;

    /* renamed from: f  reason: collision with root package name */
    private static volatile String f20677f;

    /* renamed from: g  reason: collision with root package name */
    private static volatile Boolean f20678g;

    /* renamed from: h  reason: collision with root package name */
    private static AtomicLong f20679h = new AtomicLong(65536);

    /* renamed from: i  reason: collision with root package name */
    private static volatile boolean f20680i;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f20681j;

    /* renamed from: k  reason: collision with root package name */
    private static c0 f20682k;

    /* renamed from: l  reason: collision with root package name */
    private static Context f20683l;

    /* renamed from: m  reason: collision with root package name */
    private static int f20684m = 64206;

    /* renamed from: n  reason: collision with root package name */
    private static final ReentrantLock f20685n = new ReentrantLock();

    /* renamed from: o  reason: collision with root package name */
    private static String f20686o = i0.a();

    /* renamed from: p  reason: collision with root package name */
    public static boolean f20687p;

    /* renamed from: q  reason: collision with root package name */
    public static boolean f20688q;

    /* renamed from: r  reason: collision with root package name */
    public static boolean f20689r;

    /* renamed from: s  reason: collision with root package name */
    private static final AtomicBoolean f20690s = new AtomicBoolean(false);

    /* renamed from: t  reason: collision with root package name */
    private static volatile String f20691t = "instagram.com";

    /* renamed from: u  reason: collision with root package name */
    private static volatile String f20692u = "facebook.com";

    /* renamed from: v  reason: collision with root package name */
    private static a f20693v = c.f20696a;

    /* renamed from: w  reason: collision with root package name */
    private static boolean f20694w;

    /* renamed from: x  reason: collision with root package name */
    public static final o f20695x = new o();

    public interface a {
        GraphRequest a(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.b bVar);
    }

    public interface b {
        void a();
    }

    static final class c implements a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f20696a = new c();

        c() {
        }

        public final GraphRequest a(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.b bVar) {
            return GraphRequest.f19541t.x(accessToken, str, jSONObject, bVar);
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f20697a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f20698b;

        d(Context context, String str) {
            this.f20697a = context;
            this.f20698b = str;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    o oVar = o.f20695x;
                    Context context = this.f20697a;
                    m.e(context, "applicationContext");
                    oVar.E(context, this.f20698b);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static final class e implements Callable {

        /* renamed from: a  reason: collision with root package name */
        public static final e f20699a = new e();

        e() {
        }

        /* renamed from: a */
        public final File call() {
            return o.a(o.f20695x).getCacheDir();
        }
    }

    static final class f implements n.a {

        /* renamed from: a  reason: collision with root package name */
        public static final f f20700a = new f();

        f() {
        }

        public final void a(boolean z10) {
            if (z10) {
                s5.e.a();
            }
        }
    }

    static final class g implements n.a {

        /* renamed from: a  reason: collision with root package name */
        public static final g f20701a = new g();

        g() {
        }

        public final void a(boolean z10) {
            if (z10) {
                e2.i.a();
            }
        }
    }

    static final class h implements n.a {

        /* renamed from: a  reason: collision with root package name */
        public static final h f20702a = new h();

        h() {
        }

        public final void a(boolean z10) {
            if (z10) {
                o.f20687p = true;
            }
        }
    }

    static final class i implements n.a {

        /* renamed from: a  reason: collision with root package name */
        public static final i f20703a = new i();

        i() {
        }

        public final void a(boolean z10) {
            if (z10) {
                o.f20688q = true;
            }
        }
    }

    static final class j implements n.a {

        /* renamed from: a  reason: collision with root package name */
        public static final j f20704a = new j();

        j() {
        }

        public final void a(boolean z10) {
            if (z10) {
                o.f20689r = true;
            }
        }
    }

    static final class k implements Callable {
        k(b bVar) {
        }

        /* renamed from: a */
        public final Void call() {
            c.f19600g.e().h();
            y.f20976e.a().d();
            if (AccessToken.N0.g()) {
                Profile.b bVar = Profile.f19571i;
                if (bVar.b() == null) {
                    bVar.a();
                }
            }
            g.a aVar = e2.g.f21166c;
            aVar.e(o.f(), o.f20675d);
            e0.m();
            Context applicationContext = o.f().getApplicationContext();
            m.e(applicationContext, "getApplicationContext().applicationContext");
            aVar.f(applicationContext).a();
            return null;
        }
    }

    private o() {
    }

    public static final boolean A() {
        return f20690s.get();
    }

    public static final boolean B() {
        return f20681j;
    }

    public static final boolean C(w wVar) {
        boolean z10;
        m.f(wVar, "behavior");
        HashSet hashSet = f20673b;
        synchronized (hashSet) {
            if (!x() || !hashSet.contains(wVar)) {
                z10 = false;
            } else {
                z10 = true;
            }
        }
        return z10;
    }

    public static final void D(Context context) {
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo.metaData != null) {
                    if (f20675d == null) {
                        Object obj = applicationInfo.metaData.get("com.facebook.sdk.ApplicationId");
                        if (obj instanceof String) {
                            String str = (String) obj;
                            Locale locale = Locale.ROOT;
                            m.e(locale, "Locale.ROOT");
                            String lowerCase = str.toLowerCase(locale);
                            m.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                            if (kotlin.text.j.F(lowerCase, "fb", false, 2, (Object) null)) {
                                String substring = str.substring(2);
                                m.e(substring, "(this as java.lang.String).substring(startIndex)");
                                f20675d = substring;
                            } else {
                                f20675d = str;
                            }
                        } else if (obj instanceof Number) {
                            throw new l("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                        }
                    }
                    if (f20676e == null) {
                        f20676e = applicationInfo.metaData.getString("com.facebook.sdk.ApplicationName");
                    }
                    if (f20677f == null) {
                        f20677f = applicationInfo.metaData.getString("com.facebook.sdk.ClientToken");
                    }
                    if (f20684m == 64206) {
                        f20684m = applicationInfo.metaData.getInt("com.facebook.sdk.CallbackOffset", 64206);
                    }
                    if (f20678g == null) {
                        f20678g = Boolean.valueOf(applicationInfo.metaData.getBoolean("com.facebook.sdk.CodelessDebugLogEnabled", false));
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public final void E(Context context, String str) {
        if (!v5.a.d(this)) {
            try {
                q5.b e10 = q5.b.f23250h.e(context);
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
                String str2 = str + "ping";
                long j10 = sharedPreferences.getLong(str2, 0);
                JSONObject a10 = l2.c.a(c.a.MOBILE_INSTALL_EVENT, e10, e2.g.f21166c.b(context), u(context), context);
                b0 b0Var = b0.f709a;
                String format = String.format("%s/activities", Arrays.copyOf(new Object[]{str}, 1));
                m.e(format, "java.lang.String.format(format, *args)");
                GraphRequest a11 = f20693v.a((AccessToken) null, format, a10, (GraphRequest.b) null);
                if (j10 == 0 && a11.i().b() == null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putLong(str2, System.currentTimeMillis());
                    edit.apply();
                }
            } catch (JSONException e11) {
                throw new l("An error occurred while publishing install.", (Throwable) e11);
            } catch (Exception e12) {
                p0.e0("Facebook-publish", e12);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public static final void F(Context context, String str) {
        Class<o> cls = o.class;
        if (!v5.a.d(cls)) {
            try {
                m.f(context, "context");
                m.f(str, "applicationId");
                p().execute(new d(context.getApplicationContext(), str));
                if (n.g(n.b.OnDeviceEventProcessing) && n2.a.b()) {
                    n2.a.d(str, "com.facebook.sdk.attributionTracking");
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final synchronized void G(Context context) {
        synchronized (o.class) {
            m.f(context, "applicationContext");
            H(context, (b) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized void H(android.content.Context r4, com.facebook.o.b r5) {
        /*
            java.lang.Class<com.facebook.o> r0 = com.facebook.o.class
            monitor-enter(r0)
            java.lang.String r1 = "applicationContext"
            kotlin.jvm.internal.m.f(r4, r1)     // Catch:{ all -> 0x0016 }
            java.util.concurrent.atomic.AtomicBoolean r1 = f20690s     // Catch:{ all -> 0x0016 }
            boolean r2 = r1.get()     // Catch:{ all -> 0x0016 }
            if (r2 == 0) goto L_0x001b
            if (r5 == 0) goto L_0x0019
            r5.a()     // Catch:{ all -> 0x0016 }
            goto L_0x0019
        L_0x0016:
            r4 = move-exception
            goto L_0x00dc
        L_0x0019:
            monitor-exit(r0)
            return
        L_0x001b:
            r2 = 0
            q5.q0.g(r4, r2)     // Catch:{ all -> 0x0016 }
            q5.q0.i(r4, r2)     // Catch:{ all -> 0x0016 }
            android.content.Context r2 = r4.getApplicationContext()     // Catch:{ all -> 0x0016 }
            java.lang.String r3 = "applicationContext.applicationContext"
            kotlin.jvm.internal.m.e(r2, r3)     // Catch:{ all -> 0x0016 }
            f20683l = r2     // Catch:{ all -> 0x0016 }
            e2.g$a r2 = e2.g.f21166c     // Catch:{ all -> 0x0016 }
            r2.b(r4)     // Catch:{ all -> 0x0016 }
            android.content.Context r4 = f20683l     // Catch:{ all -> 0x0016 }
            if (r4 != 0) goto L_0x003b
            java.lang.String r2 = "applicationContext"
            kotlin.jvm.internal.m.u(r2)     // Catch:{ all -> 0x0016 }
        L_0x003b:
            D(r4)     // Catch:{ all -> 0x0016 }
            java.lang.String r4 = f20675d     // Catch:{ all -> 0x0016 }
            boolean r4 = q5.p0.Y(r4)     // Catch:{ all -> 0x0016 }
            if (r4 != 0) goto L_0x00d4
            r4 = 1
            r1.set(r4)     // Catch:{ all -> 0x0016 }
            boolean r4 = j()     // Catch:{ all -> 0x0016 }
            if (r4 == 0) goto L_0x0053
            d()     // Catch:{ all -> 0x0016 }
        L_0x0053:
            android.content.Context r4 = f20683l     // Catch:{ all -> 0x0016 }
            if (r4 != 0) goto L_0x005c
            java.lang.String r1 = "applicationContext"
            kotlin.jvm.internal.m.u(r1)     // Catch:{ all -> 0x0016 }
        L_0x005c:
            boolean r4 = r4 instanceof android.app.Application     // Catch:{ all -> 0x0016 }
            if (r4 == 0) goto L_0x0081
            boolean r4 = com.facebook.e0.g()     // Catch:{ all -> 0x0016 }
            if (r4 == 0) goto L_0x0081
            android.content.Context r4 = f20683l     // Catch:{ all -> 0x0016 }
            if (r4 != 0) goto L_0x006f
            java.lang.String r1 = "applicationContext"
            kotlin.jvm.internal.m.u(r1)     // Catch:{ all -> 0x0016 }
        L_0x006f:
            if (r4 == 0) goto L_0x0079
            android.app.Application r4 = (android.app.Application) r4     // Catch:{ all -> 0x0016 }
            java.lang.String r1 = f20675d     // Catch:{ all -> 0x0016 }
            l2.a.x(r4, r1)     // Catch:{ all -> 0x0016 }
            goto L_0x0081
        L_0x0079:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException     // Catch:{ all -> 0x0016 }
            java.lang.String r5 = "null cannot be cast to non-null type android.app.Application"
            r4.<init>(r5)     // Catch:{ all -> 0x0016 }
            throw r4     // Catch:{ all -> 0x0016 }
        L_0x0081:
            q5.s.k()     // Catch:{ all -> 0x0016 }
            q5.f0.G()     // Catch:{ all -> 0x0016 }
            com.facebook.internal.BoltsMeasurementEventListener$a r4 = com.facebook.internal.BoltsMeasurementEventListener.f20334d     // Catch:{ all -> 0x0016 }
            android.content.Context r1 = f20683l     // Catch:{ all -> 0x0016 }
            if (r1 != 0) goto L_0x0092
            java.lang.String r2 = "applicationContext"
            kotlin.jvm.internal.m.u(r2)     // Catch:{ all -> 0x0016 }
        L_0x0092:
            r4.a(r1)     // Catch:{ all -> 0x0016 }
            q5.c0 r4 = new q5.c0     // Catch:{ all -> 0x0016 }
            com.facebook.o$e r1 = com.facebook.o.e.f20699a     // Catch:{ all -> 0x0016 }
            r4.<init>(r1)     // Catch:{ all -> 0x0016 }
            f20682k = r4     // Catch:{ all -> 0x0016 }
            q5.n$b r4 = q5.n.b.Instrument     // Catch:{ all -> 0x0016 }
            com.facebook.o$f r1 = com.facebook.o.f.f20700a     // Catch:{ all -> 0x0016 }
            q5.n.a(r4, r1)     // Catch:{ all -> 0x0016 }
            q5.n$b r4 = q5.n.b.AppEvents     // Catch:{ all -> 0x0016 }
            com.facebook.o$g r1 = com.facebook.o.g.f20701a     // Catch:{ all -> 0x0016 }
            q5.n.a(r4, r1)     // Catch:{ all -> 0x0016 }
            q5.n$b r4 = q5.n.b.ChromeCustomTabsPrefetching     // Catch:{ all -> 0x0016 }
            com.facebook.o$h r1 = com.facebook.o.h.f20702a     // Catch:{ all -> 0x0016 }
            q5.n.a(r4, r1)     // Catch:{ all -> 0x0016 }
            q5.n$b r4 = q5.n.b.IgnoreAppSwitchToLoggedOut     // Catch:{ all -> 0x0016 }
            com.facebook.o$i r1 = com.facebook.o.i.f20703a     // Catch:{ all -> 0x0016 }
            q5.n.a(r4, r1)     // Catch:{ all -> 0x0016 }
            q5.n$b r4 = q5.n.b.BypassAppSwitch     // Catch:{ all -> 0x0016 }
            com.facebook.o$j r1 = com.facebook.o.j.f20704a     // Catch:{ all -> 0x0016 }
            q5.n.a(r4, r1)     // Catch:{ all -> 0x0016 }
            java.util.concurrent.FutureTask r4 = new java.util.concurrent.FutureTask     // Catch:{ all -> 0x0016 }
            com.facebook.o$k r1 = new com.facebook.o$k     // Catch:{ all -> 0x0016 }
            r1.<init>(r5)     // Catch:{ all -> 0x0016 }
            r4.<init>(r1)     // Catch:{ all -> 0x0016 }
            java.util.concurrent.Executor r5 = p()     // Catch:{ all -> 0x0016 }
            r5.execute(r4)     // Catch:{ all -> 0x0016 }
            monitor-exit(r0)
            return
        L_0x00d4:
            com.facebook.l r4 = new com.facebook.l     // Catch:{ all -> 0x0016 }
            java.lang.String r5 = "A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk."
            r4.<init>((java.lang.String) r5)     // Catch:{ all -> 0x0016 }
            throw r4     // Catch:{ all -> 0x0016 }
        L_0x00dc:
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.o.H(android.content.Context, com.facebook.o$b):void");
    }

    public static final /* synthetic */ Context a(o oVar) {
        Context context = f20683l;
        if (context == null) {
            m.u("applicationContext");
        }
        return context;
    }

    public static final void d() {
        f20694w = true;
    }

    public static final boolean e() {
        return e0.e();
    }

    public static final Context f() {
        q0.o();
        Context context = f20683l;
        if (context == null) {
            m.u("applicationContext");
        }
        return context;
    }

    public static final String g() {
        q0.o();
        String str = f20675d;
        if (str != null) {
            return str;
        }
        throw new l("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
    }

    public static final String h() {
        q0.o();
        return f20676e;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String i(android.content.Context r4) {
        /*
            java.lang.Class<com.facebook.o> r0 = com.facebook.o.class
            boolean r1 = v5.a.d(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            q5.q0.o()     // Catch:{ all -> 0x0045 }
            if (r4 != 0) goto L_0x0010
            return r2
        L_0x0010:
            android.content.pm.PackageManager r1 = r4.getPackageManager()     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0047
            java.lang.String r4 = r4.getPackageName()     // Catch:{ all -> 0x0045 }
            r3 = 64
            android.content.pm.PackageInfo r4 = r1.getPackageInfo(r4, r3)     // Catch:{ NameNotFoundException -> 0x0047 }
            android.content.pm.Signature[] r1 = r4.signatures     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0047
            int r1 = r1.length     // Catch:{ all -> 0x0045 }
            if (r1 != 0) goto L_0x0028
            goto L_0x0047
        L_0x0028:
            java.lang.String r1 = "SHA-1"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{  }
            android.content.pm.Signature[] r4 = r4.signatures     // Catch:{ all -> 0x0045 }
            r3 = 0
            r4 = r4[r3]     // Catch:{ all -> 0x0045 }
            byte[] r4 = r4.toByteArray()     // Catch:{ all -> 0x0045 }
            r1.update(r4)     // Catch:{ all -> 0x0045 }
            byte[] r4 = r1.digest()     // Catch:{ all -> 0x0045 }
            r1 = 9
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r1)     // Catch:{ all -> 0x0045 }
            return r4
        L_0x0045:
            r4 = move-exception
            goto L_0x0048
        L_0x0047:
            return r2
        L_0x0048:
            v5.a.b(r4, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.o.i(android.content.Context):java.lang.String");
    }

    public static final boolean j() {
        return e0.f();
    }

    public static final boolean k() {
        return e0.g();
    }

    public static final File l() {
        q0.o();
        c0 c0Var = f20682k;
        if (c0Var == null) {
            m.u("cacheDir");
        }
        return (File) c0Var.c();
    }

    public static final int m() {
        q0.o();
        return f20684m;
    }

    public static final String n() {
        q0.o();
        return f20677f;
    }

    public static final boolean o() {
        return e0.h();
    }

    public static final Executor p() {
        ReentrantLock reentrantLock = f20685n;
        reentrantLock.lock();
        try {
            if (f20674c == null) {
                f20674c = AsyncTask.THREAD_POOL_EXECUTOR;
            }
            Unit unit = Unit.f12577a;
            reentrantLock.unlock();
            Executor executor = f20674c;
            if (executor != null) {
                return executor;
            }
            throw new IllegalStateException("Required value was null.".toString());
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static final String q() {
        return f20692u;
    }

    public static final String r() {
        String str = f20672a;
        b0 b0Var = b0.f709a;
        String format = String.format("getGraphApiVersion: %s", Arrays.copyOf(new Object[]{f20686o}, 1));
        m.e(format, "java.lang.String.format(format, *args)");
        p0.f0(str, format);
        return f20686o;
    }

    public static final String s() {
        String str;
        AccessToken e10 = AccessToken.N0.e();
        if (e10 != null) {
            str = e10.i();
        } else {
            str = null;
        }
        return p0.B(str);
    }

    public static final String t() {
        return f20691t;
    }

    public static final boolean u(Context context) {
        m.f(context, "context");
        q0.o();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    public static final long v() {
        q0.o();
        return f20679h.get();
    }

    public static final String w() {
        return "12.3.0";
    }

    public static final boolean x() {
        return f20680i;
    }

    public static final boolean y(int i10) {
        int i11 = f20684m;
        if (i10 < i11 || i10 >= i11 + 100) {
            return false;
        }
        return true;
    }

    public static final synchronized boolean z() {
        boolean z10;
        synchronized (o.class) {
            z10 = f20694w;
        }
        return z10;
    }
}
