package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class r1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f7693a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzhx f7694b;

    r1(zzhx zzhx, AtomicReference atomicReference) {
        this.f7694b = zzhx;
        this.f7693a = atomicReference;
    }

    public final void run() {
        synchronized (this.f7693a) {
            try {
                this.f7693a.set(Integer.valueOf(this.f7694b.zzt.zzf().zze(this.f7694b.zzt.zzh().zzl(), zzdu.zzM)));
                this.f7693a.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
