package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.d;
import java.io.Serializable;
import l8.l;

public abstract class v implements d, Serializable {

    /* renamed from: a  reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.v f5419a;

    protected v(com.fasterxml.jackson.databind.v vVar) {
        this.f5419a = vVar == null ? com.fasterxml.jackson.databind.v.f5722j : vVar;
    }

    public i.d a(l lVar, Class cls) {
        i.d dVar;
        i b10;
        i.d p10 = lVar.p(cls);
        b h10 = lVar.h();
        if (h10 == null || (b10 = b()) == null) {
            dVar = null;
        } else {
            dVar = h10.l(b10);
        }
        if (p10 == null) {
            if (dVar == null) {
                return d.f5218n;
            }
            return dVar;
        } else if (dVar == null) {
            return p10;
        } else {
            return p10.s(dVar);
        }
    }

    public p.b c(l lVar, Class cls) {
        b h10 = lVar.h();
        i b10 = b();
        if (b10 == null) {
            return lVar.q(cls);
        }
        p.b m10 = lVar.m(cls, b10.d());
        if (h10 == null) {
            return m10;
        }
        p.b E = h10.E(b10);
        if (m10 == null) {
            return E;
        }
        return m10.n(E);
    }

    protected v(v vVar) {
        this.f5419a = vVar.f5419a;
    }
}
