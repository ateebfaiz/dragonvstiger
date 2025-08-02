package com.google.gson.internal.bind.util;

import io.jsonwebtoken.JwtParser;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    private static final String UTC_ID = "UTC";

    private static boolean checkOffset(String str, int i10, char c10) {
        if (i10 >= str.length() || str.charAt(i10) != c10) {
            return false;
        }
        return true;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    private static int indexOfNonDigit(String str, int i10) {
        while (i10 < str.length()) {
            char charAt = str.charAt(i10);
            if (charAt < '0' || charAt > '9') {
                return i10;
            }
            i10++;
        }
        return str.length();
    }

    private static void padInt(StringBuilder sb2, int i10, int i11) {
        String num = Integer.toString(i10);
        for (int length = i11 - num.length(); length > 0; length--) {
            sb2.append('0');
        }
        sb2.append(num);
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date parse(java.lang.String r19, java.text.ParsePosition r20) throws java.text.ParseException {
        /*
            r1 = r19
            r2 = r20
            int r0 = r20.getIndex()     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            int r3 = r0 + 4
            int r4 = parseInt(r1, r0, r3)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r5 = 45
            boolean r6 = checkOffset(r1, r3, r5)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r7 = 5
            if (r6 == 0) goto L_0x0019
            int r3 = r0 + 5
        L_0x0019:
            int r0 = r3 + 2
            int r6 = parseInt(r1, r3, r0)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            boolean r8 = checkOffset(r1, r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r8 == 0) goto L_0x0027
            int r0 = r3 + 3
        L_0x0027:
            int r3 = r0 + 2
            int r8 = parseInt(r1, r0, r3)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r9 = 84
            boolean r9 = checkOffset(r1, r3, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r10 = 1
            r11 = 0
            if (r9 != 0) goto L_0x0057
            int r12 = r19.length()     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r12 > r3) goto L_0x0057
            java.util.GregorianCalendar r0 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            int r6 = r6 - r10
            r0.<init>(r4, r6, r8)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r0.setLenient(r11)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r2.setIndex(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.util.Date r0 = r0.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            return r0
        L_0x004e:
            r0 = move-exception
            goto L_0x01d1
        L_0x0051:
            r0 = move-exception
            goto L_0x01d1
        L_0x0054:
            r0 = move-exception
            goto L_0x01d1
        L_0x0057:
            r12 = 43
            r13 = 90
            r14 = 2
            if (r9 == 0) goto L_0x00db
            int r3 = r0 + 3
            int r9 = r0 + 5
            int r3 = parseInt(r1, r3, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r15 = 58
            boolean r16 = checkOffset(r1, r9, r15)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r16 == 0) goto L_0x0070
            int r9 = r0 + 6
        L_0x0070:
            int r0 = r9 + 2
            int r16 = parseInt(r1, r9, r0)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            boolean r15 = checkOffset(r1, r0, r15)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r15 == 0) goto L_0x007f
            int r9 = r9 + 3
            r0 = r9
        L_0x007f:
            int r9 = r19.length()     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r9 <= r0) goto L_0x00d1
            char r9 = r1.charAt(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r9 == r13) goto L_0x00d1
            if (r9 == r12) goto L_0x00d1
            if (r9 == r5) goto L_0x00d1
            int r9 = r0 + 2
            int r15 = parseInt(r1, r0, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r11 = 59
            if (r15 <= r11) goto L_0x009f
            r11 = 63
            if (r15 >= r11) goto L_0x009f
            r15 = 59
        L_0x009f:
            r11 = 46
            boolean r11 = checkOffset(r1, r9, r11)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r11 == 0) goto L_0x00cb
            int r9 = r0 + 3
            int r11 = r0 + 4
            int r11 = indexOfNonDigit(r1, r11)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            int r0 = r0 + 6
            int r0 = java.lang.Math.min(r11, r0)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            int r17 = parseInt(r1, r9, r0)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            int r0 = r0 - r9
            if (r0 == r10) goto L_0x00c2
            if (r0 == r14) goto L_0x00bf
            goto L_0x00c4
        L_0x00bf:
            int r17 = r17 * 10
            goto L_0x00c4
        L_0x00c2:
            int r17 = r17 * 100
        L_0x00c4:
            r0 = r3
            r3 = r11
            r9 = r16
            r11 = r17
            goto L_0x00df
        L_0x00cb:
            r0 = r3
            r3 = r9
            r9 = r16
            r11 = 0
            goto L_0x00df
        L_0x00d1:
            r9 = r16
            r11 = 0
            r15 = 0
            r18 = r3
            r3 = r0
            r0 = r18
            goto L_0x00df
        L_0x00db:
            r0 = 0
            r9 = 0
            r11 = 0
            r15 = 0
        L_0x00df:
            int r14 = r19.length()     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r14 <= r3) goto L_0x01c9
            char r14 = r1.charAt(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r14 != r13) goto L_0x00f0
            java.util.TimeZone r5 = TIMEZONE_UTC     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            int r3 = r3 + r10
            goto L_0x0198
        L_0x00f0:
            if (r14 == r12) goto L_0x0111
            if (r14 != r5) goto L_0x00f5
            goto L_0x0111
        L_0x00f5:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r3.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r4 = "Invalid time zone indicator '"
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r3.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r4 = "'"
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
        L_0x0111:
            java.lang.String r5 = r1.substring(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            int r12 = r5.length()     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r12 < r7) goto L_0x011c
            goto L_0x012d
        L_0x011c:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r12.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r12.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r5 = "00"
            r12.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r5 = r12.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
        L_0x012d:
            int r12 = r5.length()     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            int r3 = r3 + r12
            java.lang.String r12 = "+0000"
            boolean r12 = r12.equals(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r12 != 0) goto L_0x0196
            java.lang.String r12 = "+00:00"
            boolean r12 = r12.equals(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r12 == 0) goto L_0x0143
            goto L_0x0196
        L_0x0143:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r12.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r13 = "GMT"
            r12.append(r13)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r12.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r5 = r12.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.util.TimeZone r12 = java.util.TimeZone.getTimeZone(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r13 = r12.getID()     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            boolean r14 = r13.equals(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r14 != 0) goto L_0x0194
            java.lang.String r14 = ":"
            java.lang.String r7 = ""
            java.lang.String r7 = r13.replace(r14, r7)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            boolean r7 = r7.equals(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            if (r7 == 0) goto L_0x0171
            goto L_0x0194
        L_0x0171:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r3.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r4 = "Mismatching time zone indicator: "
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r3.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r4 = " given, resolves to "
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r4 = r12.getID()     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
        L_0x0194:
            r5 = r12
            goto L_0x0198
        L_0x0196:
            java.util.TimeZone r5 = TIMEZONE_UTC     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
        L_0x0198:
            java.util.GregorianCalendar r7 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r7.<init>(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r5 = 0
            r7.setLenient(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r7.set(r10, r4)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            int r6 = r6 - r10
            r4 = 2
            r7.set(r4, r6)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r4 = 5
            r7.set(r4, r8)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r4 = 11
            r7.set(r4, r0)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r0 = 12
            r7.set(r0, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r0 = 13
            r7.set(r0, r15)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r0 = 14
            r7.set(r0, r11)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            r2.setIndex(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.util.Date r0 = r7.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            return r0
        L_0x01c9:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            java.lang.String r3 = "No time zone indicator"
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e }
        L_0x01d1:
            if (r1 != 0) goto L_0x01d5
            r1 = 0
            goto L_0x01e9
        L_0x01d5:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 34
            r3.append(r4)
            r3.append(r1)
            r3.append(r4)
            java.lang.String r1 = r3.toString()
        L_0x01e9:
            java.lang.String r3 = r0.getMessage()
            if (r3 == 0) goto L_0x01f5
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0213
        L_0x01f5:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "("
            r3.append(r4)
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            java.lang.String r4 = ")"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x0213:
            java.text.ParseException r4 = new java.text.ParseException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to parse date ["
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = "]: "
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = r5.toString()
            int r2 = r20.getIndex()
            r4.<init>(r1, r2)
            r4.initCause(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int parseInt(String str, int i10, int i11) throws NumberFormatException {
        int i12;
        int i13;
        if (i10 < 0 || i11 > str.length() || i10 > i11) {
            throw new NumberFormatException(str);
        }
        if (i10 < i11) {
            i13 = i10 + 1;
            int digit = Character.digit(str.charAt(i10), 10);
            if (digit >= 0) {
                i12 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i10, i11));
            }
        } else {
            i12 = 0;
            i13 = i10;
        }
        while (i13 < i11) {
            int i14 = i13 + 1;
            int digit2 = Character.digit(str.charAt(i13), 10);
            if (digit2 >= 0) {
                i12 = (i12 * 10) - digit2;
                i13 = i14;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i10, i11));
            }
        }
        return -i12;
    }

    public static String format(Date date, boolean z10) {
        return format(date, z10, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z10, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb2 = new StringBuilder(19 + (z10 ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb2, gregorianCalendar.get(1), 4);
        char c10 = '-';
        sb2.append('-');
        padInt(sb2, gregorianCalendar.get(2) + 1, 2);
        sb2.append('-');
        padInt(sb2, gregorianCalendar.get(5), 2);
        sb2.append('T');
        padInt(sb2, gregorianCalendar.get(11), 2);
        sb2.append(':');
        padInt(sb2, gregorianCalendar.get(12), 2);
        sb2.append(':');
        padInt(sb2, gregorianCalendar.get(13), 2);
        if (z10) {
            sb2.append(JwtParser.SEPARATOR_CHAR);
            padInt(sb2, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i10 = offset / 60000;
            int abs = Math.abs(i10 / 60);
            int abs2 = Math.abs(i10 % 60);
            if (offset >= 0) {
                c10 = '+';
            }
            sb2.append(c10);
            padInt(sb2, abs, 2);
            sb2.append(':');
            padInt(sb2, abs2, 2);
        } else {
            sb2.append('Z');
        }
        return sb2.toString();
    }
}
