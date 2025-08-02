package com.facebook.imagepipeline.producers;

import e5.j;

public class b implements d1 {

    /* renamed from: a  reason: collision with root package name */
    private final d1 f20032a;

    private static class a extends t {
        /* access modifiers changed from: protected */
        /* renamed from: p */
        public void h(j jVar, int i10) {
            if (jVar == null) {
                o().c((Object) null, i10);
                return;
            }
            if (!j.H(jVar)) {
                jVar.K();
            }
            o().c(jVar, i10);
        }

        private a(n nVar) {
            super(nVar);
        }
    }

    public b(d1 d1Var) {
        this.f20032a = d1Var;
    }

    public void b(n nVar, e1 e1Var) {
        this.f20032a.b(new a(nVar), e1Var);
    }
}
