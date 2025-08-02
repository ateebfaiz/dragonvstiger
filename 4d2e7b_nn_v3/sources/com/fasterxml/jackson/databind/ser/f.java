package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.c0;
import com.fasterxml.jackson.annotation.i0;
import com.fasterxml.jackson.annotation.l0;
import com.fasterxml.jackson.annotation.n;
import com.fasterxml.jackson.annotation.q;
import com.fasterxml.jackson.core.h;
import com.fasterxml.jackson.core.p;
import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.c;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.e;
import com.fasterxml.jackson.databind.introspect.i;
import com.fasterxml.jackson.databind.introspect.s;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.l;
import com.fasterxml.jackson.databind.ser.std.k0;
import com.fasterxml.jackson.databind.t;
import com.fasterxml.jackson.databind.u;
import com.fasterxml.jackson.databind.v;
import com.fasterxml.jackson.databind.w;
import com.fasterxml.jackson.databind.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import l8.o;
import q8.g;
import t8.q;

public class f extends b implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final f f5507d = new f((o) null);

    protected f(o oVar) {
        super(oVar);
    }

    /* access modifiers changed from: protected */
    public c I(b0 b0Var, s sVar, l lVar, boolean z10, i iVar) {
        g V;
        b0 b0Var2 = b0Var;
        i iVar2 = iVar;
        w h10 = sVar.h();
        j e10 = iVar.e();
        d.a aVar = new d.a(h10, e10, sVar.p(), iVar, sVar.j());
        com.fasterxml.jackson.databind.o F = F(b0Var, iVar2);
        if (F instanceof o) {
            ((o) F).b(b0Var);
        }
        com.fasterxml.jackson.databind.o W = b0Var.W(F, aVar);
        if (e10.C() || e10.d()) {
            V = V(e10, b0Var.f(), iVar2);
        } else {
            V = null;
        }
        g gVar = V;
        return lVar.c(b0Var, sVar, e10, W, W(e10, b0Var.f(), iVar2), gVar, iVar, z10);
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.o J(b0 b0Var, j jVar, c cVar, boolean z10) {
        com.fasterxml.jackson.databind.o oVar;
        z N = b0Var.f();
        if (jVar.C()) {
            if (!z10) {
                z10 = H(N, cVar, (g) null);
            }
            oVar = m(b0Var, jVar, cVar, z10);
            if (oVar != null) {
                return oVar;
            }
        } else {
            if (jVar.d()) {
                oVar = A(b0Var, (com.fasterxml.jackson.databind.type.j) jVar, cVar, z10);
            } else {
                Iterator it = v().iterator();
                if (!it.hasNext()) {
                    oVar = null;
                } else {
                    c.d.a(it.next());
                    throw null;
                }
            }
            if (oVar == null) {
                oVar = C(b0Var, jVar, cVar);
            }
        }
        if (oVar == null && (oVar = D(jVar, N, cVar, z10)) == null && (oVar = E(b0Var, jVar, cVar, z10)) == null && (oVar = T(b0Var, jVar, cVar, z10)) == null) {
            oVar = b0Var.V(cVar.i());
        }
        if (oVar != null && this.f5485a.b()) {
            Iterator it2 = this.f5485a.d().iterator();
            if (it2.hasNext()) {
                c.d.a(it2.next());
                throw null;
            }
        }
        return oVar;
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.o K(b0 b0Var, j jVar, c cVar) {
        String a10 = com.fasterxml.jackson.databind.util.d.a(jVar);
        if (a10 == null || b0Var.f().a(jVar.s()) != null) {
            return null;
        }
        return new q(jVar, a10);
    }

    /* access modifiers changed from: protected */
    public boolean L(b0 b0Var, j jVar) {
        Class s10 = jVar.s();
        if (com.fasterxml.jackson.databind.s.class.isAssignableFrom(s10) || t.class.isAssignableFrom(s10) || u.class.isAssignableFrom(s10) || e.class.isAssignableFrom(s10) || p.class.isAssignableFrom(s10) || h.class.isAssignableFrom(s10) || com.fasterxml.jackson.core.f.class.isAssignableFrom(s10)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.o M(b0 b0Var, j jVar, c cVar, boolean z10) {
        List list;
        b0 b0Var2 = b0Var;
        j jVar2 = jVar;
        c cVar2 = cVar;
        Class<Object> cls = Object.class;
        if (cVar.i() == cls) {
            return b0Var2.V(cls);
        }
        com.fasterxml.jackson.databind.o K = K(b0Var, jVar, cVar);
        if (K != null) {
            return K;
        }
        if (L(b0Var, jVar)) {
            return new k0(jVar2);
        }
        z N = b0Var.f();
        e N2 = N(cVar2);
        N2.j(N);
        List U = U(b0Var2, cVar2, N2);
        if (U == null) {
            list = new ArrayList();
        } else {
            list = a0(b0Var2, cVar2, N2, U);
        }
        b0Var.L().d(N, cVar.k(), list);
        if (this.f5485a.b()) {
            Iterator it = this.f5485a.d().iterator();
            if (it.hasNext()) {
                c.d.a(it.next());
                throw null;
            }
        }
        List R = R(N, cVar2, S(N, cVar2, list));
        if (this.f5485a.b()) {
            Iterator it2 = this.f5485a.d().iterator();
            if (it2.hasNext()) {
                c.d.a(it2.next());
                throw null;
            }
        }
        N2.m(P(b0Var2, cVar2, R));
        N2.n(R);
        N2.k(y(N, cVar2));
        i a10 = cVar.a();
        if (a10 != null) {
            j e10 = a10.e();
            j l10 = e10.l();
            g c10 = c(N, l10);
            com.fasterxml.jackson.databind.o F = F(b0Var2, a10);
            if (F == null) {
                F = com.fasterxml.jackson.databind.ser.std.t.H((Set) null, e10, N.F(com.fasterxml.jackson.databind.q.USE_STATIC_TYPING), c10, (com.fasterxml.jackson.databind.o) null, (com.fasterxml.jackson.databind.o) null, (Object) null);
            }
            com.fasterxml.jackson.databind.o oVar = F;
            d.a aVar = r9;
            d.a aVar2 = new d.a(w.a(a10.c()), l10, (w) null, a10, v.f5721i);
            N2.i(new a(aVar, a10, oVar));
        }
        Y(N, N2);
        if (this.f5485a.b()) {
            Iterator it3 = this.f5485a.d().iterator();
            if (it3.hasNext()) {
                c.d.a(it3.next());
                throw null;
            }
        }
        try {
            com.fasterxml.jackson.databind.o a11 = N2.a();
            if (a11 == null) {
                if (jVar.K()) {
                    return N2.b();
                }
                a11 = B(N, jVar2, cVar2, z10);
                if (a11 == null && cVar.n()) {
                    return N2.b();
                }
            }
            return a11;
        } catch (RuntimeException e11) {
            RuntimeException runtimeException = e11;
            return (com.fasterxml.jackson.databind.o) b0Var2.f0(cVar2, "Failed to construct BeanSerializer for %s: (%s) %s", cVar.m(), runtimeException.getClass().getName(), runtimeException.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public e N(c cVar) {
        return new e(cVar);
    }

    /* access modifiers changed from: protected */
    public c O(c cVar, Class[] clsArr) {
        return t8.d.a(cVar, clsArr);
    }

    /* access modifiers changed from: protected */
    public t8.i P(b0 b0Var, c cVar, List list) {
        com.fasterxml.jackson.databind.introspect.b0 l10 = cVar.l();
        if (l10 == null) {
            return null;
        }
        Class<l0> c10 = l10.c();
        if (c10 == l0.class) {
            String c11 = l10.d().c();
            int size = list.size();
            for (int i10 = 0; i10 != size; i10++) {
                c cVar2 = (c) list.get(i10);
                if (c11.equals(cVar2.m())) {
                    if (i10 > 0) {
                        list.remove(i10);
                        list.add(0, cVar2);
                    }
                    return t8.i.a(cVar2.getType(), (w) null, new t8.j(l10, cVar2), l10.b());
                }
            }
            throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", new Object[]{com.fasterxml.jackson.databind.util.f.C(cVar.m()), com.fasterxml.jackson.databind.util.f.P(c11)}));
        }
        return t8.i.a(b0Var.h().G(b0Var.d(c10), i0.class)[0], l10.d(), b0Var.i(cVar.k(), l10), l10.b());
    }

    /* access modifiers changed from: protected */
    public l Q(z zVar, c cVar) {
        return new l(zVar, cVar);
    }

    /* access modifiers changed from: protected */
    public List R(z zVar, c cVar, List list) {
        Set set;
        n.a O = zVar.O(cVar.i(), cVar.k());
        Set set2 = null;
        if (O != null) {
            set = O.h();
        } else {
            set = null;
        }
        q.a Q = zVar.Q(cVar.i(), cVar.k());
        if (Q != null) {
            set2 = Q.e();
        }
        if (set2 != null || (set != null && !set.isEmpty())) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (com.fasterxml.jackson.databind.util.i.b(((c) it.next()).m(), set, set2)) {
                    it.remove();
                }
            }
        }
        return list;
    }

    /* access modifiers changed from: protected */
    public List S(z zVar, c cVar, List list) {
        j m10 = cVar.m();
        Class<CharSequence> cls = CharSequence.class;
        if (m10.L(cls) && list.size() == 1) {
            i b10 = ((c) list.get(0)).b();
            if ((b10 instanceof com.fasterxml.jackson.databind.introspect.j) && "isEmpty".equals(b10.c()) && b10.k() == cls) {
                list.remove(0);
            }
        }
        return list;
    }

    public com.fasterxml.jackson.databind.o T(b0 b0Var, j jVar, c cVar, boolean z10) {
        if (X(jVar.s()) || com.fasterxml.jackson.databind.util.f.G(jVar.s())) {
            return M(b0Var, jVar, cVar, z10);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public List U(b0 b0Var, c cVar, e eVar) {
        List<s> f10 = cVar.f();
        z N = b0Var.f();
        Z(N, cVar, f10);
        if (N.F(com.fasterxml.jackson.databind.q.REQUIRE_SETTERS_FOR_GETTERS)) {
            b0(N, cVar, f10);
        }
        if (f10.isEmpty()) {
            return null;
        }
        boolean H = H(N, cVar, (g) null);
        l Q = Q(N, cVar);
        ArrayList arrayList = new ArrayList(f10.size());
        for (s sVar : f10) {
            i e10 = sVar.e();
            if (!sVar.r()) {
                b.a c10 = sVar.c();
                if (c10 == null || !c10.b()) {
                    if (e10 instanceof com.fasterxml.jackson.databind.introspect.j) {
                        arrayList.add(I(b0Var, sVar, Q, H, (com.fasterxml.jackson.databind.introspect.j) e10));
                    } else {
                        arrayList.add(I(b0Var, sVar, Q, H, (com.fasterxml.jackson.databind.introspect.g) e10));
                    }
                }
            } else if (e10 != null) {
                eVar.o(e10);
            }
        }
        return arrayList;
    }

    public g V(j jVar, z zVar, i iVar) {
        j l10 = jVar.l();
        q8.f z10 = zVar.h().z(zVar, iVar, jVar);
        if (z10 == null) {
            return c(zVar, l10);
        }
        return z10.d(zVar, l10, zVar.T().b(zVar, iVar, l10));
    }

    public g W(j jVar, z zVar, i iVar) {
        q8.f H = zVar.h().H(zVar, iVar, jVar);
        if (H == null) {
            return c(zVar, jVar);
        }
        return H.d(zVar, jVar, zVar.T().b(zVar, iVar, jVar));
    }

    /* access modifiers changed from: protected */
    public boolean X(Class cls) {
        if (com.fasterxml.jackson.databind.util.f.f(cls) != null || com.fasterxml.jackson.databind.util.f.M(cls)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void Y(z zVar, e eVar) {
        List g10 = eVar.g();
        boolean F = zVar.F(com.fasterxml.jackson.databind.q.DEFAULT_VIEW_INCLUSION);
        int size = g10.size();
        c[] cVarArr = new c[size];
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            c cVar = (c) g10.get(i11);
            Class[] p10 = cVar.p();
            if (p10 != null && p10.length != 0) {
                i10++;
                cVarArr[i11] = O(cVar, p10);
            } else if (F) {
                cVarArr[i11] = cVar;
            }
        }
        if (!F || i10 != 0) {
            eVar.l(cVarArr);
        }
    }

    /* access modifiers changed from: protected */
    public void Z(z zVar, c cVar, List list) {
        b h10 = zVar.h();
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            if (sVar.e() == null) {
                it.remove();
            } else {
                Class n10 = sVar.n();
                Boolean bool = (Boolean) hashMap.get(n10);
                if (bool == null) {
                    bool = zVar.k(n10).f();
                    if (bool == null && (bool = h10.i0(zVar.D(n10).k())) == null) {
                        bool = Boolean.FALSE;
                    }
                    hashMap.put(n10, bool);
                }
                if (bool.booleanValue()) {
                    it.remove();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public List a0(b0 b0Var, c cVar, e eVar, List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            c cVar2 = (c) list.get(i10);
            g o10 = cVar2.o();
            if (o10 != null && o10.c() == c0.a.EXTERNAL_PROPERTY) {
                w a10 = w.a(o10.b());
                Iterator it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        c cVar3 = (c) it.next();
                        if (cVar3 != cVar2 && cVar3.B(a10)) {
                            cVar2.j((g) null);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return list;
    }

    public com.fasterxml.jackson.databind.o b(b0 b0Var, j jVar) {
        j jVar2;
        z N = b0Var.f();
        c a02 = N.a0(jVar);
        com.fasterxml.jackson.databind.o F = F(b0Var, a02.k());
        if (F != null) {
            return F;
        }
        b h10 = N.h();
        boolean z10 = false;
        if (h10 == null) {
            jVar2 = jVar;
        } else {
            try {
                jVar2 = h10.l0(N, a02.k(), jVar);
            } catch (l e10) {
                return (com.fasterxml.jackson.databind.o) b0Var.f0(a02, e10.getMessage(), new Object[0]);
            }
        }
        if (jVar2 != jVar) {
            z10 = true;
            if (!jVar2.z(jVar.s())) {
                a02 = N.a0(jVar2);
            }
        }
        a02.h();
        return J(b0Var, jVar2, a02, z10);
    }

    /* access modifiers changed from: protected */
    public void b0(z zVar, c cVar, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            if (!sVar.a() && !sVar.q()) {
                it.remove();
            }
        }
    }

    /* access modifiers changed from: protected */
    public Iterable v() {
        return this.f5485a.e();
    }
}
