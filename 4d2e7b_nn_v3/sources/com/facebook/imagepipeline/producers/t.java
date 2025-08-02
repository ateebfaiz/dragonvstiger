package com.facebook.imagepipeline.producers;

import kotlin.jvm.internal.m;

public abstract class t extends c {

    /* renamed from: b  reason: collision with root package name */
    private final n f20248b;

    public t(n nVar) {
        m.f(nVar, "consumer");
        this.f20248b = nVar;
    }

    /* access modifiers changed from: protected */
    public void f() {
        this.f20248b.a();
    }

    /* access modifiers changed from: protected */
    public void g(Throwable th) {
        m.f(th, "t");
        this.f20248b.onFailure(th);
    }

    /* access modifiers changed from: protected */
    public void i(float f10) {
        this.f20248b.b(f10);
    }

    public final n o() {
        return this.f20248b;
    }
}
