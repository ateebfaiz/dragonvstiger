package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f8175a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorStateList f8176b;

    /* renamed from: c  reason: collision with root package name */
    private final ColorStateList f8177c;

    /* renamed from: d  reason: collision with root package name */
    private final ColorStateList f8178d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8179e;

    /* renamed from: f  reason: collision with root package name */
    private final ShapeAppearanceModel f8180f;

    private a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i10, ShapeAppearanceModel shapeAppearanceModel, Rect rect) {
        Preconditions.checkArgumentNonnegative(rect.left);
        Preconditions.checkArgumentNonnegative(rect.top);
        Preconditions.checkArgumentNonnegative(rect.right);
        Preconditions.checkArgumentNonnegative(rect.bottom);
        this.f8175a = rect;
        this.f8176b = colorStateList2;
        this.f8177c = colorStateList;
        this.f8178d = colorStateList3;
        this.f8179e = i10;
        this.f8180f = shapeAppearanceModel;
    }

    static a a(Context context, int i10) {
        boolean z10;
        if (i10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, R.styleable.MaterialCalendarItem);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        ShapeAppearanceModel build = ShapeAppearanceModel.builder(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).build();
        obtainStyledAttributes.recycle();
        return new a(colorStateList, colorStateList2, colorStateList3, dimensionPixelSize, build, rect);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f8175a.bottom;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f8175a.top;
    }

    /* access modifiers changed from: package-private */
    public void d(TextView textView) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable();
        materialShapeDrawable.setShapeAppearanceModel(this.f8180f);
        materialShapeDrawable2.setShapeAppearanceModel(this.f8180f);
        materialShapeDrawable.setFillColor(this.f8177c);
        materialShapeDrawable.setStroke((float) this.f8179e, this.f8178d);
        textView.setTextColor(this.f8176b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f8176b.withAlpha(30), materialShapeDrawable, materialShapeDrawable2);
        Rect rect = this.f8175a;
        ViewCompat.setBackground(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
