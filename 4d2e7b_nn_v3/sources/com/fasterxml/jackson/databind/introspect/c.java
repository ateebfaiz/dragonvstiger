package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.introspect.t;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.type.n;
import com.fasterxml.jackson.databind.type.o;
import com.fasterxml.jackson.databind.util.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public final class c extends b implements h0 {
    private static final a Z = new a((e) null, Collections.emptyList(), Collections.emptyList());
    protected l C;
    protected List X;
    protected transient Boolean Y;

    /* renamed from: a  reason: collision with root package name */
    protected final j f5266a;

    /* renamed from: b  reason: collision with root package name */
    protected final Class f5267b;

    /* renamed from: c  reason: collision with root package name */
    protected final n f5268c;

    /* renamed from: d  reason: collision with root package name */
    protected final List f5269d;

    /* renamed from: e  reason: collision with root package name */
    protected final b f5270e;

    /* renamed from: f  reason: collision with root package name */
    protected final o f5271f;

    /* renamed from: g  reason: collision with root package name */
    protected final t.a f5272g;

    /* renamed from: h  reason: collision with root package name */
    protected final Class f5273h;

    /* renamed from: i  reason: collision with root package name */
    protected final boolean f5274i;

    /* renamed from: j  reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.util.a f5275j;

    /* renamed from: w  reason: collision with root package name */
    protected a f5276w;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final e f5277a;

        /* renamed from: b  reason: collision with root package name */
        public final List f5278b;

        /* renamed from: c  reason: collision with root package name */
        public final List f5279c;

        public a(e eVar, List list, List list2) {
            this.f5277a = eVar;
            this.f5278b = list;
            this.f5279c = list2;
        }
    }

    c(j jVar, Class cls, List list, Class cls2, com.fasterxml.jackson.databind.util.a aVar, n nVar, b bVar, t.a aVar2, o oVar, boolean z10) {
        this.f5266a = jVar;
        this.f5267b = cls;
        this.f5269d = list;
        this.f5273h = cls2;
        this.f5275j = aVar;
        this.f5268c = nVar;
        this.f5270e = bVar;
        this.f5272g = aVar2;
        this.f5271f = oVar;
        this.f5274i = z10;
    }

    private final a i() {
        a aVar = this.f5276w;
        if (aVar == null) {
            j jVar = this.f5266a;
            if (jVar == null) {
                aVar = Z;
            } else {
                aVar = f.p(this.f5270e, this.f5271f, this, jVar, this.f5273h, this.f5274i);
            }
            this.f5276w = aVar;
        }
        return aVar;
    }

    private final List j() {
        List list = this.X;
        if (list == null) {
            j jVar = this.f5266a;
            if (jVar == null) {
                list = Collections.emptyList();
            } else {
                list = h.m(this.f5270e, this, this.f5272g, this.f5271f, jVar, this.f5274i);
            }
            this.X = list;
        }
        return list;
    }

    private final l k() {
        l lVar = this.C;
        if (lVar == null) {
            j jVar = this.f5266a;
            if (jVar == null) {
                lVar = new l();
            } else {
                lVar = k.m(this.f5270e, this, this.f5272g, this.f5271f, jVar, this.f5269d, this.f5273h, this.f5274i);
            }
            this.C = lVar;
        }
        return lVar;
    }

    public j a(Type type) {
        return this.f5271f.H(type, this.f5268c);
    }

    public Annotation b(Class cls) {
        return this.f5275j.get(cls);
    }

    public String c() {
        return this.f5267b.getName();
    }

    public Class d() {
        return this.f5267b;
    }

    public j e() {
        return this.f5266a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!f.D(obj, c.class)) {
            return false;
        }
        if (((c) obj).f5267b == this.f5267b) {
            return true;
        }
        return false;
    }

    public boolean f(Class cls) {
        return this.f5275j.a(cls);
    }

    public boolean h(Class[] clsArr) {
        return this.f5275j.b(clsArr);
    }

    public int hashCode() {
        return this.f5267b.getName().hashCode();
    }

    public Iterable l() {
        return j();
    }

    public Class m() {
        return this.f5267b;
    }

    public com.fasterxml.jackson.databind.util.a n() {
        return this.f5275j;
    }

    public List o() {
        return i().f5278b;
    }

    public e p() {
        return i().f5277a;
    }

    public List q() {
        return i().f5279c;
    }

    public boolean s() {
        if (this.f5275j.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean t() {
        Boolean bool = this.Y;
        if (bool == null) {
            bool = Boolean.valueOf(f.K(this.f5267b));
            this.Y = bool;
        }
        return bool.booleanValue();
    }

    public String toString() {
        return "[AnnotedClass " + this.f5267b.getName() + "]";
    }

    public Iterable u() {
        return k();
    }

    c(Class cls) {
        this.f5266a = null;
        this.f5267b = cls;
        this.f5269d = Collections.emptyList();
        this.f5273h = null;
        this.f5275j = o.d();
        this.f5268c = n.i();
        this.f5270e = null;
        this.f5272g = null;
        this.f5271f = null;
        this.f5274i = false;
    }
}
