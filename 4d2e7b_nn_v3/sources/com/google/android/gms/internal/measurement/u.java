package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

final class u extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzef f7323e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    u(zzef zzef) {
        super(zzef, true);
        this.f7323e = zzef;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7323e.zzj)).resetAnalyticsData(this.f7315a);
    }
}
