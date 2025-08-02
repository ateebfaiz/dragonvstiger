package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

final class p extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f7260e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7261f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    p(zzef zzef, String str) {
        super(zzef, true);
        this.f7261f = zzef;
        this.f7260e = str;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7261f.zzj)).setUserId(this.f7260e, this.f7315a);
    }
}
