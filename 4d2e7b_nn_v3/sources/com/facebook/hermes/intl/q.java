package com.facebook.hermes.intl;

import android.icu.text.CompactDecimalFormat;
import android.icu.text.DecimalFormat;
import android.icu.text.DecimalFormatSymbols;
import android.icu.text.MeasureFormat;
import android.icu.text.NumberFormat;
import android.icu.text.NumberingSystem;
import android.icu.util.Currency;
import android.icu.util.MeasureUnit;
import com.facebook.hermes.intl.c;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.text.AttributedCharacterIterator;
import java.text.Format;
import java.util.ArrayList;
import o4.b;
import o4.f;
import o4.j;
import o4.k;
import o4.n3;
import o4.t3;
import o4.u3;
import o4.z;

public class q implements c {

    /* renamed from: a  reason: collision with root package name */
    private Format f19949a;

    /* renamed from: b  reason: collision with root package name */
    private NumberFormat f19950b;

    /* renamed from: c  reason: collision with root package name */
    private z f19951c;

    /* renamed from: d  reason: collision with root package name */
    private c.h f19952d;

    /* renamed from: e  reason: collision with root package name */
    private MeasureUnit f19953e;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19954a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.hermes.intl.c$g[] r0 = com.facebook.hermes.intl.c.g.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19954a = r0
                com.facebook.hermes.intl.c$g r1 = com.facebook.hermes.intl.c.g.NEVER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f19954a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.hermes.intl.c$g r1 = com.facebook.hermes.intl.c.g.ALWAYS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f19954a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.hermes.intl.c$g r1 = com.facebook.hermes.intl.c.g.EXCEPTZERO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.hermes.intl.q.a.<clinit>():void");
        }
    }

    q() {
    }

    public static int n(String str) {
        try {
            return Currency.getInstance(str).getDefaultFractionDigits();
        } catch (IllegalArgumentException unused) {
            throw new k("Invalid currency code !");
        }
    }

    private void o(NumberFormat numberFormat, b bVar, c.h hVar) {
        this.f19950b = numberFormat;
        this.f19949a = numberFormat;
        this.f19951c = (z) bVar;
        this.f19952d = hVar;
        numberFormat.setRoundingMode(4);
    }

    private static MeasureUnit p(String str) {
        for (Object a10 : MeasureUnit.getAvailable()) {
            MeasureUnit a11 = n3.a(a10);
            if (!a11.getSubtype().equals(str)) {
                String a12 = a11.getSubtype();
                if (a12.equals(a11.getType() + "-" + str)) {
                }
            }
            return a11;
        }
        throw new k("Unknown unit: " + str);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.text.AttributedCharacterIterator a(double r5) {
        /*
            r4 = this;
            java.lang.String r0 = "en"
            java.text.Format r1 = r4.f19949a     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            boolean r1 = o4.u1.a(r1)     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            if (r1 == 0) goto L_0x0022
            android.icu.util.MeasureUnit r1 = r4.f19953e     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            if (r1 == 0) goto L_0x0022
            java.text.Format r1 = r4.f19949a     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            o4.k3.a()     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            java.lang.Double r2 = java.lang.Double.valueOf(r5)     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            android.icu.util.MeasureUnit r3 = r4.f19953e     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            android.icu.util.Measure r2 = o4.j3.a(r2, r3)     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            java.text.AttributedCharacterIterator r5 = r1.formatToCharacterIterator(r2)     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            goto L_0x002c
        L_0x0022:
            java.text.Format r1 = r4.f19949a     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            java.lang.Double r2 = java.lang.Double.valueOf(r5)     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
            java.text.AttributedCharacterIterator r5 = r1.formatToCharacterIterator(r2)     // Catch:{ NumberFormatException -> 0x003e, Exception -> 0x002d }
        L_0x002c:
            return r5
        L_0x002d:
            android.icu.util.ULocale r0 = android.icu.util.ULocale.forLanguageTag(r0)
            android.icu.text.NumberFormat r0 = android.icu.text.NumberFormat.getInstance(r0)
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            java.text.AttributedCharacterIterator r5 = r0.formatToCharacterIterator(r5)
            return r5
        L_0x003e:
            android.icu.util.ULocale r1 = android.icu.util.ULocale.getDefault()     // Catch:{ RuntimeException -> 0x004f }
            android.icu.text.NumberFormat r1 = android.icu.text.NumberFormat.getInstance(r1)     // Catch:{ RuntimeException -> 0x004f }
            java.lang.Double r2 = java.lang.Double.valueOf(r5)     // Catch:{ RuntimeException -> 0x004f }
            java.text.AttributedCharacterIterator r5 = r1.formatToCharacterIterator(r2)     // Catch:{ RuntimeException -> 0x004f }
            return r5
        L_0x004f:
            android.icu.util.ULocale r0 = android.icu.util.ULocale.forLanguageTag(r0)
            android.icu.text.NumberFormat r0 = android.icu.text.NumberFormat.getInstance(r0)
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            java.text.AttributedCharacterIterator r5 = r0.formatToCharacterIterator(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.hermes.intl.q.a(double):java.text.AttributedCharacterIterator");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0046, code lost:
        return o4.b2.a(o4.q2.a(o4.m3.a("en")), r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
        return o4.b2.a(o4.q2.a(o4.f2.a()), r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b(double r4) {
        /*
            r3 = this;
            java.text.Format r0 = r3.f19949a     // Catch:{ NumberFormatException -> 0x002b }
            boolean r0 = o4.u1.a(r0)     // Catch:{ NumberFormatException -> 0x002b }
            if (r0 == 0) goto L_0x0020
            android.icu.util.MeasureUnit r0 = r3.f19953e     // Catch:{ NumberFormatException -> 0x002b }
            if (r0 == 0) goto L_0x0020
            java.text.Format r0 = r3.f19949a     // Catch:{ NumberFormatException -> 0x002b }
            o4.k3.a()     // Catch:{ NumberFormatException -> 0x002b }
            java.lang.Double r1 = java.lang.Double.valueOf(r4)     // Catch:{ NumberFormatException -> 0x002b }
            android.icu.util.MeasureUnit r2 = r3.f19953e     // Catch:{ NumberFormatException -> 0x002b }
            android.icu.util.Measure r1 = o4.j3.a(r1, r2)     // Catch:{ NumberFormatException -> 0x002b }
            java.lang.String r4 = r0.format(r1)     // Catch:{ NumberFormatException -> 0x002b }
            goto L_0x002a
        L_0x0020:
            java.text.Format r0 = r3.f19949a     // Catch:{ NumberFormatException -> 0x002b }
            java.lang.Double r1 = java.lang.Double.valueOf(r4)     // Catch:{ NumberFormatException -> 0x002b }
            java.lang.String r4 = r0.format(r1)     // Catch:{ NumberFormatException -> 0x002b }
        L_0x002a:
            return r4
        L_0x002b:
            android.icu.util.ULocale r0 = android.icu.util.ULocale.getDefault()     // Catch:{ RuntimeException -> 0x0038 }
            android.icu.text.NumberFormat r0 = android.icu.text.NumberFormat.getInstance(r0)     // Catch:{ RuntimeException -> 0x0038 }
            java.lang.String r4 = r0.format(r4)     // Catch:{ RuntimeException -> 0x0038 }
            return r4
        L_0x0038:
            java.lang.String r0 = "en"
            android.icu.util.ULocale r0 = android.icu.util.ULocale.forLanguageTag(r0)
            android.icu.text.NumberFormat r0 = android.icu.text.NumberFormat.getInstance(r0)
            java.lang.String r4 = r0.format(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.hermes.intl.q.b(double):java.lang.String");
    }

    public String c(b bVar) {
        return NumberingSystem.getInstance(f.a(bVar.h())).getName();
    }

    public String h(AttributedCharacterIterator.Attribute attribute, double d10) {
        if (attribute == NumberFormat.Field.SIGN) {
            if (Double.compare(d10, 0.0d) >= 0) {
                return "plusSign";
            }
            return "minusSign";
        } else if (attribute == NumberFormat.Field.INTEGER) {
            if (Double.isNaN(d10)) {
                return "nan";
            }
            if (Double.isInfinite(d10)) {
                return "infinity";
            }
            return "integer";
        } else if (attribute == NumberFormat.Field.FRACTION) {
            return "fraction";
        } else {
            if (attribute == NumberFormat.Field.EXPONENT) {
                return "exponentInteger";
            }
            if (attribute == NumberFormat.Field.EXPONENT_SIGN) {
                return "exponentMinusSign";
            }
            if (attribute == NumberFormat.Field.EXPONENT_SYMBOL) {
                return "exponentSeparator";
            }
            if (attribute == NumberFormat.Field.DECIMAL_SEPARATOR) {
                return "decimal";
            }
            if (attribute == NumberFormat.Field.GROUPING_SEPARATOR) {
                return "group";
            }
            if (attribute == NumberFormat.Field.PERCENT) {
                return "percentSign";
            }
            if (attribute == NumberFormat.Field.PERMILLE) {
                return "permilleSign";
            }
            if (attribute == NumberFormat.Field.CURRENCY) {
                return FirebaseAnalytics.Param.CURRENCY;
            }
            if (attribute.toString().equals("android.icu.text.NumberFormat$Field(compact)")) {
                return "compact";
            }
            return "literal";
        }
    }

    /* renamed from: m */
    public q j(b bVar, String str, c.h hVar, c.d dVar, c.e eVar, c.b bVar2) {
        CompactDecimalFormat.CompactStyle compactStyle;
        if (!str.isEmpty()) {
            try {
                if (NumberingSystem.getInstanceByName(j.h(str)) != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(j.h(str));
                    bVar.g("nu", arrayList);
                } else {
                    throw new k("Invalid numbering system: " + str);
                }
            } catch (RuntimeException unused) {
                throw new k("Invalid numbering system: " + str);
            }
        }
        if (eVar == c.e.COMPACT && (hVar == c.h.DECIMAL || hVar == c.h.UNIT)) {
            if (bVar2 == c.b.SHORT) {
                compactStyle = CompactDecimalFormat.CompactStyle.SHORT;
            } else {
                compactStyle = CompactDecimalFormat.CompactStyle.LONG;
            }
            o(CompactDecimalFormat.getInstance(f.a(bVar.h()), compactStyle), bVar, hVar);
        } else {
            NumberFormat a10 = NumberFormat.getInstance(f.a(bVar.h()), hVar.b(eVar, dVar));
            if (eVar == c.e.ENGINEERING) {
                a10.setMaximumIntegerDigits(3);
            }
            o(a10, bVar, hVar);
        }
        return this;
    }

    /* renamed from: q */
    public q f(String str, c.C0250c cVar) {
        if (this.f19952d == c.h.CURRENCY) {
            Currency a10 = Currency.getInstance(str);
            this.f19950b.setCurrency(a10);
            if (cVar != c.C0250c.CODE) {
                str = a10.getName(this.f19951c.h(), cVar.b(), (boolean[]) null);
            }
            if (t3.a(this.f19950b)) {
                DecimalFormat a11 = u3.a(this.f19950b);
                DecimalFormatSymbols a12 = a11.getDecimalFormatSymbols();
                a12.setCurrencySymbol(str);
                a11.setDecimalFormatSymbols(a12);
            }
        }
        return this;
    }

    /* renamed from: r */
    public q l(c.f fVar, int i10, int i11) {
        if (fVar == c.f.FRACTION_DIGITS) {
            if (i10 >= 0) {
                this.f19950b.setMinimumFractionDigits(i10);
            }
            if (i11 >= 0) {
                this.f19950b.setMaximumFractionDigits(i11);
            }
            if (t3.a(this.f19950b)) {
                u3.a(this.f19950b).setSignificantDigitsUsed(false);
            }
        }
        return this;
    }

    /* renamed from: s */
    public q k(boolean z10) {
        this.f19950b.setGroupingUsed(z10);
        return this;
    }

    /* renamed from: t */
    public q i(int i10) {
        if (i10 != -1) {
            this.f19950b.setMinimumIntegerDigits(i10);
        }
        return this;
    }

    /* renamed from: u */
    public q e(c.g gVar) {
        if (t3.a(this.f19950b)) {
            DecimalFormat a10 = u3.a(this.f19950b);
            DecimalFormatSymbols a11 = a10.getDecimalFormatSymbols();
            int i10 = a.f19954a[gVar.ordinal()];
            if (i10 == 1) {
                a10.setPositivePrefix("");
                a10.setPositiveSuffix("");
                a10.setNegativePrefix("");
                a10.setNegativeSuffix("");
            } else if (i10 == 2 || i10 == 3) {
                if (!a10.getNegativePrefix().isEmpty()) {
                    a10.setPositivePrefix(new String(new char[]{a11.getPlusSign()}));
                }
                if (!a10.getNegativeSuffix().isEmpty()) {
                    a10.setPositiveSuffix(new String(new char[]{a11.getPlusSign()}));
                }
            }
        }
        return this;
    }

    /* renamed from: v */
    public q g(c.f fVar, int i10, int i11) {
        if (t3.a(this.f19950b) && fVar == c.f.SIGNIFICANT_DIGITS) {
            DecimalFormat a10 = u3.a(this.f19950b);
            if (i10 >= 0) {
                a10.setMinimumSignificantDigits(i10);
            }
            if (i11 >= 0) {
                if (i11 >= a10.getMinimumSignificantDigits()) {
                    a10.setMaximumSignificantDigits(i11);
                } else {
                    throw new k("maximumSignificantDigits should be at least equal to minimumSignificantDigits");
                }
            }
            a10.setSignificantDigitsUsed(true);
        }
        return this;
    }

    /* renamed from: w */
    public q d(String str, c.i iVar) {
        if (this.f19952d == c.h.UNIT) {
            this.f19953e = p(str);
            this.f19949a = MeasureFormat.getInstance(this.f19951c.h(), iVar.b(), this.f19950b);
        }
        return this;
    }
}
