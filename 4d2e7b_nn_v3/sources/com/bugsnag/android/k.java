package com.bugsnag.android;

import d1.g;
import java.util.Map;

class k {
    k() {
    }

    public m a(Map map) {
        return new m((String) u2.c(map, "binaryArch"), (String) u2.c(map, "id"), (String) u2.c(map, "releaseStage"), (String) u2.c(map, "version"), (String) u2.c(map, "codeBundleId"), new g((String) u2.c(map, "buildUuid")), (String) u2.c(map, "type"), (Number) u2.c(map, "versionCode"), (Number) u2.c(map, "duration"), (Number) u2.c(map, "durationInForeground"), (Boolean) u2.c(map, "inForeground"), (Boolean) u2.c(map, "isLaunching"));
    }
}
