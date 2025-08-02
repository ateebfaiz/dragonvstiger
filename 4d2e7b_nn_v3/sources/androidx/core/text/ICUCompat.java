package androidx.core.text;

import android.annotation.SuppressLint;
import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    static class a {
        @DoNotInline
        static String a(Locale locale) {
            return locale.getScript();
        }
    }

    static class b {
        @DoNotInline
        static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        @DoNotInline
        static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        @DoNotInline
        static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
            } catch (Exception e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    private ICUCompat() {
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String addLikelySubtagsBelowApi21(Locale locale) {
        String locale2 = locale.toString();
        try {
            Method method = sAddLikelySubtagsMethod;
            if (method != null) {
                return (String) method.invoke((Object) null, new Object[]{locale2});
            }
        } catch (IllegalAccessException e10) {
            Log.w(TAG, e10);
        } catch (InvocationTargetException e11) {
            Log.w(TAG, e11);
        }
        return locale2;
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String getScriptBelowApi21(String str) {
        try {
            Method method = sGetScriptMethod;
            if (method != null) {
                return (String) method.invoke((Object) null, new Object[]{str});
            }
        } catch (IllegalAccessException e10) {
            Log.w(TAG, e10);
        } catch (InvocationTargetException e11) {
            Log.w(TAG, e11);
        }
        return null;
    }

    @Nullable
    public static String maximizeAndGetScript(@NonNull Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.c(b.a(b.b(locale)));
        }
        try {
            return a.a((Locale) sAddLikelySubtagsMethod.invoke((Object) null, new Object[]{locale}));
        } catch (InvocationTargetException e10) {
            Log.w(TAG, e10);
            return a.a(locale);
        } catch (IllegalAccessException e11) {
            Log.w(TAG, e11);
            return a.a(locale);
        }
    }
}
