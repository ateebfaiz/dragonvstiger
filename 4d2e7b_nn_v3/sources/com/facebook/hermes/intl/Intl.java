package com.facebook.hermes.intl;

import android.icu.lang.UCharacter;
import android.os.Build;
import d6.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import o4.f;
import o4.k;

@a
public class Intl {
    private static List a(List list) {
        if (list.size() == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                throw new k("Incorrect locale information provided");
            } else if (!str.isEmpty()) {
                String b10 = f.b(str);
                if (!b10.isEmpty() && !arrayList.contains(b10)) {
                    arrayList.add(b10);
                }
            } else {
                throw new k("Incorrect locale information provided");
            }
        }
        return arrayList;
    }

    @a
    public static List<String> getCanonicalLocales(List<String> list) throws k {
        return a(list);
    }

    @a
    public static String toLocaleLowerCase(List<String> list, String str) throws k {
        String[] strArr = new String[list.size()];
        if (Build.VERSION.SDK_INT >= 24) {
            return UCharacter.toLowerCase(f.a(g.c((String[]) list.toArray(strArr)).f19915a.h()), str);
        }
        return str.toLowerCase((Locale) g.f((String[]) list.toArray(strArr)).f19915a.h());
    }

    @a
    public static String toLocaleUpperCase(List<String> list, String str) throws k {
        String[] strArr = new String[list.size()];
        if (Build.VERSION.SDK_INT >= 24) {
            return UCharacter.toUpperCase(f.a(g.c((String[]) list.toArray(strArr)).f19915a.h()), str);
        }
        return str.toUpperCase((Locale) g.f((String[]) list.toArray(strArr)).f19915a.h());
    }
}
