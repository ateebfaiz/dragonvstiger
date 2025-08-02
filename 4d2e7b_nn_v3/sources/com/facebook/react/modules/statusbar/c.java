package com.facebook.react.modules.statusbar;

import android.animation.ValueAnimator;
import android.app.Activity;
import com.facebook.react.modules.statusbar.StatusBarModule;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f3358a;

    public /* synthetic */ c(Activity activity) {
        this.f3358a = activity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        StatusBarModule.b.b(this.f3358a, valueAnimator);
    }
}
