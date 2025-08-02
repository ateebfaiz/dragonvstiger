package com.swmansion.rnscreens;

import androidx.core.view.WindowInsetsControllerCompat;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f11650a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WindowInsetsControllerCompat f11651b;

    public /* synthetic */ p(boolean z10, WindowInsetsControllerCompat windowInsetsControllerCompat) {
        this.f11650a = z10;
        this.f11651b = windowInsetsControllerCompat;
    }

    public final void run() {
        s.m(this.f11650a, this.f11651b);
    }
}
