package com.facebook.imagepipeline.producers;

import e5.j;
import java.util.Map;
import k5.b;
import l5.b;
import q4.c;
import r2.d;
import x4.k;
import x4.x;
import y2.g;

public class z implements d1 {

    /* renamed from: a  reason: collision with root package name */
    private final x f20325a;

    /* renamed from: b  reason: collision with root package name */
    private final k f20326b;

    /* renamed from: c  reason: collision with root package name */
    private final d1 f20327c;

    private static class a extends t {

        /* renamed from: c  reason: collision with root package name */
        private final x f20328c;

        /* renamed from: d  reason: collision with root package name */
        private final d f20329d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f20330e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f20331f;

        public a(n nVar, x xVar, d dVar, boolean z10, boolean z11) {
            super(nVar);
            this.f20328c = xVar;
            this.f20329d = dVar;
            this.f20330e = z10;
            this.f20331f = z11;
        }

        /* renamed from: p */
        public void h(j jVar, int i10) {
            c3.a k10;
            c3.a aVar;
            j jVar2;
            try {
                if (b.d()) {
                    b.a("EncodedMemoryCacheProducer#onNewResultImpl");
                }
                if (!c.e(i10) && jVar != null && !c.l(i10, 10)) {
                    if (jVar.v() != c.f23230d) {
                        k10 = jVar.k();
                        if (k10 != null) {
                            if (!this.f20331f || !this.f20330e) {
                                aVar = null;
                            } else {
                                aVar = this.f20328c.b(this.f20329d, k10);
                            }
                            c3.a.m(k10);
                            if (aVar != null) {
                                jVar2 = new j(aVar);
                                jVar2.j(jVar);
                                c3.a.m(aVar);
                                o().b(1.0f);
                                o().c(jVar2, i10);
                                j.h(jVar2);
                                if (b.d()) {
                                    b.b();
                                    return;
                                }
                                return;
                            }
                        }
                        o().c(jVar, i10);
                        if (b.d()) {
                            b.b();
                            return;
                        }
                        return;
                    }
                }
                o().c(jVar, i10);
                if (b.d()) {
                    b.b();
                }
            } catch (Throwable th) {
                if (b.d()) {
                    b.b();
                }
                throw th;
            }
        }
    }

    public z(x xVar, k kVar, d1 d1Var) {
        this.f20325a = xVar;
        this.f20326b = kVar;
        this.f20327c = d1Var;
    }

    public void b(n nVar, e1 e1Var) {
        c3.a aVar;
        Map map;
        j jVar;
        try {
            if (b.d()) {
                b.a("EncodedMemoryCacheProducer#produceResults");
            }
            g1 z10 = e1Var.z();
            z10.e(e1Var, "EncodedMemoryCacheProducer");
            d c10 = this.f20326b.c(e1Var.b(), e1Var.a());
            Map map2 = null;
            if (e1Var.b().x(4)) {
                aVar = this.f20325a.get(c10);
            } else {
                aVar = null;
            }
            if (aVar != null) {
                try {
                    jVar = new j(aVar);
                    if (z10.g(e1Var, "EncodedMemoryCacheProducer")) {
                        map2 = g.of("cached_value_found", "true");
                    }
                    z10.j(e1Var, "EncodedMemoryCacheProducer", map2);
                    z10.c(e1Var, "EncodedMemoryCacheProducer", true);
                    e1Var.y("memory_encoded");
                    nVar.b(1.0f);
                    nVar.c(jVar, 1);
                    j.h(jVar);
                    c3.a.m(aVar);
                    if (b.d()) {
                        b.b();
                    }
                } catch (Throwable th) {
                    c3.a.m(aVar);
                    throw th;
                }
            } else if (e1Var.B().b() >= b.c.ENCODED_MEMORY_CACHE.b()) {
                if (z10.g(e1Var, "EncodedMemoryCacheProducer")) {
                    map = g.of("cached_value_found", "false");
                } else {
                    map = null;
                }
                z10.j(e1Var, "EncodedMemoryCacheProducer", map);
                z10.c(e1Var, "EncodedMemoryCacheProducer", false);
                e1Var.k("memory_encoded", "nil-result");
                nVar.c((Object) null, 1);
                c3.a.m(aVar);
                if (l5.b.d()) {
                    l5.b.b();
                }
            } else {
                a aVar2 = new a(nVar, this.f20325a, c10, e1Var.b().x(8), e1Var.j().F().B());
                if (z10.g(e1Var, "EncodedMemoryCacheProducer")) {
                    map2 = g.of("cached_value_found", "false");
                }
                z10.j(e1Var, "EncodedMemoryCacheProducer", map2);
                this.f20327c.b(aVar2, e1Var);
                c3.a.m(aVar);
                if (l5.b.d()) {
                    l5.b.b();
                }
            }
        } catch (Throwable th2) {
            if (l5.b.d()) {
                l5.b.b();
            }
            throw th2;
        }
    }
}
