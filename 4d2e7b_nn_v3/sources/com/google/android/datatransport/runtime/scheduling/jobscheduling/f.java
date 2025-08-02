package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class f implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f6513a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f6514b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f6515c;

    public /* synthetic */ f(Uploader uploader, TransportContext transportContext, long j10) {
        this.f6513a = uploader;
        this.f6514b = transportContext;
        this.f6515c = j10;
    }

    public final Object execute() {
        return this.f6513a.lambda$logAndUpdateState$8(this.f6514b, this.f6515c);
    }
}
