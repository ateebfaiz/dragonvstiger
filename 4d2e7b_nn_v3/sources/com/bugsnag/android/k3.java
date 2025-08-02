package com.bugsnag.android;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.Collection;
import java.util.Map;

abstract class k3 {
    static WritableArray a(Collection collection) {
        WritableArray createArray = Arguments.createArray();
        if (collection == null) {
            return createArray;
        }
        for (Object next : collection) {
            if (next instanceof String) {
                createArray.pushString((String) next);
            } else if (next instanceof Integer) {
                createArray.pushInt(((Integer) next).intValue());
            } else if (next instanceof Number) {
                createArray.pushDouble(((Number) next).doubleValue());
            } else if (next instanceof Boolean) {
                createArray.pushBoolean(((Boolean) next).booleanValue());
            } else if (next instanceof Map) {
                createArray.pushMap(b((Map) next));
            } else if (next instanceof Collection) {
                createArray.pushArray(a((Collection) next));
            } else if (next == null) {
                createArray.pushNull();
            }
        }
        return createArray;
    }

    static WritableMap b(Map map) {
        WritableMap createMap = Arguments.createMap();
        if (map == null) {
            return createMap;
        }
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                createMap.putString(str, (String) value);
            } else if (value instanceof Integer) {
                createMap.putInt(str, ((Integer) value).intValue());
            } else if (value instanceof Number) {
                createMap.putDouble(str, ((Number) value).doubleValue());
            } else if (value instanceof Boolean) {
                createMap.putBoolean(str, ((Boolean) value).booleanValue());
            } else if (value instanceof Map) {
                createMap.putMap(str, b((Map) value));
            } else if (value instanceof Collection) {
                createMap.putArray(str, a((Collection) value));
            } else if (value == null) {
                createMap.putNull(str);
            }
        }
        return createMap;
    }
}
