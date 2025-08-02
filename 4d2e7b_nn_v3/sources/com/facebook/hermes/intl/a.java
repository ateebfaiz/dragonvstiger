package com.facebook.hermes.intl;

import com.google.firebase.analytics.FirebaseAnalytics;

public interface a {

    /* renamed from: com.facebook.hermes.intl.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0248a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19753a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f19754b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f19755c;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|(2:15|16)|17|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0068 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0073 */
        static {
            /*
                com.facebook.hermes.intl.a$b[] r0 = com.facebook.hermes.intl.a.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19755c = r0
                r1 = 1
                com.facebook.hermes.intl.a$b r2 = com.facebook.hermes.intl.a.b.UPPER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f19755c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.hermes.intl.a$b r3 = com.facebook.hermes.intl.a.b.LOWER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f19755c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.hermes.intl.a$b r4 = com.facebook.hermes.intl.a.b.FALSE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.facebook.hermes.intl.a$d[] r3 = com.facebook.hermes.intl.a.d.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f19754b = r3
                com.facebook.hermes.intl.a$d r4 = com.facebook.hermes.intl.a.d.SORT     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r3 = f19754b     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.facebook.hermes.intl.a$d r4 = com.facebook.hermes.intl.a.d.SEARCH     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.facebook.hermes.intl.a$c[] r3 = com.facebook.hermes.intl.a.c.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f19753a = r3
                com.facebook.hermes.intl.a$c r4 = com.facebook.hermes.intl.a.c.BASE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r1 = f19753a     // Catch:{ NoSuchFieldError -> 0x005e }
                com.facebook.hermes.intl.a$c r3 = com.facebook.hermes.intl.a.c.ACCENT     // Catch:{ NoSuchFieldError -> 0x005e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r0 = f19753a     // Catch:{ NoSuchFieldError -> 0x0068 }
                com.facebook.hermes.intl.a$c r1 = com.facebook.hermes.intl.a.c.CASE     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0068 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0068 }
            L_0x0068:
                int[] r0 = f19753a     // Catch:{ NoSuchFieldError -> 0x0073 }
                com.facebook.hermes.intl.a$c r1 = com.facebook.hermes.intl.a.c.VARIANT     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                int[] r0 = f19753a     // Catch:{ NoSuchFieldError -> 0x007e }
                com.facebook.hermes.intl.a$c r1 = com.facebook.hermes.intl.a.c.LOCALE     // Catch:{ NoSuchFieldError -> 0x007e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.hermes.intl.a.C0248a.<clinit>():void");
        }
    }

    public enum b {
        UPPER,
        LOWER,
        FALSE;

        public String toString() {
            int i10 = C0248a.f19755c[ordinal()];
            if (i10 == 1) {
                return "upper";
            }
            if (i10 == 2) {
                return "lower";
            }
            if (i10 == 3) {
                return "false";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum c {
        BASE,
        ACCENT,
        CASE,
        VARIANT,
        LOCALE;

        public String toString() {
            int i10 = C0248a.f19753a[ordinal()];
            if (i10 == 1) {
                return "base";
            }
            if (i10 == 2) {
                return "accent";
            }
            if (i10 == 3) {
                return "case";
            }
            if (i10 == 4) {
                return "variant";
            }
            if (i10 == 5) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum d {
        SORT,
        SEARCH;

        public String toString() {
            int i10 = C0248a.f19754b[ordinal()];
            if (i10 == 1) {
                return "sort";
            }
            if (i10 == 2) {
                return FirebaseAnalytics.Event.SEARCH;
            }
            throw new IllegalArgumentException();
        }
    }

    int a(String str, String str2);

    a b(o4.b bVar);

    c c();

    a d(b bVar);

    a e(boolean z10);

    a f(c cVar);

    a g(boolean z10);
}
