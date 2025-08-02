package x;

import OooO0o0.OooO0Oo;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import b.b;
import com.mah.ndk.MahxServer;
import com.mah.ndk.OooO0O0;
import com.mah.sdk.MahProxy;
import com.mah.sdk.MahProxyAddress;
import com.mah.sdk.OooO00o;
import d.c;
import d.h;
import d.k;
import e.i;
import e.j;
import e.n;
import g.m;
import h.g;
import i.u;
import i.v;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import k.a;
import org.json.JSONObject;
import q.a;
import s.e;
import v.b;
import w.d;
import x.i;

public class f implements k, b, i.b {

    /* renamed from: x  reason: collision with root package name */
    public static final String f24630x = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final Context f24631a;

    /* renamed from: b  reason: collision with root package name */
    public final MahxServer f24632b;

    /* renamed from: c  reason: collision with root package name */
    public final m f24633c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference f24634d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f24635e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f24636f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f24637g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24638h;

    /* renamed from: i  reason: collision with root package name */
    public OooO0O0 f24639i;

    /* renamed from: j  reason: collision with root package name */
    public OooO0Oo f24640j;

    /* renamed from: k  reason: collision with root package name */
    public j.b f24641k;

    /* renamed from: l  reason: collision with root package name */
    public v.b f24642l;

    /* renamed from: m  reason: collision with root package name */
    public final AtomicInteger f24643m;

    /* renamed from: n  reason: collision with root package name */
    public String f24644n;

    /* renamed from: o  reason: collision with root package name */
    public e.m f24645o;

    /* renamed from: p  reason: collision with root package name */
    public l f24646p;

    /* renamed from: q  reason: collision with root package name */
    public final int f24647q;

    /* renamed from: r  reason: collision with root package name */
    public c f24648r;

    /* renamed from: s  reason: collision with root package name */
    public final k f24649s;

    /* renamed from: t  reason: collision with root package name */
    public final long f24650t = System.currentTimeMillis();

    /* renamed from: u  reason: collision with root package name */
    public final i f24651u;

    /* renamed from: v  reason: collision with root package name */
    public OooOo.b f24652v;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f24653w;

    public static class a extends j.c {

        /* renamed from: a  reason: collision with root package name */
        public final long f24654a;

        public a(long j10) {
            this.f24654a = j10;
        }

        public long a() {
            return this.f24654a;
        }

        public long b() {
            return this.f24654a;
        }

        public void c() {
            e.i.n().e(i.a.AUTH_TIMER);
        }
    }

    public f(Context context, boolean z10, k kVar) {
        Context b10 = v.b(context);
        this.f24631a = b10;
        this.f24635e = z10;
        this.f24634d = new AtomicReference();
        m a10 = m.a(b10);
        this.f24633c = a10;
        this.f24632b = new MahxServer(this);
        this.f24636f = false;
        this.f24637g = new AtomicBoolean(false);
        this.f24647q = OooO00o.OooO00o(context, a10);
        this.f24644n = "";
        this.f24649s = kVar;
        this.f24651u = new i(this);
        this.f24643m = new AtomicInteger(0);
        this.f24653w = E(a10);
    }

    public static boolean D(long j10, long j11, int i10) {
        long j12 = j11 - j10;
        if (i10 > 0 && j12 > ((long) i10)) {
            return true;
        }
        return false;
    }

    public static boolean E(m mVar) {
        boolean n10 = mVar.n();
        boolean i10 = mVar.i();
        if (n10) {
            mVar.l(false);
        }
        if (i10) {
            mVar.f(false);
        }
        if (n10 || i10) {
            return true;
        }
        return false;
    }

    public static void L(g gVar) {
        boolean z10 = gVar.b(2).f21743e;
        boolean z11 = gVar.b(3).f21743e;
        boolean z12 = gVar.b(4).f21743e;
        boolean z13 = gVar.b(5).f21743e;
        boolean z14 = gVar.b(6).f21743e;
        gVar.d();
    }

    public static String Q(int i10) {
        if (i10 == 0) {
            return "client";
        }
        if (i10 == 1) {
            return "service start fail";
        }
        if (i10 == 2) {
            return "prior auth config parse error";
        }
        if (i10 == 3) {
            return "close sdk";
        }
        if (i10 != 4) {
            return "unknown";
        }
        return "prior auth fail";
    }

    public static String z(String str, String str2) {
        return str + str2;
    }

    public final void A(g gVar, String str) {
        if (this.f24646p.a(gVar)) {
            OooO0o0.OooO0O0 f10 = this.f24646p.f();
            if (d.j()) {
                OooO00o.OooO00o(f10, "service-updateSharedConfig-" + str);
            }
            this.f24649s.b(f10);
        }
    }

    public final void B(g gVar, JSONObject jSONObject, boolean z10) {
        if (z10) {
            if (d.j()) {
                z(f().a(), gVar.f21776b);
            }
            if (u()) {
                this.f24645o.a(jSONObject);
            }
        }
        boolean F = F(gVar);
        e0();
        if (!F || u()) {
            b0();
        }
    }

    public final boolean F(g gVar) {
        if (gVar.f21785k) {
            return this.f24642l.p(0);
        }
        this.f24642l.o();
        return false;
    }

    public final boolean G(JSONObject jSONObject) {
        String d10 = j.d(jSONObject);
        String str = o().f21776b;
        if (TextUtils.isEmpty(d10)) {
            return true;
        }
        return !d10.equalsIgnoreCase(str);
    }

    public final void H(g gVar) {
        A(gVar, "load");
        this.f24648r.g(gVar.d());
        this.f24648r.j().d(gVar.B);
        if (!gVar.f21781g) {
            this.f24651u.e(g.BYPASS_SDK_DISABLED, false);
        }
    }

    public final void I(g gVar, JSONObject jSONObject, boolean z10) {
        boolean z11;
        A(gVar, "auth");
        g b10 = this.f24651u.b();
        g gVar2 = g.BYPASS_SDK_DISABLED;
        if (b10 == gVar2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (gVar.f21781g) {
            this.f24651u.k();
            OooO00o.OooO0OO((k) this);
        } else {
            OooO00o.OooO0O0((k) this);
            d.k(f24630x, "SDK terminated");
        }
        if (z10) {
            R(gVar);
        }
        if (this.f24632b.OooOO0()) {
            if (!this.f24640j.f13478j) {
                d0();
                if (gVar.f21781g) {
                    B(gVar, jSONObject, z10);
                    if (z11) {
                        this.f24651u.i();
                        return;
                    }
                    return;
                }
                this.f24651u.g(gVar2);
                if (u() && z10) {
                    this.f24645o.a(jSONObject);
                }
            } else if (gVar.f21781g) {
                this.f24651u.j();
                B(gVar, jSONObject, z10);
            } else {
                this.f24651u.g(gVar2);
                if (u() && z10) {
                    this.f24645o.a(jSONObject);
                }
            }
        } else if (this.f24636f) {
            M(gVar, jSONObject, z10);
        }
    }

    public final /* synthetic */ void J(String str) {
        b.C0346b bVar;
        if (o().f21785k) {
            bVar = this.f24642l.a(str);
        } else {
            bVar = this.f24642l.z(str);
        }
        MahxServer.OooO00o(bVar.f24370a, bVar.f24371b, bVar.f24372c);
        bVar.a();
    }

    public final /* synthetic */ void K(e eVar, boolean z10) {
        u.b(new d(this, eVar, z10));
    }

    public final void M(g gVar, JSONObject jSONObject, boolean z10) {
        this.f24633c.f(false);
        this.f24633c.l(false);
        if (!gVar.f21781g) {
            if (z10) {
                this.f24645o.a(jSONObject);
            }
            S(3);
            return;
        }
        try {
            F(gVar);
            q.a.a("auth", n().f13475g, System.currentTimeMillis());
            c0();
            this.f24645o.a(jSONObject);
            b0();
            d0();
            e0();
        } catch (h e10) {
            e10.getMessage();
        } catch (Exception e11) {
            o.g.a().b(e11);
        }
    }

    public final /* synthetic */ void N(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f24633c.k(str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0044, code lost:
        return;
     */
    /* renamed from: O */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void C(s.e r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f24637g     // Catch:{ all -> 0x0036 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)
            return
        L_0x000b:
            r2.a()     // Catch:{ all -> 0x0036 }
            com.mah.ndk.MahxServer r0 = r1.f24632b     // Catch:{ all -> 0x0036 }
            boolean r0 = r0.OooOO0()     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x0043
            boolean r2 = r2.h()     // Catch:{ all -> 0x0036 }
            if (r2 == 0) goto L_0x0043
            if (r3 == 0) goto L_0x0043
            h.g r2 = r1.o()     // Catch:{ all -> 0x0036 }
            OooO0o0.OooO0Oo r3 = r1.f24640j     // Catch:{ all -> 0x0036 }
            boolean r3 = r3.f13478j     // Catch:{ all -> 0x0036 }
            if (r3 != 0) goto L_0x0038
            boolean r3 = r2.f21782h     // Catch:{ all -> 0x0036 }
            if (r3 == 0) goto L_0x0038
            e.i r2 = e.i.n()     // Catch:{ all -> 0x0036 }
            e.i$a r3 = e.i.a.AUTH_NETWORK_CHANGE     // Catch:{ all -> 0x0036 }
            r2.e(r3)     // Catch:{ all -> 0x0036 }
            goto L_0x0043
        L_0x0036:
            r2 = move-exception
            goto L_0x0045
        L_0x0038:
            boolean r2 = r2.f21785k     // Catch:{ all -> 0x0036 }
            if (r2 == 0) goto L_0x0040
            r1.a0()     // Catch:{ all -> 0x0036 }
            goto L_0x0043
        L_0x0040:
            r1.Y()     // Catch:{ all -> 0x0036 }
        L_0x0043:
            monitor-exit(r1)
            return
        L_0x0045:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: x.f.C(s.e, boolean):void");
    }

    public Context OooO00o() {
        return this.f24631a;
    }

    public final void P(String str) {
        this.f24644n = z(f().a(), o().f21776b);
    }

    public final void R(g gVar) {
        this.f24648r.g(gVar.d());
        this.f24648r.j().d(gVar.B);
        k.a.f().q();
    }

    public synchronized void S(int i10) {
        if (!this.f24637g.get()) {
            this.f24637g.set(true);
            d.l(f24630x, "stopping: %s", Q(i10));
            this.f24651u.g(g.BYPASS_STOP);
            OooOo.b bVar = this.f24652v;
            if (bVar != null) {
                bVar.h();
            }
            try {
                this.f24632b.OooOOO0();
            } catch (i.i e10) {
                o.g.a().b(e10);
            }
            j.a.a().e();
            o.g.d(o.g.f22872a);
        }
    }

    public final void T() {
        OooOo.b bVar = new OooOo.b(this.f24631a);
        this.f24652v = bVar;
        bVar.c(new c(this));
    }

    public final void U() {
        r.f.c().e(this.f24631a, this.f24648r);
        e.i.n().d(this, this.f24648r);
        this.f24642l = new v.b(this, this.f24648r);
        this.f24646p = this.f24648r.a();
        this.f24645o = new n(OooO00o.OooO0O0(this.f24631a), "com.mah.use_config.json", OooO00o.OooO0O0(v.a(this.f24631a), "use"));
        this.f24634d.set(W());
        H(o());
        T();
        o.g.d(new o.f(this.f24631a, n().f13469a, this, true, this.f24648r));
        k.a.f().b(this, this.f24648r);
        q.a.a("sdk", n().f13475g, System.currentTimeMillis());
    }

    public final boolean V() {
        return o().b(f().f()).f21743e;
    }

    public final g W() {
        g gVar;
        JSONObject OooO00o = this.f24645o.OooO00o();
        if (OooO00o != null) {
            OooO00o.toString();
        }
        if (OooO00o != null) {
            gVar = g.a(OooO00o);
        } else {
            gVar = null;
        }
        if (gVar == null) {
            gVar = new g(new g.a());
            if (d.j()) {
                L(gVar);
            }
        }
        OooO00o.OooO0O0(gVar);
        return gVar;
    }

    public final /* synthetic */ void X() {
        this.f24642l.p(2);
        Y();
    }

    public final void Y() {
        try {
            if (this.f24632b.OooOO0O()) {
                P("network change update setting");
            }
        } catch (i.i e10) {
            o.g.a().b(e10);
        }
    }

    public final void Z() {
        if (o().f21781g) {
            this.f24651u.j();
        } else {
            this.f24651u.g(g.BYPASS_SDK_DISABLED);
        }
    }

    public void a(int i10) {
        if (this.f24637g.get()) {
            this.f24638h = false;
        }
        this.f24651u.g(g.BYPASS_PROXY_EXIT);
        if (i10 == 1) {
            q.f.f().h(new h("Invalid localhost", -11));
        } else if (i10 == 2) {
            q.f f10 = q.f.f();
            f10.h(new h("Port bind failed, code=" + i10, -20));
        }
    }

    public final void a0() {
        j.a.a().c(new e(this), 0);
    }

    public void b(String str) {
        u.b(new a(this, str));
    }

    public final void b0() {
        k.a.f().a();
        a.C0295a.f22232a.n();
    }

    public void c(int i10) {
        this.f24643m.set(i10);
    }

    public final void c0() {
        int i10;
        OooO0O0 oooO0O0 = new OooO0O0(this.f24631a, this.f24648r, this);
        this.f24639i = oooO0O0;
        if (this.f24640j.f13471c) {
            i10 = this.f24632b.OooO00o(oooO0O0);
        } else {
            i10 = this.f24632b.OooO0O0(oooO0O0);
        }
        if (i10 == 0) {
            P("start success");
            k.a.f().j();
            s();
            return;
        }
        S(1);
        throw OooO00o.OooO00o(i10);
    }

    public void d(String[] strArr) {
        if (d.j()) {
            for (String str : strArr) {
            }
        }
        try {
            this.f24632b.OooO00o(strArr);
        } catch (i.i e10) {
            o.g.a().b(e10);
        }
    }

    public final void d0() {
        try {
            long j10 = ((long) o().f21788n) * 60000;
            j.b bVar = this.f24641k;
            if (bVar != null) {
                if (j10 != ((a) bVar.b()).b()) {
                    this.f24641k.a();
                } else {
                    return;
                }
            }
            this.f24641k = j.a.a().b(new a(j10));
        } catch (Throwable th) {
            o.g.a().b(th);
        }
    }

    public int e() {
        return this.f24647q;
    }

    public final void e0() {
        h.d dVar = o().F;
        if (h.c.f(dVar)) {
            try {
                t.a a10 = t.a.a(this, this.f24648r);
                a10.e();
                a10.b(dVar);
            } catch (Throwable th) {
                o.g.a().b(th);
            }
        }
    }

    public e f() {
        e f10 = this.f24652v.f();
        if (f10 == null) {
            return e.c(this.f24631a);
        }
        return f10;
    }

    public boolean g() {
        return s.k.b(this.f24631a);
    }

    public MahProxyAddress h(d.b bVar) {
        return this.f24651u.f(bVar);
    }

    public void i(MahProxyAddress mahProxyAddress, MahProxyAddress mahProxyAddress2, MahProxyAddress mahProxyAddress3, MahProxy.ProxyChangedReason proxyChangedReason) {
        this.f24649s.i(mahProxyAddress, mahProxyAddress2, mahProxyAddress3, proxyChangedReason);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0039 A[Catch:{ all -> 0x0017 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003d A[Catch:{ all -> 0x0017 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void j(e.i.a r3, org.json.JSONObject r4, java.lang.String r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.concurrent.atomic.AtomicBoolean r3 = r2.f24637g     // Catch:{ all -> 0x0017 }
            boolean r3 = r3.get()     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x000b
            monitor-exit(r2)
            return
        L_0x000b:
            boolean r3 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0017 }
            if (r3 != 0) goto L_0x0019
            g.m r3 = r2.f24633c     // Catch:{ all -> 0x0017 }
            r3.k(r5)     // Catch:{ all -> 0x0017 }
            goto L_0x0019
        L_0x0017:
            r3 = move-exception
            goto L_0x0045
        L_0x0019:
            com.mah.sdk.OooO00o.OooO00o((d.k) r2)     // Catch:{ all -> 0x0017 }
            boolean r3 = r2.G(r4)     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0030
            h.g r5 = h.g.a(r4)     // Catch:{ all -> 0x0017 }
            if (r5 == 0) goto L_0x002e
            java.util.concurrent.atomic.AtomicReference r0 = r2.f24634d     // Catch:{ all -> 0x0017 }
            r0.set(r5)     // Catch:{ all -> 0x0017 }
            goto L_0x0030
        L_0x002e:
            r5 = 1
            goto L_0x0031
        L_0x0030:
            r5 = 0
        L_0x0031:
            h.g r0 = r2.o()     // Catch:{ all -> 0x0017 }
            boolean r1 = r0.f21781g     // Catch:{ all -> 0x0017 }
            if (r5 == 0) goto L_0x003d
            r2.x()     // Catch:{ all -> 0x0017 }
            goto L_0x0040
        L_0x003d:
            r2.I(r0, r4, r3)     // Catch:{ all -> 0x0017 }
        L_0x0040:
            r2.s()     // Catch:{ all -> 0x0017 }
            monitor-exit(r2)
            return
        L_0x0045:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: x.f.j(e.i$a, org.json.JSONObject, java.lang.String):void");
    }

    public v.a k(int i10) {
        if (!o().f21785k) {
            return null;
        }
        return this.f24642l.g(i10);
    }

    public void l() {
        if (this.f24640j.f13478j) {
            Z();
        }
    }

    public boolean m() {
        return this.f24635e;
    }

    public OooO0Oo n() {
        return this.f24640j;
    }

    public g o() {
        return (g) this.f24634d.get();
    }

    public void p(int i10) {
        if (this.f24637g.get()) {
            this.f24638h = false;
        }
        this.f24651u.g(g.BYPASS_PROXY_EXIT);
    }

    public boolean q() {
        return this.f24653w;
    }

    public m r() {
        return this.f24633c;
    }

    public boolean s() {
        if (!this.f24651u.h() && !V()) {
            return false;
        }
        return true;
    }

    public void t() {
        this.f24633c.f(true);
        this.f24651u.g(g.BYPASS_NDK_CRASHED);
    }

    public boolean u() {
        try {
            boolean OooOO0o = this.f24632b.OooOO0o();
            if (!OooOO0o) {
                return OooOO0o;
            }
            P("auth update setting");
            return OooOO0o;
        } catch (i.i e10) {
            o.g.a().b(e10);
            return false;
        }
    }

    public synchronized void v(i.a aVar, String str, int i10) {
        try {
            String str2 = f24630x;
            OooO00o.OooO0O0((k) this, str);
            if (!this.f24637g.get()) {
                if (this.f24632b.OooOO0()) {
                    if (this.f24640j.f13478j) {
                        if (i10 == 2) {
                            d.i(str2, "Auth failure: %s", str);
                            this.f24651u.g(g.BYPASS_AUTH_FAILED);
                            u();
                        } else {
                            Z();
                        }
                        OooO00o.OooO0OO((k) this);
                        return;
                    }
                    d0();
                    if (i10 == 2) {
                        d.i(str2, "Auth failure: %s", str);
                        this.f24651u.g(g.BYPASS_AUTH_FAILED);
                        u();
                    }
                    OooO00o.OooO0OO((k) this);
                } else if (this.f24636f) {
                    OooO00o.OooO00o((k) this, "SDK terminated");
                    S(4);
                }
                s();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void w(int i10, int i11, int i12, String str, long j10) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f24633c.c(currentTimeMillis - this.f24640j.f13475g);
        MahProxyAddress mahProxyAddress = new MahProxyAddress(str, i10, true);
        MahProxyAddress mahProxyAddress2 = new MahProxyAddress(str, i11, true);
        this.f24651u.d(new MahProxyAddress(str, i12, false), mahProxyAddress2, mahProxyAddress, !this.f24640j.f13478j);
        if (D(j10, currentTimeMillis, o().R)) {
            k.a.f().l();
        }
        q.a.a("ndk", j10, currentTimeMillis);
        long j11 = this.f24640j.f13475g;
        CopyOnWriteArrayList copyOnWriteArrayList = q.a.f23132a;
        copyOnWriteArrayList.add(new a.C0320a("mah", j11, currentTimeMillis));
        q.f.f().j(this.f24636f, this.f24640j.f13473e, copyOnWriteArrayList);
    }

    public final void x() {
        if (this.f24632b.OooOO0()) {
            if (this.f24640j.f13478j) {
                Z();
            } else {
                d0();
            }
            e0();
            b0();
        } else if (this.f24636f) {
            S(2);
        }
    }

    public synchronized int y(OooO0Oo oooO0Oo) {
        if (this.f24638h) {
            return 0;
        }
        this.f24640j = oooO0Oo;
        SharedPreferences OooO0o02 = OooO00o.OooO0o0(this.f24631a);
        String string = OooO0o02.getString("lastLaunchId", "");
        OooO0o02.edit().putString("lastLaunchId", oooO0Oo.f13477i).apply();
        i.e eVar = new i.e(oooO0Oo.f13475g, oooO0Oo.f13477i, string);
        String s10 = v.s(this.f24631a);
        c cVar = new c(this.f24631a, v.a(this.f24631a), s10, eVar);
        this.f24648r = cVar;
        cVar.e(OooO00o.OooO0O0(this.f24631a, oooO0Oo.f13474f));
        this.f24648r.c(this);
        this.f24648r.d(new b(this));
        q.f f10 = q.f.f();
        f10.c(this.f24631a, this.f24648r);
        try {
            q.a.a("remoteService", oooO0Oo.f13475g, this.f24650t);
            U();
            c0();
            b0();
            if (OooO00o.OooO00o(o().f21786l, e.i.n().t())) {
                i.b.f21078a.e(i.a.AUTH_START);
            }
            this.f24638h = true;
            boolean z10 = this.f24636f;
            f10.m();
            return z10 ? 1 : 0;
        } catch (h e10) {
            String str = f24630x;
            d.h(str, "Failed to initialize the proxy: " + e10.getMessage());
            f10.h(e10);
            int a10 = e10.a();
            f10.m();
            return a10;
        } catch (Throwable th) {
            f10.m();
            throw th;
        }
    }
}
