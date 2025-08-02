package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class s extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Bundle f7302e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7303f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    s(zzef zzef, Bundle bundle) {
        super(zzef, true);
        this.f7303f = zzef;
        this.f7302e = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7303f.zzj)).setConsent(this.f7302e, this.f7315a);
    }
}
