package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class FadeProvider implements VisibilityAnimatorProvider {
    private float incomingEndThreshold = 1.0f;

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f8769a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f8770b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float f8771c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f8772d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ float f8773e;

        a(View view, float f10, float f11, float f12, float f13) {
            this.f8769a = view;
            this.f8770b = f10;
            this.f8771c = f11;
            this.f8772d = f12;
            this.f8773e = f13;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f8769a.setAlpha(j.k(this.f8770b, this.f8771c, this.f8772d, this.f8773e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f8774a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f8775b;

        b(View view, float f10) {
            this.f8774a = view;
            this.f8775b = f10;
        }

        public void onAnimationEnd(Animator animator) {
            this.f8774a.setAlpha(this.f8775b);
        }
    }

    private static Animator createFadeAnimator(View view, float f10, float f11, @FloatRange(from = 0.0d, to = 1.0d) float f12, @FloatRange(from = 0.0d, to = 1.0d) float f13, float f14) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new a(view, f10, f11, f12, f13));
        ofFloat.addListener(new b(view, f14));
        return ofFloat;
    }

    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha;
        if (view.getAlpha() == 0.0f) {
            alpha = 1.0f;
        } else {
            alpha = view.getAlpha();
        }
        float f10 = alpha;
        return createFadeAnimator(view, 0.0f, f10, 0.0f, this.incomingEndThreshold, f10);
    }

    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha;
        if (view.getAlpha() == 0.0f) {
            alpha = 1.0f;
        } else {
            alpha = view.getAlpha();
        }
        float f10 = alpha;
        return createFadeAnimator(view, f10, 0.0f, 0.0f, 1.0f, f10);
    }

    public float getIncomingEndThreshold() {
        return this.incomingEndThreshold;
    }

    public void setIncomingEndThreshold(float f10) {
        this.incomingEndThreshold = f10;
    }
}
