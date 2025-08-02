package com.bugsnag.android;

import c1.j;
import com.alibaba.pdns.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class a3 {

    /* renamed from: a  reason: collision with root package name */
    private final Collection f18610a;

    /* renamed from: b  reason: collision with root package name */
    private final j f18611b;

    a3(Collection collection, j jVar) {
        this.f18610a = collection;
        this.f18611b = jVar;
    }

    private s3 b(Map map, Collection collection) {
        String str = (String) u2.c(map, "methodName");
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String str3 = (String) u2.c(map, "class");
        String str4 = str3 + f.G + str;
        if (str3 != null) {
            str2 = str3;
            str = str4;
        }
        s3 s3Var = new s3(str, (String) u2.c(map, "file"), (Number) u2.c(map, "lineNumber"), u3.f19023b.a(str2, collection));
        s3Var.i(ErrorType.ANDROID);
        return s3Var;
    }

    public List a(Map map) {
        List<Map> list = (List) u2.d(map, "nativeStack");
        ArrayList arrayList = new ArrayList(list.size());
        for (Map b10 : list) {
            arrayList.add(b(b10, this.f18610a));
        }
        return new u3(arrayList).a();
    }
}
