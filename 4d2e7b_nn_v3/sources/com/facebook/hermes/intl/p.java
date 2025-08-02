package com.facebook.hermes.intl;

import com.facebook.hermes.intl.c;
import java.math.RoundingMode;
import java.text.AttributedCharacterIterator;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import o4.b;
import o4.k;

public class p implements c {

    /* renamed from: a  reason: collision with root package name */
    private Format f19944a;

    /* renamed from: b  reason: collision with root package name */
    private DecimalFormat f19945b;

    /* renamed from: c  reason: collision with root package name */
    private h f19946c;

    /* renamed from: d  reason: collision with root package name */
    private c.h f19947d;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19948a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.facebook.hermes.intl.c$c[] r0 = com.facebook.hermes.intl.c.C0250c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19948a = r0
                com.facebook.hermes.intl.c$c r1 = com.facebook.hermes.intl.c.C0250c.NAME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f19948a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.hermes.intl.c$c r1 = com.facebook.hermes.intl.c.C0250c.CODE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f19948a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.hermes.intl.c$c r1 = com.facebook.hermes.intl.c.C0250c.SYMBOL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f19948a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.hermes.intl.c$c r1 = com.facebook.hermes.intl.c.C0250c.NARROWSYMBOL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.hermes.intl.p.a.<clinit>():void");
        }
    }

    p() {
    }

    public static int n(String str) {
        try {
            return Currency.getInstance(str).getDefaultFractionDigits();
        } catch (IllegalArgumentException unused) {
            throw new k("Invalid currency code !");
        }
    }

    private void o(DecimalFormat decimalFormat, b bVar, c.h hVar) {
        this.f19945b = decimalFormat;
        this.f19944a = decimalFormat;
        this.f19946c = (h) bVar;
        this.f19947d = hVar;
    }

    public AttributedCharacterIterator a(double d10) {
        return this.f19944a.formatToCharacterIterator(Double.valueOf(d10));
    }

    public String b(double d10) {
        return this.f19944a.format(Double.valueOf(d10));
    }

    public String c(b bVar) {
        return "latn";
    }

    public String h(AttributedCharacterIterator.Attribute attribute, double d10) {
        return "literal";
    }

    /* renamed from: m */
    public p j(b bVar, String str, c.h hVar, c.d dVar, c.e eVar, c.b bVar2) {
        NumberFormat instance = NumberFormat.getInstance((Locale) bVar.h());
        instance.setRoundingMode(RoundingMode.HALF_UP);
        o((DecimalFormat) instance, bVar, hVar);
        return this;
    }

    /* renamed from: p */
    public p f(String str, c.C0250c cVar) {
        if (this.f19947d == c.h.CURRENCY) {
            Currency instance = Currency.getInstance(str);
            this.f19945b.setCurrency(instance);
            int i10 = a.f19948a[cVar.ordinal()];
            if (i10 == 1) {
                str = instance.getDisplayName(this.f19946c.h());
            } else if (i10 != 2) {
                str = instance.getSymbol(this.f19946c.h());
            }
            DecimalFormatSymbols decimalFormatSymbols = this.f19945b.getDecimalFormatSymbols();
            decimalFormatSymbols.setCurrencySymbol(str);
            this.f19945b.setDecimalFormatSymbols(decimalFormatSymbols);
            this.f19945b.getDecimalFormatSymbols().setCurrencySymbol(str);
        }
        return this;
    }

    /* renamed from: q */
    public p l(c.f fVar, int i10, int i11) {
        if (fVar == c.f.FRACTION_DIGITS) {
            if (i10 >= 0) {
                this.f19945b.setMinimumFractionDigits(i10);
            }
            if (i11 >= 0) {
                this.f19945b.setMaximumFractionDigits(i11);
            }
        }
        return this;
    }

    /* renamed from: r */
    public p k(boolean z10) {
        this.f19945b.setGroupingUsed(z10);
        return this;
    }

    /* renamed from: s */
    public p i(int i10) {
        if (i10 != -1) {
            this.f19945b.setMinimumIntegerDigits(i10);
        }
        return this;
    }

    /* renamed from: t */
    public p e(c.g gVar) {
        if (gVar == c.g.NEVER) {
            this.f19945b.setPositivePrefix("");
            this.f19945b.setPositiveSuffix("");
            this.f19945b.setNegativePrefix("");
            this.f19945b.setNegativeSuffix("");
        }
        return this;
    }

    /* renamed from: u */
    public p g(c.f fVar, int i10, int i11) {
        return this;
    }

    /* renamed from: v */
    public p d(String str, c.i iVar) {
        return this;
    }
}
