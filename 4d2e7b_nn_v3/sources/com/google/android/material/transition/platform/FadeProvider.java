package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
public final class FadeProvider implements VisibilityAnimatorProvider {
    private float incomingEndThreshold = 1.0f;

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f8856a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f8857b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float f8858c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f8859d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ float f8860e;

        a(View view, float f10, float f11, float f12, float f13) {
            this.f8856a = view;
            this.f8857b = f10;
            this.f8858c = f11;
            this.f8859d = f12;
            this.f8860e = f13;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f8856a.setAlpha(j.l(this.f8857b, this.f8858c, this.f8859d, this.f8860e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f8861a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f8862b;

        b(View view, float f10) {
            this.f8861a = view;
            this.f8862b = f10;
        }

        public void onAnimationEnd(Animator animator) {
            this.f8861a.setAlpha(this.f8862b);
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
