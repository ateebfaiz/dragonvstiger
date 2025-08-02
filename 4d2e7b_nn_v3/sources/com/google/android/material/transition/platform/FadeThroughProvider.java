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
public final class FadeThroughProvider implements VisibilityAnimatorProvider {
    static final float FADE_THROUGH_THRESHOLD = 0.35f;
    private float progressThreshold = FADE_THROUGH_THRESHOLD;

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f8863a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f8864b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float f8865c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f8866d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ float f8867e;

        a(View view, float f10, float f11, float f12, float f13) {
            this.f8863a = view;
            this.f8864b = f10;
            this.f8865c = f11;
            this.f8866d = f12;
            this.f8867e = f13;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f8863a.setAlpha(j.l(this.f8864b, this.f8865c, this.f8866d, this.f8867e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f8868a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f8869b;

        b(View view, float f10) {
            this.f8868a = view;
            this.f8869b = f10;
        }

        public void onAnimationEnd(Animator animator) {
            this.f8868a.setAlpha(this.f8869b);
        }
    }

    private static Animator createFadeThroughAnimator(View view, float f10, float f11, @FloatRange(from = 0.0d, to = 1.0d) float f12, @FloatRange(from = 0.0d, to = 1.0d) float f13, float f14) {
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
        return createFadeThroughAnimator(view, 0.0f, f10, this.progressThreshold, 1.0f, f10);
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
        return createFadeThroughAnimator(view, f10, 0.0f, 0.0f, this.progressThreshold, f10);
    }

    public float getProgressThreshold() {
        return this.progressThreshold;
    }

    public void setProgressThreshold(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.progressThreshold = f10;
    }
}
