package z4;

import android.content.Context;
import b3.i;
import c5.e;
import h3.b;
import i5.f;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import x4.j;
import x4.k;
import x4.x;
import y2.o;
import y2.p;
import z4.l;

public final class n {
    public static final b K = new b((DefaultConstructorMarker) null);
    private final boolean A;
    private final boolean B;
    private final boolean C;
    private final boolean D;
    private final boolean E;
    private final boolean F;
    private final boolean G;
    private final int H;
    private final boolean I;
    private final f J;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f25097a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f25098b;

    /* renamed from: c  reason: collision with root package name */
    private final h3.b f25099c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f25100d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f25101e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f25102f;

    /* renamed from: g  reason: collision with root package name */
    private final int f25103g;

    /* renamed from: h  reason: collision with root package name */
    private final int f25104h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f25105i;

    /* renamed from: j  reason: collision with root package name */
    private final int f25106j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f25107k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f25108l;

    /* renamed from: m  reason: collision with root package name */
    private final d f25109m;

    /* renamed from: n  reason: collision with root package name */
    private final o f25110n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f25111o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f25112p;

    /* renamed from: q  reason: collision with root package name */
    private final o f25113q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f25114r;

    /* renamed from: s  reason: collision with root package name */
    private final long f25115s;

    /* renamed from: t  reason: collision with root package name */
    private final boolean f25116t;

    /* renamed from: u  reason: collision with root package name */
    private final boolean f25117u;

    /* renamed from: v  reason: collision with root package name */
    private final boolean f25118v;

    /* renamed from: w  reason: collision with root package name */
    private final boolean f25119w;

    /* renamed from: x  reason: collision with root package name */
    private final boolean f25120x;

    /* renamed from: y  reason: collision with root package name */
    private final boolean f25121y;

    /* renamed from: z  reason: collision with root package name */
    private final int f25122z;

    public static final class a {
        public boolean A;
        public int B;
        public boolean C;
        public boolean D;
        public boolean E;
        public boolean F;
        public boolean G;
        public int H;
        public boolean I;
        public boolean J;
        public f K;

        /* renamed from: a  reason: collision with root package name */
        private final l.a f25123a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f25124b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f25125c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f25126d;

        /* renamed from: e  reason: collision with root package name */
        public h3.b f25127e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f25128f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f25129g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f25130h;

        /* renamed from: i  reason: collision with root package name */
        public int f25131i;

        /* renamed from: j  reason: collision with root package name */
        public int f25132j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f25133k;

        /* renamed from: l  reason: collision with root package name */
        public int f25134l = 2048;

        /* renamed from: m  reason: collision with root package name */
        public boolean f25135m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f25136n;

        /* renamed from: o  reason: collision with root package name */
        public d f25137o;

        /* renamed from: p  reason: collision with root package name */
        public o f25138p;

        /* renamed from: q  reason: collision with root package name */
        public boolean f25139q;

        /* renamed from: r  reason: collision with root package name */
        public boolean f25140r;

        /* renamed from: s  reason: collision with root package name */
        public o f25141s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f25142t;

        /* renamed from: u  reason: collision with root package name */
        public long f25143u;

        /* renamed from: v  reason: collision with root package name */
        public boolean f25144v;

        /* renamed from: w  reason: collision with root package name */
        public boolean f25145w;

        /* renamed from: x  reason: collision with root package name */
        public boolean f25146x;

        /* renamed from: y  reason: collision with root package name */
        public boolean f25147y;

        /* renamed from: z  reason: collision with root package name */
        public boolean f25148z;

        public a(l.a aVar) {
            m.f(aVar, "configBuilder");
            this.f25123a = aVar;
            o a10 = p.a(Boolean.FALSE);
            m.e(a10, "of(false)");
            this.f25141s = a10;
            this.f25146x = true;
            this.f25147y = true;
            this.B = 20;
            this.H = 30;
            this.K = new f(false, false, 3, (DefaultConstructorMarker) null);
        }

        public final n a() {
            return new n(this, (DefaultConstructorMarker) null);
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class c implements d {
        public s a(Context context, b3.a aVar, c5.c cVar, e eVar, e eVar2, boolean z10, boolean z11, g gVar, i iVar, b3.l lVar, x xVar, x xVar2, j jVar, j jVar2, Map map, k kVar, w4.d dVar, int i10, int i11, boolean z12, int i12, a aVar2, boolean z13, int i13) {
            Context context2 = context;
            m.f(context2, "context");
            m.f(aVar, "byteArrayPool");
            m.f(cVar, "imageDecoder");
            m.f(eVar, "progressiveJpegConfig");
            m.f(eVar2, "downsampleMode");
            m.f(gVar, "executorSupplier");
            m.f(iVar, "pooledByteBufferFactory");
            m.f(lVar, "pooledByteStreams");
            m.f(xVar, "bitmapMemoryCache");
            m.f(xVar2, "encodedMemoryCache");
            m.f(jVar, "defaultBufferedDiskCache");
            m.f(jVar2, "smallImageBufferedDiskCache");
            m.f(kVar, "cacheKeyFactory");
            m.f(dVar, "platformBitmapFactory");
            m.f(aVar2, "closeableReferenceFactory");
            return new s(context2, aVar, cVar, eVar, eVar2, z10, z11, gVar, iVar, xVar, xVar2, jVar, jVar2, map, kVar, dVar, i10, i11, z12, i12, aVar2, z13, i13);
        }
    }

    public interface d {
        s a(Context context, b3.a aVar, c5.c cVar, e eVar, e eVar2, boolean z10, boolean z11, g gVar, i iVar, b3.l lVar, x xVar, x xVar2, j jVar, j jVar2, Map map, k kVar, w4.d dVar, int i10, int i11, boolean z12, int i12, a aVar2, boolean z13, int i13);
    }

    public /* synthetic */ n(a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
    }

    public final boolean A() {
        return this.f25121y;
    }

    public final boolean B() {
        return this.f25118v;
    }

    public final boolean C() {
        return this.f25120x;
    }

    public final boolean D() {
        return this.f25119w;
    }

    public final boolean E() {
        return this.f25114r;
    }

    public final boolean F() {
        return this.f25111o;
    }

    public final o G() {
        return this.f25110n;
    }

    public final boolean H() {
        return this.f25107k;
    }

    public final boolean I() {
        return this.f25108l;
    }

    public final boolean J() {
        return this.f25097a;
    }

    public final boolean a() {
        return this.A;
    }

    public final boolean b() {
        return this.F;
    }

    public final int c() {
        return this.H;
    }

    public final boolean d() {
        return this.f25105i;
    }

    public final int e() {
        return this.f25104h;
    }

    public final int f() {
        return this.f25103g;
    }

    public final boolean g() {
        return this.G;
    }

    public final boolean h() {
        return this.f25117u;
    }

    public final boolean i() {
        return this.f25112p;
    }

    public final boolean j() {
        return this.B;
    }

    public final boolean k() {
        return this.f25116t;
    }

    public final int l() {
        return this.f25106j;
    }

    public final long m() {
        return this.f25115s;
    }

    public final f n() {
        return this.J;
    }

    public final d o() {
        return this.f25109m;
    }

    public final boolean p() {
        return this.D;
    }

    public final boolean q() {
        return this.C;
    }

    public final boolean r() {
        return this.E;
    }

    public final o s() {
        return this.f25113q;
    }

    public final int t() {
        return this.f25122z;
    }

    public final boolean u() {
        return this.f25102f;
    }

    public final boolean v() {
        return this.f25101e;
    }

    public final boolean w() {
        return this.f25100d;
    }

    public final h3.b x() {
        return this.f25099c;
    }

    public final b.a y() {
        return null;
    }

    public final boolean z() {
        return this.f25098b;
    }

    private n(a aVar) {
        this.f25097a = aVar.f25125c;
        this.f25098b = aVar.f25126d;
        this.f25099c = aVar.f25127e;
        this.f25100d = aVar.f25128f;
        this.f25101e = aVar.f25129g;
        this.f25102f = aVar.f25130h;
        this.f25103g = aVar.f25131i;
        this.f25104h = aVar.f25132j;
        this.f25105i = aVar.f25133k;
        this.f25106j = aVar.f25134l;
        this.f25107k = aVar.f25135m;
        this.f25108l = aVar.f25136n;
        d dVar = aVar.f25137o;
        this.f25109m = dVar == null ? new c() : dVar;
        o oVar = aVar.f25138p;
        if (oVar == null) {
            oVar = p.f24881b;
            m.e(oVar, "BOOLEAN_FALSE");
        }
        this.f25110n = oVar;
        this.f25111o = aVar.f25139q;
        this.f25112p = aVar.f25140r;
        this.f25113q = aVar.f25141s;
        this.f25114r = aVar.f25142t;
        this.f25115s = aVar.f25143u;
        this.f25116t = aVar.f25144v;
        this.f25117u = aVar.f25145w;
        this.f25118v = aVar.f25146x;
        this.f25119w = aVar.f25147y;
        this.f25120x = aVar.f25148z;
        this.f25121y = aVar.A;
        this.f25122z = aVar.B;
        this.F = aVar.G;
        this.H = aVar.H;
        this.A = aVar.C;
        this.B = aVar.D;
        this.C = aVar.E;
        this.D = aVar.F;
        this.E = aVar.f25124b;
        this.G = aVar.I;
        this.I = aVar.J;
        this.J = aVar.K;
    }
}
