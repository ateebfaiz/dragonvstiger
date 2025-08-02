package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class n0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimatorUpdateListener f15271a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f15272b;

    public /* synthetic */ n0(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
        this.f15271a = viewPropertyAnimatorUpdateListener;
        this.f15272b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f15271a.onAnimationUpdate(this.f15272b);
    }
}
