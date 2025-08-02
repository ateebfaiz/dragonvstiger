package l8;

import com.fasterxml.jackson.annotation.e;
import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.annotation.n;
import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.annotation.q;
import com.fasterxml.jackson.annotation.z;
import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.introspect.c;
import com.fasterxml.jackson.databind.introspect.g0;
import com.fasterxml.jackson.databind.introspect.j0;
import com.fasterxml.jackson.databind.q;
import com.fasterxml.jackson.databind.util.f;
import com.fasterxml.jackson.databind.w;
import java.io.Serializable;
import q8.d;

public abstract class m extends l implements Serializable {
    protected static final g C = g.a();
    private static final long X = q.c();
    private static final long Y = ((((q.AUTO_DETECT_FIELDS.e() | q.AUTO_DETECT_GETTERS.e()) | q.AUTO_DETECT_IS_GETTERS.e()) | q.AUTO_DETECT_SETTERS.e()) | q.AUTO_DETECT_CREATORS.e());

    /* renamed from: e  reason: collision with root package name */
    protected final g0 f12727e;

    /* renamed from: f  reason: collision with root package name */
    protected final d f12728f;

    /* renamed from: g  reason: collision with root package name */
    protected final w f12729g;

    /* renamed from: h  reason: collision with root package name */
    protected final Class f12730h;

    /* renamed from: i  reason: collision with root package name */
    protected final i f12731i;

    /* renamed from: j  reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.util.m f12732j;

    /* renamed from: w  reason: collision with root package name */
    protected final h f12733w;

    protected m(a aVar, d dVar, g0 g0Var, com.fasterxml.jackson.databind.util.m mVar, h hVar) {
        super(aVar, X);
        this.f12727e = g0Var;
        this.f12728f = dVar;
        this.f12732j = mVar;
        this.f12729g = null;
        this.f12730h = null;
        this.f12731i = i.b();
        this.f12733w = hVar;
    }

    /* access modifiers changed from: protected */
    public abstract m J(long j10);

    public w K(Class cls) {
        w wVar = this.f12729g;
        if (wVar != null) {
            return wVar;
        }
        return this.f12732j.a(cls, this);
    }

    public final Class L() {
        return this.f12730h;
    }

    public final i M() {
        return this.f12731i;
    }

    public final n.a N(Class cls) {
        n.a c10;
        g b10 = this.f12733w.b(cls);
        if (b10 == null || (c10 = b10.c()) == null) {
            return null;
        }
        return c10;
    }

    public final n.a O(Class cls, c cVar) {
        n.a aVar;
        b h10 = h();
        if (h10 == null) {
            aVar = null;
        } else {
            aVar = h10.C(this, cVar);
        }
        return n.a.j(aVar, N(cls));
    }

    public final p.b P() {
        return this.f12733w.c();
    }

    public final q.a Q(Class cls, c cVar) {
        b h10 = h();
        if (h10 == null) {
            return null;
        }
        return h10.F(this, cVar);
    }

    public final j0 R() {
        j0 f10 = this.f12733w.f();
        long j10 = this.f12725a;
        long j11 = Y;
        if ((j10 & j11) == j11) {
            return f10;
        }
        if (!F(com.fasterxml.jackson.databind.q.AUTO_DETECT_FIELDS)) {
            f10 = f10.e(e.c.NONE);
        }
        if (!F(com.fasterxml.jackson.databind.q.AUTO_DETECT_GETTERS)) {
            f10 = f10.b(e.c.NONE);
        }
        if (!F(com.fasterxml.jackson.databind.q.AUTO_DETECT_IS_GETTERS)) {
            f10 = f10.i(e.c.NONE);
        }
        if (!F(com.fasterxml.jackson.databind.q.AUTO_DETECT_SETTERS)) {
            f10 = f10.l(e.c.NONE);
        }
        if (!F(com.fasterxml.jackson.databind.q.AUTO_DETECT_CREATORS)) {
            return f10.a(e.c.NONE);
        }
        return f10;
    }

    public final w S() {
        return this.f12729g;
    }

    public final d T() {
        return this.f12728f;
    }

    public final m U(com.fasterxml.jackson.databind.q... qVarArr) {
        long j10 = this.f12725a;
        for (com.fasterxml.jackson.databind.q e10 : qVarArr) {
            j10 |= e10.e();
        }
        if (j10 == this.f12725a) {
            return this;
        }
        return J(j10);
    }

    public final m V(com.fasterxml.jackson.databind.q... qVarArr) {
        long j10 = this.f12725a;
        for (com.fasterxml.jackson.databind.q e10 : qVarArr) {
            j10 &= ~e10.e();
        }
        if (j10 == this.f12725a) {
            return this;
        }
        return J(j10);
    }

    public final Class a(Class cls) {
        return this.f12727e.a(cls);
    }

    public final g k(Class cls) {
        g b10 = this.f12733w.b(cls);
        if (b10 == null) {
            return C;
        }
        return b10;
    }

    public final p.b m(Class cls, Class cls2) {
        p.b e10 = k(cls2).e();
        p.b q10 = q(cls);
        if (q10 == null) {
            return e10;
        }
        return q10.n(e10);
    }

    public Boolean o() {
        return this.f12733w.d();
    }

    public final i.d p(Class cls) {
        return this.f12733w.a(cls);
    }

    public final p.b q(Class cls) {
        p.b d10 = k(cls).d();
        p.b P = P();
        if (P == null) {
            return d10;
        }
        return P.n(d10);
    }

    public final z.a t() {
        return this.f12733w.e();
    }

    public final j0 v(Class cls, c cVar) {
        j0 j0Var;
        if (f.H(cls)) {
            j0Var = j0.a.o();
        } else {
            j0Var = R();
        }
        b h10 = h();
        if (h10 != null) {
            j0Var = h10.e(cVar, j0Var);
        }
        g b10 = this.f12733w.b(cls);
        if (b10 == null) {
            return j0Var;
        }
        b10.i();
        return j0Var.h((e.b) null);
    }

    protected m(m mVar, long j10) {
        super((l) mVar, j10);
        this.f12727e = mVar.f12727e;
        this.f12728f = mVar.f12728f;
        this.f12732j = mVar.f12732j;
        this.f12729g = mVar.f12729g;
        this.f12730h = mVar.f12730h;
        this.f12731i = mVar.f12731i;
        this.f12733w = mVar.f12733w;
    }
}
