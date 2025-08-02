package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.util.ArrayList;
import java.util.List;

class ClockHandView extends View {
    private final int C;
    private float N0;
    private boolean O0;
    private OnActionUpListener P0;
    private double Q0;
    private int R0;

    /* renamed from: a  reason: collision with root package name */
    private ValueAnimator f8674a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8675b;

    /* renamed from: c  reason: collision with root package name */
    private float f8676c;

    /* renamed from: d  reason: collision with root package name */
    private float f8677d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8678e;

    /* renamed from: f  reason: collision with root package name */
    private int f8679f;

    /* renamed from: g  reason: collision with root package name */
    private final List f8680g;

    /* renamed from: h  reason: collision with root package name */
    private final int f8681h;

    /* renamed from: i  reason: collision with root package name */
    private final float f8682i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f8683j;

    /* renamed from: w  reason: collision with root package name */
    private final RectF f8684w;

    public interface OnActionUpListener {
        void onActionUp(@FloatRange(from = 0.0d, to = 360.0d) float f10, boolean z10);
    }

    public interface OnRotateListener {
        void onRotate(@FloatRange(from = 0.0d, to = 360.0d) float f10, boolean z10);
    }

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.this.n(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    private void c(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f10 = (float) width;
        float f11 = (float) height;
        this.f8683j.setStrokeWidth(0.0f);
        canvas.drawCircle((((float) this.R0) * ((float) Math.cos(this.Q0))) + f10, (((float) this.R0) * ((float) Math.sin(this.Q0))) + f11, (float) this.f8681h, this.f8683j);
        double sin = Math.sin(this.Q0);
        double cos = Math.cos(this.Q0);
        double d10 = (double) ((float) (this.R0 - this.f8681h));
        float f12 = (float) (width + ((int) (cos * d10)));
        float f13 = (float) (height + ((int) (d10 * sin)));
        this.f8683j.setStrokeWidth((float) this.C);
        canvas.drawLine(f10, f11, f12, f13, this.f8683j);
        canvas.drawCircle(f10, f11, this.f8682i, this.f8683j);
    }

    private int e(float f10, float f11) {
        int degrees = (int) Math.toDegrees(Math.atan2((double) (f11 - ((float) (getHeight() / 2))), (double) (f10 - ((float) (getWidth() / 2)))));
        int i10 = degrees + 90;
        if (i10 < 0) {
            return degrees + 450;
        }
        return i10;
    }

    private Pair h(float f10) {
        float f11 = f();
        if (Math.abs(f11 - f10) > 180.0f) {
            if (f11 > 180.0f && f10 < 180.0f) {
                f10 += 360.0f;
            }
            if (f11 < 180.0f && f10 > 180.0f) {
                f11 += 360.0f;
            }
        }
        return new Pair(Float.valueOf(f11), Float.valueOf(f10));
    }

    private boolean i(float f10, float f11, boolean z10, boolean z11, boolean z12) {
        boolean z13;
        float e10 = (float) e(f10, f11);
        boolean z14 = false;
        if (f() != e10) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z11 && z13) {
            return true;
        }
        if (!z13 && !z10) {
            return false;
        }
        if (z12 && this.f8675b) {
            z14 = true;
        }
        m(e10, z14);
        return true;
    }

    /* access modifiers changed from: private */
    public void n(float f10, boolean z10) {
        float f11 = f10 % 360.0f;
        this.N0 = f11;
        this.Q0 = Math.toRadians((double) (f11 - 90.0f));
        float width = ((float) (getWidth() / 2)) + (((float) this.R0) * ((float) Math.cos(this.Q0)));
        float height = ((float) (getHeight() / 2)) + (((float) this.R0) * ((float) Math.sin(this.Q0)));
        RectF rectF = this.f8684w;
        int i10 = this.f8681h;
        rectF.set(width - ((float) i10), height - ((float) i10), width + ((float) i10), height + ((float) i10));
        for (OnRotateListener onRotate : this.f8680g) {
            onRotate.onRotate(f11, z10);
        }
        invalidate();
    }

    public void b(OnRotateListener onRotateListener) {
        this.f8680g.add(onRotateListener);
    }

    public RectF d() {
        return this.f8684w;
    }

    public float f() {
        return this.N0;
    }

    public int g() {
        return this.f8681h;
    }

    public void j(boolean z10) {
        this.f8675b = z10;
    }

    public void k(int i10) {
        this.R0 = i10;
        invalidate();
    }

    public void l(float f10) {
        m(f10, false);
    }

    public void m(float f10, boolean z10) {
        ValueAnimator valueAnimator = this.f8674a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z10) {
            n(f10, false);
            return;
        }
        Pair h10 = h(f10);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{((Float) h10.first).floatValue(), ((Float) h10.second).floatValue()});
        this.f8674a = ofFloat;
        ofFloat.setDuration(200);
        this.f8674a.addUpdateListener(new a());
        this.f8674a.addListener(new b());
        this.f8674a.start();
    }

    public void o(OnActionUpListener onActionUpListener) {
        this.P0 = onActionUpListener;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        l(f());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        boolean z12;
        OnActionUpListener onActionUpListener;
        boolean z13;
        int actionMasked = motionEvent.getActionMasked();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (actionMasked == 0) {
            this.f8676c = x10;
            this.f8677d = y10;
            this.f8678e = true;
            this.O0 = false;
            z12 = false;
            z11 = false;
            z10 = true;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i10 = (int) (x10 - this.f8676c);
            int i11 = (int) (y10 - this.f8677d);
            if ((i10 * i10) + (i11 * i11) > this.f8679f) {
                z13 = true;
            } else {
                z13 = false;
            }
            this.f8678e = z13;
            boolean z14 = this.O0;
            if (actionMasked == 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            z10 = false;
            z11 = z14;
        } else {
            z12 = false;
            z11 = false;
            z10 = false;
        }
        boolean i12 = i(x10, y10, z11, z10, z12) | this.O0;
        this.O0 = i12;
        if (i12 && z12 && (onActionUpListener = this.P0) != null) {
            onActionUpListener.onActionUp((float) e(x10, y10), this.f8678e);
        }
        return true;
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f8680g = new ArrayList();
        Paint paint = new Paint();
        this.f8683j = paint;
        this.f8684w = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockHandView, i10, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.R0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_materialCircleRadius, 0);
        this.f8681h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_selectorSize, 0);
        Resources resources = getResources();
        this.C = resources.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f8682i = (float) resources.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(R.styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        l(0.0f);
        this.f8679f = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        obtainStyledAttributes.recycle();
    }
}
