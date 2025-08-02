package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.List;

abstract class c extends Drawable implements Animatable2Compat {
    private static final boolean DEFAULT_DRAWABLE_RESTART = false;
    private static final int GROW_DURATION = 500;
    private static final Property<c, Float> GROW_FRACTION = new C0096c(Float.class, "growFraction");
    private List<Animatable2Compat.AnimationCallback> animationCallbacks;
    AnimatorDurationScaleProvider animatorDurationScaleProvider;
    final BaseProgressIndicatorSpec baseSpec;
    final Context context;
    private float growFraction;
    private ValueAnimator hideAnimator;
    private boolean ignoreCallbacks;
    private Animatable2Compat.AnimationCallback internalAnimationCallback;
    private float mockGrowFraction;
    private boolean mockHideAnimationRunning;
    private boolean mockShowAnimationRunning;
    final Paint paint = new Paint();
    private ValueAnimator showAnimator;
    private int totalAlpha;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            c.this.b();
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            boolean unused = c.super.setVisible(false, false);
            c.this.a();
        }
    }

    /* renamed from: com.google.android.material.progressindicator.c$c  reason: collision with other inner class name */
    class C0096c extends Property {
        C0096c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(c cVar) {
            return Float.valueOf(cVar.getGrowFraction());
        }

        /* renamed from: b */
        public void set(c cVar, Float f10) {
            cVar.setGrowFraction(f10.floatValue());
        }
    }

    c(Context context2, BaseProgressIndicatorSpec baseProgressIndicatorSpec) {
        this.context = context2;
        this.baseSpec = baseProgressIndicatorSpec;
        this.animatorDurationScaleProvider = new AnimatorDurationScaleProvider();
        setAlpha(255);
    }

    /* access modifiers changed from: private */
    public void a() {
        Animatable2Compat.AnimationCallback animationCallback = this.internalAnimationCallback;
        if (animationCallback != null) {
            animationCallback.onAnimationEnd(this);
        }
        List<Animatable2Compat.AnimationCallback> list = this.animationCallbacks;
        if (list != null && !this.ignoreCallbacks) {
            for (Animatable2Compat.AnimationCallback onAnimationEnd : list) {
                onAnimationEnd.onAnimationEnd(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        Animatable2Compat.AnimationCallback animationCallback = this.internalAnimationCallback;
        if (animationCallback != null) {
            animationCallback.onAnimationStart(this);
        }
        List<Animatable2Compat.AnimationCallback> list = this.animationCallbacks;
        if (list != null && !this.ignoreCallbacks) {
            for (Animatable2Compat.AnimationCallback onAnimationStart : list) {
                onAnimationStart.onAnimationStart(this);
            }
        }
    }

    private void c(ValueAnimator... valueAnimatorArr) {
        boolean z10 = this.ignoreCallbacks;
        this.ignoreCallbacks = true;
        for (ValueAnimator end : valueAnimatorArr) {
            end.end();
        }
        this.ignoreCallbacks = z10;
    }

    private void d() {
        if (this.showAnimator == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, GROW_FRACTION, new float[]{0.0f, 1.0f});
            this.showAnimator = ofFloat;
            ofFloat.setDuration(500);
            this.showAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            f(this.showAnimator);
        }
        if (this.hideAnimator == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, GROW_FRACTION, new float[]{1.0f, 0.0f});
            this.hideAnimator = ofFloat2;
            ofFloat2.setDuration(500);
            this.hideAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            e(this.hideAnimator);
        }
    }

    private void e(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.hideAnimator;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            this.hideAnimator = valueAnimator;
            valueAnimator.addListener(new b());
            return;
        }
        throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
    }

    private void f(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.showAnimator;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            this.showAnimator = valueAnimator;
            valueAnimator.addListener(new a());
            return;
        }
        throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
    }

    public void clearAnimationCallbacks() {
        this.animationCallbacks.clear();
        this.animationCallbacks = null;
    }

    public int getAlpha() {
        return this.totalAlpha;
    }

    /* access modifiers changed from: package-private */
    public float getGrowFraction() {
        if (!this.baseSpec.isShowAnimationEnabled() && !this.baseSpec.isHideAnimationEnabled()) {
            return 1.0f;
        }
        if (this.mockHideAnimationRunning || this.mockShowAnimationRunning) {
            return this.mockGrowFraction;
        }
        return this.growFraction;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ValueAnimator getHideAnimator() {
        return this.hideAnimator;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean hideNow() {
        return setVisible(false, false, false);
    }

    public boolean isHiding() {
        ValueAnimator valueAnimator = this.hideAnimator;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && !this.mockHideAnimationRunning) {
            return false;
        }
        return true;
    }

    public boolean isRunning() {
        if (isShowing() || isHiding()) {
            return true;
        }
        return false;
    }

    public boolean isShowing() {
        ValueAnimator valueAnimator = this.showAnimator;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && !this.mockShowAnimationRunning) {
            return false;
        }
        return true;
    }

    public void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        if (this.animationCallbacks == null) {
            this.animationCallbacks = new ArrayList();
        }
        if (!this.animationCallbacks.contains(animationCallback)) {
            this.animationCallbacks.add(animationCallback);
        }
    }

    public void setAlpha(int i10) {
        this.totalAlpha = i10;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void setGrowFraction(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        if (this.growFraction != f10) {
            this.growFraction = f10;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void setInternalAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.internalAnimationCallback = animationCallback;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setMockHideAnimationRunning(boolean z10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.mockHideAnimationRunning = z10;
        this.mockGrowFraction = f10;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setMockShowAnimationRunning(boolean z10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.mockShowAnimationRunning = z10;
        this.mockGrowFraction = f10;
    }

    public boolean setVisible(boolean z10, boolean z11) {
        return setVisible(z10, z11, true);
    }

    /* access modifiers changed from: package-private */
    public boolean setVisibleInternal(boolean z10, boolean z11, boolean z12) {
        ValueAnimator valueAnimator;
        boolean z13;
        boolean z14;
        d();
        if (!isVisible() && !z10) {
            return false;
        }
        if (z10) {
            valueAnimator = this.showAnimator;
        } else {
            valueAnimator = this.hideAnimator;
        }
        if (!z12) {
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                c(valueAnimator);
            }
            return super.setVisible(z10, false);
        } else if (z12 && valueAnimator.isRunning()) {
            return false;
        } else {
            if (!z10 || super.setVisible(z10, false)) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z10) {
                z14 = this.baseSpec.isShowAnimationEnabled();
            } else {
                z14 = this.baseSpec.isHideAnimationEnabled();
            }
            if (!z14) {
                c(valueAnimator);
                return z13;
            }
            if (z11 || !valueAnimator.isPaused()) {
                valueAnimator.start();
            } else {
                valueAnimator.resume();
            }
            return z13;
        }
    }

    public void start() {
        setVisibleInternal(true, true, false);
    }

    public void stop() {
        setVisibleInternal(false, true, false);
    }

    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.animationCallbacks;
        if (list == null || !list.contains(animationCallback)) {
            return false;
        }
        this.animationCallbacks.remove(animationCallback);
        if (!this.animationCallbacks.isEmpty()) {
            return true;
        }
        this.animationCallbacks = null;
        return true;
    }

    public boolean setVisible(boolean z10, boolean z11, boolean z12) {
        return setVisibleInternal(z10, z11, z12 && this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver()) > 0.0f);
    }
}
