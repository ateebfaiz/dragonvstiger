package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

public final class ConfigurationCompat {

    static class a {
        @DoNotInline
        static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }

        @DoNotInline
        static void b(@NonNull Configuration configuration, @NonNull LocaleListCompat localeListCompat) {
            configuration.setLocales((LocaleList) localeListCompat.unwrap());
        }
    }

    private ConfigurationCompat() {
    }

    @NonNull
    public static LocaleListCompat getLocales(@NonNull Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return LocaleListCompat.wrap(a.a(configuration));
        }
        return LocaleListCompat.create(configuration.locale);
    }

    public static void setLocales(@NonNull Configuration configuration, @NonNull LocaleListCompat localeListCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            a.b(configuration, localeListCompat);
        } else if (!localeListCompat.isEmpty()) {
            configuration.setLocale(localeListCompat.get(0));
        }
    }
}
