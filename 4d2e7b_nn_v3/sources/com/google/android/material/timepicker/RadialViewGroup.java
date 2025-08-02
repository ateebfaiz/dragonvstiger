package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;

class RadialViewGroup extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f8690a;

    /* renamed from: b  reason: collision with root package name */
    private int f8691b;

    /* renamed from: c  reason: collision with root package name */
    private MaterialShapeDrawable f8692c;

    class a implements Runnable {
        a() {
        }

        public void run() {
            RadialViewGroup.this.e();
        }
    }

    public RadialViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Drawable a() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.f8692c = materialShapeDrawable;
        materialShapeDrawable.setCornerSize((CornerSize) new RelativeCornerSize(0.5f));
        this.f8692c.setFillColor(ColorStateList.valueOf(-1));
        return this.f8692c;
    }

    private static boolean d(View view) {
        return "skip".equals(view.getTag());
    }

    private void f() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f8690a);
            handler.post(this.f8690a);
        }
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        if (view.getId() == -1) {
            view.setId(ViewCompat.generateViewId());
        }
        f();
    }

    public int b() {
        return this.f8691b;
    }

    public void c(int i10) {
        this.f8691b = i10;
        e();
    }

    /* access modifiers changed from: protected */
    public void e() {
        int childCount = getChildCount();
        int i10 = 1;
        for (int i11 = 0; i11 < childCount; i11++) {
            if (d(getChildAt(i11))) {
                i10++;
            }
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone((ConstraintLayout) this);
        float f10 = 0.0f;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getId() != R.id.circle_center && !d(childAt)) {
                constraintSet.constrainCircle(childAt.getId(), R.id.circle_center, this.f8691b, f10);
                f10 += 360.0f / ((float) (childCount - i10));
            }
        }
        constraintSet.applyTo(this);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        e();
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        f();
    }

    public void setBackgroundColor(int i10) {
        this.f8692c.setFillColor(ColorStateList.valueOf(i10));
    }

    public RadialViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        ViewCompat.setBackground(this, a());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RadialViewGroup, i10, 0);
        this.f8691b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RadialViewGroup_materialCircleRadius, 0);
        this.f8690a = new a();
        obtainStyledAttributes.recycle();
    }
}
