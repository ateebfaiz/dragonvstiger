package com.google.android.gms.common.api.internal;

import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;

public final class zab extends ActivityLifecycleObserver {
    private final WeakReference<a> zaa;

    @VisibleForTesting(otherwise = 2)
    zab(a aVar) {
        this.zaa = new WeakReference<>(aVar);
    }

    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        a aVar = this.zaa.get();
        if (aVar != null) {
            aVar.c(runnable);
            return this;
        }
        throw new IllegalStateException("The target activity has already been GC'd");
    }
}
