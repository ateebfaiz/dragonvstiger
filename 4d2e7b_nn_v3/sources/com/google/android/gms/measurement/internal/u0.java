package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class u0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f7726a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzgj f7727b;

    u0(zzgj zzgj, String str) {
        this.f7727b = zzgj;
        this.f7726a = str;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        this.f7727b.zza.zzA();
        return this.f7727b.zza.zzi().N(this.f7726a);
    }
}
