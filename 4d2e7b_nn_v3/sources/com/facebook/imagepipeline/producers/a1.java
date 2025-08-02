package com.facebook.imagepipeline.producers;

import java.util.Map;
import k5.b;
import r2.d;
import x4.k;
import x4.x;
import y2.g;

public class a1 implements d1 {

    /* renamed from: a  reason: collision with root package name */
    private final x f20025a;

    /* renamed from: b  reason: collision with root package name */
    private final k f20026b;

    /* renamed from: c  reason: collision with root package name */
    private final d1 f20027c;

    public static class a extends t {

        /* renamed from: c  reason: collision with root package name */
        private final d f20028c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f20029d;

        /* renamed from: e  reason: collision with root package name */
        private final x f20030e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f20031f;

        public a(n nVar, d dVar, boolean z10, x xVar, boolean z11) {
            super(nVar);
            this.f20028c = dVar;
            this.f20029d = z10;
            this.f20030e = xVar;
            this.f20031f = z11;
        }

        /* access modifiers changed from: protected */
        /* renamed from: p */
        public void h(c3.a aVar, int i10) {
            c3.a aVar2 = null;
            if (aVar == null) {
                if (c.d(i10)) {
                    o().c(aVar2, i10);
                }
            } else if (!c.e(i10) || this.f20029d) {
                if (this.f20031f) {
                    aVar2 = this.f20030e.b(this.f20028c, aVar);
                }
                try {
                    o().b(1.0f);
                    n o10 = o();
                    if (aVar2 != null) {
                        aVar = aVar2;
                    }
                    o10.c(aVar, i10);
                } finally {
                    c3.a.m(aVar2);
                }
            }
        }
    }

    public a1(x xVar, k kVar, d1 d1Var) {
        this.f20025a = xVar;
        this.f20026b = kVar;
        this.f20027c = d1Var;
    }

    public void b(n nVar, e1 e1Var) {
        c3.a aVar;
        g1 z10 = e1Var.z();
        b b10 = e1Var.b();
        Object a10 = e1Var.a();
        k5.d k10 = b10.k();
        if (k10 == null || k10.b() == null) {
            this.f20027c.b(nVar, e1Var);
            return;
        }
        z10.e(e1Var, c());
        d b11 = this.f20026b.b(b10, a10);
        Map map = null;
        if (e1Var.b().x(1)) {
            aVar = this.f20025a.get(b11);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            String c10 = c();
            if (z10.g(e1Var, c())) {
                map = g.of("cached_value_found", "true");
            }
            z10.j(e1Var, c10, map);
            z10.c(e1Var, "PostprocessedBitmapMemoryCacheProducer", true);
            e1Var.k("memory_bitmap", "postprocessed");
            nVar.b(1.0f);
            nVar.c(aVar, 1);
            aVar.close();
            return;
        }
        a aVar2 = new a(nVar, b11, false, this.f20025a, e1Var.b().x(2));
        String c11 = c();
        if (z10.g(e1Var, c())) {
            map = g.of("cached_value_found", "false");
        }
        z10.j(e1Var, c11, map);
        this.f20027c.b(aVar2, e1Var);
    }

    /* access modifiers changed from: protected */
    public String c() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
