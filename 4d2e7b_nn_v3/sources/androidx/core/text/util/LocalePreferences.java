package androidx.core.text.util;

import android.icu.number.NumberFormatter;
import android.icu.text.DateFormat;
import android.icu.text.DateTimePatternGenerator;
import android.icu.util.Calendar;
import android.icu.util.MeasureUnit;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Locale;

@RequiresApi(21)
public final class LocalePreferences {
    private static final String TAG = "LocalePreferences";
    private static final String[] WEATHER_FAHRENHEIT_COUNTRIES = {"BS", "BZ", "KY", "PR", "PW", "US"};

    public static class CalendarType {
        public static final String CHINESE = "chinese";
        public static final String DANGI = "dangi";
        public static final String DEFAULT = "";
        public static final String GREGORIAN = "gregorian";
        public static final String HEBREW = "hebrew";
        public static final String INDIAN = "indian";
        public static final String ISLAMIC = "islamic";
        public static final String ISLAMIC_CIVIL = "islamic-civil";
        public static final String ISLAMIC_RGSA = "islamic-rgsa";
        public static final String ISLAMIC_TBLA = "islamic-tbla";
        public static final String ISLAMIC_UMALQURA = "islamic-umalqura";
        public static final String PERSIAN = "persian";
        private static final String U_EXTENSION_TAG = "ca";

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Retention(RetentionPolicy.SOURCE)
        public @interface CalendarTypes {
        }

        private CalendarType() {
        }
    }

    public static class FirstDayOfWeek {
        public static final String DEFAULT = "";
        public static final String FRIDAY = "fri";
        public static final String MONDAY = "mon";
        public static final String SATURDAY = "sat";
        public static final String SUNDAY = "sun";
        public static final String THURSDAY = "thu";
        public static final String TUESDAY = "tue";
        private static final String U_EXTENSION_TAG = "fw";
        public static final String WEDNESDAY = "wed";

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Retention(RetentionPolicy.SOURCE)
        public @interface Days {
        }

        private FirstDayOfWeek() {
        }
    }

    public static class HourCycle {
        public static final String DEFAULT = "";
        public static final String H11 = "h11";
        public static final String H12 = "h12";
        public static final String H23 = "h23";
        public static final String H24 = "h24";
        private static final String U_EXTENSION_TAG = "hc";

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Retention(RetentionPolicy.SOURCE)
        public @interface HourCycleTypes {
        }

        private HourCycle() {
        }
    }

    public static class TemperatureUnit {
        public static final String CELSIUS = "celsius";
        public static final String DEFAULT = "";
        public static final String FAHRENHEIT = "fahrenhe";
        public static final String KELVIN = "kelvin";
        private static final String U_EXTENSION_TAG = "mu";

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Retention(RetentionPolicy.SOURCE)
        public @interface TemperatureUnits {
        }

        private TemperatureUnit() {
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15121a;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0021 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002e */
        static {
            /*
                android.icu.text.DateFormat$HourCycle[] r0 = android.icu.text.DateFormat.HourCycle.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f15121a = r0
                android.icu.text.DateFormat$HourCycle r1 = android.icu.text.DateFormat.HourCycle.HOUR_CYCLE_11     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f15121a     // Catch:{ NoSuchFieldError -> 0x0021 }
                android.icu.text.DateFormat$HourCycle r1 = android.icu.text.DateFormat.HourCycle.HOUR_CYCLE_12     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0021 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                int[] r0 = f15121a     // Catch:{ NoSuchFieldError -> 0x002e }
                android.icu.text.DateFormat$HourCycle r1 = android.icu.text.DateFormat.HourCycle.HOUR_CYCLE_23     // Catch:{ NoSuchFieldError -> 0x002e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r0 = f15121a     // Catch:{ NoSuchFieldError -> 0x003b }
                android.icu.text.DateFormat$HourCycle r1 = android.icu.text.DateFormat.HourCycle.HOUR_CYCLE_24     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.util.LocalePreferences.a.<clinit>():void");
        }
    }

    private static class b {
        @DoNotInline
        static String a(@NonNull Locale locale) {
            return Calendar.getInstance(locale).getType();
        }

        @DoNotInline
        static Locale b() {
            return Locale.getDefault(Locale.Category.FORMAT);
        }
    }

    private static class c {
        @DoNotInline
        static String a(@NonNull Locale locale) {
            return b(DateTimePatternGenerator.getInstance(locale).getDefaultHourCycle());
        }

        private static String b(DateFormat.HourCycle hourCycle) {
            int i10 = a.f15121a[hourCycle.ordinal()];
            if (i10 == 1) {
                return HourCycle.H11;
            }
            if (i10 == 2) {
                return HourCycle.H12;
            }
            if (i10 == 3) {
                return HourCycle.H23;
            }
            if (i10 != 4) {
                return "";
            }
            return HourCycle.H24;
        }

        @DoNotInline
        static String c(@NonNull Locale locale) {
            String identifier = NumberFormatter.with().usage("weather").unit(MeasureUnit.CELSIUS).locale(locale).format(1).getOutputUnit().getIdentifier();
            if (identifier.startsWith(TemperatureUnit.FAHRENHEIT)) {
                return TemperatureUnit.FAHRENHEIT;
            }
            return identifier;
        }
    }

    private LocalePreferences() {
    }

    private static String getBaseFirstDayOfWeek(@NonNull Locale locale) {
        return getStringOfFirstDayOfWeek(java.util.Calendar.getInstance(locale).getFirstDayOfWeek());
    }

    private static String getBaseHourCycle(@NonNull Locale locale) {
        if (android.text.format.DateFormat.getBestDateTimePattern(locale, "jm").contains("H")) {
            return HourCycle.H23;
        }
        return HourCycle.H12;
    }

    @NonNull
    public static String getCalendarType() {
        return getCalendarType(true);
    }

    private static Locale getDefaultLocale() {
        return Locale.getDefault();
    }

    @NonNull
    public static String getFirstDayOfWeek() {
        return getFirstDayOfWeek(true);
    }

    @NonNull
    public static String getHourCycle() {
        return getHourCycle(true);
    }

    private static String getStringOfFirstDayOfWeek(int i10) {
        String[] strArr = {FirstDayOfWeek.SUNDAY, FirstDayOfWeek.MONDAY, FirstDayOfWeek.TUESDAY, FirstDayOfWeek.WEDNESDAY, FirstDayOfWeek.THURSDAY, FirstDayOfWeek.FRIDAY, FirstDayOfWeek.SATURDAY};
        if (i10 < 1 || i10 > 7) {
            return "";
        }
        return strArr[i10 - 1];
    }

    private static String getTemperatureHardCoded(Locale locale) {
        if (Arrays.binarySearch(WEATHER_FAHRENHEIT_COUNTRIES, locale.getCountry()) >= 0) {
            return TemperatureUnit.FAHRENHEIT;
        }
        return TemperatureUnit.CELSIUS;
    }

    @NonNull
    public static String getTemperatureUnit() {
        return getTemperatureUnit(true);
    }

    private static String getUnicodeLocaleType(String str, String str2, Locale locale, boolean z10) {
        String unicodeLocaleType = locale.getUnicodeLocaleType(str);
        if (unicodeLocaleType != null) {
            return unicodeLocaleType;
        }
        if (!z10) {
            return str2;
        }
        return null;
    }

    @NonNull
    public static String getCalendarType(@NonNull Locale locale) {
        return getCalendarType(locale, true);
    }

    @NonNull
    public static String getFirstDayOfWeek(@NonNull Locale locale) {
        return getFirstDayOfWeek(locale, true);
    }

    @NonNull
    public static String getHourCycle(@NonNull Locale locale) {
        return getHourCycle(locale, true);
    }

    @NonNull
    public static String getTemperatureUnit(@NonNull Locale locale) {
        return getTemperatureUnit(locale, true);
    }

    @NonNull
    public static String getCalendarType(boolean z10) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = b.b();
        } else {
            locale = getDefaultLocale();
        }
        return getCalendarType(locale, z10);
    }

    @NonNull
    public static String getFirstDayOfWeek(boolean z10) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = b.b();
        } else {
            locale = getDefaultLocale();
        }
        return getFirstDayOfWeek(locale, z10);
    }

    @NonNull
    public static String getHourCycle(boolean z10) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = b.b();
        } else {
            locale = getDefaultLocale();
        }
        return getHourCycle(locale, z10);
    }

    @NonNull
    public static String getTemperatureUnit(boolean z10) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = b.b();
        } else {
            locale = getDefaultLocale();
        }
        return getTemperatureUnit(locale, z10);
    }

    @NonNull
    public static String getCalendarType(@NonNull Locale locale, boolean z10) {
        String unicodeLocaleType = getUnicodeLocaleType("ca", "", locale, z10);
        if (unicodeLocaleType != null) {
            return unicodeLocaleType;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return b.a(locale);
        }
        if (z10) {
            return CalendarType.GREGORIAN;
        }
        return "";
    }

    @NonNull
    public static String getFirstDayOfWeek(@NonNull Locale locale, boolean z10) {
        String unicodeLocaleType = getUnicodeLocaleType("fw", "", locale, z10);
        return unicodeLocaleType != null ? unicodeLocaleType : getBaseFirstDayOfWeek(locale);
    }

    @NonNull
    public static String getHourCycle(@NonNull Locale locale, boolean z10) {
        String unicodeLocaleType = getUnicodeLocaleType("hc", "", locale, z10);
        if (unicodeLocaleType != null) {
            return unicodeLocaleType;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return c.a(locale);
        }
        return getBaseHourCycle(locale);
    }

    @NonNull
    public static String getTemperatureUnit(@NonNull Locale locale, boolean z10) {
        String unicodeLocaleType = getUnicodeLocaleType("mu", "", locale, z10);
        if (unicodeLocaleType != null) {
            return unicodeLocaleType;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return c.c(locale);
        }
        return getTemperatureHardCoded(locale);
    }
}
