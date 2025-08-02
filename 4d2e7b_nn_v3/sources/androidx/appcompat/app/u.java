package androidx.appcompat.app;

import androidx.core.os.LocaleListCompat;
import java.util.LinkedHashSet;
import java.util.Locale;

abstract class u {
    private static LocaleListCompat a(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        Locale locale;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i10 = 0; i10 < localeListCompat.size() + localeListCompat2.size(); i10++) {
            if (i10 < localeListCompat.size()) {
                locale = localeListCompat.get(i10);
            } else {
                locale = localeListCompat2.get(i10 - localeListCompat.size());
            }
            if (locale != null) {
                linkedHashSet.add(locale);
            }
        }
        return LocaleListCompat.create((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    static LocaleListCompat b(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        if (localeListCompat == null || localeListCompat.isEmpty()) {
            return LocaleListCompat.getEmptyLocaleList();
        }
        return a(localeListCompat, localeListCompat2);
    }
}
