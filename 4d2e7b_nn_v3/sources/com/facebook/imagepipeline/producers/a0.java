package com.facebook.imagepipeline.producers;

import java.util.Map;
import k5.b;
import l5.b;
import q4.c;
import x4.d;
import x4.j;
import x4.k;

public class a0 implements d1 {

    /* renamed from: a  reason: collision with root package name */
    private final j f20013a;

    /* renamed from: b  reason: collision with root package name */
    private final j f20014b;

    /* renamed from: c  reason: collision with root package name */
    private final k f20015c;

    /* renamed from: d  reason: collision with root package name */
    private final d1 f20016d;

    /* renamed from: e  reason: collision with root package name */
    private final d f20017e;

    /* renamed from: f  reason: collision with root package name */
    private final d f20018f;

    private static class a extends t {

        /* renamed from: c  reason: collision with root package name */
        private final e1 f20019c;

        /* renamed from: d  reason: collision with root package name */
        private final j f20020d;

        /* renamed from: e  reason: collision with root package name */
        private final j f20021e;

        /* renamed from: f  reason: collision with root package name */
        private final k f20022f;

        /* renamed from: g  reason: collision with root package name */
        private final d f20023g;

        /* renamed from: h  reason: collision with root package name */
        private final d f20024h;

        public a(n nVar, e1 e1Var, j jVar, j jVar2, k kVar, d dVar, d dVar2) {
            super(nVar);
            this.f20019c = e1Var;
            this.f20020d = jVar;
            this.f20021e = jVar2;
            this.f20022f = kVar;
            this.f20023g = dVar;
            this.f20024h = dVar2;
        }

        /* renamed from: p */
        public void h(e5.j jVar, int i10) {
            j jVar2;
            try {
                if (b.d()) {
                    b.a("EncodedProbeProducer#onNewResultImpl");
                }
                if (!c.e(i10) && jVar != null && !c.l(i10, 10)) {
                    if (jVar.v() != c.f23230d) {
                        k5.b b10 = this.f20019c.b();
                        r2.d c10 = this.f20022f.c(b10, this.f20019c.a());
                        this.f20023g.a(c10);
                        if ("memory_encoded".equals(this.f20019c.p("origin"))) {
                            if (!this.f20024h.b(c10)) {
                                if (b10.c() == b.C0299b.SMALL) {
                                    jVar2 = this.f20021e;
                                } else {
                                    jVar2 = this.f20020d;
                                }
                                jVar2.f(c10);
                                this.f20024h.a(c10);
                            }
                        } else if ("disk".equals(this.f20019c.p("origin"))) {
                            this.f20024h.a(c10);
                        }
                        o().c(jVar, i10);
                        if (l5.b.d()) {
                            l5.b.b();
                            return;
                        }
                        return;
                    }
                }
                o().c(jVar, i10);
                if (l5.b.d()) {
                    l5.b.b();
                }
            } catch (Throwable th) {
                if (l5.b.d()) {
                    l5.b.b();
                }
                throw th;
            }
        }
    }

    public a0(j jVar, j jVar2, k kVar, d dVar, d dVar2, d1 d1Var) {
        this.f20013a = jVar;
        this.f20014b = jVar2;
        this.f20015c = kVar;
        this.f20017e = dVar;
        this.f20018f = dVar2;
        this.f20016d = d1Var;
    }

    public void b(n nVar, e1 e1Var) {
        try {
            if (l5.b.d()) {
                l5.b.a("EncodedProbeProducer#produceResults");
            }
            g1 z10 = e1Var.z();
            z10.e(e1Var, c());
            a aVar = new a(nVar, e1Var, this.f20013a, this.f20014b, this.f20015c, this.f20017e, this.f20018f);
            z10.j(e1Var, "EncodedProbeProducer", (Map) null);
            if (l5.b.d()) {
                l5.b.a("mInputProducer.produceResult");
            }
            this.f20016d.b(aVar, e1Var);
            if (l5.b.d()) {
                l5.b.b();
            }
            if (l5.b.d()) {
                l5.b.b();
            }
        } catch (Throwable th) {
            if (l5.b.d()) {
                l5.b.b();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public String c() {
        return "EncodedProbeProducer";
    }
}
