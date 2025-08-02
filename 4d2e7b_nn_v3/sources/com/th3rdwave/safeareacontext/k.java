package com.th3rdwave.safeareacontext;

import kotlin.jvm.internal.m;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final j f11728a;

    /* renamed from: b  reason: collision with root package name */
    private final j f11729b;

    /* renamed from: c  reason: collision with root package name */
    private final j f11730c;

    /* renamed from: d  reason: collision with root package name */
    private final j f11731d;

    public k(j jVar, j jVar2, j jVar3, j jVar4) {
        m.f(jVar, "top");
        m.f(jVar2, "right");
        m.f(jVar3, "bottom");
        m.f(jVar4, "left");
        this.f11728a = jVar;
        this.f11729b = jVar2;
        this.f11730c = jVar3;
        this.f11731d = jVar4;
    }

    public final j a() {
        return this.f11730c;
    }

    public final j b() {
        return this.f11731d;
    }

    public final j c() {
        return this.f11729b;
    }

    public final j d() {
        return this.f11728a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f11728a == kVar.f11728a && this.f11729b == kVar.f11729b && this.f11730c == kVar.f11730c && this.f11731d == kVar.f11731d;
    }

    public int hashCode() {
        return (((((this.f11728a.hashCode() * 31) + this.f11729b.hashCode()) * 31) + this.f11730c.hashCode()) * 31) + this.f11731d.hashCode();
    }

    public String toString() {
        j jVar = this.f11728a;
        j jVar2 = this.f11729b;
        j jVar3 = this.f11730c;
        j jVar4 = this.f11731d;
        return "SafeAreaViewEdges(top=" + jVar + ", right=" + jVar2 + ", bottom=" + jVar3 + ", left=" + jVar4 + ")";
    }
}
