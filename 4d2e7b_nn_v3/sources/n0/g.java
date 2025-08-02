package n0;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.k0;
import com.airbnb.lottie.r0;
import java.util.ArrayList;
import java.util.List;
import o0.a;
import o0.c;
import o0.d;
import o0.q;
import r0.e;
import t0.p;
import u0.b;
import y0.k;
import y0.l;

public class g implements e, a.b, k {

    /* renamed from: a  reason: collision with root package name */
    private final Path f22698a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f22699b = new m0.a(1);

    /* renamed from: c  reason: collision with root package name */
    private final b f22700c;

    /* renamed from: d  reason: collision with root package name */
    private final String f22701d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f22702e;

    /* renamed from: f  reason: collision with root package name */
    private final List f22703f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final a f22704g;

    /* renamed from: h  reason: collision with root package name */
    private final a f22705h;

    /* renamed from: i  reason: collision with root package name */
    private a f22706i;

    /* renamed from: j  reason: collision with root package name */
    private final k0 f22707j;

    /* renamed from: k  reason: collision with root package name */
    private a f22708k;

    /* renamed from: l  reason: collision with root package name */
    float f22709l;

    /* renamed from: m  reason: collision with root package name */
    private c f22710m;

    public g(k0 k0Var, b bVar, p pVar) {
        Path path = new Path();
        this.f22698a = path;
        this.f22700c = bVar;
        this.f22701d = pVar.d();
        this.f22702e = pVar.f();
        this.f22707j = k0Var;
        if (bVar.w() != null) {
            d d10 = bVar.w().a().a();
            this.f22708k = d10;
            d10.a(this);
            bVar.i(this.f22708k);
        }
        if (bVar.y() != null) {
            this.f22710m = new c(this, bVar, bVar.y());
        }
        if (pVar.b() == null || pVar.e() == null) {
            this.f22704g = null;
            this.f22705h = null;
            return;
        }
        path.setFillType(pVar.c());
        a a10 = pVar.b().a();
        this.f22704g = a10;
        a10.a(this);
        bVar.i(a10);
        a a11 = pVar.e().a();
        this.f22705h = a11;
        a11.a(this);
        bVar.i(a11);
    }

    public void a() {
        this.f22707j.invalidateSelf();
    }

    public void b(List list, List list2) {
        for (int i10 = 0; i10 < list2.size(); i10++) {
            c cVar = (c) list2.get(i10);
            if (cVar instanceof m) {
                this.f22703f.add((m) cVar);
            }
        }
    }

    public void c(Object obj, z0.c cVar) {
        c cVar2;
        c cVar3;
        c cVar4;
        c cVar5;
        c cVar6;
        if (obj == r0.f17738a) {
            this.f22704g.o(cVar);
        } else if (obj == r0.f17741d) {
            this.f22705h.o(cVar);
        } else if (obj == r0.K) {
            a aVar = this.f22706i;
            if (aVar != null) {
                this.f22700c.H(aVar);
            }
            if (cVar == null) {
                this.f22706i = null;
                return;
            }
            q qVar = new q(cVar);
            this.f22706i = qVar;
            qVar.a(this);
            this.f22700c.i(this.f22706i);
        } else if (obj == r0.f17747j) {
            a aVar2 = this.f22708k;
            if (aVar2 != null) {
                aVar2.o(cVar);
                return;
            }
            q qVar2 = new q(cVar);
            this.f22708k = qVar2;
            qVar2.a(this);
            this.f22700c.i(this.f22708k);
        } else if (obj == r0.f17742e && (cVar6 = this.f22710m) != null) {
            cVar6.c(cVar);
        } else if (obj == r0.G && (cVar5 = this.f22710m) != null) {
            cVar5.f(cVar);
        } else if (obj == r0.H && (cVar4 = this.f22710m) != null) {
            cVar4.d(cVar);
        } else if (obj == r0.I && (cVar3 = this.f22710m) != null) {
            cVar3.e(cVar);
        } else if (obj == r0.J && (cVar2 = this.f22710m) != null) {
            cVar2.g(cVar);
        }
    }

    public void d(e eVar, int i10, List list, e eVar2) {
        k.k(eVar, i10, list, eVar2, this);
    }

    public void e(RectF rectF, Matrix matrix, boolean z10) {
        this.f22698a.reset();
        for (int i10 = 0; i10 < this.f22703f.size(); i10++) {
            this.f22698a.addPath(((m) this.f22703f.get(i10)).getPath(), matrix);
        }
        this.f22698a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public void g(Canvas canvas, Matrix matrix, int i10) {
        if (!this.f22702e) {
            if (com.airbnb.lottie.e.h()) {
                com.airbnb.lottie.e.b("FillContent#draw");
            }
            int q10 = ((o0.b) this.f22704g).q();
            int intValue = (int) ((((((float) i10) / 255.0f) * ((float) ((Integer) this.f22705h.h()).intValue())) / 100.0f) * 255.0f);
            this.f22699b.setColor((q10 & ViewCompat.MEASURED_SIZE_MASK) | (k.c(intValue, 0, 255) << 24));
            a aVar = this.f22706i;
            if (aVar != null) {
                this.f22699b.setColorFilter((ColorFilter) aVar.h());
            }
            a aVar2 = this.f22708k;
            if (aVar2 != null) {
                float floatValue = ((Float) aVar2.h()).floatValue();
                if (floatValue == 0.0f) {
                    this.f22699b.setMaskFilter((MaskFilter) null);
                } else if (floatValue != this.f22709l) {
                    this.f22699b.setMaskFilter(this.f22700c.x(floatValue));
                }
                this.f22709l = floatValue;
            }
            c cVar = this.f22710m;
            if (cVar != null) {
                cVar.b(this.f22699b, matrix, l.l(i10, intValue));
            }
            this.f22698a.reset();
            for (int i11 = 0; i11 < this.f22703f.size(); i11++) {
                this.f22698a.addPath(((m) this.f22703f.get(i11)).getPath(), matrix);
            }
            canvas.drawPath(this.f22698a, this.f22699b);
            if (com.airbnb.lottie.e.h()) {
                com.airbnb.lottie.e.c("FillContent#draw");
            }
        }
    }

    public String getName() {
        return this.f22701d;
    }
}
