package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

final class p0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ v0 f7262e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7263f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    p0(zzef zzef, v0 v0Var) {
        super(zzef, true);
        this.f7263f = zzef;
        this.f7262e = v0Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7263f.zzj)).registerOnMeasurementEventListener(this.f7262e);
    }
}
