package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class g implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f6516a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f6517b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f6518c;

    public /* synthetic */ g(Uploader uploader, TransportContext transportContext, int i10) {
        this.f6516a = uploader;
        this.f6517b = transportContext;
        this.f6518c = i10;
    }

    public final Object execute() {
        return this.f6516a.lambda$upload$0(this.f6517b, this.f6518c);
    }
}
