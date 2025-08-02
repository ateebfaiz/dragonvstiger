package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.producers.u;
import java.util.Map;
import k5.b;
import q4.c;
import r2.d;
import x4.j;
import x4.k;

public class x implements d1 {

    /* renamed from: a  reason: collision with root package name */
    private final j f20296a;

    /* renamed from: b  reason: collision with root package name */
    private final j f20297b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f20298c;

    /* renamed from: d  reason: collision with root package name */
    private final k f20299d;

    /* renamed from: e  reason: collision with root package name */
    private final d1 f20300e;

    private static class a extends t {

        /* renamed from: c  reason: collision with root package name */
        private final e1 f20301c;

        /* renamed from: d  reason: collision with root package name */
        private final j f20302d;

        /* renamed from: e  reason: collision with root package name */
        private final j f20303e;

        /* renamed from: f  reason: collision with root package name */
        private final Map f20304f;

        /* renamed from: g  reason: collision with root package name */
        private final k f20305g;

        /* renamed from: p */
        public void h(e5.j jVar, int i10) {
            this.f20301c.z().e(this.f20301c, "DiskCacheWriteProducer");
            if (c.e(i10) || jVar == null || c.l(i10, 10) || jVar.v() == c.f23230d) {
                this.f20301c.z().j(this.f20301c, "DiskCacheWriteProducer", (Map) null);
                o().c(jVar, i10);
                return;
            }
            b b10 = this.f20301c.b();
            d c10 = this.f20305g.c(b10, this.f20301c.a());
            j a10 = u.a(b10, this.f20303e, this.f20302d, this.f20304f);
            if (a10 == null) {
                g1 z10 = this.f20301c.z();
                e1 e1Var = this.f20301c;
                z10.k(e1Var, "DiskCacheWriteProducer", new u.a("Got no disk cache for CacheChoice: " + Integer.valueOf(b10.c().ordinal()).toString()), (Map) null);
                o().c(jVar, i10);
                return;
            }
            a10.p(c10, jVar);
            this.f20301c.z().j(this.f20301c, "DiskCacheWriteProducer", (Map) null);
            o().c(jVar, i10);
        }

        private a(n nVar, e1 e1Var, j jVar, j jVar2, Map map, k kVar) {
            super(nVar);
            this.f20301c = e1Var;
            this.f20302d = jVar;
            this.f20303e = jVar2;
            this.f20304f = map;
            this.f20305g = kVar;
        }
    }

    public x(j jVar, j jVar2, Map map, k kVar, d1 d1Var) {
        this.f20296a = jVar;
        this.f20297b = jVar2;
        this.f20298c = map;
        this.f20299d = kVar;
        this.f20300e = d1Var;
    }

    private void c(n nVar, e1 e1Var) {
        if (e1Var.B().b() >= b.c.DISK_CACHE.b()) {
            e1Var.k("disk", "nil-result_write");
            nVar.c((Object) null, 1);
            return;
        }
        if (e1Var.b().x(32)) {
            nVar = new a(nVar, e1Var, this.f20296a, this.f20297b, this.f20298c, this.f20299d);
        }
        this.f20300e.b(nVar, e1Var);
    }

    public void b(n nVar, e1 e1Var) {
        c(nVar, e1Var);
    }
}
