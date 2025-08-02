package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class j0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f7564a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7565b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f7566c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzgj f7567d;

    j0(zzgj zzgj, String str, String str2, String str3) {
        this.f7567d = zzgj;
        this.f7564a = str;
        this.f7565b = str2;
        this.f7566c = str3;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        this.f7567d.zza.zzA();
        return this.f7567d.zza.zzi().O(this.f7564a, this.f7565b, this.f7566c);
    }
}
