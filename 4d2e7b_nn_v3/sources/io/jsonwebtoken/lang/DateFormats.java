package io.jsonwebtoken.lang;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateFormats {
    private static final ThreadLocal<DateFormat> ISO_8601 = new ThreadLocal<DateFormat>() {
        /* access modifiers changed from: protected */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormats.ISO_8601_PATTERN);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat;
        }
    };
    private static final ThreadLocal<DateFormat> ISO_8601_MILLIS = new ThreadLocal<DateFormat>() {
        /* access modifiers changed from: protected */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormats.ISO_8601_MILLIS_PATTERN);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat;
        }
    };
    private static final String ISO_8601_MILLIS_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String ISO_8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public static String formatIso8601(Date date) {
        return formatIso8601(date, true);
    }

    public static Date parseIso8601Date(String str) throws ParseException {
        Assert.notNull(str, "String argument cannot be null.");
        if (str.lastIndexOf(46) > -1) {
            return ISO_8601_MILLIS.get().parse(str);
        }
        return ISO_8601.get().parse(str);
    }

    public static String formatIso8601(Date date, boolean z10) {
        if (z10) {
            return ISO_8601_MILLIS.get().format(date);
        }
        return ISO_8601.get().format(date);
    }
}
