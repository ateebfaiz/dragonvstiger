package com.bugsnag.android;

import c1.j;
import d1.d;

public final class m extends f {
    private Boolean C;
    private Boolean X;

    /* renamed from: j  reason: collision with root package name */
    private Number f18843j;

    /* renamed from: w  reason: collision with root package name */
    private Number f18844w;

    public m(String str, String str2, String str3, String str4, String str5, d dVar, String str6, Number number, Number number2, Number number3, Boolean bool, Boolean bool2) {
        super(str, str2, str3, str4, str5, dVar, str6, number);
        this.f18843j = number2;
        this.f18844w = number3;
        this.C = bool;
        this.X = bool2;
    }

    public void i(k2 k2Var) {
        super.i(k2Var);
        k2Var.v("duration").J(this.f18843j);
        k2Var.v("durationInForeground").J(this.f18844w);
        k2Var.v("inForeground").I(this.C);
        k2Var.v("isLaunching").I(this.X);
    }

    public final Number j() {
        return this.f18843j;
    }

    public final Number k() {
        return this.f18844w;
    }

    public final Boolean l() {
        return this.C;
    }

    public final Boolean m() {
        return this.X;
    }

    public m(j jVar, String str, String str2, String str3, String str4, String str5, Number number, Number number2, Boolean bool, Boolean bool2) {
        this(str, str2, str3, str4, str5, jVar.h(), jVar.c(), jVar.I(), number, number2, bool, bool2);
    }
}
