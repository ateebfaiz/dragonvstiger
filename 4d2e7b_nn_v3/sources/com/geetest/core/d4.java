package com.geetest.core;

public class d4 extends u4 {

    /* renamed from: e  reason: collision with root package name */
    public final float f5953e;

    public d4(v4 v4Var, float f10) {
        super(v4Var);
        this.f5953e = f10;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d4)) {
            return false;
        }
        d4 d4Var = (d4) obj;
        if (!super.equals(obj) || this.f5953e != d4Var.f5953e) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode() ^ Float.valueOf(this.f5953e).hashCode();
    }
}
