package com.facebook.react.fabric.mounting;

import android.view.View;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SurfaceMountingManager f3181a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f3182b;

    public /* synthetic */ b(SurfaceMountingManager surfaceMountingManager, View view) {
        this.f3181a = surfaceMountingManager;
        this.f3182b = view;
    }

    public final void run() {
        this.f3181a.lambda$addRootView$0(this.f3182b);
    }
}
