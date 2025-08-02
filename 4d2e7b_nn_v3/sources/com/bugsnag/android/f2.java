package com.bugsnag.android;

import c1.j;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

class f2 {

    /* renamed from: a  reason: collision with root package name */
    private final z f18731a;

    public f2(z zVar) {
        this.f18731a = zVar;
    }

    public Map a() {
        return this.f18731a.f19168k.f();
    }

    public m b() {
        return this.f18731a.f19168k.e();
    }

    public Map c() {
        return this.f18731a.f19167j.l();
    }

    public i1 d() {
        return this.f18731a.f19167j.j(new Date().getTime());
    }

    public Collection e(j jVar) {
        return jVar.A();
    }

    public List f(boolean z10) {
        return new f4((Throwable) null, z10, this.f18731a.m()).c();
    }
}
