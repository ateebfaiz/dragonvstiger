package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class c1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f6674a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6675b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzb f6676c;

    c1(zzb zzb, LifecycleCallback lifecycleCallback, String str) {
        this.f6676c = zzb;
        this.f6674a = lifecycleCallback;
        this.f6675b = str;
    }

    public final void run() {
        Bundle bundle;
        zzb zzb = this.f6676c;
        if (zzb.zzc > 0) {
            LifecycleCallback lifecycleCallback = this.f6674a;
            if (zzb.zzd != null) {
                bundle = zzb.zzd.getBundle(this.f6675b);
            } else {
                bundle = null;
            }
            lifecycleCallback.onCreate(bundle);
        }
        if (this.f6676c.zzc >= 2) {
            this.f6674a.onStart();
        }
        if (this.f6676c.zzc >= 3) {
            this.f6674a.onResume();
        }
        if (this.f6676c.zzc >= 4) {
            this.f6674a.onStop();
        }
        if (this.f6676c.zzc >= 5) {
            this.f6674a.onDestroy();
        }
    }
}
