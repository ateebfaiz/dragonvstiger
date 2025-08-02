package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.io.h;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.introspect.i;
import com.fasterxml.jackson.databind.introspect.s;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.q;
import com.fasterxml.jackson.databind.ser.std.d;
import com.fasterxml.jackson.databind.util.a;
import com.fasterxml.jackson.databind.util.l;
import com.fasterxml.jackson.databind.w;
import com.fasterxml.jackson.databind.z;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import q8.g;
import t8.k;
import t8.r;

public class c extends n implements Serializable {
    public static final Object Q0 = p.a.NON_EMPTY;
    protected o C;
    protected final Object N0;
    protected final Class[] O0;
    protected transient HashMap P0;
    protected g X;
    protected transient k Y;
    protected final boolean Z;

    /* renamed from: b  reason: collision with root package name */
    protected final h f5488b;

    /* renamed from: c  reason: collision with root package name */
    protected final w f5489c;

    /* renamed from: d  reason: collision with root package name */
    protected final j f5490d;

    /* renamed from: e  reason: collision with root package name */
    protected final j f5491e;

    /* renamed from: f  reason: collision with root package name */
    protected j f5492f;

    /* renamed from: g  reason: collision with root package name */
    protected final transient a f5493g;

    /* renamed from: h  reason: collision with root package name */
    protected final i f5494h;

    /* renamed from: i  reason: collision with root package name */
    protected transient Method f5495i;

    /* renamed from: j  reason: collision with root package name */
    protected transient Field f5496j;

    /* renamed from: w  reason: collision with root package name */
    protected o f5497w;

    public c(s sVar, i iVar, a aVar, j jVar, o oVar, g gVar, j jVar2, boolean z10, Object obj, Class[] clsArr) {
        super(sVar);
        this.f5494h = iVar;
        this.f5493g = aVar;
        this.f5488b = new h(sVar.l());
        this.f5489c = sVar.p();
        this.f5490d = jVar;
        this.f5497w = oVar;
        this.Y = oVar == null ? k.c() : null;
        this.X = gVar;
        this.f5491e = jVar2;
        if (iVar instanceof com.fasterxml.jackson.databind.introspect.g) {
            this.f5495i = null;
            this.f5496j = (Field) iVar.m();
        } else if (iVar instanceof com.fasterxml.jackson.databind.introspect.j) {
            this.f5495i = (Method) iVar.m();
            this.f5496j = null;
        } else {
            this.f5495i = null;
            this.f5496j = null;
        }
        this.Z = z10;
        this.N0 = obj;
        this.C = null;
        this.O0 = clsArr;
    }

    public boolean A() {
        return this.Z;
    }

    public boolean B(w wVar) {
        w wVar2 = this.f5489c;
        if (wVar2 != null) {
            return wVar2.equals(wVar);
        }
        if (!wVar.f(this.f5488b.getValue()) || wVar.d()) {
            return false;
        }
        return true;
    }

    public i b() {
        return this.f5494h;
    }

    /* access modifiers changed from: protected */
    public o d(k kVar, Class cls, b0 b0Var) {
        k.d dVar;
        j jVar = this.f5492f;
        if (jVar != null) {
            dVar = kVar.e(b0Var.t(jVar, cls), b0Var, this);
        } else {
            dVar = kVar.f(cls, b0Var, this);
        }
        k kVar2 = dVar.f13099b;
        if (kVar != kVar2) {
            this.Y = kVar2;
        }
        return dVar.f13098a;
    }

    /* access modifiers changed from: protected */
    public boolean e(Object obj, f fVar, b0 b0Var, o oVar) {
        if (oVar.j()) {
            return false;
        }
        if (b0Var.b0(a0.FAIL_ON_SELF_REFERENCES)) {
            if (!(oVar instanceof d)) {
                return false;
            }
            b0Var.j(getType(), "Direct self-reference leading to cycle");
            return false;
        } else if (!b0Var.b0(a0.WRITE_SELF_REFERENCES_AS_NULL)) {
            return false;
        } else {
            if (this.C == null) {
                return true;
            }
            if (!fVar.v().d()) {
                fVar.S(this.f5488b);
            }
            this.C.f((Object) null, fVar, b0Var);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public c f(w wVar) {
        return new c(this, wVar);
    }

    public j getType() {
        return this.f5490d;
    }

    public void h(o oVar) {
        o oVar2 = this.C;
        if (oVar2 == null || oVar2 == oVar) {
            this.C = oVar;
            return;
        }
        throw new IllegalStateException(String.format("Cannot override _nullSerializer: had a %s, trying to set to %s", new Object[]{com.fasterxml.jackson.databind.util.f.h(this.C), com.fasterxml.jackson.databind.util.f.h(oVar)}));
    }

    public void i(o oVar) {
        o oVar2 = this.f5497w;
        if (oVar2 == null || oVar2 == oVar) {
            this.f5497w = oVar;
            return;
        }
        throw new IllegalStateException(String.format("Cannot override _serializer: had a %s, trying to set to %s", new Object[]{com.fasterxml.jackson.databind.util.f.h(this.f5497w), com.fasterxml.jackson.databind.util.f.h(oVar)}));
    }

    public void j(g gVar) {
        this.X = gVar;
    }

    public void k(z zVar) {
        this.f5494h.i(zVar.F(q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public final Object l(Object obj) {
        Method method = this.f5495i;
        if (method == null) {
            return this.f5496j.get(obj);
        }
        return method.invoke(obj, (Object[]) null);
    }

    public String m() {
        return this.f5488b.getValue();
    }

    public j n() {
        return this.f5491e;
    }

    public g o() {
        return this.X;
    }

    public Class[] p() {
        return this.O0;
    }

    public boolean q() {
        if (this.C != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Object readResolve() {
        i iVar = this.f5494h;
        if (iVar instanceof com.fasterxml.jackson.databind.introspect.g) {
            this.f5495i = null;
            this.f5496j = (Field) iVar.m();
        } else if (iVar instanceof com.fasterxml.jackson.databind.introspect.j) {
            this.f5495i = (Method) iVar.m();
            this.f5496j = null;
        }
        if (this.f5497w == null) {
            this.Y = k.c();
        }
        return this;
    }

    public boolean s() {
        if (this.f5497w != null) {
            return true;
        }
        return false;
    }

    public c t(l lVar) {
        String c10 = lVar.c(this.f5488b.getValue());
        if (c10.equals(this.f5488b.toString())) {
            return this;
        }
        return f(w.a(c10));
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("property '");
        sb2.append(m());
        sb2.append("' (");
        if (this.f5495i != null) {
            sb2.append("via method ");
            sb2.append(this.f5495i.getDeclaringClass().getName());
            sb2.append("#");
            sb2.append(this.f5495i.getName());
        } else if (this.f5496j != null) {
            sb2.append("field \"");
            sb2.append(this.f5496j.getDeclaringClass().getName());
            sb2.append("#");
            sb2.append(this.f5496j.getName());
        } else {
            sb2.append("virtual");
        }
        if (this.f5497w == null) {
            sb2.append(", no static serializer");
        } else {
            sb2.append(", static serializer of type " + this.f5497w.getClass().getName());
        }
        sb2.append(')');
        return sb2.toString();
    }

    public void u(Object obj, f fVar, b0 b0Var) {
        Object obj2;
        Method method = this.f5495i;
        if (method == null) {
            obj2 = this.f5496j.get(obj);
        } else {
            obj2 = method.invoke(obj, (Object[]) null);
        }
        if (obj2 == null) {
            o oVar = this.C;
            if (oVar != null) {
                oVar.f((Object) null, fVar, b0Var);
            } else {
                fVar.U();
            }
        } else {
            o oVar2 = this.f5497w;
            if (oVar2 == null) {
                Class<?> cls = obj2.getClass();
                k kVar = this.Y;
                o j10 = kVar.j(cls);
                if (j10 == null) {
                    oVar2 = d(kVar, cls, b0Var);
                } else {
                    oVar2 = j10;
                }
            }
            Object obj3 = this.N0;
            if (obj3 != null) {
                if (Q0 == obj3) {
                    if (oVar2.d(b0Var, obj2)) {
                        x(obj, fVar, b0Var);
                        return;
                    }
                } else if (obj3.equals(obj2)) {
                    x(obj, fVar, b0Var);
                    return;
                }
            }
            if (obj2 != obj || !e(obj, fVar, b0Var, oVar2)) {
                g gVar = this.X;
                if (gVar == null) {
                    oVar2.f(obj2, fVar, b0Var);
                } else {
                    oVar2.h(obj2, fVar, b0Var, gVar);
                }
            }
        }
    }

    public void v(Object obj, f fVar, b0 b0Var) {
        Object obj2;
        Method method = this.f5495i;
        if (method == null) {
            obj2 = this.f5496j.get(obj);
        } else {
            obj2 = method.invoke(obj, (Object[]) null);
        }
        if (obj2 != null) {
            o oVar = this.f5497w;
            if (oVar == null) {
                Class<?> cls = obj2.getClass();
                k kVar = this.Y;
                o j10 = kVar.j(cls);
                if (j10 == null) {
                    oVar = d(kVar, cls, b0Var);
                } else {
                    oVar = j10;
                }
            }
            Object obj3 = this.N0;
            if (obj3 != null) {
                if (Q0 == obj3) {
                    if (oVar.d(b0Var, obj2)) {
                        return;
                    }
                } else if (obj3.equals(obj2)) {
                    return;
                }
            }
            if (obj2 != obj || !e(obj, fVar, b0Var, oVar)) {
                fVar.S(this.f5488b);
                g gVar = this.X;
                if (gVar == null) {
                    oVar.f(obj2, fVar, b0Var);
                } else {
                    oVar.h(obj2, fVar, b0Var, gVar);
                }
            }
        } else if (this.C != null) {
            fVar.S(this.f5488b);
            this.C.f((Object) null, fVar, b0Var);
        }
    }

    public void w(Object obj, f fVar, b0 b0Var) {
        if (!fVar.j()) {
            fVar.f0(this.f5488b.getValue());
        }
    }

    public void x(Object obj, f fVar, b0 b0Var) {
        o oVar = this.C;
        if (oVar != null) {
            oVar.f((Object) null, fVar, b0Var);
        } else {
            fVar.U();
        }
    }

    public void y(j jVar) {
        this.f5492f = jVar;
    }

    public c z(l lVar) {
        return new r(this, lVar);
    }

    protected c(c cVar) {
        this(cVar, cVar.f5488b);
    }

    protected c(c cVar, w wVar) {
        super((n) cVar);
        this.f5488b = new h(wVar.c());
        this.f5489c = cVar.f5489c;
        this.f5493g = cVar.f5493g;
        this.f5490d = cVar.f5490d;
        this.f5494h = cVar.f5494h;
        this.f5495i = cVar.f5495i;
        this.f5496j = cVar.f5496j;
        this.f5497w = cVar.f5497w;
        this.C = cVar.C;
        if (cVar.P0 != null) {
            this.P0 = new HashMap(cVar.P0);
        }
        this.f5491e = cVar.f5491e;
        this.Y = cVar.Y;
        this.Z = cVar.Z;
        this.N0 = cVar.N0;
        this.O0 = cVar.O0;
        this.X = cVar.X;
        this.f5492f = cVar.f5492f;
    }

    protected c(c cVar, h hVar) {
        super((n) cVar);
        this.f5488b = hVar;
        this.f5489c = cVar.f5489c;
        this.f5494h = cVar.f5494h;
        this.f5493g = cVar.f5493g;
        this.f5490d = cVar.f5490d;
        this.f5495i = cVar.f5495i;
        this.f5496j = cVar.f5496j;
        this.f5497w = cVar.f5497w;
        this.C = cVar.C;
        if (cVar.P0 != null) {
            this.P0 = new HashMap(cVar.P0);
        }
        this.f5491e = cVar.f5491e;
        this.Y = cVar.Y;
        this.Z = cVar.Z;
        this.N0 = cVar.N0;
        this.O0 = cVar.O0;
        this.X = cVar.X;
        this.f5492f = cVar.f5492f;
    }
}
