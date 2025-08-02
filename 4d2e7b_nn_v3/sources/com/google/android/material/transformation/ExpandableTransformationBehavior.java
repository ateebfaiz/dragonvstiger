package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    /* access modifiers changed from: private */
    @Nullable
    public AnimatorSet currentAnimation;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationEnd(Animator animator) {
            AnimatorSet unused = ExpandableTransformationBehavior.this.currentAnimation = null;
        }
    }

    public ExpandableTransformationBehavior() {
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract AnimatorSet onCreateExpandedStateChangeAnimation(View view, View view2, boolean z10, boolean z11);

    /* access modifiers changed from: protected */
    @CallSuper
    public boolean onExpandedStateChange(View view, View view2, boolean z10, boolean z11) {
        boolean z12;
        AnimatorSet animatorSet = this.currentAnimation;
        if (animatorSet != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            animatorSet.cancel();
        }
        AnimatorSet onCreateExpandedStateChangeAnimation = onCreateExpandedStateChangeAnimation(view, view2, z10, z12);
        this.currentAnimation = onCreateExpandedStateChangeAnimation;
        onCreateExpandedStateChangeAnimation.addListener(new a());
        this.currentAnimation.start();
        if (!z11) {
            this.currentAnimation.end();
        }
        return true;
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
