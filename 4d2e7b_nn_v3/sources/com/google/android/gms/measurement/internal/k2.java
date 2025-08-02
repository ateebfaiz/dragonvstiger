package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

final class k2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f7589a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzq f7590b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ boolean f7591c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzjm f7592d;

    k2(zzjm zzjm, AtomicReference atomicReference, zzq zzq, boolean z10) {
        this.f7592d = zzjm;
        this.f7589a = atomicReference;
        this.f7590b = zzq;
        this.f7591c = z10;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.f7589a) {
            try {
                zzjm zzjm = this.f7592d;
                zzdx zzh = zzjm.zzb;
                if (zzh == null) {
                    zzjm.zzt.zzay().zzd().zza("Failed to get all user properties; not connected to service");
                    this.f7589a.notify();
                    return;
                }
                Preconditions.checkNotNull(this.f7590b);
                this.f7589a.set(zzh.zze(this.f7590b, this.f7591c));
                this.f7592d.zzQ();
                atomicReference = this.f7589a;
                atomicReference.notify();
            } catch (RemoteException e10) {
                try {
                    this.f7592d.zzt.zzay().zzd().zzb("Failed to get all user properties; remote exception", e10);
                    atomicReference = this.f7589a;
                } catch (Throwable th) {
                    this.f7589a.notify();
                    throw th;
                }
            }
        }
    }
}
