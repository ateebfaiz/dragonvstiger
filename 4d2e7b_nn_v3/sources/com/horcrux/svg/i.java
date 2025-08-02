package com.horcrux.svg;

import java.util.HashMap;
import java.util.Map;

enum i {
    OBJECT_BOUNDING_BOX("objectBoundingBox"),
    USER_SPACE_ON_USE("userSpaceOnUse");
    

    /* renamed from: d  reason: collision with root package name */
    private static final Map f9846d = null;

    /* renamed from: a  reason: collision with root package name */
    private final String f9848a;

    static {
        int i10;
        f9846d = new HashMap();
        for (i iVar : values()) {
            f9846d.put(iVar.f9848a, iVar);
        }
    }

    private i(String str) {
        this.f9848a = str;
    }

    static i b(String str) {
        Map map = f9846d;
        if (map.containsKey(str)) {
            return (i) map.get(str);
        }
        throw new IllegalArgumentException("Unknown 'Unit' Value: " + str);
    }

    public String toString() {
        return this.f9848a;
    }
}
