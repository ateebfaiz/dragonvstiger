package com.geetest.core;

import java.io.IOException;

public abstract class p0 extends i0 {
    public abstract int a(boolean z10) throws IOException;

    public abstract void a(n0 n0Var, boolean z10) throws IOException;

    public abstract boolean a(p0 p0Var);

    public final boolean b(p0 p0Var) {
        if (this == p0Var || a(p0Var)) {
            return true;
        }
        return false;
    }

    public final p0 d() {
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v) || !a(((v) obj).d())) {
            return false;
        }
        return true;
    }

    public abstract boolean g();

    public p0 h() {
        return this;
    }

    public p0 i() {
        return this;
    }
}
