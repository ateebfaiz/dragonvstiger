package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class h1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f7529a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzhx f7530b;

    h1(zzhx zzhx, long j10) {
        this.f7530b = zzhx;
        this.f7529a = j10;
    }

    public final void run() {
        this.f7530b.zzL(this.f7529a, true);
        this.f7530b.zzt.zzt().zzu(new AtomicReference());
    }
}
