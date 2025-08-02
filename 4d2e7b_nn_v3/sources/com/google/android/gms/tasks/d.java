package com.google.android.gms.tasks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class d implements e {

    /* renamed from: a  reason: collision with root package name */
    private final CountDownLatch f7837a = new CountDownLatch(1);

    /* synthetic */ d(zzac zzac) {
    }

    public final void a() {
        this.f7837a.await();
    }

    public final boolean b(long j10, TimeUnit timeUnit) {
        return this.f7837a.await(j10, timeUnit);
    }

    public final void onCanceled() {
        this.f7837a.countDown();
    }

    public final void onFailure(Exception exc) {
        this.f7837a.countDown();
    }

    public final void onSuccess(Object obj) {
        this.f7837a.countDown();
    }
}
