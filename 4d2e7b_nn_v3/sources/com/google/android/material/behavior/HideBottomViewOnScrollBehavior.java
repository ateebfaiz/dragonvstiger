package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimationUtils;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    protected static final int ENTER_ANIMATION_DURATION = 225;
    protected static final int EXIT_ANIMATION_DURATION = 175;
    private static final int STATE_SCROLLED_DOWN = 1;
    private static final int STATE_SCROLLED_UP = 2;
    private int additionalHiddenOffsetY = 0;
    /* access modifiers changed from: private */
    @Nullable
    public ViewPropertyAnimator currentAnimator;
    private int currentState = 2;
    private int height = 0;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationEnd(Animator animator) {
            ViewPropertyAnimator unused = HideBottomViewOnScrollBehavior.this.currentAnimator = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
    }

    private void animateChildTo(@NonNull V v10, int i10, long j10, TimeInterpolator timeInterpolator) {
        this.currentAnimator = v10.animate().translationY((float) i10).setInterpolator(timeInterpolator).setDuration(j10).setListener(new a());
    }

    public boolean isScrolledDown() {
        if (this.currentState == 1) {
            return true;
        }
        return false;
    }

    public boolean isScrolledUp() {
        if (this.currentState == 2) {
            return true;
        }
        return false;
    }

    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10) {
        this.height = v10.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v10.getLayoutParams()).bottomMargin;
        return super.onLayoutChild(coordinatorLayout, v10, i10);
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, int i12, int i13, int i14, @NonNull int[] iArr) {
        if (i11 > 0) {
            slideDown(v10);
        } else if (i11 < 0) {
            slideUp(v10);
        }
    }

    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, @NonNull View view2, int i10, int i11) {
        return i10 == 2;
    }

    public void setAdditionalHiddenOffsetY(@NonNull V v10, @Dimension int i10) {
        this.additionalHiddenOffsetY = i10;
        if (this.currentState == 1) {
            v10.setTranslationY((float) (this.height + i10));
        }
    }

    public void slideDown(@NonNull V v10) {
        slideDown(v10, true);
    }

    public void slideUp(@NonNull V v10) {
        slideUp(v10, true);
    }

    public void slideDown(@NonNull V v10, boolean z10) {
        if (!isScrolledDown()) {
            ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v10.clearAnimation();
            }
            this.currentState = 1;
            int i10 = this.height + this.additionalHiddenOffsetY;
            if (z10) {
                animateChildTo(v10, i10, 175, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
                return;
            }
            v10.setTranslationY((float) i10);
        }
    }

    public void slideUp(@NonNull V v10, boolean z10) {
        if (!isScrolledUp()) {
            ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v10.clearAnimation();
            }
            this.currentState = 2;
            if (z10) {
                animateChildTo(v10, 0, 225, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
                return;
            }
            v10.setTranslationY((float) 0);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
