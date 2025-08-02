package com.google.android.gms.internal.measurement;

abstract class t0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final long f7315a;

    /* renamed from: b  reason: collision with root package name */
    final long f7316b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f7317c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzef f7318d;

    t0(zzef zzef, boolean z10) {
        this.f7318d = zzef;
        this.f7315a = zzef.zza.currentTimeMillis();
        this.f7316b = zzef.zza.elapsedRealtime();
        this.f7317c = z10;
    }

    /* access modifiers changed from: package-private */
    public abstract void a();

    /* access modifiers changed from: protected */
    public void b() {
    }

    public final void run() {
        if (this.f7318d.zzh) {
            b();
            return;
        }
        try {
            a();
        } catch (Exception e10) {
            this.f7318d.zzT(e10, false, this.f7317c);
            b();
        }
    }
}
