package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import java.util.ArrayList;
import java.util.List;

abstract class h extends Visibility {
    private final List<VisibilityAnimatorProvider> additionalAnimatorProviders = new ArrayList();
    private final VisibilityAnimatorProvider primaryAnimatorProvider;
    @Nullable
    private VisibilityAnimatorProvider secondaryAnimatorProvider;

    protected h(VisibilityAnimatorProvider visibilityAnimatorProvider, VisibilityAnimatorProvider visibilityAnimatorProvider2) {
        this.primaryAnimatorProvider = visibilityAnimatorProvider;
        this.secondaryAnimatorProvider = visibilityAnimatorProvider2;
    }

    private static void a(List list, VisibilityAnimatorProvider visibilityAnimatorProvider, ViewGroup viewGroup, View view, boolean z10) {
        Animator animator;
        if (visibilityAnimatorProvider != null) {
            if (z10) {
                animator = visibilityAnimatorProvider.createAppear(viewGroup, view);
            } else {
                animator = visibilityAnimatorProvider.createDisappear(viewGroup, view);
            }
            if (animator != null) {
                list.add(animator);
            }
        }
    }

    private Animator b(ViewGroup viewGroup, View view, boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        a(arrayList, this.primaryAnimatorProvider, viewGroup, view, z10);
        a(arrayList, this.secondaryAnimatorProvider, viewGroup, view, z10);
        for (VisibilityAnimatorProvider a10 : this.additionalAnimatorProviders) {
            a(arrayList, a10, viewGroup, view, z10);
        }
        c(viewGroup.getContext(), z10);
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    private void c(Context context, boolean z10) {
        j.p(this, context, getDurationThemeAttrResId(z10));
        j.q(this, context, getEasingThemeAttrResId(z10), getDefaultEasingInterpolator(z10));
    }

    public void addAdditionalAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.additionalAnimatorProviders.add(visibilityAnimatorProvider);
    }

    public void clearAdditionalAnimatorProvider() {
        this.additionalAnimatorProviders.clear();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public TimeInterpolator getDefaultEasingInterpolator(boolean z10) {
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int getDurationThemeAttrResId(boolean z10) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int getEasingThemeAttrResId(boolean z10) {
        return 0;
    }

    public VisibilityAnimatorProvider getPrimaryAnimatorProvider() {
        return this.primaryAnimatorProvider;
    }

    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return this.secondaryAnimatorProvider;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return b(viewGroup, view, true);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return b(viewGroup, view, false);
    }

    public boolean removeAdditionalAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return this.additionalAnimatorProviders.remove(visibilityAnimatorProvider);
    }

    public void setSecondaryAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
    }
}
