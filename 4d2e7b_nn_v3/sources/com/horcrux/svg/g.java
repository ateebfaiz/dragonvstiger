package com.horcrux.svg;

import java.util.HashMap;
import java.util.Map;

enum g {
    MATRIX("matrix"),
    SATURATE("saturate"),
    HUE_ROTATE("hueRotate"),
    LUMINANCE_TO_ALPHA("luminanceToAlpha");
    

    /* renamed from: f  reason: collision with root package name */
    private static final Map f9821f = null;

    /* renamed from: a  reason: collision with root package name */
    private final String f9823a;

    static {
        int i10;
        f9821f = new HashMap();
        for (g gVar : values()) {
            f9821f.put(gVar.f9823a, gVar);
        }
    }

    private g(String str) {
        this.f9823a = str;
    }

    static g b(String str) {
        Map map = f9821f;
        if (map.containsKey(str)) {
            return (g) map.get(str);
        }
        throw new IllegalArgumentException("Unknown String Value: " + str);
    }

    public String toString() {
        return this.f9823a;
    }
}
