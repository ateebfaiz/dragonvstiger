package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.b;
import com.fasterxml.jackson.core.d;
import com.fasterxml.jackson.core.i;
import com.fasterxml.jackson.core.l;
import com.fasterxml.jackson.databind.deser.d;
import com.fasterxml.jackson.databind.introspect.g0;
import com.fasterxml.jackson.databind.introspect.r;
import com.fasterxml.jackson.databind.introspect.t;
import com.fasterxml.jackson.databind.introspect.w;
import com.fasterxml.jackson.databind.introspect.x;
import com.fasterxml.jackson.databind.ser.j;
import com.fasterxml.jackson.databind.ser.q;
import com.fasterxml.jackson.databind.type.o;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import l8.a;
import l8.h;
import l8.k;
import l8.m;
import q8.f;
import r8.g;

public class s extends l implements Serializable {
    protected static final b X;
    protected static final a Y;
    protected final ConcurrentHashMap C;

    /* renamed from: a  reason: collision with root package name */
    protected final d f5468a;

    /* renamed from: b  reason: collision with root package name */
    protected o f5469b;

    /* renamed from: c  reason: collision with root package name */
    protected q8.d f5470c;

    /* renamed from: d  reason: collision with root package name */
    protected final h f5471d;

    /* renamed from: e  reason: collision with root package name */
    protected final l8.d f5472e;

    /* renamed from: f  reason: collision with root package name */
    protected g0 f5473f;

    /* renamed from: g  reason: collision with root package name */
    protected z f5474g;

    /* renamed from: h  reason: collision with root package name */
    protected j f5475h;

    /* renamed from: i  reason: collision with root package name */
    protected q f5476i;

    /* renamed from: j  reason: collision with root package name */
    protected g f5477j;

    /* renamed from: w  reason: collision with root package name */
    protected com.fasterxml.jackson.databind.deser.d f5478w;

    static {
        x xVar = new x();
        X = xVar;
        Y = new a((t) null, xVar, (x) null, o.F(), (f) null, com.fasterxml.jackson.databind.util.o.X, (k) null, Locale.getDefault(), (TimeZone) null, b.a(), g.f12949a, new w.b());
    }

    public s() {
        this((d) null, (j) null, (com.fasterxml.jackson.databind.deser.d) null);
    }

    private final void c(com.fasterxml.jackson.core.f fVar, Object obj, z zVar) {
        Closeable closeable = (Closeable) obj;
        try {
            b(zVar).q0(fVar, obj);
            try {
                closeable.close();
                fVar.close();
            } catch (Exception e10) {
                e = e10;
                closeable = null;
                com.fasterxml.jackson.databind.util.f.i(fVar, closeable, e);
            }
        } catch (Exception e11) {
            e = e11;
            com.fasterxml.jackson.databind.util.f.i(fVar, closeable, e);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null", new Object[]{str}));
        }
    }

    /* access modifiers changed from: protected */
    public j b(z zVar) {
        return this.f5475h.p0(zVar, this.f5476i);
    }

    /* access modifiers changed from: protected */
    public final void d(com.fasterxml.jackson.core.f fVar, Object obj) {
        z i10 = i();
        if (!i10.b0(a0.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) {
            try {
                b(i10).q0(fVar, obj);
                fVar.close();
            } catch (Exception e10) {
                com.fasterxml.jackson.databind.util.f.j(fVar, e10);
            }
        } else {
            c(fVar, obj, i10);
        }
    }

    public s e(q qVar, boolean z10) {
        m V;
        m V2;
        if (z10) {
            V = this.f5474g.U(qVar);
        } else {
            V = this.f5474g.V(qVar);
        }
        this.f5474g = (z) V;
        if (z10) {
            V2 = this.f5477j.U(qVar);
        } else {
            V2 = this.f5477j.V(qVar);
        }
        this.f5477j = (g) V2;
        return this;
    }

    public com.fasterxml.jackson.core.f f(Writer writer) {
        a("w", writer);
        com.fasterxml.jackson.core.f h10 = this.f5468a.h(writer);
        this.f5474g.Z(h10);
        return h10;
    }

    /* access modifiers changed from: protected */
    public t h() {
        return new r();
    }

    public z i() {
        return this.f5474g;
    }

    public String j(Object obj) {
        com.fasterxml.jackson.core.io.g gVar = new com.fasterxml.jackson.core.io.g(this.f5468a.e());
        try {
            d(f(gVar), obj);
            return gVar.a();
        } catch (i e10) {
            throw e10;
        } catch (IOException e11) {
            throw l.k(e11);
        }
    }

    public s(d dVar) {
        this(dVar, (j) null, (com.fasterxml.jackson.databind.deser.d) null);
    }

    public s(d dVar, j jVar, com.fasterxml.jackson.databind.deser.d dVar2) {
        this.C = new ConcurrentHashMap(64, 0.6f, 2);
        if (dVar == null) {
            this.f5468a = new r(this);
        } else {
            this.f5468a = dVar;
            if (dVar.i() == null) {
                dVar.k(this);
            }
        }
        this.f5470c = new r8.i();
        com.fasterxml.jackson.databind.util.m mVar = new com.fasterxml.jackson.databind.util.m();
        this.f5469b = o.F();
        g0 g0Var = new g0((t.a) null);
        this.f5473f = g0Var;
        a n10 = Y.n(h());
        h hVar = new h();
        this.f5471d = hVar;
        l8.d dVar3 = new l8.d();
        this.f5472e = dVar3;
        a aVar = n10;
        g0 g0Var2 = g0Var;
        com.fasterxml.jackson.databind.util.m mVar2 = mVar;
        h hVar2 = hVar;
        this.f5474g = new z(aVar, this.f5470c, g0Var2, mVar2, hVar2);
        this.f5477j = new g(aVar, this.f5470c, g0Var2, mVar2, hVar2, dVar3);
        boolean j10 = this.f5468a.j();
        z zVar = this.f5474g;
        q qVar = q.SORT_PROPERTIES_ALPHABETICALLY;
        if (zVar.F(qVar) ^ j10) {
            e(qVar, j10);
        }
        this.f5475h = jVar == null ? new j.a() : jVar;
        this.f5478w = dVar2 == null ? new d.a(com.fasterxml.jackson.databind.deser.b.f5234w) : dVar2;
        this.f5476i = com.fasterxml.jackson.databind.ser.f.f5507d;
    }
}
