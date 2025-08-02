package n0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.k0;
import com.airbnb.lottie.r0;
import java.util.List;
import o0.a;
import o0.d;
import r0.e;
import t0.m;
import u0.b;
import y0.k;
import z0.c;

public class p implements e, m, j, a.b, k {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f22778a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Path f22779b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final k0 f22780c;

    /* renamed from: d  reason: collision with root package name */
    private final b f22781d;

    /* renamed from: e  reason: collision with root package name */
    private final String f22782e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f22783f;

    /* renamed from: g  reason: collision with root package name */
    private final a f22784g;

    /* renamed from: h  reason: collision with root package name */
    private final a f22785h;

    /* renamed from: i  reason: collision with root package name */
    private final o0.p f22786i;

    /* renamed from: j  reason: collision with root package name */
    private d f22787j;

    public p(k0 k0Var, b bVar, m mVar) {
        this.f22780c = k0Var;
        this.f22781d = bVar;
        this.f22782e = mVar.c();
        this.f22783f = mVar.f();
        d d10 = mVar.b().a();
        this.f22784g = d10;
        bVar.i(d10);
        d10.a(this);
        d d11 = mVar.d().a();
        this.f22785h = d11;
        bVar.i(d11);
        d11.a(this);
        o0.p b10 = mVar.e().b();
        this.f22786i = b10;
        b10.a(bVar);
        b10.b(this);
    }

    public void a() {
        this.f22780c.invalidateSelf();
    }

    public void b(List list, List list2) {
        this.f22787j.b(list, list2);
    }

    public void c(Object obj, c cVar) {
        if (!this.f22786i.c(obj, cVar)) {
            if (obj == r0.f17758u) {
                this.f22784g.o(cVar);
            } else if (obj == r0.f17759v) {
                this.f22785h.o(cVar);
            }
        }
    }

    public void d(e eVar, int i10, List list, e eVar2) {
        k.k(eVar, i10, list, eVar2, this);
        for (int i11 = 0; i11 < this.f22787j.j().size(); i11++) {
            c cVar = (c) this.f22787j.j().get(i11);
            if (cVar instanceof k) {
                k.k(eVar, i10, list, eVar2, (k) cVar);
            }
        }
    }

    public void e(RectF rectF, Matrix matrix, boolean z10) {
        this.f22787j.e(rectF, matrix, z10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0005 A[LOOP:0: B:3:0x0005->B:6:0x000f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(java.util.ListIterator r9) {
        /*
            r8 = this;
            n0.d r0 = r8.f22787j
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r9.hasPrevious()
            if (r0 == 0) goto L_0x0012
            java.lang.Object r0 = r9.previous()
            if (r0 == r8) goto L_0x0012
            goto L_0x0005
        L_0x0012:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x0017:
            boolean r0 = r9.hasPrevious()
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r9.previous()
            n0.c r0 = (n0.c) r0
            r6.add(r0)
            r9.remove()
            goto L_0x0017
        L_0x002a:
            java.util.Collections.reverse(r6)
            n0.d r9 = new n0.d
            com.airbnb.lottie.k0 r2 = r8.f22780c
            u0.b r3 = r8.f22781d
            boolean r5 = r8.f22783f
            r7 = 0
            java.lang.String r4 = "Repeater"
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r8.f22787j = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.p.f(java.util.ListIterator):void");
    }

    public void g(Canvas canvas, Matrix matrix, int i10) {
        float floatValue = ((Float) this.f22784g.h()).floatValue();
        float floatValue2 = ((Float) this.f22785h.h()).floatValue();
        float floatValue3 = ((Float) this.f22786i.i().h()).floatValue() / 100.0f;
        float floatValue4 = ((Float) this.f22786i.e().h()).floatValue() / 100.0f;
        for (int i11 = ((int) floatValue) - 1; i11 >= 0; i11--) {
            this.f22778a.set(matrix);
            float f10 = (float) i11;
            this.f22778a.preConcat(this.f22786i.g(f10 + floatValue2));
            this.f22787j.g(canvas, this.f22778a, (int) (((float) i10) * k.i(floatValue3, floatValue4, f10 / floatValue)));
        }
    }

    public String getName() {
        return this.f22782e;
    }

    public Path getPath() {
        Path path = this.f22787j.getPath();
        this.f22779b.reset();
        float floatValue = ((Float) this.f22784g.h()).floatValue();
        float floatValue2 = ((Float) this.f22785h.h()).floatValue();
        for (int i10 = ((int) floatValue) - 1; i10 >= 0; i10--) {
            this.f22778a.set(this.f22786i.g(((float) i10) + floatValue2));
            this.f22779b.addPath(path, this.f22778a);
        }
        return this.f22779b;
    }
}
