package com.fasterxml.jackson.databind.util;

import androidx.core.app.NotificationManagerCompat;
import com.fasterxml.jackson.core.io.e;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import io.jsonwebtoken.JwtParser;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class o extends DateFormat {
    protected static final DateFormat C;
    public static final o X = new o();
    protected static final Calendar Y;

    /* renamed from: g  reason: collision with root package name */
    protected static final Pattern f5705g = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d");

    /* renamed from: h  reason: collision with root package name */
    protected static final Pattern f5706h = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d[T]\\d\\d[:]\\d\\d(?:[:]\\d\\d)?(\\.\\d+)?(Z|[+-]\\d\\d(?:[:]?\\d\\d)?)?");

    /* renamed from: i  reason: collision with root package name */
    protected static final String[] f5707i = {"yyyy-MM-dd'T'HH:mm:ss.SSSX", "yyyy-MM-dd'T'HH:mm:ss.SSS", "EEE, dd MMM yyyy HH:mm:ss zzz", TimeUtils.YYYY_MM_DD};

    /* renamed from: j  reason: collision with root package name */
    protected static final TimeZone f5708j;

    /* renamed from: w  reason: collision with root package name */
    protected static final Locale f5709w;

    /* renamed from: a  reason: collision with root package name */
    protected transient TimeZone f5710a;

    /* renamed from: b  reason: collision with root package name */
    protected final Locale f5711b;

    /* renamed from: c  reason: collision with root package name */
    protected Boolean f5712c;

    /* renamed from: d  reason: collision with root package name */
    private transient Calendar f5713d;

    /* renamed from: e  reason: collision with root package name */
    private transient DateFormat f5714e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5715f;

    static {
        try {
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            f5708j = timeZone;
            Locale locale = Locale.US;
            f5709w = locale;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", locale);
            C = simpleDateFormat;
            simpleDateFormat.setTimeZone(timeZone);
            Y = new GregorianCalendar(timeZone, locale);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public o() {
        this.f5715f = true;
        this.f5711b = f5709w;
    }

    private static final DateFormat b(DateFormat dateFormat, String str, TimeZone timeZone, Locale locale, Boolean bool) {
        DateFormat dateFormat2;
        if (!locale.equals(f5709w)) {
            dateFormat2 = new SimpleDateFormat(str, locale);
            if (timeZone == null) {
                timeZone = f5708j;
            }
            dateFormat2.setTimeZone(timeZone);
        } else {
            dateFormat2 = (DateFormat) dateFormat.clone();
            if (timeZone != null) {
                dateFormat2.setTimeZone(timeZone);
            }
        }
        if (bool != null) {
            dateFormat2.setLenient(bool.booleanValue());
        }
        return dateFormat2;
    }

    protected static boolean c(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || !obj.equals(obj2)) {
            return false;
        }
        return true;
    }

    private static int h(String str, int i10) {
        return ((str.charAt(i10) - '0') * 10) + (str.charAt(i10 + 1) - '0');
    }

    private static int i(String str, int i10) {
        return ((str.charAt(i10) - '0') * 1000) + ((str.charAt(i10 + 1) - '0') * 100) + ((str.charAt(i10 + 2) - '0') * 10) + (str.charAt(i10 + 3) - '0');
    }

    private Date l(String str, ParsePosition parsePosition) {
        try {
            return new Date(e.c(str));
        } catch (NumberFormatException unused) {
            throw new ParseException(String.format("Timestamp value %s out of 64-bit value range", new Object[]{str}), parsePosition.getErrorIndex());
        }
    }

    private static void o(StringBuffer stringBuffer, int i10) {
        int i11 = i10 / 10;
        if (i11 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char) (i11 + 48));
            i10 -= i11 * 10;
        }
        stringBuffer.append((char) (i10 + 48));
    }

    private static void p(StringBuffer stringBuffer, int i10) {
        int i11 = i10 / 100;
        if (i11 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char) (i11 + 48));
            i10 -= i11 * 100;
        }
        o(stringBuffer, i10);
    }

    private static void q(StringBuffer stringBuffer, int i10) {
        int i11 = i10 / 100;
        if (i11 == 0) {
            stringBuffer.append('0');
            stringBuffer.append('0');
        } else {
            if (i11 > 99) {
                stringBuffer.append(i11);
            } else {
                o(stringBuffer, i11);
            }
            i10 -= i11 * 100;
        }
        o(stringBuffer, i10);
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.f5714e = null;
    }

    /* access modifiers changed from: protected */
    public void d(TimeZone timeZone, Locale locale, Date date, StringBuffer stringBuffer) {
        Calendar f10 = f(timeZone);
        f10.setTime(date);
        int i10 = f10.get(1);
        char c10 = '+';
        if (f10.get(0) == 0) {
            e(stringBuffer, i10);
        } else {
            if (i10 > 9999) {
                stringBuffer.append('+');
            }
            q(stringBuffer, i10);
        }
        stringBuffer.append('-');
        o(stringBuffer, f10.get(2) + 1);
        stringBuffer.append('-');
        o(stringBuffer, f10.get(5));
        stringBuffer.append('T');
        o(stringBuffer, f10.get(11));
        stringBuffer.append(':');
        o(stringBuffer, f10.get(12));
        stringBuffer.append(':');
        o(stringBuffer, f10.get(13));
        stringBuffer.append(JwtParser.SEPARATOR_CHAR);
        p(stringBuffer, f10.get(14));
        int offset = timeZone.getOffset(f10.getTimeInMillis());
        if (offset != 0) {
            int i11 = offset / 60000;
            int abs = Math.abs(i11 / 60);
            int abs2 = Math.abs(i11 % 60);
            if (offset < 0) {
                c10 = '-';
            }
            stringBuffer.append(c10);
            o(stringBuffer, abs);
            if (this.f5715f) {
                stringBuffer.append(':');
            }
            o(stringBuffer, abs2);
        } else if (this.f5715f) {
            stringBuffer.append("+00:00");
        } else {
            stringBuffer.append("+0000");
        }
    }

    /* access modifiers changed from: protected */
    public void e(StringBuffer stringBuffer, int i10) {
        if (i10 == 1) {
            stringBuffer.append("+0000");
            return;
        }
        stringBuffer.append('-');
        q(stringBuffer, i10 - 1);
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    /* access modifiers changed from: protected */
    public Calendar f(TimeZone timeZone) {
        Calendar calendar = this.f5713d;
        if (calendar == null) {
            calendar = (Calendar) Y.clone();
            this.f5713d = calendar;
        }
        if (!calendar.getTimeZone().equals(timeZone)) {
            calendar.setTimeZone(timeZone);
        }
        calendar.setLenient(isLenient());
        return calendar;
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        TimeZone timeZone = this.f5710a;
        if (timeZone == null) {
            timeZone = f5708j;
        }
        d(timeZone, this.f5711b, date, stringBuffer);
        return stringBuffer;
    }

    public TimeZone getTimeZone() {
        return this.f5710a;
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    public boolean isLenient() {
        Boolean bool = this.f5712c;
        if (bool == null || bool.booleanValue()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public Date j(String str, ParsePosition parsePosition) {
        String str2;
        int i10;
        int i11;
        int i12;
        String str3 = str;
        int i13 = 0;
        int length = str.length();
        TimeZone timeZone = f5708j;
        if (!(this.f5710a == null || 'Z' == str3.charAt(length - 1))) {
            timeZone = this.f5710a;
        }
        Calendar f10 = f(timeZone);
        f10.clear();
        if (length > 10) {
            Matcher matcher = f5706h.matcher(str3);
            if (matcher.matches()) {
                int start = matcher.start(2);
                int end = matcher.end(2);
                int i14 = end - start;
                if (i14 > 1) {
                    int h10 = h(str3, start + 1) * 3600;
                    if (i14 >= 5) {
                        h10 += h(str3, end - 2) * 60;
                    }
                    if (str3.charAt(start) == '-') {
                        i12 = h10 * NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    } else {
                        i12 = h10 * 1000;
                    }
                    f10.set(15, i12);
                    f10.set(16, 0);
                }
                int i15 = i(str3, 0);
                int h11 = h(str3, 5) - 1;
                int h12 = h(str3, 8);
                int h13 = h(str3, 11);
                int h14 = h(str3, 14);
                if (length <= 16 || str3.charAt(16) != ':') {
                    i10 = 0;
                } else {
                    i10 = h(str3, 17);
                }
                int i16 = i15;
                Matcher matcher2 = matcher;
                f10.set(i16, h11, h12, h13, h14, i10);
                int start2 = matcher2.start(1);
                int i17 = start2 + 1;
                int end2 = matcher2.end(1);
                if (i17 >= end2) {
                    f10.set(14, 0);
                } else {
                    int i18 = end2 - i17;
                    if (i18 != 0) {
                        if (i18 != 1) {
                            if (i18 != 2) {
                                if (i18 == 3) {
                                    i11 = 3;
                                } else if (i18 <= 9) {
                                    i11 = 3;
                                } else {
                                    throw new ParseException(String.format("Cannot parse date \"%s\": invalid fractional seconds '%s'; can use at most 9 digits", new Object[]{str3, matcher2.group(1).substring(1)}), i17);
                                }
                                i13 = str3.charAt(i11 + start2) - '0';
                            }
                            i13 += (str3.charAt(start2 + 2) - '0') * 10;
                        }
                        i13 += (str3.charAt(i17) - '0') * 100;
                    }
                    f10.set(14, i13);
                }
                return f10.getTime();
            }
            str2 = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
        } else if (f5705g.matcher(str3).matches()) {
            f10.set(i(str3, 0), h(str3, 5) - 1, h(str3, 8), 0, 0, 0);
            f10.set(14, 0);
            return f10.getTime();
        } else {
            str2 = TimeUtils.YYYY_MM_DD;
        }
        throw new ParseException(String.format("Cannot parse date \"%s\": while it seems to fit format '%s', parsing fails (leniency? %s)", new Object[]{str3, str2, this.f5712c}), 0);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Date k(java.lang.String r5, java.text.ParsePosition r6) {
        /*
            r4 = this;
            boolean r0 = r4.n(r5)
            if (r0 == 0) goto L_0x000b
            java.util.Date r5 = r4.s(r5, r6)
            return r5
        L_0x000b:
            int r0 = r5.length()
        L_0x000f:
            int r0 = r0 + -1
            r1 = 45
            if (r0 < 0) goto L_0x0025
            char r2 = r5.charAt(r0)
            r3 = 48
            if (r2 < r3) goto L_0x0021
            r3 = 57
            if (r2 <= r3) goto L_0x000f
        L_0x0021:
            if (r0 > 0) goto L_0x0025
            if (r2 == r1) goto L_0x000f
        L_0x0025:
            if (r0 >= 0) goto L_0x0039
            r0 = 0
            char r2 = r5.charAt(r0)
            if (r2 == r1) goto L_0x0034
            boolean r0 = com.fasterxml.jackson.core.io.e.a(r5, r0)
            if (r0 == 0) goto L_0x0039
        L_0x0034:
            java.util.Date r5 = r4.l(r5, r6)
            return r5
        L_0x0039:
            java.util.Date r5 = r4.t(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.util.o.k(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    /* renamed from: m */
    public o clone() {
        return new o(this.f5710a, this.f5711b, this.f5712c, this.f5715f);
    }

    /* access modifiers changed from: protected */
    public boolean n(String str) {
        if (str.length() < 7 || !Character.isDigit(str.charAt(0)) || !Character.isDigit(str.charAt(3)) || str.charAt(4) != '-' || !Character.isDigit(str.charAt(5))) {
            return false;
        }
        return true;
    }

    public Date parse(String str) {
        String trim = str.trim();
        ParsePosition parsePosition = new ParsePosition(0);
        Date k10 = k(trim, parsePosition);
        if (k10 != null) {
            return k10;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : f5707i) {
            if (sb2.length() > 0) {
                sb2.append("\", \"");
            } else {
                sb2.append('\"');
            }
            sb2.append(str2);
        }
        sb2.append('\"');
        throw new ParseException(String.format("Cannot parse date \"%s\": not compatible with any of standard forms (%s)", new Object[]{trim, sb2.toString()}), parsePosition.getErrorIndex());
    }

    /* access modifiers changed from: protected */
    public Date s(String str, ParsePosition parsePosition) {
        try {
            return j(str, parsePosition);
        } catch (IllegalArgumentException e10) {
            throw new ParseException(String.format("Cannot parse date \"%s\", problem: %s", new Object[]{str, e10.getMessage()}), parsePosition.getErrorIndex());
        }
    }

    public void setLenient(boolean z10) {
        Boolean valueOf = Boolean.valueOf(z10);
        if (!c(valueOf, this.f5712c)) {
            this.f5712c = valueOf;
            a();
        }
    }

    public void setTimeZone(TimeZone timeZone) {
        if (!timeZone.equals(this.f5710a)) {
            a();
            this.f5710a = timeZone;
        }
    }

    /* access modifiers changed from: protected */
    public Date t(String str, ParsePosition parsePosition) {
        if (this.f5714e == null) {
            this.f5714e = b(C, "EEE, dd MMM yyyy HH:mm:ss zzz", this.f5710a, this.f5711b, this.f5712c);
        }
        return this.f5714e.parse(str, parsePosition);
    }

    public String toString() {
        return String.format("DateFormat %s: (timezone: %s, locale: %s, lenient: %s)", new Object[]{getClass().getName(), this.f5710a, this.f5711b, this.f5712c});
    }

    public o u(Locale locale) {
        if (locale.equals(this.f5711b)) {
            return this;
        }
        return new o(this.f5710a, locale, this.f5712c, this.f5715f);
    }

    public o v(TimeZone timeZone) {
        if (timeZone == null) {
            timeZone = f5708j;
        }
        TimeZone timeZone2 = this.f5710a;
        if (timeZone == timeZone2 || timeZone.equals(timeZone2)) {
            return this;
        }
        return new o(timeZone, this.f5711b, this.f5712c, this.f5715f);
    }

    protected o(TimeZone timeZone, Locale locale, Boolean bool, boolean z10) {
        this.f5710a = timeZone;
        this.f5711b = locale;
        this.f5712c = bool;
        this.f5715f = z10;
    }

    public Date parse(String str, ParsePosition parsePosition) {
        try {
            return k(str, parsePosition);
        } catch (ParseException unused) {
            return null;
        }
    }
}
