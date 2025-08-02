package com.bugsnag.android;

import c1.f;
import com.alibaba.pdns.d;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.t;

public abstract class t0 {
    public static final Map a(s1 s1Var) {
        Pair a10 = t.a("Bugsnag-Payload-Version", "4.0");
        String c10 = s1Var.c();
        if (c10 == null) {
            c10 = "";
        }
        Map j10 = i0.j(a10, t.a("Bugsnag-Api-Key", c10), t.a("Bugsnag-Sent-At", f.c(new Date())), t.a("Content-Type", "application/json"));
        Set d10 = s1Var.d();
        if (true ^ d10.isEmpty()) {
            j10.put("Bugsnag-Stacktrace-Types", b(d10));
        }
        return i0.p(j10);
    }

    public static final String b(Set set) {
        if (set.isEmpty()) {
            return "";
        }
        Iterable<ErrorType> iterable = set;
        ArrayList arrayList = new ArrayList(r.v(iterable, 10));
        for (ErrorType desc$bugsnag_android_core_release : iterable) {
            arrayList.add(desc$bugsnag_android_core_release.getDesc$bugsnag_android_core_release());
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            String str = it.next();
            while (it.hasNext()) {
                str = ((String) str) + ',' + ((String) it.next());
            }
            return (String) str;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public static final Map c(String str) {
        return i0.i(t.a("Bugsnag-Payload-Version", d.f17906g), t.a("Bugsnag-Api-Key", str), t.a("Content-Type", "application/json"), t.a("Bugsnag-Sent-At", f.c(new Date())));
    }
}
