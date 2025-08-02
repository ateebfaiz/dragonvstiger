package com.facebook.imagepipeline.producers;

import android.net.Uri;
import y4.a;

public abstract class c0 {

    /* renamed from: a  reason: collision with root package name */
    private final n f20051a;

    /* renamed from: b  reason: collision with root package name */
    private final e1 f20052b;

    /* renamed from: c  reason: collision with root package name */
    private long f20053c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f20054d;

    /* renamed from: e  reason: collision with root package name */
    private a f20055e;

    public c0(n nVar, e1 e1Var) {
        this.f20051a = nVar;
        this.f20052b = e1Var;
    }

    public n a() {
        return this.f20051a;
    }

    public e1 b() {
        return this.f20052b;
    }

    public long c() {
        return this.f20053c;
    }

    public g1 d() {
        return this.f20052b.z();
    }

    public int e() {
        return this.f20054d;
    }

    public a f() {
        return this.f20055e;
    }

    public Uri g() {
        return this.f20052b.b().u();
    }

    public void h(long j10) {
        this.f20053c = j10;
    }

    public void i(int i10) {
        this.f20054d = i10;
    }

    public void j(a aVar) {
        this.f20055e = aVar;
    }
}
