package com.alibaba.pdns.pools;

import android.app.Activity;
import com.alibaba.pdns.pools.Callback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public interface d {
    <T> AbstractTask<T> a(Activity activity, AbstractTask<T> abstractTask);

    <T extends AbstractTask<?>> Callback.a a(Callback.b<T> bVar, T... tArr);

    <T> T a(AbstractTask<T> abstractTask) throws Throwable;

    ExecutorService a(int i10, int i11, long j10, String str, boolean z10);

    ScheduledExecutorService a(String str, boolean z10);

    void a(Runnable runnable);

    void a(Runnable runnable, long j10);

    void a(Runnable... runnableArr);

    <T> AbstractTask<T> b(AbstractTask<T> abstractTask);

    ExecutorService b(String str, boolean z10);

    void b(Runnable runnable);

    Future<?> c(Runnable runnable);

    void d(Runnable runnable);

    void e(Runnable runnable);

    void execute(Runnable runnable);
}
