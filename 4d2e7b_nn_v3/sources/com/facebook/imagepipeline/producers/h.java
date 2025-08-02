package com.facebook.imagepipeline.producers;

import android.util.Pair;
import c3.a;
import x4.k;

public class h extends u0 {

    /* renamed from: f  reason: collision with root package name */
    private final k f20105f;

    public h(k kVar, d1 d1Var) {
        super(d1Var, "BitmapMemoryCacheKeyMultiplexProducer", "multiplex_bmp_cnt");
        this.f20105f = kVar;
    }

    /* renamed from: l */
    public a g(a aVar) {
        return a.j(aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public Pair j(e1 e1Var) {
        return Pair.create(this.f20105f.d(e1Var.b(), e1Var.a()), e1Var.B());
    }
}
