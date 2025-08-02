package com.bugsnag.android;

import com.bugsnag.android.k2;
import java.util.List;
import kotlin.collections.r;

public final class c4 implements k2.a {

    /* renamed from: a  reason: collision with root package name */
    private String f18665a;

    /* renamed from: b  reason: collision with root package name */
    private String f18666b;

    /* renamed from: c  reason: collision with root package name */
    private ErrorType f18667c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f18668d;

    /* renamed from: e  reason: collision with root package name */
    private String f18669e;

    /* renamed from: f  reason: collision with root package name */
    private List f18670f;

    public c4(String str, String str2, ErrorType errorType, boolean z10, String str3, u3 u3Var) {
        this.f18665a = str;
        this.f18666b = str2;
        this.f18667c = errorType;
        this.f18668d = z10;
        this.f18669e = str3;
        this.f18670f = r.y0(u3Var.a());
    }

    public final String a() {
        return this.f18665a;
    }

    public final String b() {
        return this.f18666b;
    }

    public final List c() {
        return this.f18670f;
    }

    public final String d() {
        return this.f18669e;
    }

    public final ErrorType e() {
        return this.f18667c;
    }

    public final boolean f() {
        return this.f18668d;
    }

    public void toStream(k2 k2Var) {
        k2Var.j();
        k2Var.v("id").K(this.f18665a);
        k2Var.v("name").K(this.f18666b);
        k2Var.v("type").K(this.f18667c.getDesc$bugsnag_android_core_release());
        k2Var.v("state").K(this.f18669e);
        k2Var.v("stacktrace");
        k2Var.h();
        for (s3 P : this.f18670f) {
            k2Var.P(P);
        }
        k2Var.m();
        if (this.f18668d) {
            k2Var.v("errorReportingThread").L(true);
        }
        k2Var.n();
    }
}
