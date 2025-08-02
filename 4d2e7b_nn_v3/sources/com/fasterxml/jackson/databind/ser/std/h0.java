package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.introspect.i;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.l;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.m;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Map;

public abstract class h0 extends o implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f5554b = new Object();

    /* renamed from: a  reason: collision with root package name */
    protected final Class f5555a;

    protected h0(Class cls) {
        this.f5555a = cls;
    }

    protected static final boolean k(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? false : true;
    }

    protected static final boolean l(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return false;
        }
        return true;
    }

    public Class c() {
        return this.f5555a;
    }

    public abstract void f(Object obj, f fVar, b0 b0Var);

    /* access modifiers changed from: protected */
    public o m(b0 b0Var, d dVar) {
        Object f10;
        if (dVar == null) {
            return null;
        }
        i b10 = dVar.b();
        b L = b0Var.L();
        if (b10 == null || (f10 = L.f(b10)) == null) {
            return null;
        }
        return b0Var.i0(b10, f10);
    }

    /* access modifiers changed from: protected */
    public o n(b0 b0Var, d dVar, o oVar) {
        Object obj = f5554b;
        Map map = (Map) b0Var.M(obj);
        if (map == null) {
            map = new IdentityHashMap();
            b0Var.j0(obj, map);
        } else if (map.get(dVar) != null) {
            return oVar;
        }
        map.put(dVar, Boolean.TRUE);
        try {
            o o10 = o(b0Var, dVar, oVar);
            if (o10 != null) {
                return b0Var.X(o10, dVar);
            }
            map.remove(dVar);
            return oVar;
        } finally {
            map.remove(dVar);
        }
    }

    /* access modifiers changed from: protected */
    public o o(b0 b0Var, d dVar, o oVar) {
        i b10;
        Object L;
        b L2 = b0Var.L();
        if (!k(L2, dVar) || (b10 = dVar.b()) == null || (L = L2.L(b10)) == null) {
            return oVar;
        }
        b0Var.e(dVar.b(), L);
        b0Var.h();
        throw null;
    }

    /* access modifiers changed from: protected */
    public Boolean p(b0 b0Var, d dVar, Class cls, i.a aVar) {
        i.d q10 = q(b0Var, dVar, cls);
        if (q10 != null) {
            return q10.e(aVar);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public i.d q(b0 b0Var, d dVar, Class cls) {
        if (dVar != null) {
            return dVar.a(b0Var.f(), cls);
        }
        return b0Var.P(cls);
    }

    /* access modifiers changed from: protected */
    public p.b s(b0 b0Var, d dVar, Class cls) {
        if (dVar != null) {
            return dVar.c(b0Var.f(), cls);
        }
        return b0Var.Q(cls);
    }

    /* access modifiers changed from: protected */
    public m t(b0 b0Var, Object obj, Object obj2) {
        b0Var.R();
        Class c10 = c();
        c.d.a(b0Var.k(c10, "Cannot resolve PropertyFilter with id '" + obj + "'; no FilterProvider configured"));
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean u(o oVar) {
        return com.fasterxml.jackson.databind.util.f.J(oVar);
    }

    public void v(b0 b0Var, Throwable th, Object obj, int i10) {
        boolean z10;
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        com.fasterxml.jackson.databind.util.f.U(th);
        if (b0Var == null || b0Var.b0(a0.WRAP_EXCEPTIONS)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (th instanceof IOException) {
            if (!z10 || !(th instanceof c)) {
                throw ((IOException) th);
            }
        } else if (!z10) {
            com.fasterxml.jackson.databind.util.f.W(th);
        }
        throw l.p(th, obj, i10);
    }

    public void w(b0 b0Var, Throwable th, Object obj, String str) {
        boolean z10;
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        com.fasterxml.jackson.databind.util.f.U(th);
        if (b0Var == null || b0Var.b0(a0.WRAP_EXCEPTIONS)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (th instanceof IOException) {
            if (!z10 || !(th instanceof c)) {
                throw ((IOException) th);
            }
        } else if (!z10) {
            com.fasterxml.jackson.databind.util.f.W(th);
        }
        throw l.q(th, obj, str);
    }

    protected h0(j jVar) {
        this.f5555a = jVar.s();
    }

    protected h0(Class cls, boolean z10) {
        this.f5555a = cls;
    }

    protected h0(h0 h0Var) {
        this.f5555a = h0Var.f5555a;
    }
}
