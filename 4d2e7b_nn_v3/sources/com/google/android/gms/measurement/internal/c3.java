package com.google.android.gms.measurement.internal;

final class c3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzdx f7443a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzjl f7444b;

    c3(zzjl zzjl, zzdx zzdx) {
        this.f7444b = zzjl;
        this.f7443a = zzdx;
    }

    public final void run() {
        synchronized (this.f7444b) {
            try {
                this.f7444b.zzb = false;
                if (!this.f7444b.zza.zzL()) {
                    this.f7444b.zza.zzt.zzay().zzj().zza("Connected to service");
                    this.f7444b.zza.zzJ(this.f7443a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
