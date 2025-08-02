package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class c0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzbz f7131e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7132f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    c0(zzef zzef, zzbz zzbz) {
        super(zzef, true);
        this.f7132f = zzef;
        this.f7131e = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7132f.zzj)).getCurrentScreenName(this.f7131e);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f7131e.zze((Bundle) null);
    }
}
