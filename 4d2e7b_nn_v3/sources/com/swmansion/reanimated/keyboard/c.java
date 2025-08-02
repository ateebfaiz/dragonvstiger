package com.swmansion.reanimated.keyboard;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WindowsInsetsManager f11450a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f11451b;

    public /* synthetic */ c(WindowsInsetsManager windowsInsetsManager, boolean z10) {
        this.f11450a = windowsInsetsManager;
        this.f11451b = z10;
    }

    public final void run() {
        this.f11450a.lambda$updateWindowDecor$0(this.f11451b);
    }
}
