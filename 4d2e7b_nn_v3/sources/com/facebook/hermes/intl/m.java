package com.facebook.hermes.intl;

import android.icu.text.RuleBasedCollator;
import com.facebook.hermes.intl.a;
import o4.b;
import o4.b0;
import o4.j;
import o4.z;

public class m implements a {

    /* renamed from: a  reason: collision with root package name */
    private RuleBasedCollator f19937a = null;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19938a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f19939b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        static {
            /*
                com.facebook.hermes.intl.a$b[] r0 = com.facebook.hermes.intl.a.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19939b = r0
                r1 = 1
                com.facebook.hermes.intl.a$b r2 = com.facebook.hermes.intl.a.b.UPPER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f19939b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.hermes.intl.a$b r3 = com.facebook.hermes.intl.a.b.LOWER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f19939b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.hermes.intl.a$b r4 = com.facebook.hermes.intl.a.b.FALSE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.facebook.hermes.intl.a$c[] r3 = com.facebook.hermes.intl.a.c.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f19938a = r3
                com.facebook.hermes.intl.a$c r4 = com.facebook.hermes.intl.a.c.BASE     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f19938a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.facebook.hermes.intl.a$c r3 = com.facebook.hermes.intl.a.c.ACCENT     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f19938a     // Catch:{ NoSuchFieldError -> 0x004d }
                com.facebook.hermes.intl.a$c r1 = com.facebook.hermes.intl.a.c.CASE     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = f19938a     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.facebook.hermes.intl.a$c r1 = com.facebook.hermes.intl.a.c.VARIANT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.hermes.intl.m.a.<clinit>():void");
        }
    }

    m() {
    }

    public int a(String str, String str2) {
        return this.f19937a.compare(str, str2);
    }

    public a b(b bVar) {
        RuleBasedCollator a10 = b0.a(RuleBasedCollator.getInstance(((z) bVar).h()));
        this.f19937a = a10;
        a10.setDecomposition(17);
        return this;
    }

    public a.c c() {
        RuleBasedCollator ruleBasedCollator = this.f19937a;
        if (ruleBasedCollator == null) {
            return a.c.LOCALE;
        }
        int a10 = ruleBasedCollator.getStrength();
        if (a10 == 0) {
            if (this.f19937a.isCaseLevel()) {
                return a.c.CASE;
            }
            return a.c.BASE;
        } else if (a10 == 1) {
            return a.c.ACCENT;
        } else {
            return a.c.VARIANT;
        }
    }

    public a d(a.b bVar) {
        int i10 = a.f19939b[bVar.ordinal()];
        if (i10 == 1) {
            this.f19937a.setUpperCaseFirst(true);
        } else if (i10 != 2) {
            this.f19937a.setCaseFirstDefault();
        } else {
            this.f19937a.setLowerCaseFirst(true);
        }
        return this;
    }

    public a e(boolean z10) {
        if (z10) {
            this.f19937a.setNumericCollation(j.e(Boolean.TRUE));
        }
        return this;
    }

    public a f(a.c cVar) {
        int i10 = a.f19938a[cVar.ordinal()];
        if (i10 == 1) {
            this.f19937a.setStrength(0);
        } else if (i10 == 2) {
            this.f19937a.setStrength(1);
        } else if (i10 == 3) {
            this.f19937a.setStrength(0);
            this.f19937a.setCaseLevel(true);
        } else if (i10 == 4) {
            this.f19937a.setStrength(2);
        }
        return this;
    }

    public a g(boolean z10) {
        if (z10) {
            this.f19937a.setAlternateHandlingShifted(true);
        }
        return this;
    }
}
