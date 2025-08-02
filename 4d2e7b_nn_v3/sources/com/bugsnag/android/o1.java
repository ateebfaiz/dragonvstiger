package com.bugsnag.android;

import c1.j;
import c1.l;
import com.bugsnag.android.k2;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class o1 implements k2.a {

    /* renamed from: a  reason: collision with root package name */
    private final r1 f18890a;

    /* renamed from: b  reason: collision with root package name */
    private final s2 f18891b;

    o1(Throwable th, j jVar, q3 q3Var, s2 s2Var) {
        this(th, jVar, q3Var, new y2(), new c2(), s2Var);
    }

    private void n(String str) {
        s2 s2Var = this.f18891b;
        s2Var.a("Invalid null value supplied to config." + str + ", ignoring");
    }

    public void a(String str, String str2) {
        if (str != null) {
            this.f18890a.a(str, str2);
        } else {
            n("addFeatureFlag");
        }
    }

    public void b(String str, String str2, Object obj) {
        if (str == null || str2 == null) {
            n("addMetadata");
        } else {
            this.f18890a.b(str, str2, obj);
        }
    }

    public void c(String str, Map map) {
        if (str == null || map == null) {
            n("addMetadata");
        } else {
            this.f18890a.c(str, map);
        }
    }

    public void d() {
        this.f18890a.d();
    }

    public String e() {
        return this.f18890a.e();
    }

    public m f() {
        return this.f18890a.f();
    }

    public List g() {
        return this.f18890a.g();
    }

    public List h() {
        return this.f18890a.j();
    }

    /* access modifiers changed from: package-private */
    public r1 i() {
        return this.f18890a;
    }

    /* access modifiers changed from: package-private */
    public l3 j() {
        return this.f18890a.f18961i;
    }

    public Severity k() {
        return this.f18890a.m();
    }

    public List l() {
        return this.f18890a.o();
    }

    public boolean m() {
        return this.f18890a.p();
    }

    public void o(String str) {
        if (str != null) {
            this.f18890a.s(str);
        } else {
            n("apiKey");
        }
    }

    /* access modifiers changed from: package-private */
    public void p(m mVar) {
        this.f18890a.t(mVar);
    }

    /* access modifiers changed from: package-private */
    public void q(List list) {
        this.f18890a.u(list);
    }

    public void r(String str) {
        this.f18890a.v(str);
    }

    /* access modifiers changed from: package-private */
    public void s(i1 i1Var) {
        this.f18890a.w(i1Var);
    }

    public void t(String str) {
        this.f18890a.x(str);
    }

    public void toStream(k2 k2Var) {
        this.f18890a.toStream(k2Var);
    }

    /* access modifiers changed from: package-private */
    public void u(l lVar) {
        this.f18890a.y(lVar);
    }

    /* access modifiers changed from: package-private */
    public void v(Collection collection) {
        this.f18890a.A(collection);
    }

    /* access modifiers changed from: package-private */
    public void w(l3 l3Var) {
        this.f18890a.f18961i = l3Var;
    }

    public void x(UUID uuid, long j10) {
        if (uuid != null) {
            this.f18890a.B(new h4(uuid, j10));
        } else {
            n("traceId");
        }
    }

    public void y(String str, String str2, String str3) {
        this.f18890a.C(str, str2, str3);
    }

    /* access modifiers changed from: protected */
    public void z(Severity severity) {
        this.f18890a.G(severity);
    }

    o1(Throwable th, j jVar, q3 q3Var, y2 y2Var, c2 c2Var, s2 s2Var) {
        this(new r1(th, jVar, q3Var, y2Var, c2Var), s2Var);
    }

    o1(r1 r1Var, s2 s2Var) {
        this.f18890a = r1Var;
        this.f18891b = s2Var;
    }
}
