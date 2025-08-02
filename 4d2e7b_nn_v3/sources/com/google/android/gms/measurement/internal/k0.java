package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class k0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f7581a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7582b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f7583c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzgj f7584d;

    k0(zzgj zzgj, String str, String str2, String str3) {
        this.f7584d = zzgj;
        this.f7581a = str;
        this.f7582b = str2;
        this.f7583c = str3;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        this.f7584d.zza.zzA();
        return this.f7584d.zza.zzi().O(this.f7581a, this.f7582b, this.f7583c);
    }
}
