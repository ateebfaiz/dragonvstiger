package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.List;

final class i2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f7552a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7553b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzq f7554c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f7555d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzcf f7556e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzjm f7557f;

    i2(zzjm zzjm, String str, String str2, zzq zzq, boolean z10, zzcf zzcf) {
        this.f7557f = zzjm;
        this.f7552a = str;
        this.f7553b = str2;
        this.f7554c = zzq;
        this.f7555d = z10;
        this.f7556e = zzcf;
    }

    public final void run() {
        Throwable th;
        Bundle bundle;
        RemoteException e10;
        Bundle bundle2 = new Bundle();
        try {
            zzjm zzjm = this.f7557f;
            zzdx zzh = zzjm.zzb;
            if (zzh == null) {
                zzjm.zzt.zzay().zzd().zzc("Failed to get user properties; not connected to service", this.f7552a, this.f7553b);
                this.f7557f.zzt.zzv().zzR(this.f7556e, bundle2);
                return;
            }
            Preconditions.checkNotNull(this.f7554c);
            List<zzkw> zzh2 = zzh.zzh(this.f7552a, this.f7553b, this.f7555d, this.f7554c);
            bundle = new Bundle();
            if (zzh2 != null) {
                for (zzkw zzkw : zzh2) {
                    String str = zzkw.zze;
                    if (str != null) {
                        bundle.putString(zzkw.zzb, str);
                    } else {
                        Long l10 = zzkw.zzd;
                        if (l10 != null) {
                            bundle.putLong(zzkw.zzb, l10.longValue());
                        } else {
                            Double d10 = zzkw.zzg;
                            if (d10 != null) {
                                bundle.putDouble(zzkw.zzb, d10.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                this.f7557f.zzQ();
                this.f7557f.zzt.zzv().zzR(this.f7556e, bundle);
            } catch (RemoteException e11) {
                e10 = e11;
                try {
                    this.f7557f.zzt.zzay().zzd().zzc("Failed to get user properties; remote exception", this.f7552a, e10);
                    this.f7557f.zzt.zzv().zzR(this.f7556e, bundle);
                } catch (Throwable th2) {
                    th = th2;
                    bundle2 = bundle;
                    this.f7557f.zzt.zzv().zzR(this.f7556e, bundle2);
                    throw th;
                }
            }
        } catch (RemoteException e12) {
            bundle = bundle2;
            e10 = e12;
            this.f7557f.zzt.zzay().zzd().zzc("Failed to get user properties; remote exception", this.f7552a, e10);
            this.f7557f.zzt.zzv().zzR(this.f7556e, bundle);
        } catch (Throwable th3) {
            th = th3;
            this.f7557f.zzt.zzv().zzR(this.f7556e, bundle2);
            throw th;
        }
    }
}
