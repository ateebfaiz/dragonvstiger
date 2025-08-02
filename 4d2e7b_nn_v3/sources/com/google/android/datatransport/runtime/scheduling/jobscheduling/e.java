package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class e implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventStore f6512a;

    public /* synthetic */ e(EventStore eventStore) {
        this.f6512a = eventStore;
    }

    public final Object execute() {
        return Integer.valueOf(this.f6512a.cleanUp());
    }
}
