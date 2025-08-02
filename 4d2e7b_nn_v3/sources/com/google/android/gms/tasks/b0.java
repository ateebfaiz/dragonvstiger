package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

final class b0 extends LifecycleCallback {

    /* renamed from: a  reason: collision with root package name */
    private final List f7829a = new ArrayList();

    private b0(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
    }

    public static b0 a(Activity activity) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        b0 b0Var = (b0) fragment.getCallbackOrNull("TaskOnStopCallback", b0.class);
        if (b0Var == null) {
            return new b0(fragment);
        }
        return b0Var;
    }

    public final void b(w wVar) {
        synchronized (this.f7829a) {
            this.f7829a.add(new WeakReference(wVar));
        }
    }

    public final void onStop() {
        synchronized (this.f7829a) {
            try {
                for (WeakReference weakReference : this.f7829a) {
                    w wVar = (w) weakReference.get();
                    if (wVar != null) {
                        wVar.zzc();
                    }
                }
                this.f7829a.clear();
            } finally {
            }
        }
    }
}
