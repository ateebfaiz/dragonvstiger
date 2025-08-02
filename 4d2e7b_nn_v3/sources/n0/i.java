package n0;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.k0;
import com.airbnb.lottie.r0;
import o0.a;
import o0.q;
import t0.d;
import t0.f;
import t0.g;
import u0.b;
import z0.c;

public class i extends a {
    private final a A;
    private q B;

    /* renamed from: r  reason: collision with root package name */
    private final String f22732r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f22733s;

    /* renamed from: t  reason: collision with root package name */
    private final LongSparseArray f22734t = new LongSparseArray();

    /* renamed from: u  reason: collision with root package name */
    private final LongSparseArray f22735u = new LongSparseArray();

    /* renamed from: v  reason: collision with root package name */
    private final RectF f22736v = new RectF();

    /* renamed from: w  reason: collision with root package name */
    private final g f22737w;

    /* renamed from: x  reason: collision with root package name */
    private final int f22738x;

    /* renamed from: y  reason: collision with root package name */
    private final a f22739y;

    /* renamed from: z  reason: collision with root package name */
    private final a f22740z;

    public i(k0 k0Var, b bVar, f fVar) {
        super(k0Var, bVar, fVar.b().b(), fVar.g().b(), fVar.i(), fVar.k(), fVar.m(), fVar.h(), fVar.c());
        this.f22732r = fVar.j();
        this.f22737w = fVar.f();
        this.f22733s = fVar.n();
        this.f22738x = (int) (k0Var.J().d() / 32.0f);
        a a10 = fVar.e().a();
        this.f22739y = a10;
        a10.a(this);
        bVar.i(a10);
        a a11 = fVar.l().a();
        this.f22740z = a11;
        a11.a(this);
        bVar.i(a11);
        a a12 = fVar.d().a();
        this.A = a12;
        a12.a(this);
        bVar.i(a12);
    }

    private int[] j(int[] iArr) {
        q qVar = this.B;
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

    private int k() {
        int i10;
        int round = Math.round(this.f22740z.f() * ((float) this.f22738x));
        int round2 = Math.round(this.A.f() * ((float) this.f22738x));
        int round3 = Math.round(this.f22739y.f() * ((float) this.f22738x));
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

    private LinearGradient l() {
        long k10 = (long) k();
        LinearGradient linearGradient = (LinearGradient) this.f22734t.get(k10);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.f22740z.h();
        PointF pointF2 = (PointF) this.A.h();
        d dVar = (d) this.f22739y.h();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, j(dVar.d()), dVar.e(), Shader.TileMode.CLAMP);
        this.f22734t.put(k10, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient m() {
        long k10 = (long) k();
        RadialGradient radialGradient = (RadialGradient) this.f22735u.get(k10);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.f22740z.h();
        PointF pointF2 = (PointF) this.A.h();
        d dVar = (d) this.f22739y.h();
        int[] j10 = j(dVar.d());
        float[] e10 = dVar.e();
        float f10 = pointF.x;
        float f11 = pointF.y;
        RadialGradient radialGradient2 = new RadialGradient(f10, f11, (float) Math.hypot((double) (pointF2.x - f10), (double) (pointF2.y - f11)), j10, e10, Shader.TileMode.CLAMP);
        this.f22735u.put(k10, radialGradient2);
        return radialGradient2;
    }

    public void c(Object obj, c cVar) {
        super.c(obj, cVar);
        if (obj == r0.L) {
            q qVar = this.B;
            if (qVar != null) {
                this.f22664f.H(qVar);
            }
            if (cVar == null) {
                this.B = null;
                return;
            }
            q qVar2 = new q(cVar);
            this.B = qVar2;
            qVar2.a(this);
            this.f22664f.i(this.B);
        }
    }

    public void g(Canvas canvas, Matrix matrix, int i10) {
        Shader shader;
        if (!this.f22733s) {
            e(this.f22736v, matrix, false);
            if (this.f22737w == g.LINEAR) {
                shader = l();
            } else {
                shader = m();
            }
            this.f22667i.setShader(shader);
            super.g(canvas, matrix, i10);
        }
    }

    public String getName() {
        return this.f22732r;
    }
}
