package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.Map;

public final /* synthetic */ class o implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f6535a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f6536b;

    public /* synthetic */ o(Uploader uploader, Map map) {
        this.f6535a = uploader;
        this.f6536b = map;
    }

    public final Object execute() {
        return this.f6535a.lambda$logAndUpdateState$7(this.f6536b);
    }
}
