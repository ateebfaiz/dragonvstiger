package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.j;

public class q {

    /* renamed from: a  reason: collision with root package name */
    protected int f5716a;

    /* renamed from: b  reason: collision with root package name */
    protected Class f5717b;

    /* renamed from: c  reason: collision with root package name */
    protected j f5718c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f5719d;

    public q(Class cls, boolean z10) {
        this.f5717b = cls;
        this.f5718c = null;
        this.f5719d = z10;
        this.f5716a = z10 ? e(cls) : g(cls);
    }

    public static final int d(j jVar) {
        return jVar.hashCode() - 2;
    }

    public static final int e(Class cls) {
        return cls.getName().hashCode() + 1;
    }

    public static final int f(j jVar) {
        return jVar.hashCode() - 1;
    }

    public static final int g(Class cls) {
        return cls.getName().hashCode();
    }

    public Class a() {
        return this.f5717b;
    }

    public j b() {
        return this.f5718c;
    }

    public boolean c() {
        return this.f5719d;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        q qVar = (q) obj;
        if (qVar.f5719d != this.f5719d) {
            return false;
        }
        Class cls = this.f5717b;
        if (cls == null) {
            return this.f5718c.equals(qVar.f5718c);
        }
        if (qVar.f5717b == cls) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f5716a;
    }

    public final String toString() {
        if (this.f5717b != null) {
            return "{class: " + this.f5717b.getName() + ", typed? " + this.f5719d + "}";
        }
        return "{type: " + this.f5718c + ", typed? " + this.f5719d + "}";
    }

    public q(j jVar, boolean z10) {
        this.f5718c = jVar;
        this.f5717b = null;
        this.f5719d = z10;
        this.f5716a = z10 ? d(jVar) : f(jVar);
    }
}
