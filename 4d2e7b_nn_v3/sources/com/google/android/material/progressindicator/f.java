package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;

final class f extends d {

    /* renamed from: c  reason: collision with root package name */
    private float f8402c = 300.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f8403d;

    /* renamed from: e  reason: collision with root package name */
    private float f8404e;

    public f(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
    }

    public void a(Canvas canvas, float f10) {
        Rect clipBounds = canvas.getClipBounds();
        this.f8402c = (float) clipBounds.width();
        float f11 = (float) ((LinearProgressIndicatorSpec) this.f8397a).trackThickness;
        canvas.translate(((float) clipBounds.left) + (((float) clipBounds.width()) / 2.0f), ((float) clipBounds.top) + (((float) clipBounds.height()) / 2.0f) + Math.max(0.0f, ((float) (clipBounds.height() - ((LinearProgressIndicatorSpec) this.f8397a).trackThickness)) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.f8397a).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.f8398b.isShowing() && ((LinearProgressIndicatorSpec) this.f8397a).showAnimationBehavior == 1) || (this.f8398b.isHiding() && ((LinearProgressIndicatorSpec) this.f8397a).hideAnimationBehavior == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.f8398b.isShowing() || this.f8398b.isHiding()) {
            canvas.translate(0.0f, (((float) ((LinearProgressIndicatorSpec) this.f8397a).trackThickness) * (f10 - 1.0f)) / 2.0f);
        }
        float f12 = this.f8402c;
        canvas.clipRect((-f12) / 2.0f, (-f11) / 2.0f, f12 / 2.0f, f11 / 2.0f);
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f8397a;
        this.f8403d = ((float) ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).trackThickness) * f10;
        this.f8404e = ((float) ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).trackCornerRadius) * f10;
    }

    public void b(Canvas canvas, Paint paint, float f10, float f11, int i10) {
        if (f10 != f11) {
            float f12 = this.f8402c;
            float f13 = this.f8404e;
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setColor(i10);
            float f14 = this.f8403d;
            RectF rectF = new RectF(((-f12) / 2.0f) + (f10 * (f12 - (f13 * 2.0f))), (-f14) / 2.0f, ((-f12) / 2.0f) + (f11 * (f12 - (f13 * 2.0f))) + (f13 * 2.0f), f14 / 2.0f);
            float f15 = this.f8404e;
            canvas.drawRoundRect(rectF, f15, f15, paint);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Canvas canvas, Paint paint) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((LinearProgressIndicatorSpec) this.f8397a).trackColor, this.f8398b.getAlpha());
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(compositeARGBWithAlpha);
        float f10 = this.f8402c;
        float f11 = this.f8403d;
        RectF rectF = new RectF((-f10) / 2.0f, (-f11) / 2.0f, f10 / 2.0f, f11 / 2.0f);
        float f12 = this.f8404e;
        canvas.drawRoundRect(rectF, f12, f12, paint);
    }

    public int d() {
        return ((LinearProgressIndicatorSpec) this.f8397a).trackThickness;
    }

    public int e() {
        return -1;
    }
}
