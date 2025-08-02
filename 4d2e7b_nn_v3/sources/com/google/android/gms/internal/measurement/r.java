package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

final class r extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Boolean f7277e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzef f7278f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    r(zzef zzef, Boolean bool) {
        super(zzef, true);
        this.f7278f = zzef;
        this.f7277e = bool;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (this.f7277e != null) {
            ((zzcc) Preconditions.checkNotNull(this.f7278f.zzj)).setMeasurementEnabled(this.f7277e.booleanValue(), this.f7315a);
        } else {
            ((zzcc) Preconditions.checkNotNull(this.f7278f.zzj)).clearMeasurementEnabled(this.f7315a);
        }
    }
}
