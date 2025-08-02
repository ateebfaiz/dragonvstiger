package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class s1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f7701a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzhx f7702b;

    s1(zzhx zzhx, AtomicReference atomicReference) {
        this.f7702b = zzhx;
        this.f7701a = atomicReference;
    }

    public final void run() {
        synchronized (this.f7701a) {
            try {
                this.f7701a.set(Double.valueOf(this.f7702b.zzt.zzf().zza(this.f7702b.zzt.zzh().zzl(), zzdu.zzN)));
                this.f7701a.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
