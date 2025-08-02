package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

final class w0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Bundle f7345e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Activity f7346f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ d1 f7347g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    w0(d1 d1Var, Bundle bundle, Activity activity) {
        super(d1Var.f7140a, true);
        this.f7347g = d1Var;
        this.f7345e = bundle;
        this.f7346f = activity;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        Bundle bundle;
        if (this.f7345e != null) {
            bundle = new Bundle();
            if (this.f7345e.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.f7345e.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        ((zzcc) Preconditions.checkNotNull(this.f7347g.f7140a.zzj)).onActivityCreated(ObjectWrapper.wrap(this.f7346f), bundle, this.f7316b);
    }
}
