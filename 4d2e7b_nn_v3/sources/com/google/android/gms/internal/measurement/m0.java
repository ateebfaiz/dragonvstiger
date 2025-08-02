package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

final class m0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ boolean f7224e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7225f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    m0(zzef zzef, boolean z10) {
        super(zzef, true);
        this.f7225f = zzef;
        this.f7224e = z10;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7225f.zzj)).setDataCollectionEnabled(this.f7224e);
    }
}
