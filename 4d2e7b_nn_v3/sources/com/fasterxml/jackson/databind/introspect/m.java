package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.util.f;
import java.lang.reflect.Member;

public final class m extends i {

    /* renamed from: c  reason: collision with root package name */
    protected final n f5381c;

    /* renamed from: d  reason: collision with root package name */
    protected final j f5382d;

    /* renamed from: e  reason: collision with root package name */
    protected final int f5383e;

    public m(n nVar, j jVar, h0 h0Var, p pVar, int i10) {
        super(h0Var, pVar);
        this.f5381c = nVar;
        this.f5382d = jVar;
        this.f5383e = i10;
    }

    public String c() {
        return "";
    }

    public Class d() {
        return this.f5382d.s();
    }

    public j e() {
        return this.f5382d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!f.D(obj, m.class)) {
            return false;
        }
        m mVar = (m) obj;
        if (!mVar.f5381c.equals(this.f5381c) || mVar.f5383e != this.f5383e) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f5381c.hashCode() + this.f5383e;
    }

    public Class k() {
        return this.f5381c.k();
    }

    public Member m() {
        return this.f5381c.m();
    }

    public Object n(Object obj) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor parameter of " + k().getName());
    }

    public int p() {
        return this.f5383e;
    }

    public n q() {
        return this.f5381c;
    }

    /* renamed from: s */
    public m o(p pVar) {
        if (pVar == this.f5358b) {
            return this;
        }
        return this.f5381c.t(this.f5383e, pVar);
    }

    public String toString() {
        return "[parameter #" + p() + ", annotations: " + this.f5358b + "]";
    }
}
