package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.HashMap;
import java.util.Map;

class u extends b {

    /* renamed from: e  reason: collision with root package name */
    private final p f2872e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f2873f = new HashMap();

    u(ReadableMap readableMap, p pVar) {
        ReadableMap map = readableMap.getMap("style");
        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            this.f2873f.put(nextKey, Integer.valueOf(map.getInt(nextKey)));
        }
        this.f2872e = pVar;
    }

    public String e() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("StyleAnimatedNode[");
        sb2.append(this.f2778d);
        sb2.append("] mPropMapping: ");
        Map map = this.f2873f;
        if (map != null) {
            str = map.toString();
        } else {
            str = "null";
        }
        sb2.append(str);
        return sb2.toString();
    }

    public void i(JavaOnlyMap javaOnlyMap) {
        for (Map.Entry entry : this.f2873f.entrySet()) {
            b k10 = this.f2872e.k(((Integer) entry.getValue()).intValue());
            if (k10 == null) {
                throw new IllegalArgumentException("Mapped style node does not exist");
            } else if (k10 instanceof y) {
                ((y) k10).i(javaOnlyMap);
            } else if (k10 instanceof b0) {
                b0 b0Var = (b0) k10;
                Object k11 = b0Var.k();
                if (k11 instanceof Integer) {
                    javaOnlyMap.putInt((String) entry.getKey(), ((Integer) k11).intValue());
                } else if (k11 instanceof String) {
                    javaOnlyMap.putString((String) entry.getKey(), (String) k11);
                } else {
                    javaOnlyMap.putDouble((String) entry.getKey(), b0Var.l());
                }
            } else if (k10 instanceof f) {
                javaOnlyMap.putInt((String) entry.getKey(), ((f) k10).i());
            } else if (k10 instanceof q) {
                ((q) k10).i((String) entry.getKey(), javaOnlyMap);
            } else {
                throw new IllegalArgumentException("Unsupported type of node used in property node " + k10.getClass());
            }
        }
    }
}
