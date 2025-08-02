package com.geetest.core;

import java.util.Objects;

public class u4 extends i4 {

    /* renamed from: c  reason: collision with root package name */
    public static final u4 f6190c = new u4(v4.BREAK);

    /* renamed from: d  reason: collision with root package name */
    public final v4 f6191d;

    public u4(v4 v4Var) {
        super(m4.SPECIAL);
        Objects.requireNonNull(v4Var);
        this.f6191d = v4Var;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof u4)) {
            return false;
        }
        u4 u4Var = (u4) obj;
        if (!super.equals(obj) || this.f6191d != u4Var.f6191d) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode() ^ Objects.hashCode(this.f6191d);
    }

    public String toString() {
        return this.f6191d.name();
    }
}
