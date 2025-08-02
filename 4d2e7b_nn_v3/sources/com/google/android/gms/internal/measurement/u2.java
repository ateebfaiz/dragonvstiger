package com.google.android.gms.internal.measurement;

final class u2 {

    /* renamed from: a  reason: collision with root package name */
    private final Object f7325a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7326b;

    u2(Object obj, int i10) {
        this.f7325a = obj;
        this.f7326b = i10;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof u2)) {
            return false;
        }
        u2 u2Var = (u2) obj;
        if (this.f7325a == u2Var.f7325a && this.f7326b == u2Var.f7326b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f7325a) * 65535) + this.f7326b;
    }
}
