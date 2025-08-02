package n0;

import android.graphics.PointF;
import com.airbnb.lottie.k0;
import java.util.ArrayList;
import java.util.List;
import o0.a;
import t0.n;
import t0.o;
import u0.b;

public class q implements s, a.b {

    /* renamed from: a  reason: collision with root package name */
    private final k0 f22788a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22789b;

    /* renamed from: c  reason: collision with root package name */
    private final a f22790c;

    /* renamed from: d  reason: collision with root package name */
    private o f22791d;

    public q(k0 k0Var, b bVar, n nVar) {
        this.f22788a = k0Var;
        this.f22789b = nVar.c();
        a a10 = nVar.b().a();
        this.f22790c = a10;
        bVar.i(a10);
        a10.a(this);
    }

    private static int c(int i10, int i11) {
        int i12 = i10 / i11;
        if ((i10 ^ i11) >= 0 || i11 * i12 == i10) {
            return i12;
        }
        return i12 - 1;
    }

    private static int d(int i10, int i11) {
        return i10 - (c(i10, i11) * i11);
    }

    private o i(o oVar) {
        PointF pointF;
        PointF pointF2;
        boolean z10;
        List a10 = oVar.a();
        boolean d10 = oVar.d();
        int i10 = 0;
        for (int size = a10.size() - 1; size >= 0; size--) {
            r0.a aVar = (r0.a) a10.get(size);
            r0.a aVar2 = (r0.a) a10.get(d(size - 1, a10.size()));
            if (size != 0 || d10) {
                pointF = aVar2.c();
            } else {
                pointF = oVar.b();
            }
            if (size != 0 || d10) {
                pointF2 = aVar2.b();
            } else {
                pointF2 = pointF;
            }
            PointF a11 = aVar.a();
            if (oVar.d() || !(size == 0 || size == a10.size() - 1)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!pointF2.equals(pointF) || !a11.equals(pointF) || z10) {
                i10++;
            } else {
                i10 += 2;
            }
        }
        o oVar2 = this.f22791d;
        if (oVar2 == null || oVar2.a().size() != i10) {
            ArrayList arrayList = new ArrayList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                arrayList.add(new r0.a());
            }
            this.f22791d = new o(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.f22791d.e(d10);
        return this.f22791d;
    }

    public void a() {
        this.f22788a.invalidateSelf();
    }

    public void b(List list, List list2) {
    }

    public a f() {
        return this.f22790c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009c, code lost:
        if (r7 != (r0.size() - 1)) goto L_0x009f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public t0.o h(t0.o r19) {
        /*
            r18 = this;
            java.util.List r0 = r19.a()
            int r1 = r0.size()
            r2 = 2
            if (r1 > r2) goto L_0x000c
            return r19
        L_0x000c:
            r1 = r18
            o0.a r2 = r1.f22790c
            java.lang.Object r2 = r2.h()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            r3 = 0
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x0020
            return r19
        L_0x0020:
            t0.o r3 = r18.i(r19)
            android.graphics.PointF r4 = r19.b()
            float r4 = r4.x
            android.graphics.PointF r5 = r19.b()
            float r5 = r5.y
            r3.f(r4, r5)
            java.util.List r4 = r3.a()
            boolean r5 = r19.d()
            r7 = 0
            r8 = 0
        L_0x003d:
            int r9 = r0.size()
            if (r7 >= r9) goto L_0x0195
            java.lang.Object r9 = r0.get(r7)
            r0.a r9 = (r0.a) r9
            int r10 = r7 + -1
            int r11 = r0.size()
            int r10 = d(r10, r11)
            java.lang.Object r10 = r0.get(r10)
            r0.a r10 = (r0.a) r10
            int r11 = r7 + -2
            int r12 = r0.size()
            int r11 = d(r11, r12)
            java.lang.Object r11 = r0.get(r11)
            r0.a r11 = (r0.a) r11
            if (r7 != 0) goto L_0x0072
            if (r5 != 0) goto L_0x0072
            android.graphics.PointF r12 = r19.b()
            goto L_0x0076
        L_0x0072:
            android.graphics.PointF r12 = r10.c()
        L_0x0076:
            if (r7 != 0) goto L_0x007c
            if (r5 != 0) goto L_0x007c
            r13 = r12
            goto L_0x0080
        L_0x007c:
            android.graphics.PointF r13 = r10.b()
        L_0x0080:
            android.graphics.PointF r14 = r9.a()
            android.graphics.PointF r11 = r11.c()
            android.graphics.PointF r15 = r9.c()
            boolean r16 = r19.d()
            if (r16 != 0) goto L_0x009f
            r16 = 1
            if (r7 == 0) goto L_0x00a1
            int r17 = r0.size()
            int r6 = r17 + -1
            if (r7 != r6) goto L_0x009f
            goto L_0x00a1
        L_0x009f:
            r16 = 0
        L_0x00a1:
            boolean r6 = r13.equals(r12)
            if (r6 == 0) goto L_0x0146
            boolean r6 = r14.equals(r12)
            if (r6 == 0) goto L_0x0146
            if (r16 != 0) goto L_0x0146
            float r6 = r12.x
            float r9 = r11.x
            float r9 = r6 - r9
            float r10 = r12.y
            float r13 = r11.y
            float r13 = r10 - r13
            float r14 = r15.x
            float r14 = r14 - r6
            float r6 = r15.y
            float r6 = r6 - r10
            double r9 = (double) r9
            r16 = r0
            double r0 = (double) r13
            double r0 = java.lang.Math.hypot(r9, r0)
            float r0 = (float) r0
            double r9 = (double) r14
            double r13 = (double) r6
            double r9 = java.lang.Math.hypot(r9, r13)
            float r1 = (float) r9
            float r0 = r2 / r0
            r6 = 1056964608(0x3f000000, float:0.5)
            float r0 = java.lang.Math.min(r0, r6)
            float r1 = r2 / r1
            float r1 = java.lang.Math.min(r1, r6)
            float r6 = r12.x
            float r9 = r11.x
            float r9 = r9 - r6
            float r9 = r9 * r0
            float r9 = r9 + r6
            float r10 = r12.y
            float r11 = r11.y
            float r11 = r11 - r10
            float r11 = r11 * r0
            float r11 = r11 + r10
            float r0 = r15.x
            float r0 = r0 - r6
            float r0 = r0 * r1
            float r0 = r0 + r6
            float r12 = r15.y
            float r12 = r12 - r10
            float r12 = r12 * r1
            float r12 = r12 + r10
            float r1 = r9 - r6
            r13 = 1057835346(0x3f0d4952, float:0.5519)
            float r1 = r1 * r13
            float r1 = r9 - r1
            float r14 = r11 - r10
            float r14 = r14 * r13
            float r14 = r11 - r14
            float r6 = r0 - r6
            float r6 = r6 * r13
            float r6 = r0 - r6
            float r10 = r12 - r10
            float r10 = r10 * r13
            float r10 = r12 - r10
            int r13 = r8 + -1
            int r15 = r4.size()
            int r13 = d(r13, r15)
            java.lang.Object r13 = r4.get(r13)
            r0.a r13 = (r0.a) r13
            java.lang.Object r15 = r4.get(r8)
            r0.a r15 = (r0.a) r15
            r13.e(r9, r11)
            r13.f(r9, r11)
            if (r7 != 0) goto L_0x012f
            r3.f(r9, r11)
        L_0x012f:
            r15.d(r1, r14)
            int r1 = r8 + 1
            java.lang.Object r1 = r4.get(r1)
            r0.a r1 = (r0.a) r1
            r15.e(r6, r10)
            r15.f(r0, r12)
            r1.d(r0, r12)
            int r8 = r8 + 2
            goto L_0x018d
        L_0x0146:
            r16 = r0
            int r0 = r8 + -1
            int r1 = r4.size()
            int r0 = d(r0, r1)
            java.lang.Object r0 = r4.get(r0)
            r0.a r0 = (r0.a) r0
            java.lang.Object r1 = r4.get(r8)
            r0.a r1 = (r0.a) r1
            android.graphics.PointF r6 = r10.b()
            float r6 = r6.x
            android.graphics.PointF r11 = r10.b()
            float r11 = r11.y
            r0.e(r6, r11)
            android.graphics.PointF r6 = r10.c()
            float r6 = r6.x
            android.graphics.PointF r10 = r10.c()
            float r10 = r10.y
            r0.f(r6, r10)
            android.graphics.PointF r0 = r9.a()
            float r0 = r0.x
            android.graphics.PointF r6 = r9.a()
            float r6 = r6.y
            r1.d(r0, r6)
            int r8 = r8 + 1
        L_0x018d:
            int r7 = r7 + 1
            r1 = r18
            r0 = r16
            goto L_0x003d
        L_0x0195:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.q.h(t0.o):t0.o");
    }
}
