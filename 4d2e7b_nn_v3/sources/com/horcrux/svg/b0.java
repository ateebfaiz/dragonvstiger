package com.horcrux.svg;

import java.util.HashMap;
import java.util.Map;

enum b0 {
    baseline("baseline"),
    textBottom("text-bottom"),
    alphabetic("alphabetic"),
    ideographic("ideographic"),
    middle("middle"),
    central("central"),
    mathematical("mathematical"),
    textTop("text-top"),
    bottom("bottom"),
    center("center"),
    top("top"),
    textBeforeEdge("text-before-edge"),
    textAfterEdge("text-after-edge"),
    beforeEdge("before-edge"),
    afterEdge("after-edge"),
    hanging("hanging");
    
    private static final Map P0 = null;

    /* renamed from: a  reason: collision with root package name */
    private final String f9772a;

    static {
        int i10;
        P0 = new HashMap();
        for (b0 b0Var : values()) {
            P0.put(b0Var.f9772a, b0Var);
        }
    }

    private b0(String str) {
        this.f9772a = str;
    }

    static b0 b(String str) {
        Map map = P0;
        if (map.containsKey(str)) {
            return (b0) map.get(str);
        }
        throw new IllegalArgumentException("Unknown String Value: " + str);
    }

    public String toString() {
        return this.f9772a;
    }
}
