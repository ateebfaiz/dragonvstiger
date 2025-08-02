package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.j;
import java.lang.reflect.Array;

public final class a extends m {
    protected final j C;
    protected final Object X;

    protected a(j jVar, n nVar, Object obj, Object obj2, Object obj3, boolean z10) {
        super(obj.getClass(), nVar, (j) null, (j[]) null, jVar.hashCode(), obj2, obj3, z10);
        this.C = jVar;
        this.X = obj;
    }

    public static a Y(j jVar, n nVar) {
        return Z(jVar, nVar, (Object) null, (Object) null);
    }

    public static a Z(j jVar, n nVar, Object obj, Object obj2) {
        return new a(jVar, nVar, Array.newInstance(jVar.s(), 0), obj, obj2, false);
    }

    public boolean A() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public j N(Class cls, n nVar, j jVar, j[] jVarArr) {
        return null;
    }

    public j P(j jVar) {
        return new a(jVar, this.f5633h, Array.newInstance(jVar.s(), 0), this.f5441c, this.f5442d, this.f5443e);
    }

    /* renamed from: a0 */
    public a Q(Object obj) {
        if (obj == this.C.v()) {
            return this;
        }
        return new a(this.C.T(obj), this.f5633h, this.X, this.f5441c, this.f5442d, this.f5443e);
    }

    /* renamed from: b0 */
    public a S() {
        if (this.f5443e) {
            return this;
        }
        return new a(this.C.S(), this.f5633h, this.X, this.f5441c, this.f5442d, true);
    }

    /* renamed from: c0 */
    public a T(Object obj) {
        if (obj == this.f5442d) {
            return this;
        }
        return new a(this.C, this.f5633h, this.X, this.f5441c, obj, this.f5443e);
    }

    /* renamed from: d0 */
    public a U(Object obj) {
        if (obj == this.f5441c) {
            return this;
        }
        return new a(this.C, this.f5633h, this.X, obj, this.f5442d, this.f5443e);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == a.class) {
            return this.C.equals(((a) obj).C);
        }
        return false;
    }

    public j l() {
        return this.C;
    }

    public StringBuilder m(StringBuilder sb2) {
        sb2.append('[');
        return this.C.m(sb2);
    }

    public StringBuilder o(StringBuilder sb2) {
        sb2.append('[');
        return this.C.o(sb2);
    }

    public String toString() {
        return "[array type, component type: " + this.C + "]";
    }

    public boolean x() {
        return this.C.x();
    }

    public boolean y() {
        if (super.y() || this.C.y()) {
            return true;
        }
        return false;
    }
}
