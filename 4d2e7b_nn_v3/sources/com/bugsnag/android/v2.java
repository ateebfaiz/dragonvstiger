package com.bugsnag.android;

import c1.p;
import java.io.File;
import kotlin.jvm.functions.Function0;

public final class v2 implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    private final File f19036a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19037b;

    /* renamed from: c  reason: collision with root package name */
    private final s2 f19038c;

    /* renamed from: d  reason: collision with root package name */
    private o1 f19039d;

    public v2(File file, String str, s2 s2Var) {
        this.f19036a = file;
        this.f19037b = str;
        this.f19038c = s2Var;
    }

    private final o1 d() {
        return new o1(new s(this.f19038c).g(p.f17266a.c(this.f19036a), this.f19037b), this.f19038c);
    }

    public final void a() {
        this.f19039d = null;
    }

    public final o1 b() {
        return this.f19039d;
    }

    /* renamed from: c */
    public o1 invoke() {
        o1 o1Var = this.f19039d;
        if (o1Var != null) {
            return o1Var;
        }
        o1 d10 = d();
        this.f19039d = d10;
        return d10;
    }
}
