package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class j0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzbz f7204e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7205f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    j0(zzef zzef, zzbz zzbz) {
        super(zzef, true);
        this.f7205f = zzef;
        this.f7204e = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7205f.zzj)).getAppInstanceId(this.f7204e);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f7204e.zze((Bundle) null);
    }
}
