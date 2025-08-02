package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.introspect.t;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.type.n;
import com.fasterxml.jackson.databind.util.a;
import com.fasterxml.jackson.databind.util.f;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l8.l;

public class d {

    /* renamed from: i  reason: collision with root package name */
    private static final a f5302i = o.d();

    /* renamed from: j  reason: collision with root package name */
    private static final Class f5303j = Object.class;

    /* renamed from: k  reason: collision with root package name */
    private static final Class f5304k = Enum.class;

    /* renamed from: l  reason: collision with root package name */
    private static final Class f5305l = List.class;

    /* renamed from: m  reason: collision with root package name */
    private static final Class f5306m = Map.class;

    /* renamed from: a  reason: collision with root package name */
    private final l f5307a;

    /* renamed from: b  reason: collision with root package name */
    private final b f5308b;

    /* renamed from: c  reason: collision with root package name */
    private final t.a f5309c;

    /* renamed from: d  reason: collision with root package name */
    private final n f5310d;

    /* renamed from: e  reason: collision with root package name */
    private final j f5311e;

    /* renamed from: f  reason: collision with root package name */
    private final Class f5312f;

    /* renamed from: g  reason: collision with root package name */
    private final Class f5313g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f5314h;

    d(l lVar, j jVar, t.a aVar) {
        this.f5307a = lVar;
        this.f5311e = jVar;
        Class s10 = jVar.s();
        this.f5312f = s10;
        this.f5309c = aVar;
        this.f5310d = jVar.k();
        Class cls = null;
        b h10 = lVar.E() ? lVar.h() : null;
        this.f5308b = h10;
        this.f5313g = aVar != null ? aVar.a(s10) : cls;
        this.f5314h = h10 != null && (!f.H(s10) || !jVar.C());
    }

    private o a(o oVar, Annotation[] annotationArr) {
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                if (!oVar.f(annotation)) {
                    oVar = oVar.a(annotation);
                    if (this.f5308b.h0(annotation)) {
                        oVar = c(oVar, annotation);
                    }
                }
            }
        }
        return oVar;
    }

    private o b(o oVar, Class cls, Class cls2) {
        if (cls2 != null) {
            oVar = a(oVar, f.n(cls2));
            for (Class n10 : f.u(cls2, cls, false)) {
                oVar = a(oVar, f.n(n10));
            }
        }
        return oVar;
    }

    private o c(o oVar, Annotation annotation) {
        for (Annotation annotation2 : f.n(annotation.annotationType())) {
            if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention) && !oVar.f(annotation2)) {
                oVar = oVar.a(annotation2);
                if (this.f5308b.h0(annotation2)) {
                    oVar = c(oVar, annotation2);
                }
            }
        }
        return oVar;
    }

    private static void d(j jVar, List list, boolean z10) {
        Class s10 = jVar.s();
        if (z10) {
            if (!f(list, s10)) {
                list.add(jVar);
                if (s10 == f5305l || s10 == f5306m) {
                    return;
                }
            } else {
                return;
            }
        }
        for (j d10 : jVar.p()) {
            d(d10, list, true);
        }
    }

    private static void e(j jVar, List list, boolean z10) {
        Class s10 = jVar.s();
        if (s10 != f5303j && s10 != f5304k) {
            if (z10) {
                if (!f(list, s10)) {
                    list.add(jVar);
                } else {
                    return;
                }
            }
            for (j d10 : jVar.p()) {
                d(d10, list, true);
            }
            j u10 = jVar.u();
            if (u10 != null) {
                e(u10, list, true);
            }
        }
    }

    private static boolean f(List list, Class cls) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((j) list.get(i10)).s() == cls) {
                return true;
            }
        }
        return false;
    }

    static c g(l lVar, Class cls) {
        return new c(cls);
    }

    static c h(Class cls) {
        return new c(cls);
    }

    public static c i(l lVar, j jVar, t.a aVar) {
        if (!jVar.A() || !o(lVar, jVar.s())) {
            return new d(lVar, jVar, aVar).k();
        }
        return g(lVar, jVar.s());
    }

    private a j(List list) {
        boolean z10;
        if (this.f5308b == null) {
            return f5302i;
        }
        t.a aVar = this.f5309c;
        if (aVar == null || ((aVar instanceof g0) && !((g0) aVar).b())) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10 && !this.f5314h) {
            return f5302i;
        }
        o e10 = o.e();
        Class cls = this.f5313g;
        if (cls != null) {
            e10 = b(e10, this.f5312f, cls);
        }
        if (this.f5314h) {
            e10 = a(e10, f.n(this.f5312f));
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            if (z10) {
                Class s10 = jVar.s();
                e10 = b(e10, s10, this.f5309c.a(s10));
            }
            if (this.f5314h) {
                e10 = a(e10, f.n(jVar.s()));
            }
        }
        if (z10) {
            Class<Object> cls2 = Object.class;
            e10 = b(e10, cls2, this.f5309c.a(cls2));
        }
        return e10.c();
    }

    public static c m(l lVar, Class cls) {
        return n(lVar, cls, lVar);
    }

    public static c n(l lVar, Class cls, t.a aVar) {
        if (!cls.isArray() || !o(lVar, cls)) {
            return new d(lVar, cls, aVar).l();
        }
        return g(lVar, cls);
    }

    private static boolean o(l lVar, Class cls) {
        if (lVar == null || lVar.a(cls) == null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public c k() {
        ArrayList arrayList = new ArrayList(8);
        if (!this.f5311e.z(Object.class)) {
            if (this.f5311e.G()) {
                d(this.f5311e, arrayList, false);
            } else {
                e(this.f5311e, arrayList, false);
            }
        }
        return new c(this.f5311e, this.f5312f, arrayList, this.f5313g, j(arrayList), this.f5310d, this.f5308b, this.f5309c, this.f5307a.B(), this.f5314h);
    }

    /* access modifiers changed from: package-private */
    public c l() {
        List emptyList = Collections.emptyList();
        return new c((j) null, this.f5312f, emptyList, this.f5313g, j(emptyList), this.f5310d, this.f5308b, this.f5309c, this.f5307a.B(), this.f5314h);
    }

    d(l lVar, Class cls, t.a aVar) {
        this.f5307a = lVar;
        Class cls2 = null;
        this.f5311e = null;
        this.f5312f = cls;
        this.f5309c = aVar;
        this.f5310d = n.i();
        if (lVar == null) {
            this.f5308b = null;
            this.f5313g = null;
        } else {
            this.f5308b = lVar.E() ? lVar.h() : null;
            this.f5313g = aVar != null ? aVar.a(cls) : cls2;
        }
        this.f5314h = this.f5308b != null;
    }
}
