package com.facebook.imagepipeline.producers;

import java.util.Map;
import kotlin.jvm.internal.m;
import w2.h;

public abstract class m1 extends h {

    /* renamed from: b  reason: collision with root package name */
    private final n f20175b;

    /* renamed from: c  reason: collision with root package name */
    private final g1 f20176c;

    /* renamed from: d  reason: collision with root package name */
    private final e1 f20177d;

    /* renamed from: e  reason: collision with root package name */
    private final String f20178e;

    public m1(n nVar, g1 g1Var, e1 e1Var, String str) {
        m.f(nVar, "consumer");
        m.f(g1Var, "producerListener");
        m.f(e1Var, "producerContext");
        m.f(str, "producerName");
        this.f20175b = nVar;
        this.f20176c = g1Var;
        this.f20177d = e1Var;
        this.f20178e = str;
        g1Var.e(e1Var, str);
    }

    /* access modifiers changed from: protected */
    public void d() {
        Map map;
        g1 g1Var = this.f20176c;
        e1 e1Var = this.f20177d;
        String str = this.f20178e;
        if (g1Var.g(e1Var, str)) {
            map = g();
        } else {
            map = null;
        }
        g1Var.d(e1Var, str, map);
        this.f20175b.a();
    }

    /* access modifiers changed from: protected */
    public void e(Exception exc) {
        Map map;
        m.f(exc, "e");
        g1 g1Var = this.f20176c;
        e1 e1Var = this.f20177d;
        String str = this.f20178e;
        if (g1Var.g(e1Var, str)) {
            map = h(exc);
        } else {
            map = null;
        }
        g1Var.k(e1Var, str, exc, map);
        this.f20175b.onFailure(exc);
    }

    /* access modifiers changed from: protected */
    public void f(Object obj) {
        Map map;
        g1 g1Var = this.f20176c;
        e1 e1Var = this.f20177d;
        String str = this.f20178e;
        if (g1Var.g(e1Var, str)) {
            map = i(obj);
        } else {
            map = null;
        }
        g1Var.j(e1Var, str, map);
        this.f20175b.c(obj, 1);
    }

    /* access modifiers changed from: protected */
    public Map g() {
        return null;
    }

    /* access modifiers changed from: protected */
    public Map h(Exception exc) {
        return null;
    }

    /* access modifiers changed from: protected */
    public Map i(Object obj) {
        return null;
    }
}
