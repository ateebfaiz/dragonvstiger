package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class z2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f7814a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7815b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f7816c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzq f7817d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzjm f7818e;

    z2(zzjm zzjm, AtomicReference atomicReference, String str, String str2, String str3, zzq zzq) {
        this.f7818e = zzjm;
        this.f7814a = atomicReference;
        this.f7815b = str2;
        this.f7816c = str3;
        this.f7817d = zzq;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.f7814a) {
            try {
                zzjm zzjm = this.f7818e;
                zzdx zzh = zzjm.zzb;
                if (zzh == null) {
                    zzjm.zzt.zzay().zzd().zzd("(legacy) Failed to get conditional properties; not connected to service", (Object) null, this.f7815b, this.f7816c);
                    this.f7814a.set(Collections.emptyList());
                    this.f7814a.notify();
                    return;
                }
                if (TextUtils.isEmpty((CharSequence) null)) {
                    Preconditions.checkNotNull(this.f7817d);
                    this.f7814a.set(zzh.zzf(this.f7815b, this.f7816c, this.f7817d));
                } else {
                    this.f7814a.set(zzh.zzg((String) null, this.f7815b, this.f7816c));
                }
                this.f7818e.zzQ();
                atomicReference = this.f7814a;
                atomicReference.notify();
            } catch (RemoteException e10) {
                try {
                    this.f7818e.zzt.zzay().zzd().zzd("(legacy) Failed to get conditional properties; remote exception", (Object) null, this.f7815b, e10);
                    this.f7814a.set(Collections.emptyList());
                    atomicReference = this.f7814a;
                } catch (Throwable th) {
                    this.f7814a.notify();
                    throw th;
                }
            }
        }
    }
}
