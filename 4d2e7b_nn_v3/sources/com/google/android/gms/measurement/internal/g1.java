package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class g1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f7511a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f7512b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzhx f7513c;

    g1(zzhx zzhx, AtomicReference atomicReference, boolean z10) {
        this.f7513c = zzhx;
        this.f7511a = atomicReference;
        this.f7512b = z10;
    }

    public final void run() {
        this.f7513c.zzt.zzt().zzx(this.f7511a, this.f7512b);
    }
}
