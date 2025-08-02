package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class d2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzie f7454a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzie f7455b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f7456c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f7457d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzim f7458e;

    d2(zzim zzim, zzie zzie, zzie zzie2, long j10, boolean z10) {
        this.f7458e = zzim;
        this.f7454a = zzie;
        this.f7455b = zzie2;
        this.f7456c = j10;
        this.f7457d = z10;
    }

    public final void run() {
        this.f7458e.zzA(this.f7454a, this.f7455b, this.f7456c, this.f7457d, (Bundle) null);
    }
}
