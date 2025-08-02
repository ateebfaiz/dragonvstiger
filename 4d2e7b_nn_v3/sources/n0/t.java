package n0;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.k0;
import com.airbnb.lottie.r0;
import o0.a;
import o0.q;
import t0.s;
import u0.b;
import z0.c;

public class t extends a {

    /* renamed from: r  reason: collision with root package name */
    private final b f22799r;

    /* renamed from: s  reason: collision with root package name */
    private final String f22800s;

    /* renamed from: t  reason: collision with root package name */
    private final boolean f22801t;

    /* renamed from: u  reason: collision with root package name */
    private final a f22802u;

    /* renamed from: v  reason: collision with root package name */
    private a f22803v;

    public t(k0 k0Var, b bVar, s sVar) {
        super(k0Var, bVar, sVar.b().b(), sVar.e().b(), sVar.g(), sVar.i(), sVar.j(), sVar.f(), sVar.d());
        this.f22799r = bVar;
        this.f22800s = sVar.h();
        this.f22801t = sVar.k();
        a a10 = sVar.c().a();
        this.f22802u = a10;
        a10.a(this);
        bVar.i(a10);
    }

    public void c(Object obj, c cVar) {
        super.c(obj, cVar);
        if (obj == r0.f17739b) {
            this.f22802u.o(cVar);
        } else if (obj == r0.K) {
            a aVar = this.f22803v;
            if (aVar != null) {
                this.f22799r.H(aVar);
            }
            if (cVar == null) {
                this.f22803v = null;
                return;
            }
            q qVar = new q(cVar);
            this.f22803v = qVar;
            qVar.a(this);
            this.f22799r.i(this.f22802u);
        }
    }

    public void g(Canvas canvas, Matrix matrix, int i10) {
        if (!this.f22801t) {
            this.f22667i.setColor(((o0.b) this.f22802u).q());
            a aVar = this.f22803v;
            if (aVar != null) {
                this.f22667i.setColorFilter((ColorFilter) aVar.h());
            }
            super.g(canvas, matrix, i10);
        }
    }

    public String getName() {
        return this.f22800s;
    }
}
