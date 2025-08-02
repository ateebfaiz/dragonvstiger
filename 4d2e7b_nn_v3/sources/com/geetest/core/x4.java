package com.geetest.core;

public class x4 extends h4 {

    /* renamed from: d  reason: collision with root package name */
    public final String f6214d;

    public x4(String str) {
        super(m4.UNICODE_STRING);
        this.f6214d = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof x4) || !super.equals(obj)) {
            return false;
        }
        x4 x4Var = (x4) obj;
        String str = this.f6214d;
        if (str != null) {
            return str.equals(x4Var.f6214d);
        }
        if (x4Var.f6214d == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f6214d != null) {
            return super.hashCode() + this.f6214d.hashCode();
        }
        return 0;
    }

    public String toString() {
        String str = this.f6214d;
        if (str == null) {
            return "null";
        }
        return str;
    }
}
