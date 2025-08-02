package com.google.android.gms.dynamic;

import java.util.Iterator;

final class a implements OnDelegateCreatedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DeferredLifecycleHelper f6837a;

    a(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.f6837a = deferredLifecycleHelper;
    }

    public final void onDelegateCreated(LifecycleDelegate lifecycleDelegate) {
        this.f6837a.zaa = lifecycleDelegate;
        Iterator it = this.f6837a.zac.iterator();
        while (it.hasNext()) {
            ((h) it.next()).a(this.f6837a.zaa);
        }
        this.f6837a.zac.clear();
        this.f6837a.zab = null;
    }
}
