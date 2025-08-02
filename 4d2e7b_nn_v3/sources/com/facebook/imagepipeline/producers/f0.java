package com.facebook.imagepipeline.producers;

import g5.d;
import g5.e;
import kotlin.jvm.internal.m;

public final class f0 extends e0 implements d {

    /* renamed from: c  reason: collision with root package name */
    private final e f20083c;

    /* renamed from: d  reason: collision with root package name */
    private final d f20084d;

    public f0(e eVar, d dVar) {
        super(eVar, dVar);
        this.f20083c = eVar;
        this.f20084d = dVar;
    }

    public void b(e1 e1Var) {
        m.f(e1Var, "producerContext");
        e eVar = this.f20083c;
        if (eVar != null) {
            eVar.a(e1Var.b(), e1Var.a(), e1Var.getId(), e1Var.n());
        }
        d dVar = this.f20084d;
        if (dVar != null) {
            dVar.b(e1Var);
        }
    }

    public void f(e1 e1Var) {
        m.f(e1Var, "producerContext");
        e eVar = this.f20083c;
        if (eVar != null) {
            eVar.i(e1Var.b(), e1Var.getId(), e1Var.n());
        }
        d dVar = this.f20084d;
        if (dVar != null) {
            dVar.f(e1Var);
        }
    }

    public void h(e1 e1Var, Throwable th) {
        m.f(e1Var, "producerContext");
        e eVar = this.f20083c;
        if (eVar != null) {
            eVar.j(e1Var.b(), e1Var.getId(), th, e1Var.n());
        }
        d dVar = this.f20084d;
        if (dVar != null) {
            dVar.h(e1Var, th);
        }
    }

    public void i(e1 e1Var) {
        m.f(e1Var, "producerContext");
        e eVar = this.f20083c;
        if (eVar != null) {
            eVar.k(e1Var.getId());
        }
        d dVar = this.f20084d;
        if (dVar != null) {
            dVar.i(e1Var);
        }
    }
}
