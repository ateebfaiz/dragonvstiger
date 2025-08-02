package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class l0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f7605a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7606b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f7607c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzgj f7608d;

    l0(zzgj zzgj, String str, String str2, String str3) {
        this.f7608d = zzgj;
        this.f7605a = str;
        this.f7606b = str2;
        this.f7607c = str3;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        this.f7608d.zza.zzA();
        return this.f7608d.zza.zzi().L(this.f7605a, this.f7606b, this.f7607c);
    }
}
