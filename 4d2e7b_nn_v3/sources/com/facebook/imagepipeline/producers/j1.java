package com.facebook.imagepipeline.producers;

import e5.j;
import kotlin.jvm.internal.m;

public final class j1 implements d1 {

    /* renamed from: a  reason: collision with root package name */
    private final d1 f20131a;

    private final class a extends t {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ j1 f20132c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(j1 j1Var, n nVar) {
            super(nVar);
            m.f(nVar, "consumer");
            this.f20132c = j1Var;
        }

        /* access modifiers changed from: protected */
        /* renamed from: p */
        public void h(j jVar, int i10) {
            c3.a aVar = null;
            try {
                if (j.J(jVar) && jVar != null) {
                    aVar = jVar.k();
                }
                o().c(aVar, i10);
                c3.a.m(aVar);
            } catch (Throwable th) {
                c3.a.m((c3.a) null);
                throw th;
            }
        }
    }

    public j1(d1 d1Var) {
        m.f(d1Var, "inputProducer");
        this.f20131a = d1Var;
    }

    public void b(n nVar, e1 e1Var) {
        m.f(nVar, "consumer");
        m.f(e1Var, "context");
        this.f20131a.b(new a(this, nVar), e1Var);
    }
}
