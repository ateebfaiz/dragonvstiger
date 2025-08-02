package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class q1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f7683a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzhx f7684b;

    q1(zzhx zzhx, AtomicReference atomicReference) {
        this.f7684b = zzhx;
        this.f7683a = atomicReference;
    }

    public final void run() {
        synchronized (this.f7683a) {
            try {
                this.f7683a.set(Long.valueOf(this.f7684b.zzt.zzf().zzi(this.f7684b.zzt.zzh().zzl(), zzdu.zzL)));
                this.f7683a.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
