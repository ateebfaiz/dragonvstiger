package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.annotation.i0;
import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.introspect.b;
import com.fasterxml.jackson.databind.introspect.s;
import com.fasterxml.jackson.databind.ser.k;
import com.fasterxml.jackson.databind.ser.q;
import com.fasterxml.jackson.databind.ser.std.u;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import l8.i;
import n8.a;
import q8.g;
import t8.c;
import t8.l;
import t8.o;
import t8.p;
import t8.t;

public abstract class b0 extends e {
    public static final o X = new c("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
    protected static final o Y = new p();
    protected final boolean C;

    /* renamed from: a  reason: collision with root package name */
    protected final z f5206a;

    /* renamed from: b  reason: collision with root package name */
    protected final Class f5207b;

    /* renamed from: c  reason: collision with root package name */
    protected final q f5208c;

    /* renamed from: d  reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.ser.p f5209d;

    /* renamed from: e  reason: collision with root package name */
    protected transient i f5210e;

    /* renamed from: f  reason: collision with root package name */
    protected o f5211f;

    /* renamed from: g  reason: collision with root package name */
    protected o f5212g;

    /* renamed from: h  reason: collision with root package name */
    protected o f5213h;

    /* renamed from: i  reason: collision with root package name */
    protected o f5214i;

    /* renamed from: j  reason: collision with root package name */
    protected final l f5215j;

    /* renamed from: w  reason: collision with root package name */
    protected DateFormat f5216w;

    public b0() {
        this.f5211f = Y;
        this.f5213h = u.f5585c;
        this.f5214i = X;
        this.f5206a = null;
        this.f5208c = null;
        this.f5209d = new com.fasterxml.jackson.databind.ser.p();
        this.f5215j = null;
        this.f5207b = null;
        this.f5210e = null;
        this.C = true;
    }

    public o A(j jVar, d dVar) {
        return p(this.f5208c.a(this, jVar, this.f5212g), dVar);
    }

    public o B(Class cls, d dVar) {
        return A(this.f5206a.e(cls), dVar);
    }

    public o C(j jVar, d dVar) {
        return this.f5214i;
    }

    public o D(d dVar) {
        return this.f5213h;
    }

    public abstract t E(Object obj, i0 i0Var);

    public o F(j jVar, d dVar) {
        o d10 = this.f5215j.d(jVar);
        if (d10 == null && (d10 = this.f5209d.g(jVar)) == null && (d10 = l(jVar)) == null) {
            return V(jVar.s());
        }
        return W(d10, dVar);
    }

    public o G(Class cls, d dVar) {
        o e10 = this.f5215j.e(cls);
        if (e10 == null && (e10 = this.f5209d.h(cls)) == null && (e10 = this.f5209d.g(this.f5206a.e(cls))) == null && (e10 = m(cls)) == null) {
            return V(cls);
        }
        return W(e10, dVar);
    }

    public o H(Class cls, boolean z10, d dVar) {
        o c10 = this.f5215j.c(cls);
        if (c10 != null) {
            return c10;
        }
        o f10 = this.f5209d.f(cls);
        if (f10 != null) {
            return f10;
        }
        o J = J(cls, dVar);
        q qVar = this.f5208c;
        z zVar = this.f5206a;
        g c11 = qVar.c(zVar, zVar.e(cls));
        if (c11 != null) {
            J = new o(c11.a(dVar), J);
        }
        if (z10) {
            this.f5209d.d(cls, J);
        }
        return J;
    }

    public o I(j jVar, d dVar) {
        if (jVar == null) {
            g0("Null passed for `valueType` of `findValueSerializer()`", new Object[0]);
        }
        o d10 = this.f5215j.d(jVar);
        if (d10 == null && (d10 = this.f5209d.g(jVar)) == null && (d10 = l(jVar)) == null) {
            return V(jVar.s());
        }
        return X(d10, dVar);
    }

    public o J(Class cls, d dVar) {
        o e10 = this.f5215j.e(cls);
        if (e10 == null && (e10 = this.f5209d.h(cls)) == null && (e10 = this.f5209d.g(this.f5206a.e(cls))) == null && (e10 = m(cls)) == null) {
            return V(cls);
        }
        return X(e10, dVar);
    }

    public final Class K() {
        return this.f5207b;
    }

    public final b L() {
        return this.f5206a.h();
    }

    public Object M(Object obj) {
        return this.f5210e.a(obj);
    }

    /* renamed from: N */
    public final z f() {
        return this.f5206a;
    }

    public o O() {
        return this.f5213h;
    }

    public final i.d P(Class cls) {
        return this.f5206a.p(cls);
    }

    public final p.b Q(Class cls) {
        return this.f5206a.q(cls);
    }

    public final k R() {
        this.f5206a.Y();
        return null;
    }

    public abstract f S();

    public Locale T() {
        return this.f5206a.x();
    }

    public TimeZone U() {
        return this.f5206a.A();
    }

    public o V(Class cls) {
        if (cls == Object.class) {
            return this.f5211f;
        }
        return new t8.p(cls);
    }

    public o W(o oVar, d dVar) {
        if (oVar == null || !(oVar instanceof com.fasterxml.jackson.databind.ser.i)) {
            return oVar;
        }
        return ((com.fasterxml.jackson.databind.ser.i) oVar).a(this, dVar);
    }

    public o X(o oVar, d dVar) {
        if (oVar == null || !(oVar instanceof com.fasterxml.jackson.databind.ser.i)) {
            return oVar;
        }
        return ((com.fasterxml.jackson.databind.ser.i) oVar).a(this, dVar);
    }

    public abstract Object Y(s sVar, Class cls);

    public abstract boolean Z(Object obj);

    public final boolean a0(q qVar) {
        return this.f5206a.F(qVar);
    }

    public final boolean b0(a0 a0Var) {
        return this.f5206a.b0(a0Var);
    }

    public l c0(String str, Object... objArr) {
        return l.i(S(), a(str, objArr));
    }

    public Object d0(Class cls, String str, Throwable th) {
        throw a.t(S(), str, d(cls)).n(th);
    }

    public Object e0(c cVar, s sVar, String str, Object... objArr) {
        String str2;
        String a10 = a(str, objArr);
        String str3 = "N/A";
        if (sVar != null) {
            str2 = b(sVar.l());
        } else {
            str2 = str3;
        }
        if (cVar != null) {
            str3 = com.fasterxml.jackson.databind.util.f.Q(cVar.i());
        }
        throw a.s(S(), String.format("Invalid definition for property %s (of type %s): %s", new Object[]{str2, str3, a10}), cVar, sVar);
    }

    public Object f0(c cVar, String str, Object... objArr) {
        String str2;
        if (cVar != null) {
            str2 = com.fasterxml.jackson.databind.util.f.Q(cVar.i());
        } else {
            str2 = "N/A";
        }
        throw a.s(S(), String.format("Invalid type definition for type %s: %s", new Object[]{str2, a(str, objArr)}), cVar, (s) null);
    }

    public void g0(String str, Object... objArr) {
        throw c0(str, objArr);
    }

    public final com.fasterxml.jackson.databind.type.o h() {
        return this.f5206a.B();
    }

    public void h0(Throwable th, String str, Object... objArr) {
        throw l.j(S(), a(str, objArr), th);
    }

    public abstract o i0(b bVar, Object obj);

    public Object j(j jVar, String str) {
        throw a.t(S(), str, jVar);
    }

    public b0 j0(Object obj, Object obj2) {
        this.f5210e = this.f5210e.c(obj, obj2);
        return this;
    }

    /* access modifiers changed from: protected */
    public o l(j jVar) {
        o oVar;
        try {
            oVar = n(jVar);
        } catch (IllegalArgumentException e10) {
            h0(e10, com.fasterxml.jackson.databind.util.f.m(e10), new Object[0]);
            oVar = null;
        }
        if (oVar != null) {
            this.f5209d.b(jVar, oVar, this);
        }
        return oVar;
    }

    /* access modifiers changed from: protected */
    public o m(Class cls) {
        o oVar;
        j e10 = this.f5206a.e(cls);
        try {
            oVar = n(e10);
        } catch (IllegalArgumentException e11) {
            j(e10, com.fasterxml.jackson.databind.util.f.m(e11));
            oVar = null;
        }
        if (oVar != null) {
            this.f5209d.c(cls, e10, oVar, this);
        }
        return oVar;
    }

    /* access modifiers changed from: protected */
    public o n(j jVar) {
        return this.f5208c.b(this, jVar);
    }

    /* access modifiers changed from: protected */
    public final DateFormat o() {
        DateFormat dateFormat = this.f5216w;
        if (dateFormat != null) {
            return dateFormat;
        }
        DateFormat dateFormat2 = (DateFormat) this.f5206a.l().clone();
        this.f5216w = dateFormat2;
        return dateFormat2;
    }

    /* access modifiers changed from: protected */
    public o p(o oVar, d dVar) {
        if (oVar instanceof com.fasterxml.jackson.databind.ser.o) {
            ((com.fasterxml.jackson.databind.ser.o) oVar).b(this);
        }
        return X(oVar, dVar);
    }

    /* access modifiers changed from: protected */
    public o q(o oVar) {
        if (oVar instanceof com.fasterxml.jackson.databind.ser.o) {
            ((com.fasterxml.jackson.databind.ser.o) oVar).b(this);
        }
        return oVar;
    }

    public final boolean s() {
        return this.f5206a.b();
    }

    public j t(j jVar, Class cls) {
        if (jVar.z(cls)) {
            return jVar;
        }
        return f().B().D(jVar, cls, true);
    }

    public void u(long j10, f fVar) {
        if (b0(a0.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
            fVar.T(String.valueOf(j10));
        } else {
            fVar.T(o().format(new Date(j10)));
        }
    }

    public void v(Date date, f fVar) {
        if (b0(a0.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
            fVar.T(String.valueOf(date.getTime()));
        } else {
            fVar.T(o().format(date));
        }
    }

    public final void w(Date date, f fVar) {
        if (b0(a0.WRITE_DATES_AS_TIMESTAMPS)) {
            fVar.Y(date.getTime());
        } else {
            fVar.s0(o().format(date));
        }
    }

    public final void x(f fVar) {
        if (this.C) {
            fVar.U();
        } else {
            this.f5213h.f((Object) null, fVar, this);
        }
    }

    public o y(j jVar, d dVar) {
        o d10 = this.f5215j.d(jVar);
        if (d10 == null && (d10 = this.f5209d.g(jVar)) == null && (d10 = l(jVar)) == null) {
            return V(jVar.s());
        }
        return X(d10, dVar);
    }

    public o z(Class cls, d dVar) {
        o e10 = this.f5215j.e(cls);
        if (e10 == null && (e10 = this.f5209d.h(cls)) == null && (e10 = this.f5209d.g(this.f5206a.e(cls))) == null && (e10 = m(cls)) == null) {
            return V(cls);
        }
        return X(e10, dVar);
    }

    protected b0(b0 b0Var, z zVar, q qVar) {
        this.f5211f = Y;
        this.f5213h = u.f5585c;
        o oVar = X;
        this.f5214i = oVar;
        this.f5208c = qVar;
        this.f5206a = zVar;
        com.fasterxml.jackson.databind.ser.p pVar = b0Var.f5209d;
        this.f5209d = pVar;
        this.f5211f = b0Var.f5211f;
        this.f5212g = b0Var.f5212g;
        o oVar2 = b0Var.f5213h;
        this.f5213h = oVar2;
        this.f5214i = b0Var.f5214i;
        this.C = oVar2 == oVar;
        this.f5207b = zVar.L();
        this.f5210e = zVar.M();
        this.f5215j = pVar.e();
    }
}
