package com.horcrux.svg;

import com.adjust.sdk.Constants;
import java.util.HashMap;
import java.util.Map;

enum f {
    UNKNOWN("unknown"),
    NORMAL(Constants.NORMAL),
    MULTIPLY("multiply"),
    SCREEN("screen"),
    DARKEN("darken"),
    LIGHTEN("lighten");
    

    /* renamed from: h  reason: collision with root package name */
    private static final Map f9810h = null;

    /* renamed from: a  reason: collision with root package name */
    private final String f9812a;

    static {
        int i10;
        f9810h = new HashMap();
        for (f fVar : values()) {
            f9810h.put(fVar.f9812a, fVar);
        }
    }

    private f(String str) {
        this.f9812a = str;
    }

    static f b(String str) {
        Map map = f9810h;
        if (map.containsKey(str)) {
            return (f) map.get(str);
        }
        throw new IllegalArgumentException("Unknown String Value: " + str);
    }

    public String toString() {
        return this.f9812a;
    }
}
