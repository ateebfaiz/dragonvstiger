package com.horcrux.svg;

import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.util.HashMap;
import java.util.Map;

enum g0 {
    None(DevicePublicKeyStringDef.NONE),
    Underline("underline"),
    Overline("overline"),
    LineThrough("line-through"),
    Blink("blink");
    

    /* renamed from: g  reason: collision with root package name */
    private static final Map f9829g = null;

    /* renamed from: a  reason: collision with root package name */
    private final String f9831a;

    static {
        int i10;
        f9829g = new HashMap();
        for (g0 g0Var : values()) {
            f9829g.put(g0Var.f9831a, g0Var);
        }
    }

    private g0(String str) {
        this.f9831a = str;
    }

    static g0 b(String str) {
        Map map = f9829g;
        if (map.containsKey(str)) {
            return (g0) map.get(str);
        }
        throw new IllegalArgumentException("Unknown String Value: " + str);
    }

    public String toString() {
        return this.f9831a;
    }
}
