package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class e0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f7148e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f7149f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ boolean f7150g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ zzbz f7151h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ zzef f7152i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    e0(zzef zzef, String str, String str2, boolean z10, zzbz zzbz) {
        super(zzef, true);
        this.f7152i = zzef;
        this.f7148e = str;
        this.f7149f = str2;
        this.f7150g = z10;
        this.f7151h = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7152i.zzj)).getUserProperties(this.f7148e, this.f7149f, this.f7150g, this.f7151h);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f7151h.zze((Bundle) null);
    }
}
