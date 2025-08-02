package com.bugsnag.android;

import com.bugsnag.android.k2;
import java.util.Collection;
import java.util.List;

public class k1 implements k2.a {

    /* renamed from: a  reason: collision with root package name */
    private final m1 f18813a;

    /* renamed from: b  reason: collision with root package name */
    private final s2 f18814b;

    k1(m1 m1Var, s2 s2Var) {
        this.f18813a = m1Var;
        this.f18814b = s2Var;
    }

    static List a(Throwable th, Collection collection, s2 s2Var) {
        return m1.f18848e.a(th, collection, s2Var);
    }

    private void f(String str) {
        s2 s2Var = this.f18814b;
        s2Var.a("Invalid null value supplied to error." + str + ", ignoring");
    }

    public String b() {
        return this.f18813a.a();
    }

    public String c() {
        return this.f18813a.b();
    }

    public List d() {
        return this.f18813a.c();
    }

    public ErrorType e() {
        return this.f18813a.d();
    }

    public void g(String str) {
        if (str != null) {
            this.f18813a.e(str);
        } else {
            f("errorClass");
        }
    }

    public void h(String str) {
        this.f18813a.f(str);
    }

    public void i(ErrorType errorType) {
        if (errorType != null) {
            this.f18813a.g(errorType);
        } else {
            f("type");
        }
    }

    public void toStream(k2 k2Var) {
        this.f18813a.toStream(k2Var);
    }
}
