package com.bugsnag.android;

import c1.j;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    private final b0 f19113a = new b0();

    /* renamed from: b  reason: collision with root package name */
    private final y f19114b;

    /* renamed from: c  reason: collision with root package name */
    private final m0 f19115c;

    /* renamed from: d  reason: collision with root package name */
    private final BreadcrumbState f19116d;

    /* renamed from: e  reason: collision with root package name */
    private final z2 f19117e;

    /* renamed from: f  reason: collision with root package name */
    private final b2 f19118f;

    public x(j jVar, f0 f0Var) {
        y yVar = f0Var.f18730a.f18673c;
        this.f19114b = yVar;
        m0 m0Var = new m0();
        if (f0Var.f() != null) {
            m0Var.e(f0Var.f());
        }
        this.f19115c = m0Var;
        this.f19116d = new BreadcrumbState(jVar.s(), yVar, jVar.r());
        this.f19117e = a(f0Var);
        this.f19118f = f0Var.f18730a.f18675e.e();
    }

    private final z2 a(f0 f0Var) {
        return f0Var.f18730a.f18674d.f(f0Var.f18730a.f18674d.h().e());
    }

    public final BreadcrumbState b() {
        return this.f19116d;
    }

    public final y c() {
        return this.f19114b;
    }

    public final b0 d() {
        return this.f19113a;
    }

    public final m0 e() {
        return this.f19115c;
    }

    public final b2 f() {
        return this.f19118f;
    }

    public final z2 g() {
        return this.f19117e;
    }
}
