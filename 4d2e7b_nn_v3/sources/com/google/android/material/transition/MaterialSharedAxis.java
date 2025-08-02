package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.GravityCompat;
import androidx.transition.TransitionValues;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class MaterialSharedAxis extends h {
    @AttrRes
    private static final int DEFAULT_THEMED_DURATION_ATTR = R.attr.motionDurationLong1;
    @AttrRes
    private static final int DEFAULT_THEMED_EASING_ATTR = R.attr.motionEasingStandard;
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    private final int axis;
    private final boolean forward;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Axis {
    }

    public MaterialSharedAxis(int i10, boolean z10) {
        super(createPrimaryAnimatorProvider(i10, z10), createSecondaryAnimatorProvider());
        this.axis = i10;
        this.forward = z10;
    }

    private static VisibilityAnimatorProvider createPrimaryAnimatorProvider(int i10, boolean z10) {
        int i11;
        int i12;
        if (i10 == 0) {
            if (z10) {
                i11 = GravityCompat.END;
            } else {
                i11 = GravityCompat.START;
            }
            return new SlideDistanceProvider(i11);
        } else if (i10 == 1) {
            if (z10) {
                i12 = 80;
            } else {
                i12 = 48;
            }
            return new SlideDistanceProvider(i12);
        } else if (i10 == 2) {
            return new ScaleProvider(z10);
        } else {
            throw new IllegalArgumentException("Invalid axis: " + i10);
        }
    }

    private static VisibilityAnimatorProvider createSecondaryAnimatorProvider() {
        return new FadeThroughProvider();
    }

    public /* bridge */ /* synthetic */ void addAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.addAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    public int getAxis() {
        return this.axis;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int getDurationThemeAttrResId(boolean z10) {
        return DEFAULT_THEMED_DURATION_ATTR;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int getEasingThemeAttrResId(boolean z10) {
        return DEFAULT_THEMED_EASING_ATTR;
    }

    @NonNull
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    @Nullable
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    public boolean isForward() {
        return this.forward;
    }

    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }

    public /* bridge */ /* synthetic */ boolean removeAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return super.removeAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    public /* bridge */ /* synthetic */ void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.setSecondaryAnimatorProvider(visibilityAnimatorProvider);
    }
}
