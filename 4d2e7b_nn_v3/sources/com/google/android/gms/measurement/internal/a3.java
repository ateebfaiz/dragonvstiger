package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.ArrayList;

final class a3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f7386a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7387b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzq f7388c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzcf f7389d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzjm f7390e;

    a3(zzjm zzjm, String str, String str2, zzq zzq, zzcf zzcf) {
        this.f7390e = zzjm;
        this.f7386a = str;
        this.f7387b = str2;
        this.f7388c = zzq;
        this.f7389d = zzcf;
    }

    public final void run() {
        zzfr zzfr;
        ArrayList arrayList = new ArrayList();
        try {
            zzjm zzjm = this.f7390e;
            zzdx zzh = zzjm.zzb;
            if (zzh == null) {
                zzjm.zzt.zzay().zzd().zzc("Failed to get conditional properties; not connected to service", this.f7386a, this.f7387b);
                zzfr = this.f7390e.zzt;
            } else {
                Preconditions.checkNotNull(this.f7388c);
                arrayList = zzlb.zzH(zzh.zzf(this.f7386a, this.f7387b, this.f7388c));
                this.f7390e.zzQ();
                zzfr = this.f7390e.zzt;
            }
        } catch (RemoteException e10) {
            this.f7390e.zzt.zzay().zzd().zzd("Failed to get conditional properties; remote exception", this.f7386a, this.f7387b, e10);
            zzfr = this.f7390e.zzt;
        } catch (Throwable th) {
            this.f7390e.zzt.zzv().zzQ(this.f7389d, arrayList);
            throw th;
        }
        zzfr.zzv().zzQ(this.f7389d, arrayList);
    }
}
