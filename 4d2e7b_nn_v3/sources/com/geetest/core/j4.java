package com.geetest.core;

public class j4 extends u4 {

    /* renamed from: e  reason: collision with root package name */
    public final double f6042e;

    public j4(double d10) {
        super(v4.IEEE_754_DOUBLE_PRECISION_FLOAT);
        this.f6042e = d10;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j4)) {
            return false;
        }
        j4 j4Var = (j4) obj;
        if (!super.equals(obj) || this.f6042e != j4Var.f6042e) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode() ^ Double.valueOf(this.f6042e).hashCode();
    }

    public String toString() {
        return String.valueOf(this.f6042e);
    }
}
