package com.swmansion.reanimated.layoutReanimation;

import android.view.ViewParent;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedTransitionManager f11461a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewParent f11462b;

    public /* synthetic */ e(SharedTransitionManager sharedTransitionManager, ViewParent viewParent) {
        this.f11461a = sharedTransitionManager;
        this.f11462b = viewParent;
    }

    public final void run() {
        this.f11461a.lambda$finishSharedAnimation$1(this.f11462b);
    }
}
