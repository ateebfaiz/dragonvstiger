package com.google.android.gms.common.providers;

import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.internal.common.zzh;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class a implements PooledExecutorsProvider.PooledExecutorFactory {
    a() {
    }

    public final ScheduledExecutorService newSingleThreadScheduledExecutor() {
        zzh.zza();
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
    }
}
