package k5;

import android.net.Uri;
import android.os.Build;
import java.io.File;
import r2.d;
import y2.e;
import y2.j;
import y2.l;
import y4.f;
import y4.g;

public class b {

    /* renamed from: x  reason: collision with root package name */
    private static boolean f22284x;

    /* renamed from: y  reason: collision with root package name */
    private static boolean f22285y;

    /* renamed from: z  reason: collision with root package name */
    public static final e f22286z = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f22287a;

    /* renamed from: b  reason: collision with root package name */
    private final C0299b f22288b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f22289c;

    /* renamed from: d  reason: collision with root package name */
    private final int f22290d;

    /* renamed from: e  reason: collision with root package name */
    private File f22291e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f22292f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f22293g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f22294h;

    /* renamed from: i  reason: collision with root package name */
    private final y4.c f22295i;

    /* renamed from: j  reason: collision with root package name */
    private final f f22296j;

    /* renamed from: k  reason: collision with root package name */
    private final g f22297k;

    /* renamed from: l  reason: collision with root package name */
    private final y4.a f22298l;

    /* renamed from: m  reason: collision with root package name */
    private final y4.e f22299m;

    /* renamed from: n  reason: collision with root package name */
    private final c f22300n;

    /* renamed from: o  reason: collision with root package name */
    protected int f22301o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f22302p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f22303q;

    /* renamed from: r  reason: collision with root package name */
    private final Boolean f22304r;

    /* renamed from: s  reason: collision with root package name */
    private final d f22305s;

    /* renamed from: t  reason: collision with root package name */
    private final g5.e f22306t;

    /* renamed from: u  reason: collision with root package name */
    private final Boolean f22307u;

    /* renamed from: v  reason: collision with root package name */
    private final String f22308v;

    /* renamed from: w  reason: collision with root package name */
    private final int f22309w;

    class a implements e {
        a() {
        }

        /* renamed from: a */
        public Uri apply(b bVar) {
            if (bVar != null) {
                return bVar.u();
            }
            return null;
        }
    }

    /* renamed from: k5.b$b  reason: collision with other inner class name */
    public enum C0299b {
        SMALL,
        DEFAULT,
        DYNAMIC
    }

    public enum c {
        FULL_FETCH(1),
        DISK_CACHE(2),
        ENCODED_MEMORY_CACHE(3),
        BITMAP_MEMORY_CACHE(4);
        

        /* renamed from: a  reason: collision with root package name */
        private int f22319a;

        private c(int i10) {
            this.f22319a = i10;
        }

        public static c a(c cVar, c cVar2) {
            if (cVar.b() > cVar2.b()) {
                return cVar;
            }
            return cVar2;
        }

        public int b() {
            return this.f22319a;
        }
    }

    protected b(c cVar) {
        g gVar;
        this.f22288b = cVar.d();
        Uri q10 = cVar.q();
        this.f22289c = q10;
        this.f22290d = w(q10);
        this.f22292f = cVar.v();
        this.f22293g = cVar.t();
        this.f22294h = cVar.i();
        this.f22295i = cVar.h();
        this.f22296j = cVar.n();
        if (cVar.p() == null) {
            gVar = g.d();
        } else {
            gVar = cVar.p();
        }
        this.f22297k = gVar;
        this.f22298l = cVar.c();
        this.f22299m = cVar.m();
        this.f22300n = cVar.j();
        boolean s10 = cVar.s();
        this.f22302p = s10;
        int e10 = cVar.e();
        this.f22301o = !s10 ? e10 | 48 : e10;
        this.f22303q = cVar.u();
        this.f22304r = cVar.P();
        this.f22305s = cVar.k();
        this.f22306t = cVar.l();
        this.f22307u = cVar.o();
        this.f22309w = cVar.f();
        this.f22308v = cVar.g();
    }

    public static b a(Uri uri) {
        if (uri == null) {
            return null;
        }
        return c.w(uri).a();
    }

    private static int w(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (g3.f.o(uri)) {
            return 0;
        }
        if (uri.getPath() == null || !g3.f.m(uri)) {
            if (g3.f.l(uri)) {
                return 4;
            }
            if (g3.f.i(uri)) {
                return 5;
            }
            if (g3.f.n(uri)) {
                return 6;
            }
            if (g3.f.h(uri)) {
                return 7;
            }
            if (g3.f.p(uri)) {
                return 8;
            }
            return -1;
        } else if (a3.a.c(a3.a.b(uri.getPath()))) {
            return 2;
        } else {
            return 3;
        }
    }

    public y4.a b() {
        return this.f22298l;
    }

    public C0299b c() {
        return this.f22288b;
    }

    public int d() {
        return this.f22301o;
    }

    public int e() {
        return this.f22309w;
    }

    public boolean equals(Object obj) {
        d dVar;
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (f22284x) {
            int i10 = this.f22287a;
            int i11 = bVar.f22287a;
            if (!(i10 == 0 || i11 == 0 || i10 == i11)) {
                return false;
            }
        }
        if (this.f22293g != bVar.f22293g || this.f22302p != bVar.f22302p || this.f22303q != bVar.f22303q || !j.a(this.f22289c, bVar.f22289c) || !j.a(this.f22288b, bVar.f22288b) || !j.a(this.f22308v, bVar.f22308v) || !j.a(this.f22291e, bVar.f22291e) || !j.a(this.f22298l, bVar.f22298l) || !j.a(this.f22295i, bVar.f22295i) || !j.a(this.f22296j, bVar.f22296j) || !j.a(this.f22299m, bVar.f22299m) || !j.a(this.f22300n, bVar.f22300n) || !j.a(Integer.valueOf(this.f22301o), Integer.valueOf(bVar.f22301o)) || !j.a(this.f22304r, bVar.f22304r) || !j.a(this.f22307u, bVar.f22307u) || !j.a(this.f22297k, bVar.f22297k) || this.f22294h != bVar.f22294h) {
            return false;
        }
        d dVar2 = this.f22305s;
        d dVar3 = null;
        if (dVar2 != null) {
            dVar = dVar2.b();
        } else {
            dVar = null;
        }
        d dVar4 = bVar.f22305s;
        if (dVar4 != null) {
            dVar3 = dVar4.b();
        }
        if (j.a(dVar, dVar3) && this.f22309w == bVar.f22309w) {
            return true;
        }
        return false;
    }

    public String f() {
        return this.f22308v;
    }

    public y4.c g() {
        return this.f22295i;
    }

    public boolean h() {
        if (Build.VERSION.SDK_INT < 29 || !this.f22294h) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        d dVar;
        boolean z10;
        int a10;
        b bVar = this;
        boolean z11 = f22285y;
        if (z11) {
            i10 = bVar.f22287a;
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            d dVar2 = bVar.f22305s;
            if (dVar2 != null) {
                dVar = dVar2.b();
            } else {
                dVar = null;
            }
            if (!a6.a.a()) {
                z10 = z11;
                a10 = j.b(bVar.f22288b, bVar.f22308v, bVar.f22289c, Boolean.valueOf(bVar.f22293g), bVar.f22298l, bVar.f22299m, bVar.f22300n, Integer.valueOf(bVar.f22301o), Boolean.valueOf(bVar.f22302p), Boolean.valueOf(bVar.f22303q), bVar.f22295i, bVar.f22304r, bVar.f22296j, bVar.f22297k, dVar, bVar.f22307u, Integer.valueOf(bVar.f22309w), Boolean.valueOf(bVar.f22294h));
                bVar = this;
            } else {
                z10 = z11;
                d dVar3 = dVar;
                a10 = b6.a.a(b6.a.a(b6.a.a(b6.a.a(b6.a.a(b6.a.a(b6.a.a(b6.a.a(b6.a.a(b6.a.a(b6.a.a(b6.a.a(b6.a.a(b6.a.a(b6.a.a(b6.a.a(b6.a.a(0, bVar.f22288b), bVar.f22289c), Boolean.valueOf(bVar.f22293g)), bVar.f22298l), bVar.f22299m), bVar.f22300n), Integer.valueOf(bVar.f22301o)), Boolean.valueOf(bVar.f22302p)), Boolean.valueOf(bVar.f22303q)), bVar.f22295i), bVar.f22304r), bVar.f22296j), bVar.f22297k), dVar), bVar.f22307u), Integer.valueOf(bVar.f22309w)), Boolean.valueOf(bVar.f22294h));
            }
            if (z10) {
                bVar.f22287a = i10;
            }
        }
        return i10;
    }

    public boolean i() {
        return this.f22293g;
    }

    public c j() {
        return this.f22300n;
    }

    public d k() {
        return this.f22305s;
    }

    public int l() {
        f fVar = this.f22296j;
        if (fVar != null) {
            return fVar.f24927b;
        }
        return 2048;
    }

    public int m() {
        f fVar = this.f22296j;
        if (fVar != null) {
            return fVar.f24926a;
        }
        return 2048;
    }

    public y4.e n() {
        return this.f22299m;
    }

    public boolean o() {
        return this.f22292f;
    }

    public g5.e p() {
        return this.f22306t;
    }

    public f q() {
        return this.f22296j;
    }

    public Boolean r() {
        return this.f22307u;
    }

    public g s() {
        return this.f22297k;
    }

    public synchronized File t() {
        try {
            if (this.f22291e == null) {
                l.g(this.f22289c.getPath());
                this.f22291e = new File(this.f22289c.getPath());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f22291e;
    }

    public String toString() {
        return j.c(this).b("uri", this.f22289c).b("cacheChoice", this.f22288b).b("decodeOptions", this.f22295i).b("postprocessor", this.f22305s).b("priority", this.f22299m).b("resizeOptions", this.f22296j).b("rotationOptions", this.f22297k).b("bytesRange", this.f22298l).b("resizingAllowedOverride", this.f22307u).c("progressiveRenderingEnabled", this.f22292f).c("localThumbnailPreviewsEnabled", this.f22293g).c("loadThumbnailOnly", this.f22294h).b("lowestPermittedRequestLevel", this.f22300n).a("cachesDisabled", this.f22301o).c("isDiskCacheEnabled", this.f22302p).c("isMemoryCacheEnabled", this.f22303q).b("decodePrefetches", this.f22304r).a("delayMs", this.f22309w).toString();
    }

    public Uri u() {
        return this.f22289c;
    }

    public int v() {
        return this.f22290d;
    }

    public boolean x(int i10) {
        if ((i10 & d()) == 0) {
            return true;
        }
        return false;
    }

    public Boolean y() {
        return this.f22304r;
    }
}
