package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class l1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f7609a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzhx f7610b;

    l1(zzhx zzhx, AtomicReference atomicReference) {
        this.f7610b = zzhx;
        this.f7609a = atomicReference;
    }

    public final void run() {
        synchronized (this.f7609a) {
            try {
                this.f7609a.set(Boolean.valueOf(this.f7610b.zzt.zzf().zzs(this.f7610b.zzt.zzh().zzl(), zzdu.zzJ)));
                this.f7609a.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
