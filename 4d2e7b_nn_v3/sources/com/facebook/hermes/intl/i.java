package com.facebook.hermes.intl;

import android.os.Build;
import com.facebook.hermes.intl.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import o4.j;
import o4.z3;

public abstract class i {
    public static HashMap a(List list, Object obj, List list2) {
        g.a aVar;
        HashMap hashMap = new HashMap();
        String h10 = j.h(j.a(obj, "localeMatcher"));
        if (Build.VERSION.SDK_INT < 24 || h10.equals("lookup")) {
            aVar = g.f((String[]) list.toArray(new String[list.size()]));
        } else {
            aVar = g.c((String[]) list.toArray(new String[list.size()]));
        }
        HashSet<String> hashSet = new HashSet<>();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Object b10 = j.b();
            if (!aVar.f19916b.isEmpty() && aVar.f19916b.containsKey(str)) {
                String str2 = (String) aVar.f19916b.get(str);
                boolean isEmpty = str2.isEmpty();
                String str3 = str2;
                if (isEmpty) {
                    str3 = j.r("true");
                }
                hashSet.add(str);
                b10 = str3;
            }
            if (j.g(obj).containsKey(str)) {
                Object a10 = j.a(obj, str);
                if (j.m(a10) && j.h(a10).isEmpty()) {
                    a10 = j.o(true);
                }
                if (!j.n(a10) && !a10.equals(b10)) {
                    hashSet.remove(str);
                    b10 = a10;
                }
            }
            if (!j.j(b10)) {
                b10 = z3.f(str, b10);
            }
            if (!j.m(b10) || z3.c(str, j.h(b10), aVar.f19915a)) {
                hashMap.put(str, b10);
            } else {
                hashMap.put(str, j.b());
            }
        }
        for (String str4 : hashSet) {
            ArrayList arrayList = new ArrayList();
            String h11 = j.h(z3.f(str4, j.r((String) aVar.f19916b.get(str4))));
            if (!j.m(h11) || z3.c(str4, j.h(h11), aVar.f19915a)) {
                arrayList.add(h11);
                aVar.f19915a.g(str4, arrayList);
            }
        }
        hashMap.put("locale", aVar.f19915a);
        return hashMap;
    }
}
