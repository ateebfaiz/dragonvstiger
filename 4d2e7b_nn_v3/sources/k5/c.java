package k5;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;
import k5.b;
import y4.e;
import y4.f;
import y4.g;
import z4.l;

public class c {

    /* renamed from: s  reason: collision with root package name */
    private static final Set f22320s = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    private Uri f22321a = null;

    /* renamed from: b  reason: collision with root package name */
    private b.c f22322b = b.c.FULL_FETCH;

    /* renamed from: c  reason: collision with root package name */
    private int f22323c = 0;

    /* renamed from: d  reason: collision with root package name */
    private f f22324d = null;

    /* renamed from: e  reason: collision with root package name */
    private g f22325e = null;

    /* renamed from: f  reason: collision with root package name */
    private y4.c f22326f = y4.c.a();

    /* renamed from: g  reason: collision with root package name */
    private b.C0299b f22327g = b.C0299b.DEFAULT;

    /* renamed from: h  reason: collision with root package name */
    private boolean f22328h = l.J().a();

    /* renamed from: i  reason: collision with root package name */
    private boolean f22329i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f22330j = false;

    /* renamed from: k  reason: collision with root package name */
    private e f22331k = e.HIGH;

    /* renamed from: l  reason: collision with root package name */
    private d f22332l = null;

    /* renamed from: m  reason: collision with root package name */
    private Boolean f22333m = null;

    /* renamed from: n  reason: collision with root package name */
    private g5.e f22334n;

    /* renamed from: o  reason: collision with root package name */
    private y4.a f22335o = null;

    /* renamed from: p  reason: collision with root package name */
    private Boolean f22336p = null;

    /* renamed from: q  reason: collision with root package name */
    private int f22337q;

    /* renamed from: r  reason: collision with root package name */
    private String f22338r = null;

    public static class a extends RuntimeException {
        public a(String str) {
            super("Invalid request builder: " + str);
        }
    }

    private c() {
    }

    private c A(int i10) {
        this.f22323c = i10;
        if (this.f22327g != b.C0299b.DYNAMIC) {
            this.f22338r = null;
        }
        return this;
    }

    public static c b(b bVar) {
        return w(bVar.u()).D(bVar.g()).y(bVar.b()).z(bVar.c()).F(bVar.i()).E(bVar.h()).G(bVar.j()).A(bVar.d()).H(bVar.k()).I(bVar.o()).K(bVar.n()).L(bVar.q()).J(bVar.p()).M(bVar.s()).N(bVar.y()).B(bVar.e()).C(bVar.f());
    }

    public static boolean r(Uri uri) {
        Set<String> set = f22320s;
        if (!(set == null || uri == null)) {
            for (String equals : set) {
                if (equals.equals(uri.getScheme())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static c w(Uri uri) {
        return new c().O(uri);
    }

    public c B(int i10) {
        this.f22337q = i10;
        return this;
    }

    public c C(String str) {
        this.f22338r = str;
        return this;
    }

    public c D(y4.c cVar) {
        this.f22326f = cVar;
        return this;
    }

    public c E(boolean z10) {
        this.f22330j = z10;
        return this;
    }

    public c F(boolean z10) {
        this.f22329i = z10;
        return this;
    }

    public c G(b.c cVar) {
        this.f22322b = cVar;
        return this;
    }

    public c H(d dVar) {
        this.f22332l = dVar;
        return this;
    }

    public c I(boolean z10) {
        this.f22328h = z10;
        return this;
    }

    public c J(g5.e eVar) {
        this.f22334n = eVar;
        return this;
    }

    public c K(e eVar) {
        this.f22331k = eVar;
        return this;
    }

    public c L(f fVar) {
        this.f22324d = fVar;
        return this;
    }

    public c M(g gVar) {
        this.f22325e = gVar;
        return this;
    }

    public c N(Boolean bool) {
        this.f22333m = bool;
        return this;
    }

    public c O(Uri uri) {
        y2.l.g(uri);
        this.f22321a = uri;
        return this;
    }

    public Boolean P() {
        return this.f22333m;
    }

    /* access modifiers changed from: protected */
    public void Q() {
        Uri uri = this.f22321a;
        if (uri != null) {
            if (g3.f.n(uri)) {
                if (!this.f22321a.isAbsolute()) {
                    throw new a("Resource URI path must be absolute.");
                } else if (!this.f22321a.getPath().isEmpty()) {
                    try {
                        Integer.parseInt(this.f22321a.getPath().substring(1));
                    } catch (NumberFormatException unused) {
                        throw new a("Resource URI path must be a resource id.");
                    }
                } else {
                    throw new a("Resource URI must not be empty");
                }
            }
            if (g3.f.i(this.f22321a) && !this.f22321a.isAbsolute()) {
                throw new a("Asset URI path must be absolute.");
            } else if (this.f22327g != b.C0299b.DYNAMIC) {
                String str = this.f22338r;
                if (str != null && str.length() != 0) {
                    throw new a("Ensure that if you want to use a disk cache id, you set the CacheChoice to DYNAMIC");
                }
            } else if (this.f22338r == null) {
                throw new a("Disk cache id must be set for dynamic cache choice");
            }
        } else {
            throw new a("Source must be set!");
        }
    }

    public b a() {
        Q();
        return new b(this);
    }

    public y4.a c() {
        return this.f22335o;
    }

    public b.C0299b d() {
        return this.f22327g;
    }

    public int e() {
        return this.f22323c;
    }

    public int f() {
        return this.f22337q;
    }

    public String g() {
        return this.f22338r;
    }

    public y4.c h() {
        return this.f22326f;
    }

    public boolean i() {
        return this.f22330j;
    }

    public b.c j() {
        return this.f22322b;
    }

    public d k() {
        return this.f22332l;
    }

    public g5.e l() {
        return this.f22334n;
    }

    public e m() {
        return this.f22331k;
    }

    public f n() {
        return this.f22324d;
    }

    public Boolean o() {
        return this.f22336p;
    }

    public g p() {
        return this.f22325e;
    }

    public Uri q() {
        return this.f22321a;
    }

    public boolean s() {
        if ((this.f22323c & 48) != 0 || (!g3.f.o(this.f22321a) && !r(this.f22321a))) {
            return false;
        }
        return true;
    }

    public boolean t() {
        return this.f22329i;
    }

    public boolean u() {
        if ((this.f22323c & 15) == 0) {
            return true;
        }
        return false;
    }

    public boolean v() {
        return this.f22328h;
    }

    public c x(boolean z10) {
        if (z10) {
            return M(g.d());
        }
        return M(g.g());
    }

    public c y(y4.a aVar) {
        this.f22335o = aVar;
        return this;
    }

    public c z(b.C0299b bVar) {
        this.f22327g = bVar;
        return this;
    }
}
