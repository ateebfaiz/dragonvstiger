package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.h;
import com.fasterxml.jackson.databind.ser.i;
import q8.g;
import t8.k;

public abstract class b extends h implements i {

    /* renamed from: c  reason: collision with root package name */
    protected final j f5521c;

    /* renamed from: d  reason: collision with root package name */
    protected final d f5522d;

    /* renamed from: e  reason: collision with root package name */
    protected final boolean f5523e;

    /* renamed from: f  reason: collision with root package name */
    protected final Boolean f5524f;

    /* renamed from: g  reason: collision with root package name */
    protected final g f5525g;

    /* renamed from: h  reason: collision with root package name */
    protected final o f5526h;

    /* renamed from: i  reason: collision with root package name */
    protected k f5527i;

    protected b(Class cls, j jVar, boolean z10, g gVar, o oVar) {
        this(cls, jVar, z10, gVar, (d) null, oVar, (Boolean) null);
    }

    /* access modifiers changed from: protected */
    public final o A(k kVar, Class cls, b0 b0Var) {
        k.d h10 = kVar.h(cls, b0Var, this.f5522d);
        k kVar2 = h10.f13099b;
        if (kVar != kVar2) {
            this.f5527i = kVar2;
        }
        return h10.f13098a;
    }

    /* access modifiers changed from: protected */
    public abstract void B(Object obj, f fVar, b0 b0Var);

    public abstract b C(d dVar, g gVar, o oVar, Boolean bool);

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0064 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.o a(com.fasterxml.jackson.databind.b0 r6, com.fasterxml.jackson.databind.d r7) {
        /*
            r5 = this;
            q8.g r0 = r5.f5525g
            if (r0 == 0) goto L_0x0008
            q8.g r0 = r0.a(r7)
        L_0x0008:
            r1 = 0
            if (r7 == 0) goto L_0x0020
            com.fasterxml.jackson.databind.b r2 = r6.L()
            com.fasterxml.jackson.databind.introspect.i r3 = r7.b()
            if (r3 == 0) goto L_0x0020
            java.lang.Object r2 = r2.f(r3)
            if (r2 == 0) goto L_0x0020
            com.fasterxml.jackson.databind.o r2 = r6.i0(r3, r2)
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
            com.fasterxml.jackson.databind.o r2 = r5.f5526h
        L_0x0035:
            com.fasterxml.jackson.databind.o r2 = r5.n(r6, r7, r2)
            if (r2 != 0) goto L_0x004f
            com.fasterxml.jackson.databind.j r3 = r5.f5521c
            if (r3 == 0) goto L_0x004f
            boolean r4 = r5.f5523e
            if (r4 == 0) goto L_0x004f
            boolean r3 = r3.H()
            if (r3 != 0) goto L_0x004f
            com.fasterxml.jackson.databind.j r2 = r5.f5521c
            com.fasterxml.jackson.databind.o r2 = r6.y(r2, r7)
        L_0x004f:
            com.fasterxml.jackson.databind.o r6 = r5.f5526h
            if (r2 != r6) goto L_0x0065
            com.fasterxml.jackson.databind.d r6 = r5.f5522d
            if (r7 != r6) goto L_0x0065
            q8.g r6 = r5.f5525g
            if (r6 != r0) goto L_0x0065
            java.lang.Boolean r6 = r5.f5524f
            boolean r6 = java.util.Objects.equals(r6, r1)
            if (r6 != 0) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            return r5
        L_0x0065:
            com.fasterxml.jackson.databind.ser.std.b r6 = r5.C(r7, r0, r2, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.b.a(com.fasterxml.jackson.databind.b0, com.fasterxml.jackson.databind.d):com.fasterxml.jackson.databind.o");
    }

    public void h(Object obj, f fVar, b0 b0Var, g gVar) {
        i8.b g10 = gVar.g(fVar, gVar.d(obj, com.fasterxml.jackson.core.k.START_ARRAY));
        fVar.B(obj);
        B(obj, fVar, b0Var);
        gVar.h(fVar, g10);
    }

    /* access modifiers changed from: protected */
    public final o z(k kVar, j jVar, b0 b0Var) {
        k.d g10 = kVar.g(jVar, b0Var, this.f5522d);
        k kVar2 = g10.f13099b;
        if (kVar != kVar2) {
            this.f5527i = kVar2;
        }
        return g10.f13098a;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected b(Class cls, j jVar, boolean z10, g gVar, d dVar, o oVar, Boolean bool) {
        super(cls, false);
        boolean z11 = false;
        this.f5521c = jVar;
        if (z10 || (jVar != null && jVar.F())) {
            z11 = true;
        }
        this.f5523e = z11;
        this.f5525g = gVar;
        this.f5522d = dVar;
        this.f5526h = oVar;
        this.f5527i = k.c();
        this.f5524f = bool;
    }

    protected b(b bVar, d dVar, g gVar, o oVar, Boolean bool) {
        super((h) bVar);
        this.f5521c = bVar.f5521c;
        this.f5523e = bVar.f5523e;
        this.f5525g = gVar;
        this.f5522d = dVar;
        this.f5526h = oVar;
        this.f5527i = k.c();
        this.f5524f = bool;
    }
}
