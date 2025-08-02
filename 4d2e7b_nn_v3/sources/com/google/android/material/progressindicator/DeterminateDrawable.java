package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec> extends c {
    private static final FloatPropertyCompat<DeterminateDrawable> INDICATOR_LENGTH_IN_LEVEL = new a("indicatorLevel");
    private static final int MAX_DRAWABLE_LEVEL = 10000;
    private static final float SPRING_FORCE_STIFFNESS = 50.0f;
    private d drawingDelegate;
    private float indicatorFraction;
    private boolean skipAnimationOnLevelChange = false;
    private final SpringAnimation springAnimation;
    private final SpringForce springForce;

    class a extends FloatPropertyCompat {
        a(String str) {
            super(str);
        }

        /* renamed from: a */
        public float getValue(DeterminateDrawable determinateDrawable) {
            return determinateDrawable.getIndicatorFraction() * 10000.0f;
        }

        /* renamed from: b */
        public void setValue(DeterminateDrawable determinateDrawable, float f10) {
            determinateDrawable.setIndicatorFraction(f10 / 10000.0f);
        }
    }

    DeterminateDrawable(@NonNull Context context, @NonNull BaseProgressIndicatorSpec baseProgressIndicatorSpec, @NonNull d dVar) {
        super(context, baseProgressIndicatorSpec);
        setDrawingDelegate(dVar);
        SpringForce springForce2 = new SpringForce();
        this.springForce = springForce2;
        springForce2.setDampingRatio(1.0f);
        springForce2.setStiffness(50.0f);
        SpringAnimation springAnimation2 = new SpringAnimation(this, INDICATOR_LENGTH_IN_LEVEL);
        this.springAnimation = springAnimation2;
        springAnimation2.setSpring(springForce2);
        setGrowFraction(1.0f);
    }

    @NonNull
    public static DeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new DeterminateDrawable<>(context, circularProgressIndicatorSpec, new a(circularProgressIndicatorSpec));
    }

    @NonNull
    public static DeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new DeterminateDrawable<>(context, linearProgressIndicatorSpec, new f(linearProgressIndicatorSpec));
    }

    /* access modifiers changed from: private */
    public float getIndicatorFraction() {
        return this.indicatorFraction;
    }

    /* access modifiers changed from: private */
    public void setIndicatorFraction(float f10) {
        this.indicatorFraction = f10;
        invalidateSelf();
    }

    public void addSpringAnimationEndListener(@NonNull DynamicAnimation.OnAnimationEndListener onAnimationEndListener) {
        this.springAnimation.addEndListener(onAnimationEndListener);
    }

    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.drawingDelegate.g(canvas, getGrowFraction());
            this.drawingDelegate.c(canvas, this.paint);
            Canvas canvas2 = canvas;
            this.drawingDelegate.b(canvas2, this.paint, 0.0f, getIndicatorFraction(), MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], getAlpha()));
            canvas.restore();
        }
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public d getDrawingDelegate() {
        return this.drawingDelegate;
    }

    public int getIntrinsicHeight() {
        return this.drawingDelegate.d();
    }

    public int getIntrinsicWidth() {
        return this.drawingDelegate.e();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean hideNow() {
        return super.hideNow();
    }

    public /* bridge */ /* synthetic */ boolean isHiding() {
        return super.isHiding();
    }

    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    public /* bridge */ /* synthetic */ boolean isShowing() {
        return super.isShowing();
    }

    public void jumpToCurrentState() {
        this.springAnimation.skipToEnd();
        setIndicatorFraction(((float) getLevel()) / 10000.0f);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i10) {
        if (this.skipAnimationOnLevelChange) {
            this.springAnimation.skipToEnd();
            setIndicatorFraction(((float) i10) / 10000.0f);
            return true;
        }
        this.springAnimation.setStartValue(getIndicatorFraction() * 10000.0f);
        this.springAnimation.animateToFinalPosition((float) i10);
        return true;
    }

    public /* bridge */ /* synthetic */ void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        super.registerAnimationCallback(animationCallback);
    }

    public void removeSpringAnimationEndListener(@NonNull DynamicAnimation.OnAnimationEndListener onAnimationEndListener) {
        this.springAnimation.removeEndListener(onAnimationEndListener);
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i10) {
        super.setAlpha(i10);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(@Nullable ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: package-private */
    public void setDrawingDelegate(@NonNull d dVar) {
        this.drawingDelegate = dVar;
        dVar.f(this);
    }

    /* access modifiers changed from: package-private */
    public void setLevelByFraction(float f10) {
        setLevel((int) (f10 * 10000.0f));
    }

    public /* bridge */ /* synthetic */ boolean setVisible(boolean z10, boolean z11) {
        return super.setVisible(z10, z11);
    }

    /* access modifiers changed from: package-private */
    public boolean setVisibleInternal(boolean z10, boolean z11, boolean z12) {
        boolean visibleInternal = super.setVisibleInternal(z10, z11, z12);
        float systemAnimatorDurationScale = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (systemAnimatorDurationScale == 0.0f) {
            this.skipAnimationOnLevelChange = true;
        } else {
            this.skipAnimationOnLevelChange = false;
            this.springForce.setStiffness(50.0f / systemAnimatorDurationScale);
        }
        return visibleInternal;
    }

    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        return super.unregisterAnimationCallback(animationCallback);
    }

    public /* bridge */ /* synthetic */ boolean setVisible(boolean z10, boolean z11, boolean z12) {
        return super.setVisible(z10, z11, z12);
    }
}
