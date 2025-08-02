package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class i0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f7194e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzbz f7195f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ zzef f7196g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    i0(zzef zzef, String str, zzbz zzbz) {
        super(zzef, true);
        this.f7196g = zzef;
        this.f7194e = str;
        this.f7195f = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7196g.zzj)).getMaxUserProperties(this.f7194e, this.f7195f);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f7195f.zze((Bundle) null);
    }
}
