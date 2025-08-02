package com.facebook.imagepipeline.producers;

import e5.j;
import k5.b;

public class m implements d1 {

    /* renamed from: a  reason: collision with root package name */
    private final d1 f20163a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final d1 f20164b;

    private class a extends t {

        /* renamed from: c  reason: collision with root package name */
        private e1 f20165c;

        /* access modifiers changed from: protected */
        public void g(Throwable th) {
            m.this.f20164b.b(o(), this.f20165c);
        }

        /* access modifiers changed from: protected */
        /* renamed from: p */
        public void h(j jVar, int i10) {
            b b10 = this.f20165c.b();
            boolean d10 = c.d(i10);
            boolean c10 = v1.c(jVar, b10.q());
            if (jVar != null && (c10 || b10.i())) {
                if (!d10 || !c10) {
                    o().c(jVar, c.n(i10, 1));
                } else {
                    o().c(jVar, i10);
                }
            }
            if (d10 && !c10 && !b10.h()) {
                j.h(jVar);
                m.this.f20164b.b(o(), this.f20165c);
            }
        }

        private a(n nVar, e1 e1Var) {
            super(nVar);
            this.f20165c = e1Var;
        }
    }

    public m(d1 d1Var, d1 d1Var2) {
        this.f20163a = d1Var;
        this.f20164b = d1Var2;
    }

    public void b(n nVar, e1 e1Var) {
        this.f20163a.b(new a(nVar, e1Var), e1Var);
    }
}
