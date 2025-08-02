package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;

final class b implements h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f6838a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Bundle f6839b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Bundle f6840c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ DeferredLifecycleHelper f6841d;

    b(DeferredLifecycleHelper deferredLifecycleHelper, Activity activity, Bundle bundle, Bundle bundle2) {
        this.f6841d = deferredLifecycleHelper;
        this.f6838a = activity;
        this.f6839b = bundle;
        this.f6840c = bundle2;
    }

    public final void a(LifecycleDelegate lifecycleDelegate) {
        this.f6841d.zaa.onInflate(this.f6838a, this.f6839b, this.f6840c);
    }

    public final int zaa() {
        return 0;
    }
}
