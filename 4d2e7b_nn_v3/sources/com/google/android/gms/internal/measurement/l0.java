package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class l0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzbz f7215e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ int f7216f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ zzef f7217g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    l0(zzef zzef, zzbz zzbz, int i10) {
        super(zzef, true);
        this.f7217g = zzef;
        this.f7215e = zzbz;
        this.f7216f = i10;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7217g.zzj)).getTestFlag(this.f7215e, this.f7216f);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f7215e.zze((Bundle) null);
    }
}
