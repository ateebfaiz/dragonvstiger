package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class a0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzbz f7112e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7113f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    a0(zzef zzef, zzbz zzbz) {
        super(zzef, true);
        this.f7113f = zzef;
        this.f7112e = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7113f.zzj)).getCachedAppInstanceId(this.f7112e);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f7112e.zze((Bundle) null);
    }
}
