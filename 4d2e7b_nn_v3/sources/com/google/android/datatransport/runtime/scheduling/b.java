package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class b implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultScheduler f6499a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f6500b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EventInternal f6501c;

    public /* synthetic */ b(DefaultScheduler defaultScheduler, TransportContext transportContext, EventInternal eventInternal) {
        this.f6499a = defaultScheduler;
        this.f6500b = transportContext;
        this.f6501c = eventInternal;
    }

    public final Object execute() {
        return this.f6499a.lambda$schedule$0(this.f6500b, this.f6501c);
    }
}
