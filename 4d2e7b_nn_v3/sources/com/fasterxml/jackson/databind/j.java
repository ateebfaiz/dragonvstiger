package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.type.n;
import com.fasterxml.jackson.databind.type.o;
import com.fasterxml.jackson.databind.util.f;
import i8.a;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;

public abstract class j extends a implements Serializable, Type {

    /* renamed from: a  reason: collision with root package name */
    protected final Class f5439a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f5440b;

    /* renamed from: c  reason: collision with root package name */
    protected final Object f5441c;

    /* renamed from: d  reason: collision with root package name */
    protected final Object f5442d;

    /* renamed from: e  reason: collision with root package name */
    protected final boolean f5443e;

    protected j(Class cls, int i10, Object obj, Object obj2, boolean z10) {
        this.f5439a = cls;
        this.f5440b = cls.getName().hashCode() + i10;
        this.f5441c = obj;
        this.f5442d = obj2;
        this.f5443e = z10;
    }

    public boolean A() {
        return false;
    }

    public boolean B() {
        return false;
    }

    public abstract boolean C();

    public final boolean D() {
        if (!f.G(this.f5439a) || this.f5439a == Enum.class) {
            return false;
        }
        return true;
    }

    public final boolean E() {
        return f.G(this.f5439a);
    }

    public final boolean F() {
        return Modifier.isFinal(this.f5439a.getModifiers());
    }

    public final boolean G() {
        return this.f5439a.isInterface();
    }

    public final boolean H() {
        if (this.f5439a == Object.class) {
            return true;
        }
        return false;
    }

    public boolean I() {
        return false;
    }

    public final boolean J() {
        return this.f5439a.isPrimitive();
    }

    public final boolean K() {
        return f.N(this.f5439a);
    }

    public final boolean L(Class cls) {
        Class cls2 = this.f5439a;
        if (cls2 == cls || cls.isAssignableFrom(cls2)) {
            return true;
        }
        return false;
    }

    public final boolean M(Class cls) {
        Class cls2 = this.f5439a;
        if (cls2 == cls || cls2.isAssignableFrom(cls)) {
            return true;
        }
        return false;
    }

    public abstract j N(Class cls, n nVar, j jVar, j[] jVarArr);

    public final boolean O() {
        return this.f5443e;
    }

    public abstract j P(j jVar);

    public abstract j Q(Object obj);

    public j R(j jVar) {
        j jVar2;
        Object v10 = jVar.v();
        if (v10 != this.f5442d) {
            jVar2 = T(v10);
        } else {
            jVar2 = this;
        }
        Object w10 = jVar.w();
        if (w10 != this.f5441c) {
            return jVar2.U(w10);
        }
        return jVar2;
    }

    public abstract j S();

    public abstract j T(Object obj);

    public abstract j U(Object obj);

    public abstract boolean equals(Object obj);

    public abstract j f(int i10);

    public abstract int h();

    public final int hashCode() {
        return this.f5440b;
    }

    public j i(int i10) {
        j f10 = f(i10);
        if (f10 == null) {
            return o.J();
        }
        return f10;
    }

    public abstract j j(Class cls);

    public abstract n k();

    public j l() {
        return null;
    }

    public abstract StringBuilder m(StringBuilder sb2);

    public String n() {
        StringBuilder sb2 = new StringBuilder(40);
        o(sb2);
        return sb2.toString();
    }

    public abstract StringBuilder o(StringBuilder sb2);

    public abstract List p();

    public j q() {
        return null;
    }

    public final Class s() {
        return this.f5439a;
    }

    /* renamed from: t */
    public j b() {
        return null;
    }

    public abstract j u();

    public Object v() {
        return this.f5442d;
    }

    public Object w() {
        return this.f5441c;
    }

    public boolean x() {
        if (h() > 0) {
            return true;
        }
        return false;
    }

    public boolean y() {
        if (this.f5442d == null && this.f5441c == null) {
            return false;
        }
        return true;
    }

    public final boolean z(Class cls) {
        if (this.f5439a == cls) {
            return true;
        }
        return false;
    }
}
