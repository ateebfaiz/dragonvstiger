package com.fasterxml.jackson.databind.introspect;

import c.d;
import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.c;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.util.a;
import com.fasterxml.jackson.databind.util.f;
import com.fasterxml.jackson.databind.util.g;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l8.l;

public class q extends c {

    /* renamed from: j  reason: collision with root package name */
    private static final Class[] f5398j = new Class[0];

    /* renamed from: b  reason: collision with root package name */
    protected final c0 f5399b;

    /* renamed from: c  reason: collision with root package name */
    protected final l f5400c;

    /* renamed from: d  reason: collision with root package name */
    protected final b f5401d;

    /* renamed from: e  reason: collision with root package name */
    protected final c f5402e;

    /* renamed from: f  reason: collision with root package name */
    protected Class[] f5403f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f5404g;

    /* renamed from: h  reason: collision with root package name */
    protected List f5405h;

    /* renamed from: i  reason: collision with root package name */
    protected b0 f5406i;

    protected q(c0 c0Var, j jVar, c cVar) {
        super(jVar);
        this.f5399b = c0Var;
        l z10 = c0Var.z();
        this.f5400c = z10;
        if (z10 == null) {
            this.f5401d = null;
        } else {
            this.f5401d = z10.h();
        }
        this.f5402e = cVar;
    }

    public static q r(l lVar, j jVar, c cVar) {
        return new q(lVar, jVar, cVar, Collections.emptyList());
    }

    public static q s(c0 c0Var) {
        return new q(c0Var);
    }

    public i a() {
        c0 c0Var = this.f5399b;
        if (c0Var == null) {
            return null;
        }
        i x10 = c0Var.x();
        Class<Map> cls = Map.class;
        if (x10 == null) {
            i w10 = this.f5399b.w();
            if (w10 == null) {
                return null;
            }
            if (cls.isAssignableFrom(w10.d())) {
                return w10;
            }
            throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on field '%s': type is not instance of java.util.Map", new Object[]{w10.c()}));
        } else if (cls.isAssignableFrom(x10.d())) {
            return x10;
        } else {
            throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on method %s(): return type is not instance of java.util.Map", new Object[]{x10.c()}));
        }
    }

    public Class[] b() {
        Class[] clsArr;
        if (!this.f5404g) {
            this.f5404g = true;
            b bVar = this.f5401d;
            if (bVar == null) {
                clsArr = null;
            } else {
                clsArr = bVar.W(this.f5402e);
            }
            if (clsArr == null && !this.f5400c.F(com.fasterxml.jackson.databind.q.DEFAULT_VIEW_INCLUSION)) {
                clsArr = f5398j;
            }
            this.f5403f = clsArr;
        }
        return this.f5403f;
    }

    public i.d c(i.d dVar) {
        i.d l10;
        b bVar = this.f5401d;
        if (!(bVar == null || (l10 = bVar.l(this.f5402e)) == null)) {
            if (dVar == null) {
                dVar = l10;
            } else {
                dVar = dVar.s(l10);
            }
        }
        i.d p10 = this.f5400c.p(this.f5402e.d());
        if (p10 == null) {
            return dVar;
        }
        if (dVar == null) {
            return p10;
        }
        return dVar.s(p10);
    }

    public i d() {
        c0 c0Var = this.f5399b;
        if (c0Var == null) {
            return null;
        }
        return c0Var.A();
    }

    public i e() {
        c0 c0Var = this.f5399b;
        if (c0Var == null) {
            return null;
        }
        return c0Var.B();
    }

    public List f() {
        return q();
    }

    public p.b g(p.b bVar) {
        p.b E;
        b bVar2 = this.f5401d;
        if (bVar2 == null || (E = bVar2.E(this.f5402e)) == null) {
            return bVar;
        }
        if (bVar == null) {
            return E;
        }
        return bVar.n(E);
    }

    public g h() {
        b bVar = this.f5401d;
        if (bVar == null) {
            return null;
        }
        p(bVar.M(this.f5402e));
        return null;
    }

    public a j() {
        return this.f5402e.n();
    }

    public c k() {
        return this.f5402e;
    }

    public b0 l() {
        return this.f5406i;
    }

    public boolean n() {
        return this.f5402e.s();
    }

    public Object o(boolean z10) {
        e p10 = this.f5402e.p();
        if (p10 == null) {
            return null;
        }
        if (z10) {
            p10.i(this.f5400c.F(com.fasterxml.jackson.databind.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        try {
            return p10.u();
        } catch (Exception e10) {
            e = e10;
            while (e.getCause() != null) {
                e = e.getCause();
            }
            f.U(e);
            f.W(e);
            throw new IllegalArgumentException("Failed to instantiate bean of type " + this.f5402e.m().getName() + ": (" + e.getClass().getName() + ") " + f.m(e), e);
        }
    }

    /* access modifiers changed from: protected */
    public g p(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Class) {
            Class<g.a> cls = (Class) obj;
            if (cls == g.a.class || f.F(cls)) {
                return null;
            }
            if (g.class.isAssignableFrom(cls)) {
                this.f5400c.w();
                d.a(f.k(cls, this.f5400c.b()));
                return null;
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<Converter>");
        }
        throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + obj.getClass().getName() + "; expected type Converter or Class<Converter> instead");
    }

    /* access modifiers changed from: protected */
    public List q() {
        if (this.f5405h == null) {
            this.f5405h = this.f5399b.D();
        }
        return this.f5405h;
    }

    public boolean t(String str) {
        Iterator it = q().iterator();
        while (it.hasNext()) {
            if (((s) it.next()).l().equals(str)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    protected q(l lVar, j jVar, c cVar, List list) {
        super(jVar);
        this.f5399b = null;
        this.f5400c = lVar;
        if (lVar == null) {
            this.f5401d = null;
        } else {
            this.f5401d = lVar.h();
        }
        this.f5402e = cVar;
        this.f5405h = list;
    }

    protected q(c0 c0Var) {
        this(c0Var, c0Var.F(), c0Var.y());
        this.f5406i = c0Var.C();
    }
}
