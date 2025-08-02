package g;

import OooO0o0.OooO0O0;
import OooO0o0.OooO0Oo;
import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import com.mah.sdk.MahProxy;
import com.mah.sdk.MahProxyAddress;
import com.mah.sdk.MahProxyOptions;
import com.mah.sdk.OooO00o;
import d.c;
import d.e;
import d.f;
import d.h;
import f.b;
import g.k;
import i.u;
import i.v;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import o.g;
import q.c;
import w.d;

public class i implements b, k.c, f {

    /* renamed from: r  reason: collision with root package name */
    public static final String f21534r = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final Context f21535a;

    /* renamed from: b  reason: collision with root package name */
    public final MahProxyOptions f21536b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f21537c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference f21538d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference f21539e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference f21540f;

    /* renamed from: g  reason: collision with root package name */
    public final k f21541g;

    /* renamed from: h  reason: collision with root package name */
    public final c f21542h;

    /* renamed from: i  reason: collision with root package name */
    public final o f21543i;

    /* renamed from: j  reason: collision with root package name */
    public long f21544j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f21545k;

    /* renamed from: l  reason: collision with root package name */
    public short f21546l;

    /* renamed from: m  reason: collision with root package name */
    public final l f21547m;

    /* renamed from: n  reason: collision with root package name */
    public final AtomicReference f21548n;

    /* renamed from: o  reason: collision with root package name */
    public final c f21549o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f21550p = false;

    /* renamed from: q  reason: collision with root package name */
    public final b.a f21551q = new a();

    public class a extends b.a {
        public a() {
        }

        public boolean a(int i10) {
            String unused = i.f21534r;
            i iVar = i.this;
            iVar.f21545k = true;
            iVar.C();
            return true;
        }

        public void b(OooO0O0 oooO0O0) {
            String unused = i.f21534r;
            i.this.c(oooO0O0);
        }

        public void m(MahProxyAddress mahProxyAddress, MahProxyAddress mahProxyAddress2, MahProxyAddress mahProxyAddress3, int i10) {
            String unused = i.f21534r;
            i.this.A(mahProxyAddress, mahProxyAddress2, mahProxyAddress3, OooO00o.OooO0Oo(i10));
        }
    }

    public class b implements k.c {
        public b() {
        }

        public void a() {
            String unused = i.f21534r;
            i.this.f21547m.f21566b.post(new j(this));
        }

        public void b() {
        }

        public final /* synthetic */ void c() {
            i.this.E();
        }
    }

    public i(Context context, c cVar, MahProxyOptions mahProxyOptions, long j10) {
        this.f21541g = new k(context, false);
        this.f21542h = cVar;
        this.f21547m = new l("Client-Dispatcher", (Handler.Callback) null);
        this.f21535a = context.getApplicationContext();
        this.f21538d = new AtomicReference((Object) null);
        this.f21539e = new AtomicReference((Object) null);
        this.f21540f = new AtomicReference((Object) null);
        this.f21537c = new AtomicBoolean(false);
        this.f21536b = mahProxyOptions;
        this.f21543i = new o();
        this.f21545k = false;
        this.f21546l = 0;
        this.f21544j = j10;
        e a10 = cVar.a();
        this.f21549o = a10;
        this.f21548n = new AtomicReference(a10.f());
        G();
    }

    public static void i(Context context) {
        q.f.f().i(new c.a(u.a.c(), u.c.c(context), v.c(), u.a.b(context)));
    }

    public static void p(Context context, d.c cVar, MahProxyOptions mahProxyOptions) {
        long currentTimeMillis = System.currentTimeMillis();
        OooO00o.OooO0O0(context, cVar.f().b(), mahProxyOptions.OooOOO);
        z(context);
        a.b(new i(context, cVar, mahProxyOptions, currentTimeMillis));
        a.a().g();
    }

    public static void z(Context context) {
        u.b(new g(context));
    }

    public final void A(MahProxyAddress mahProxyAddress, MahProxyAddress mahProxyAddress2, MahProxyAddress mahProxyAddress3, MahProxy.ProxyChangedReason proxyChangedReason) {
        this.f21547m.f21566b.post(new f(this, mahProxyAddress, mahProxyAddress3, mahProxyAddress2, proxyChangedReason));
    }

    public void C() {
        if (this.f21537c.get()) {
            this.f21547m.f21566b.post(new h(this));
        }
    }

    public final void E() {
        this.f21541g.b(this);
        if (J()) {
            this.f21537c.set(true);
            d.k(f21534r, "MahProxy start succeed");
            System.currentTimeMillis();
        }
    }

    public final /* synthetic */ void F() {
        if (this.f21543i.a()) {
            this.f21544j = System.currentTimeMillis();
            this.f21541g.f();
            return;
        }
        this.f21541g.g();
    }

    public final void G() {
        OooO0O0 oooO0O0 = (OooO0O0) this.f21548n.get();
        if (d.j()) {
            OooO00o.OooO00o(oooO0O0, "initSharedConfig");
        }
    }

    public final /* synthetic */ void H() {
        this.f21541g.c(!this.f21545k);
        this.f21537c.set(false);
    }

    public final void I() {
        this.f21546l = (short) (this.f21546l + 1);
        if (J()) {
            d.k(f21534r, "MahProxy start succeed");
            System.currentTimeMillis();
        }
    }

    public final boolean J() {
        f.a e10 = this.f21541g.e();
        if (e10 == null) {
            return false;
        }
        i.e f10 = this.f21542h.f();
        try {
            e10.e(this.f21551q);
            int x10 = e10.x(new OooO0Oo(this.f21546l, this.f21536b, f10.c(), f10.b()));
            boolean z10 = true;
            if (x10 == 1) {
                return true;
            }
            if (x10 != 0) {
                z10 = false;
            }
            if (!z10) {
                w((MahProxyAddress) null, OooO00o.OooO0OO(x10));
            }
            return z10;
        } catch (RemoteException e11) {
            g.a().b(e11);
            return false;
        }
    }

    public Context OooO00o() {
        return this.f21535a;
    }

    public void a() {
        this.f21547m.f21566b.post(new e(this));
    }

    public void b() {
        this.f21547m.f21566b.post(new d(this));
    }

    public final void c(OooO0O0 oooO0O0) {
        if (d.j()) {
            OooO00o.OooO00o(oooO0O0, "updateSharedConfig");
        }
        if (!((OooO0O0) this.f21548n.getAndSet(oooO0O0)).f13466b.equals(oooO0O0.f13466b)) {
            this.f21542h.j().d(oooO0O0.f13466b);
        }
    }

    public s.e f() {
        return s.e.c(this.f21535a);
    }

    public void g() {
        y(this.f21550p);
        this.f21541g.b(new b());
        if (!this.f21541g.h()) {
            throw new h("bind service failed", -17);
        }
    }

    public MahProxyAddress h(d.b bVar) {
        if (bVar == d.b.ADDRESS_TYPE_SOURCE) {
            return (MahProxyAddress) this.f21539e.get();
        }
        if (bVar == d.b.ADDRESS_TYPE_PROXY_NORMAL) {
            return (MahProxyAddress) this.f21538d.get();
        }
        return (MahProxyAddress) this.f21540f.get();
    }

    public void t() {
    }

    public final void w(MahProxyAddress mahProxyAddress, MahProxy.ProxyChangedReason proxyChangedReason) {
        String str;
        int i10;
        if (mahProxyAddress == null) {
            str = null;
        } else {
            str = mahProxyAddress.getHost();
        }
        if (mahProxyAddress == null) {
            i10 = -1;
        } else {
            i10 = mahProxyAddress.getPort();
        }
        proxyChangedReason.name();
        MahProxy.ProxyListener proxyListener = this.f21536b.OooO0oo;
        if (proxyListener != null) {
            proxyListener.onProxyChanged(str, i10, proxyChangedReason);
        }
    }

    public final void x(MahProxyAddress mahProxyAddress, MahProxyAddress mahProxyAddress2, MahProxyAddress mahProxyAddress3, MahProxy.ProxyChangedReason proxyChangedReason) {
        if (mahProxyAddress == null) {
            this.f21538d.set((Object) null);
            this.f21539e.set((Object) null);
            this.f21540f.set((Object) null);
        } else {
            if (((MahProxyAddress) this.f21538d.get()) == null) {
                d.k(f21534r, "address change to not-null, may be service start finish");
            }
            this.f21538d.set(mahProxyAddress);
            this.f21539e.set(mahProxyAddress2);
            this.f21540f.set(mahProxyAddress3);
        }
        w(mahProxyAddress2, proxyChangedReason);
    }

    public final void y(boolean z10) {
        if (z10) {
            g.d(new o.f(this.f21535a, this.f21536b.OooO00o, this, false, this.f21542h));
        }
    }
}
