package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class d extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private float f14456a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f14457b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f14458c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f14459d;

    /* renamed from: e  reason: collision with root package name */
    private float f14460e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14461f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14462g = true;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f14463h;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuffColorFilter f14464i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f14465j;

    /* renamed from: k  reason: collision with root package name */
    private PorterDuff.Mode f14466k = PorterDuff.Mode.SRC_IN;

    d(ColorStateList colorStateList, float f10) {
        this.f14456a = f10;
        this.f14457b = new Paint(5);
        e(colorStateList);
        this.f14458c = new RectF();
        this.f14459d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f14463h = colorStateList;
        this.f14457b.setColor(colorStateList.getColorForState(getState(), this.f14463h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f14458c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f14459d.set(rect);
        if (this.f14461f) {
            float b10 = e.b(this.f14460e, this.f14456a, this.f14462g);
            this.f14459d.inset((int) Math.ceil((double) e.a(this.f14460e, this.f14456a, this.f14462g)), (int) Math.ceil((double) b10));
            this.f14458c.set(this.f14459d);
        }
    }

    public ColorStateList b() {
        return this.f14463h;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f14460e;
    }

    public float d() {
        return this.f14456a;
    }

    public void draw(Canvas canvas) {
        boolean z10;
        Paint paint = this.f14457b;
        if (this.f14464i == null || paint.getColorFilter() != null) {
            z10 = false;
        } else {
            paint.setColorFilter(this.f14464i);
            z10 = true;
        }
        RectF rectF = this.f14458c;
        float f10 = this.f14456a;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        if (z10) {
            paint.setColorFilter((ColorFilter) null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void g(float f10, boolean z10, boolean z11) {
        if (f10 != this.f14460e || this.f14461f != z10 || this.f14462g != z11) {
            this.f14460e = f10;
            this.f14461f = z10;
            this.f14462g = z11;
            i((Rect) null);
            invalidateSelf();
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f14459d, this.f14456a);
    }

    /* access modifiers changed from: package-private */
    public void h(float f10) {
        if (f10 != this.f14456a) {
            this.f14456a = f10;
            i((Rect) null);
            invalidateSelf();
        }
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f14465j;
        if ((colorStateList2 == null || !colorStateList2.isStateful()) && (((colorStateList = this.f14463h) == null || !colorStateList.isStateful()) && !super.isStateful())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z10;
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f14463h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (colorForState != this.f14457b.getColor()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f14457b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f14465j;
        if (colorStateList2 == null || (mode = this.f14466k) == null) {
            return z10;
        }
        this.f14464i = a(colorStateList2, mode);
        return true;
    }

    public void setAlpha(int i10) {
        this.f14457b.setAlpha(i10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f14457b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f14465j = colorStateList;
        this.f14464i = a(colorStateList, this.f14466k);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f14466k = mode;
        this.f14464i = a(this.f14465j, mode);
        invalidateSelf();
    }
}
