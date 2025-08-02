package com.bugsnag.android;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

class l1 {

    /* renamed from: a  reason: collision with root package name */
    private final t3 f18819a;

    /* renamed from: b  reason: collision with root package name */
    private final s2 f18820b;

    l1(t3 t3Var, s2 s2Var) {
        this.f18819a = t3Var;
        this.f18820b = s2Var;
    }

    public k1 a(Map map) {
        String str = (String) u2.d(map, "type");
        List<Map> list = (List) u2.d(map, "stacktrace");
        ArrayList arrayList = new ArrayList(list.size());
        for (Map a10 : list) {
            arrayList.add(this.f18819a.a(a10));
        }
        return new k1(new m1((String) u2.d(map, "errorClass"), (String) u2.c(map, "errorMessage"), new u3(arrayList), ErrorType.valueOf(str.toUpperCase(Locale.US))), this.f18820b);
    }
}
