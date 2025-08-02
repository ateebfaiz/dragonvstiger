package w3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.Arrays;

public class l extends g implements i {
    private boolean C = false;
    private float N0 = 0.0f;
    private boolean O0 = false;
    private boolean P0 = false;
    private final Path Q0 = new Path();
    private final Path R0 = new Path();
    private final RectF S0 = new RectF();
    private float X = 0.0f;
    private int Y = 0;
    private int Z = 0;

    /* renamed from: e  reason: collision with root package name */
    b f24552e = b.OVERLAY_COLOR;

    /* renamed from: f  reason: collision with root package name */
    private final RectF f24553f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private RectF f24554g;

    /* renamed from: h  reason: collision with root package name */
    private Matrix f24555h;

    /* renamed from: i  reason: collision with root package name */
    private final float[] f24556i = new float[8];

    /* renamed from: j  reason: collision with root package name */
    final float[] f24557j = new float[8];

    /* renamed from: w  reason: collision with root package name */
    final Paint f24558w = new Paint(1);

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24559a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                w3.l$b[] r0 = w3.l.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24559a = r0
                w3.l$b r1 = w3.l.b.CLIPPING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24559a     // Catch:{ NoSuchFieldError -> 0x001d }
                w3.l$b r1 = w3.l.b.OVERLAY_COLOR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: w3.l.a.<clinit>():void");
        }
    }

    public enum b {
        OVERLAY_COLOR,
        CLIPPING
    }

    public l(Drawable drawable) {
        super((Drawable) y2.l.g(drawable));
    }

    private void y() {
        float[] fArr;
        this.Q0.reset();
        this.R0.reset();
        this.S0.set(getBounds());
        RectF rectF = this.S0;
        float f10 = this.N0;
        rectF.inset(f10, f10);
        if (this.f24552e == b.OVERLAY_COLOR) {
            this.Q0.addRect(this.S0, Path.Direction.CW);
        }
        if (this.C) {
            this.Q0.addCircle(this.S0.centerX(), this.S0.centerY(), Math.min(this.S0.width(), this.S0.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.Q0.addRoundRect(this.S0, this.f24556i, Path.Direction.CW);
        }
        RectF rectF2 = this.S0;
        float f11 = this.N0;
        rectF2.inset(-f11, -f11);
        RectF rectF3 = this.S0;
        float f12 = this.X;
        rectF3.inset(f12 / 2.0f, f12 / 2.0f);
        if (this.C) {
            this.R0.addCircle(this.S0.centerX(), this.S0.centerY(), Math.min(this.S0.width(), this.S0.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i10 = 0;
            while (true) {
                fArr = this.f24557j;
                if (i10 >= fArr.length) {
                    break;
                }
                fArr[i10] = (this.f24556i[i10] + this.N0) - (this.X / 2.0f);
                i10++;
            }
            this.R0.addRoundRect(this.S0, fArr, Path.Direction.CW);
        }
        RectF rectF4 = this.S0;
        float f13 = this.X;
        rectF4.inset((-f13) / 2.0f, (-f13) / 2.0f);
    }

    public void b(int i10, float f10) {
        this.Y = i10;
        this.X = f10;
        y();
        invalidateSelf();
    }

    public void d(boolean z10) {
    }

    public void draw(Canvas canvas) {
        this.f24553f.set(getBounds());
        int i10 = a.f24559a[this.f24552e.ordinal()];
        if (i10 == 1) {
            int save = canvas.save();
            canvas.clipPath(this.Q0);
            super.draw(canvas);
            canvas.restoreToCount(save);
        } else if (i10 == 2) {
            if (this.O0) {
                RectF rectF = this.f24554g;
                if (rectF == null) {
                    this.f24554g = new RectF(this.f24553f);
                    this.f24555h = new Matrix();
                } else {
                    rectF.set(this.f24553f);
                }
                RectF rectF2 = this.f24554g;
                float f10 = this.X;
                rectF2.inset(f10, f10);
                this.f24555h.setRectToRect(this.f24553f, this.f24554g, Matrix.ScaleToFit.FILL);
                int save2 = canvas.save();
                canvas.clipRect(this.f24553f);
                canvas.concat(this.f24555h);
                super.draw(canvas);
                canvas.restoreToCount(save2);
            } else {
                super.draw(canvas);
            }
            this.f24558w.setStyle(Paint.Style.FILL);
            this.f24558w.setColor(this.Z);
            this.f24558w.setStrokeWidth(0.0f);
            this.f24558w.setFilterBitmap(w());
            this.Q0.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.Q0, this.f24558w);
            if (this.C) {
                float width = ((this.f24553f.width() - this.f24553f.height()) + this.X) / 2.0f;
                float height = ((this.f24553f.height() - this.f24553f.width()) + this.X) / 2.0f;
                if (width > 0.0f) {
                    RectF rectF3 = this.f24553f;
                    float f11 = rectF3.left;
                    Canvas canvas2 = canvas;
                    canvas2.drawRect(f11, rectF3.top, f11 + width, rectF3.bottom, this.f24558w);
                    RectF rectF4 = this.f24553f;
                    float f12 = rectF4.right;
                    canvas2.drawRect(f12 - width, rectF4.top, f12, rectF4.bottom, this.f24558w);
                }
                if (height > 0.0f) {
                    RectF rectF5 = this.f24553f;
                    float f13 = rectF5.left;
                    float f14 = rectF5.top;
                    Canvas canvas3 = canvas;
                    canvas3.drawRect(f13, f14, rectF5.right, f14 + height, this.f24558w);
                    RectF rectF6 = this.f24553f;
                    float f15 = rectF6.left;
                    float f16 = rectF6.bottom;
                    canvas3.drawRect(f15, f16 - height, rectF6.right, f16, this.f24558w);
                }
            }
        }
        if (this.Y != 0) {
            this.f24558w.setStyle(Paint.Style.STROKE);
            this.f24558w.setColor(this.Y);
            this.f24558w.setStrokeWidth(this.X);
            this.Q0.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.R0, this.f24558w);
        }
    }

    public void e(boolean z10) {
        this.C = z10;
        y();
        invalidateSelf();
    }

    public void h(boolean z10) {
        if (this.P0 != z10) {
            this.P0 = z10;
            invalidateSelf();
        }
    }

    public void j(boolean z10) {
        this.O0 = z10;
        y();
        invalidateSelf();
    }

    public void m(float f10) {
        this.N0 = f10;
        y();
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        y();
    }

    public void q(float f10) {
        Arrays.fill(this.f24556i, f10);
        y();
        invalidateSelf();
    }

    public void s(float[] fArr) {
        boolean z10;
        if (fArr == null) {
            Arrays.fill(this.f24556i, 0.0f);
        } else {
            if (fArr.length == 8) {
                z10 = true;
            } else {
                z10 = false;
            }
            y2.l.c(z10, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f24556i, 0, 8);
        }
        y();
        invalidateSelf();
    }

    public boolean w() {
        return this.P0;
    }

    public void x(int i10) {
        this.Z = i10;
        invalidateSelf();
    }
}
