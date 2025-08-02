package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

final class q0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ v0 f7274e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7275f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    q0(zzef zzef, v0 v0Var) {
        super(zzef, true);
        this.f7275f = zzef;
        this.f7274e = v0Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7275f.zzj)).unregisterOnMeasurementEventListener(this.f7274e);
    }
}
