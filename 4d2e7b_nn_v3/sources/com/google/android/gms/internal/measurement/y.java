package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

final class y extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f7355e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7356f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    y(zzef zzef, String str) {
        super(zzef, true);
        this.f7356f = zzef;
        this.f7355e = str;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7356f.zzj)).endAdUnitExposure(this.f7355e, this.f7316b);
    }
}
