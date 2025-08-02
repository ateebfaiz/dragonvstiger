package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

final class f0 extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f7163e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Object f7164f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ zzef f7165g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    f0(zzef zzef, boolean z10, int i10, String str, Object obj, Object obj2, Object obj3) {
        super(zzef, false);
        this.f7165g = zzef;
        this.f7163e = str;
        this.f7164f = obj;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7165g.zzj)).logHealthData(5, this.f7163e, ObjectWrapper.wrap(this.f7164f), ObjectWrapper.wrap(null), ObjectWrapper.wrap(null));
    }
}
