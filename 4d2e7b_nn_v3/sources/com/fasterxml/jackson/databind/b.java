package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.b;
import com.fasterxml.jackson.annotation.g;
import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.annotation.n;
import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.annotation.q;
import com.fasterxml.jackson.annotation.u;
import com.fasterxml.jackson.annotation.z;
import com.fasterxml.jackson.databind.introspect.a0;
import com.fasterxml.jackson.databind.introspect.b0;
import com.fasterxml.jackson.databind.introspect.c;
import com.fasterxml.jackson.databind.introspect.g;
import com.fasterxml.jackson.databind.introspect.i;
import com.fasterxml.jackson.databind.introspect.j;
import com.fasterxml.jackson.databind.introspect.j0;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import k8.e;
import l8.l;
import q8.f;

public abstract class b implements Serializable {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final C0070a f5201a;

        /* renamed from: b  reason: collision with root package name */
        private final String f5202b;

        /* renamed from: com.fasterxml.jackson.databind.b$a$a  reason: collision with other inner class name */
        public enum C0070a {
            MANAGED_REFERENCE,
            BACK_REFERENCE
        }

        public a(C0070a aVar, String str) {
            this.f5201a = aVar;
            this.f5202b = str;
        }

        public static a a(String str) {
            return new a(C0070a.BACK_REFERENCE, str);
        }

        public static a c(String str) {
            return new a(C0070a.MANAGED_REFERENCE, str);
        }

        public boolean b() {
            if (this.f5201a == C0070a.BACK_REFERENCE) {
                return true;
            }
            return false;
        }
    }

    public static b k0() {
        return a0.f5259a;
    }

    public String A(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public String B(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public n.a C(l lVar, com.fasterxml.jackson.databind.introspect.b bVar) {
        return D(bVar);
    }

    public n.a D(com.fasterxml.jackson.databind.introspect.b bVar) {
        return n.a.f();
    }

    public p.b E(com.fasterxml.jackson.databind.introspect.b bVar) {
        return p.b.c();
    }

    public q.a F(l lVar, com.fasterxml.jackson.databind.introspect.b bVar) {
        return q.a.c();
    }

    public Integer G(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public f H(l lVar, i iVar, j jVar) {
        return null;
    }

    public a I(i iVar) {
        return null;
    }

    public w J(l lVar, g gVar, w wVar) {
        return null;
    }

    public w K(c cVar) {
        return null;
    }

    public Object L(i iVar) {
        return null;
    }

    public Object M(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public String[] N(c cVar) {
        return null;
    }

    public Boolean O(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public e.b P(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public Object Q(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public z.a R(com.fasterxml.jackson.databind.introspect.b bVar) {
        return z.a.c();
    }

    public List S(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public String T(c cVar) {
        return null;
    }

    public f U(l lVar, c cVar, j jVar) {
        return null;
    }

    public com.fasterxml.jackson.databind.util.l V(i iVar) {
        return null;
    }

    public Class[] W(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public w X(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public Boolean Y(com.fasterxml.jackson.databind.introspect.b bVar) {
        if (!(bVar instanceof j) || !Z((j) bVar)) {
            return null;
        }
        return Boolean.TRUE;
    }

    public boolean Z(j jVar) {
        return false;
    }

    /* access modifiers changed from: protected */
    public Annotation a(com.fasterxml.jackson.databind.introspect.b bVar, Class cls) {
        return bVar.b(cls);
    }

    public Boolean a0(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean b(com.fasterxml.jackson.databind.introspect.b bVar, Class cls) {
        return bVar.f(cls);
    }

    public Boolean b0(l lVar, com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean c(com.fasterxml.jackson.databind.introspect.b bVar, Class[] clsArr) {
        return bVar.h(clsArr);
    }

    public Boolean c0(com.fasterxml.jackson.databind.introspect.b bVar) {
        if (!(bVar instanceof j) || !d0((j) bVar)) {
            return null;
        }
        return Boolean.TRUE;
    }

    public void d(l lVar, c cVar, List list) {
    }

    public boolean d0(j jVar) {
        return false;
    }

    public j0 e(c cVar, j0 j0Var) {
        return j0Var;
    }

    public boolean e0(com.fasterxml.jackson.databind.introspect.b bVar) {
        return false;
    }

    public Object f(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public boolean f0(i iVar) {
        return false;
    }

    public Boolean g0(i iVar) {
        return null;
    }

    public g.a h(l lVar, com.fasterxml.jackson.databind.introspect.b bVar) {
        if (!e0(bVar)) {
            return null;
        }
        g.a i10 = i(bVar);
        if (i10 == null) {
            return g.a.DEFAULT;
        }
        return i10;
    }

    public boolean h0(Annotation annotation) {
        return false;
    }

    public g.a i(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public Boolean i0(c cVar) {
        return null;
    }

    public String[] j(Class cls, Enum[] enumArr, String[] strArr) {
        return strArr;
    }

    public Boolean j0(i iVar) {
        return null;
    }

    public Object k(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public i.d l(com.fasterxml.jackson.databind.introspect.b bVar) {
        return i.d.b();
    }

    public j l0(l lVar, com.fasterxml.jackson.databind.introspect.b bVar, j jVar) {
        return jVar;
    }

    public String m(com.fasterxml.jackson.databind.introspect.i iVar) {
        return null;
    }

    public j m0(l lVar, j jVar, j jVar2) {
        return null;
    }

    public b.a n(com.fasterxml.jackson.databind.introspect.i iVar) {
        Object o10 = o(iVar);
        if (o10 != null) {
            return b.a.c(o10);
        }
        return null;
    }

    public Object o(com.fasterxml.jackson.databind.introspect.i iVar) {
        return null;
    }

    public Object p(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public Boolean q(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public w s(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public w t(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public Object u(c cVar) {
        return null;
    }

    public Object v(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public b0 w(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public b0 x(com.fasterxml.jackson.databind.introspect.b bVar, b0 b0Var) {
        return b0Var;
    }

    public u.a y(com.fasterxml.jackson.databind.introspect.b bVar) {
        return null;
    }

    public f z(l lVar, com.fasterxml.jackson.databind.introspect.i iVar, j jVar) {
        return null;
    }
}
