package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultScheduler f6495a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f6496b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportScheduleCallback f6497c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ EventInternal f6498d;

    public /* synthetic */ a(DefaultScheduler defaultScheduler, TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        this.f6495a = defaultScheduler;
        this.f6496b = transportContext;
        this.f6497c = transportScheduleCallback;
        this.f6498d = eventInternal;
    }

    public final void run() {
        this.f6495a.lambda$schedule$1(this.f6496b, this.f6497c, this.f6498d);
    }
}
