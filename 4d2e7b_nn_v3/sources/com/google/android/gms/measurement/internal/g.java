package com.google.android.gms.measurement.internal;

final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z0 f7507a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h f7508b;

    g(h hVar, z0 z0Var) {
        this.f7508b = hVar;
        this.f7507a = z0Var;
    }

    public final void run() {
        this.f7507a.zzaw();
        if (zzab.zza()) {
            this.f7507a.zzaz().zzp(this);
            return;
        }
        boolean e10 = this.f7508b.e();
        this.f7508b.f7525c = 0;
        if (e10) {
            this.f7508b.c();
        }
    }
}
