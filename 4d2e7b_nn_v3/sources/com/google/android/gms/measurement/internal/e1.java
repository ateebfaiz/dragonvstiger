package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class e1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f7471a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7472b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f7473c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Bundle f7474d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ boolean f7475e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ boolean f7476f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ boolean f7477g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ String f7478h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ zzhx f7479i;

    e1(zzhx zzhx, String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        this.f7479i = zzhx;
        this.f7471a = str;
        this.f7472b = str2;
        this.f7473c = j10;
        this.f7474d = bundle;
        this.f7475e = z10;
        this.f7476f = z11;
        this.f7477g = z12;
        this.f7478h = str3;
    }

    public final void run() {
        this.f7479i.zzI(this.f7471a, this.f7472b, this.f7473c, this.f7474d, this.f7475e, this.f7476f, this.f7477g, this.f7478h);
    }
}
