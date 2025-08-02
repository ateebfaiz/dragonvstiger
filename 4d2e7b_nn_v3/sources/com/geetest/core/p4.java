package com.geetest.core;

import java.math.BigInteger;
import java.util.Objects;

public abstract class p4 extends i4 {

    /* renamed from: c  reason: collision with root package name */
    public final BigInteger f6136c;

    public p4(m4 m4Var, BigInteger bigInteger) {
        super(m4Var);
        Objects.requireNonNull(bigInteger);
        this.f6136c = bigInteger;
    }

    public BigInteger a() {
        return this.f6136c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p4)) {
            return false;
        }
        p4 p4Var = (p4) obj;
        if (!super.equals(obj) || !this.f6136c.equals(p4Var.f6136c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode() ^ this.f6136c.hashCode();
    }

    public String toString() {
        return this.f6136c.toString();
    }
}
