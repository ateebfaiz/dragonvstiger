package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.NonNull;
import com.google.android.material.circularreveal.CircularRevealWidget;

public final class CircularRevealCompat {

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CircularRevealWidget f8041a;

        a(CircularRevealWidget circularRevealWidget) {
            this.f8041a = circularRevealWidget;
        }

        public void onAnimationEnd(Animator animator) {
            this.f8041a.destroyCircularRevealCache();
        }

        public void onAnimationStart(Animator animator) {
            this.f8041a.buildCircularRevealCache();
        }
    }

    private CircularRevealCompat() {
    }

    @NonNull
    public static Animator createCircularReveal(@NonNull CircularRevealWidget circularRevealWidget, float f10, float f11, float f12) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(circularRevealWidget, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(f10, f11, f12)});
        CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) circularRevealWidget, (int) f10, (int) f11, revealInfo.radius, f12);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofObject, createCircularReveal});
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    @NonNull
    public static Animator.AnimatorListener createCircularRevealListener(@NonNull CircularRevealWidget circularRevealWidget) {
        return new a(circularRevealWidget);
    }

    @NonNull
    public static Animator createCircularReveal(CircularRevealWidget circularRevealWidget, float f10, float f11, float f12, float f13) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(circularRevealWidget, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(f10, f11, f12), new CircularRevealWidget.RevealInfo(f10, f11, f13)});
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) circularRevealWidget, (int) f10, (int) f11, f12, f13);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofObject, createCircularReveal});
        return animatorSet;
    }
}
