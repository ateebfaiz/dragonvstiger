package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

final class a extends LifecycleCallback {

    /* renamed from: a  reason: collision with root package name */
    private List f6651a = new ArrayList();

    private a(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
    }

    static /* bridge */ /* synthetic */ a a(Activity activity) {
        a aVar;
        synchronized (activity) {
            try {
                LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
                aVar = (a) fragment.getCallbackOrNull("LifecycleObserverOnStop", a.class);
                if (aVar == null) {
                    aVar = new a(fragment);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public final synchronized void c(Runnable runnable) {
        this.f6651a.add(runnable);
    }

    public final void onStop() {
        List<Runnable> list;
        synchronized (this) {
            list = this.f6651a;
            this.f6651a = new ArrayList();
        }
        for (Runnable run : list) {
            run.run();
        }
    }
}
