package dd;

import dd.d;
import dd.f;
import java.math.BigInteger;
import java.util.Random;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    protected id.a f127a;

    /* renamed from: b  reason: collision with root package name */
    protected d f128b;

    /* renamed from: c  reason: collision with root package name */
    protected d f129c;

    /* renamed from: d  reason: collision with root package name */
    protected BigInteger f130d;

    /* renamed from: e  reason: collision with root package name */
    protected BigInteger f131e;

    /* renamed from: f  reason: collision with root package name */
    protected int f132f = 0;

    /* renamed from: g  reason: collision with root package name */
    protected hd.a f133g = null;

    public static abstract class a extends c {

        /* renamed from: h  reason: collision with root package name */
        private BigInteger[] f134h = null;

        protected a(int i10, int i11, int i12, int i13) {
            super(y(i10, i11, i12, i13));
        }

        private static id.a y(int i10, int i11, int i12, int i13) {
            if (i11 == 0) {
                throw new IllegalArgumentException("k1 must be > 0");
            } else if (i12 == 0) {
                if (i13 == 0) {
                    return id.b.a(new int[]{0, i11, i10});
                }
                throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
            } else if (i12 <= i11) {
                throw new IllegalArgumentException("k2 must be > k1");
            } else if (i13 > i12) {
                return id.b.a(new int[]{0, i11, i12, i13, i10});
            } else {
                throw new IllegalArgumentException("k3 must be > k2");
            }
        }

        private d z(d dVar) {
            d dVar2;
            if (dVar.h()) {
                return dVar;
            }
            d j10 = j(b.f121a);
            int p10 = p();
            Random random = new Random();
            do {
                d j11 = j(new BigInteger(p10, random));
                d dVar3 = dVar;
                dVar2 = j10;
                for (int i10 = 1; i10 < p10; i10++) {
                    d n10 = dVar3.n();
                    dVar2 = dVar2.n().a(n10.i(j11));
                    dVar3 = n10.a(dVar);
                }
                if (!dVar3.h()) {
                    return null;
                }
            } while (dVar2.n().a(dVar2).h());
            return dVar2;
        }

        public f e(BigInteger bigInteger, BigInteger bigInteger2, boolean z10) {
            d j10 = j(bigInteger);
            d j11 = j(bigInteger2);
            int n10 = n();
            if (n10 == 5 || n10 == 6) {
                if (!j10.h()) {
                    j11 = j11.d(j10).a(j10);
                } else if (!j11.n().equals(l())) {
                    throw new IllegalArgumentException();
                }
            }
            return f(j10, j11, z10);
        }

        /* access modifiers changed from: protected */
        public f h(int i10, BigInteger bigInteger) {
            d dVar;
            boolean z10;
            d j10 = j(bigInteger);
            if (j10.h()) {
                dVar = l().m();
            } else {
                d z11 = z(j10.n().f().i(l()).a(k()).a(j10));
                if (z11 != null) {
                    boolean q10 = z11.q();
                    if (i10 == 1) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (q10 != z10) {
                        z11 = z11.b();
                    }
                    int n10 = n();
                    if (n10 == 5 || n10 == 6) {
                        dVar = z11.a(j10);
                    } else {
                        dVar = z11.i(j10);
                    }
                } else {
                    dVar = null;
                }
            }
            if (dVar != null) {
                return f(j10, dVar, true);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }
    }

    public static abstract class b extends c {
        protected b(BigInteger bigInteger) {
            super(id.b.b(bigInteger));
        }

        /* access modifiers changed from: protected */
        public f h(int i10, BigInteger bigInteger) {
            boolean z10;
            d j10 = j(bigInteger);
            d m10 = j10.n().a(this.f128b).i(j10).a(this.f129c).m();
            if (m10 != null) {
                boolean q10 = m10.q();
                if (i10 == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (q10 != z10) {
                    m10 = m10.l();
                }
                return f(j10, m10, true);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }
    }

    /* renamed from: dd.c$c  reason: collision with other inner class name */
    public class C0001c {

        /* renamed from: a  reason: collision with root package name */
        protected int f135a;

        /* renamed from: b  reason: collision with root package name */
        protected hd.a f136b;

        C0001c(int i10, hd.a aVar, e eVar) {
            this.f135a = i10;
            this.f136b = aVar;
        }

        public c a() {
            if (c.this.v(this.f135a)) {
                c b10 = c.this.b();
                if (b10 != c.this) {
                    synchronized (b10) {
                        b10.f132f = this.f135a;
                        b10.f133g = this.f136b;
                    }
                    return b10;
                }
                throw new IllegalStateException("implementation returned current curve");
            }
            throw new IllegalStateException("unsupported coordinate system");
        }

        public C0001c b(hd.a aVar) {
            this.f136b = aVar;
            return this;
        }
    }

    public static class d extends a {

        /* renamed from: i  reason: collision with root package name */
        private int f138i;

        /* renamed from: j  reason: collision with root package name */
        private int f139j;

        /* renamed from: k  reason: collision with root package name */
        private int f140k;

        /* renamed from: l  reason: collision with root package name */
        private int f141l;

        /* renamed from: m  reason: collision with root package name */
        private f.c f142m;

        public d(int i10, int i11, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this(i10, i11, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
        }

        /* access modifiers changed from: protected */
        public c b() {
            return new d(this.f138i, this.f139j, this.f140k, this.f141l, this.f128b, this.f129c, this.f130d, this.f131e);
        }

        /* access modifiers changed from: protected */
        public f f(d dVar, d dVar2, boolean z10) {
            return new f.c(this, dVar, dVar2, z10);
        }

        public d j(BigInteger bigInteger) {
            return new d.a(this.f138i, this.f139j, this.f140k, this.f141l, bigInteger);
        }

        public int p() {
            return this.f138i;
        }

        public f q() {
            return this.f142m;
        }

        public boolean v(int i10) {
            if (i10 == 0 || i10 == 1 || i10 == 6) {
                return true;
            }
            return false;
        }

        public d(int i10, int i11, int i12, int i13, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(i10, i11, i12, i13);
            this.f138i = i10;
            this.f139j = i11;
            this.f140k = i12;
            this.f141l = i13;
            this.f130d = bigInteger3;
            this.f131e = bigInteger4;
            this.f142m = new f.c(this, (d) null, (d) null);
            this.f128b = j(bigInteger);
            this.f129c = j(bigInteger2);
            this.f132f = 6;
        }

        protected d(int i10, int i11, int i12, int i13, d dVar, d dVar2, BigInteger bigInteger, BigInteger bigInteger2) {
            super(i10, i11, i12, i13);
            this.f138i = i10;
            this.f139j = i11;
            this.f140k = i12;
            this.f141l = i13;
            this.f130d = bigInteger;
            this.f131e = bigInteger2;
            this.f142m = new f.c(this, (d) null, (d) null);
            this.f128b = dVar;
            this.f129c = dVar2;
            this.f132f = 6;
        }
    }

    protected c(id.a aVar) {
        this.f127a = aVar;
    }

    /* access modifiers changed from: protected */
    public void a(f[] fVarArr, int i10, int i11) {
        if (fVarArr == null) {
            throw new IllegalArgumentException("'points' cannot be null");
        } else if (i10 < 0 || i11 < 0 || i10 > fVarArr.length - i11) {
            throw new IllegalArgumentException("invalid range specified for 'points'");
        } else {
            int i12 = 0;
            while (i12 < i11) {
                f fVar = fVarArr[i10 + i12];
                if (fVar == null || this == fVar.g()) {
                    i12++;
                } else {
                    throw new IllegalArgumentException("'points' entries must be null or on this curve");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract c b();

    public synchronized C0001c c() {
        return new C0001c(this.f132f, this.f133g, (e) null);
    }

    public f d(BigInteger bigInteger, BigInteger bigInteger2) {
        return e(bigInteger, bigInteger2, false);
    }

    public f e(BigInteger bigInteger, BigInteger bigInteger2, boolean z10) {
        return f(j(bigInteger), j(bigInteger2), z10);
    }

    public boolean equals(Object obj) {
        if (this == obj || ((obj instanceof c) && i((c) obj))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract f f(d dVar, d dVar2, boolean z10);

    public f g(byte[] bArr) {
        f fVar;
        int p10 = (p() + 7) / 8;
        boolean z10 = false;
        byte b10 = bArr[0];
        if (b10 != 0) {
            if (b10 == 2 || b10 == 3) {
                if (bArr.length == p10 + 1) {
                    fVar = h(b10 & 1, zd.b.a(bArr, 1, p10));
                    if (!fVar.u()) {
                        throw new IllegalArgumentException("Invalid point");
                    }
                } else {
                    throw new IllegalArgumentException("Incorrect length for compressed encoding");
                }
            } else if (b10 != 4) {
                if (b10 != 6 && b10 != 7) {
                    throw new IllegalArgumentException("Invalid point encoding 0x" + Integer.toString(b10, 16));
                } else if (bArr.length == (p10 * 2) + 1) {
                    BigInteger a10 = zd.b.a(bArr, 1, p10);
                    BigInteger a11 = zd.b.a(bArr, p10 + 1, p10);
                    boolean testBit = a11.testBit(0);
                    if (b10 == 7) {
                        z10 = true;
                    }
                    if (testBit == z10) {
                        fVar = w(a10, a11);
                    } else {
                        throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
                    }
                } else {
                    throw new IllegalArgumentException("Incorrect length for hybrid encoding");
                }
            } else if (bArr.length == (p10 * 2) + 1) {
                fVar = w(zd.b.a(bArr, 1, p10), zd.b.a(bArr, p10 + 1, p10));
            } else {
                throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
            }
        } else if (bArr.length == 1) {
            fVar = q();
        } else {
            throw new IllegalArgumentException("Incorrect length for infinity encoding");
        }
        if (b10 == 0 || !fVar.o()) {
            return fVar;
        }
        throw new IllegalArgumentException("Invalid infinity encoding");
    }

    /* access modifiers changed from: protected */
    public abstract f h(int i10, BigInteger bigInteger);

    public int hashCode() {
        return (o().hashCode() ^ zd.c.a(k().r().hashCode(), 8)) ^ zd.c.a(l().r().hashCode(), 16);
    }

    public boolean i(c cVar) {
        if (this == cVar || (cVar != null && o().equals(cVar.o()) && k().r().equals(cVar.k().r()) && l().r().equals(cVar.l().r()))) {
            return true;
        }
        return false;
    }

    public abstract d j(BigInteger bigInteger);

    public d k() {
        return this.f128b;
    }

    public d l() {
        return this.f129c;
    }

    public BigInteger m() {
        return this.f131e;
    }

    public int n() {
        return this.f132f;
    }

    public id.a o() {
        return this.f127a;
    }

    public abstract int p();

    public abstract f q();

    public BigInteger r() {
        return this.f130d;
    }

    public f s(f fVar) {
        if (this == fVar.g()) {
            return fVar;
        }
        if (fVar.o()) {
            return q();
        }
        f s10 = fVar.s();
        return x(s10.l().r(), s10.m().r(), s10.f158e);
    }

    public void t(f[] fVarArr) {
        u(fVarArr, 0, fVarArr.length, (d) null);
    }

    public void u(f[] fVarArr, int i10, int i11, d dVar) {
        a(fVarArr, i10, i11);
        int n10 = n();
        if (n10 != 0 && n10 != 5) {
            d[] dVarArr = new d[i11];
            int[] iArr = new int[i11];
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                int i14 = i10 + i13;
                f fVar = fVarArr[i14];
                if (fVar != null && (dVar != null || !fVar.p())) {
                    dVarArr[i12] = fVar.n(0);
                    iArr[i12] = i14;
                    i12++;
                }
            }
            if (i12 != 0) {
                a.e(dVarArr, 0, i12, dVar);
                for (int i15 = 0; i15 < i12; i15++) {
                    int i16 = iArr[i15];
                    fVarArr[i16] = fVarArr[i16].t(dVarArr[i15]);
                }
            }
        } else if (dVar != null) {
            throw new IllegalArgumentException("'iso' not valid for affine coordinates");
        }
    }

    public abstract boolean v(int i10);

    public f w(BigInteger bigInteger, BigInteger bigInteger2) {
        f d10 = d(bigInteger, bigInteger2);
        if (d10.q()) {
            return d10;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }

    public f x(BigInteger bigInteger, BigInteger bigInteger2, boolean z10) {
        f e10 = e(bigInteger, bigInteger2, z10);
        if (e10.q()) {
            return e10;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }

    public static class e extends b {

        /* renamed from: h  reason: collision with root package name */
        BigInteger f143h;

        /* renamed from: i  reason: collision with root package name */
        BigInteger f144i;

        /* renamed from: j  reason: collision with root package name */
        f.d f145j = new f.d(this, (d) null, (d) null);

        public e(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
            super(bigInteger);
            this.f143h = bigInteger;
            this.f144i = d.b.s(bigInteger);
            this.f128b = j(bigInteger2);
            this.f129c = j(bigInteger3);
            this.f130d = bigInteger4;
            this.f131e = bigInteger5;
            this.f132f = 4;
        }

        /* access modifiers changed from: protected */
        public c b() {
            return new e(this.f143h, this.f144i, this.f128b, this.f129c, this.f130d, this.f131e);
        }

        /* access modifiers changed from: protected */
        public f f(d dVar, d dVar2, boolean z10) {
            return new f.d(this, dVar, dVar2, z10);
        }

        public d j(BigInteger bigInteger) {
            return new d.b(this.f143h, this.f144i, bigInteger);
        }

        public int p() {
            return this.f143h.bitLength();
        }

        public f q() {
            return this.f145j;
        }

        public f s(f fVar) {
            int n10;
            if (this == fVar.g() || n() != 2 || fVar.o() || ((n10 = fVar.g().n()) != 2 && n10 != 3 && n10 != 4)) {
                return c.super.s(fVar);
            }
            return new f.d(this, j(fVar.f155b.r()), j(fVar.f156c.r()), new d[]{j(fVar.f157d[0].r())}, fVar.f158e);
        }

        public boolean v(int i10) {
            if (i10 == 0 || i10 == 1 || i10 == 2 || i10 == 4) {
                return true;
            }
            return false;
        }

        protected e(BigInteger bigInteger, BigInteger bigInteger2, d dVar, d dVar2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(bigInteger);
            this.f143h = bigInteger;
            this.f144i = bigInteger2;
            this.f128b = dVar;
            this.f129c = dVar2;
            this.f130d = bigInteger3;
            this.f131e = bigInteger4;
            this.f132f = 4;
        }
    }
}
