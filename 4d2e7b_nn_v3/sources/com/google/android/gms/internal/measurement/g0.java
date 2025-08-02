package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class g0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Bundle f7176e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzbz f7177f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ zzef f7178g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    g0(zzef zzef, Bundle bundle, zzbz zzbz) {
        super(zzef, true);
        this.f7178g = zzef;
        this.f7176e = bundle;
        this.f7177f = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7178g.zzj)).performAction(this.f7176e, this.f7177f, this.f7315a);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f7177f.zze((Bundle) null);
    }
}
