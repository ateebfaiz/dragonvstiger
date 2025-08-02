package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class c2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle f7438a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzie f7439b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzie f7440c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f7441d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzim f7442e;

    c2(zzim zzim, Bundle bundle, zzie zzie, zzie zzie2, long j10) {
        this.f7442e = zzim;
        this.f7438a = bundle;
        this.f7439b = zzie;
        this.f7440c = zzie2;
        this.f7441d = j10;
    }

    public final void run() {
        zzim.zzp(this.f7442e, this.f7438a, this.f7439b, this.f7440c, this.f7441d);
    }
}
