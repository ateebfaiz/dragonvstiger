package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class o extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f7237e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f7238f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ zzbz f7239g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ zzef f7240h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    o(zzef zzef, String str, String str2, zzbz zzbz) {
        super(zzef, true);
        this.f7240h = zzef;
        this.f7237e = str;
        this.f7238f = str2;
        this.f7239g = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7240h.zzj)).getConditionalUserProperties(this.f7237e, this.f7238f, this.f7239g);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f7239g.zze((Bundle) null);
    }
}
