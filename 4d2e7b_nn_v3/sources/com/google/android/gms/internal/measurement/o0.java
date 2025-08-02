package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

final class o0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ u0 f7241e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7242f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    o0(zzef zzef, u0 u0Var) {
        super(zzef, true);
        this.f7242f = zzef;
        this.f7241e = u0Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7242f.zzj)).setEventInterceptor(this.f7241e);
    }
}
