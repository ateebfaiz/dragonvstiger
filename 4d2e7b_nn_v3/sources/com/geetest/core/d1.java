package com.geetest.core;

public abstract class d1 {

    /* renamed from: a  reason: collision with root package name */
    public final Class f5951a;

    public d1(Class cls, int i10) {
        this.f5951a = cls;
    }

    public abstract p0 a(d2 d2Var);

    public final p0 a(p0 p0Var) {
        if (this.f5951a.isInstance(p0Var)) {
            return p0Var;
        }
        throw new IllegalStateException("unexpected object: " + p0Var.getClass().getName());
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public p0 a(s0 s0Var) {
        throw new IllegalStateException("unexpected implicit constructed encoding");
    }

    public final p0 a(z0 z0Var, boolean z10) {
        p0 p0Var;
        z0 a10 = c.a(z0Var);
        if (z10) {
            if (a10.l()) {
                p0Var = a(a10.f6229d.d());
            } else {
                throw new IllegalStateException("object explicit - implicit expected.");
            }
        } else if (1 != a10.f6226a) {
            p0 d10 = a10.f6229d.d();
            int i10 = a10.f6226a;
            if (i10 == 3) {
                p0Var = a(a10.c(d10));
            } else if (i10 != 4) {
                p0Var = a(d10);
            } else if (d10 instanceof s0) {
                p0Var = a((s0) d10);
            } else {
                p0Var = a((d2) d10);
            }
        } else {
            throw new IllegalStateException("object explicit - implicit expected.");
        }
        return a(p0Var);
    }
}
