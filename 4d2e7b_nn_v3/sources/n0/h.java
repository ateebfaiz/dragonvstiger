package n0;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.j;
import com.airbnb.lottie.k0;
import com.airbnb.lottie.r0;
import java.util.ArrayList;
import java.util.List;
import o0.a;
import o0.c;
import o0.d;
import o0.q;
import t0.e;
import t0.g;
import u0.b;
import y0.k;
import y0.l;

public class h implements e, a.b, k {

    /* renamed from: a  reason: collision with root package name */
    private final String f22711a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f22712b;

    /* renamed from: c  reason: collision with root package name */
    private final b f22713c;

    /* renamed from: d  reason: collision with root package name */
    private final LongSparseArray f22714d = new LongSparseArray();

    /* renamed from: e  reason: collision with root package name */
    private final LongSparseArray f22715e = new LongSparseArray();

    /* renamed from: f  reason: collision with root package name */
    private final Path f22716f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f22717g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f22718h;

    /* renamed from: i  reason: collision with root package name */
    private final List f22719i;

    /* renamed from: j  reason: collision with root package name */
    private final g f22720j;

    /* renamed from: k  reason: collision with root package name */
    private final a f22721k;

    /* renamed from: l  reason: collision with root package name */
    private final a f22722l;

    /* renamed from: m  reason: collision with root package name */
    private final a f22723m;

    /* renamed from: n  reason: collision with root package name */
    private final a f22724n;

    /* renamed from: o  reason: collision with root package name */
    private a f22725o;

    /* renamed from: p  reason: collision with root package name */
    private q f22726p;

    /* renamed from: q  reason: collision with root package name */
    private final k0 f22727q;

    /* renamed from: r  reason: collision with root package name */
    private final int f22728r;

    /* renamed from: s  reason: collision with root package name */
    private a f22729s;

    /* renamed from: t  reason: collision with root package name */
    float f22730t;

    /* renamed from: u  reason: collision with root package name */
    private c f22731u;

    public h(k0 k0Var, j jVar, b bVar, e eVar) {
        Path path = new Path();
        this.f22716f = path;
        this.f22717g = new m0.a(1);
        this.f22718h = new RectF();
        this.f22719i = new ArrayList();
        this.f22730t = 0.0f;
        this.f22713c = bVar;
        this.f22711a = eVar.f();
        this.f22712b = eVar.i();
        this.f22727q = k0Var;
        this.f22720j = eVar.e();
        path.setFillType(eVar.c());
        this.f22728r = (int) (jVar.d() / 32.0f);
        a a10 = eVar.d().a();
        this.f22721k = a10;
        a10.a(this);
        bVar.i(a10);
        a a11 = eVar.g().a();
        this.f22722l = a11;
        a11.a(this);
        bVar.i(a11);
        a a12 = eVar.h().a();
        this.f22723m = a12;
        a12.a(this);
        bVar.i(a12);
        a a13 = eVar.b().a();
        this.f22724n = a13;
        a13.a(this);
        bVar.i(a13);
        if (bVar.w() != null) {
            d d10 = bVar.w().a().a();
            this.f22729s = d10;
            d10.a(this);
            bVar.i(this.f22729s);
        }
        if (bVar.y() != null) {
            this.f22731u = new c(this, bVar, bVar.y());
        }
    }

    private int[] f(int[] iArr) {
        q qVar = this.f22726p;
        if (qVar != null) {
            Integer[] numArr = (Integer[]) qVar.h();
            int i10 = 0;
            if (iArr.length == numArr.length) {
                while (i10 < iArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i10 < numArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            }
        }
        return iArr;
    }

    private int i() {
        int i10;
        int round = Math.round(this.f22723m.f() * ((float) this.f22728r));
        int round2 = Math.round(this.f22724n.f() * ((float) this.f22728r));
        int round3 = Math.round(this.f22721k.f() * ((float) this.f22728r));
        if (round != 0) {
            i10 = 527 * round;
        } else {
            i10 = 17;
        }
        if (round2 != 0) {
            i10 = i10 * 31 * round2;
        }
        if (round3 != 0) {
            return i10 * 31 * round3;
        }
        return i10;
    }

    private LinearGradient j() {
        long i10 = (long) i();
        LinearGradient linearGradient = (LinearGradient) this.f22714d.get(i10);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.f22723m.h();
        PointF pointF2 = (PointF) this.f22724n.h();
        t0.d dVar = (t0.d) this.f22721k.h();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, f(dVar.d()), dVar.e(), Shader.TileMode.CLAMP);
        this.f22714d.put(i10, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient k() {
        long i10 = (long) i();
        RadialGradient radialGradient = (RadialGradient) this.f22715e.get(i10);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.f22723m.h();
        PointF pointF2 = (PointF) this.f22724n.h();
        t0.d dVar = (t0.d) this.f22721k.h();
        int[] f10 = f(dVar.d());
        float[] e10 = dVar.e();
        float f11 = pointF.x;
        float f12 = pointF.y;
        float hypot = (float) Math.hypot((double) (pointF2.x - f11), (double) (pointF2.y - f12));
        if (hypot <= 0.0f) {
            hypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f11, f12, hypot, f10, e10, Shader.TileMode.CLAMP);
        this.f22715e.put(i10, radialGradient2);
        return radialGradient2;
    }

    public void a() {
        this.f22727q.invalidateSelf();
    }

    public void b(List list, List list2) {
        for (int i10 = 0; i10 < list2.size(); i10++) {
            c cVar = (c) list2.get(i10);
            if (cVar instanceof m) {
                this.f22719i.add((m) cVar);
            }
        }
    }

    public void c(Object obj, z0.c cVar) {
        c cVar2;
        c cVar3;
        c cVar4;
        c cVar5;
        c cVar6;
        if (obj == r0.f17741d) {
            this.f22722l.o(cVar);
        } else if (obj == r0.K) {
            a aVar = this.f22725o;
            if (aVar != null) {
                this.f22713c.H(aVar);
            }
            if (cVar == null) {
                this.f22725o = null;
                return;
            }
            q qVar = new q(cVar);
            this.f22725o = qVar;
            qVar.a(this);
            this.f22713c.i(this.f22725o);
        } else if (obj == r0.L) {
            q qVar2 = this.f22726p;
            if (qVar2 != null) {
                this.f22713c.H(qVar2);
            }
            if (cVar == null) {
                this.f22726p = null;
                return;
            }
            this.f22714d.clear();
            this.f22715e.clear();
            q qVar3 = new q(cVar);
            this.f22726p = qVar3;
            qVar3.a(this);
            this.f22713c.i(this.f22726p);
        } else if (obj == r0.f17747j) {
            a aVar2 = this.f22729s;
            if (aVar2 != null) {
                aVar2.o(cVar);
                return;
            }
            q qVar4 = new q(cVar);
            this.f22729s = qVar4;
            qVar4.a(this);
            this.f22713c.i(this.f22729s);
        } else if (obj == r0.f17742e && (cVar6 = this.f22731u) != null) {
            cVar6.c(cVar);
        } else if (obj == r0.G && (cVar5 = this.f22731u) != null) {
            cVar5.f(cVar);
        } else if (obj == r0.H && (cVar4 = this.f22731u) != null) {
            cVar4.d(cVar);
        } else if (obj == r0.I && (cVar3 = this.f22731u) != null) {
            cVar3.e(cVar);
        } else if (obj == r0.J && (cVar2 = this.f22731u) != null) {
            cVar2.g(cVar);
        }
    }

    public void d(r0.e eVar, int i10, List list, r0.e eVar2) {
        k.k(eVar, i10, list, eVar2, this);
    }

    public void e(RectF rectF, Matrix matrix, boolean z10) {
        this.f22716f.reset();
        for (int i10 = 0; i10 < this.f22719i.size(); i10++) {
            this.f22716f.addPath(((m) this.f22719i.get(i10)).getPath(), matrix);
        }
        this.f22716f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public void g(Canvas canvas, Matrix matrix, int i10) {
        Shader shader;
        if (!this.f22712b) {
            if (com.airbnb.lottie.e.h()) {
                com.airbnb.lottie.e.b("GradientFillContent#draw");
            }
            this.f22716f.reset();
            for (int i11 = 0; i11 < this.f22719i.size(); i11++) {
                this.f22716f.addPath(((m) this.f22719i.get(i11)).getPath(), matrix);
            }
            this.f22716f.computeBounds(this.f22718h, false);
            if (this.f22720j == g.LINEAR) {
                shader = j();
            } else {
                shader = k();
            }
            shader.setLocalMatrix(matrix);
            this.f22717g.setShader(shader);
            a aVar = this.f22725o;
            if (aVar != null) {
                this.f22717g.setColorFilter((ColorFilter) aVar.h());
            }
            a aVar2 = this.f22729s;
            if (aVar2 != null) {
                float floatValue = ((Float) aVar2.h()).floatValue();
                if (floatValue == 0.0f) {
                    this.f22717g.setMaskFilter((MaskFilter) null);
                } else if (floatValue != this.f22730t) {
                    this.f22717g.setMaskFilter(new BlurMaskFilter(floatValue, BlurMaskFilter.Blur.NORMAL));
                }
                this.f22730t = floatValue;
            }
            int intValue = (int) ((((((float) i10) / 255.0f) * ((float) ((Integer) this.f22722l.h()).intValue())) / 100.0f) * 255.0f);
            this.f22717g.setAlpha(k.c(intValue, 0, 255));
            c cVar = this.f22731u;
            if (cVar != null) {
                cVar.b(this.f22717g, matrix, l.l(i10, intValue));
            }
            canvas.drawPath(this.f22716f, this.f22717g);
            if (com.airbnb.lottie.e.h()) {
                com.airbnb.lottie.e.c("GradientFillContent#draw");
            }
        }
    }

    public String getName() {
        return this.f22711a;
    }
}
