package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class k1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f7585a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7586b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f7587c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzhx f7588d;

    k1(zzhx zzhx, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f7588d = zzhx;
        this.f7585a = atomicReference;
        this.f7586b = str2;
        this.f7587c = str3;
    }

    public final void run() {
        this.f7588d.zzt.zzt().zzw(this.f7585a, (String) null, this.f7586b, this.f7587c);
    }
}
