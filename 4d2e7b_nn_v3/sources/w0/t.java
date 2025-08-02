package w0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.e;
import com.airbnb.lottie.j;
import com.alibaba.pdns.model.DomainUhfReportModel;
import java.lang.ref.WeakReference;
import x0.c;
import y0.k;
import y0.l;
import z0.a;

abstract class t {

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f24471a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    private static SparseArrayCompat f24472b;

    /* renamed from: c  reason: collision with root package name */
    static c.a f24473c = c.a.a("t", DomainUhfReportModel.SCENE, "e", "o", "i", "h", "to", "ti");

    /* renamed from: d  reason: collision with root package name */
    static c.a f24474d = c.a.a("x", "y");

    private static WeakReference a(int i10) {
        WeakReference weakReference;
        synchronized (t.class) {
            weakReference = (WeakReference) g().get(i10);
        }
        return weakReference;
    }

    private static Interpolator b(PointF pointF, PointF pointF2) {
        WeakReference weakReference;
        Interpolator linearInterpolator;
        pointF.x = k.b(pointF.x, -1.0f, 1.0f);
        pointF.y = k.b(pointF.y, -100.0f, 100.0f);
        pointF2.x = k.b(pointF2.x, -1.0f, 1.0f);
        float b10 = k.b(pointF2.y, -100.0f, 100.0f);
        pointF2.y = b10;
        int i10 = l.i(pointF.x, pointF.y, pointF2.x, b10);
        Interpolator interpolator = null;
        if (e.e()) {
            weakReference = null;
        } else {
            weakReference = a(i10);
        }
        if (weakReference != null) {
            interpolator = (Interpolator) weakReference.get();
        }
        if (weakReference == null || interpolator == null) {
            try {
                linearInterpolator = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e10) {
                if ("The Path cannot loop back on itself.".equals(e10.getMessage())) {
                    linearInterpolator = PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            if (!e.e()) {
                try {
                    h(i10, new WeakReference(interpolator));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator;
    }

    static a c(c cVar, j jVar, float f10, n0 n0Var, boolean z10, boolean z11) {
        if (z10 && z11) {
            return e(jVar, cVar, f10, n0Var);
        }
        if (z10) {
            return d(jVar, cVar, f10, n0Var);
        }
        return f(cVar, f10, n0Var);
    }

    private static a d(j jVar, c cVar, float f10, n0 n0Var) {
        Interpolator interpolator;
        Object obj;
        Interpolator interpolator2;
        cVar.h();
        PointF pointF = null;
        Object obj2 = null;
        Object obj3 = null;
        PointF pointF2 = null;
        PointF pointF3 = null;
        float f11 = 0.0f;
        boolean z10 = false;
        PointF pointF4 = null;
        while (cVar.m()) {
            switch (cVar.C(f24473c)) {
                case 0:
                    f11 = (float) cVar.p();
                    break;
                case 1:
                    obj3 = n0Var.a(cVar, f10);
                    break;
                case 2:
                    obj2 = n0Var.a(cVar, f10);
                    break;
                case 3:
                    pointF = s.e(cVar, 1.0f);
                    break;
                case 4:
                    pointF4 = s.e(cVar, 1.0f);
                    break;
                case 5:
                    if (cVar.v() != 1) {
                        z10 = false;
                        break;
                    } else {
                        z10 = true;
                        break;
                    }
                case 6:
                    pointF2 = s.e(cVar, f10);
                    break;
                case 7:
                    pointF3 = s.e(cVar, f10);
                    break;
                default:
                    cVar.G();
                    break;
            }
        }
        cVar.k();
        if (z10) {
            interpolator = f24471a;
            obj = obj3;
        } else {
            if (pointF == null || pointF4 == null) {
                interpolator2 = f24471a;
            } else {
                interpolator2 = b(pointF, pointF4);
            }
            interpolator = interpolator2;
            obj = obj2;
        }
        a aVar = new a(jVar, obj3, obj, interpolator, f11, (Float) null);
        aVar.f24983o = pointF2;
        aVar.f24984p = pointF3;
        return aVar;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e0, code lost:
        r14 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static z0.a e(com.airbnb.lottie.j r21, x0.c r22, float r23, w0.n0 r24) {
        /*
            r0 = r22
            r1 = r23
            r2 = r24
            r22.h()
            r3 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x0016:
            boolean r17 = r22.m()
            if (r17 == 0) goto L_0x01a5
            x0.c$a r4 = f24473c
            int r4 = r0.C(r4)
            r5 = 1
            switch(r4) {
                case 0: goto L_0x019a;
                case 1: goto L_0x018f;
                case 2: goto L_0x0184;
                case 3: goto L_0x00ef;
                case 4: goto L_0x003e;
                case 5: goto L_0x0034;
                case 6: goto L_0x002f;
                case 7: goto L_0x002a;
                default: goto L_0x0026;
            }
        L_0x0026:
            r22.G()
            goto L_0x0016
        L_0x002a:
            android.graphics.PointF r3 = w0.s.e(r22, r23)
            goto L_0x0016
        L_0x002f:
            android.graphics.PointF r15 = w0.s.e(r22, r23)
            goto L_0x0016
        L_0x0034:
            int r4 = r22.v()
            if (r4 != r5) goto L_0x003c
            r6 = r5
            goto L_0x0016
        L_0x003c:
            r6 = 0
            goto L_0x0016
        L_0x003e:
            x0.c$b r4 = r22.A()
            x0.c$b r5 = x0.c.b.BEGIN_OBJECT
            if (r4 != r5) goto L_0x00e5
            r22.h()
            r4 = 0
            r5 = 0
            r12 = 0
            r13 = 0
        L_0x004d:
            boolean r18 = r22.m()
            if (r18 == 0) goto L_0x00cc
            r18 = r15
            x0.c$a r15 = f24474d
            int r15 = r0.C(r15)
            if (r15 == 0) goto L_0x009f
            r19 = r3
            r3 = 1
            if (r15 == r3) goto L_0x006a
            r22.G()
        L_0x0065:
            r15 = r18
            r3 = r19
            goto L_0x004d
        L_0x006a:
            x0.c$b r3 = r22.A()
            x0.c$b r5 = x0.c.b.NUMBER
            if (r3 != r5) goto L_0x007b
            r3 = r14
            double r13 = r22.p()
            float r13 = (float) r13
            r14 = r3
            r5 = r13
            goto L_0x0065
        L_0x007b:
            r3 = r14
            r22.b()
            double r13 = r22.p()
            float r13 = (float) r13
            x0.c$b r14 = r22.A()
            if (r14 != r5) goto L_0x0090
            double r14 = r22.p()
            float r5 = (float) r14
            goto L_0x0091
        L_0x0090:
            r5 = r13
        L_0x0091:
            r22.j()
            r14 = r3
            r15 = r18
            r3 = r19
            r20 = r13
            r13 = r5
            r5 = r20
            goto L_0x004d
        L_0x009f:
            r19 = r3
            r3 = r14
            x0.c$b r4 = r22.A()
            x0.c$b r12 = x0.c.b.NUMBER
            if (r4 != r12) goto L_0x00b2
            double r14 = r22.p()
            float r12 = (float) r14
            r14 = r3
            r4 = r12
            goto L_0x0065
        L_0x00b2:
            r22.b()
            double r14 = r22.p()
            float r4 = (float) r14
            x0.c$b r14 = r22.A()
            if (r14 != r12) goto L_0x00c6
            double r14 = r22.p()
            float r12 = (float) r14
            goto L_0x00c7
        L_0x00c6:
            r12 = r4
        L_0x00c7:
            r22.j()
            r14 = r3
            goto L_0x0065
        L_0x00cc:
            r19 = r3
            r3 = r14
            r18 = r15
            android.graphics.PointF r14 = new android.graphics.PointF
            r14.<init>(r4, r5)
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>(r12, r13)
            r22.k()
            r13 = r4
            r12 = r14
        L_0x00e0:
            r14 = r3
        L_0x00e1:
            r3 = r19
            goto L_0x0016
        L_0x00e5:
            r19 = r3
            r3 = r14
            r18 = r15
            android.graphics.PointF r8 = w0.s.e(r22, r23)
            goto L_0x00e1
        L_0x00ef:
            r19 = r3
            r3 = r14
            r18 = r15
            x0.c$b r4 = r22.A()
            x0.c$b r5 = x0.c.b.BEGIN_OBJECT
            if (r4 != r5) goto L_0x017b
            r22.h()
            r4 = 0
            r5 = 0
            r9 = 0
            r11 = 0
        L_0x0103:
            boolean r14 = r22.m()
            if (r14 == 0) goto L_0x0168
            x0.c$a r14 = f24474d
            int r14 = r0.C(r14)
            if (r14 == 0) goto L_0x0140
            r15 = 1
            if (r14 == r15) goto L_0x0118
            r22.G()
            goto L_0x0103
        L_0x0118:
            x0.c$b r5 = r22.A()
            x0.c$b r11 = x0.c.b.NUMBER
            if (r5 != r11) goto L_0x0127
            double r14 = r22.p()
            float r11 = (float) r14
            r5 = r11
            goto L_0x0103
        L_0x0127:
            r22.b()
            double r14 = r22.p()
            float r5 = (float) r14
            x0.c$b r14 = r22.A()
            if (r14 != r11) goto L_0x013b
            double r14 = r22.p()
            float r11 = (float) r14
            goto L_0x013c
        L_0x013b:
            r11 = r5
        L_0x013c:
            r22.j()
            goto L_0x0103
        L_0x0140:
            x0.c$b r4 = r22.A()
            x0.c$b r9 = x0.c.b.NUMBER
            if (r4 != r9) goto L_0x014f
            double r14 = r22.p()
            float r9 = (float) r14
            r4 = r9
            goto L_0x0103
        L_0x014f:
            r22.b()
            double r14 = r22.p()
            float r4 = (float) r14
            x0.c$b r14 = r22.A()
            if (r14 != r9) goto L_0x0163
            double r14 = r22.p()
            float r9 = (float) r14
            goto L_0x0164
        L_0x0163:
            r9 = r4
        L_0x0164:
            r22.j()
            goto L_0x0103
        L_0x0168:
            android.graphics.PointF r14 = new android.graphics.PointF
            r14.<init>(r4, r5)
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>(r9, r11)
            r22.k()
            r11 = r4
            r9 = r14
            r15 = r18
            goto L_0x00e0
        L_0x017b:
            android.graphics.PointF r7 = w0.s.e(r22, r23)
            r14 = r3
            r15 = r18
            goto L_0x00e1
        L_0x0184:
            r19 = r3
            r3 = r14
            r18 = r15
            java.lang.Object r16 = r2.a(r0, r1)
            goto L_0x00e1
        L_0x018f:
            r19 = r3
            r3 = r14
            r18 = r15
            java.lang.Object r10 = r2.a(r0, r1)
            goto L_0x00e1
        L_0x019a:
            r19 = r3
            r18 = r15
            double r3 = r22.p()
            float r14 = (float) r3
            goto L_0x00e1
        L_0x01a5:
            r19 = r3
            r3 = r14
            r18 = r15
            r22.k()
            if (r6 == 0) goto L_0x01b5
            android.view.animation.Interpolator r0 = f24471a
            r11 = r10
        L_0x01b2:
            r12 = 0
            r13 = 0
            goto L_0x01d9
        L_0x01b5:
            if (r7 == 0) goto L_0x01c0
            if (r8 == 0) goto L_0x01c0
            android.view.animation.Interpolator r0 = b(r7, r8)
        L_0x01bd:
            r11 = r16
            goto L_0x01b2
        L_0x01c0:
            if (r9 == 0) goto L_0x01d6
            if (r11 == 0) goto L_0x01d6
            if (r12 == 0) goto L_0x01d6
            if (r13 == 0) goto L_0x01d6
            android.view.animation.Interpolator r0 = b(r9, r12)
            android.view.animation.Interpolator r1 = b(r11, r13)
            r12 = r0
            r13 = r1
            r11 = r16
            r0 = 0
            goto L_0x01d9
        L_0x01d6:
            android.view.animation.Interpolator r0 = f24471a
            goto L_0x01bd
        L_0x01d9:
            if (r12 == 0) goto L_0x01ea
            if (r13 == 0) goto L_0x01ea
            z0.a r0 = new z0.a
            r15 = 0
            r8 = r0
            r9 = r21
            r14 = r3
            r1 = r18
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            goto L_0x01f8
        L_0x01ea:
            r1 = r18
            z0.a r2 = new z0.a
            r14 = 0
            r8 = r2
            r9 = r21
            r12 = r0
            r13 = r3
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r0 = r2
        L_0x01f8:
            r0.f24983o = r1
            r3 = r19
            r0.f24984p = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.t.e(com.airbnb.lottie.j, x0.c, float, w0.n0):z0.a");
    }

    private static a f(c cVar, float f10, n0 n0Var) {
        return new a(n0Var.a(cVar, f10));
    }

    private static SparseArrayCompat g() {
        if (f24472b == null) {
            f24472b = new SparseArrayCompat();
        }
        return f24472b;
    }

    private static void h(int i10, WeakReference weakReference) {
        synchronized (t.class) {
            f24472b.put(i10, weakReference);
        }
    }
}
