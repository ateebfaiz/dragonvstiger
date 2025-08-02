package com.google.android.gms.measurement.internal;

final class e3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzdx f7481a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzjl f7482b;

    e3(zzjl zzjl, zzdx zzdx) {
        this.f7482b = zzjl;
        this.f7481a = zzdx;
    }

    public final void run() {
        synchronized (this.f7482b) {
            try {
                this.f7482b.zzb = false;
                if (!this.f7482b.zza.zzL()) {
                    this.f7482b.zza.zzt.zzay().zzc().zza("Connected to remote service");
                    this.f7482b.zza.zzJ(this.f7481a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
