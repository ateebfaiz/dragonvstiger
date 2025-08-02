package com.geetest.core;

import java.util.ArrayList;
import java.util.Arrays;

public class f4 extends h4 {

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<i4> f5976d;

    public f4() {
        super(m4.ARRAY);
        this.f5976d = new ArrayList<>();
    }

    public f4 a(i4 i4Var) {
        this.f5976d.add(i4Var);
        return this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f4)) {
            return false;
        }
        f4 f4Var = (f4) obj;
        if (!super.equals(obj) || !this.f5976d.equals(f4Var.f5976d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode() ^ this.f5976d.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        if (this.f6010c) {
            sb2.append("_ ");
        }
        sb2.append(Arrays.toString(this.f5976d.toArray()).substring(1));
        return sb2.toString();
    }

    public f4(int i10) {
        super(m4.ARRAY);
        this.f5976d = new ArrayList<>(i10);
    }
}
