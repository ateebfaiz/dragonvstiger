package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class m1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f7624a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7625b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f7626c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f7627d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzhx f7628e;

    m1(zzhx zzhx, AtomicReference atomicReference, String str, String str2, String str3, boolean z10) {
        this.f7628e = zzhx;
        this.f7624a = atomicReference;
        this.f7625b = str2;
        this.f7626c = str3;
        this.f7627d = z10;
    }

    public final void run() {
        this.f7628e.zzt.zzt().zzz(this.f7624a, (String) null, this.f7625b, this.f7626c, this.f7627d);
    }
}
