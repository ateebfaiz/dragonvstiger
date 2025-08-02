package n0;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.k0;
import com.airbnb.lottie.r0;
import java.util.List;
import o0.a;
import r0.e;
import t0.b;
import t0.t;
import y0.k;
import z0.c;

public class f implements m, a.b, k {

    /* renamed from: a  reason: collision with root package name */
    private final Path f22690a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f22691b;

    /* renamed from: c  reason: collision with root package name */
    private final k0 f22692c;

    /* renamed from: d  reason: collision with root package name */
    private final a f22693d;

    /* renamed from: e  reason: collision with root package name */
    private final a f22694e;

    /* renamed from: f  reason: collision with root package name */
    private final b f22695f;

    /* renamed from: g  reason: collision with root package name */
    private final b f22696g = new b();

    /* renamed from: h  reason: collision with root package name */
    private boolean f22697h;

    public f(k0 k0Var, u0.b bVar, b bVar2) {
        this.f22691b = bVar2.b();
        this.f22692c = k0Var;
        a a10 = bVar2.d().a();
        this.f22693d = a10;
        a a11 = bVar2.c().a();
        this.f22694e = a11;
        this.f22695f = bVar2;
        bVar.i(a10);
        bVar.i(a11);
        a10.a(this);
        a11.a(this);
    }

    private void f() {
        this.f22697h = false;
        this.f22692c.invalidateSelf();
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
                    this.f22696g.a(uVar);
                    uVar.c(this);
                }
            }
        }
    }

    public void c(Object obj, c cVar) {
        if (obj == r0.f17748k) {
            this.f22693d.o(cVar);
        } else if (obj == r0.f17751n) {
            this.f22694e.o(cVar);
        }
    }

    public void d(e eVar, int i10, List list, e eVar2) {
        k.k(eVar, i10, list, eVar2, this);
    }

    public String getName() {
        return this.f22691b;
    }

    public Path getPath() {
        if (this.f22697h) {
            return this.f22690a;
        }
        this.f22690a.reset();
        if (this.f22695f.e()) {
            this.f22697h = true;
            return this.f22690a;
        }
        PointF pointF = (PointF) this.f22693d.h();
        float f10 = pointF.x / 2.0f;
        float f11 = pointF.y / 2.0f;
        float f12 = f10 * 0.55228f;
        float f13 = 0.55228f * f11;
        this.f22690a.reset();
        if (this.f22695f.f()) {
            float f14 = -f11;
            this.f22690a.moveTo(0.0f, f14);
            float f15 = 0.0f - f12;
            float f16 = -f10;
            float f17 = 0.0f - f13;
            this.f22690a.cubicTo(f15, f14, f16, f17, f16, 0.0f);
            float f18 = f13 + 0.0f;
            float f19 = f14;
            this.f22690a.cubicTo(f16, f18, f15, f11, 0.0f, f11);
            float f20 = f12 + 0.0f;
            this.f22690a.cubicTo(f20, f11, f10, f18, f10, 0.0f);
            this.f22690a.cubicTo(f10, f17, f20, f19, 0.0f, f19);
        } else {
            float f21 = -f11;
            this.f22690a.moveTo(0.0f, f21);
            float f22 = f12 + 0.0f;
            float f23 = 0.0f - f13;
            this.f22690a.cubicTo(f22, f21, f10, f23, f10, 0.0f);
            float f24 = f13 + 0.0f;
            this.f22690a.cubicTo(f10, f24, f22, f11, 0.0f, f11);
            float f25 = 0.0f - f12;
            float f26 = -f10;
            this.f22690a.cubicTo(f25, f11, f26, f24, f26, 0.0f);
            float f27 = f21;
            this.f22690a.cubicTo(f26, f23, f25, f27, 0.0f, f27);
        }
        PointF pointF2 = (PointF) this.f22694e.h();
        this.f22690a.offset(pointF2.x, pointF2.y);
        this.f22690a.close();
        this.f22696g.b(this.f22690a);
        this.f22697h = true;
        return this.f22690a;
    }
}
