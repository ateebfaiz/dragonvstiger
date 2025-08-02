package com.horcrux.svg;

import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.util.HashMap;
import java.util.Map;

enum e {
    UNKNOWN("unknown"),
    DUPLICATE("duplicate"),
    WRAP("wrap"),
    NONE(DevicePublicKeyStringDef.NONE);
    

    /* renamed from: f  reason: collision with root package name */
    private static final Map f9790f = null;

    /* renamed from: a  reason: collision with root package name */
    private final String f9792a;

    static {
        int i10;
        f9790f = new HashMap();
        for (e eVar : values()) {
            f9790f.put(eVar.f9792a, eVar);
        }
    }

    private e(String str) {
        this.f9792a = str;
    }

    static e b(String str) {
        Map map = f9790f;
        if (map.containsKey(str)) {
            return (e) map.get(str);
        }
        throw new IllegalArgumentException("Unknown 'edgeMode' Value: " + str);
    }

    public String toString() {
        return this.f9792a;
    }
}
