package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class ScaleProvider implements VisibilityAnimatorProvider {
    private boolean growing;
    private float incomingEndScale;
    private float incomingStartScale;
    private float outgoingEndScale;
    private float outgoingStartScale;
    private boolean scaleOnDisappear;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f8822a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f8823b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float f8824c;

        a(View view, float f10, float f11) {
            this.f8822a = view;
            this.f8823b = f10;
            this.f8824c = f11;
        }

        public void onAnimationEnd(Animator animator) {
            this.f8822a.setScaleX(this.f8823b);
            this.f8822a.setScaleY(this.f8824c);
        }
    }

    public ScaleProvider() {
        this(true);
    }

    private static Animator createScaleAnimator(View view, float f10, float f11) {
        float scaleX = view.getScaleX();
        float scaleY = view.getScaleY();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{scaleX * f10, scaleX * f11}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{f10 * scaleY, f11 * scaleY})});
        ofPropertyValuesHolder.addListener(new a(view, scaleX, scaleY));
        return ofPropertyValuesHolder;
    }

    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (this.growing) {
            return createScaleAnimator(view, this.incomingStartScale, this.incomingEndScale);
        }
        return createScaleAnimator(view, this.outgoingEndScale, this.outgoingStartScale);
    }

    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (!this.scaleOnDisappear) {
            return null;
        }
        if (this.growing) {
            return createScaleAnimator(view, this.outgoingStartScale, this.outgoingEndScale);
        }
        return createScaleAnimator(view, this.incomingEndScale, this.incomingStartScale);
    }

    public float getIncomingEndScale() {
        return this.incomingEndScale;
    }

    public float getIncomingStartScale() {
        return this.incomingStartScale;
    }

    public float getOutgoingEndScale() {
        return this.outgoingEndScale;
    }

    public float getOutgoingStartScale() {
        return this.outgoingStartScale;
    }

    public boolean isGrowing() {
        return this.growing;
    }

    public boolean isScaleOnDisappear() {
        return this.scaleOnDisappear;
    }

    public void setGrowing(boolean z10) {
        this.growing = z10;
    }

    public void setIncomingEndScale(float f10) {
        this.incomingEndScale = f10;
    }

    public void setIncomingStartScale(float f10) {
        this.incomingStartScale = f10;
    }

    public void setOutgoingEndScale(float f10) {
        this.outgoingEndScale = f10;
    }

    public void setOutgoingStartScale(float f10) {
        this.outgoingStartScale = f10;
    }

    public void setScaleOnDisappear(boolean z10) {
        this.scaleOnDisappear = z10;
    }

    public ScaleProvider(boolean z10) {
        this.outgoingStartScale = 1.0f;
        this.outgoingEndScale = 1.1f;
        this.incomingStartScale = 0.8f;
        this.incomingEndScale = 1.0f;
        this.scaleOnDisappear = true;
        this.growing = z10;
    }
}
