package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class i implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClientHealthMetricsStore f6523a;

    public /* synthetic */ i(ClientHealthMetricsStore clientHealthMetricsStore) {
        this.f6523a = clientHealthMetricsStore;
    }

    public final Object execute() {
        return this.f6523a.loadClientMetrics();
    }
}
