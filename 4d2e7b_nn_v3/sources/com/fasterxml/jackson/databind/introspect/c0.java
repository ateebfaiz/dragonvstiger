package com.fasterxml.jackson.databind.introspect;

import c.d;
import com.fasterxml.jackson.annotation.b;
import com.fasterxml.jackson.annotation.g;
import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.q;
import com.fasterxml.jackson.databind.util.f;
import com.fasterxml.jackson.databind.w;
import com.fasterxml.jackson.databind.x;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import l8.l;

public class c0 {

    /* renamed from: a  reason: collision with root package name */
    protected final l f5280a;

    /* renamed from: b  reason: collision with root package name */
    protected final a f5281b;

    /* renamed from: c  reason: collision with root package name */
    protected final boolean f5282c;

    /* renamed from: d  reason: collision with root package name */
    protected final j f5283d;

    /* renamed from: e  reason: collision with root package name */
    protected final c f5284e;

    /* renamed from: f  reason: collision with root package name */
    protected final j0 f5285f;

    /* renamed from: g  reason: collision with root package name */
    protected final b f5286g;

    /* renamed from: h  reason: collision with root package name */
    protected final boolean f5287h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f5288i;

    /* renamed from: j  reason: collision with root package name */
    protected LinkedHashMap f5289j;

    /* renamed from: k  reason: collision with root package name */
    protected LinkedList f5290k;

    /* renamed from: l  reason: collision with root package name */
    protected Map f5291l;

    /* renamed from: m  reason: collision with root package name */
    protected LinkedList f5292m;

    /* renamed from: n  reason: collision with root package name */
    protected LinkedList f5293n;

    /* renamed from: o  reason: collision with root package name */
    protected LinkedList f5294o;

    /* renamed from: p  reason: collision with root package name */
    protected LinkedList f5295p;

    /* renamed from: q  reason: collision with root package name */
    protected LinkedList f5296q;

    /* renamed from: r  reason: collision with root package name */
    protected LinkedList f5297r;

    /* renamed from: s  reason: collision with root package name */
    protected HashSet f5298s;

    /* renamed from: t  reason: collision with root package name */
    protected LinkedHashMap f5299t;

    /* renamed from: u  reason: collision with root package name */
    protected final boolean f5300u;

    /* renamed from: v  reason: collision with root package name */
    protected String f5301v = "set";

    protected c0(l lVar, boolean z10, j jVar, c cVar, a aVar) {
        this.f5280a = lVar;
        this.f5282c = z10;
        this.f5283d = jVar;
        this.f5284e = cVar;
        if (lVar.E()) {
            this.f5287h = true;
            this.f5286g = lVar.h();
        } else {
            this.f5287h = false;
            this.f5286g = b.k0();
        }
        this.f5285f = lVar.v(jVar.s(), cVar);
        this.f5281b = aVar;
        this.f5300u = lVar.F(q.USE_STD_BEAN_NAMING);
    }

    private boolean h(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((f0) it.next()).j().c()) {
                return true;
            }
        }
        return false;
    }

    private String i(String str) {
        w wVar;
        Map map = this.f5291l;
        if (map == null || (wVar = (w) map.get(m(str))) == null) {
            return str;
        }
        return wVar.c();
    }

    private x l() {
        Object u10 = this.f5286g.u(this.f5284e);
        if (u10 == null) {
            this.f5280a.z();
            return null;
        } else if (u10 instanceof Class) {
            Class<x> cls = (Class) u10;
            Class<x> cls2 = x.class;
            if (cls == cls2) {
                return null;
            }
            if (cls2.isAssignableFrom(cls)) {
                this.f5280a.w();
                d.a(f.k(cls, this.f5280a.b()));
                return null;
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<PropertyNamingStrategy>");
        } else {
            throw new IllegalStateException("AnnotationIntrospector returned PropertyNamingStrategy definition of type " + u10.getClass().getName() + "; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
        }
    }

    private w m(String str) {
        return w.b(str, (String) null);
    }

    public i A() {
        if (!this.f5288i) {
            v();
        }
        LinkedList linkedList = this.f5296q;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            G("Multiple 'as-key' properties defined (%s vs %s)", this.f5296q.get(0), this.f5296q.get(1));
        }
        return (i) this.f5296q.get(0);
    }

    public i B() {
        if (!this.f5288i) {
            v();
        }
        LinkedList linkedList = this.f5297r;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            G("Multiple 'as-value' properties defined (%s vs %s)", this.f5297r.get(0), this.f5297r.get(1));
        }
        return (i) this.f5297r.get(0);
    }

    public b0 C() {
        b0 w10 = this.f5286g.w(this.f5284e);
        if (w10 != null) {
            return this.f5286g.x(this.f5284e, w10);
        }
        return w10;
    }

    public List D() {
        return new ArrayList(E().values());
    }

    /* access modifiers changed from: protected */
    public Map E() {
        if (!this.f5288i) {
            v();
        }
        return this.f5289j;
    }

    public j F() {
        return this.f5283d;
    }

    /* access modifiers changed from: protected */
    public void G(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        throw new IllegalArgumentException("Problem with definition of " + this.f5284e + ": " + str);
    }

    /* access modifiers changed from: protected */
    public void a(Map map, m mVar) {
        boolean z10;
        f0 f0Var;
        g.a h10;
        String m10 = this.f5286g.m(mVar);
        if (m10 == null) {
            m10 = "";
        }
        w s10 = this.f5286g.s(mVar);
        if (s10 == null || s10.h()) {
            z10 = false;
        } else {
            z10 = true;
        }
        boolean z11 = z10;
        if (!z11) {
            if (!m10.isEmpty() && (h10 = this.f5286g.h(this.f5280a, mVar.q())) != null && h10 != g.a.DISABLED) {
                s10 = w.a(m10);
            } else {
                return;
            }
        }
        w wVar = s10;
        String i10 = i(m10);
        if (!z11 || !i10.isEmpty()) {
            f0Var = o(map, i10);
        } else {
            f0Var = n(map, wVar);
        }
        f0Var.L(mVar, wVar, z11, true, false);
        this.f5290k.add(f0Var);
    }

    /* access modifiers changed from: protected */
    public void b(Map map) {
        if (this.f5287h) {
            Iterator it = this.f5284e.o().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e eVar = (e) it.next();
                if (this.f5290k == null) {
                    this.f5290k = new LinkedList();
                }
                int v10 = eVar.v();
                for (int i10 = 0; i10 < v10; i10++) {
                    a(map, eVar.p(i10));
                }
            }
            for (j jVar : this.f5284e.q()) {
                if (this.f5290k == null) {
                    this.f5290k = new LinkedList();
                }
                int w10 = jVar.w();
                for (int i11 = 0; i11 < w10; i11++) {
                    a(map, jVar.p(i11));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c(Map map) {
        boolean z10;
        w wVar;
        boolean z11;
        boolean z12;
        w wVar2;
        boolean z13;
        boolean z14;
        boolean z15;
        b bVar = this.f5286g;
        if (this.f5282c || this.f5280a.F(q.ALLOW_FINAL_FIELDS_AS_MUTATORS)) {
            z10 = false;
        } else {
            z10 = true;
        }
        boolean F = this.f5280a.F(q.PROPAGATE_TRANSIENT_MARKER);
        for (g gVar : this.f5284e.l()) {
            Boolean bool = Boolean.TRUE;
            if (bool.equals(bVar.b0(this.f5280a, gVar))) {
                if (this.f5296q == null) {
                    this.f5296q = new LinkedList();
                }
                this.f5296q.add(gVar);
            }
            if (bool.equals(bVar.c0(gVar))) {
                if (this.f5297r == null) {
                    this.f5297r = new LinkedList();
                }
                this.f5297r.add(gVar);
            } else {
                boolean equals = bool.equals(bVar.Y(gVar));
                boolean equals2 = bool.equals(bVar.a0(gVar));
                if (equals || equals2) {
                    if (equals) {
                        if (this.f5293n == null) {
                            this.f5293n = new LinkedList();
                        }
                        this.f5293n.add(gVar);
                    }
                    if (equals2) {
                        if (this.f5295p == null) {
                            this.f5295p = new LinkedList();
                        }
                        this.f5295p.add(gVar);
                    }
                } else {
                    String m10 = bVar.m(gVar);
                    if (m10 == null) {
                        m10 = gVar.c();
                    }
                    String d10 = this.f5281b.d(gVar, m10);
                    if (d10 != null) {
                        w m11 = m(d10);
                        w J = bVar.J(this.f5280a, gVar, m11);
                        if (J != null && !J.equals(m11)) {
                            if (this.f5291l == null) {
                                this.f5291l = new HashMap();
                            }
                            this.f5291l.put(J, m11);
                        }
                        if (this.f5282c) {
                            wVar = bVar.t(gVar);
                        } else {
                            wVar = bVar.s(gVar);
                        }
                        if (wVar != null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (!z11 || !wVar.h()) {
                            wVar2 = wVar;
                            z12 = z11;
                        } else {
                            z12 = false;
                            wVar2 = m(d10);
                        }
                        if (wVar2 != null) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        if (!z13) {
                            z13 = this.f5285f.c(gVar);
                        }
                        boolean f02 = bVar.f0(gVar);
                        if (!gVar.s() || z11) {
                            z14 = f02;
                            z15 = z13;
                        } else {
                            if (F) {
                                z14 = true;
                            } else {
                                z14 = f02;
                            }
                            z15 = false;
                        }
                        if (!z10 || wVar2 != null || z14 || !Modifier.isFinal(gVar.q())) {
                            o(map, d10).M(gVar, wVar2, z12, z15, z14);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void d(Map map, j jVar, b bVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        w wVar;
        String str;
        boolean d10;
        Class<Void> z13 = jVar.z();
        if (z13 == Void.TYPE) {
            return;
        }
        if (z13 != Void.class || this.f5280a.F(q.ALLOW_VOID_VALUED_PROPERTIES)) {
            Boolean bool = Boolean.TRUE;
            if (bool.equals(bVar.Y(jVar))) {
                if (this.f5292m == null) {
                    this.f5292m = new LinkedList();
                }
                this.f5292m.add(jVar);
            } else if (bool.equals(bVar.b0(this.f5280a, jVar))) {
                if (this.f5296q == null) {
                    this.f5296q = new LinkedList();
                }
                this.f5296q.add(jVar);
            } else if (bool.equals(bVar.c0(jVar))) {
                if (this.f5297r == null) {
                    this.f5297r = new LinkedList();
                }
                this.f5297r.add(jVar);
            } else {
                w t10 = bVar.t(jVar);
                boolean z14 = false;
                if (t10 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    str = bVar.m(jVar);
                    if (str == null) {
                        str = this.f5281b.c(jVar, jVar.c());
                    }
                    if (str == null) {
                        str = this.f5281b.a(jVar, jVar.c());
                        if (str != null) {
                            d10 = this.f5285f.j(jVar);
                        } else {
                            return;
                        }
                    } else {
                        d10 = this.f5285f.d(jVar);
                    }
                    wVar = t10;
                    z11 = d10;
                    z12 = z10;
                } else {
                    String m10 = bVar.m(jVar);
                    if (m10 == null && (m10 = this.f5281b.c(jVar, jVar.c())) == null) {
                        m10 = this.f5281b.a(jVar, jVar.c());
                    }
                    if (m10 == null) {
                        m10 = jVar.c();
                    }
                    if (t10.h()) {
                        t10 = m(m10);
                    } else {
                        z14 = z10;
                    }
                    wVar = t10;
                    z12 = z14;
                    z11 = true;
                    str = m10;
                }
                o(map, i(str)).N(jVar, wVar, z12, z11, bVar.f0(jVar));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void e(Map map) {
        for (g gVar : this.f5284e.l()) {
            k(this.f5286g.n(gVar), gVar);
        }
        for (j jVar : this.f5284e.u()) {
            if (jVar.w() == 1) {
                k(this.f5286g.n(jVar), jVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void f(Map map) {
        for (j jVar : this.f5284e.u()) {
            int w10 = jVar.w();
            if (w10 == 0) {
                d(map, jVar, this.f5286g);
            } else if (w10 == 1) {
                g(map, jVar, this.f5286g);
            } else if (w10 == 2 && Boolean.TRUE.equals(this.f5286g.a0(jVar))) {
                if (this.f5294o == null) {
                    this.f5294o = new LinkedList();
                }
                this.f5294o.add(jVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void g(Map map, j jVar, b bVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        w wVar;
        String str;
        w s10 = bVar.s(jVar);
        boolean z13 = false;
        if (s10 != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            str = bVar.m(jVar);
            if (str == null) {
                str = this.f5281b.b(jVar, jVar.c());
            }
            if (str != null) {
                wVar = s10;
                z11 = this.f5285f.k(jVar);
                z12 = z10;
            } else {
                return;
            }
        } else {
            String m10 = bVar.m(jVar);
            if (m10 == null) {
                m10 = this.f5281b.b(jVar, jVar.c());
            }
            if (m10 == null) {
                m10 = jVar.c();
            }
            if (s10.h()) {
                s10 = m(m10);
            } else {
                z13 = z10;
            }
            wVar = s10;
            z12 = z13;
            z11 = true;
            str = m10;
        }
        o(map, i(str)).O(jVar, wVar, z12, z11, bVar.f0(jVar));
    }

    /* access modifiers changed from: protected */
    public void j(String str) {
        if (!this.f5282c && str != null) {
            if (this.f5298s == null) {
                this.f5298s = new HashSet();
            }
            this.f5298s.add(str);
        }
    }

    /* access modifiers changed from: protected */
    public void k(b.a aVar, i iVar) {
        if (aVar != null) {
            Object e10 = aVar.e();
            if (this.f5299t == null) {
                this.f5299t = new LinkedHashMap();
            }
            i iVar2 = (i) this.f5299t.put(e10, iVar);
            if (iVar2 != null && iVar2.getClass() == iVar.getClass()) {
                String name = e10.getClass().getName();
                throw new IllegalArgumentException("Duplicate injectable value with id '" + e10 + "' (of type " + name + ")");
            }
        }
    }

    /* access modifiers changed from: protected */
    public f0 n(Map map, w wVar) {
        String c10 = wVar.c();
        f0 f0Var = (f0) map.get(c10);
        if (f0Var != null) {
            return f0Var;
        }
        f0 f0Var2 = new f0(this.f5280a, this.f5286g, this.f5282c, wVar);
        map.put(c10, f0Var2);
        return f0Var2;
    }

    /* access modifiers changed from: protected */
    public f0 o(Map map, String str) {
        f0 f0Var = (f0) map.get(str);
        if (f0Var != null) {
            return f0Var;
        }
        f0 f0Var2 = new f0(this.f5280a, this.f5286g, this.f5282c, w.a(str));
        map.put(str, f0Var2);
        return f0Var2;
    }

    /* access modifiers changed from: protected */
    public void p(Map map) {
        c0 c0Var;
        boolean F = this.f5280a.F(q.INFER_PROPERTY_MUTATORS);
        for (f0 f0Var : map.values()) {
            if (this.f5282c) {
                c0Var = null;
            } else {
                c0Var = this;
            }
            f0Var.d0(F, c0Var);
        }
    }

    /* access modifiers changed from: protected */
    public void q(Map map) {
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            f0 f0Var = (f0) it.next();
            if (!f0Var.Q()) {
                it.remove();
            } else if (f0Var.P()) {
                if (!f0Var.q()) {
                    it.remove();
                    j(f0Var.l());
                } else {
                    f0Var.c0();
                    if (!f0Var.a()) {
                        j(f0Var.l());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void r(Map map) {
        HashSet hashSet;
        Iterator it = map.entrySet().iterator();
        LinkedList linkedList = null;
        while (it.hasNext()) {
            f0 f0Var = (f0) ((Map.Entry) it.next()).getValue();
            Set U = f0Var.U();
            if (!U.isEmpty()) {
                it.remove();
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                if (U.size() == 1) {
                    linkedList.add(f0Var.f0((w) U.iterator().next()));
                } else {
                    linkedList.addAll(f0Var.S(U));
                }
            }
        }
        if (linkedList != null) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                f0 f0Var2 = (f0) it2.next();
                String l10 = f0Var2.l();
                f0 f0Var3 = (f0) map.get(l10);
                if (f0Var3 == null) {
                    map.put(l10, f0Var2);
                } else {
                    f0Var3.K(f0Var2);
                }
                if (t(f0Var2, this.f5290k) && (hashSet = this.f5298s) != null) {
                    hashSet.remove(l10);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void s(Map map) {
        w X;
        Iterator it = map.entrySet().iterator();
        LinkedList linkedList = null;
        while (it.hasNext()) {
            f0 f0Var = (f0) ((Map.Entry) it.next()).getValue();
            i m10 = f0Var.m();
            if (m10 != null && (X = this.f5286g.X(m10)) != null && X.e() && !X.equals(f0Var.h())) {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(f0Var.f0(X));
                it.remove();
            }
        }
        if (linkedList != null) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                f0 f0Var2 = (f0) it2.next();
                String l10 = f0Var2.l();
                f0 f0Var3 = (f0) map.get(l10);
                if (f0Var3 == null) {
                    map.put(l10, f0Var2);
                } else {
                    f0Var3.K(f0Var2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean t(f0 f0Var, List list) {
        if (list != null) {
            String X = f0Var.X();
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((f0) list.get(i10)).X().equals(X)) {
                    list.set(i10, f0Var);
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void u(Map map) {
        boolean z10;
        Map map2;
        Collection<f0> collection;
        com.fasterxml.jackson.databind.b bVar = this.f5286g;
        Boolean O = bVar.O(this.f5284e);
        if (O == null) {
            z10 = this.f5280a.G();
        } else {
            z10 = O.booleanValue();
        }
        boolean h10 = h(map.values());
        String[] N = bVar.N(this.f5284e);
        if (z10 || h10 || this.f5290k != null || N != null) {
            int size = map.size();
            if (z10) {
                map2 = new TreeMap();
            } else {
                map2 = new LinkedHashMap(size + size);
            }
            for (f0 f0Var : map.values()) {
                map2.put(f0Var.l(), f0Var);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(size + size);
            if (N != null) {
                for (String str : N) {
                    f0 f0Var2 = (f0) map2.remove(str);
                    if (f0Var2 == null) {
                        Iterator it = map.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            f0 f0Var3 = (f0) it.next();
                            if (str.equals(f0Var3.X())) {
                                str = f0Var3.l();
                                f0Var2 = f0Var3;
                                break;
                            }
                        }
                    }
                    if (f0Var2 != null) {
                        linkedHashMap.put(str, f0Var2);
                    }
                }
            }
            if (h10) {
                TreeMap treeMap = new TreeMap();
                Iterator it2 = map2.entrySet().iterator();
                while (it2.hasNext()) {
                    f0 f0Var4 = (f0) ((Map.Entry) it2.next()).getValue();
                    Integer b10 = f0Var4.j().b();
                    if (b10 != null) {
                        treeMap.put(b10, f0Var4);
                        it2.remove();
                    }
                }
                for (f0 f0Var5 : treeMap.values()) {
                    linkedHashMap.put(f0Var5.l(), f0Var5);
                }
            }
            if (this.f5290k != null && (!z10 || this.f5280a.F(q.SORT_CREATOR_PROPERTIES_FIRST))) {
                if (z10) {
                    TreeMap treeMap2 = new TreeMap();
                    Iterator it3 = this.f5290k.iterator();
                    while (it3.hasNext()) {
                        f0 f0Var6 = (f0) it3.next();
                        treeMap2.put(f0Var6.l(), f0Var6);
                    }
                    collection = treeMap2.values();
                } else {
                    collection = this.f5290k;
                }
                for (f0 f0Var7 : collection) {
                    String l10 = f0Var7.l();
                    if (map2.containsKey(l10)) {
                        linkedHashMap.put(l10, f0Var7);
                    }
                }
            }
            linkedHashMap.putAll(map2);
            map.clear();
            map.putAll(linkedHashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void v() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c(linkedHashMap);
        f(linkedHashMap);
        if (!this.f5284e.t()) {
            b(linkedHashMap);
        }
        q(linkedHashMap);
        p(linkedHashMap);
        r(linkedHashMap);
        e(linkedHashMap);
        for (f0 b02 : linkedHashMap.values()) {
            b02.b0(this.f5282c);
        }
        l();
        for (f0 e02 : linkedHashMap.values()) {
            e02.e0();
        }
        if (this.f5280a.F(q.USE_WRAPPER_NAME_AS_PROPERTY_NAME)) {
            s(linkedHashMap);
        }
        u(linkedHashMap);
        this.f5289j = linkedHashMap;
        this.f5288i = true;
    }

    public i w() {
        if (!this.f5288i) {
            v();
        }
        LinkedList linkedList = this.f5293n;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            G("Multiple 'any-getter' fields defined (%s vs %s)", this.f5293n.get(0), this.f5293n.get(1));
        }
        return (i) this.f5293n.getFirst();
    }

    public i x() {
        if (!this.f5288i) {
            v();
        }
        LinkedList linkedList = this.f5292m;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            G("Multiple 'any-getter' methods defined (%s vs %s)", this.f5292m.get(0), this.f5292m.get(1));
        }
        return (i) this.f5292m.getFirst();
    }

    public c y() {
        return this.f5284e;
    }

    public l z() {
        return this.f5280a;
    }
}
