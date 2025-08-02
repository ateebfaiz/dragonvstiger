package com.swmansion.rnscreens;

import android.animation.ValueAnimator;
import android.view.Window;
import com.swmansion.rnscreens.s;

public final /* synthetic */ class t implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Window f11667a;

    public /* synthetic */ t(Window window) {
        this.f11667a = window;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        s.b.b(this.f11667a, valueAnimator);
    }
}
