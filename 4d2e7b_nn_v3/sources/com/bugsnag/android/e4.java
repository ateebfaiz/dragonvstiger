package com.bugsnag.android;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.r;
import kotlin.jvm.internal.m;

public final class e4 {
    public void a(Map map, a4 a4Var) {
        map.put("id", a4Var.b());
        map.put("name", a4Var.c());
        String lowerCase = a4Var.f().toString().toLowerCase(Locale.ROOT);
        m.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        map.put("type", lowerCase);
        map.put("errorReportingThread", Boolean.valueOf(a4Var.a()));
        map.put("state", a4Var.e().c());
        Iterable<s3> d10 = a4Var.d();
        ArrayList arrayList = new ArrayList(r.v(d10, 10));
        for (s3 s3Var : d10) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(FirebaseAnalytics.Param.METHOD, s3Var.f());
            linkedHashMap.put("lineNumber", s3Var.d());
            linkedHashMap.put("file", s3Var.a());
            linkedHashMap.put("inProject", s3Var.c());
            arrayList.add(linkedHashMap);
        }
        map.put("stacktrace", arrayList);
    }
}
