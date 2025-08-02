package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.introspect.t;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.m;
import com.fasterxml.jackson.databind.util.f;
import com.fasterxml.jackson.databind.z;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import l8.l;

public class r extends t implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final Class f5407a;

    /* renamed from: b  reason: collision with root package name */
    private static final Class f5408b;

    /* renamed from: c  reason: collision with root package name */
    private static final Class f5409c = m.class;

    /* renamed from: d  reason: collision with root package name */
    protected static final q f5410d;

    /* renamed from: e  reason: collision with root package name */
    protected static final q f5411e;

    /* renamed from: f  reason: collision with root package name */
    protected static final q f5412f;

    /* renamed from: g  reason: collision with root package name */
    protected static final q f5413g;

    /* renamed from: h  reason: collision with root package name */
    protected static final q f5414h;

    static {
        Class<Object> cls = Object.class;
        f5407a = cls;
        Class<String> cls2 = String.class;
        f5408b = cls2;
        f5410d = q.r((l) null, com.fasterxml.jackson.databind.type.l.Y(cls2), d.h(cls2));
        Class cls3 = Boolean.TYPE;
        f5411e = q.r((l) null, com.fasterxml.jackson.databind.type.l.Y(cls3), d.h(cls3));
        Class cls4 = Integer.TYPE;
        f5412f = q.r((l) null, com.fasterxml.jackson.databind.type.l.Y(cls4), d.h(cls4));
        Class cls5 = Long.TYPE;
        f5413g = q.r((l) null, com.fasterxml.jackson.databind.type.l.Y(cls5), d.h(cls5));
        f5414h = q.r((l) null, com.fasterxml.jackson.databind.type.l.Y(cls), d.h(cls));
    }

    /* access modifiers changed from: protected */
    public q c(l lVar, j jVar) {
        if (e(jVar)) {
            return q.r(lVar, jVar, f(lVar, jVar, lVar));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public q d(l lVar, j jVar) {
        Class<Boolean> s10 = jVar.s();
        if (s10.isPrimitive()) {
            if (s10 == Integer.TYPE) {
                return f5412f;
            }
            if (s10 == Long.TYPE) {
                return f5413g;
            }
            if (s10 == Boolean.TYPE) {
                return f5411e;
            }
            return null;
        } else if (f.H(s10)) {
            if (s10 == f5407a) {
                return f5414h;
            }
            if (s10 == f5408b) {
                return f5410d;
            }
            if (s10 == Integer.class) {
                return f5412f;
            }
            if (s10 == Long.class) {
                return f5413g;
            }
            if (s10 == Boolean.class) {
                return f5411e;
            }
            return null;
        } else if (f5409c.isAssignableFrom(s10)) {
            return q.r(lVar, jVar, d.h(s10));
        } else {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean e(j jVar) {
        if (jVar.C() && !jVar.A()) {
            Class s10 = jVar.s();
            if (!f.H(s10) || (!Collection.class.isAssignableFrom(s10) && !Map.class.isAssignableFrom(s10))) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public c f(l lVar, j jVar, t.a aVar) {
        return d.i(lVar, jVar, aVar);
    }

    /* access modifiers changed from: protected */
    public c0 h(l lVar, j jVar, t.a aVar, boolean z10) {
        a a10;
        c f10 = f(lVar, jVar, aVar);
        if (jVar.K()) {
            a10 = lVar.f().b(lVar, f10);
        } else {
            a10 = lVar.f().a(lVar, f10);
        }
        return i(lVar, f10, jVar, z10, a10);
    }

    /* access modifiers changed from: protected */
    public c0 i(l lVar, c cVar, j jVar, boolean z10, a aVar) {
        return new c0(lVar, z10, jVar, cVar, aVar);
    }

    /* renamed from: j */
    public q a(l lVar, j jVar, t.a aVar) {
        q d10 = d(lVar, jVar);
        if (d10 == null) {
            return q.r(lVar, jVar, f(lVar, jVar, aVar));
        }
        return d10;
    }

    /* renamed from: k */
    public q b(z zVar, j jVar, t.a aVar) {
        q d10 = d(zVar, jVar);
        if (d10 != null) {
            return d10;
        }
        q c10 = c(zVar, jVar);
        if (c10 == null) {
            return q.s(h(zVar, jVar, aVar, true));
        }
        return c10;
    }
}
