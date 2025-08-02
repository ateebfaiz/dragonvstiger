package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

final class m2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f7629a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzq f7630b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzjm f7631c;

    m2(zzjm zzjm, AtomicReference atomicReference, zzq zzq) {
        this.f7631c = zzjm;
        this.f7629a = atomicReference;
        this.f7630b = zzq;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.f7629a) {
            try {
                if (!this.f7631c.zzt.zzm().c().zzi(zzah.ANALYTICS_STORAGE)) {
                    this.f7631c.zzt.zzay().zzl().zza("Analytics storage consent denied; will not get app instance id");
                    this.f7631c.zzt.zzq().zzO((String) null);
                    this.f7631c.zzt.zzm().f7772e.zzb((String) null);
                    this.f7629a.set((Object) null);
                    this.f7629a.notify();
                    return;
                }
                zzjm zzjm = this.f7631c;
                zzdx zzh = zzjm.zzb;
                if (zzh == null) {
                    zzjm.zzt.zzay().zzd().zza("Failed to get app instance id");
                    this.f7629a.notify();
                    return;
                }
                Preconditions.checkNotNull(this.f7630b);
                this.f7629a.set(zzh.zzd(this.f7630b));
                String str = (String) this.f7629a.get();
                if (str != null) {
                    this.f7631c.zzt.zzq().zzO(str);
                    this.f7631c.zzt.zzm().f7772e.zzb(str);
                }
                this.f7631c.zzQ();
                atomicReference = this.f7629a;
                atomicReference.notify();
            } catch (RemoteException e10) {
                try {
                    this.f7631c.zzt.zzay().zzd().zzb("Failed to get app instance id", e10);
                    atomicReference = this.f7629a;
                } catch (Throwable th) {
                    this.f7629a.notify();
                    throw th;
                }
            }
        }
    }
}
