package com.bugsnag.android;

import c1.f;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.m;

public final class q {
    public void a(Map map, Breadcrumb breadcrumb) {
        map.put("timestamp", f.c(breadcrumb.getTimestamp()));
        map.put("message", breadcrumb.getMessage());
        String lowerCase = breadcrumb.getType().toString().toLowerCase(Locale.ROOT);
        m.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        map.put("type", lowerCase);
        map.put("metadata", breadcrumb.getMetadata());
    }
}
