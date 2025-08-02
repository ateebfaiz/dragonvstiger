package com.google.android.material.floatingactionbutton;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

class c extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final ShapeAppearancePathProvider f8239a = ShapeAppearancePathProvider.getInstance();

    /* renamed from: b  reason: collision with root package name */
    private final Paint f8240b;

    /* renamed from: c  reason: collision with root package name */
    private final Path f8241c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final Rect f8242d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final RectF f8243e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private final RectF f8244f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final b f8245g = new b();

    /* renamed from: h  reason: collision with root package name */
    float f8246h;

    /* renamed from: i  reason: collision with root package name */
    private int f8247i;

    /* renamed from: j  reason: collision with root package name */
    private int f8248j;

    /* renamed from: k  reason: collision with root package name */
    private int f8249k;

    /* renamed from: l  reason: collision with root package name */
    private int f8250l;

    /* renamed from: m  reason: collision with root package name */
    private int f8251m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f8252n = true;

    /* renamed from: o  reason: collision with root package name */
    private ShapeAppearanceModel f8253o;

    /* renamed from: p  reason: collision with root package name */
    private ColorStateList f8254p;

    private class b extends Drawable.ConstantState {
        private b() {
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return c.this;
        }
    }

    c(ShapeAppearanceModel shapeAppearanceModel) {
        this.f8253o = shapeAppearanceModel;
        Paint paint = new Paint(1);
        this.f8240b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    private Shader a() {
        Rect rect = this.f8242d;
        copyBounds(rect);
        float height = this.f8246h / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{ColorUtils.compositeColors(this.f8247i, this.f8251m), ColorUtils.compositeColors(this.f8248j, this.f8251m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f8248j, 0), this.f8251m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f8250l, 0), this.f8251m), ColorUtils.compositeColors(this.f8250l, this.f8251m), ColorUtils.compositeColors(this.f8249k, this.f8251m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    /* access modifiers changed from: protected */
    public RectF b() {
        this.f8244f.set(getBounds());
        return this.f8244f;
    }

    /* access modifiers changed from: package-private */
    public void c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f8251m = colorStateList.getColorForState(getState(), this.f8251m);
        }
        this.f8254p = colorStateList;
        this.f8252n = true;
        invalidateSelf();
    }

    public void d(float f10) {
        if (this.f8246h != f10) {
            this.f8246h = f10;
            this.f8240b.setStrokeWidth(f10 * 1.3333f);
            this.f8252n = true;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.f8252n) {
            this.f8240b.setShader(a());
            this.f8252n = false;
        }
        float strokeWidth = this.f8240b.getStrokeWidth() / 2.0f;
        copyBounds(this.f8242d);
        this.f8243e.set(this.f8242d);
        float min = Math.min(this.f8253o.getTopLeftCornerSize().getCornerSize(b()), this.f8243e.width() / 2.0f);
        if (this.f8253o.isRoundRect(b())) {
            this.f8243e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f8243e, min, min, this.f8240b);
        }
    }

    /* access modifiers changed from: package-private */
    public void e(int i10, int i11, int i12, int i13) {
        this.f8247i = i10;
        this.f8248j = i11;
        this.f8249k = i12;
        this.f8250l = i13;
    }

    public void f(ShapeAppearanceModel shapeAppearanceModel) {
        this.f8253o = shapeAppearanceModel;
        invalidateSelf();
    }

    public Drawable.ConstantState getConstantState() {
        return this.f8245g;
    }

    public int getOpacity() {
        if (this.f8246h > 0.0f) {
            return -3;
        }
        return -2;
    }

    public void getOutline(Outline outline) {
        if (this.f8253o.isRoundRect(b())) {
            outline.setRoundRect(getBounds(), this.f8253o.getTopLeftCornerSize().getCornerSize(b()));
            return;
        }
        copyBounds(this.f8242d);
        this.f8243e.set(this.f8242d);
        this.f8239a.calculatePath(this.f8253o, 1.0f, this.f8243e, this.f8241c);
        if (this.f8241c.isConvex()) {
            outline.setConvexPath(this.f8241c);
        }
    }

    public boolean getPadding(Rect rect) {
        if (!this.f8253o.isRoundRect(b())) {
            return true;
        }
        int round = Math.round(this.f8246h);
        rect.set(round, round, round, round);
        return true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f8254p;
        if ((colorStateList == null || !colorStateList.isStateful()) && !super.isStateful()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f8252n = true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f8254p;
        if (!(colorStateList == null || (colorForState = colorStateList.getColorForState(iArr, this.f8251m)) == this.f8251m)) {
            this.f8252n = true;
            this.f8251m = colorForState;
        }
        if (this.f8252n) {
            invalidateSelf();
        }
        return this.f8252n;
    }

    public void setAlpha(int i10) {
        this.f8240b.setAlpha(i10);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f8240b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
