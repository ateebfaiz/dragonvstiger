package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class m implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f6532a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Iterable f6533b;

    public /* synthetic */ m(Uploader uploader, Iterable iterable) {
        this.f6532a = uploader;
        this.f6533b = iterable;
    }

    public final Object execute() {
        return this.f6532a.lambda$logAndUpdateState$5(this.f6533b);
    }
}
