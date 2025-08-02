package n0;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.k0;
import com.airbnb.lottie.r0;
import java.util.List;
import o0.a;
import o0.d;
import r0.e;
import t0.l;
import t0.t;
import u0.b;
import y0.k;
import z0.c;

public class o implements a.b, k, m {

    /* renamed from: a  reason: collision with root package name */
    private final Path f22767a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f22768b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    private final String f22769c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f22770d;

    /* renamed from: e  reason: collision with root package name */
    private final k0 f22771e;

    /* renamed from: f  reason: collision with root package name */
    private final a f22772f;

    /* renamed from: g  reason: collision with root package name */
    private final a f22773g;

    /* renamed from: h  reason: collision with root package name */
    private final a f22774h;

    /* renamed from: i  reason: collision with root package name */
    private final b f22775i = new b();

    /* renamed from: j  reason: collision with root package name */
    private a f22776j = null;

    /* renamed from: k  reason: collision with root package name */
    private boolean f22777k;

    public o(k0 k0Var, b bVar, l lVar) {
        this.f22769c = lVar.c();
        this.f22770d = lVar.f();
        this.f22771e = k0Var;
        a a10 = lVar.d().a();
        this.f22772f = a10;
        a a11 = lVar.e().a();
        this.f22773g = a11;
        d d10 = lVar.b().a();
        this.f22774h = d10;
        bVar.i(a10);
        bVar.i(a11);
        bVar.i(d10);
        a10.a(this);
        a11.a(this);
        d10.a(this);
    }

    private void f() {
        this.f22777k = false;
        this.f22771e.invalidateSelf();
    }

    public void a() {
        f();
    }

    public void b(List list, List list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = (c) list.get(i10);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.j() == t.a.SIMULTANEOUSLY) {
                    this.f22775i.a(uVar);
                    uVar.c(this);
                }
            }
            if (cVar instanceof q) {
                this.f22776j = ((q) cVar).f();
            }
        }
    }

    public void c(Object obj, c cVar) {
        if (obj == r0.f17749l) {
            this.f22773g.o(cVar);
        } else if (obj == r0.f17751n) {
            this.f22772f.o(cVar);
        } else if (obj == r0.f17750m) {
            this.f22774h.o(cVar);
        }
    }

    public void d(e eVar, int i10, List list, e eVar2) {
        k.k(eVar, i10, list, eVar2, this);
    }

    public String getName() {
        return this.f22769c;
    }

    public Path getPath() {
        float f10;
        a aVar;
        if (this.f22777k) {
            return this.f22767a;
        }
        this.f22767a.reset();
        if (this.f22770d) {
            this.f22777k = true;
            return this.f22767a;
        }
        PointF pointF = (PointF) this.f22773g.h();
        float f11 = pointF.x / 2.0f;
        float f12 = pointF.y / 2.0f;
        a aVar2 = this.f22774h;
        if (aVar2 == null) {
            f10 = 0.0f;
        } else {
            f10 = ((d) aVar2).q();
        }
        if (f10 == 0.0f && (aVar = this.f22776j) != null) {
            f10 = Math.min(((Float) aVar.h()).floatValue(), Math.min(f11, f12));
        }
        float min = Math.min(f11, f12);
        if (f10 > min) {
            f10 = min;
        }
        PointF pointF2 = (PointF) this.f22772f.h();
        this.f22767a.moveTo(pointF2.x + f11, (pointF2.y - f12) + f10);
        this.f22767a.lineTo(pointF2.x + f11, (pointF2.y + f12) - f10);
        int i10 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
        if (i10 > 0) {
            RectF rectF = this.f22768b;
            float f13 = pointF2.x;
            float f14 = f10 * 2.0f;
            float f15 = pointF2.y;
            rectF.set((f13 + f11) - f14, (f15 + f12) - f14, f13 + f11, f15 + f12);
            this.f22767a.arcTo(this.f22768b, 0.0f, 90.0f, false);
        }
        this.f22767a.lineTo((pointF2.x - f11) + f10, pointF2.y + f12);
        if (i10 > 0) {
            RectF rectF2 = this.f22768b;
            float f16 = pointF2.x;
            float f17 = pointF2.y;
            float f18 = f10 * 2.0f;
            rectF2.set(f16 - f11, (f17 + f12) - f18, (f16 - f11) + f18, f17 + f12);
            this.f22767a.arcTo(this.f22768b, 90.0f, 90.0f, false);
        }
        this.f22767a.lineTo(pointF2.x - f11, (pointF2.y - f12) + f10);
        if (i10 > 0) {
            RectF rectF3 = this.f22768b;
            float f19 = pointF2.x;
            float f20 = pointF2.y;
            float f21 = f10 * 2.0f;
            rectF3.set(f19 - f11, f20 - f12, (f19 - f11) + f21, (f20 - f12) + f21);
            this.f22767a.arcTo(this.f22768b, 180.0f, 90.0f, false);
        }
        this.f22767a.lineTo((pointF2.x + f11) - f10, pointF2.y - f12);
        if (i10 > 0) {
            RectF rectF4 = this.f22768b;
            float f22 = pointF2.x;
            float f23 = f10 * 2.0f;
            float f24 = pointF2.y;
            rectF4.set((f22 + f11) - f23, f24 - f12, f22 + f11, (f24 - f12) + f23);
            this.f22767a.arcTo(this.f22768b, 270.0f, 90.0f, false);
        }
        this.f22767a.close();
        this.f22775i.b(this.f22767a);
        this.f22777k = true;
        return this.f22767a;
    }
}
