package com.onesignal;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

abstract class q3 {

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f11000a;

        a(View view) {
            this.f11000a = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f11000a.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    static Animation a(View view, float f10, float f11, int i10, Interpolator interpolator, Animation.AnimationListener animationListener) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f10, f11);
        translateAnimation.setDuration((long) i10);
        translateAnimation.setInterpolator(interpolator);
        if (animationListener != null) {
            translateAnimation.setAnimationListener(animationListener);
        }
        view.setAnimation(translateAnimation);
        return translateAnimation;
    }

    static ValueAnimator b(View view, int i10, int i11, int i12, Animator.AnimatorListener animatorListener) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration((long) i10);
        valueAnimator.setIntValues(new int[]{i11, i12});
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.addUpdateListener(new a(view));
        if (animatorListener != null) {
            valueAnimator.addListener(animatorListener);
        }
        return valueAnimator;
    }

    static Animation c(View view, int i10, Interpolator interpolator, Animation.AnimationListener animationListener) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration((long) i10);
        scaleAnimation.setInterpolator(interpolator);
        if (animationListener != null) {
            scaleAnimation.setAnimationListener(animationListener);
        }
        view.setAnimation(scaleAnimation);
        return scaleAnimation;
    }
}
