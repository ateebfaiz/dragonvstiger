package w3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class g extends Drawable implements Drawable.Callback, r, q, c {

    /* renamed from: d  reason: collision with root package name */
    private static final Matrix f24525d = new Matrix();

    /* renamed from: a  reason: collision with root package name */
    private Drawable f24526a;

    /* renamed from: b  reason: collision with root package name */
    private final d f24527b = new d();

    /* renamed from: c  reason: collision with root package name */
    protected r f24528c;

    public g(Drawable drawable) {
        this.f24526a = drawable;
        e.d(drawable, this, this);
    }

    public void c(r rVar) {
        this.f24528c = rVar;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f24526a;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    public void g(Matrix matrix) {
        t(matrix);
    }

    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f24526a;
        if (drawable == null) {
            return super.getConstantState();
        }
        return drawable.getConstantState();
    }

    public Drawable getCurrent() {
        return this.f24526a;
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f24526a;
        if (drawable == null) {
            return super.getIntrinsicHeight();
        }
        return drawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f24526a;
        if (drawable == null) {
            return super.getIntrinsicWidth();
        }
        return drawable.getIntrinsicWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f24526a;
        if (drawable == null) {
            return 0;
        }
        return drawable.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        Drawable drawable = this.f24526a;
        if (drawable == null) {
            return super.getPadding(rect);
        }
        return drawable.getPadding(rect);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isStateful() {
        Drawable drawable = this.f24526a;
        if (drawable == null) {
            return false;
        }
        return drawable.isStateful();
    }

    public void l(RectF rectF) {
        r rVar = this.f24528c;
        if (rVar != null) {
            rVar.l(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    public Drawable mutate() {
        Drawable drawable = this.f24526a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f24526a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i10) {
        Drawable drawable = this.f24526a;
        if (drawable == null) {
            return super.onLevelChange(i10);
        }
        return drawable.setLevel(i10);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f24526a;
        if (drawable == null) {
            return super.onStateChange(iArr);
        }
        return drawable.setState(iArr);
    }

    public Drawable r() {
        return getCurrent();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    public void setAlpha(int i10) {
        this.f24527b.b(i10);
        Drawable drawable = this.f24526a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f24527b.c(colorFilter);
        Drawable drawable = this.f24526a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }

    public void setDither(boolean z10) {
        this.f24527b.d(z10);
        Drawable drawable = this.f24526a;
        if (drawable != null) {
            drawable.setDither(z10);
        }
    }

    public Drawable setDrawable(Drawable drawable) {
        return u(drawable);
    }

    public void setFilterBitmap(boolean z10) {
        this.f24527b.e(z10);
        Drawable drawable = this.f24526a;
        if (drawable != null) {
            drawable.setFilterBitmap(z10);
        }
    }

    public void setHotspot(float f10, float f11) {
        Drawable drawable = this.f24526a;
        if (drawable != null) {
            drawable.setHotspot(f10, f11);
        }
    }

    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        Drawable drawable = this.f24526a;
        if (drawable == null) {
            return visible;
        }
        return drawable.setVisible(z10, z11);
    }

    /* access modifiers changed from: protected */
    public void t(Matrix matrix) {
        r rVar = this.f24528c;
        if (rVar != null) {
            rVar.g(matrix);
        } else {
            matrix.reset();
        }
    }

    public Drawable u(Drawable drawable) {
        Drawable v10 = v(drawable);
        invalidateSelf();
        return v10;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* access modifiers changed from: protected */
    public Drawable v(Drawable drawable) {
        Drawable drawable2 = this.f24526a;
        e.d(drawable2, (Drawable.Callback) null, (r) null);
        e.d(drawable, (Drawable.Callback) null, (r) null);
        e.e(drawable, this.f24527b);
        e.a(drawable, this);
        e.d(drawable, this, this);
        this.f24526a = drawable;
        return drawable2;
    }
}
