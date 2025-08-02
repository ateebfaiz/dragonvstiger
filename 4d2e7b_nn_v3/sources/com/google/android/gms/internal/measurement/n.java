package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class n extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f7229e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f7230f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Bundle f7231g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ zzef f7232h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    n(zzef zzef, String str, String str2, Bundle bundle) {
        super(zzef, true);
        this.f7232h = zzef;
        this.f7229e = str;
        this.f7230f = str2;
        this.f7231g = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7232h.zzj)).clearConditionalUserProperty(this.f7229e, this.f7230f, this.f7231g);
    }
}
