package w3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;
import l5.b;

public class j extends m {

    /* renamed from: h1  reason: collision with root package name */
    private static boolean f24534h1;

    /* renamed from: b1  reason: collision with root package name */
    private final Paint f24535b1;

    /* renamed from: c1  reason: collision with root package name */
    private final Paint f24536c1;

    /* renamed from: d1  reason: collision with root package name */
    private final Bitmap f24537d1;

    /* renamed from: e1  reason: collision with root package name */
    private WeakReference f24538e1;

    /* renamed from: f1  reason: collision with root package name */
    private boolean f24539f1;

    /* renamed from: g1  reason: collision with root package name */
    private RectF f24540g1 = null;

    public j(Resources resources, Bitmap bitmap, Paint paint, boolean z10) {
        super(new BitmapDrawable(resources, bitmap));
        Paint paint2 = new Paint();
        this.f24535b1 = paint2;
        Paint paint3 = new Paint(1);
        this.f24536c1 = paint3;
        this.f24537d1 = bitmap;
        if (paint != null) {
            paint2.set(paint);
        }
        paint2.setFlags(1);
        paint3.setStyle(Paint.Style.STROKE);
        this.f24539f1 = z10;
    }

    public static boolean k() {
        return f24534h1;
    }

    private void l() {
        WeakReference weakReference = this.f24538e1;
        if (weakReference == null || weakReference.get() != this.f24537d1) {
            this.f24538e1 = new WeakReference(this.f24537d1);
            Paint paint = this.f24535b1;
            Bitmap bitmap = this.f24537d1;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            this.f24569f = true;
        }
        if (this.f24569f) {
            this.f24535b1.getShader().setLocalMatrix(this.V0);
            this.f24569f = false;
        }
        this.f24535b1.setFilterBitmap(a());
    }

    public void d(boolean z10) {
        this.f24539f1 = z10;
    }

    public void draw(Canvas canvas) {
        if (b.d()) {
            b.a("RoundedBitmapDrawable#draw");
        }
        if (!f()) {
            super.draw(canvas);
            if (b.d()) {
                b.b();
                return;
            }
            return;
        }
        i();
        g();
        l();
        int save = canvas.save();
        canvas.concat(this.S0);
        if (this.f24539f1 || this.f24540g1 == null) {
            canvas.drawPath(this.f24568e, this.f24535b1);
        } else {
            int save2 = canvas.save();
            canvas.clipRect(this.f24540g1);
            canvas.drawPath(this.f24568e, this.f24535b1);
            canvas.restoreToCount(save2);
        }
        float f10 = this.f24567d;
        if (f10 > 0.0f) {
            this.f24536c1.setStrokeWidth(f10);
            this.f24536c1.setColor(e.c(this.f24570g, this.f24535b1.getAlpha()));
            canvas.drawPath(this.f24571h, this.f24536c1);
        }
        canvas.restoreToCount(save);
        if (b.d()) {
            b.b();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        if (!super.f() || this.f24537d1 == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void i() {
        super.i();
        if (!this.f24539f1) {
            if (this.f24540g1 == null) {
                this.f24540g1 = new RectF();
            }
            this.V0.mapRect(this.f24540g1, this.Y);
        }
    }

    public void setAlpha(int i10) {
        super.setAlpha(i10);
        if (i10 != this.f24535b1.getAlpha()) {
            this.f24535b1.setAlpha(i10);
            super.setAlpha(i10);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
        this.f24535b1.setColorFilter(colorFilter);
    }
}
