package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

final class b1 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Activity f7124e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzbz f7125f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ d1 f7126g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    b1(d1 d1Var, Activity activity, zzbz zzbz) {
        super(d1Var.f7140a, true);
        this.f7126g = d1Var;
        this.f7124e = activity;
        this.f7125f = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7126g.f7140a.zzj)).onActivitySaveInstanceState(ObjectWrapper.wrap(this.f7124e), this.f7125f, this.f7316b);
    }
}
