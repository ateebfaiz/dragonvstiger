package com.google.android.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RippleDrawableCompat extends Drawable implements Shapeable, TintAwareDrawable {
    private b drawableState;

    public void draw(Canvas canvas) {
        b bVar = this.drawableState;
        if (bVar.f8433b) {
            bVar.f8432a.draw(canvas);
        }
    }

    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    public int getOpacity() {
        return this.drawableState.f8432a.getOpacity();
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.f8432a.getShapeAppearanceModel();
    }

    public boolean isStateful() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.drawableState.f8432a.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(@NonNull int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.drawableState.f8432a.setState(iArr)) {
            onStateChange = true;
        }
        boolean shouldDrawRippleCompat = RippleUtils.shouldDrawRippleCompat(iArr);
        b bVar = this.drawableState;
        if (bVar.f8433b == shouldDrawRippleCompat) {
            return onStateChange;
        }
        bVar.f8433b = shouldDrawRippleCompat;
        return true;
    }

    public void setAlpha(int i10) {
        this.drawableState.f8432a.setAlpha(i10);
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.drawableState.f8432a.setColorFilter(colorFilter);
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.drawableState.f8432a.setShapeAppearanceModel(shapeAppearanceModel);
    }

    public void setTint(@ColorInt int i10) {
        this.drawableState.f8432a.setTint(i10);
    }

    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.drawableState.f8432a.setTintList(colorStateList);
    }

    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.drawableState.f8432a.setTintMode(mode);
    }

    public RippleDrawableCompat(ShapeAppearanceModel shapeAppearanceModel) {
        this(new b(new MaterialShapeDrawable(shapeAppearanceModel)));
    }

    @NonNull
    public RippleDrawableCompat mutate() {
        this.drawableState = new b(this.drawableState);
        return this;
    }

    static final class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        MaterialShapeDrawable f8432a;

        /* renamed from: b  reason: collision with root package name */
        boolean f8433b;

        public b(MaterialShapeDrawable materialShapeDrawable) {
            this.f8432a = materialShapeDrawable;
            this.f8433b = false;
        }

        /* renamed from: a */
        public RippleDrawableCompat newDrawable() {
            return new RippleDrawableCompat(new b(this));
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public b(b bVar) {
            this.f8432a = (MaterialShapeDrawable) bVar.f8432a.getConstantState().newDrawable();
            this.f8433b = bVar.f8433b;
        }
    }

    private RippleDrawableCompat(b bVar) {
        this.drawableState = bVar;
    }
}
