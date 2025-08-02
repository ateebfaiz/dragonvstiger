package com.bugsnag.android;

import c1.j;
import com.bugsnag.android.k2;
import d1.d;

public class f implements k2.a {

    /* renamed from: a  reason: collision with root package name */
    private String f18721a;

    /* renamed from: b  reason: collision with root package name */
    private String f18722b;

    /* renamed from: c  reason: collision with root package name */
    private String f18723c;

    /* renamed from: d  reason: collision with root package name */
    private String f18724d;

    /* renamed from: e  reason: collision with root package name */
    private String f18725e;

    /* renamed from: f  reason: collision with root package name */
    private String f18726f;

    /* renamed from: g  reason: collision with root package name */
    private Number f18727g;

    /* renamed from: h  reason: collision with root package name */
    private d f18728h;

    /* renamed from: i  reason: collision with root package name */
    private String f18729i;

    public f(String str, String str2, String str3, String str4, String str5, d dVar, String str6, Number number) {
        this.f18721a = str;
        this.f18722b = str2;
        this.f18723c = str3;
        this.f18724d = str4;
        this.f18725e = str5;
        this.f18726f = str6;
        this.f18727g = number;
        this.f18728h = dVar;
    }

    public final String a() {
        return this.f18721a;
    }

    public final String b() {
        String str = this.f18729i;
        if (str != null) {
            return str;
        }
        d dVar = this.f18728h;
        if (dVar == null) {
            return null;
        }
        return (String) dVar.a();
    }

    public final String c() {
        return this.f18725e;
    }

    public final String d() {
        return this.f18722b;
    }

    public final String e() {
        return this.f18723c;
    }

    public final String f() {
        return this.f18726f;
    }

    public final String g() {
        return this.f18724d;
    }

    public final Number h() {
        return this.f18727g;
    }

    public void i(k2 k2Var) {
        k2Var.v("binaryArch").K(this.f18721a);
        k2Var.v("buildUUID").K(b());
        k2Var.v("codeBundleId").K(this.f18725e);
        k2Var.v("id").K(this.f18722b);
        k2Var.v("releaseStage").K(this.f18723c);
        k2Var.v("type").K(this.f18726f);
        k2Var.v("version").K(this.f18724d);
        k2Var.v("versionCode").J(this.f18727g);
    }

    public void toStream(k2 k2Var) {
        k2Var.j();
        i(k2Var);
        k2Var.n();
    }

    public f(j jVar, String str, String str2, String str3, String str4, String str5) {
        this(str, str2, str3, str4, str5, jVar.h(), jVar.c(), jVar.I());
    }
}
