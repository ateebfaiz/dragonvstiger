package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class d0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzbz f7138e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7139f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    d0(zzef zzef, zzbz zzbz) {
        super(zzef, true);
        this.f7139f = zzef;
        this.f7138e = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7139f.zzj)).getCurrentScreenClass(this.f7138e);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f7138e.zze((Bundle) null);
    }
}
