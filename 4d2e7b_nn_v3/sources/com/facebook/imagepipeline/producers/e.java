package com.facebook.imagepipeline.producers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k5.b;
import y2.h;
import z4.m;

public class e implements e1 {
    public static final Set Y = h.a("id", "uri_source");
    private static final Object Z = new Object();
    private final List C;
    private final m X;

    /* renamed from: a  reason: collision with root package name */
    private final b f20070a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20071b;

    /* renamed from: c  reason: collision with root package name */
    private final String f20072c;

    /* renamed from: d  reason: collision with root package name */
    private final g1 f20073d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f20074e;

    /* renamed from: f  reason: collision with root package name */
    private final b.c f20075f;

    /* renamed from: g  reason: collision with root package name */
    private final Map f20076g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f20077h;

    /* renamed from: i  reason: collision with root package name */
    private y4.e f20078i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f20079j;

    /* renamed from: w  reason: collision with root package name */
    private boolean f20080w;

    public e(b bVar, String str, g1 g1Var, Object obj, b.c cVar, boolean z10, boolean z11, y4.e eVar, m mVar) {
        this(bVar, str, (String) null, (Map) null, g1Var, obj, cVar, z10, z11, eVar, mVar);
    }

    public static void c(List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((f1) it.next()).a();
            }
        }
    }

    public static void d(List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((f1) it.next()).b();
            }
        }
    }

    public static void e(List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((f1) it.next()).d();
            }
        }
    }

    public static void f(List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((f1) it.next()).c();
            }
        }
    }

    public synchronized boolean A() {
        return this.f20079j;
    }

    public b.c B() {
        return this.f20075f;
    }

    public synchronized List C(y4.e eVar) {
        if (eVar == this.f20078i) {
            return null;
        }
        this.f20078i = eVar;
        return new ArrayList(this.C);
    }

    public Object a() {
        return this.f20074e;
    }

    public b b() {
        return this.f20070a;
    }

    public Map getExtras() {
        return this.f20076g;
    }

    public String getId() {
        return this.f20071b;
    }

    public synchronized y4.e getPriority() {
        return this.f20078i;
    }

    public void h(f1 f1Var) {
        boolean z10;
        synchronized (this) {
            this.C.add(f1Var);
            z10 = this.f20080w;
        }
        if (z10) {
            f1Var.a();
        }
    }

    public m j() {
        return this.X;
    }

    public void k(String str, String str2) {
        this.f20076g.put("origin", str);
        this.f20076g.put("origin_sub", str2);
    }

    public void m(Map map) {
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                w((String) entry.getKey(), entry.getValue());
            }
        }
    }

    public synchronized boolean n() {
        return this.f20077h;
    }

    public void o() {
        c(q());
    }

    public Object p(String str) {
        return this.f20076g.get(str);
    }

    public synchronized List q() {
        if (this.f20080w) {
            return null;
        }
        this.f20080w = true;
        return new ArrayList(this.C);
    }

    public synchronized List r(boolean z10) {
        if (z10 == this.f20079j) {
            return null;
        }
        this.f20079j = z10;
        return new ArrayList(this.C);
    }

    public synchronized List t(boolean z10) {
        if (z10 == this.f20077h) {
            return null;
        }
        this.f20077h = z10;
        return new ArrayList(this.C);
    }

    public String v() {
        return this.f20072c;
    }

    public void w(String str, Object obj) {
        if (!Y.contains(str)) {
            this.f20076g.put(str, obj);
        }
    }

    public void y(String str) {
        k(str, "default");
    }

    public g1 z() {
        return this.f20073d;
    }

    public e(b bVar, String str, String str2, Map map, g1 g1Var, Object obj, b.c cVar, boolean z10, boolean z11, y4.e eVar, m mVar) {
        this.f20070a = bVar;
        this.f20071b = str;
        HashMap hashMap = new HashMap();
        this.f20076g = hashMap;
        hashMap.put("id", str);
        hashMap.put("uri_source", bVar == null ? "null-request" : bVar.u());
        m(map);
        this.f20072c = str2;
        this.f20073d = g1Var;
        this.f20074e = obj == null ? Z : obj;
        this.f20075f = cVar;
        this.f20077h = z10;
        this.f20078i = eVar;
        this.f20079j = z11;
        this.f20080w = false;
        this.C = new ArrayList();
        this.X = mVar;
    }
}
