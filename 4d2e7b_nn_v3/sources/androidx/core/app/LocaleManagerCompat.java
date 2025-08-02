package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.AnyThread;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.LocaleListCompat;
import java.util.Locale;

public final class LocaleManagerCompat {

    static class a {
        @DoNotInline
        static String a(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    static class b {
        @DoNotInline
        static LocaleListCompat a(Configuration configuration) {
            return LocaleListCompat.forLanguageTags(configuration.getLocales().toLanguageTags());
        }
    }

    static class c {
        @DoNotInline
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        @DoNotInline
        static LocaleList b(Object obj) {
            return ((LocaleManager) obj).getSystemLocales();
        }
    }

    private LocaleManagerCompat() {
    }

    @NonNull
    @AnyThread
    public static LocaleListCompat getApplicationLocales(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 33) {
            return LocaleListCompat.forLanguageTags(AppLocalesStorageHelper.readLocales(context));
        }
        Object localeManagerForApplication = getLocaleManagerForApplication(context);
        if (localeManagerForApplication != null) {
            return LocaleListCompat.wrap(c.a(localeManagerForApplication));
        }
        return LocaleListCompat.getEmptyLocaleList();
    }

    @VisibleForTesting
    static LocaleListCompat getConfigurationLocales(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.a(configuration);
        }
        return LocaleListCompat.forLanguageTags(a.a(configuration.locale));
    }

    @RequiresApi(33)
    private static Object getLocaleManagerForApplication(Context context) {
        return context.getSystemService("locale");
    }

    @NonNull
    @AnyThread
    public static LocaleListCompat getSystemLocales(@NonNull Context context) {
        LocaleListCompat emptyLocaleList = LocaleListCompat.getEmptyLocaleList();
        if (Build.VERSION.SDK_INT < 33) {
            return getConfigurationLocales(Resources.getSystem().getConfiguration());
        }
        Object localeManagerForApplication = getLocaleManagerForApplication(context);
        if (localeManagerForApplication != null) {
            return LocaleListCompat.wrap(c.b(localeManagerForApplication));
        }
        return emptyLocaleList;
    }
}
