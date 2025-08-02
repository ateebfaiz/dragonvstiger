package e2;

import android.os.Bundle;
import com.adjust.sdk.Constants;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.o;
import com.facebook.t;
import com.facebook.w;
import e2.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q5.d0;
import q5.r;
import q5.s;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21144a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f21145b = 100;

    /* renamed from: c  reason: collision with root package name */
    private static volatile d f21146c = new d();

    /* renamed from: d  reason: collision with root package name */
    private static final ScheduledExecutorService f21147d = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: e  reason: collision with root package name */
    private static ScheduledFuture f21148e;

    /* renamed from: f  reason: collision with root package name */
    private static final Runnable f21149f = d.f21158a;

    /* renamed from: g  reason: collision with root package name */
    public static final e f21150g = new e();

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f21151a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f21152b;

        a(a aVar, c cVar) {
            this.f21151a = aVar;
            this.f21152b = cVar;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    e eVar = e.f21150g;
                    e.a(eVar).a(this.f21151a, this.f21152b);
                    if (g.f21166c.c() != g.b.EXPLICIT_ONLY && e.a(eVar).d() > e.c(eVar)) {
                        e.l(j.EVENT_THRESHOLD);
                    } else if (e.d(eVar) == null) {
                        e.g(eVar, e.e(eVar).schedule(e.b(eVar), (long) 15, TimeUnit.SECONDS));
                    }
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static final class b implements GraphRequest.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f21153a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GraphRequest f21154b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ o f21155c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ l f21156d;

        b(a aVar, GraphRequest graphRequest, o oVar, l lVar) {
            this.f21153a = aVar;
            this.f21154b = graphRequest;
            this.f21155c = oVar;
            this.f21156d = lVar;
        }

        public final void a(t tVar) {
            m.f(tVar, "response");
            e.n(this.f21153a, this.f21154b, tVar, this.f21155c, this.f21156d);
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f21157a;

        c(j jVar) {
            this.f21157a = jVar;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    e.l(this.f21157a);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final d f21158a = new d();

        d() {
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    e.g(e.f21150g, (ScheduledFuture) null);
                    if (g.f21166c.c() != g.b.EXPLICIT_ONLY) {
                        e.l(j.TIMER);
                    }
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    /* renamed from: e2.e$e  reason: collision with other inner class name */
    static final class C0263e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f21159a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o f21160b;

        C0263e(a aVar, o oVar) {
            this.f21159a = aVar;
            this.f21160b = oVar;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    f.a(this.f21159a, this.f21160b);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final f f21161a = new f();

        f() {
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    e eVar = e.f21150g;
                    f.b(e.a(eVar));
                    e.f(eVar, new d());
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static {
        String name = e.class.getName();
        m.e(name, "AppEventQueue::class.java.name");
        f21144a = name;
    }

    private e() {
    }

    public static final /* synthetic */ d a(e eVar) {
        Class<e> cls = e.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f21146c;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Runnable b(e eVar) {
        Class<e> cls = e.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f21149f;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ int c(e eVar) {
        Class<e> cls = e.class;
        if (v5.a.d(cls)) {
            return 0;
        }
        try {
            return f21145b;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return 0;
        }
    }

    public static final /* synthetic */ ScheduledFuture d(e eVar) {
        Class<e> cls = e.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f21148e;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ ScheduledExecutorService e(e eVar) {
        Class<e> cls = e.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f21147d;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void f(e eVar, d dVar) {
        Class<e> cls = e.class;
        if (!v5.a.d(cls)) {
            try {
                f21146c = dVar;
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final /* synthetic */ void g(e eVar, ScheduledFuture scheduledFuture) {
        Class<e> cls = e.class;
        if (!v5.a.d(cls)) {
            try {
                f21148e = scheduledFuture;
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final void h(a aVar, c cVar) {
        Class<e> cls = e.class;
        if (!v5.a.d(cls)) {
            try {
                m.f(aVar, "accessTokenAppId");
                m.f(cVar, "appEvent");
                f21147d.execute(new a(aVar, cVar));
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final GraphRequest i(a aVar, o oVar, boolean z10, l lVar) {
        boolean z11 = false;
        Class<e> cls = e.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(aVar, "accessTokenAppId");
            m.f(oVar, "appEvents");
            m.f(lVar, "flushState");
            String b10 = aVar.b();
            r o10 = s.o(b10, false);
            GraphRequest.c cVar = GraphRequest.f19541t;
            b0 b0Var = b0.f709a;
            String format = String.format("%s/activities", Arrays.copyOf(new Object[]{b10}, 1));
            m.e(format, "java.lang.String.format(format, *args)");
            GraphRequest x10 = cVar.x((AccessToken) null, format, (JSONObject) null, (GraphRequest.b) null);
            x10.C(true);
            Bundle s10 = x10.s();
            if (s10 == null) {
                s10 = new Bundle();
            }
            s10.putString("access_token", aVar.a());
            String c10 = m.f21204b.c();
            if (c10 != null) {
                s10.putString("device_token", c10);
            }
            String i10 = h.f21178j.i();
            if (i10 != null) {
                s10.putString(Constants.INSTALL_REFERRER, i10);
            }
            x10.F(s10);
            if (o10 != null) {
                z11 = o10.o();
            }
            int e10 = oVar.e(x10, o.f(), z11, z10);
            if (e10 == 0) {
                return null;
            }
            lVar.c(lVar.a() + e10);
            x10.B(new b(aVar, x10, oVar, lVar));
            return x10;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final List j(d dVar, l lVar) {
        Class<e> cls = e.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(dVar, "appEventCollection");
            m.f(lVar, "flushResults");
            boolean u10 = o.u(o.f());
            ArrayList arrayList = new ArrayList();
            for (a aVar : dVar.f()) {
                o c10 = dVar.c(aVar);
                if (c10 != null) {
                    GraphRequest i10 = i(aVar, c10, u10, lVar);
                    if (i10 != null) {
                        arrayList.add(i10);
                    }
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
            return arrayList;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final void k(j jVar) {
        Class<e> cls = e.class;
        if (!v5.a.d(cls)) {
            try {
                m.f(jVar, "reason");
                f21147d.execute(new c(jVar));
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void l(e2.j r4) {
        /*
            java.lang.Class<e2.e> r0 = e2.e.class
            boolean r1 = v5.a.d(r0)
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r1 = "reason"
            kotlin.jvm.internal.m.f(r4, r1)     // Catch:{ all -> 0x0044 }
            e2.n r1 = e2.f.c()     // Catch:{ all -> 0x0044 }
            e2.d r2 = f21146c     // Catch:{ all -> 0x0044 }
            r2.b(r1)     // Catch:{ all -> 0x0044 }
            e2.d r1 = f21146c     // Catch:{ Exception -> 0x0047 }
            e2.l r4 = p(r4, r1)     // Catch:{ Exception -> 0x0047 }
            if (r4 == 0) goto L_0x0046
            android.content.Intent r1 = new android.content.Intent     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = "com.facebook.sdk.APP_EVENTS_FLUSHED"
            r1.<init>(r2)     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED"
            int r3 = r4.a()     // Catch:{ all -> 0x0044 }
            r1.putExtra(r2, r3)     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT"
            e2.k r4 = r4.b()     // Catch:{ all -> 0x0044 }
            r1.putExtra(r2, r4)     // Catch:{ all -> 0x0044 }
            android.content.Context r4 = com.facebook.o.f()     // Catch:{ all -> 0x0044 }
            androidx.localbroadcastmanager.content.LocalBroadcastManager r4 = androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(r4)     // Catch:{ all -> 0x0044 }
            r4.sendBroadcast(r1)     // Catch:{ all -> 0x0044 }
            goto L_0x0046
        L_0x0044:
            r4 = move-exception
            goto L_0x0050
        L_0x0046:
            return
        L_0x0047:
            r4 = move-exception
            java.lang.String r1 = f21144a     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = "Caught unexpected exception while flushing app events: "
            android.util.Log.w(r1, r2, r4)     // Catch:{ all -> 0x0044 }
            return
        L_0x0050:
            v5.a.b(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.e.l(e2.j):void");
    }

    public static final Set m() {
        Class<e> cls = e.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f21146c.f();
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final void n(a aVar, GraphRequest graphRequest, t tVar, o oVar, l lVar) {
        String str;
        a aVar2 = aVar;
        o oVar2 = oVar;
        l lVar2 = lVar;
        boolean z10 = true;
        Class<e> cls = e.class;
        if (!v5.a.d(cls)) {
            try {
                m.f(aVar2, "accessTokenAppId");
                m.f(graphRequest, "request");
                m.f(tVar, "response");
                m.f(oVar2, "appEvents");
                m.f(lVar2, "flushState");
                FacebookRequestError b10 = tVar.b();
                String str2 = "Success";
                k kVar = k.SUCCESS;
                if (b10 != null) {
                    if (b10.b() == -1) {
                        str2 = "Failed: No Connectivity";
                        kVar = k.NO_CONNECTIVITY;
                    } else {
                        b0 b0Var = b0.f709a;
                        str2 = String.format("Failed:\n  Response: %s\n  Error %s", Arrays.copyOf(new Object[]{tVar.toString(), b10.toString()}, 2));
                        m.e(str2, "java.lang.String.format(format, *args)");
                        kVar = k.SERVER_ERROR;
                    }
                }
                if (o.C(w.APP_EVENTS)) {
                    try {
                        str = new JSONArray((String) graphRequest.u()).toString(2);
                        m.e(str, "jsonArray.toString(2)");
                    } catch (JSONException unused) {
                        str = "<Can't encode events for debug logging>";
                    }
                    d0.f23283f.c(w.APP_EVENTS, f21144a, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", String.valueOf(graphRequest.o()), str2, str);
                }
                if (b10 == null) {
                    z10 = false;
                }
                oVar2.b(z10);
                k kVar2 = k.NO_CONNECTIVITY;
                if (kVar == kVar2) {
                    o.p().execute(new C0263e(aVar2, oVar2));
                }
                if (kVar != k.SUCCESS && lVar.b() != kVar2) {
                    lVar2.d(kVar);
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final void o() {
        Class<e> cls = e.class;
        if (!v5.a.d(cls)) {
            try {
                f21147d.execute(f.f21161a);
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final l p(j jVar, d dVar) {
        Class<e> cls = e.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(jVar, "reason");
            m.f(dVar, "appEventCollection");
            l lVar = new l();
            List<GraphRequest> j10 = j(dVar, lVar);
            if (!(!j10.isEmpty())) {
                return null;
            }
            d0.f23283f.c(w.APP_EVENTS, f21144a, "Flushing %d events due to %s.", Integer.valueOf(lVar.a()), jVar.toString());
            for (GraphRequest i10 : j10) {
                i10.i();
            }
            return lVar;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }
}
