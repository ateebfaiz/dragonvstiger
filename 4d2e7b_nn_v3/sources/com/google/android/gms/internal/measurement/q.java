package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

final class q extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Activity f7270e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f7271f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ String f7272g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ zzef f7273h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    q(zzef zzef, Activity activity, String str, String str2) {
        super(zzef, true);
        this.f7273h = zzef;
        this.f7270e = activity;
        this.f7271f = str;
        this.f7272g = str2;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((zzcc) Preconditions.checkNotNull(this.f7273h.zzj)).setCurrentScreen(ObjectWrapper.wrap(this.f7270e), this.f7271f, this.f7272g, this.f7315a);
    }
}
