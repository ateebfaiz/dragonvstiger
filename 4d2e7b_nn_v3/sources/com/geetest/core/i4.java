package com.geetest.core;

import java.util.Objects;

public class i4 {

    /* renamed from: a  reason: collision with root package name */
    public final m4 f6019a;

    /* renamed from: b  reason: collision with root package name */
    public w4 f6020b;

    public i4(m4 m4Var) {
        this.f6019a = m4Var;
        Objects.requireNonNull(m4Var, "majorType is null");
    }

    public void a(long j10) {
        if (j10 >= 0) {
            this.f6020b = new w4(j10);
            return;
        }
        throw new IllegalArgumentException("tag number must be 0 or greater");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i4)) {
            return false;
        }
        i4 i4Var = (i4) obj;
        w4 w4Var = this.f6020b;
        if (w4Var != null) {
            if (!w4Var.equals(i4Var.f6020b) || this.f6019a != i4Var.f6019a) {
                return false;
            }
            return true;
        } else if (i4Var.f6020b == null && this.f6019a == i4Var.f6019a) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f6019a, this.f6020b});
    }
}
