package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;

final class n2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f7641a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzcf f7642b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzjm f7643c;

    n2(zzjm zzjm, zzq zzq, zzcf zzcf) {
        this.f7643c = zzjm;
        this.f7641a = zzq;
        this.f7642b = zzcf;
    }

    public final void run() {
        zzfr zzfr;
        String str = null;
        try {
            if (!this.f7643c.zzt.zzm().c().zzi(zzah.ANALYTICS_STORAGE)) {
                this.f7643c.zzt.zzay().zzl().zza("Analytics storage consent denied; will not get app instance id");
                this.f7643c.zzt.zzq().zzO((String) null);
                this.f7643c.zzt.zzm().f7772e.zzb((String) null);
                zzfr = this.f7643c.zzt;
            } else {
                zzjm zzjm = this.f7643c;
                zzdx zzh = zzjm.zzb;
                if (zzh == null) {
                    zzjm.zzt.zzay().zzd().zza("Failed to get app instance id");
                    zzfr = this.f7643c.zzt;
                } else {
                    Preconditions.checkNotNull(this.f7641a);
                    str = zzh.zzd(this.f7641a);
                    if (str != null) {
                        this.f7643c.zzt.zzq().zzO(str);
                        this.f7643c.zzt.zzm().f7772e.zzb(str);
                    }
                    this.f7643c.zzQ();
                    zzfr = this.f7643c.zzt;
                }
            }
        } catch (RemoteException e10) {
            this.f7643c.zzt.zzay().zzd().zzb("Failed to get app instance id", e10);
            zzfr = this.f7643c.zzt;
        } catch (Throwable th) {
            this.f7643c.zzt.zzv().zzV(this.f7642b, (String) null);
            throw th;
        }
        zzfr.zzv().zzV(this.f7642b, str);
    }
}
