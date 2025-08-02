package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.h;
import com.fasterxml.jackson.databind.ser.i;
import java.util.Objects;
import q8.g;
import t8.k;

public class x extends a implements i {

    /* renamed from: e  reason: collision with root package name */
    protected final boolean f5597e;

    /* renamed from: f  reason: collision with root package name */
    protected final j f5598f;

    /* renamed from: g  reason: collision with root package name */
    protected final g f5599g;

    /* renamed from: h  reason: collision with root package name */
    protected o f5600h;

    /* renamed from: i  reason: collision with root package name */
    protected k f5601i = k.c();

    public x(j jVar, boolean z10, g gVar, o oVar) {
        super(Object[].class);
        this.f5598f = jVar;
        this.f5597e = z10;
        this.f5599g = gVar;
        this.f5600h = oVar;
    }

    public o A(d dVar, Boolean bool) {
        return new x(this, dVar, this.f5599g, this.f5600h, bool);
    }

    /* access modifiers changed from: protected */
    public final o C(k kVar, j jVar, b0 b0Var) {
        k.d g10 = kVar.g(jVar, b0Var, this.f5518c);
        k kVar2 = g10.f13099b;
        if (kVar != kVar2) {
            this.f5601i = kVar2;
        }
        return g10.f13098a;
    }

    /* access modifiers changed from: protected */
    public final o D(k kVar, Class cls, b0 b0Var) {
        k.d h10 = kVar.h(cls, b0Var, this.f5518c);
        k kVar2 = h10.f13099b;
        if (kVar != kVar2) {
            this.f5601i = kVar2;
        }
        return h10.f13098a;
    }

    /* renamed from: E */
    public boolean d(b0 b0Var, Object[] objArr) {
        if (objArr.length == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: F */
    public final void f(Object[] objArr, f fVar, b0 b0Var) {
        int length = objArr.length;
        if (length != 1 || ((this.f5519d != null || !b0Var.b0(a0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this.f5519d != Boolean.TRUE)) {
            fVar.n0(objArr, length);
            B(objArr, fVar, b0Var);
            fVar.P();
            return;
        }
        B(objArr, fVar, b0Var);
    }

    /* renamed from: G */
    public void B(Object[] objArr, f fVar, b0 b0Var) {
        if (r0 != 0) {
            o oVar = this.f5600h;
            if (oVar != null) {
                H(objArr, fVar, b0Var, oVar);
            } else if (this.f5599g != null) {
                I(objArr, fVar, b0Var);
            } else {
                try {
                    k kVar = this.f5601i;
                    for (Object obj : objArr) {
                        if (obj == null) {
                            b0Var.x(fVar);
                        } else {
                            Class<?> cls = obj.getClass();
                            o j10 = kVar.j(cls);
                            if (j10 == null) {
                                if (this.f5598f.x()) {
                                    j10 = C(kVar, b0Var.t(this.f5598f, cls), b0Var);
                                } else {
                                    j10 = D(kVar, cls, b0Var);
                                }
                            }
                            j10.f(obj, fVar, b0Var);
                        }
                    }
                } catch (Exception e10) {
                    v(b0Var, e10, (Object) null, 0);
                }
            }
        }
    }

    public void H(Object[] objArr, f fVar, b0 b0Var, o oVar) {
        int length = objArr.length;
        g gVar = this.f5599g;
        int i10 = 0;
        Object obj = null;
        while (i10 < length) {
            try {
                obj = objArr[i10];
                if (obj == null) {
                    b0Var.x(fVar);
                } else if (gVar == null) {
                    oVar.f(obj, fVar, b0Var);
                } else {
                    oVar.h(obj, fVar, b0Var, gVar);
                }
                i10++;
            } catch (Exception e10) {
                v(b0Var, e10, obj, i10);
                return;
            }
        }
    }

    public void I(Object[] objArr, f fVar, b0 b0Var) {
        g gVar = this.f5599g;
        try {
            k kVar = this.f5601i;
            for (Object obj : objArr) {
                if (obj == null) {
                    b0Var.x(fVar);
                } else {
                    Class<?> cls = obj.getClass();
                    o j10 = kVar.j(cls);
                    if (j10 == null) {
                        j10 = D(kVar, cls, b0Var);
                    }
                    j10.h(obj, fVar, b0Var, gVar);
                }
            }
        } catch (Exception e10) {
            v(b0Var, e10, (Object) null, 0);
        }
    }

    public x J(d dVar, g gVar, o oVar, Boolean bool) {
        if (this.f5518c == dVar && oVar == this.f5600h && this.f5599g == gVar && Objects.equals(this.f5519d, bool)) {
            return this;
        }
        return new x(this, dVar, gVar, oVar, bool);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.o a(com.fasterxml.jackson.databind.b0 r6, com.fasterxml.jackson.databind.d r7) {
        /*
            r5 = this;
            q8.g r0 = r5.f5599g
            if (r0 == 0) goto L_0x0008
            q8.g r0 = r0.a(r7)
        L_0x0008:
            r1 = 0
            if (r7 == 0) goto L_0x0020
            com.fasterxml.jackson.databind.introspect.i r2 = r7.b()
            com.fasterxml.jackson.databind.b r3 = r6.L()
            if (r2 == 0) goto L_0x0020
            java.lang.Object r3 = r3.f(r2)
            if (r3 == 0) goto L_0x0020
            com.fasterxml.jackson.databind.o r2 = r6.i0(r2, r3)
            goto L_0x0021
        L_0x0020:
            r2 = r1
        L_0x0021:
            java.lang.Class r3 = r5.c()
            com.fasterxml.jackson.annotation.i$d r3 = r5.q(r6, r7, r3)
            if (r3 == 0) goto L_0x0031
            com.fasterxml.jackson.annotation.i$a r1 = com.fasterxml.jackson.annotation.i.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            java.lang.Boolean r1 = r3.e(r1)
        L_0x0031:
            if (r2 != 0) goto L_0x0035
            com.fasterxml.jackson.databind.o r2 = r5.f5600h
        L_0x0035:
            com.fasterxml.jackson.databind.o r2 = r5.n(r6, r7, r2)
            if (r2 != 0) goto L_0x004f
            com.fasterxml.jackson.databind.j r3 = r5.f5598f
            if (r3 == 0) goto L_0x004f
            boolean r4 = r5.f5597e
            if (r4 == 0) goto L_0x004f
            boolean r3 = r3.H()
            if (r3 != 0) goto L_0x004f
            com.fasterxml.jackson.databind.j r2 = r5.f5598f
            com.fasterxml.jackson.databind.o r2 = r6.y(r2, r7)
        L_0x004f:
            com.fasterxml.jackson.databind.ser.std.x r6 = r5.J(r7, r0, r2, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.x.a(com.fasterxml.jackson.databind.b0, com.fasterxml.jackson.databind.d):com.fasterxml.jackson.databind.o");
    }

    public h x(g gVar) {
        return new x(this.f5598f, this.f5597e, gVar, this.f5600h);
    }

    public x(x xVar, d dVar, g gVar, o oVar, Boolean bool) {
        super(xVar, dVar, bool);
        this.f5598f = xVar.f5598f;
        this.f5599g = gVar;
        this.f5597e = xVar.f5597e;
        this.f5600h = oVar;
    }
}
