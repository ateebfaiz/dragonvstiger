package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class q implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkInitializer f6538a;

    public /* synthetic */ q(WorkInitializer workInitializer) {
        this.f6538a = workInitializer;
    }

    public final Object execute() {
        return this.f6538a.lambda$ensureContextsScheduled$0();
    }
}
