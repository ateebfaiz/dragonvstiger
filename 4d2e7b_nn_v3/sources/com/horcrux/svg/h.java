package com.horcrux.svg;

import java.util.HashMap;
import java.util.Map;

enum h {
    OVER("over"),
    IN("in"),
    OUT("out"),
    ATOP("atop"),
    XOR("xor"),
    ARITHMETIC("arithmetic");
    

    /* renamed from: h  reason: collision with root package name */
    private static final Map f9838h = null;

    /* renamed from: a  reason: collision with root package name */
    private final String f9840a;

    static {
        int i10;
        f9838h = new HashMap();
        for (h hVar : values()) {
            f9838h.put(hVar.f9840a, hVar);
        }
    }

    private h(String str) {
        this.f9840a = str;
    }

    static h b(String str) {
        Map map = f9838h;
        if (map.containsKey(str)) {
            return (h) map.get(str);
        }
        throw new IllegalArgumentException("Unknown String Value: " + str);
    }

    public String toString() {
        return this.f9840a;
    }
}
