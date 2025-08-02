package com.facebook.imagepipeline.producers;

import java.util.Map;
import kotlin.jvm.internal.m;

public abstract class e0 implements g1 {

    /* renamed from: a  reason: collision with root package name */
    private final h1 f20081a;

    /* renamed from: b  reason: collision with root package name */
    private final g1 f20082b;

    public e0(h1 h1Var, g1 g1Var) {
        this.f20081a = h1Var;
        this.f20082b = g1Var;
    }

    public void a(e1 e1Var, String str, String str2) {
        m.f(e1Var, "context");
        h1 h1Var = this.f20081a;
        if (h1Var != null) {
            h1Var.f(e1Var.getId(), str, str2);
        }
        g1 g1Var = this.f20082b;
        if (g1Var != null) {
            g1Var.a(e1Var, str, str2);
        }
    }

    public void c(e1 e1Var, String str, boolean z10) {
        m.f(e1Var, "context");
        h1 h1Var = this.f20081a;
        if (h1Var != null) {
            h1Var.d(e1Var.getId(), str, z10);
        }
        g1 g1Var = this.f20082b;
        if (g1Var != null) {
            g1Var.c(e1Var, str, z10);
        }
    }

    public void d(e1 e1Var, String str, Map map) {
        m.f(e1Var, "context");
        h1 h1Var = this.f20081a;
        if (h1Var != null) {
            h1Var.c(e1Var.getId(), str, map);
        }
        g1 g1Var = this.f20082b;
        if (g1Var != null) {
            g1Var.d(e1Var, str, map);
        }
    }

    public void e(e1 e1Var, String str) {
        m.f(e1Var, "context");
        h1 h1Var = this.f20081a;
        if (h1Var != null) {
            h1Var.b(e1Var.getId(), str);
        }
        g1 g1Var = this.f20082b;
        if (g1Var != null) {
            g1Var.e(e1Var, str);
        }
    }

    public boolean g(e1 e1Var, String str) {
        Boolean bool;
        m.f(e1Var, "context");
        h1 h1Var = this.f20081a;
        Boolean bool2 = null;
        if (h1Var != null) {
            bool = Boolean.valueOf(h1Var.e(e1Var.getId()));
        } else {
            bool = null;
        }
        if (!m.b(bool, Boolean.TRUE)) {
            g1 g1Var = this.f20082b;
            if (g1Var != null) {
                bool2 = Boolean.valueOf(g1Var.g(e1Var, str));
            }
            bool = bool2;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public void j(e1 e1Var, String str, Map map) {
        m.f(e1Var, "context");
        h1 h1Var = this.f20081a;
        if (h1Var != null) {
            h1Var.g(e1Var.getId(), str, map);
        }
        g1 g1Var = this.f20082b;
        if (g1Var != null) {
            g1Var.j(e1Var, str, map);
        }
    }

    public void k(e1 e1Var, String str, Throwable th, Map map) {
        m.f(e1Var, "context");
        h1 h1Var = this.f20081a;
        if (h1Var != null) {
            h1Var.h(e1Var.getId(), str, th, map);
        }
        g1 g1Var = this.f20082b;
        if (g1Var != null) {
            g1Var.k(e1Var, str, th, map);
        }
    }
}
