package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

final class v extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ long f7330e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7331f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    v(zzef zzef, long j10) {
        super(zzef, true);
        this.f7331f = zzef;
        this.f7330e = j10;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7331f.zzj)).setSessionTimeoutDuration(this.f7330e);
    }
}
