package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.annotation.p;
import java.io.Serializable;
import l8.l;

public interface d {

    /* renamed from: n  reason: collision with root package name */
    public static final i.d f5218n = new i.d();

    /* renamed from: o  reason: collision with root package name */
    public static final p.b f5219o = p.b.c();

    public static class a implements d, Serializable {

        /* renamed from: a  reason: collision with root package name */
        protected final w f5220a;

        /* renamed from: b  reason: collision with root package name */
        protected final j f5221b;

        /* renamed from: c  reason: collision with root package name */
        protected final w f5222c;

        /* renamed from: d  reason: collision with root package name */
        protected final v f5223d;

        /* renamed from: e  reason: collision with root package name */
        protected final com.fasterxml.jackson.databind.introspect.i f5224e;

        public a(w wVar, j jVar, w wVar2, com.fasterxml.jackson.databind.introspect.i iVar, v vVar) {
            this.f5220a = wVar;
            this.f5221b = jVar;
            this.f5222c = wVar2;
            this.f5223d = vVar;
            this.f5224e = iVar;
        }

        public i.d a(l lVar, Class cls) {
            com.fasterxml.jackson.databind.introspect.i iVar;
            i.d l10;
            i.d p10 = lVar.p(cls);
            b h10 = lVar.h();
            if (h10 == null || (iVar = this.f5224e) == null || (l10 = h10.l(iVar)) == null) {
                return p10;
            }
            return p10.s(l10);
        }

        public com.fasterxml.jackson.databind.introspect.i b() {
            return this.f5224e;
        }

        public p.b c(l lVar, Class cls) {
            com.fasterxml.jackson.databind.introspect.i iVar;
            p.b E;
            p.b m10 = lVar.m(cls, this.f5221b.s());
            b h10 = lVar.h();
            if (h10 == null || (iVar = this.f5224e) == null || (E = h10.E(iVar)) == null) {
                return m10;
            }
            return m10.n(E);
        }

        public j getType() {
            return this.f5221b;
        }
    }

    i.d a(l lVar, Class cls);

    com.fasterxml.jackson.databind.introspect.i b();

    p.b c(l lVar, Class cls);

    j getType();
}
