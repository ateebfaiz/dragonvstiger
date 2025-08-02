package com.facebook.imagepipeline.producers;

import e5.e;
import e5.o;
import java.util.Map;
import k5.b;
import l5.b;
import r2.d;
import x4.k;
import x4.x;
import y2.g;

public class i implements d1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final x f20108a;

    /* renamed from: b  reason: collision with root package name */
    private final k f20109b;

    /* renamed from: c  reason: collision with root package name */
    private final d1 f20110c;

    class a extends t {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f20111c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f20112d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(n nVar, d dVar, boolean z10) {
            super(nVar);
            this.f20111c = dVar;
            this.f20112d = z10;
        }

        /* renamed from: p */
        public void h(c3.a aVar, int i10) {
            c3.a aVar2;
            c3.a aVar3;
            try {
                if (b.d()) {
                    b.a("BitmapMemoryCacheProducer#onNewResultImpl");
                }
                boolean d10 = c.d(i10);
                aVar2 = null;
                if (aVar == null) {
                    if (d10) {
                        o().c((Object) null, i10);
                    }
                    if (b.d()) {
                        b.b();
                        return;
                    }
                    return;
                }
                if (!((e) aVar.p()).D()) {
                    if (!c.m(i10, 8)) {
                        if (!d10 && (aVar3 = i.this.f20108a.get(this.f20111c)) != null) {
                            o s10 = ((e) aVar.p()).s();
                            o s11 = ((e) aVar3.p()).s();
                            if (s11.a() || s11.c() >= s10.c()) {
                                o().c(aVar3, i10);
                                c3.a.m(aVar3);
                                if (b.d()) {
                                    b.b();
                                    return;
                                }
                                return;
                            }
                            c3.a.m(aVar3);
                        }
                        if (this.f20112d) {
                            aVar2 = i.this.f20108a.b(this.f20111c, aVar);
                        }
                        if (d10) {
                            o().b(1.0f);
                        }
                        n o10 = o();
                        if (aVar2 != null) {
                            aVar = aVar2;
                        }
                        o10.c(aVar, i10);
                        c3.a.m(aVar2);
                        if (b.d()) {
                            b.b();
                            return;
                        }
                        return;
                    }
                }
                o().c(aVar, i10);
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

    public i(x xVar, k kVar, d1 d1Var) {
        this.f20108a = xVar;
        this.f20109b = kVar;
        this.f20110c = d1Var;
    }

    private static void f(e5.k kVar, e1 e1Var) {
        e1Var.m(kVar.getExtras());
    }

    public void b(n nVar, e1 e1Var) {
        c3.a aVar;
        Map map;
        Map map2;
        try {
            if (b.d()) {
                b.a("BitmapMemoryCacheProducer#produceResults");
            }
            g1 z10 = e1Var.z();
            z10.e(e1Var, e());
            d d10 = this.f20109b.d(e1Var.b(), e1Var.a());
            Map map3 = null;
            if (e1Var.b().x(1)) {
                aVar = this.f20108a.get(d10);
            } else {
                aVar = null;
            }
            if (aVar != null) {
                f((e5.k) aVar.p(), e1Var);
                boolean a10 = ((e) aVar.p()).s().a();
                if (a10) {
                    String e10 = e();
                    if (z10.g(e1Var, e())) {
                        map2 = g.of("cached_value_found", "true");
                    } else {
                        map2 = null;
                    }
                    z10.j(e1Var, e10, map2);
                    z10.c(e1Var, e(), true);
                    e1Var.k("memory_bitmap", d());
                    nVar.b(1.0f);
                }
                nVar.c(aVar, c.k(a10));
                aVar.close();
                if (a10) {
                    if (b.d()) {
                        b.b();
                        return;
                    }
                    return;
                }
            }
            if (e1Var.B().b() >= b.c.BITMAP_MEMORY_CACHE.b()) {
                String e11 = e();
                if (z10.g(e1Var, e())) {
                    map = g.of("cached_value_found", "false");
                } else {
                    map = null;
                }
                z10.j(e1Var, e11, map);
                z10.c(e1Var, e(), false);
                e1Var.k("memory_bitmap", d());
                nVar.c((Object) null, 1);
                if (l5.b.d()) {
                    l5.b.b();
                    return;
                }
                return;
            }
            n g10 = g(nVar, d10, e1Var.b().x(2));
            String e12 = e();
            if (z10.g(e1Var, e())) {
                map3 = g.of("cached_value_found", "false");
            }
            z10.j(e1Var, e12, map3);
            if (l5.b.d()) {
                l5.b.a("mInputProducer.produceResult");
            }
            this.f20110c.b(g10, e1Var);
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
    public String d() {
        return "pipe_bg";
    }

    /* access modifiers changed from: protected */
    public String e() {
        return "BitmapMemoryCacheProducer";
    }

    /* access modifiers changed from: protected */
    public n g(n nVar, d dVar, boolean z10) {
        return new a(nVar, dVar, z10);
    }
}
