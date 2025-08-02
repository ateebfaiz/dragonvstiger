package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class t extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Bundle f7313e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7314f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    t(zzef zzef, Bundle bundle) {
        super(zzef, true);
        this.f7314f = zzef;
        this.f7313e = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7314f.zzj)).setConsentThirdParty(this.f7313e, this.f7315a);
    }
}
