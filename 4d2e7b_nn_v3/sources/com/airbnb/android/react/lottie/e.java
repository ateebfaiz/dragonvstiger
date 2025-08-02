package com.airbnb.android.react.lottie;

import com.airbnb.lottie.LottieAnimationView;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f17559a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f17560b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f17561c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f17562d;

    public /* synthetic */ e(boolean z10, int i10, int i11, LottieAnimationView lottieAnimationView) {
        this.f17559a = z10;
        this.f17560b = i10;
        this.f17561c = i11;
        this.f17562d = lottieAnimationView;
    }

    public final void run() {
        g.k(this.f17559a, this.f17560b, this.f17561c, this.f17562d);
    }
}
