package com.google.android.gms.measurement.internal;

final class v3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzku f7751a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzkt f7752b;

    v3(zzkt zzkt, zzku zzku) {
        this.f7752b = zzkt;
        this.f7751a = zzku;
    }

    public final void run() {
        zzkt.zzy(this.f7752b, this.f7751a);
        this.f7752b.zzS();
    }
}
