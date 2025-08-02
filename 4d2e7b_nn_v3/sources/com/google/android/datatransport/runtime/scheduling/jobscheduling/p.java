package com.google.android.datatransport.runtime.scheduling.jobscheduling;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkInitializer f6537a;

    public /* synthetic */ p(WorkInitializer workInitializer) {
        this.f6537a = workInitializer;
    }

    public final void run() {
        this.f6537a.lambda$ensureContextsScheduled$1();
    }
}
