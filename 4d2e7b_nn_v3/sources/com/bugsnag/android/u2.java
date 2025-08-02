package com.bugsnag.android;

import java.util.Map;

abstract class u2 {
    static Integer a(Map map, String str) {
        Number number = (Number) c(map, str);
        if (number != null) {
            return Integer.valueOf(number.intValue());
        }
        return null;
    }

    static Long b(Map map, String str) {
        Number number = (Number) c(map, str);
        if (number != null) {
            return Long.valueOf(number.longValue());
        }
        return null;
    }

    static Object c(Map map, String str) {
        Object obj = map.get(str);
        if (obj != null) {
            return obj;
        }
        return null;
    }

    static Object d(Map map, String str) {
        Object obj = map.get(str);
        if (obj != null) {
            return obj;
        }
        throw new IllegalArgumentException("Missing required parameter " + str);
    }
}
