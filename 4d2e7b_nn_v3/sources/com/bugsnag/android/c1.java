package com.bugsnag.android;

import c1.f;
import java.util.Date;
import java.util.Map;

class c1 {
    c1() {
    }

    public i1 a(Map map) {
        Date date;
        x0 x0Var = new x0((String) u2.c(map, "manufacturer"), (String) u2.c(map, "model"), (String) u2.c(map, "osVersion"), u2.a(map, "apiLevel"), (String) u2.c(map, "osBuild"), (String) u2.c(map, "fingerprint"), (String) u2.c(map, "tags"), (String) u2.c(map, "brand"), (String[]) u2.c(map, "cpuAbis"));
        String str = (String) u2.c(map, "time");
        if (str != null) {
            date = f.a(str);
        } else {
            date = null;
        }
        return new i1(x0Var, (Boolean) u2.c(map, "jailbroken"), (String) u2.c(map, "id"), (String) u2.c(map, "locale"), u2.b(map, "totalMemory"), (Map) u2.c(map, "runtimeVersions"), u2.b(map, "freeDisk"), u2.b(map, "freeMemory"), (String) u2.c(map, "orientation"), date);
    }
}
