package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.core.text.ICUCompat;
import java.util.Locale;

public final class LocaleListCompat {
    private static final LocaleListCompat sEmptyLocaleList = create(new Locale[0]);
    private final f mImpl;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final Locale[] f15037a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        @DoNotInline
        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        private static boolean b(Locale locale) {
            for (Locale equals : f15037a) {
                if (equals.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        @DoNotInline
        static boolean c(@NonNull Locale locale, @NonNull Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String maximizeAndGetScript = ICUCompat.maximizeAndGetScript(locale);
            if (!maximizeAndGetScript.isEmpty()) {
                return maximizeAndGetScript.equals(ICUCompat.maximizeAndGetScript(locale2));
            }
            String country = locale.getCountry();
            if (country.isEmpty() || country.equals(locale2.getCountry())) {
                return true;
            }
            return false;
        }
    }

    static class b {
        @DoNotInline
        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        @DoNotInline
        static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        @DoNotInline
        static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    private LocaleListCompat(f fVar) {
        this.mImpl = fVar;
    }

    @NonNull
    public static LocaleListCompat create(@NonNull Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return wrap(b.a(localeArr));
        }
        return new LocaleListCompat(new e(localeArr));
    }

    static Locale forLanguageTagCompat(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains("_")) {
            return new Locale(str);
        } else {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    @NonNull
    public static LocaleListCompat forLanguageTags(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return getEmptyLocaleList();
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i10 = 0; i10 < length; i10++) {
            localeArr[i10] = a.a(split[i10]);
        }
        return create(localeArr);
    }

    @Size(min = 1)
    @NonNull
    public static LocaleListCompat getAdjustedDefault() {
        if (Build.VERSION.SDK_INT >= 24) {
            return wrap(b.b());
        }
        return create(Locale.getDefault());
    }

    @Size(min = 1)
    @NonNull
    public static LocaleListCompat getDefault() {
        if (Build.VERSION.SDK_INT >= 24) {
            return wrap(b.c());
        }
        return create(Locale.getDefault());
    }

    @NonNull
    public static LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    @RequiresApi(21)
    public static boolean matchesLanguageAndScript(@NonNull Locale locale, @NonNull Locale locale2) {
        if (Build.VERSION.SDK_INT >= 33) {
            return LocaleList.matchesLanguageAndScript(locale, locale2);
        }
        return a.c(locale, locale2);
    }

    @RequiresApi(24)
    @Deprecated
    public static LocaleListCompat wrap(Object obj) {
        return wrap(d.a(obj));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocaleListCompat) || !this.mImpl.equals(((LocaleListCompat) obj).mImpl)) {
            return false;
        }
        return true;
    }

    @Nullable
    public Locale get(int i10) {
        return this.mImpl.get(i10);
    }

    @Nullable
    public Locale getFirstMatch(@NonNull String[] strArr) {
        return this.mImpl.d(strArr);
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    @IntRange(from = -1)
    public int indexOf(@Nullable Locale locale) {
        return this.mImpl.a(locale);
    }

    public boolean isEmpty() {
        return this.mImpl.isEmpty();
    }

    @IntRange(from = 0)
    public int size() {
        return this.mImpl.size();
    }

    @NonNull
    public String toLanguageTags() {
        return this.mImpl.b();
    }

    @NonNull
    public String toString() {
        return this.mImpl.toString();
    }

    @Nullable
    public Object unwrap() {
        return this.mImpl.c();
    }

    @RequiresApi(24)
    @NonNull
    public static LocaleListCompat wrap(@NonNull LocaleList localeList) {
        return new LocaleListCompat(new n(localeList));
    }
}
