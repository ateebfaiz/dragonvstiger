package w3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import java.util.Arrays;
import y2.l;

public class k extends Drawable implements i {
    final Path C = new Path();
    private int X = 0;
    private final RectF Y = new RectF();
    private int Z = 255;

    /* renamed from: a  reason: collision with root package name */
    private final float[] f24541a = new float[8];

    /* renamed from: b  reason: collision with root package name */
    final float[] f24542b = new float[8];

    /* renamed from: c  reason: collision with root package name */
    float[] f24543c;

    /* renamed from: d  reason: collision with root package name */
    final Paint f24544d = new Paint(1);

    /* renamed from: e  reason: collision with root package name */
    private boolean f24545e = false;

    /* renamed from: f  reason: collision with root package name */
    private float f24546f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private float f24547g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private int f24548h = 0;

    /* renamed from: i  reason: collision with root package name */
    private boolean f24549i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f24550j = false;

    /* renamed from: w  reason: collision with root package name */
    final Path f24551w = new Path();

    public k(int i10) {
        f(i10);
    }

    public static k a(ColorDrawable colorDrawable) {
        return new k(colorDrawable.getColor());
    }

    private void g() {
        float f10;
        float[] fArr;
        float[] fArr2;
        this.f24551w.reset();
        this.C.reset();
        this.Y.set(getBounds());
        RectF rectF = this.Y;
        float f11 = this.f24546f;
        rectF.inset(f11 / 2.0f, f11 / 2.0f);
        int i10 = 0;
        if (this.f24545e) {
            this.C.addCircle(this.Y.centerX(), this.Y.centerY(), Math.min(this.Y.width(), this.Y.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i11 = 0;
            while (true) {
                fArr2 = this.f24542b;
                if (i11 >= fArr2.length) {
                    break;
                }
                fArr2[i11] = (this.f24541a[i11] + this.f24547g) - (this.f24546f / 2.0f);
                i11++;
            }
            this.C.addRoundRect(this.Y, fArr2, Path.Direction.CW);
        }
        RectF rectF2 = this.Y;
        float f12 = this.f24546f;
        rectF2.inset((-f12) / 2.0f, (-f12) / 2.0f);
        float f13 = this.f24547g;
        if (this.f24549i) {
            f10 = this.f24546f;
        } else {
            f10 = 0.0f;
        }
        float f14 = f13 + f10;
        this.Y.inset(f14, f14);
        if (this.f24545e) {
            this.f24551w.addCircle(this.Y.centerX(), this.Y.centerY(), Math.min(this.Y.width(), this.Y.height()) / 2.0f, Path.Direction.CW);
        } else if (this.f24549i) {
            if (this.f24543c == null) {
                this.f24543c = new float[8];
            }
            while (true) {
                fArr = this.f24543c;
                if (i10 >= fArr.length) {
                    break;
                }
                fArr[i10] = this.f24541a[i10] - this.f24546f;
                i10++;
            }
            this.f24551w.addRoundRect(this.Y, fArr, Path.Direction.CW);
        } else {
            this.f24551w.addRoundRect(this.Y, this.f24541a, Path.Direction.CW);
        }
        float f15 = -f14;
        this.Y.inset(f15, f15);
    }

    public void b(int i10, float f10) {
        if (this.f24548h != i10) {
            this.f24548h = i10;
            invalidateSelf();
        }
        if (this.f24546f != f10) {
            this.f24546f = f10;
            g();
            invalidateSelf();
        }
    }

    public boolean c() {
        return this.f24550j;
    }

    public void d(boolean z10) {
    }

    public void draw(Canvas canvas) {
        this.f24544d.setColor(e.c(this.X, this.Z));
        this.f24544d.setStyle(Paint.Style.FILL);
        this.f24544d.setFilterBitmap(c());
        canvas.drawPath(this.f24551w, this.f24544d);
        if (this.f24546f != 0.0f) {
            this.f24544d.setColor(e.c(this.f24548h, this.Z));
            this.f24544d.setStyle(Paint.Style.STROKE);
            this.f24544d.setStrokeWidth(this.f24546f);
            canvas.drawPath(this.C, this.f24544d);
        }
    }

    public void e(boolean z10) {
        this.f24545e = z10;
        g();
        invalidateSelf();
    }

    public void f(int i10) {
        if (this.X != i10) {
            this.X = i10;
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.Z;
    }

    public int getOpacity() {
        return e.b(e.c(this.X, this.Z));
    }

    public void h(boolean z10) {
        if (this.f24550j != z10) {
            this.f24550j = z10;
            invalidateSelf();
        }
    }

    public void j(boolean z10) {
        if (this.f24549i != z10) {
            this.f24549i = z10;
            g();
            invalidateSelf();
        }
    }

    public void m(float f10) {
        if (this.f24547g != f10) {
            this.f24547g = f10;
            g();
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        g();
    }

    public void q(float f10) {
        boolean z10;
        if (f10 >= 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.c(z10, "radius should be non negative");
        Arrays.fill(this.f24541a, f10);
        g();
        invalidateSelf();
    }

    public void s(float[] fArr) {
        boolean z10;
        if (fArr == null) {
            Arrays.fill(this.f24541a, 0.0f);
        } else {
            if (fArr.length == 8) {
                z10 = true;
            } else {
                z10 = false;
            }
            l.c(z10, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f24541a, 0, 8);
        }
        g();
        invalidateSelf();
    }

    public void setAlpha(int i10) {
        if (i10 != this.Z) {
            this.Z = i10;
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
