package com.geetest.core;

public class w4 extends i4 {

    /* renamed from: c  reason: collision with root package name */
    public final long f6205c;

    public w4(long j10) {
        super(m4.TAG);
        this.f6205c = j10;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof w4)) {
            return false;
        }
        w4 w4Var = (w4) obj;
        if (!super.equals(obj) || this.f6205c != w4Var.f6205c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode() ^ Long.valueOf(this.f6205c).hashCode();
    }

    public String toString() {
        return "Tag(" + this.f6205c + ")";
    }
}
