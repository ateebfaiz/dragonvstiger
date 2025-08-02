package com.bugsnag.android;

import g0.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class n1 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f18877a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18878b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18879c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18880d;

    public n1(boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f18877a = z10;
        this.f18878b = z11;
        this.f18879c = z12;
        this.f18880d = z13;
    }

    public final n1 a() {
        return new n1(this.f18877a, this.f18878b, this.f18879c, this.f18880d);
    }

    public final boolean b() {
        return this.f18877a;
    }

    public final boolean c() {
        return this.f18878b;
    }

    public final boolean d() {
        return this.f18879c;
    }

    public final boolean e() {
        return this.f18880d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof n1) {
            n1 n1Var = (n1) obj;
            if (this.f18877a == n1Var.f18877a && this.f18878b == n1Var.f18878b && this.f18879c == n1Var.f18879c && this.f18880d == n1Var.f18880d) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((((a.a(this.f18877a) * 31) + a.a(this.f18878b)) * 31) + a.a(this.f18879c)) * 31) + a.a(this.f18880d);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n1(boolean z10, boolean z11, boolean z12, boolean z13, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? true : z10, (i10 & 2) != 0 ? true : z11, (i10 & 4) != 0 ? true : z12, (i10 & 8) != 0 ? true : z13);
    }

    public n1(boolean z10) {
        this(z10, z10, z10, z10);
    }
}
