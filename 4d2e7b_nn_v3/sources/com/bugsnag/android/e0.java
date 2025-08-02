package com.bugsnag.android;

import c1.j;
import d1.d;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class e0 {
    e0() {
    }

    private Collection b(j jVar) {
        Set<BreadcrumbType> k10 = jVar.k();
        if (k10 == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (BreadcrumbType breadcrumbType : k10) {
            hashSet.add(breadcrumbType.toString());
        }
        return hashSet;
    }

    private Map c(j jVar) {
        HashMap hashMap = new HashMap();
        j1 n10 = jVar.n();
        hashMap.put("notify", n10.a());
        hashMap.put("sessions", n10.b());
        return hashMap;
    }

    private Map d(j jVar) {
        HashMap hashMap = new HashMap();
        n1 l10 = jVar.l();
        hashMap.put("anrs", Boolean.valueOf(l10.b()));
        hashMap.put("ndkCrashes", Boolean.valueOf(l10.c()));
        hashMap.put("unhandledExceptions", Boolean.valueOf(l10.d()));
        hashMap.put("unhandledRejections", Boolean.valueOf(l10.e()));
        return hashMap;
    }

    public void a(Map map, j jVar) {
        map.put("apiKey", jVar.a());
        map.put("autoDetectErrors", Boolean.valueOf(jVar.f()));
        map.put("autoTrackSessions", Boolean.valueOf(jVar.g()));
        map.put("sendThreads", jVar.E().toString());
        map.put("projectPackages", jVar.A());
        map.put("enabledReleaseStages", jVar.m());
        map.put("releaseStage", jVar.C());
        d h10 = jVar.h();
        if (h10 != null) {
            map.put("buildUuid", h10.a());
        }
        if (jVar.d() != null) {
            map.put("appVersion", jVar.d());
        }
        map.put("versionCode", jVar.I());
        map.put("type", jVar.c());
        map.put("persistUser", Boolean.valueOf(jVar.y()));
        map.put("generateAnonymousId", Boolean.valueOf(jVar.p()));
        map.put("launchCrashThresholdMs", Integer.valueOf((int) jVar.q()));
        map.put("maxBreadcrumbs", Integer.valueOf(jVar.s()));
        map.put("enabledBreadcrumbTypes", b(jVar));
        map.put("enabledErrorTypes", d(jVar));
        map.put("endpoints", c(jVar));
    }
}
