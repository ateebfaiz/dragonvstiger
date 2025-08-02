package com.bugsnag.android;

import c1.f;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.collections.j;
import kotlin.jvm.internal.m;

public final class h1 {
    public void a(Map map, i1 i1Var) {
        List list;
        String[] a10 = i1Var.a();
        if (a10 == null) {
            list = null;
        } else {
            list = j.W(a10);
        }
        map.put("cpuAbi", list);
        map.put("jailbroken", i1Var.c());
        map.put("id", i1Var.b());
        map.put("locale", i1Var.d());
        map.put("manufacturer", i1Var.e());
        map.put("model", i1Var.f());
        map.put("osName", i1Var.g());
        map.put("osVersion", i1Var.h());
        map.put("totalMemory", i1Var.j());
        map.put("freeDisk", i1Var.m());
        map.put("freeMemory", i1Var.n());
        map.put("orientation", i1Var.o());
        if (i1Var.p() != null) {
            Date p10 = i1Var.p();
            m.c(p10);
            map.put("time", f.c(p10));
        }
        map.put("runtimeVersions", i1Var.i());
    }
}
