package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzcf;

final class s2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzaw f7703a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7704b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzcf f7705c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzjm f7706d;

    s2(zzjm zzjm, zzaw zzaw, String str, zzcf zzcf) {
        this.f7706d = zzjm;
        this.f7703a = zzaw;
        this.f7704b = str;
        this.f7705c = zzcf;
    }

    public final void run() {
        zzfr zzfr;
        byte[] bArr = null;
        try {
            zzjm zzjm = this.f7706d;
            zzdx zzh = zzjm.zzb;
            if (zzh == null) {
                zzjm.zzt.zzay().zzd().zza("Discarding data. Failed to send event to service to bundle");
                zzfr = this.f7706d.zzt;
            } else {
                bArr = zzh.zzu(this.f7703a, this.f7704b);
                this.f7706d.zzQ();
                zzfr = this.f7706d.zzt;
            }
        } catch (RemoteException e10) {
            this.f7706d.zzt.zzay().zzd().zzb("Failed to send event to the service to bundle", e10);
            zzfr = this.f7706d.zzt;
        } catch (Throwable th) {
            this.f7706d.zzt.zzv().zzS(this.f7705c, bArr);
            throw th;
        }
        zzfr.zzv().zzS(this.f7705c, bArr);
    }
}
