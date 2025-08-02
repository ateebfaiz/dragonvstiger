package com.bugsnag.android;

import com.bugsnag.android.a4;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

class b4 {

    /* renamed from: a  reason: collision with root package name */
    private final t3 f18645a;

    /* renamed from: b  reason: collision with root package name */
    private final s2 f18646b;

    b4(t3 t3Var, s2 s2Var) {
        this.f18645a = t3Var;
        this.f18646b = s2Var;
    }

    public a4 a(Map map) {
        boolean booleanValue;
        String str = (String) u2.d(map, "type");
        List<Map> list = (List) u2.d(map, "stacktrace");
        ArrayList arrayList = new ArrayList(list.size());
        for (Map a10 : list) {
            arrayList.add(this.f18645a.a(a10));
        }
        Boolean bool = (Boolean) u2.c(map, "errorReportingThread");
        if (bool == null) {
            booleanValue = false;
        } else {
            booleanValue = bool.booleanValue();
        }
        return new a4(u2.d(map, "id").toString(), (String) u2.d(map, "name"), ErrorType.valueOf(str.toUpperCase(Locale.US)), booleanValue, a4.b.a((String) u2.d(map, "state")), new u3(arrayList), this.f18646b);
    }
}
