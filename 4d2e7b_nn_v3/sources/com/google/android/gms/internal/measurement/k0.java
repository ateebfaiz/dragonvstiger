package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class k0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzbz f7208e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7209f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    k0(zzef zzef, zzbz zzbz) {
        super(zzef, true);
        this.f7209f = zzef;
        this.f7208e = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7209f.zzj)).getSessionId(this.f7208e);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f7208e.zze((Bundle) null);
    }
}
