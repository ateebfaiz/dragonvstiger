package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.producers.u;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import k0.d;
import k0.f;
import k5.b;
import x4.j;
import x4.k;
import y2.g;

public class v implements d1 {

    /* renamed from: a  reason: collision with root package name */
    private final j f20279a;

    /* renamed from: b  reason: collision with root package name */
    private final j f20280b;

    /* renamed from: c  reason: collision with root package name */
    private final k f20281c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final d1 f20282d;

    /* renamed from: e  reason: collision with root package name */
    private final Map f20283e;

    class a implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g1 f20284a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e1 f20285b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ n f20286c;

        a(g1 g1Var, e1 e1Var, n nVar) {
            this.f20284a = g1Var;
            this.f20285b = e1Var;
            this.f20286c = nVar;
        }

        /* renamed from: b */
        public Void a(f fVar) {
            if (v.f(fVar)) {
                this.f20284a.d(this.f20285b, "DiskCacheProducer", (Map) null);
                this.f20286c.a();
            } else if (fVar.n()) {
                this.f20284a.k(this.f20285b, "DiskCacheProducer", fVar.i(), (Map) null);
                v.this.f20282d.b(this.f20286c, this.f20285b);
            } else {
                e5.j jVar = (e5.j) fVar.j();
                if (jVar != null) {
                    g1 g1Var = this.f20284a;
                    e1 e1Var = this.f20285b;
                    g1Var.j(e1Var, "DiskCacheProducer", v.e(g1Var, e1Var, true, jVar.A()));
                    this.f20284a.c(this.f20285b, "DiskCacheProducer", true);
                    this.f20285b.y("disk");
                    this.f20286c.b(1.0f);
                    this.f20286c.c(jVar, 1);
                    jVar.close();
                } else {
                    g1 g1Var2 = this.f20284a;
                    e1 e1Var2 = this.f20285b;
                    g1Var2.j(e1Var2, "DiskCacheProducer", v.e(g1Var2, e1Var2, false, 0));
                    v.this.f20282d.b(this.f20286c, this.f20285b);
                }
            }
            return null;
        }
    }

    class b extends f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f20288a;

        b(AtomicBoolean atomicBoolean) {
            this.f20288a = atomicBoolean;
        }

        public void a() {
            this.f20288a.set(true);
        }
    }

    public v(j jVar, j jVar2, Map map, k kVar, d1 d1Var) {
        this.f20279a = jVar;
        this.f20280b = jVar2;
        this.f20283e = map;
        this.f20281c = kVar;
        this.f20282d = d1Var;
    }

    static Map e(g1 g1Var, e1 e1Var, boolean z10, int i10) {
        if (!g1Var.g(e1Var, "DiskCacheProducer")) {
            return null;
        }
        if (z10) {
            return g.of("cached_value_found", String.valueOf(z10), "encodedImageSize", String.valueOf(i10));
        }
        return g.of("cached_value_found", String.valueOf(z10));
    }

    /* access modifiers changed from: private */
    public static boolean f(f fVar) {
        if (fVar.l() || (fVar.n() && (fVar.i() instanceof CancellationException))) {
            return true;
        }
        return false;
    }

    private void g(n nVar, e1 e1Var) {
        if (e1Var.B().b() >= b.c.DISK_CACHE.b()) {
            e1Var.k("disk", "nil-result_read");
            nVar.c((Object) null, 1);
            return;
        }
        this.f20282d.b(nVar, e1Var);
    }

    private d h(n nVar, e1 e1Var) {
        return new a(e1Var.z(), e1Var, nVar);
    }

    private void i(AtomicBoolean atomicBoolean, e1 e1Var) {
        e1Var.h(new b(atomicBoolean));
    }

    public void b(n nVar, e1 e1Var) {
        k5.b b10 = e1Var.b();
        if (!e1Var.b().x(16)) {
            g(nVar, e1Var);
            return;
        }
        e1Var.z().e(e1Var, "DiskCacheProducer");
        r2.d c10 = this.f20281c.c(b10, e1Var.a());
        j a10 = u.a(b10, this.f20280b, this.f20279a, this.f20283e);
        if (a10 == null) {
            g1 z10 = e1Var.z();
            z10.k(e1Var, "DiskCacheProducer", new u.a("Got no disk cache for CacheChoice: " + Integer.valueOf(b10.c().ordinal()).toString()), (Map) null);
            g(nVar, e1Var);
            return;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        a10.m(c10, atomicBoolean).e(h(nVar, e1Var));
        i(atomicBoolean, e1Var);
    }
}
