package com.geetest.core;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class n4 extends h4 {

    /* renamed from: d  reason: collision with root package name */
    public final LinkedHashMap<i4, i4> f6113d;

    /* renamed from: e  reason: collision with root package name */
    public final List<i4> f6114e;

    public n4() {
        super(m4.MAP);
        this.f6114e = new LinkedList();
        this.f6113d = new LinkedHashMap<>();
    }

    public i4 a(i4 i4Var) {
        return this.f6113d.get(i4Var);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n4)) {
            return false;
        }
        n4 n4Var = (n4) obj;
        if (!super.equals(obj) || !this.f6113d.equals(n4Var.f6113d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode() ^ this.f6113d.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f6010c) {
            sb2.append("{_ ");
        } else {
            sb2.append("{ ");
        }
        for (i4 next : this.f6114e) {
            sb2.append(next);
            sb2.append(": ");
            sb2.append(this.f6113d.get(next));
            sb2.append(", ");
        }
        if (sb2.toString().endsWith(", ")) {
            sb2.setLength(sb2.length() - 2);
        }
        sb2.append(" }");
        return sb2.toString();
    }

    public Collection<i4> a() {
        return this.f6114e;
    }

    public n4(int i10) {
        super(m4.MAP);
        this.f6114e = new LinkedList();
        this.f6113d = new LinkedHashMap<>(i10);
    }
}
