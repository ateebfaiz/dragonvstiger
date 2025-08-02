package com.facebook.hermes.intl;

import java.util.Arrays;
import o4.k;

public abstract class j {

    public enum a {
        BOOLEAN,
        STRING
    }

    public static Object a(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (o4.j.n(obj)) {
            return obj4;
        }
        if (o4.j.k(obj)) {
            double f10 = o4.j.f(obj);
            if (!Double.isNaN(f10) && f10 <= o4.j.f(obj3) && f10 >= o4.j.f(obj2)) {
                return obj;
            }
            throw new k(str + " value is invalid.");
        }
        throw new k(str + " value is invalid.");
    }

    public static Object b(Object obj, String str, Object obj2, Object obj3, Object obj4) {
        return a(str, o4.j.a(obj, str), obj2, obj3, obj4);
    }

    public static Object c(Object obj, String str, a aVar, Object obj2, Object obj3) {
        Object a10 = o4.j.a(obj, str);
        if (o4.j.n(a10)) {
            return obj3;
        }
        if (o4.j.j(a10)) {
            a10 = "";
        }
        if (aVar == a.BOOLEAN && !o4.j.i(a10)) {
            throw new k("Boolean option expected but not found");
        } else if (aVar == a.STRING && !o4.j.m(a10)) {
            throw new k("String option expected but not found");
        } else if (o4.j.n(obj2) || Arrays.asList((Object[]) obj2).contains(a10)) {
            return a10;
        } else {
            throw new k("String option expected but not found");
        }
    }

    public static Enum d(Class cls, Object obj) {
        try {
            if (o4.j.n(obj)) {
                return Enum.valueOf(cls, "UNDEFINED");
            }
            if (o4.j.j(obj)) {
                return null;
            }
            String h10 = o4.j.h(obj);
            if (h10.equals("2-digit")) {
                return Enum.valueOf(cls, "DIGIT2");
            }
            for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                if (enumR.name().compareToIgnoreCase(h10) == 0) {
                    return enumR;
                }
            }
            return null;
        } catch (IllegalArgumentException unused) {
        }
    }
}
