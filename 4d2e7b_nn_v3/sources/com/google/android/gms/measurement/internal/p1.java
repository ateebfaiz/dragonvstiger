package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class p1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f7666a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzhx f7667b;

    p1(zzhx zzhx, AtomicReference atomicReference) {
        this.f7667b = zzhx;
        this.f7666a = atomicReference;
    }

    public final void run() {
        synchronized (this.f7666a) {
            try {
                this.f7666a.set(this.f7667b.zzt.zzf().zzo(this.f7667b.zzt.zzh().zzl(), zzdu.zzK));
                this.f7666a.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
