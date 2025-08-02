package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.introspect.g;
import com.fasterxml.jackson.databind.introspect.i;
import com.fasterxml.jackson.databind.introspect.j;
import com.fasterxml.jackson.databind.introspect.m;
import com.fasterxml.jackson.databind.introspect.s;
import com.fasterxml.jackson.databind.v;
import com.fasterxml.jackson.databind.w;
import l8.l;

public class n extends s {

    /* renamed from: b  reason: collision with root package name */
    protected final b f5700b;

    /* renamed from: c  reason: collision with root package name */
    protected final i f5701c;

    /* renamed from: d  reason: collision with root package name */
    protected final v f5702d;

    /* renamed from: e  reason: collision with root package name */
    protected final w f5703e;

    /* renamed from: f  reason: collision with root package name */
    protected final p.b f5704f;

    protected n(b bVar, i iVar, w wVar, v vVar, p.b bVar2) {
        this.f5700b = bVar;
        this.f5701c = iVar;
        this.f5703e = wVar;
        this.f5702d = vVar == null ? v.f5721i : vVar;
        this.f5704f = bVar2;
    }

    public static n s(l lVar, i iVar, w wVar, v vVar, p.a aVar) {
        p.b bVar;
        if (aVar == null || aVar == p.a.USE_DEFAULTS) {
            bVar = s.f5415a;
        } else {
            bVar = p.b.a(aVar, (p.a) null);
        }
        return new n(lVar.h(), iVar, wVar, vVar, bVar);
    }

    public p.b b() {
        return this.f5704f;
    }

    public m f() {
        i iVar = this.f5701c;
        if (iVar instanceof m) {
            return (m) iVar;
        }
        return null;
    }

    public g g() {
        i iVar = this.f5701c;
        if (iVar instanceof g) {
            return (g) iVar;
        }
        return null;
    }

    public w h() {
        return this.f5703e;
    }

    public j i() {
        i iVar = this.f5701c;
        if (!(iVar instanceof j) || ((j) iVar).w() != 0) {
            return null;
        }
        return (j) this.f5701c;
    }

    public v j() {
        return this.f5702d;
    }

    public String l() {
        return this.f5703e.c();
    }

    public i m() {
        return this.f5701c;
    }

    public Class n() {
        i iVar = this.f5701c;
        if (iVar == null) {
            return Object.class;
        }
        return iVar.d();
    }

    public j o() {
        i iVar = this.f5701c;
        if (!(iVar instanceof j) || ((j) iVar).w() != 1) {
            return null;
        }
        return (j) this.f5701c;
    }

    public w p() {
        i iVar;
        b bVar = this.f5700b;
        if (bVar == null || (iVar = this.f5701c) == null) {
            return null;
        }
        return bVar.X(iVar);
    }

    public boolean q() {
        return false;
    }
}
