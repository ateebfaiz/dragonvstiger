package com.botion.captcha;

import android.content.Context;
import android.text.TextUtils;

final class h {
    static boolean a(String str) {
        return TextUtils.isEmpty(str) || "$unknown".equals(str);
    }

    static long b(Context context, String str) {
        try {
            return context.getSharedPreferences("boc_fp", 0).getLong(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    static String c(Context context, String str) {
        String a10 = j.a(str.getBytes());
        if (a(a10)) {
            return null;
        }
        a(context, "boc_fp", a10);
        return a10;
    }

    static String a(Context context, String str) {
        try {
            return context.getSharedPreferences("boc_fp", 0).getString(str, (String) null);
        } catch (Exception unused) {
            return "$unknown";
        }
    }

    static void a(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("boc_fp", 0).edit().putString(str, str2).apply();
        } catch (Exception unused) {
        }
    }
}
