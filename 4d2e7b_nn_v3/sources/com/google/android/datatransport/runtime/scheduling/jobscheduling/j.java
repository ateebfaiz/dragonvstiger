package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class j implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f6524a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f6525b;

    public /* synthetic */ j(Uploader uploader, TransportContext transportContext) {
        this.f6524a = uploader;
        this.f6525b = transportContext;
    }

    public final Object execute() {
        return this.f6524a.lambda$logAndUpdateState$2(this.f6525b);
    }
}
