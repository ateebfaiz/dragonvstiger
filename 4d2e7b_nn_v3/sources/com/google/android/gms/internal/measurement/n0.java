package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class n0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Bundle f7233e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7234f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    n0(zzef zzef, Bundle bundle) {
        super(zzef, true);
        this.f7234f = zzef;
        this.f7233e = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7234f.zzj)).setDefaultEventParameters(this.f7233e);
    }
}
