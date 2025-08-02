package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class b0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzbz f7122e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7123f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    b0(zzef zzef, zzbz zzbz) {
        super(zzef, true);
        this.f7123f = zzef;
        this.f7122e = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7123f.zzj)).generateEventId(this.f7122e);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f7122e.zze((Bundle) null);
    }
}
