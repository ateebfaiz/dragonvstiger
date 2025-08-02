package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f6519a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f6520b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f6521c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Runnable f6522d;

    public /* synthetic */ h(Uploader uploader, TransportContext transportContext, int i10, Runnable runnable) {
        this.f6519a = uploader;
        this.f6520b = transportContext;
        this.f6521c = i10;
        this.f6522d = runnable;
    }

    public final void run() {
        this.f6519a.lambda$upload$1(this.f6520b, this.f6521c, this.f6522d);
    }
}
