package com.geetest.core;

public class h4 extends i4 {

    /* renamed from: c  reason: collision with root package name */
    public boolean f6010c = false;

    public h4(m4 m4Var) {
        super(m4Var);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h4)) {
            return false;
        }
        h4 h4Var = (h4) obj;
        if (!super.equals(obj) || this.f6010c != h4Var.f6010c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode() ^ Boolean.valueOf(this.f6010c).hashCode();
    }
}
