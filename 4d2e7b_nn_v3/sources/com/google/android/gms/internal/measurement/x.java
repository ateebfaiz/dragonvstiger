package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

final class x extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f7349e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7350f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    x(zzef zzef, String str) {
        super(zzef, true);
        this.f7350f = zzef;
        this.f7349e = str;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7350f.zzj)).beginAdUnitExposure(this.f7349e, this.f7316b);
    }
}
