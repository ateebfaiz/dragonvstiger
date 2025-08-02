package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class m extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Bundle f7222e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7223f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    m(zzef zzef, Bundle bundle) {
        super(zzef, true);
        this.f7223f = zzef;
        this.f7222e = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7223f.zzj)).setConditionalUserProperty(this.f7222e, this.f7315a);
    }
}
