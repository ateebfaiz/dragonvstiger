package com.google.android.gms.measurement.internal;

final class i3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzkt f7558a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Runnable f7559b;

    i3(zzjt zzjt, zzkt zzkt, Runnable runnable) {
        this.f7558a = zzkt;
        this.f7559b = runnable;
    }

    public final void run() {
        this.f7558a.zzA();
        this.f7558a.zzz(this.f7559b);
        this.f7558a.zzX();
    }
}
