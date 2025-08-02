package com.facebook.imagepipeline.producers;

import android.util.Pair;
import e5.j;
import x4.k;

public class y extends u0 {

    /* renamed from: f  reason: collision with root package name */
    private final k f20306f;

    public y(k kVar, boolean z10, d1 d1Var) {
        super(d1Var, "EncodedCacheKeyMultiplexProducer", "multiplex_enc_cnt", z10);
        this.f20306f = kVar;
    }

    /* renamed from: l */
    public j g(j jVar) {
        return j.b(jVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public Pair j(e1 e1Var) {
        return Pair.create(this.f20306f.c(e1Var.b(), e1Var.a()), e1Var.B());
    }
}
