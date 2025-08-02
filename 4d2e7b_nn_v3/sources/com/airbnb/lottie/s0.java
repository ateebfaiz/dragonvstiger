package com.airbnb.lottie;

import java.util.Arrays;

public final class s0 {

    /* renamed from: a  reason: collision with root package name */
    private final Object f17768a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f17769b;

    public s0(Object obj) {
        this.f17768a = obj;
        this.f17769b = null;
    }

    public Throwable a() {
        return this.f17769b;
    }

    public Object b() {
        return this.f17768a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s0)) {
            return false;
        }
        s0 s0Var = (s0) obj;
        if (b() != null && b().equals(s0Var.b())) {
            return true;
        }
        if (a() == null || s0Var.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public s0(Throwable th) {
        this.f17769b = th;
        this.f17768a = null;
    }
}
