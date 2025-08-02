package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

final class a1 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Activity f7114e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ d1 f7115f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    a1(d1 d1Var, Activity activity) {
        super(d1Var.f7140a, true);
        this.f7115f = d1Var;
        this.f7114e = activity;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7115f.f7140a.zzj)).onActivityStopped(ObjectWrapper.wrap(this.f7114e), this.f7316b);
    }
}
