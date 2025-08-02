package com.google.android.gms.measurement.internal;

final class f1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f7499a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7500b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Object f7501c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f7502d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzhx f7503e;

    f1(zzhx zzhx, String str, String str2, Object obj, long j10) {
        this.f7503e = zzhx;
        this.f7499a = str;
        this.f7500b = str2;
        this.f7501c = obj;
        this.f7502d = j10;
    }

    public final void run() {
        this.f7503e.zzY(this.f7499a, this.f7500b, this.f7501c, this.f7502d);
    }
}
