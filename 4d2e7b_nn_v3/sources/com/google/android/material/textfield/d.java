package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

class d extends MaterialShapeDrawable {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f8583a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f8584b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    d(ShapeAppearanceModel shapeAppearanceModel) {
        super(shapeAppearanceModel == null ? new ShapeAppearanceModel() : shapeAppearanceModel);
        this.f8583a = new Paint(1);
        e();
        this.f8584b = new RectF();
    }

    private void e() {
        this.f8583a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f8583a.setColor(-1);
        this.f8583a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return !this.f8584b.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        c(0.0f, 0.0f, 0.0f, 0.0f);
    }

    /* access modifiers changed from: package-private */
    public void c(float f10, float f11, float f12, float f13) {
        RectF rectF = this.f8584b;
        if (f10 != rectF.left || f11 != rectF.top || f12 != rectF.right || f13 != rectF.bottom) {
            rectF.set(f10, f11, f12, f13);
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void d(RectF rectF) {
        c(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* access modifiers changed from: protected */
    public void drawStrokeShape(Canvas canvas) {
        if (this.f8584b.isEmpty()) {
            super.drawStrokeShape(canvas);
            return;
        }
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            boolean unused = canvas.clipOutRect(this.f8584b);
        } else {
            canvas.clipRect(this.f8584b, Region.Op.DIFFERENCE);
        }
        super.drawStrokeShape(canvas);
        canvas.restore();
    }
}
