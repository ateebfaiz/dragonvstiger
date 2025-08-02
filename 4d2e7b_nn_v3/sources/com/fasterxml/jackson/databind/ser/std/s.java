package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.c0;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.l;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.q;
import com.fasterxml.jackson.databind.ser.i;
import com.fasterxml.jackson.databind.y;
import i8.b;
import q8.g;
import t8.k;

public class s extends h0 implements i {

    /* renamed from: c  reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.introspect.i f5566c;

    /* renamed from: d  reason: collision with root package name */
    protected final g f5567d;

    /* renamed from: e  reason: collision with root package name */
    protected final o f5568e;

    /* renamed from: f  reason: collision with root package name */
    protected final d f5569f;

    /* renamed from: g  reason: collision with root package name */
    protected final j f5570g;

    /* renamed from: h  reason: collision with root package name */
    protected final boolean f5571h;

    /* renamed from: i  reason: collision with root package name */
    protected transient k f5572i;

    static class a extends g {

        /* renamed from: a  reason: collision with root package name */
        protected final g f5573a;

        /* renamed from: b  reason: collision with root package name */
        protected final Object f5574b;

        public a(g gVar, Object obj) {
            this.f5573a = gVar;
            this.f5574b = obj;
        }

        public g a(d dVar) {
            throw new UnsupportedOperationException();
        }

        public String b() {
            return this.f5573a.b();
        }

        public c0.a c() {
            return this.f5573a.c();
        }

        public b g(f fVar, b bVar) {
            bVar.f12330a = this.f5574b;
            return this.f5573a.g(fVar, bVar);
        }

        public b h(f fVar, b bVar) {
            return this.f5573a.h(fVar, bVar);
        }
    }

    public s(com.fasterxml.jackson.databind.introspect.i iVar, g gVar, o oVar) {
        super(iVar.e());
        this.f5566c = iVar;
        this.f5570g = iVar.e();
        this.f5567d = gVar;
        this.f5568e = oVar;
        this.f5569f = null;
        this.f5571h = true;
        this.f5572i = k.c();
    }

    private static final Class y(Class cls) {
        if (cls == null) {
            return Object.class;
        }
        return cls;
    }

    /* access modifiers changed from: protected */
    public s A(d dVar, g gVar, o oVar, boolean z10) {
        if (this.f5569f == dVar && this.f5567d == gVar && this.f5568e == oVar && z10 == this.f5571h) {
            return this;
        }
        return new s(this, dVar, gVar, oVar, z10);
    }

    public o a(b0 b0Var, d dVar) {
        g gVar = this.f5567d;
        if (gVar != null) {
            gVar = gVar.a(dVar);
        }
        o oVar = this.f5568e;
        if (oVar != null) {
            return A(dVar, gVar, b0Var.W(oVar, dVar), this.f5571h);
        }
        if (b0Var.a0(q.USE_STATIC_TYPING) || this.f5570g.F()) {
            o F = b0Var.F(this.f5570g, dVar);
            return A(dVar, gVar, F, z(this.f5570g.s(), F));
        } else if (dVar != this.f5569f) {
            return A(dVar, gVar, oVar, this.f5571h);
        } else {
            return this;
        }
    }

    public boolean d(b0 b0Var, Object obj) {
        Object n10 = this.f5566c.n(obj);
        if (n10 == null) {
            return true;
        }
        o oVar = this.f5568e;
        if (oVar == null) {
            try {
                oVar = x(b0Var, n10.getClass());
            } catch (l e10) {
                throw new y(e10);
            }
        }
        return oVar.d(b0Var, n10);
    }

    public void f(Object obj, f fVar, b0 b0Var) {
        Object obj2;
        try {
            obj2 = this.f5566c.n(obj);
        } catch (Exception e10) {
            w(b0Var, e10, obj, this.f5566c.c() + "()");
            obj2 = null;
        }
        if (obj2 == null) {
            b0Var.x(fVar);
            return;
        }
        o oVar = this.f5568e;
        if (oVar == null) {
            oVar = x(b0Var, obj2.getClass());
        }
        g gVar = this.f5567d;
        if (gVar != null) {
            oVar.h(obj2, fVar, b0Var, gVar);
        } else {
            oVar.f(obj2, fVar, b0Var);
        }
    }

    public void h(Object obj, f fVar, b0 b0Var, g gVar) {
        Object obj2;
        try {
            obj2 = this.f5566c.n(obj);
        } catch (Exception e10) {
            w(b0Var, e10, obj, this.f5566c.c() + "()");
            obj2 = null;
        }
        if (obj2 == null) {
            b0Var.x(fVar);
            return;
        }
        o oVar = this.f5568e;
        if (oVar == null) {
            oVar = x(b0Var, obj2.getClass());
        } else if (this.f5571h) {
            b g10 = gVar.g(fVar, gVar.d(obj, com.fasterxml.jackson.core.k.VALUE_STRING));
            oVar.f(obj2, fVar, b0Var);
            gVar.h(fVar, g10);
            return;
        }
        oVar.h(obj2, fVar, b0Var, new a(gVar, obj));
    }

    public String toString() {
        return "(@JsonValue serializer for method " + this.f5566c.k() + "#" + this.f5566c.c() + ")";
    }

    /* access modifiers changed from: protected */
    public o x(b0 b0Var, Class cls) {
        o j10 = this.f5572i.j(cls);
        if (j10 != null) {
            return j10;
        }
        if (this.f5570g.x()) {
            j t10 = b0Var.t(this.f5570g, cls);
            o F = b0Var.F(t10, this.f5569f);
            this.f5572i = this.f5572i.a(t10, F).f13099b;
            return F;
        }
        o G = b0Var.G(cls, this.f5569f);
        this.f5572i = this.f5572i.b(cls, G).f13099b;
        return G;
    }

    /* access modifiers changed from: protected */
    public boolean z(Class cls, o oVar) {
        if (cls.isPrimitive()) {
            if (!(cls == Integer.TYPE || cls == Boolean.TYPE || cls == Double.TYPE)) {
                return false;
            }
        } else if (!(cls == String.class || cls == Integer.class || cls == Boolean.class || cls == Double.class)) {
            return false;
        }
        return u(oVar);
    }

    public s(s sVar, d dVar, g gVar, o oVar, boolean z10) {
        super(y(sVar.c()));
        this.f5566c = sVar.f5566c;
        this.f5570g = sVar.f5570g;
        this.f5567d = gVar;
        this.f5568e = oVar;
        this.f5569f = dVar;
        this.f5571h = z10;
        this.f5572i = k.c();
    }
}
