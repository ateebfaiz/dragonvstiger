package com.airbnb.lottie;

import java.util.concurrent.Callable;

public final /* synthetic */ class h implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f17650a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f17651b;

    public /* synthetic */ h(LottieAnimationView lottieAnimationView, int i10) {
        this.f17650a = lottieAnimationView;
        this.f17651b = i10;
    }

    public final Object call() {
        return this.f17650a.s(this.f17651b);
    }
}
