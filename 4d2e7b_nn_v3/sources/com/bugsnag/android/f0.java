package com.bugsnag.android;

import android.content.Context;
import java.io.File;
import java.util.Set;

public class f0 {

    /* renamed from: a  reason: collision with root package name */
    final d0 f18730a;

    public f0(String str) {
        this.f18730a = new d0(str);
    }

    public static f0 I(Context context) {
        return d0.J(context);
    }

    private void J(String str) {
        s2 o10 = o();
        o10.a("Invalid null value supplied to config." + str + ", ignoring");
    }

    public String A() {
        return this.f18730a.C();
    }

    public boolean B() {
        return this.f18730a.D();
    }

    public d4 C() {
        return this.f18730a.E();
    }

    public Set D() {
        return this.f18730a.F();
    }

    public long E() {
        return this.f18730a.G();
    }

    public k4 F() {
        return this.f18730a.H();
    }

    public Integer G() {
        return this.f18730a.I();
    }

    public boolean H() {
        return this.f18730a.d();
    }

    public void K(String str) {
        this.f18730a.L(str);
    }

    public void L(String str) {
        this.f18730a.M(str);
    }

    public void M(boolean z10) {
        this.f18730a.N(z10);
    }

    public void N(boolean z10) {
        this.f18730a.O(z10);
    }

    public void O(boolean z10) {
        this.f18730a.P(z10);
    }

    public void P(r0 r0Var) {
        if (r0Var != null) {
            this.f18730a.Q(r0Var);
        } else {
            J("delivery");
        }
    }

    public void Q(Set set) {
        if (c0.a(set)) {
            J("discardClasses");
        } else {
            this.f18730a.R(set);
        }
    }

    public void R(Set set) {
        this.f18730a.S(set);
    }

    public void S(j1 j1Var) {
        if (j1Var != null) {
            this.f18730a.T(j1Var);
        } else {
            J("endpoints");
        }
    }

    public void T(boolean z10) {
        this.f18730a.U(z10);
    }

    public void U(long j10) {
        if (j10 >= 0) {
            this.f18730a.V(j10);
            return;
        }
        s2 o10 = o();
        o10.a("Invalid configuration value detected. Option launchDurationMillis should be a positive long value.Supplied value is " + j10);
    }

    public void V(s2 s2Var) {
        this.f18730a.W(s2Var);
    }

    public void W(int i10) {
        if (i10 < 0 || i10 > 500) {
            s2 o10 = o();
            o10.a("Invalid configuration value detected. Option maxBreadcrumbs should be an integer between 0-500. Supplied value is " + i10);
            return;
        }
        this.f18730a.X(i10);
    }

    public void X(int i10) {
        if (i10 >= 0) {
            this.f18730a.Y(i10);
            return;
        }
        s2 o10 = o();
        o10.a("Invalid configuration value detected. Option maxPersistedEvents should be a positive integer.Supplied value is " + i10);
    }

    public void Y(int i10) {
        if (i10 >= 0) {
            this.f18730a.Z(i10);
            return;
        }
        s2 o10 = o();
        o10.a("Invalid configuration value detected. Option maxPersistedSessions should be a positive integer.Supplied value is " + i10);
    }

    public void Z(int i10) {
        if (i10 >= 0) {
            this.f18730a.a0(i10);
            return;
        }
        s2 o10 = o();
        o10.a("Invalid configuration value detected. Option maxReportedThreads should be a positive integer.Supplied value is " + i10);
    }

    public String a() {
        return this.f18730a.a();
    }

    public void a0(boolean z10) {
        this.f18730a.b0(z10);
    }

    public String b() {
        return this.f18730a.b();
    }

    public void b0(Set set) {
        if (c0.a(set)) {
            J("projectPackages");
        } else {
            this.f18730a.c0(set);
        }
    }

    public String c() {
        return this.f18730a.c();
    }

    public void c0(Set set) {
        if (c0.a(set)) {
            J("redactedKeys");
        } else {
            this.f18730a.d0(set);
        }
    }

    public boolean d() {
        return this.f18730a.e();
    }

    public void d0(String str) {
        this.f18730a.e0(str);
    }

    public boolean e() {
        return this.f18730a.f();
    }

    public void e0(boolean z10) {
        this.f18730a.f0(z10);
    }

    public String f() {
        return this.f18730a.h();
    }

    public void f0(d4 d4Var) {
        if (d4Var != null) {
            this.f18730a.g0(d4Var);
        } else {
            J("sendThreads");
        }
    }

    public r0 g() {
        return this.f18730a.i();
    }

    public void g0(long j10) {
        if (j10 >= 0) {
            this.f18730a.h0(j10);
            return;
        }
        s2 o10 = o();
        o10.a("Invalid configuration value detected. Option threadCollectionTimeLimitMillis should be a positive integer.Supplied value is " + j10);
    }

    public Set h() {
        return this.f18730a.j();
    }

    public void h0(Integer num) {
        this.f18730a.i0(num);
    }

    public Set i() {
        return this.f18730a.k();
    }

    public n1 j() {
        return this.f18730a.l();
    }

    public Set k() {
        return this.f18730a.m();
    }

    public j1 l() {
        return this.f18730a.n();
    }

    public boolean m() {
        return this.f18730a.o();
    }

    public long n() {
        return this.f18730a.p();
    }

    public s2 o() {
        return this.f18730a.q();
    }

    public int p() {
        return this.f18730a.r();
    }

    public int q() {
        return this.f18730a.s();
    }

    public int r() {
        return this.f18730a.t();
    }

    public int s() {
        return this.f18730a.u();
    }

    public int t() {
        return this.f18730a.v();
    }

    /* access modifiers changed from: package-private */
    public e3 u() {
        return this.f18730a.w();
    }

    public boolean v() {
        return this.f18730a.x();
    }

    public File w() {
        return this.f18730a.y();
    }

    /* access modifiers changed from: package-private */
    public Set x() {
        return this.f18730a.z();
    }

    public Set y() {
        return this.f18730a.A();
    }

    public Set z() {
        return this.f18730a.B();
    }
}
