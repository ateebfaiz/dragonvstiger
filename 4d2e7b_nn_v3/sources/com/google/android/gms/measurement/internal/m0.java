package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class m0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f7620a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7621b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f7622c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzgj f7623d;

    m0(zzgj zzgj, String str, String str2, String str3) {
        this.f7623d = zzgj;
        this.f7620a = str;
        this.f7621b = str2;
        this.f7622c = str3;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        this.f7623d.zza.zzA();
        return this.f7623d.zza.zzi().L(this.f7620a, this.f7621b, this.f7622c);
    }
}
