package com.blankj.utilcode.util;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

public final class k {

    /* renamed from: b  reason: collision with root package name */
    private static final Map f18399b = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f18400a;

    private k(String str, int i10) {
        this.f18400a = p.a().getSharedPreferences(str, i10);
    }

    public static k a(String str) {
        return b(str, 0);
    }

    public static k b(String str, int i10) {
        if (e(str)) {
            str = "spUtils";
        }
        Map map = f18399b;
        k kVar = (k) map.get(str);
        if (kVar == null) {
            synchronized (k.class) {
                try {
                    kVar = (k) map.get(str);
                    if (kVar == null) {
                        kVar = new k(str, i10);
                        map.put(str, kVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return kVar;
    }

    private static boolean e(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isWhitespace(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public String c(String str) {
        return d(str, "");
    }

    public String d(String str, String str2) {
        return this.f18400a.getString(str, str2);
    }

    public void f(String str) {
        g(str, false);
    }

    public void g(String str, boolean z10) {
        if (z10) {
            this.f18400a.edit().remove(str).commit();
        } else {
            this.f18400a.edit().remove(str).apply();
        }
    }
}
