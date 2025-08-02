package com.bugsnag.android;

import c1.r;
import c1.u;
import com.bugsnag.android.k2;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public final class p implements k2.a {

    /* renamed from: a  reason: collision with root package name */
    public String f18905a;

    /* renamed from: b  reason: collision with root package name */
    public BreadcrumbType f18906b;

    /* renamed from: c  reason: collision with root package name */
    public Map f18907c;

    /* renamed from: d  reason: collision with root package name */
    public final Date f18908d;

    public p(String str, BreadcrumbType breadcrumbType, Map map, Date date) {
        this.f18905a = str;
        this.f18906b = breadcrumbType;
        this.f18907c = map;
        this.f18908d = date;
    }

    public final u a(int i10) {
        Map map = this.f18907c;
        if (map == null) {
            return new u(0, 0);
        }
        return r.f17269a.e(i10, map);
    }

    public void toStream(k2 k2Var) {
        k2Var.j();
        k2Var.v("timestamp").P(this.f18908d);
        k2Var.v("name").K(this.f18905a);
        k2Var.v("type").K(this.f18906b.toString());
        k2Var.v("metaData");
        k2Var.Q(this.f18907c, true);
        k2Var.n();
    }

    public p(String str) {
        this(str, BreadcrumbType.MANUAL, new LinkedHashMap(), new Date());
    }
}
