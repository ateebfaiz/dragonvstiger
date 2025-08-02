package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.util.f;
import java.io.Serializable;
import java.lang.reflect.Member;

public class i0 extends i implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    protected final Class f5359c;

    /* renamed from: d  reason: collision with root package name */
    protected final j f5360d;

    /* renamed from: e  reason: collision with root package name */
    protected final String f5361e;

    public i0(h0 h0Var, Class cls, String str, j jVar) {
        super(h0Var, (p) null);
        this.f5359c = cls;
        this.f5360d = jVar;
        this.f5361e = str;
    }

    public String c() {
        return this.f5361e;
    }

    public Class d() {
        return this.f5360d.s();
    }

    public j e() {
        return this.f5360d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!f.D(obj, getClass())) {
            return false;
        }
        i0 i0Var = (i0) obj;
        if (i0Var.f5359c != this.f5359c || !i0Var.f5361e.equals(this.f5361e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f5361e.hashCode();
    }

    public Class k() {
        return this.f5359c;
    }

    public Member m() {
        return null;
    }

    public Object n(Object obj) {
        throw new IllegalArgumentException("Cannot get virtual property '" + this.f5361e + "'");
    }

    public b o(p pVar) {
        return this;
    }

    public String toString() {
        return "[virtual " + l() + "]";
    }
}
