package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;

final class a extends d {

    /* renamed from: c  reason: collision with root package name */
    private int f8376c = 1;

    /* renamed from: d  reason: collision with root package name */
    private float f8377d;

    /* renamed from: e  reason: collision with root package name */
    private float f8378e;

    /* renamed from: f  reason: collision with root package name */
    private float f8379f;

    public a(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
    }

    private void h(Canvas canvas, Paint paint, float f10, float f11, float f12) {
        canvas.save();
        canvas.rotate(f12);
        float f13 = this.f8379f;
        float f14 = f10 / 2.0f;
        canvas.drawRoundRect(new RectF(f13 - f14, f11, f13 + f14, -f11), f11, f11, paint);
        canvas.restore();
    }

    private int i() {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f8397a;
        return ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).indicatorSize + (((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).indicatorInset * 2);
    }

    public void a(Canvas canvas, float f10) {
        int i10;
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f8397a;
        float f11 = (((float) ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).indicatorSize) / 2.0f) + ((float) ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).indicatorInset);
        canvas.translate(f11, f11);
        canvas.rotate(-90.0f);
        float f12 = -f11;
        canvas.clipRect(f12, f12, f11, f11);
        BaseProgressIndicatorSpec baseProgressIndicatorSpec2 = this.f8397a;
        if (((CircularProgressIndicatorSpec) baseProgressIndicatorSpec2).indicatorDirection == 0) {
            i10 = 1;
        } else {
            i10 = -1;
        }
        this.f8376c = i10;
        this.f8377d = ((float) ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec2).trackThickness) * f10;
        this.f8378e = ((float) ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec2).trackCornerRadius) * f10;
        this.f8379f = ((float) (((CircularProgressIndicatorSpec) baseProgressIndicatorSpec2).indicatorSize - ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec2).trackThickness)) / 2.0f;
        if ((this.f8398b.isShowing() && ((CircularProgressIndicatorSpec) this.f8397a).showAnimationBehavior == 2) || (this.f8398b.isHiding() && ((CircularProgressIndicatorSpec) this.f8397a).hideAnimationBehavior == 1)) {
            this.f8379f += ((1.0f - f10) * ((float) ((CircularProgressIndicatorSpec) this.f8397a).trackThickness)) / 2.0f;
        } else if ((this.f8398b.isShowing() && ((CircularProgressIndicatorSpec) this.f8397a).showAnimationBehavior == 1) || (this.f8398b.isHiding() && ((CircularProgressIndicatorSpec) this.f8397a).hideAnimationBehavior == 2)) {
            this.f8379f -= ((1.0f - f10) * ((float) ((CircularProgressIndicatorSpec) this.f8397a).trackThickness)) / 2.0f;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Canvas canvas, Paint paint, float f10, float f11, int i10) {
        float f12;
        Paint paint2 = paint;
        if (f10 != f11) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.BUTT);
            paint.setAntiAlias(true);
            paint.setColor(i10);
            paint.setStrokeWidth(this.f8377d);
            int i11 = this.f8376c;
            float f13 = f10 * 360.0f * ((float) i11);
            if (f11 >= f10) {
                f12 = f11 - f10;
            } else {
                f12 = (1.0f + f11) - f10;
            }
            float f14 = f12 * 360.0f * ((float) i11);
            float f15 = this.f8379f;
            canvas.drawArc(new RectF(-f15, -f15, f15, f15), f13, f14, false, paint);
            if (this.f8378e > 0.0f && Math.abs(f14) < 360.0f) {
                paint.setStyle(Paint.Style.FILL);
                Canvas canvas2 = canvas;
                Paint paint3 = paint;
                h(canvas2, paint3, this.f8377d, this.f8378e, f13);
                h(canvas2, paint3, this.f8377d, this.f8378e, f13 + f14);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Canvas canvas, Paint paint) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((CircularProgressIndicatorSpec) this.f8397a).trackColor, this.f8398b.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(compositeARGBWithAlpha);
        paint.setStrokeWidth(this.f8377d);
        float f10 = this.f8379f;
        canvas.drawArc(new RectF(-f10, -f10, f10, f10), 0.0f, 360.0f, false, paint);
    }

    public int d() {
        return i();
    }

    public int e() {
        return i();
    }
}
