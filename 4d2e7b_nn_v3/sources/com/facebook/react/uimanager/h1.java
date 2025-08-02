package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

public abstract class h1 {

    /* renamed from: a  reason: collision with root package name */
    private static ThreadLocal f3695a = new a();

    class a extends ThreadLocal {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public double[] initialValue() {
            return new double[16];
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3696a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3696a = r0
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3696a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.h1.b.<clinit>():void");
        }
    }

    private static double a(ReadableMap readableMap, String str) {
        double d10;
        boolean z10 = true;
        if (readableMap.getType(str) == ReadableType.String) {
            String string = readableMap.getString(str);
            if (string.endsWith("rad")) {
                string = string.substring(0, string.length() - 3);
            } else if (string.endsWith("deg")) {
                string = string.substring(0, string.length() - 3);
                z10 = false;
            }
            d10 = (double) Float.parseFloat(string);
        } else {
            d10 = readableMap.getDouble(str);
        }
        if (z10) {
            return d10;
        }
        return z.l(d10);
    }

    private static float[] b(float f10, float f11, ReadableArray readableArray, boolean z10) {
        float f12;
        if (readableArray == null) {
            return null;
        }
        if (f11 == 0.0f && f10 == 0.0f) {
            return null;
        }
        float f13 = f10 / 2.0f;
        float f14 = f11 / 2.0f;
        float[] fArr = {f13, f14, 0.0f};
        int i10 = 0;
        while (i10 < readableArray.size() && i10 < 3) {
            int i11 = b.f3696a[readableArray.getType(i10).ordinal()];
            if (i11 == 1) {
                fArr[i10] = (float) readableArray.getDouble(i10);
            } else if (i11 == 2 && z10) {
                String string = readableArray.getString(i10);
                if (string.endsWith("%")) {
                    float parseFloat = Float.parseFloat(string.substring(0, string.length() - 1));
                    if (i10 == 0) {
                        f12 = f10;
                    } else {
                        f12 = f11;
                    }
                    fArr[i10] = (f12 * parseFloat) / 100.0f;
                }
            }
            i10++;
        }
        return new float[]{(-f13) + fArr[0], (-f14) + fArr[1], fArr[2]};
    }

    private static double c(String str, double d10) {
        try {
            if (str.endsWith("%")) {
                return (Double.parseDouble(str.substring(0, str.length() - 1)) * d10) / 100.0d;
            }
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            z2.a.G("ReactNative", "Invalid translate value: " + str);
            return 0.0d;
        }
    }

    public static void d(ReadableArray readableArray, double[] dArr, float f10, float f11, ReadableArray readableArray2, boolean z10) {
        int i10;
        int i11;
        int i12;
        double d10;
        double d11;
        double d12;
        double d13;
        double d14;
        ReadableArray readableArray3 = readableArray;
        double[] dArr2 = dArr;
        float f12 = f10;
        float f13 = f11;
        double[] dArr3 = (double[]) f3695a.get();
        z.r(dArr);
        float[] b10 = b(f10, f11, readableArray2, z10);
        int i13 = 1;
        if (b10 != null) {
            z.r(dArr3);
            z.j(dArr3, (double) b10[0], (double) b10[1], (double) b10[2]);
            z.p(dArr2, dArr2, dArr3);
        }
        int i14 = 16;
        if (readableArray.size() == 16 && readableArray3.getType(0) == ReadableType.Number) {
            z.r(dArr3);
            for (int i15 = 0; i15 < readableArray.size(); i15++) {
                dArr3[i15] = readableArray3.getDouble(i15);
            }
            z.p(dArr2, dArr2, dArr3);
        } else {
            int size = readableArray.size();
            int i16 = 0;
            while (i16 < size) {
                ReadableMap map = readableArray3.getMap(i16);
                String nextKey = map.keySetIterator().nextKey();
                z.r(dArr3);
                if ("matrix".equals(nextKey)) {
                    ReadableArray array = map.getArray(nextKey);
                    for (int i17 = 0; i17 < i14; i17++) {
                        dArr3[i17] = array.getDouble(i17);
                    }
                } else if ("perspective".equals(nextKey)) {
                    z.a(dArr3, map.getDouble(nextKey));
                } else if ("rotateX".equals(nextKey)) {
                    z.b(dArr3, a(map, nextKey));
                } else if ("rotateY".equals(nextKey)) {
                    z.c(dArr3, a(map, nextKey));
                } else if ("rotate".equals(nextKey) || "rotateZ".equals(nextKey)) {
                    i10 = i16;
                    i12 = i14;
                    i11 = size;
                    z.d(dArr3, a(map, nextKey));
                    z.p(dArr2, dArr2, dArr3);
                    i16 = i10 + 1;
                    i14 = i12;
                    size = i11;
                    i13 = 1;
                } else if ("scale".equals(nextKey)) {
                    double d15 = map.getDouble(nextKey);
                    z.e(dArr3, d15);
                    z.f(dArr3, d15);
                } else if ("scaleX".equals(nextKey)) {
                    z.e(dArr3, map.getDouble(nextKey));
                } else if ("scaleY".equals(nextKey)) {
                    z.f(dArr3, map.getDouble(nextKey));
                } else {
                    int i18 = size;
                    if ("translate".equals(nextKey)) {
                        ReadableArray array2 = map.getArray(nextKey);
                        ReadableType type = array2.getType(0);
                        ReadableType readableType = ReadableType.String;
                        if (type != readableType || !z10) {
                            d12 = array2.getDouble(0);
                        } else {
                            d12 = c(array2.getString(0), (double) f12);
                        }
                        if (array2.getType(i13) != readableType || !z10) {
                            d13 = array2.getDouble(i13);
                        } else {
                            d13 = c(array2.getString(i13), (double) f13);
                        }
                        if (array2.size() > 2) {
                            d14 = array2.getDouble(2);
                        } else {
                            d14 = 0.0d;
                        }
                        i10 = i16;
                        double d16 = d13;
                        i11 = i18;
                        i12 = 16;
                        z.j(dArr3, d12, d16, d14);
                    } else {
                        i10 = i16;
                        i11 = i18;
                        i12 = 16;
                        if ("translateX".equals(nextKey)) {
                            if (map.getType(nextKey) != ReadableType.String || !z10) {
                                d11 = map.getDouble(nextKey);
                            } else {
                                d11 = c(map.getString(nextKey), (double) f12);
                            }
                            z.i(dArr3, d11, 0.0d);
                        } else if ("translateY".equals(nextKey)) {
                            if (map.getType(nextKey) != ReadableType.String || !z10) {
                                d10 = map.getDouble(nextKey);
                            } else {
                                d10 = c(map.getString(nextKey), (double) f13);
                            }
                            z.i(dArr3, 0.0d, d10);
                        } else if ("skewX".equals(nextKey)) {
                            z.g(dArr3, a(map, nextKey));
                        } else if ("skewY".equals(nextKey)) {
                            z.h(dArr3, a(map, nextKey));
                        } else {
                            z2.a.G("ReactNative", "Unsupported transform type: " + nextKey);
                        }
                    }
                    z.p(dArr2, dArr2, dArr3);
                    i16 = i10 + 1;
                    i14 = i12;
                    size = i11;
                    i13 = 1;
                }
                i10 = i16;
                i12 = i14;
                i11 = size;
                z.p(dArr2, dArr2, dArr3);
                i16 = i10 + 1;
                i14 = i12;
                size = i11;
                i13 = 1;
            }
        }
        if (b10 != null) {
            z.r(dArr3);
            z.j(dArr3, (double) (-b10[0]), (double) (-b10[1]), (double) (-b10[2]));
            z.p(dArr2, dArr2, dArr3);
        }
    }
}
