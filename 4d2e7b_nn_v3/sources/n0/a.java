package n0;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.e;
import com.airbnb.lottie.k0;
import com.airbnb.lottie.r0;
import java.util.ArrayList;
import java.util.List;
import o0.a;
import o0.c;
import o0.f;
import o0.q;
import s0.d;
import t0.t;
import y0.k;
import y0.l;

public abstract class a implements a.b, k, e {

    /* renamed from: a  reason: collision with root package name */
    private final PathMeasure f22659a = new PathMeasure();

    /* renamed from: b  reason: collision with root package name */
    private final Path f22660b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f22661c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final RectF f22662d = new RectF();

    /* renamed from: e  reason: collision with root package name */
    private final k0 f22663e;

    /* renamed from: f  reason: collision with root package name */
    protected final u0.b f22664f;

    /* renamed from: g  reason: collision with root package name */
    private final List f22665g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final float[] f22666h;

    /* renamed from: i  reason: collision with root package name */
    final Paint f22667i;

    /* renamed from: j  reason: collision with root package name */
    private final o0.a f22668j;

    /* renamed from: k  reason: collision with root package name */
    private final o0.a f22669k;

    /* renamed from: l  reason: collision with root package name */
    private final List f22670l;

    /* renamed from: m  reason: collision with root package name */
    private final o0.a f22671m;

    /* renamed from: n  reason: collision with root package name */
    private o0.a f22672n;

    /* renamed from: o  reason: collision with root package name */
    private o0.a f22673o;

    /* renamed from: p  reason: collision with root package name */
    float f22674p;

    /* renamed from: q  reason: collision with root package name */
    private c f22675q;

    private static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final List f22676a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final u f22677b;

        private b(u uVar) {
            this.f22676a = new ArrayList();
            this.f22677b = uVar;
        }
    }

    a(k0 k0Var, u0.b bVar, Paint.Cap cap, Paint.Join join, float f10, d dVar, s0.b bVar2, List list, s0.b bVar3) {
        m0.a aVar = new m0.a(1);
        this.f22667i = aVar;
        this.f22674p = 0.0f;
        this.f22663e = k0Var;
        this.f22664f = bVar;
        aVar.setStyle(Paint.Style.STROKE);
        aVar.setStrokeCap(cap);
        aVar.setStrokeJoin(join);
        aVar.setStrokeMiter(f10);
        this.f22669k = dVar.a();
        this.f22668j = bVar2.a();
        if (bVar3 == null) {
            this.f22671m = null;
        } else {
            this.f22671m = bVar3.a();
        }
        this.f22670l = new ArrayList(list.size());
        this.f22666h = new float[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.f22670l.add(((s0.b) list.get(i10)).a());
        }
        bVar.i(this.f22669k);
        bVar.i(this.f22668j);
        for (int i11 = 0; i11 < this.f22670l.size(); i11++) {
            bVar.i((o0.a) this.f22670l.get(i11));
        }
        o0.a aVar2 = this.f22671m;
        if (aVar2 != null) {
            bVar.i(aVar2);
        }
        this.f22669k.a(this);
        this.f22668j.a(this);
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((o0.a) this.f22670l.get(i12)).a(this);
        }
        o0.a aVar3 = this.f22671m;
        if (aVar3 != null) {
            aVar3.a(this);
        }
        if (bVar.w() != null) {
            o0.d d10 = bVar.w().a().a();
            this.f22673o = d10;
            d10.a(this);
            bVar.i(this.f22673o);
        }
        if (bVar.y() != null) {
            this.f22675q = new c(this, bVar, bVar.y());
        }
    }

    private void f() {
        float f10;
        if (e.h()) {
            e.b("StrokeContent#applyDashPattern");
        }
        if (!this.f22670l.isEmpty()) {
            for (int i10 = 0; i10 < this.f22670l.size(); i10++) {
                this.f22666h[i10] = ((Float) ((o0.a) this.f22670l.get(i10)).h()).floatValue();
                if (i10 % 2 == 0) {
                    float[] fArr = this.f22666h;
                    if (fArr[i10] < 1.0f) {
                        fArr[i10] = 1.0f;
                    }
                } else {
                    float[] fArr2 = this.f22666h;
                    if (fArr2[i10] < 0.1f) {
                        fArr2[i10] = 0.1f;
                    }
                }
            }
            o0.a aVar = this.f22671m;
            if (aVar == null) {
                f10 = 0.0f;
            } else {
                f10 = ((Float) aVar.h()).floatValue();
            }
            this.f22667i.setPathEffect(new DashPathEffect(this.f22666h, f10));
            if (e.h()) {
                e.c("StrokeContent#applyDashPattern");
            }
        } else if (e.h()) {
            e.c("StrokeContent#applyDashPattern");
        }
    }

    private void i(Canvas canvas, b bVar) {
        float f10;
        float f11;
        float f12;
        if (e.h()) {
            e.b("StrokeContent#applyTrimPath");
        }
        if (bVar.f22677b != null) {
            this.f22660b.reset();
            for (int size = bVar.f22676a.size() - 1; size >= 0; size--) {
                this.f22660b.addPath(((m) bVar.f22676a.get(size)).getPath());
            }
            float floatValue = ((Float) bVar.f22677b.i().h()).floatValue() / 100.0f;
            float floatValue2 = ((Float) bVar.f22677b.d().h()).floatValue() / 100.0f;
            float floatValue3 = ((Float) bVar.f22677b.f().h()).floatValue() / 360.0f;
            if (floatValue >= 0.01f || floatValue2 <= 0.99f) {
                this.f22659a.setPath(this.f22660b, false);
                float length = this.f22659a.getLength();
                while (this.f22659a.nextContour()) {
                    length += this.f22659a.getLength();
                }
                float f13 = floatValue3 * length;
                float f14 = (floatValue * length) + f13;
                float min = Math.min((floatValue2 * length) + f13, (f14 + length) - 1.0f);
                float f15 = 0.0f;
                for (int size2 = bVar.f22676a.size() - 1; size2 >= 0; size2--) {
                    this.f22661c.set(((m) bVar.f22676a.get(size2)).getPath());
                    this.f22659a.setPath(this.f22661c, false);
                    float length2 = this.f22659a.getLength();
                    if (min > length) {
                        float f16 = min - length;
                        if (f16 < f15 + length2 && f15 < f16) {
                            if (f14 > length) {
                                f12 = (f14 - length) / length2;
                            } else {
                                f12 = 0.0f;
                            }
                            l.a(this.f22661c, f12, Math.min(f16 / length2, 1.0f), 0.0f);
                            canvas.drawPath(this.f22661c, this.f22667i);
                            f15 += length2;
                        }
                    }
                    float f17 = f15 + length2;
                    if (f17 >= f14 && f15 <= min) {
                        if (f17 > min || f14 >= f15) {
                            if (f14 < f15) {
                                f10 = 0.0f;
                            } else {
                                f10 = (f14 - f15) / length2;
                            }
                            if (min > f17) {
                                f11 = 1.0f;
                            } else {
                                f11 = (min - f15) / length2;
                            }
                            l.a(this.f22661c, f10, f11, 0.0f);
                            canvas.drawPath(this.f22661c, this.f22667i);
                        } else {
                            canvas.drawPath(this.f22661c, this.f22667i);
                        }
                    }
                    f15 += length2;
                }
                if (e.h()) {
                    e.c("StrokeContent#applyTrimPath");
                    return;
                }
                return;
            }
            canvas.drawPath(this.f22660b, this.f22667i);
            if (e.h()) {
                e.c("StrokeContent#applyTrimPath");
            }
        } else if (e.h()) {
            e.c("StrokeContent#applyTrimPath");
        }
    }

    public void a() {
        this.f22663e.invalidateSelf();
    }

    public void b(List list, List list2) {
        u uVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = (c) list.get(size);
            if (cVar instanceof u) {
                u uVar2 = (u) cVar;
                if (uVar2.j() == t.a.INDIVIDUALLY) {
                    uVar = uVar2;
                }
            }
        }
        if (uVar != null) {
            uVar.c(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = (c) list2.get(size2);
            if (cVar2 instanceof u) {
                u uVar3 = (u) cVar2;
                if (uVar3.j() == t.a.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f22665g.add(bVar);
                    }
                    bVar = new b(uVar3);
                    uVar3.c(this);
                }
            }
            if (cVar2 instanceof m) {
                if (bVar == null) {
                    bVar = new b(uVar);
                }
                bVar.f22676a.add((m) cVar2);
            }
        }
        if (bVar != null) {
            this.f22665g.add(bVar);
        }
    }

    public void c(Object obj, z0.c cVar) {
        c cVar2;
        c cVar3;
        c cVar4;
        c cVar5;
        c cVar6;
        if (obj == r0.f17741d) {
            this.f22669k.o(cVar);
        } else if (obj == r0.f17756s) {
            this.f22668j.o(cVar);
        } else if (obj == r0.K) {
            o0.a aVar = this.f22672n;
            if (aVar != null) {
                this.f22664f.H(aVar);
            }
            if (cVar == null) {
                this.f22672n = null;
                return;
            }
            q qVar = new q(cVar);
            this.f22672n = qVar;
            qVar.a(this);
            this.f22664f.i(this.f22672n);
        } else if (obj == r0.f17747j) {
            o0.a aVar2 = this.f22673o;
            if (aVar2 != null) {
                aVar2.o(cVar);
                return;
            }
            q qVar2 = new q(cVar);
            this.f22673o = qVar2;
            qVar2.a(this);
            this.f22664f.i(this.f22673o);
        } else if (obj == r0.f17742e && (cVar6 = this.f22675q) != null) {
            cVar6.c(cVar);
        } else if (obj == r0.G && (cVar5 = this.f22675q) != null) {
            cVar5.f(cVar);
        } else if (obj == r0.H && (cVar4 = this.f22675q) != null) {
            cVar4.d(cVar);
        } else if (obj == r0.I && (cVar3 = this.f22675q) != null) {
            cVar3.e(cVar);
        } else if (obj == r0.J && (cVar2 = this.f22675q) != null) {
            cVar2.g(cVar);
        }
    }

    public void d(r0.e eVar, int i10, List list, r0.e eVar2) {
        k.k(eVar, i10, list, eVar2, this);
    }

    public void e(RectF rectF, Matrix matrix, boolean z10) {
        if (e.h()) {
            e.b("StrokeContent#getBounds");
        }
        this.f22660b.reset();
        for (int i10 = 0; i10 < this.f22665g.size(); i10++) {
            b bVar = (b) this.f22665g.get(i10);
            for (int i11 = 0; i11 < bVar.f22676a.size(); i11++) {
                this.f22660b.addPath(((m) bVar.f22676a.get(i11)).getPath(), matrix);
            }
        }
        this.f22660b.computeBounds(this.f22662d, false);
        float q10 = ((o0.d) this.f22668j).q();
        RectF rectF2 = this.f22662d;
        float f10 = q10 / 2.0f;
        rectF2.set(rectF2.left - f10, rectF2.top - f10, rectF2.right + f10, rectF2.bottom + f10);
        rectF.set(this.f22662d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        if (e.h()) {
            e.c("StrokeContent#getBounds");
        }
    }

    public void g(Canvas canvas, Matrix matrix, int i10) {
        if (e.h()) {
            e.b("StrokeContent#draw");
        }
        if (!l.h(matrix)) {
            int q10 = (int) ((((((float) i10) / 255.0f) * ((float) ((f) this.f22669k).q())) / 100.0f) * 255.0f);
            this.f22667i.setAlpha(k.c(q10, 0, 255));
            this.f22667i.setStrokeWidth(((o0.d) this.f22668j).q());
            if (this.f22667i.getStrokeWidth() > 0.0f) {
                f();
                o0.a aVar = this.f22672n;
                if (aVar != null) {
                    this.f22667i.setColorFilter((ColorFilter) aVar.h());
                }
                o0.a aVar2 = this.f22673o;
                if (aVar2 != null) {
                    float floatValue = ((Float) aVar2.h()).floatValue();
                    if (floatValue == 0.0f) {
                        this.f22667i.setMaskFilter((MaskFilter) null);
                    } else if (floatValue != this.f22674p) {
                        this.f22667i.setMaskFilter(this.f22664f.x(floatValue));
                    }
                    this.f22674p = floatValue;
                }
                c cVar = this.f22675q;
                if (cVar != null) {
                    cVar.b(this.f22667i, matrix, l.l(i10, q10));
                }
                canvas.save();
                canvas.concat(matrix);
                for (int i11 = 0; i11 < this.f22665g.size(); i11++) {
                    b bVar = (b) this.f22665g.get(i11);
                    if (bVar.f22677b != null) {
                        i(canvas, bVar);
                    } else {
                        if (e.h()) {
                            e.b("StrokeContent#buildPath");
                        }
                        this.f22660b.reset();
                        for (int size = bVar.f22676a.size() - 1; size >= 0; size--) {
                            this.f22660b.addPath(((m) bVar.f22676a.get(size)).getPath());
                        }
                        if (e.h()) {
                            e.c("StrokeContent#buildPath");
                            e.b("StrokeContent#drawPath");
                        }
                        canvas.drawPath(this.f22660b, this.f22667i);
                        if (e.h()) {
                            e.c("StrokeContent#drawPath");
                        }
                    }
                }
                canvas.restore();
                if (e.h()) {
                    e.c("StrokeContent#draw");
                }
            } else if (e.h()) {
                e.c("StrokeContent#draw");
            }
        } else if (e.h()) {
            e.c("StrokeContent#draw");
        }
    }
}
