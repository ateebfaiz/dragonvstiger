package com.google.android.gms.common.internal;

import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.common.zzh;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

abstract class n {

    /* renamed from: a  reason: collision with root package name */
    static final ExecutorService f6795a;

    static {
        zzh.zza();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("CallbackExecutor"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f6795a = Executors.unconfigurableExecutorService(threadPoolExecutor);
    }
}
