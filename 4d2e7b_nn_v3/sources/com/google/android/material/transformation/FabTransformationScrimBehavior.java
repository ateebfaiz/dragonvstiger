package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    public static final long COLLAPSE_DELAY = 0;
    public static final long COLLAPSE_DURATION = 150;
    public static final long EXPAND_DELAY = 75;
    public static final long EXPAND_DURATION = 150;
    private final MotionTiming collapseTiming = new MotionTiming(0, 150);
    private final MotionTiming expandTiming = new MotionTiming(75, 150);

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8766a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f8767b;

        a(boolean z10, View view) {
            this.f8766a = z10;
            this.f8767b = view;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f8766a) {
                this.f8767b.setVisibility(4);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (this.f8766a) {
                this.f8767b.setVisibility(0);
            }
        }
    }

    public FabTransformationScrimBehavior() {
    }

    private void createScrimAnimation(@NonNull View view, boolean z10, boolean z11, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        MotionTiming motionTiming;
        ObjectAnimator objectAnimator;
        if (z10) {
            motionTiming = this.expandTiming;
        } else {
            motionTiming = this.collapseTiming;
        }
        if (z10) {
            if (!z11) {
                view.setAlpha(0.0f);
            }
            objectAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{1.0f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f});
        }
        motionTiming.apply(objectAnimator);
        list.add(objectAnimator);
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AnimatorSet onCreateExpandedStateChangeAnimation(@NonNull View view, @NonNull View view2, boolean z10, boolean z11) {
        ArrayList arrayList = new ArrayList();
        createScrimAnimation(view2, z10, z11, arrayList, new ArrayList());
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        animatorSet.addListener(new a(z10, view2));
        return animatorSet;
    }

    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
        return super.onTouchEvent(coordinatorLayout, view, motionEvent);
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
