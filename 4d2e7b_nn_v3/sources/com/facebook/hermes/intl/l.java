package com.facebook.hermes.intl;

import com.facebook.hermes.intl.a;
import java.text.Collator;
import java.text.RuleBasedCollator;
import o4.b;

public class l implements a {

    /* renamed from: a  reason: collision with root package name */
    private RuleBasedCollator f19934a;

    /* renamed from: b  reason: collision with root package name */
    private h f19935b;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19936a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.facebook.hermes.intl.a$c[] r0 = com.facebook.hermes.intl.a.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19936a = r0
                com.facebook.hermes.intl.a$c r1 = com.facebook.hermes.intl.a.c.BASE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f19936a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.hermes.intl.a$c r1 = com.facebook.hermes.intl.a.c.ACCENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f19936a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.hermes.intl.a$c r1 = com.facebook.hermes.intl.a.c.VARIANT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f19936a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.hermes.intl.a$c r1 = com.facebook.hermes.intl.a.c.CASE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.hermes.intl.l.a.<clinit>():void");
        }
    }

    l() {
    }

    public int a(String str, String str2) {
        return this.f19934a.compare(str, str2);
    }

    public a b(b bVar) {
        h hVar = (h) bVar;
        this.f19935b = hVar;
        this.f19934a = (RuleBasedCollator) Collator.getInstance(hVar.h());
        return this;
    }

    public a.c c() {
        RuleBasedCollator ruleBasedCollator = this.f19934a;
        if (ruleBasedCollator == null) {
            return a.c.LOCALE;
        }
        int strength = ruleBasedCollator.getStrength();
        if (strength == 0) {
            return a.c.BASE;
        }
        if (strength == 1) {
            return a.c.ACCENT;
        }
        return a.c.VARIANT;
    }

    public a d(a.b bVar) {
        return this;
    }

    public a e(boolean z10) {
        return this;
    }

    public a f(a.c cVar) {
        int i10 = a.f19936a[cVar.ordinal()];
        if (i10 == 1) {
            this.f19934a.setStrength(0);
        } else if (i10 == 2) {
            this.f19934a.setStrength(1);
        } else if (i10 == 3) {
            this.f19934a.setStrength(2);
        } else if (i10 == 4) {
            this.f19934a.setStrength(0);
        }
        return this;
    }

    public a g(boolean z10) {
        return this;
    }
}
