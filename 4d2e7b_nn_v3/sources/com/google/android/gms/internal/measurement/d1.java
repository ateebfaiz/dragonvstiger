package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

final class d1 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzef f7140a;

    d1(zzef zzef) {
        this.f7140a = zzef;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.f7140a.zzV(new w0(this, bundle, activity));
    }

    public final void onActivityDestroyed(Activity activity) {
        this.f7140a.zzV(new c1(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        this.f7140a.zzV(new z0(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        this.f7140a.zzV(new y0(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzbz zzbz = new zzbz();
        this.f7140a.zzV(new b1(this, activity, zzbz));
        Bundle zzb = zzbz.zzb(50);
        if (zzb != null) {
            bundle.putAll(zzb);
        }
    }

    public final void onActivityStarted(Activity activity) {
        this.f7140a.zzV(new x0(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        this.f7140a.zzV(new a1(this, activity));
    }
}
