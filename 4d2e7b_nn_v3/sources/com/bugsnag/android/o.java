package com.bugsnag.android;

import c1.f;
import java.util.Locale;
import java.util.Map;

class o {

    /* renamed from: a  reason: collision with root package name */
    private final s2 f18888a;

    o(s2 s2Var) {
        this.f18888a = s2Var;
    }

    public Breadcrumb a(Map map) {
        return new Breadcrumb((String) u2.d(map, "message"), BreadcrumbType.valueOf(((String) u2.d(map, "type")).toUpperCase(Locale.US)), (Map) u2.c(map, "metadata"), f.a((String) u2.d(map, "timestamp")), this.f18888a);
    }
}
