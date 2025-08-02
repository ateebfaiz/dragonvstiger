package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class l implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f6528a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Iterable f6529b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f6530c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f6531d;

    public /* synthetic */ l(Uploader uploader, Iterable iterable, TransportContext transportContext, long j10) {
        this.f6528a = uploader;
        this.f6529b = iterable;
        this.f6530c = transportContext;
        this.f6531d = j10;
    }

    public final Object execute() {
        return this.f6528a.lambda$logAndUpdateState$4(this.f6529b, this.f6530c, this.f6531d);
    }
}
