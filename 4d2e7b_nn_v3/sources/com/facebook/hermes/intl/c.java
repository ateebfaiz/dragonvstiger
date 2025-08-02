package com.facebook.hermes.intl;

import android.icu.text.MeasureFormat;
import com.adjust.sdk.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.zing.zalo.zalosdk.common.Constant;
import java.text.AttributedCharacterIterator;
import o4.k;

public interface c {

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19848a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f19849b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f19850c;

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ int[] f19851d;

        /* renamed from: e  reason: collision with root package name */
        static final /* synthetic */ int[] f19852e;

        /* renamed from: f  reason: collision with root package name */
        static final /* synthetic */ int[] f19853f;

        /* renamed from: g  reason: collision with root package name */
        static final /* synthetic */ int[] f19854g;

        /* JADX WARNING: Can't wrap try/catch for region: R(48:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|(2:15|16)|17|(2:19|20)|21|23|24|25|26|27|28|29|31|32|33|34|35|36|(2:37|38)|39|41|42|(2:43|44)|45|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|(3:63|64|66)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(49:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|(2:19|20)|21|23|24|25|26|27|28|29|31|32|33|34|35|36|(2:37|38)|39|41|42|(2:43|44)|45|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|(3:63|64|66)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(54:0|(2:1|2)|3|5|6|7|9|10|(2:11|12)|13|15|16|17|(2:19|20)|21|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|63|64|66) */
        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|1|2|3|5|6|7|9|10|11|12|13|15|16|17|(2:19|20)|21|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|63|64|66) */
        /* JADX WARNING: Can't wrap try/catch for region: R(57:0|1|2|3|5|6|7|9|10|11|12|13|15|16|17|19|20|21|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|63|64|66) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x008e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0098 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00b3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00e2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00fd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x0107 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0111 */
        static {
            /*
                com.facebook.hermes.intl.c$d[] r0 = com.facebook.hermes.intl.c.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19854g = r0
                r1 = 1
                com.facebook.hermes.intl.c$d r2 = com.facebook.hermes.intl.c.d.ACCOUNTING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f19854g     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.hermes.intl.c$d r3 = com.facebook.hermes.intl.c.d.STANDARD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.facebook.hermes.intl.c$c[] r2 = com.facebook.hermes.intl.c.C0250c.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f19853f = r2
                com.facebook.hermes.intl.c$c r3 = com.facebook.hermes.intl.c.C0250c.SYMBOL     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f19853f     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.facebook.hermes.intl.c$c r3 = com.facebook.hermes.intl.c.C0250c.NARROWSYMBOL     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                r2 = 3
                int[] r3 = f19853f     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.facebook.hermes.intl.c$c r4 = com.facebook.hermes.intl.c.C0250c.CODE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                r3 = 4
                int[] r4 = f19853f     // Catch:{ NoSuchFieldError -> 0x004e }
                com.facebook.hermes.intl.c$c r5 = com.facebook.hermes.intl.c.C0250c.NAME     // Catch:{ NoSuchFieldError -> 0x004e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                com.facebook.hermes.intl.c$i[] r4 = com.facebook.hermes.intl.c.i.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f19852e = r4
                com.facebook.hermes.intl.c$i r5 = com.facebook.hermes.intl.c.i.SHORT     // Catch:{ NoSuchFieldError -> 0x005f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                int[] r4 = f19852e     // Catch:{ NoSuchFieldError -> 0x0069 }
                com.facebook.hermes.intl.c$i r5 = com.facebook.hermes.intl.c.i.NARROW     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                int[] r4 = f19852e     // Catch:{ NoSuchFieldError -> 0x0073 }
                com.facebook.hermes.intl.c$i r5 = com.facebook.hermes.intl.c.i.LONG     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                com.facebook.hermes.intl.c$g[] r4 = com.facebook.hermes.intl.c.g.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f19851d = r4
                com.facebook.hermes.intl.c$g r5 = com.facebook.hermes.intl.c.g.AUTO     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r4 = f19851d     // Catch:{ NoSuchFieldError -> 0x008e }
                com.facebook.hermes.intl.c$g r5 = com.facebook.hermes.intl.c.g.ALWAYS     // Catch:{ NoSuchFieldError -> 0x008e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x008e }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x008e }
            L_0x008e:
                int[] r4 = f19851d     // Catch:{ NoSuchFieldError -> 0x0098 }
                com.facebook.hermes.intl.c$g r5 = com.facebook.hermes.intl.c.g.NEVER     // Catch:{ NoSuchFieldError -> 0x0098 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0098 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0098 }
            L_0x0098:
                int[] r4 = f19851d     // Catch:{ NoSuchFieldError -> 0x00a2 }
                com.facebook.hermes.intl.c$g r5 = com.facebook.hermes.intl.c.g.EXCEPTZERO     // Catch:{ NoSuchFieldError -> 0x00a2 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a2 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x00a2 }
            L_0x00a2:
                com.facebook.hermes.intl.c$b[] r4 = com.facebook.hermes.intl.c.b.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f19850c = r4
                com.facebook.hermes.intl.c$b r5 = com.facebook.hermes.intl.c.b.SHORT     // Catch:{ NoSuchFieldError -> 0x00b3 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b3 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00b3 }
            L_0x00b3:
                int[] r4 = f19850c     // Catch:{ NoSuchFieldError -> 0x00bd }
                com.facebook.hermes.intl.c$b r5 = com.facebook.hermes.intl.c.b.LONG     // Catch:{ NoSuchFieldError -> 0x00bd }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bd }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x00bd }
            L_0x00bd:
                com.facebook.hermes.intl.c$e[] r4 = com.facebook.hermes.intl.c.e.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f19849b = r4
                com.facebook.hermes.intl.c$e r5 = com.facebook.hermes.intl.c.e.STANDARD     // Catch:{ NoSuchFieldError -> 0x00ce }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ce }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00ce }
            L_0x00ce:
                int[] r4 = f19849b     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.facebook.hermes.intl.c$e r5 = com.facebook.hermes.intl.c.e.SCIENTIFIC     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r4 = f19849b     // Catch:{ NoSuchFieldError -> 0x00e2 }
                com.facebook.hermes.intl.c$e r5 = com.facebook.hermes.intl.c.e.ENGINEERING     // Catch:{ NoSuchFieldError -> 0x00e2 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e2 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x00e2 }
            L_0x00e2:
                int[] r4 = f19849b     // Catch:{ NoSuchFieldError -> 0x00ec }
                com.facebook.hermes.intl.c$e r5 = com.facebook.hermes.intl.c.e.COMPACT     // Catch:{ NoSuchFieldError -> 0x00ec }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ec }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x00ec }
            L_0x00ec:
                com.facebook.hermes.intl.c$h[] r4 = com.facebook.hermes.intl.c.h.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f19848a = r4
                com.facebook.hermes.intl.c$h r5 = com.facebook.hermes.intl.c.h.DECIMAL     // Catch:{ NoSuchFieldError -> 0x00fd }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fd }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00fd }
            L_0x00fd:
                int[] r1 = f19848a     // Catch:{ NoSuchFieldError -> 0x0107 }
                com.facebook.hermes.intl.c$h r4 = com.facebook.hermes.intl.c.h.PERCENT     // Catch:{ NoSuchFieldError -> 0x0107 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0107 }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0107 }
            L_0x0107:
                int[] r0 = f19848a     // Catch:{ NoSuchFieldError -> 0x0111 }
                com.facebook.hermes.intl.c$h r1 = com.facebook.hermes.intl.c.h.CURRENCY     // Catch:{ NoSuchFieldError -> 0x0111 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0111 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0111 }
            L_0x0111:
                int[] r0 = f19848a     // Catch:{ NoSuchFieldError -> 0x011b }
                com.facebook.hermes.intl.c$h r1 = com.facebook.hermes.intl.c.h.UNIT     // Catch:{ NoSuchFieldError -> 0x011b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x011b }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x011b }
            L_0x011b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.hermes.intl.c.a.<clinit>():void");
        }
    }

    public enum b {
        SHORT,
        LONG;

        public String toString() {
            int i10 = a.f19850c[ordinal()];
            if (i10 == 1) {
                return "short";
            }
            if (i10 == 2) {
                return Constants.LONG;
            }
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: com.facebook.hermes.intl.c$c  reason: collision with other inner class name */
    public enum C0250c {
        SYMBOL,
        NARROWSYMBOL,
        CODE,
        NAME;

        public int b() {
            if (a.f19853f[ordinal()] != 4) {
                return 0;
            }
            return 1;
        }

        public String toString() {
            int i10 = a.f19853f[ordinal()];
            if (i10 == 1) {
                return "symbol";
            }
            if (i10 == 2) {
                return "narrowSymbol";
            }
            if (i10 == 3) {
                return Constant.PARAM_OAUTH_CODE;
            }
            if (i10 == 4) {
                return "name";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum d {
        STANDARD,
        ACCOUNTING;

        public String toString() {
            int i10 = a.f19854g[ordinal()];
            if (i10 == 1) {
                return "accounting";
            }
            if (i10 == 2) {
                return "standard";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum e {
        STANDARD,
        SCIENTIFIC,
        ENGINEERING,
        COMPACT;

        public String toString() {
            int i10 = a.f19849b[ordinal()];
            if (i10 == 1) {
                return "standard";
            }
            if (i10 == 2) {
                return "scientific";
            }
            if (i10 == 3) {
                return "engineering";
            }
            if (i10 == 4) {
                return "compact";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum f {
        SIGNIFICANT_DIGITS,
        FRACTION_DIGITS,
        COMPACT_ROUNDING
    }

    public enum g {
        AUTO,
        ALWAYS,
        NEVER,
        EXCEPTZERO;

        public String toString() {
            int i10 = a.f19851d[ordinal()];
            if (i10 == 1) {
                return "auto";
            }
            if (i10 == 2) {
                return "always";
            }
            if (i10 == 3) {
                return "never";
            }
            if (i10 == 4) {
                return "exceptZero";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum h {
        DECIMAL,
        PERCENT,
        CURRENCY,
        UNIT;

        public int b(e eVar, d dVar) {
            int i10 = a.f19848a[ordinal()];
            if (i10 == 2) {
                return 2;
            }
            if (i10 != 3) {
                if (eVar == e.SCIENTIFIC || eVar == e.ENGINEERING) {
                    return 3;
                }
                return 0;
            } else if (dVar == d.ACCOUNTING) {
                return 7;
            } else {
                if (dVar == d.STANDARD) {
                    return 1;
                }
                throw new k("Unrecognized formatting style requested.");
            }
        }

        public String toString() {
            int i10 = a.f19848a[ordinal()];
            if (i10 == 1) {
                return "decimal";
            }
            if (i10 == 2) {
                return "percent";
            }
            if (i10 == 3) {
                return FirebaseAnalytics.Param.CURRENCY;
            }
            if (i10 == 4) {
                return "unit";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum i {
        SHORT,
        NARROW,
        LONG;

        public MeasureFormat.FormatWidth b() {
            int i10 = a.f19852e[ordinal()];
            if (i10 == 2) {
                return MeasureFormat.FormatWidth.NARROW;
            }
            if (i10 != 3) {
                return MeasureFormat.FormatWidth.SHORT;
            }
            return MeasureFormat.FormatWidth.WIDE;
        }

        public String toString() {
            int i10 = a.f19852e[ordinal()];
            if (i10 == 1) {
                return "short";
            }
            if (i10 == 2) {
                return "narrow";
            }
            if (i10 == 3) {
                return Constants.LONG;
            }
            throw new IllegalArgumentException();
        }
    }

    AttributedCharacterIterator a(double d10);

    String b(double d10);

    String c(o4.b bVar);

    c d(String str, i iVar);

    c e(g gVar);

    c f(String str, C0250c cVar);

    c g(f fVar, int i10, int i11);

    String h(AttributedCharacterIterator.Attribute attribute, double d10);

    c i(int i10);

    c j(o4.b bVar, String str, h hVar, d dVar, e eVar, b bVar2);

    c k(boolean z10);

    c l(f fVar, int i10, int i11);
}
