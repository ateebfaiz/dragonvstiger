package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.g0;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.m;
import kotlin.t;

public abstract class o {
    public static final Map a(a aVar) {
        m.f(aVar, "insets");
        return i0.i(t.a("top", Float.valueOf(g0.b(aVar.d()))), t.a("right", Float.valueOf(g0.b(aVar.c()))), t.a("bottom", Float.valueOf(g0.b(aVar.a()))), t.a("left", Float.valueOf(g0.b(aVar.b()))));
    }

    public static final WritableMap b(a aVar) {
        m.f(aVar, "insets");
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("top", (double) g0.b(aVar.d()));
        createMap.putDouble("right", (double) g0.b(aVar.c()));
        createMap.putDouble("bottom", (double) g0.b(aVar.a()));
        createMap.putDouble("left", (double) g0.b(aVar.b()));
        m.c(createMap);
        return createMap;
    }

    public static final Map c(c cVar) {
        m.f(cVar, "rect");
        return i0.i(t.a("x", Float.valueOf(g0.b(cVar.c()))), t.a("y", Float.valueOf(g0.b(cVar.d()))), t.a(Snapshot.WIDTH, Float.valueOf(g0.b(cVar.b()))), t.a(Snapshot.HEIGHT, Float.valueOf(g0.b(cVar.a()))));
    }

    public static final WritableMap d(c cVar) {
        m.f(cVar, "rect");
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("x", (double) g0.b(cVar.c()));
        createMap.putDouble("y", (double) g0.b(cVar.d()));
        createMap.putDouble(Snapshot.WIDTH, (double) g0.b(cVar.b()));
        createMap.putDouble(Snapshot.HEIGHT, (double) g0.b(cVar.a()));
        m.c(createMap);
        return createMap;
    }
}
