package u0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.j;
import com.airbnb.lottie.k0;
import java.util.Collections;
import java.util.List;
import n0.d;
import r0.e;
import t0.a;
import t0.q;

public class g extends b {
    private final d E;
    private final c F;

    g(k0 k0Var, e eVar, c cVar, j jVar) {
        super(k0Var, eVar);
        this.F = cVar;
        d dVar = new d(k0Var, this, new q("__container", eVar.o(), false), jVar);
        this.E = dVar;
        dVar.b(Collections.emptyList(), Collections.emptyList());
    }

    /* access modifiers changed from: protected */
    public void I(e eVar, int i10, List list, e eVar2) {
        this.E.d(eVar, i10, list, eVar2);
    }

    public void e(RectF rectF, Matrix matrix, boolean z10) {
        super.e(rectF, matrix, z10);
        this.E.e(rectF, this.f24189o, z10);
    }

    /* access modifiers changed from: package-private */
    public void t(Canvas canvas, Matrix matrix, int i10) {
        this.E.g(canvas, matrix, i10);
    }

    public a w() {
        a w10 = super.w();
        if (w10 != null) {
            return w10;
        }
        return this.F.w();
    }

    public w0.j y() {
        w0.j y10 = super.y();
        if (y10 != null) {
            return y10;
        }
        return this.F.y();
    }
}
