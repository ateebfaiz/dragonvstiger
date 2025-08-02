package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class b3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f7399a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7400b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f7401c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzq f7402d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ boolean f7403e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzjm f7404f;

    b3(zzjm zzjm, AtomicReference atomicReference, String str, String str2, String str3, zzq zzq, boolean z10) {
        this.f7404f = zzjm;
        this.f7399a = atomicReference;
        this.f7400b = str2;
        this.f7401c = str3;
        this.f7402d = zzq;
        this.f7403e = z10;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.f7399a) {
            try {
                zzjm zzjm = this.f7404f;
                zzdx zzh = zzjm.zzb;
                if (zzh == null) {
                    zzjm.zzt.zzay().zzd().zzd("(legacy) Failed to get user properties; not connected to service", (Object) null, this.f7400b, this.f7401c);
                    this.f7399a.set(Collections.emptyList());
                    this.f7399a.notify();
                    return;
                }
                if (TextUtils.isEmpty((CharSequence) null)) {
                    Preconditions.checkNotNull(this.f7402d);
                    this.f7399a.set(zzh.zzh(this.f7400b, this.f7401c, this.f7403e, this.f7402d));
                } else {
                    this.f7399a.set(zzh.zzi((String) null, this.f7400b, this.f7401c, this.f7403e));
                }
                this.f7404f.zzQ();
                atomicReference = this.f7399a;
                atomicReference.notify();
            } catch (RemoteException e10) {
                try {
                    this.f7404f.zzt.zzay().zzd().zzd("(legacy) Failed to get user properties; remote exception", (Object) null, this.f7400b, e10);
                    this.f7399a.set(Collections.emptyList());
                    atomicReference = this.f7399a;
                } catch (Throwable th) {
                    this.f7399a.notify();
                    throw th;
                }
            }
        }
    }
}
