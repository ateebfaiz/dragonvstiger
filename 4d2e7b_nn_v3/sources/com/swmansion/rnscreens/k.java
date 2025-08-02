package com.swmansion.rnscreens;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f11646a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScreenFragment f11647b;

    public /* synthetic */ k(boolean z10, ScreenFragment screenFragment) {
        this.f11646a = z10;
        this.f11647b = screenFragment;
    }

    public final void run() {
        ScreenFragment.y(this.f11646a, this.f11647b);
    }
}
