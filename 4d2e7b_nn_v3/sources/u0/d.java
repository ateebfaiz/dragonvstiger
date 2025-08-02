package u0;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.k0;
import com.airbnb.lottie.n0;
import com.airbnb.lottie.r0;
import m0.a;
import o0.c;
import o0.q;
import y0.l;

public class d extends b {
    private final Paint E = new a(3);
    private final Rect F = new Rect();
    private final Rect G = new Rect();
    private final n0 H;
    private o0.a I;
    private o0.a J;
    private c K;

    d(k0 k0Var, e eVar) {
        super(k0Var, eVar);
        this.H = k0Var.P(eVar.n());
        if (y() != null) {
            this.K = new c(this, this, y());
        }
    }

    private Bitmap P() {
        Bitmap bitmap;
        o0.a aVar = this.J;
        if (aVar != null && (bitmap = (Bitmap) aVar.h()) != null) {
            return bitmap;
        }
        Bitmap G2 = this.f24190p.G(this.f24191q.n());
        if (G2 != null) {
            return G2;
        }
        n0 n0Var = this.H;
        if (n0Var != null) {
            return n0Var.b();
        }
        return null;
    }

    public void c(Object obj, z0.c cVar) {
        super.c(obj, cVar);
        if (obj == r0.K) {
            if (cVar == null) {
                this.I = null;
            } else {
                this.I = new q(cVar);
            }
        } else if (obj != r0.N) {
        } else {
            if (cVar == null) {
                this.J = null;
            } else {
                this.J = new q(cVar);
            }
        }
    }

    public void e(RectF rectF, Matrix matrix, boolean z10) {
        super.e(rectF, matrix, z10);
        if (this.H != null) {
            float e10 = l.e();
            rectF.set(0.0f, 0.0f, ((float) this.H.f()) * e10, ((float) this.H.d()) * e10);
            this.f24189o.mapRect(rectF);
        }
    }

    public void t(Canvas canvas, Matrix matrix, int i10) {
        Bitmap P = P();
        if (P != null && !P.isRecycled() && this.H != null) {
            float e10 = l.e();
            this.E.setAlpha(i10);
            o0.a aVar = this.I;
            if (aVar != null) {
                this.E.setColorFilter((ColorFilter) aVar.h());
            }
            canvas.save();
            canvas.concat(matrix);
            this.F.set(0, 0, P.getWidth(), P.getHeight());
            if (this.f24190p.Q()) {
                this.G.set(0, 0, (int) (((float) this.H.f()) * e10), (int) (((float) this.H.d()) * e10));
            } else {
                this.G.set(0, 0, (int) (((float) P.getWidth()) * e10), (int) (((float) P.getHeight()) * e10));
            }
            c cVar = this.K;
            if (cVar != null) {
                cVar.b(this.E, matrix, i10);
            }
            canvas.drawBitmap(P, this.F, this.G, this.E);
            canvas.restore();
        }
    }
}
