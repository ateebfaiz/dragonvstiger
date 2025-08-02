package o0;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.r0;
import java.util.Collections;
import o0.a;
import s0.n;
import u0.b;
import z0.c;
import z0.d;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f22934a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f22935b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f22936c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f22937d;

    /* renamed from: e  reason: collision with root package name */
    private final float[] f22938e;

    /* renamed from: f  reason: collision with root package name */
    private a f22939f;

    /* renamed from: g  reason: collision with root package name */
    private a f22940g;

    /* renamed from: h  reason: collision with root package name */
    private a f22941h;

    /* renamed from: i  reason: collision with root package name */
    private a f22942i;

    /* renamed from: j  reason: collision with root package name */
    private a f22943j;

    /* renamed from: k  reason: collision with root package name */
    private d f22944k;

    /* renamed from: l  reason: collision with root package name */
    private d f22945l;

    /* renamed from: m  reason: collision with root package name */
    private a f22946m;

    /* renamed from: n  reason: collision with root package name */
    private a f22947n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f22948o;

    public p(n nVar) {
        a aVar;
        a aVar2;
        a aVar3;
        d dVar;
        d dVar2;
        d dVar3;
        if (nVar.c() == null) {
            aVar = null;
        } else {
            aVar = nVar.c().a();
        }
        this.f22939f = aVar;
        if (nVar.f() == null) {
            aVar2 = null;
        } else {
            aVar2 = nVar.f().a();
        }
        this.f22940g = aVar2;
        if (nVar.h() == null) {
            aVar3 = null;
        } else {
            aVar3 = nVar.h().a();
        }
        this.f22941h = aVar3;
        if (nVar.g() == null) {
            dVar = null;
        } else {
            dVar = nVar.g().a();
        }
        this.f22942i = dVar;
        if (nVar.i() == null) {
            dVar2 = null;
        } else {
            dVar2 = nVar.i().a();
        }
        this.f22944k = dVar2;
        this.f22948o = nVar.l();
        if (this.f22944k != null) {
            this.f22935b = new Matrix();
            this.f22936c = new Matrix();
            this.f22937d = new Matrix();
            this.f22938e = new float[9];
        } else {
            this.f22935b = null;
            this.f22936c = null;
            this.f22937d = null;
            this.f22938e = null;
        }
        if (nVar.j() == null) {
            dVar3 = null;
        } else {
            dVar3 = nVar.j().a();
        }
        this.f22945l = dVar3;
        if (nVar.e() != null) {
            this.f22943j = nVar.e().a();
        }
        if (nVar.k() != null) {
            this.f22946m = nVar.k().a();
        } else {
            this.f22946m = null;
        }
        if (nVar.d() != null) {
            this.f22947n = nVar.d().a();
        } else {
            this.f22947n = null;
        }
    }

    private void d() {
        for (int i10 = 0; i10 < 9; i10++) {
            this.f22938e[i10] = 0.0f;
        }
    }

    public void a(b bVar) {
        bVar.i(this.f22943j);
        bVar.i(this.f22946m);
        bVar.i(this.f22947n);
        bVar.i(this.f22939f);
        bVar.i(this.f22940g);
        bVar.i(this.f22941h);
        bVar.i(this.f22942i);
        bVar.i(this.f22944k);
        bVar.i(this.f22945l);
    }

    public void b(a.b bVar) {
        a aVar = this.f22943j;
        if (aVar != null) {
            aVar.a(bVar);
        }
        a aVar2 = this.f22946m;
        if (aVar2 != null) {
            aVar2.a(bVar);
        }
        a aVar3 = this.f22947n;
        if (aVar3 != null) {
            aVar3.a(bVar);
        }
        a aVar4 = this.f22939f;
        if (aVar4 != null) {
            aVar4.a(bVar);
        }
        a aVar5 = this.f22940g;
        if (aVar5 != null) {
            aVar5.a(bVar);
        }
        a aVar6 = this.f22941h;
        if (aVar6 != null) {
            aVar6.a(bVar);
        }
        a aVar7 = this.f22942i;
        if (aVar7 != null) {
            aVar7.a(bVar);
        }
        d dVar = this.f22944k;
        if (dVar != null) {
            dVar.a(bVar);
        }
        d dVar2 = this.f22945l;
        if (dVar2 != null) {
            dVar2.a(bVar);
        }
    }

    public boolean c(Object obj, c cVar) {
        if (obj == r0.f17743f) {
            a aVar = this.f22939f;
            if (aVar == null) {
                this.f22939f = new q(cVar, new PointF());
                return true;
            }
            aVar.o(cVar);
            return true;
        } else if (obj == r0.f17744g) {
            a aVar2 = this.f22940g;
            if (aVar2 == null) {
                this.f22940g = new q(cVar, new PointF());
                return true;
            }
            aVar2.o(cVar);
            return true;
        } else {
            if (obj == r0.f17745h) {
                a aVar3 = this.f22940g;
                if (aVar3 instanceof n) {
                    ((n) aVar3).s(cVar);
                    return true;
                }
            }
            if (obj == r0.f17746i) {
                a aVar4 = this.f22940g;
                if (aVar4 instanceof n) {
                    ((n) aVar4).t(cVar);
                    return true;
                }
            }
            if (obj == r0.f17752o) {
                a aVar5 = this.f22941h;
                if (aVar5 == null) {
                    this.f22941h = new q(cVar, new d());
                    return true;
                }
                aVar5.o(cVar);
                return true;
            } else if (obj == r0.f17753p) {
                a aVar6 = this.f22942i;
                if (aVar6 == null) {
                    this.f22942i = new q(cVar, Float.valueOf(0.0f));
                    return true;
                }
                aVar6.o(cVar);
                return true;
            } else if (obj == r0.f17740c) {
                a aVar7 = this.f22943j;
                if (aVar7 == null) {
                    this.f22943j = new q(cVar, 100);
                    return true;
                }
                aVar7.o(cVar);
                return true;
            } else if (obj == r0.C) {
                a aVar8 = this.f22946m;
                if (aVar8 == null) {
                    this.f22946m = new q(cVar, Float.valueOf(100.0f));
                    return true;
                }
                aVar8.o(cVar);
                return true;
            } else if (obj == r0.D) {
                a aVar9 = this.f22947n;
                if (aVar9 == null) {
                    this.f22947n = new q(cVar, Float.valueOf(100.0f));
                    return true;
                }
                aVar9.o(cVar);
                return true;
            } else if (obj == r0.f17754q) {
                if (this.f22944k == null) {
                    this.f22944k = new d(Collections.singletonList(new z0.a(Float.valueOf(0.0f))));
                }
                this.f22944k.o(cVar);
                return true;
            } else if (obj != r0.f17755r) {
                return false;
            } else {
                if (this.f22945l == null) {
                    this.f22945l = new d(Collections.singletonList(new z0.a(Float.valueOf(0.0f))));
                }
                this.f22945l.o(cVar);
                return true;
            }
        }
    }

    public a e() {
        return this.f22947n;
    }

    public Matrix f() {
        PointF pointF;
        d dVar;
        float f10;
        float f11;
        float f12;
        PointF pointF2;
        this.f22934a.reset();
        a aVar = this.f22940g;
        if (!(aVar == null || (pointF2 = (PointF) aVar.h()) == null)) {
            float f13 = pointF2.x;
            if (!(f13 == 0.0f && pointF2.y == 0.0f)) {
                this.f22934a.preTranslate(f13, pointF2.y);
            }
        }
        if (!this.f22948o) {
            a aVar2 = this.f22942i;
            if (aVar2 != null) {
                if (aVar2 instanceof q) {
                    f12 = ((Float) aVar2.h()).floatValue();
                } else {
                    f12 = ((d) aVar2).q();
                }
                if (f12 != 0.0f) {
                    this.f22934a.preRotate(f12);
                }
            }
        } else if (aVar != null) {
            float f14 = aVar.f();
            PointF pointF3 = (PointF) aVar.h();
            float f15 = pointF3.x;
            float f16 = pointF3.y;
            aVar.n(1.0E-4f + f14);
            PointF pointF4 = (PointF) aVar.h();
            aVar.n(f14);
            this.f22934a.preRotate((float) Math.toDegrees(Math.atan2((double) (pointF4.y - f16), (double) (pointF4.x - f15))));
        }
        d dVar2 = this.f22944k;
        if (dVar2 != null) {
            d dVar3 = this.f22945l;
            if (dVar3 == null) {
                f10 = 0.0f;
            } else {
                f10 = (float) Math.cos(Math.toRadians((double) ((-dVar3.q()) + 90.0f)));
            }
            d dVar4 = this.f22945l;
            if (dVar4 == null) {
                f11 = 1.0f;
            } else {
                f11 = (float) Math.sin(Math.toRadians((double) ((-dVar4.q()) + 90.0f)));
            }
            float tan = (float) Math.tan(Math.toRadians((double) dVar2.q()));
            d();
            float[] fArr = this.f22938e;
            fArr[0] = f10;
            fArr[1] = f11;
            float f17 = -f11;
            fArr[3] = f17;
            fArr[4] = f10;
            fArr[8] = 1.0f;
            this.f22935b.setValues(fArr);
            d();
            float[] fArr2 = this.f22938e;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f22936c.setValues(fArr2);
            d();
            float[] fArr3 = this.f22938e;
            fArr3[0] = f10;
            fArr3[1] = f17;
            fArr3[3] = f11;
            fArr3[4] = f10;
            fArr3[8] = 1.0f;
            this.f22937d.setValues(fArr3);
            this.f22936c.preConcat(this.f22935b);
            this.f22937d.preConcat(this.f22936c);
            this.f22934a.preConcat(this.f22937d);
        }
        a aVar3 = this.f22941h;
        if (!(aVar3 == null || (dVar = (d) aVar3.h()) == null || (dVar.b() == 1.0f && dVar.c() == 1.0f))) {
            this.f22934a.preScale(dVar.b(), dVar.c());
        }
        a aVar4 = this.f22939f;
        if (!(aVar4 == null || (pointF = (PointF) aVar4.h()) == null)) {
            float f18 = pointF.x;
            if (!(f18 == 0.0f && pointF.y == 0.0f)) {
                this.f22934a.preTranslate(-f18, -pointF.y);
            }
        }
        return this.f22934a;
    }

    public Matrix g(float f10) {
        PointF pointF;
        d dVar;
        float f11;
        a aVar = this.f22940g;
        PointF pointF2 = null;
        if (aVar == null) {
            pointF = null;
        } else {
            pointF = (PointF) aVar.h();
        }
        a aVar2 = this.f22941h;
        if (aVar2 == null) {
            dVar = null;
        } else {
            dVar = (d) aVar2.h();
        }
        this.f22934a.reset();
        if (pointF != null) {
            this.f22934a.preTranslate(pointF.x * f10, pointF.y * f10);
        }
        if (dVar != null) {
            double d10 = (double) f10;
            this.f22934a.preScale((float) Math.pow((double) dVar.b(), d10), (float) Math.pow((double) dVar.c(), d10));
        }
        a aVar3 = this.f22942i;
        if (aVar3 != null) {
            float floatValue = ((Float) aVar3.h()).floatValue();
            a aVar4 = this.f22939f;
            if (aVar4 != null) {
                pointF2 = (PointF) aVar4.h();
            }
            Matrix matrix = this.f22934a;
            float f12 = floatValue * f10;
            float f13 = 0.0f;
            if (pointF2 == null) {
                f11 = 0.0f;
            } else {
                f11 = pointF2.x;
            }
            if (pointF2 != null) {
                f13 = pointF2.y;
            }
            matrix.preRotate(f12, f11, f13);
        }
        return this.f22934a;
    }

    public a h() {
        return this.f22943j;
    }

    public a i() {
        return this.f22946m;
    }

    public void j(float f10) {
        a aVar = this.f22943j;
        if (aVar != null) {
            aVar.n(f10);
        }
        a aVar2 = this.f22946m;
        if (aVar2 != null) {
            aVar2.n(f10);
        }
        a aVar3 = this.f22947n;
        if (aVar3 != null) {
            aVar3.n(f10);
        }
        a aVar4 = this.f22939f;
        if (aVar4 != null) {
            aVar4.n(f10);
        }
        a aVar5 = this.f22940g;
        if (aVar5 != null) {
            aVar5.n(f10);
        }
        a aVar6 = this.f22941h;
        if (aVar6 != null) {
            aVar6.n(f10);
        }
        a aVar7 = this.f22942i;
        if (aVar7 != null) {
            aVar7.n(f10);
        }
        d dVar = this.f22944k;
        if (dVar != null) {
            dVar.n(f10);
        }
        d dVar2 = this.f22945l;
        if (dVar2 != null) {
            dVar2.n(f10);
        }
    }
}
