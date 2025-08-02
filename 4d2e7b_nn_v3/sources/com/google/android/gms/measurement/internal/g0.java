package com.google.android.gms.measurement.internal;

final class g0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzgu f7509a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzfr f7510b;

    g0(zzfr zzfr, zzgu zzgu) {
        this.f7510b = zzfr;
        this.f7509a = zzgu;
    }

    public final void run() {
        zzfr.zzA(this.f7510b, this.f7509a);
        this.f7510b.zzH(this.f7509a.zzg);
    }
}
