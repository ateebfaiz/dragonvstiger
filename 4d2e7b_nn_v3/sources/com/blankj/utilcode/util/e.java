package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

public abstract class e {
    static void a(Activity activity) {
        Locale locale;
        String c10 = s.g().c("KEY_LOCALE");
        if (!TextUtils.isEmpty(c10)) {
            if ("VALUE_FOLLOW_SYSTEM".equals(c10)) {
                locale = b(Resources.getSystem().getConfiguration());
            } else {
                locale = e(c10);
            }
            if (locale != null) {
                g(activity, locale);
                g(p.a(), locale);
            }
        }
    }

    private static Locale b(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return configuration.getLocales().get(0);
        }
        return configuration.locale;
    }

    private static boolean c(String str) {
        int i10 = 0;
        for (char c10 : str.toCharArray()) {
            if (c10 == '$') {
                if (i10 >= 1) {
                    return false;
                }
                i10++;
            }
        }
        if (i10 == 1) {
            return true;
        }
        return false;
    }

    private static void d(Configuration configuration, Locale locale) {
        configuration.setLocale(locale);
    }

    private static Locale e(String str) {
        Locale f10 = f(str);
        if (f10 == null) {
            Log.e("LanguageUtils", "The string of " + str + " is not in the correct format.");
            s.g().f("KEY_LOCALE");
        }
        return f10;
    }

    private static Locale f(String str) {
        if (!c(str)) {
            return null;
        }
        try {
            int indexOf = str.indexOf("$");
            return new Locale(str.substring(0, indexOf), str.substring(indexOf + 1));
        } catch (Exception unused) {
            return null;
        }
    }

    private static void g(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        d(configuration, locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
