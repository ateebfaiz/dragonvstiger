package com.facebook.react.animated;

import androidx.core.graphics.ColorUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class k extends b0 {

    /* renamed from: p  reason: collision with root package name */
    private static final Pattern f2815p = Pattern.compile("[+-]?(\\d+\\.?\\d*|\\.\\d+)([eE][+-]?\\d+)?");

    /* renamed from: h  reason: collision with root package name */
    private final double[] f2816h;

    /* renamed from: i  reason: collision with root package name */
    private final Object f2817i;

    /* renamed from: j  reason: collision with root package name */
    private final b f2818j;

    /* renamed from: k  reason: collision with root package name */
    private final String f2819k;

    /* renamed from: l  reason: collision with root package name */
    private final String f2820l;

    /* renamed from: m  reason: collision with root package name */
    private final String f2821m;

    /* renamed from: n  reason: collision with root package name */
    private b0 f2822n;

    /* renamed from: o  reason: collision with root package name */
    private Object f2823o;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2824a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.react.animated.k$b[] r0 = com.facebook.react.animated.k.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2824a = r0
                com.facebook.react.animated.k$b r1 = com.facebook.react.animated.k.b.Number     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2824a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.animated.k$b r1 = com.facebook.react.animated.k.b.Color     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2824a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.animated.k$b r1 = com.facebook.react.animated.k.b.String     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.k.a.<clinit>():void");
        }
    }

    private enum b {
        Number,
        Color,
        String
    }

    public k(ReadableMap readableMap) {
        this.f2816h = p(readableMap.getArray("inputRange"));
        ReadableArray array = readableMap.getArray("outputRange");
        if ("color".equals(readableMap.getString("outputType"))) {
            this.f2818j = b.Color;
            this.f2817i = q(array);
            this.f2819k = null;
        } else if (array.getType(0) == ReadableType.String) {
            this.f2818j = b.String;
            this.f2817i = r(array);
            this.f2819k = array.getString(0);
        } else {
            this.f2818j = b.Number;
            this.f2817i = p(array);
            this.f2819k = null;
        }
        this.f2820l = readableMap.getString("extrapolateLeft");
        this.f2821m = readableMap.getString("extrapolateRight");
    }

    private static int o(double d10, double[] dArr) {
        int i10 = 1;
        while (i10 < dArr.length - 1 && dArr[i10] < d10) {
            i10++;
        }
        return i10 - 1;
    }

    private static double[] p(ReadableArray readableArray) {
        int size = readableArray.size();
        double[] dArr = new double[size];
        for (int i10 = 0; i10 < size; i10++) {
            dArr[i10] = readableArray.getDouble(i10);
        }
        return dArr;
    }

    private static int[] q(ReadableArray readableArray) {
        int size = readableArray.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = readableArray.getInt(i10);
        }
        return iArr;
    }

    private static double[][] r(ReadableArray readableArray) {
        int size = readableArray.size();
        double[][] dArr = new double[size][];
        Matcher matcher = f2815p.matcher(readableArray.getString(0));
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            arrayList.add(Double.valueOf(Double.parseDouble(matcher.group())));
        }
        int size2 = arrayList.size();
        double[] dArr2 = new double[size2];
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            dArr2[i10] = ((Double) arrayList.get(i10)).doubleValue();
        }
        dArr[0] = dArr2;
        for (int i11 = 1; i11 < size; i11++) {
            double[] dArr3 = new double[size2];
            Matcher matcher2 = f2815p.matcher(readableArray.getString(i11));
            int i12 = 0;
            while (matcher2.find() && i12 < size2) {
                dArr3[i12] = Double.parseDouble(matcher2.group());
                i12++;
            }
            dArr[i11] = dArr3;
        }
        return dArr;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006f, code lost:
        if (r1.equals("clamp") == false) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static double s(double r13, double r15, double r17, double r19, double r21, java.lang.String r23, java.lang.String r24) {
        /*
            r0 = r23
            r1 = r24
            r2 = 2
            java.lang.String r3 = "clamp"
            r4 = 1
            java.lang.String r5 = "identity"
            r6 = 0
            java.lang.String r7 = "extend"
            r8 = -1
            int r9 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            java.lang.String r10 = "Invalid extrapolation type "
            if (r9 >= 0) goto L_0x005a
            r23.hashCode()
            int r11 = r23.hashCode()
            switch(r11) {
                case -1289044198: goto L_0x0032;
                case -135761730: goto L_0x0029;
                case 94742715: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            r11 = r8
            goto L_0x003a
        L_0x0020:
            boolean r11 = r0.equals(r3)
            if (r11 != 0) goto L_0x0027
            goto L_0x001e
        L_0x0027:
            r11 = r2
            goto L_0x003a
        L_0x0029:
            boolean r11 = r0.equals(r5)
            if (r11 != 0) goto L_0x0030
            goto L_0x001e
        L_0x0030:
            r11 = r4
            goto L_0x003a
        L_0x0032:
            boolean r11 = r0.equals(r7)
            if (r11 != 0) goto L_0x0039
            goto L_0x001e
        L_0x0039:
            r11 = r6
        L_0x003a:
            switch(r11) {
                case 0: goto L_0x005a;
                case 1: goto L_0x0059;
                case 2: goto L_0x0057;
                default: goto L_0x003d;
            }
        L_0x003d:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r1 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r10)
            r2.append(r0)
            java.lang.String r0 = "for left extrapolation"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0057:
            r11 = r15
            goto L_0x005b
        L_0x0059:
            return r13
        L_0x005a:
            r11 = r13
        L_0x005b:
            int r0 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a4
            r24.hashCode()
            int r0 = r24.hashCode()
            switch(r0) {
                case -1289044198: goto L_0x007b;
                case -135761730: goto L_0x0072;
                case 94742715: goto L_0x006b;
                default: goto L_0x0069;
            }
        L_0x0069:
            r2 = r8
            goto L_0x0083
        L_0x006b:
            boolean r0 = r1.equals(r3)
            if (r0 != 0) goto L_0x0083
            goto L_0x0069
        L_0x0072:
            boolean r0 = r1.equals(r5)
            if (r0 != 0) goto L_0x0079
            goto L_0x0069
        L_0x0079:
            r2 = r4
            goto L_0x0083
        L_0x007b:
            boolean r0 = r1.equals(r7)
            if (r0 != 0) goto L_0x0082
            goto L_0x0069
        L_0x0082:
            r2 = r6
        L_0x0083:
            switch(r2) {
                case 0: goto L_0x00a4;
                case 1: goto L_0x00a3;
                case 2: goto L_0x00a0;
                default: goto L_0x0086;
            }
        L_0x0086:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r0 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r10)
            r2.append(r1)
            java.lang.String r1 = "for right extrapolation"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x00a0:
            r11 = r17
            goto L_0x00a4
        L_0x00a3:
            return r11
        L_0x00a4:
            int r0 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1))
            if (r0 != 0) goto L_0x00a9
            return r19
        L_0x00a9:
            int r0 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r0 != 0) goto L_0x00b1
            if (r9 > 0) goto L_0x00b0
            return r19
        L_0x00b0:
            return r21
        L_0x00b1:
            double r0 = r21 - r19
            double r11 = r11 - r15
            double r0 = r0 * r11
            double r2 = r17 - r15
            double r0 = r0 / r2
            double r0 = r19 + r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.k.s(double, double, double, double, double, java.lang.String, java.lang.String):double");
    }

    static double t(double d10, double[] dArr, double[] dArr2, String str, String str2) {
        int o10 = o(d10, dArr);
        int i10 = o10 + 1;
        return s(d10, dArr[o10], dArr[i10], dArr2[o10], dArr2[i10], str, str2);
    }

    static int u(double d10, double[] dArr, int[] iArr) {
        int o10 = o(d10, dArr);
        int i10 = iArr[o10];
        int i11 = o10 + 1;
        int i12 = iArr[i11];
        if (i10 == i12) {
            return i10;
        }
        double d11 = dArr[o10];
        double d12 = dArr[i11];
        if (d11 != d12) {
            return ColorUtils.blendARGB(i10, i12, (float) ((d10 - d11) / (d12 - d11)));
        }
        if (d10 <= d11) {
            return i10;
        }
        return i12;
    }

    static String v(String str, double d10, double[] dArr, double[][] dArr2, String str2, String str3) {
        String str4;
        int o10 = o(d10, dArr);
        StringBuffer stringBuffer = new StringBuffer(str.length());
        Matcher matcher = f2815p.matcher(str);
        int i10 = 0;
        while (matcher.find()) {
            double[] dArr3 = dArr2[o10];
            if (i10 >= dArr3.length) {
                break;
            }
            int i11 = o10 + 1;
            double s10 = s(d10, dArr[o10], dArr[i11], dArr3[i10], dArr2[i11][i10], str2, str3);
            int i12 = (int) s10;
            if (((double) i12) != s10) {
                str4 = Double.toString(s10);
            } else {
                str4 = Integer.toString(i12);
            }
            matcher.appendReplacement(stringBuffer, str4);
            i10++;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public void c(b bVar) {
        if (this.f2822n != null) {
            throw new IllegalStateException("Parent already attached");
        } else if (bVar instanceof b0) {
            this.f2822n = (b0) bVar;
        } else {
            throw new IllegalArgumentException("Parent is of an invalid type");
        }
    }

    public void d(b bVar) {
        if (bVar == this.f2822n) {
            this.f2822n = null;
            return;
        }
        throw new IllegalArgumentException("Invalid parent node provided");
    }

    public String e() {
        return "InterpolationAnimatedNode[" + this.f2778d + "] super: " + super.e();
    }

    public void h() {
        b0 b0Var = this.f2822n;
        if (b0Var != null) {
            double l10 = b0Var.l();
            int i10 = a.f2824a[this.f2818j.ordinal()];
            if (i10 == 1) {
                this.f2779e = t(l10, this.f2816h, (double[]) this.f2817i, this.f2820l, this.f2821m);
            } else if (i10 == 2) {
                this.f2823o = Integer.valueOf(u(l10, this.f2816h, (int[]) this.f2817i));
            } else if (i10 == 3) {
                this.f2823o = v(this.f2819k, l10, this.f2816h, (double[][]) this.f2817i, this.f2820l, this.f2821m);
            }
        }
    }

    public Object k() {
        return this.f2823o;
    }
}
