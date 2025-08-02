package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;

class e extends d {

    static class a extends MaterialShapeDrawable {
        a(ShapeAppearanceModel shapeAppearanceModel) {
            super(shapeAppearanceModel);
        }

        public boolean isStateful() {
            return true;
        }
    }

    e(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        super(floatingActionButton, shadowViewDelegate);
    }

    private Animator l0(float f10, float f11) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f8278w, "elevation", new float[]{f10}).setDuration(0)).with(ObjectAnimator.ofFloat(this.f8278w, View.TRANSLATION_Z, new float[]{f11}).setDuration(100));
        animatorSet.setInterpolator(d.D);
        return animatorSet;
    }

    /* access modifiers changed from: package-private */
    public void B() {
        h0();
    }

    /* access modifiers changed from: package-private */
    public void D(int[] iArr) {
    }

    /* access modifiers changed from: package-private */
    public void E(float f10, float f11, float f12) {
        int i10 = Build.VERSION.SDK_INT;
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(d.E, l0(f10, f12));
        stateListAnimator.addState(d.F, l0(f10, f11));
        stateListAnimator.addState(d.G, l0(f10, f11));
        stateListAnimator.addState(d.H, l0(f10, f11));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f8278w, "elevation", new float[]{f10}).setDuration(0));
        if (i10 <= 24) {
            FloatingActionButton floatingActionButton = this.f8278w;
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, new float[]{floatingActionButton.getTranslationZ()}).setDuration(100));
        }
        arrayList.add(ObjectAnimator.ofFloat(this.f8278w, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(d.D);
        stateListAnimator.addState(d.I, animatorSet);
        stateListAnimator.addState(d.J, l0(0.0f, 0.0f));
        this.f8278w.setStateListAnimator(stateListAnimator);
        if (b0()) {
            h0();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean M() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void X(ColorStateList colorStateList) {
        Drawable drawable = this.f8258c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        } else {
            super.X(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b0() {
        if (this.f8279x.isCompatPaddingEnabled() || !d0()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void f0() {
    }

    /* access modifiers changed from: package-private */
    public c k0(int i10, ColorStateList colorStateList) {
        Context context = this.f8278w.getContext();
        c cVar = new c((ShapeAppearanceModel) Preconditions.checkNotNull(this.f8256a));
        cVar.e(ContextCompat.getColor(context, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_outer_color));
        cVar.d((float) i10);
        cVar.c(colorStateList);
        return cVar;
    }

    public float m() {
        return this.f8278w.getElevation();
    }

    /* access modifiers changed from: package-private */
    public MaterialShapeDrawable m0() {
        return new a((ShapeAppearanceModel) Preconditions.checkNotNull(this.f8256a));
    }

    /* access modifiers changed from: package-private */
    public void r(Rect rect) {
        if (this.f8279x.isCompatPaddingEnabled()) {
            super.r(rect);
        } else if (!d0()) {
            int sizeDimension = (this.f8266k - this.f8278w.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i10) {
        Drawable drawable;
        MaterialShapeDrawable m02 = m0();
        this.f8257b = m02;
        m02.setTintList(colorStateList);
        if (mode != null) {
            this.f8257b.setTintMode(mode);
        }
        this.f8257b.initializeElevationOverlay(this.f8278w.getContext());
        if (i10 > 0) {
            this.f8259d = k0(i10, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.f8259d), (Drawable) Preconditions.checkNotNull(this.f8257b)});
        } else {
            this.f8259d = null;
            drawable = this.f8257b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(colorStateList2), drawable, (Drawable) null);
        this.f8258c = rippleDrawable;
        this.f8260e = rippleDrawable;
    }

    /* access modifiers changed from: package-private */
    public void z() {
    }
}
