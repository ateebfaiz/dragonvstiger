package com.facebook.imagepipeline.producers;

import java.util.Map;
import k5.b;
import l5.b;
import x4.d;
import x4.j;
import x4.x;

public class k implements d1 {

    /* renamed from: a  reason: collision with root package name */
    private final x f20133a;

    /* renamed from: b  reason: collision with root package name */
    private final j f20134b;

    /* renamed from: c  reason: collision with root package name */
    private final j f20135c;

    /* renamed from: d  reason: collision with root package name */
    private final x4.k f20136d;

    /* renamed from: e  reason: collision with root package name */
    private final d1 f20137e;

    /* renamed from: f  reason: collision with root package name */
    private final d f20138f;

    /* renamed from: g  reason: collision with root package name */
    private final d f20139g;

    private static class a extends t {

        /* renamed from: c  reason: collision with root package name */
        private final e1 f20140c;

        /* renamed from: d  reason: collision with root package name */
        private final x f20141d;

        /* renamed from: e  reason: collision with root package name */
        private final j f20142e;

        /* renamed from: f  reason: collision with root package name */
        private final j f20143f;

        /* renamed from: g  reason: collision with root package name */
        private final x4.k f20144g;

        /* renamed from: h  reason: collision with root package name */
        private final d f20145h;

        /* renamed from: i  reason: collision with root package name */
        private final d f20146i;

        public a(n nVar, e1 e1Var, x xVar, j jVar, j jVar2, x4.k kVar, d dVar, d dVar2) {
            super(nVar);
            this.f20140c = e1Var;
            this.f20141d = xVar;
            this.f20142e = jVar;
            this.f20143f = jVar2;
            this.f20144g = kVar;
            this.f20145h = dVar;
            this.f20146i = dVar2;
        }

        /* renamed from: p */
        public void h(c3.a aVar, int i10) {
            j jVar;
            try {
                if (b.d()) {
                    b.a("BitmapProbeProducer#onNewResultImpl");
                }
                if (!c.e(i10) && aVar != null) {
                    if (!c.l(i10, 8)) {
                        k5.b b10 = this.f20140c.b();
                        r2.d c10 = this.f20144g.c(b10, this.f20140c.a());
                        String str = (String) this.f20140c.p("origin");
                        if (str != null && str.equals("memory_bitmap")) {
                            if (this.f20140c.j().F().C() && !this.f20145h.b(c10)) {
                                this.f20141d.c(c10);
                                this.f20145h.a(c10);
                            }
                            if (this.f20140c.j().F().A() && !this.f20146i.b(c10)) {
                                if (b10.c() == b.C0299b.SMALL) {
                                    jVar = this.f20143f;
                                } else {
                                    jVar = this.f20142e;
                                }
                                jVar.f(c10);
                                this.f20146i.a(c10);
                            }
                        }
                        o().c(aVar, i10);
                        if (l5.b.d()) {
                            l5.b.b();
                            return;
                        }
                        return;
                    }
                }
                o().c(aVar, i10);
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

    public k(x xVar, j jVar, j jVar2, x4.k kVar, d dVar, d dVar2, d1 d1Var) {
        this.f20133a = xVar;
        this.f20134b = jVar;
        this.f20135c = jVar2;
        this.f20136d = kVar;
        this.f20138f = dVar;
        this.f20139g = dVar2;
        this.f20137e = d1Var;
    }

    public void b(n nVar, e1 e1Var) {
        try {
            if (l5.b.d()) {
                l5.b.a("BitmapProbeProducer#produceResults");
            }
            g1 z10 = e1Var.z();
            z10.e(e1Var, c());
            a aVar = new a(nVar, e1Var, this.f20133a, this.f20134b, this.f20135c, this.f20136d, this.f20138f, this.f20139g);
            z10.j(e1Var, "BitmapProbeProducer", (Map) null);
            if (l5.b.d()) {
                l5.b.a("mInputProducer.produceResult");
            }
            this.f20137e.b(aVar, e1Var);
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
        return "BitmapProbeProducer";
    }
}
