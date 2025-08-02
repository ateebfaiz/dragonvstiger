package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class z extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzbz f7367e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7368f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    z(zzef zzef, zzbz zzbz) {
        super(zzef, true);
        this.f7368f = zzef;
        this.f7367e = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7368f.zzj)).getGmpAppId(this.f7367e);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f7367e.zze((Bundle) null);
    }
}
