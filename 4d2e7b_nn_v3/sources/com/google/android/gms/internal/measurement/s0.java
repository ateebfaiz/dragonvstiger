package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

final class s0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f7304e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f7305f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Object f7306g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ boolean f7307h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ zzef f7308i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    s0(zzef zzef, String str, String str2, Object obj, boolean z10) {
        super(zzef, true);
        this.f7308i = zzef;
        this.f7304e = str;
        this.f7305f = str2;
        this.f7306g = obj;
        this.f7307h = z10;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7308i.zzj)).setUserProperty(this.f7304e, this.f7305f, ObjectWrapper.wrap(this.f7306g), this.f7307h, this.f7315a);
    }
}
