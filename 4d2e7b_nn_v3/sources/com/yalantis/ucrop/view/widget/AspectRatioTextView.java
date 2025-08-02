package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.model.AspectRatio;
import fb.a;
import fb.b;
import fb.h;
import java.util.Locale;

public class AspectRatioTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private final float f11843a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f11844b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f11845c;

    /* renamed from: d  reason: collision with root package name */
    private int f11846d;

    /* renamed from: e  reason: collision with root package name */
    private float f11847e;

    /* renamed from: f  reason: collision with root package name */
    private String f11848f;

    /* renamed from: g  reason: collision with root package name */
    private float f11849g;

    /* renamed from: h  reason: collision with root package name */
    private float f11850h;

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i10) {
        Paint paint = this.f11845c;
        if (paint != null) {
            paint.setColor(i10);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{16842913}, new int[]{0}}, new int[]{i10, ContextCompat.getColor(getContext(), a.f12092k)}));
    }

    private void c(TypedArray typedArray) {
        setGravity(1);
        this.f11848f = typedArray.getString(h.R);
        this.f11849g = typedArray.getFloat(h.S, 0.0f);
        float f10 = typedArray.getFloat(h.T, 0.0f);
        this.f11850h = f10;
        float f11 = this.f11849g;
        if (f11 == 0.0f || f10 == 0.0f) {
            this.f11847e = 0.0f;
        } else {
            this.f11847e = f11 / f10;
        }
        this.f11846d = getContext().getResources().getDimensionPixelSize(b.f12102h);
        Paint paint = new Paint(1);
        this.f11845c = paint;
        paint.setStyle(Paint.Style.FILL);
        d();
        a(getResources().getColor(a.f12093l));
        typedArray.recycle();
    }

    private void d() {
        if (!TextUtils.isEmpty(this.f11848f)) {
            setText(this.f11848f);
            return;
        }
        setText(String.format(Locale.US, "%d:%d", new Object[]{Integer.valueOf((int) this.f11849g), Integer.valueOf((int) this.f11850h)}));
    }

    private void e() {
        if (this.f11847e != 0.0f) {
            float f10 = this.f11849g;
            float f11 = this.f11850h;
            this.f11849g = f11;
            this.f11850h = f10;
            this.f11847e = f11 / f10;
        }
    }

    public float b(boolean z10) {
        if (z10) {
            e();
            d();
        }
        return this.f11847e;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.f11844b);
            Rect rect = this.f11844b;
            float f10 = ((float) rect.bottom) - (((float) rect.top) / 2.0f);
            int i10 = this.f11846d;
            canvas.drawCircle(((float) (rect.right - rect.left)) / 2.0f, f10 - (((float) i10) * 1.5f), ((float) i10) / 2.0f, this.f11845c);
        }
    }

    public void setActiveColor(@ColorInt int i10) {
        a(i10);
        invalidate();
    }

    public void setAspectRatio(@NonNull AspectRatio aspectRatio) {
        this.f11848f = aspectRatio.a();
        this.f11849g = aspectRatio.b();
        float c10 = aspectRatio.c();
        this.f11850h = c10;
        float f10 = this.f11849g;
        if (f10 == 0.0f || c10 == 0.0f) {
            this.f11847e = 0.0f;
        } else {
            this.f11847e = f10 / c10;
        }
        d();
    }

    @TargetApi(21)
    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11843a = 1.5f;
        this.f11844b = new Rect();
        c(context.obtainStyledAttributes(attributeSet, h.Q));
    }
}
