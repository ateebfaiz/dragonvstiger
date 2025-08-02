package w0;

import android.graphics.Color;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import x0.c;

abstract class s {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24469a = c.a.a("x", "y");

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24470a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                x0.c$b[] r0 = x0.c.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24470a = r0
                x0.c$b r1 = x0.c.b.NUMBER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24470a     // Catch:{ NoSuchFieldError -> 0x001d }
                x0.c$b r1 = x0.c.b.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f24470a     // Catch:{ NoSuchFieldError -> 0x0028 }
                x0.c$b r1 = x0.c.b.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: w0.s.a.<clinit>():void");
        }
    }

    private static PointF a(c cVar, float f10) {
        cVar.b();
        float p10 = (float) cVar.p();
        float p11 = (float) cVar.p();
        while (cVar.A() != c.b.END_ARRAY) {
            cVar.G();
        }
        cVar.j();
        return new PointF(p10 * f10, p11 * f10);
    }

    private static PointF b(c cVar, float f10) {
        float p10 = (float) cVar.p();
        float p11 = (float) cVar.p();
        while (cVar.m()) {
            cVar.G();
        }
        return new PointF(p10 * f10, p11 * f10);
    }

    private static PointF c(c cVar, float f10) {
        cVar.h();
        float f11 = 0.0f;
        float f12 = 0.0f;
        while (cVar.m()) {
            int C = cVar.C(f24469a);
            if (C == 0) {
                f11 = g(cVar);
            } else if (C != 1) {
                cVar.E();
                cVar.G();
            } else {
                f12 = g(cVar);
            }
        }
        cVar.k();
        return new PointF(f11 * f10, f12 * f10);
    }

    static int d(c cVar) {
        cVar.b();
        int p10 = (int) (cVar.p() * 255.0d);
        int p11 = (int) (cVar.p() * 255.0d);
        int p12 = (int) (cVar.p() * 255.0d);
        while (cVar.m()) {
            cVar.G();
        }
        cVar.j();
        return Color.argb(255, p10, p11, p12);
    }

    static PointF e(c cVar, float f10) {
        int i10 = a.f24470a[cVar.A().ordinal()];
        if (i10 == 1) {
            return b(cVar, f10);
        }
        if (i10 == 2) {
            return a(cVar, f10);
        }
        if (i10 == 3) {
            return c(cVar, f10);
        }
        throw new IllegalArgumentException("Unknown point starts with " + cVar.A());
    }

    static List f(c cVar, float f10) {
        ArrayList arrayList = new ArrayList();
        cVar.b();
        while (cVar.A() == c.b.BEGIN_ARRAY) {
            cVar.b();
            arrayList.add(e(cVar, f10));
            cVar.j();
        }
        cVar.j();
        return arrayList;
    }

    static float g(c cVar) {
        c.b A = cVar.A();
        int i10 = a.f24470a[A.ordinal()];
        if (i10 == 1) {
            return (float) cVar.p();
        }
        if (i10 == 2) {
            cVar.b();
            float p10 = (float) cVar.p();
            while (cVar.m()) {
                cVar.G();
            }
            cVar.j();
            return p10;
        }
        throw new IllegalArgumentException("Unknown value for token of type " + A);
    }
}
