package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.databind.j;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class d {
    public static String a(j jVar) {
        String str;
        String str2;
        String name = jVar.s().getName();
        if (c(name)) {
            if (name.indexOf(46, 10) >= 0) {
                return null;
            }
            str2 = "Java 8 date/time";
            str = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310";
        } else if (!d(name)) {
            return null;
        } else {
            str2 = "Joda date/time";
            str = "com.fasterxml.jackson.datatype:jackson-datatype-joda";
        }
        return String.format("%s type %s not supported by default: add Module \"%s\" to enable handling", new Object[]{str2, f.C(jVar), str});
    }

    public static Object b(j jVar) {
        Class<String> s10 = jVar.s();
        Class S = f.S(s10);
        if (S != null) {
            return f.l(S);
        }
        if (jVar.C() || jVar.d()) {
            return p.a.NON_EMPTY;
        }
        if (s10 == String.class) {
            return "";
        }
        if (jVar.L(Date.class)) {
            return new Date(0);
        }
        if (!jVar.L(Calendar.class)) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(0);
        return gregorianCalendar;
    }

    private static boolean c(String str) {
        return str.startsWith("java.time.");
    }

    private static boolean d(String str) {
        return str.startsWith("org.joda.time.");
    }
}
