package com.google.android.gms.dynamic;

import android.os.Bundle;

final class c implements h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle f6842a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ DeferredLifecycleHelper f6843b;

    c(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        this.f6843b = deferredLifecycleHelper;
        this.f6842a = bundle;
    }

    public final void a(LifecycleDelegate lifecycleDelegate) {
        this.f6843b.zaa.onCreate(this.f6842a);
    }

    public final int zaa() {
        return 1;
    }
}
