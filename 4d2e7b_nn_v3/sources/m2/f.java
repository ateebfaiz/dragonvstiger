package m2;

import kotlin.jvm.internal.m;
import v5.a;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f22528a = new f();

    private f() {
    }

    public static final void a(a aVar, a aVar2) {
        Class<f> cls = f.class;
        if (!a.d(cls)) {
            try {
                m.f(aVar, "x");
                m.f(aVar2, "b");
                int b10 = aVar.b(0);
                int b11 = aVar.b(1);
                int b12 = aVar.b(2);
                float[] a10 = aVar.a();
                float[] a11 = aVar2.a();
                for (int i10 = 0; i10 < b10; i10++) {
                    for (int i11 = 0; i11 < b11; i11++) {
                        for (int i12 = 0; i12 < b12; i12++) {
                            int i13 = (i10 * b11 * b12) + (i11 * b12) + i12;
                            a10[i13] = a10[i13] + a11[i12];
                        }
                    }
                }
            } catch (Throwable th) {
                a.b(th, cls);
            }
        }
    }

    public static final a b(a[] aVarArr) {
        Class<f> cls = f.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            m.f(aVarArr, "tensors");
            int b10 = aVarArr[0].b(0);
            int i10 = 0;
            for (a b11 : aVarArr) {
                i10 += b11.b(1);
            }
            a aVar = new a(new int[]{b10, i10});
            float[] a10 = aVar.a();
            for (int i11 = 0; i11 < b10; i11++) {
                int i12 = i11 * i10;
                int length = aVarArr.length;
                for (int i13 = 0; i13 < length; i13++) {
                    float[] a11 = aVarArr[i13].a();
                    int b12 = aVarArr[i13].b(1);
                    System.arraycopy(a11, i11 * b12, a10, i12, b12);
                    i12 += b12;
                }
            }
            return aVar;
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    public static final a c(a aVar, a aVar2) {
        a aVar3 = aVar;
        a aVar4 = aVar2;
        Class<f> cls = f.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            m.f(aVar3, "x");
            m.f(aVar4, "w");
            int i10 = 0;
            int b10 = aVar3.b(0);
            int b11 = aVar3.b(1);
            int b12 = aVar3.b(2);
            int b13 = aVar4.b(0);
            int i11 = (b11 - b13) + 1;
            int b14 = aVar4.b(2);
            a aVar5 = new a(new int[]{b10, i11, b14});
            float[] a10 = aVar.a();
            float[] a11 = aVar5.a();
            float[] a12 = aVar2.a();
            int i12 = 0;
            while (i12 < b10) {
                int i13 = i10;
                while (i13 < b14) {
                    int i14 = i10;
                    while (i14 < i11) {
                        float f10 = 0.0f;
                        while (i10 < b13) {
                            for (int i15 = 0; i15 < b12; i15++) {
                                f10 += a10[(b11 * b12 * i12) + ((i10 + i14) * b12) + i15] * a12[(((i10 * b12) + i15) * b14) + i13];
                            }
                            i10++;
                        }
                        a11[(i11 * b14 * i12) + (i14 * b14) + i13] = f10;
                        i14++;
                        i10 = 0;
                    }
                    i13++;
                    i10 = 0;
                }
                i12++;
                i10 = 0;
            }
            return aVar5;
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    public static final a d(a aVar, a aVar2, a aVar3) {
        Class<f> cls = f.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            m.f(aVar, "x");
            m.f(aVar2, "w");
            m.f(aVar3, "b");
            int b10 = aVar.b(0);
            int b11 = aVar3.b(0);
            a h10 = h(aVar, aVar2);
            float[] a10 = aVar3.a();
            float[] a11 = h10.a();
            for (int i10 = 0; i10 < b10; i10++) {
                for (int i11 = 0; i11 < b11; i11++) {
                    int i12 = (i10 * b11) + i11;
                    a11[i12] = a11[i12] + a10[i11];
                }
            }
            return h10;
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    public static final a e(String[] strArr, int i10, a aVar) {
        Class<f> cls = f.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            m.f(strArr, "texts");
            m.f(aVar, "w");
            int length = strArr.length;
            int b10 = aVar.b(1);
            a aVar2 = new a(new int[]{length, i10, b10});
            float[] a10 = aVar2.a();
            float[] a11 = aVar.a();
            for (int i11 = 0; i11 < length; i11++) {
                int[] d10 = g.f22529a.d(strArr[i11], i10);
                for (int i12 = 0; i12 < i10; i12++) {
                    System.arraycopy(a11, d10[i12] * b10, a10, (b10 * i10 * i11) + (b10 * i12), b10);
                }
            }
            return aVar2;
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    public static final void f(a aVar, int i10) {
        Class<f> cls = f.class;
        if (!a.d(cls)) {
            try {
                m.f(aVar, "x");
                if (i10 < aVar.c()) {
                    int c10 = aVar.c();
                    int i11 = 1;
                    for (int i12 = i10; i12 < c10; i12++) {
                        i11 *= aVar.b(i12);
                    }
                    int[] iArr = new int[(i10 + 1)];
                    for (int i13 = 0; i13 < i10; i13++) {
                        iArr[i13] = aVar.b(i13);
                    }
                    iArr[i10] = i11;
                    aVar.d(iArr);
                }
            } catch (Throwable th) {
                a.b(th, cls);
            }
        }
    }

    public static final a g(a aVar, int i10) {
        a aVar2 = aVar;
        int i11 = i10;
        Class<f> cls = f.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            m.f(aVar2, "x");
            int i12 = 0;
            int b10 = aVar2.b(0);
            int b11 = aVar2.b(1);
            int b12 = aVar2.b(2);
            int i13 = (b11 - i11) + 1;
            a aVar3 = new a(new int[]{b10, i13, b12});
            float[] a10 = aVar.a();
            float[] a11 = aVar3.a();
            int i14 = 0;
            while (i14 < b10) {
                int i15 = i12;
                while (i15 < b12) {
                    int i16 = i12;
                    while (i16 < i13) {
                        int i17 = i16 * b12;
                        int i18 = (i14 * i13 * b12) + i17 + i15;
                        int i19 = (i14 * b11 * b12) + i17 + i15;
                        a11[i18] = Float.MIN_VALUE;
                        for (int i20 = i12; i20 < i11; i20++) {
                            a11[i18] = Math.max(a11[i18], a10[i19 + (i20 * b12)]);
                        }
                        i16++;
                        i12 = 0;
                    }
                    i15++;
                    i12 = 0;
                }
                i14++;
                i12 = 0;
            }
            return aVar3;
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    public static final a h(a aVar, a aVar2) {
        a aVar3 = aVar;
        a aVar4 = aVar2;
        Class<f> cls = f.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            m.f(aVar3, "x");
            m.f(aVar4, "w");
            int b10 = aVar3.b(0);
            int b11 = aVar4.b(0);
            int b12 = aVar4.b(1);
            a aVar5 = new a(new int[]{b10, b12});
            float[] a10 = aVar.a();
            float[] a11 = aVar2.a();
            float[] a12 = aVar5.a();
            for (int i10 = 0; i10 < b10; i10++) {
                for (int i11 = 0; i11 < b12; i11++) {
                    int i12 = (i10 * b12) + i11;
                    a12[i12] = 0.0f;
                    for (int i13 = 0; i13 < b11; i13++) {
                        a12[i12] = a12[i12] + (a10[(i10 * b11) + i13] * a11[(i13 * b12) + i11]);
                    }
                }
            }
            return aVar5;
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    public static final void i(a aVar) {
        Class<f> cls = f.class;
        if (!a.d(cls)) {
            try {
                m.f(aVar, "x");
                float[] a10 = aVar.a();
                int length = a10.length;
                for (int i10 = 0; i10 < length; i10++) {
                    if (a10[i10] < ((float) 0)) {
                        a10[i10] = 0.0f;
                    }
                }
            } catch (Throwable th) {
                a.b(th, cls);
            }
        }
    }

    public static final void j(a aVar) {
        Class<f> cls = f.class;
        if (!a.d(cls)) {
            try {
                m.f(aVar, "x");
                int b10 = aVar.b(0);
                int b11 = aVar.b(1);
                float[] a10 = aVar.a();
                for (int i10 = 0; i10 < b10; i10++) {
                    int i11 = i10 * b11;
                    int i12 = i11 + b11;
                    float f10 = Float.MIN_VALUE;
                    for (int i13 = i11; i13 < i12; i13++) {
                        float f11 = a10[i13];
                        if (f11 > f10) {
                            f10 = f11;
                        }
                    }
                    float f12 = 0.0f;
                    for (int i14 = i11; i14 < i12; i14++) {
                        float exp = (float) Math.exp((double) (a10[i14] - f10));
                        a10[i14] = exp;
                        f12 += exp;
                    }
                    while (i11 < i12) {
                        a10[i11] = a10[i11] / f12;
                        i11++;
                    }
                }
            } catch (Throwable th) {
                a.b(th, cls);
            }
        }
    }

    public static final a k(a aVar) {
        Class<f> cls = f.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            m.f(aVar, "x");
            int b10 = aVar.b(0);
            int b11 = aVar.b(1);
            a aVar2 = new a(new int[]{b11, b10});
            float[] a10 = aVar.a();
            float[] a11 = aVar2.a();
            for (int i10 = 0; i10 < b10; i10++) {
                for (int i11 = 0; i11 < b11; i11++) {
                    a11[(i11 * b10) + i10] = a10[(i10 * b11) + i11];
                }
            }
            return aVar2;
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    public static final a l(a aVar) {
        Class<f> cls = f.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            m.f(aVar, "x");
            int b10 = aVar.b(0);
            int b11 = aVar.b(1);
            int b12 = aVar.b(2);
            a aVar2 = new a(new int[]{b12, b11, b10});
            float[] a10 = aVar.a();
            float[] a11 = aVar2.a();
            for (int i10 = 0; i10 < b10; i10++) {
                for (int i11 = 0; i11 < b11; i11++) {
                    for (int i12 = 0; i12 < b12; i12++) {
                        a11[(i12 * b10 * b11) + (i11 * b10) + i10] = a10[(i10 * b11 * b12) + (i11 * b12) + i12];
                    }
                }
            }
            return aVar2;
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }
}
