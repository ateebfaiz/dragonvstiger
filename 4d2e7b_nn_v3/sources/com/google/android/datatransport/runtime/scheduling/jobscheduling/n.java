package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class n implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f6534a;

    public /* synthetic */ n(Uploader uploader) {
        this.f6534a = uploader;
    }

    public final Object execute() {
        return this.f6534a.lambda$logAndUpdateState$6();
    }
}
