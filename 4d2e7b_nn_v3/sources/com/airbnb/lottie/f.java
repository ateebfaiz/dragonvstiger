package com.airbnb.lottie;

import java.util.concurrent.Callable;

public final /* synthetic */ class f implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f17646a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f17647b;

    public /* synthetic */ f(LottieAnimationView lottieAnimationView, String str) {
        this.f17646a = lottieAnimationView;
        this.f17647b = str;
    }

    public final Object call() {
        return this.f17646a.r(this.f17647b);
    }
}
