package com.facebook.react.views.text;

import java.text.BreakIterator;

public enum s {
    NONE,
    UPPERCASE,
    LOWERCASE,
    CAPITALIZE,
    UNSET;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4277a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.react.views.text.s[] r0 = com.facebook.react.views.text.s.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4277a = r0
                com.facebook.react.views.text.s r1 = com.facebook.react.views.text.s.UPPERCASE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4277a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.views.text.s r1 = com.facebook.react.views.text.s.LOWERCASE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4277a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.views.text.s r1 = com.facebook.react.views.text.s.CAPITALIZE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.s.a.<clinit>():void");
        }
    }

    public static String b(String str, s sVar) {
        if (str == null) {
            return null;
        }
        int i10 = a.f4277a[sVar.ordinal()];
        if (i10 == 1) {
            return str.toUpperCase();
        }
        if (i10 == 2) {
            return str.toLowerCase();
        }
        if (i10 != 3) {
            return str;
        }
        return c(str);
    }

    private static String c(String str) {
        BreakIterator wordInstance = BreakIterator.getWordInstance();
        wordInstance.setText(str);
        StringBuilder sb2 = new StringBuilder(str.length());
        int first = wordInstance.first();
        while (true) {
            int i10 = first;
            first = wordInstance.next();
            if (first == -1) {
                return sb2.toString();
            }
            String substring = str.substring(i10, first);
            if (Character.isLetterOrDigit(substring.charAt(0))) {
                sb2.append(Character.toUpperCase(substring.charAt(0)));
                sb2.append(substring.substring(1).toLowerCase());
            } else {
                sb2.append(substring);
            }
        }
    }
}
