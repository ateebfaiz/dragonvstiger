package w3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.Arrays;
import l5.b;
import y2.l;

public abstract class m extends Drawable implements i, q {
    final RectF C = new RectF();
    RectF N0;
    final Matrix O0 = new Matrix();
    final Matrix P0 = new Matrix();
    final Matrix Q0 = new Matrix();
    final Matrix R0 = new Matrix();
    final Matrix S0 = new Matrix();
    Matrix T0;
    Matrix U0;
    final Matrix V0 = new Matrix();
    private float W0 = 0.0f;
    final RectF X = new RectF();
    private boolean X0 = false;
    final RectF Y = new RectF();
    private boolean Y0 = false;
    final RectF Z = new RectF();
    private boolean Z0 = true;

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f24563a;

    /* renamed from: a1  reason: collision with root package name */
    private r f24564a1;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f24565b = false;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f24566c = false;

    /* renamed from: d  reason: collision with root package name */
    protected float f24567d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    protected final Path f24568e = new Path();

    /* renamed from: f  reason: collision with root package name */
    protected boolean f24569f = true;

    /* renamed from: g  reason: collision with root package name */
    protected int f24570g = 0;

    /* renamed from: h  reason: collision with root package name */
    protected final Path f24571h = new Path();

    /* renamed from: i  reason: collision with root package name */
    private final float[] f24572i = new float[8];

    /* renamed from: j  reason: collision with root package name */
    final float[] f24573j = new float[8];

    /* renamed from: w  reason: collision with root package name */
    float[] f24574w;

    m(Drawable drawable) {
        this.f24563a = drawable;
    }

    public boolean a() {
        return this.Y0;
    }

    public void b(int i10, float f10) {
        if (this.f24570g != i10 || this.f24567d != f10) {
            this.f24570g = i10;
            this.f24567d = f10;
            this.Z0 = true;
            invalidateSelf();
        }
    }

    public void c(r rVar) {
        this.f24564a1 = rVar;
    }

    public void clearColorFilter() {
        this.f24563a.clearColorFilter();
    }

    public void d(boolean z10) {
    }

    public void draw(Canvas canvas) {
        if (b.d()) {
            b.a("RoundedDrawable#draw");
        }
        this.f24563a.draw(canvas);
        if (b.d()) {
            b.b();
        }
    }

    public void e(boolean z10) {
        this.f24565b = z10;
        this.Z0 = true;
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        if (this.f24565b || this.f24566c || this.f24567d > 0.0f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void g() {
        float f10;
        float[] fArr;
        if (this.Z0) {
            this.f24571h.reset();
            RectF rectF = this.C;
            float f11 = this.f24567d;
            rectF.inset(f11 / 2.0f, f11 / 2.0f);
            if (this.f24565b) {
                this.f24571h.addCircle(this.C.centerX(), this.C.centerY(), Math.min(this.C.width(), this.C.height()) / 2.0f, Path.Direction.CW);
            } else {
                int i10 = 0;
                while (true) {
                    fArr = this.f24573j;
                    if (i10 >= fArr.length) {
                        break;
                    }
                    fArr[i10] = (this.f24572i[i10] + this.W0) - (this.f24567d / 2.0f);
                    i10++;
                }
                this.f24571h.addRoundRect(this.C, fArr, Path.Direction.CW);
            }
            RectF rectF2 = this.C;
            float f12 = this.f24567d;
            rectF2.inset((-f12) / 2.0f, (-f12) / 2.0f);
            this.f24568e.reset();
            float f13 = this.W0;
            if (this.X0) {
                f10 = this.f24567d;
            } else {
                f10 = 0.0f;
            }
            float f14 = f13 + f10;
            this.C.inset(f14, f14);
            if (this.f24565b) {
                this.f24568e.addCircle(this.C.centerX(), this.C.centerY(), Math.min(this.C.width(), this.C.height()) / 2.0f, Path.Direction.CW);
            } else if (this.X0) {
                if (this.f24574w == null) {
                    this.f24574w = new float[8];
                }
                for (int i11 = 0; i11 < this.f24573j.length; i11++) {
                    this.f24574w[i11] = this.f24572i[i11] - this.f24567d;
                }
                this.f24568e.addRoundRect(this.C, this.f24574w, Path.Direction.CW);
            } else {
                this.f24568e.addRoundRect(this.C, this.f24572i, Path.Direction.CW);
            }
            float f15 = -f14;
            this.C.inset(f15, f15);
            this.f24568e.setFillType(Path.FillType.WINDING);
            this.Z0 = false;
        }
    }

    public int getAlpha() {
        return this.f24563a.getAlpha();
    }

    public ColorFilter getColorFilter() {
        return this.f24563a.getColorFilter();
    }

    public int getIntrinsicHeight() {
        return this.f24563a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f24563a.getIntrinsicWidth();
    }

    public int getOpacity() {
        return this.f24563a.getOpacity();
    }

    public void h(boolean z10) {
        if (this.Y0 != z10) {
            this.Y0 = z10;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public void i() {
        Matrix matrix;
        r rVar = this.f24564a1;
        if (rVar != null) {
            rVar.g(this.Q0);
            this.f24564a1.l(this.C);
        } else {
            this.Q0.reset();
            this.C.set(getBounds());
        }
        this.Y.set(0.0f, 0.0f, (float) getIntrinsicWidth(), (float) getIntrinsicHeight());
        this.Z.set(this.f24563a.getBounds());
        Matrix matrix2 = this.O0;
        RectF rectF = this.Y;
        RectF rectF2 = this.Z;
        Matrix.ScaleToFit scaleToFit = Matrix.ScaleToFit.FILL;
        matrix2.setRectToRect(rectF, rectF2, scaleToFit);
        if (this.X0) {
            RectF rectF3 = this.N0;
            if (rectF3 == null) {
                this.N0 = new RectF(this.C);
            } else {
                rectF3.set(this.C);
            }
            RectF rectF4 = this.N0;
            float f10 = this.f24567d;
            rectF4.inset(f10, f10);
            if (this.T0 == null) {
                this.T0 = new Matrix();
            }
            this.T0.setRectToRect(this.C, this.N0, scaleToFit);
        } else {
            Matrix matrix3 = this.T0;
            if (matrix3 != null) {
                matrix3.reset();
            }
        }
        if (!this.Q0.equals(this.R0) || !this.O0.equals(this.P0) || ((matrix = this.T0) != null && !matrix.equals(this.U0))) {
            this.f24569f = true;
            this.Q0.invert(this.S0);
            this.V0.set(this.Q0);
            if (this.X0) {
                this.V0.postConcat(this.T0);
            }
            this.V0.preConcat(this.O0);
            this.R0.set(this.Q0);
            this.P0.set(this.O0);
            if (this.X0) {
                Matrix matrix4 = this.U0;
                if (matrix4 == null) {
                    this.U0 = new Matrix(this.T0);
                } else {
                    matrix4.set(this.T0);
                }
            } else {
                Matrix matrix5 = this.U0;
                if (matrix5 != null) {
                    matrix5.reset();
                }
            }
        }
        if (!this.C.equals(this.X)) {
            this.Z0 = true;
            this.X.set(this.C);
        }
    }

    public void j(boolean z10) {
        if (this.X0 != z10) {
            this.X0 = z10;
            this.Z0 = true;
            invalidateSelf();
        }
    }

    public void m(float f10) {
        if (this.W0 != f10) {
            this.W0 = f10;
            this.Z0 = true;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f24563a.setBounds(rect);
    }

    public void q(float f10) {
        boolean z10;
        int i10 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
        boolean z11 = false;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.i(z10);
        Arrays.fill(this.f24572i, f10);
        if (i10 != 0) {
            z11 = true;
        }
        this.f24566c = z11;
        this.Z0 = true;
        invalidateSelf();
    }

    public void s(float[] fArr) {
        boolean z10;
        boolean z11;
        if (fArr == null) {
            Arrays.fill(this.f24572i, 0.0f);
            this.f24566c = false;
        } else {
            if (fArr.length == 8) {
                z10 = true;
            } else {
                z10 = false;
            }
            l.c(z10, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f24572i, 0, 8);
            this.f24566c = false;
            for (int i10 = 0; i10 < 8; i10++) {
                boolean z12 = this.f24566c;
                if (fArr[i10] > 0.0f) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                this.f24566c = z12 | z11;
            }
        }
        this.Z0 = true;
        invalidateSelf();
    }

    public void setAlpha(int i10) {
        this.f24563a.setAlpha(i10);
    }

    public void setColorFilter(int i10, PorterDuff.Mode mode) {
        this.f24563a.setColorFilter(i10, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f24563a.setColorFilter(colorFilter);
    }
}
