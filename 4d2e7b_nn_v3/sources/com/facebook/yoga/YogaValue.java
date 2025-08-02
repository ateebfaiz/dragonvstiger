package com.facebook.yoga;

public class YogaValue {

    /* renamed from: c  reason: collision with root package name */
    static final YogaValue f4855c = new YogaValue(Float.NaN, u.UNDEFINED);

    /* renamed from: d  reason: collision with root package name */
    static final YogaValue f4856d = new YogaValue(0.0f, u.POINT);

    /* renamed from: e  reason: collision with root package name */
    static final YogaValue f4857e = new YogaValue(Float.NaN, u.AUTO);

    /* renamed from: a  reason: collision with root package name */
    public final float f4858a;

    /* renamed from: b  reason: collision with root package name */
    public final u f4859b;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4860a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.facebook.yoga.u[] r0 = com.facebook.yoga.u.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4860a = r0
                com.facebook.yoga.u r1 = com.facebook.yoga.u.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4860a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.yoga.u r1 = com.facebook.yoga.u.POINT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4860a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.yoga.u r1 = com.facebook.yoga.u.PERCENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4860a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.yoga.u r1 = com.facebook.yoga.u.AUTO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.yoga.YogaValue.a.<clinit>():void");
        }
    }

    public YogaValue(float f10, u uVar) {
        this.f4858a = f10;
        this.f4859b = uVar;
    }

    public static YogaValue a(String str) {
        if (str == null) {
            return null;
        }
        if ("undefined".equals(str)) {
            return f4855c;
        }
        if ("auto".equals(str)) {
            return f4857e;
        }
        if (str.endsWith("%")) {
            return new YogaValue(Float.parseFloat(str.substring(0, str.length() - 1)), u.PERCENT);
        }
        return new YogaValue(Float.parseFloat(str), u.POINT);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof YogaValue)) {
            return false;
        }
        YogaValue yogaValue = (YogaValue) obj;
        u uVar = this.f4859b;
        if (uVar != yogaValue.f4859b) {
            return false;
        }
        if (uVar == u.UNDEFINED || uVar == u.AUTO || Float.compare(this.f4858a, yogaValue.f4858a) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f4858a) + this.f4859b.c();
    }

    public String toString() {
        int i10 = a.f4860a[this.f4859b.ordinal()];
        if (i10 == 1) {
            return "undefined";
        }
        if (i10 == 2) {
            return Float.toString(this.f4858a);
        }
        if (i10 == 3) {
            return this.f4858a + "%";
        } else if (i10 == 4) {
            return "auto";
        } else {
            throw new IllegalStateException();
        }
    }

    YogaValue(float f10, int i10) {
        this(f10, u.b(i10));
    }
}
