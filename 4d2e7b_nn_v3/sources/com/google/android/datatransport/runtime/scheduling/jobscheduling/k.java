package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class k implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f6526a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f6527b;

    public /* synthetic */ k(Uploader uploader, TransportContext transportContext) {
        this.f6526a = uploader;
        this.f6527b = transportContext;
    }

    public final Object execute() {
        return this.f6526a.lambda$logAndUpdateState$3(this.f6527b);
    }
}
