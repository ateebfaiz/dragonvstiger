package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.introspect.s;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.q;
import com.fasterxml.jackson.databind.ser.i;
import com.fasterxml.jackson.databind.util.l;
import com.fasterxml.jackson.databind.y;
import k8.e;
import q8.g;
import t8.k;

public abstract class z extends h0 implements i {

    /* renamed from: w  reason: collision with root package name */
    public static final Object f5602w = p.a.NON_EMPTY;

    /* renamed from: c  reason: collision with root package name */
    protected final j f5603c;

    /* renamed from: d  reason: collision with root package name */
    protected final d f5604d;

    /* renamed from: e  reason: collision with root package name */
    protected final g f5605e;

    /* renamed from: f  reason: collision with root package name */
    protected final o f5606f;

    /* renamed from: g  reason: collision with root package name */
    protected final l f5607g;

    /* renamed from: h  reason: collision with root package name */
    protected transient k f5608h;

    /* renamed from: i  reason: collision with root package name */
    protected final Object f5609i;

    /* renamed from: j  reason: collision with root package name */
    protected final boolean f5610j;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5611a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.fasterxml.jackson.annotation.p$a[] r0 = com.fasterxml.jackson.annotation.p.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5611a = r0
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.NON_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5611a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.NON_ABSENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5611a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.NON_EMPTY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5611a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f5611a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.NON_NULL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f5611a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.ALWAYS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.z.a.<clinit>():void");
        }
    }

    public z(com.fasterxml.jackson.databind.type.j jVar, boolean z10, g gVar, o oVar) {
        super((j) jVar);
        this.f5603c = jVar.b();
        this.f5604d = null;
        this.f5605e = gVar;
        this.f5606f = oVar;
        this.f5607g = null;
        this.f5609i = null;
        this.f5610j = false;
        this.f5608h = k.c();
    }

    private final o x(b0 b0Var, Class cls) {
        o oVar;
        o j10 = this.f5608h.j(cls);
        if (j10 != null) {
            return j10;
        }
        if (this.f5603c.x()) {
            oVar = b0Var.F(b0Var.t(this.f5603c, cls), this.f5604d);
        } else {
            oVar = b0Var.G(cls, this.f5604d);
        }
        l lVar = this.f5607g;
        if (lVar != null) {
            oVar = oVar.i(lVar);
        }
        o oVar2 = oVar;
        this.f5608h = this.f5608h.i(cls, oVar2);
        return oVar2;
    }

    private final o y(b0 b0Var, j jVar, d dVar) {
        return b0Var.F(jVar, dVar);
    }

    /* access modifiers changed from: protected */
    public abstract Object A(Object obj);

    /* access modifiers changed from: protected */
    public abstract boolean B(Object obj);

    /* access modifiers changed from: protected */
    public boolean C(b0 b0Var, d dVar, j jVar) {
        if (jVar.H()) {
            return false;
        }
        if (jVar.F() || jVar.O()) {
            return true;
        }
        b L = b0Var.L();
        if (!(L == null || dVar == null || dVar.b() == null)) {
            e.b P = L.P(dVar.b());
            if (P == e.b.STATIC) {
                return true;
            }
            if (P == e.b.DYNAMIC) {
                return false;
            }
        }
        return b0Var.a0(q.USE_STATIC_TYPING);
    }

    public abstract z D(Object obj, boolean z10);

    /* access modifiers changed from: protected */
    public abstract z E(d dVar, g gVar, o oVar, l lVar);

    public o a(b0 b0Var, d dVar) {
        z zVar;
        p.b c10;
        p.a f10;
        Object obj;
        g gVar = this.f5605e;
        if (gVar != null) {
            gVar = gVar.a(dVar);
        }
        o m10 = m(b0Var, dVar);
        if (m10 == null) {
            m10 = this.f5606f;
            if (m10 != null) {
                m10 = b0Var.W(m10, dVar);
            } else if (C(b0Var, dVar, this.f5603c)) {
                m10 = y(b0Var, this.f5603c, dVar);
            }
        }
        if (this.f5604d == dVar && this.f5605e == gVar && this.f5606f == m10) {
            zVar = this;
        } else {
            zVar = E(dVar, gVar, m10, this.f5607g);
        }
        if (dVar == null || (c10 = dVar.c(b0Var.f(), c())) == null || (f10 = c10.f()) == p.a.USE_DEFAULTS) {
            return zVar;
        }
        int i10 = a.f5611a[f10.ordinal()];
        boolean z10 = true;
        if (i10 != 1) {
            obj = null;
            if (i10 != 2) {
                if (i10 == 3) {
                    obj = f5602w;
                } else if (i10 == 4) {
                    obj = b0Var.Y((s) null, c10.e());
                    if (obj != null) {
                        z10 = b0Var.Z(obj);
                    }
                } else if (i10 != 5) {
                    z10 = false;
                }
            } else if (this.f5603c.d()) {
                obj = f5602w;
            }
        } else {
            obj = com.fasterxml.jackson.databind.util.d.b(this.f5603c);
            if (obj != null && obj.getClass().isArray()) {
                obj = com.fasterxml.jackson.databind.util.b.a(obj);
            }
        }
        if (this.f5609i == obj && this.f5610j == z10) {
            return zVar;
        }
        return zVar.D(obj, z10);
    }

    public boolean d(b0 b0Var, Object obj) {
        if (!B(obj)) {
            return true;
        }
        Object z10 = z(obj);
        if (z10 == null) {
            return this.f5610j;
        }
        if (this.f5609i == null) {
            return false;
        }
        o oVar = this.f5606f;
        if (oVar == null) {
            try {
                oVar = x(b0Var, z10.getClass());
            } catch (com.fasterxml.jackson.databind.l e10) {
                throw new y(e10);
            }
        }
        Object obj2 = this.f5609i;
        if (obj2 == f5602w) {
            return oVar.d(b0Var, z10);
        }
        return obj2.equals(z10);
    }

    public boolean e() {
        if (this.f5607g != null) {
            return true;
        }
        return false;
    }

    public void f(Object obj, f fVar, b0 b0Var) {
        Object A = A(obj);
        if (A != null) {
            o oVar = this.f5606f;
            if (oVar == null) {
                oVar = x(b0Var, A.getClass());
            }
            g gVar = this.f5605e;
            if (gVar != null) {
                oVar.h(A, fVar, b0Var, gVar);
            } else {
                oVar.f(A, fVar, b0Var);
            }
        } else if (this.f5607g == null) {
            b0Var.x(fVar);
        }
    }

    public void h(Object obj, f fVar, b0 b0Var, g gVar) {
        Object A = A(obj);
        if (A != null) {
            o oVar = this.f5606f;
            if (oVar == null) {
                oVar = x(b0Var, A.getClass());
            }
            oVar.h(A, fVar, b0Var, gVar);
        } else if (this.f5607g == null) {
            b0Var.x(fVar);
        }
    }

    public o i(l lVar) {
        o oVar = this.f5606f;
        if (oVar != null && (oVar = oVar.i(lVar)) == this.f5606f) {
            return this;
        }
        l lVar2 = this.f5607g;
        if (lVar2 != null) {
            lVar = l.a(lVar, lVar2);
        }
        if (this.f5606f == oVar && this.f5607g == lVar) {
            return this;
        }
        return E(this.f5604d, this.f5605e, oVar, lVar);
    }

    /* access modifiers changed from: protected */
    public abstract Object z(Object obj);

    protected z(z zVar, d dVar, g gVar, o oVar, l lVar, Object obj, boolean z10) {
        super((h0) zVar);
        this.f5603c = zVar.f5603c;
        this.f5608h = k.c();
        this.f5604d = dVar;
        this.f5605e = gVar;
        this.f5606f = oVar;
        this.f5607g = lVar;
        this.f5609i = obj;
        this.f5610j = z10;
    }
}
