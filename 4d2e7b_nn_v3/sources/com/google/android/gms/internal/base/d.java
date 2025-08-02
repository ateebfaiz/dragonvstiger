package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class d implements zam {
    /* synthetic */ d(zan zan) {
    }

    public final ExecutorService zaa(ThreadFactory threadFactory, int i10) {
        return zac(1, threadFactory, 1);
    }

    public final ExecutorService zab(int i10, int i11) {
        return zac(4, Executors.defaultThreadFactory(), 2);
    }

    public final ExecutorService zac(int i10, ThreadFactory threadFactory, int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i10, i10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }
}
