package e;

import OooO0o0.OooO0Oo;
import android.os.Handler;
import android.text.TextUtils;
import com.mah.sdk.OooO00o;
import d.c;
import d.k;
import g.l;
import i.v;
import java.util.concurrent.atomic.AtomicBoolean;
import w.d;

public class i {

    /* renamed from: m  reason: collision with root package name */
    public static final String f21059m = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public k f21060a;

    /* renamed from: b  reason: collision with root package name */
    public l f21061b;

    /* renamed from: c  reason: collision with root package name */
    public j.b f21062c;

    /* renamed from: d  reason: collision with root package name */
    public k f21063d;

    /* renamed from: e  reason: collision with root package name */
    public j.b f21064e;

    /* renamed from: f  reason: collision with root package name */
    public m f21065f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f21066g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public int f21067h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21068i;

    /* renamed from: j  reason: collision with root package name */
    public c f21069j;

    /* renamed from: k  reason: collision with root package name */
    public String f21070k;

    /* renamed from: l  reason: collision with root package name */
    public Handler f21071l;

    public enum a {
        AUTH_START(0, "priority start"),
        AUTH_NETWORK_CHANGE(1, "network change"),
        AUTH_TIMER(2, "timer");
        

        /* renamed from: a  reason: collision with root package name */
        public final int f21076a;

        /* renamed from: b  reason: collision with root package name */
        public final String f21077b;

        /* access modifiers changed from: public */
        a(int i10, String str) {
            this.f21076a = i10;
            this.f21077b = str;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final i f21078a = new i();
    }

    public static i n() {
        return b.f21078a;
    }

    public final void a() {
        OooO0Oo n10 = this.f21060a.n();
        if (n10.f13478j) {
            this.f21064e = j.a.a().c(new c(this), (long) n10.f13479w);
        }
    }

    public final String b(int i10) {
        if (i10 == 1) {
            return "Network error";
        }
        if (i10 == 2) {
            return "Response code error";
        }
        if (i10 != 3) {
            return "Unknown error";
        }
        return "Data abnormal error";
    }

    public final void c() {
        j.b bVar = this.f21062c;
        if (bVar != null) {
            bVar.a();
            this.f21063d.d();
        }
    }

    public void d(k kVar, c cVar) {
        if (this.f21066g.compareAndSet(false, true)) {
            this.f21060a = kVar;
            this.f21069j = cVar;
            this.f21065f = new n(OooO00o.OooO0O0(kVar.OooO00o()), "com.mah.auth_config.json", OooO00o.OooO0O0(v.a(kVar.OooO00o()), "auth"));
            this.f21061b = new l(kVar.r().j());
            this.f21067h = 0;
            this.f21068i = false;
            if (p(kVar.n().f13473e)) {
                this.f21061b.b(System.currentTimeMillis());
            }
            this.f21070k = this.f21061b.f();
            this.f21071l = new l("Auth-Dispatcher", (Handler.Callback) null).f21566b;
        }
    }

    public void e(a aVar) {
        if (this.f21066g.get()) {
            this.f21071l.post(new b(this, aVar));
        }
    }

    public final void h(k kVar, int i10) {
        if (kVar.l()) {
            kVar.k();
            return;
        }
        int i11 = this.f21067h;
        this.f21067h = i11 + 1;
        if (i11 < 10) {
            long j10 = (long) j(i10);
            kVar.k();
            kVar.e(this.f21067h);
            j.b c10 = j.a.a().c(kVar, j10);
            this.f21062c = c10;
            if (c10 == null) {
                kVar.k();
                return;
            }
            return;
        }
        w();
        this.f21061b.g();
        this.f21060a.v(kVar.f21093a, b(i10), 1);
    }

    public final int j(int i10) {
        if (i10 == -1 || i10 != 1) {
            return 60000;
        }
        return 30000;
    }

    public final String l() {
        String str = this.f21060a.o().S;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return "https://au.relauservice.com/frontoffice/authV2";
    }

    /* renamed from: m */
    public final void q(a aVar) {
        if (!this.f21060a.n().f13478j || aVar == a.AUTH_START) {
            if (d.j()) {
                int i10 = aVar.f21076a;
            }
            c();
            s(aVar);
            k o10 = o(aVar);
            o10.g(new h(this));
            o10.h(this.f21070k);
            a();
            j.b c10 = j.a.a().c(o10, o10.j());
            this.f21062c = c10;
            if (c10 != null) {
                this.f21063d = o10;
            }
        }
    }

    public final k o(a aVar) {
        return new o(aVar, this.f21061b.a(), l(), this.f21060a, this.f21065f, this.f21069j);
    }

    public final boolean p(int i10) {
        if (i10 == 0) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ void r() {
        this.f21061b.g();
        this.f21060a.l();
    }

    public final void s(a aVar) {
        if (aVar != a.AUTH_NETWORK_CHANGE) {
            this.f21067h = 0;
            this.f21068i = false;
        } else if (this.f21068i) {
            this.f21067h = 10;
        }
    }

    public boolean t() {
        if (!this.f21066g.get() || this.f21061b.d() == 0) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ void u() {
        c();
        v();
    }

    public final void v() {
        this.f21071l.post(new d(this));
    }

    public final void w() {
        j.b bVar;
        if (this.f21060a.n().f13478j && (bVar = this.f21064e) != null && !bVar.c()) {
            bVar.a();
        }
    }
}
