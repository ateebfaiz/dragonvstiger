package com.swmansion.reanimated.keyboard;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WindowsInsetsManager f11452a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f11453b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f11454c;

    public /* synthetic */ d(WindowsInsetsManager windowsInsetsManager, int i10, int i11) {
        this.f11452a = windowsInsetsManager;
        this.f11453b = i10;
        this.f11454c = i11;
    }

    public final void run() {
        this.f11452a.lambda$updateInsets$1(this.f11453b, this.f11454c);
    }
}
