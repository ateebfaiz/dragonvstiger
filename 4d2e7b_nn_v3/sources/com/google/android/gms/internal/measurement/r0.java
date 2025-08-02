package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class r0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Long f7279e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f7280f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ String f7281g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ Bundle f7282h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ boolean f7283i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ boolean f7284j;

    /* renamed from: w  reason: collision with root package name */
    final /* synthetic */ zzef f7285w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    r0(zzef zzef, Long l10, String str, String str2, Bundle bundle, boolean z10, boolean z11) {
        super(zzef, true);
        this.f7285w = zzef;
        this.f7279e = l10;
        this.f7280f = str;
        this.f7281g = str2;
        this.f7282h = bundle;
        this.f7283i = z10;
        this.f7284j = z11;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        long longValue;
        Long l10 = this.f7279e;
        if (l10 == null) {
            longValue = this.f7315a;
        } else {
            longValue = l10.longValue();
        }
        ((zzcc) Preconditions.checkNotNull(this.f7285w.zzj)).logEvent(this.f7280f, this.f7281g, this.f7282h, this.f7283i, this.f7284j, longValue);
    }
}
