package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class d1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f6680a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6681b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzd f6682c;

    d1(zzd zzd, LifecycleCallback lifecycleCallback, String str) {
        this.f6682c = zzd;
        this.f6680a = lifecycleCallback;
        this.f6681b = str;
    }

    public final void run() {
        Bundle bundle;
        zzd zzd = this.f6682c;
        if (zzd.zzc > 0) {
            LifecycleCallback lifecycleCallback = this.f6680a;
            if (zzd.zzd != null) {
                bundle = zzd.zzd.getBundle(this.f6681b);
            } else {
                bundle = null;
            }
            lifecycleCallback.onCreate(bundle);
        }
        if (this.f6682c.zzc >= 2) {
            this.f6680a.onStart();
        }
        if (this.f6682c.zzc >= 3) {
            this.f6680a.onResume();
        }
        if (this.f6682c.zzc >= 4) {
            this.f6680a.onStop();
        }
        if (this.f6682c.zzc >= 5) {
            this.f6680a.onDestroy();
        }
    }
}
