package u0;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.k0;
import com.airbnb.lottie.r0;
import o0.a;
import o0.q;
import z0.c;

public class h extends b {
    private final RectF E = new RectF();
    private final Paint F;
    private final float[] G;
    private final Path H;
    private final e I;
    private a J;
    private a K;

    h(k0 k0Var, e eVar) {
        super(k0Var, eVar);
        m0.a aVar = new m0.a();
        this.F = aVar;
        this.G = new float[8];
        this.H = new Path();
        this.I = eVar;
        aVar.setAlpha(0);
        aVar.setStyle(Paint.Style.FILL);
        aVar.setColor(eVar.p());
    }

    public void c(Object obj, c cVar) {
        super.c(obj, cVar);
        if (obj == r0.K) {
            if (cVar == null) {
                this.J = null;
            } else {
                this.J = new q(cVar);
            }
        } else if (obj != r0.f17738a) {
        } else {
            if (cVar == null) {
                this.K = null;
                this.F.setColor(this.I.p());
                return;
            }
            this.K = new q(cVar);
        }
    }

    public void e(RectF rectF, Matrix matrix, boolean z10) {
        super.e(rectF, matrix, z10);
        this.E.set(0.0f, 0.0f, (float) this.I.r(), (float) this.I.q());
        this.f24189o.mapRect(this.E);
        rectF.set(this.E);
    }

    public void t(Canvas canvas, Matrix matrix, int i10) {
        Integer num;
        int i11;
        int alpha = Color.alpha(this.I.p());
        if (alpha != 0) {
            a aVar = this.K;
            if (aVar == null) {
                num = null;
            } else {
                num = (Integer) aVar.h();
            }
            if (num != null) {
                this.F.setColor(num.intValue());
            } else {
                this.F.setColor(this.I.p());
            }
            if (this.f24198x.h() == null) {
                i11 = 100;
            } else {
                i11 = ((Integer) this.f24198x.h().h()).intValue();
            }
            int i12 = (int) ((((float) i10) / 255.0f) * (((((float) alpha) / 255.0f) * ((float) i11)) / 100.0f) * 255.0f);
            this.F.setAlpha(i12);
            a aVar2 = this.J;
            if (aVar2 != null) {
                this.F.setColorFilter((ColorFilter) aVar2.h());
            }
            if (i12 > 0) {
                float[] fArr = this.G;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = (float) this.I.r();
                float[] fArr2 = this.G;
                fArr2[3] = 0.0f;
                fArr2[4] = (float) this.I.r();
                this.G[5] = (float) this.I.q();
                float[] fArr3 = this.G;
                fArr3[6] = 0.0f;
                fArr3[7] = (float) this.I.q();
                matrix.mapPoints(this.G);
                this.H.reset();
                Path path = this.H;
                float[] fArr4 = this.G;
                path.moveTo(fArr4[0], fArr4[1]);
                Path path2 = this.H;
                float[] fArr5 = this.G;
                path2.lineTo(fArr5[2], fArr5[3]);
                Path path3 = this.H;
                float[] fArr6 = this.G;
                path3.lineTo(fArr6[4], fArr6[5]);
                Path path4 = this.H;
                float[] fArr7 = this.G;
                path4.lineTo(fArr7[6], fArr7[7]);
                Path path5 = this.H;
                float[] fArr8 = this.G;
                path5.lineTo(fArr8[0], fArr8[1]);
                this.H.close();
                canvas.drawPath(this.H, this.F);
            }
        }
    }
}
