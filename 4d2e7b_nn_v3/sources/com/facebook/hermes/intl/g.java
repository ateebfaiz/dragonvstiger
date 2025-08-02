package com.facebook.hermes.intl;

import android.icu.util.ULocale;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import o4.b;
import o4.f;
import o4.n;
import o4.z;

public abstract class g {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public b f19915a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap f19916b = new HashMap();
    }

    public static String a(String[] strArr, String str) {
        while (Arrays.asList(strArr).indexOf(str) <= -1) {
            int lastIndexOf = str.lastIndexOf("-");
            if (lastIndexOf < 0) {
                return "";
            }
            if (lastIndexOf >= 2 && str.charAt(lastIndexOf - 2) == '-') {
                lastIndexOf -= 2;
            }
            str = str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static ULocale b(b bVar) {
        ULocale[] a10 = ULocale.getAvailableLocales();
        ULocale[] uLocaleArr = {f.a(bVar.d())};
        boolean[] zArr = new boolean[1];
        ULocale a11 = ULocale.acceptLanguage(uLocaleArr, a10, zArr);
        if (zArr[0] || a11 == null) {
            return null;
        }
        return a11;
    }

    public static a c(String[] strArr) {
        a aVar = new a();
        for (String b10 : strArr) {
            b b11 = n.b(b10);
            ULocale b12 = b(b11);
            if (b12 != null) {
                aVar.f19915a = z.k(b12);
                aVar.f19916b = b11.b();
                return aVar;
            }
        }
        aVar.f19915a = z.i();
        return aVar;
    }

    public static String[] d(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (b(n.b(str)) != null) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] e() {
        ArrayList arrayList = new ArrayList();
        for (Locale languageTag : Locale.getAvailableLocales()) {
            arrayList.add(languageTag.toLanguageTag());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static a f(String[] strArr) {
        return g(strArr, e());
    }

    public static a g(String[] strArr, String[] strArr2) {
        a aVar = new a();
        for (String b10 : strArr) {
            b b11 = n.b(b10);
            String a10 = a(strArr2, b11.f());
            if (!a10.isEmpty()) {
                aVar.f19915a = n.b(a10);
                aVar.f19916b = b11.b();
                return aVar;
            }
        }
        aVar.f19915a = n.a();
        return aVar;
    }

    public static String[] h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        String[] e10 = e();
        for (String str : strArr) {
            String a10 = a(e10, n.b(str).f());
            if (a10 != null && !a10.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
