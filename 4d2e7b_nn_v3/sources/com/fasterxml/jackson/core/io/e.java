package com.fasterxml.jackson.core.io;

import androidx.core.location.LocationRequestCompat;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    static final String f5152a = String.valueOf(Long.MIN_VALUE).substring(1);

    /* renamed from: b  reason: collision with root package name */
    static final String f5153b = String.valueOf(LocationRequestCompat.PASSIVE_INTERVAL);

    public static boolean a(String str, boolean z10) {
        String str2;
        if (z10) {
            str2 = f5152a;
        } else {
            str2 = f5153b;
        }
        int length = str2.length();
        int length2 = str.length();
        if (length2 < length) {
            return true;
        }
        if (length2 > length) {
            return false;
        }
        int i10 = 0;
        while (i10 < length) {
            int charAt = str.charAt(i10) - str2.charAt(i10);
            if (charAt == 0) {
                i10++;
            } else if (charAt < 0) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0072, code lost:
        return java.lang.Integer.parseInt(r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b(java.lang.String r10) {
        /*
            r0 = 0
            char r1 = r10.charAt(r0)
            int r2 = r10.length()
            r3 = 45
            r4 = 1
            if (r1 != r3) goto L_0x000f
            r0 = r4
        L_0x000f:
            r3 = 2
            r5 = 10
            if (r0 == 0) goto L_0x0024
            if (r2 == r4) goto L_0x001f
            if (r2 <= r5) goto L_0x0019
            goto L_0x001f
        L_0x0019:
            char r1 = r10.charAt(r4)
            r4 = r3
            goto L_0x002d
        L_0x001f:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L_0x0024:
            r6 = 9
            if (r2 <= r6) goto L_0x002d
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L_0x002d:
            r6 = 57
            if (r1 > r6) goto L_0x0081
            r7 = 48
            if (r1 >= r7) goto L_0x0036
            goto L_0x0081
        L_0x0036:
            int r1 = r1 - r7
            if (r4 >= r2) goto L_0x007d
            int r8 = r4 + 1
            char r9 = r10.charAt(r4)
            if (r9 > r6) goto L_0x0078
            if (r9 >= r7) goto L_0x0044
            goto L_0x0078
        L_0x0044:
            int r1 = r1 * 10
            int r9 = r9 - r7
            int r1 = r1 + r9
            if (r8 >= r2) goto L_0x007d
            int r4 = r4 + r3
            char r3 = r10.charAt(r8)
            if (r3 > r6) goto L_0x0073
            if (r3 >= r7) goto L_0x0054
            goto L_0x0073
        L_0x0054:
            int r1 = r1 * 10
            int r3 = r3 - r7
            int r1 = r1 + r3
            if (r4 >= r2) goto L_0x007d
        L_0x005a:
            int r3 = r4 + 1
            char r4 = r10.charAt(r4)
            if (r4 > r6) goto L_0x006e
            if (r4 >= r7) goto L_0x0065
            goto L_0x006e
        L_0x0065:
            int r1 = r1 * r5
            int r4 = r4 + -48
            int r1 = r1 + r4
            if (r3 < r2) goto L_0x006c
            goto L_0x007d
        L_0x006c:
            r4 = r3
            goto L_0x005a
        L_0x006e:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L_0x0073:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L_0x0078:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        L_0x007d:
            if (r0 == 0) goto L_0x0080
            int r1 = -r1
        L_0x0080:
            return r1
        L_0x0081:
            int r10 = java.lang.Integer.parseInt(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.e.b(java.lang.String):int");
    }

    public static long c(String str) {
        if (str.length() <= 9) {
            return (long) b(str);
        }
        return Long.parseLong(str);
    }
}
