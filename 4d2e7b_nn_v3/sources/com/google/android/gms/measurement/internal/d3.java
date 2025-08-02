package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

final class d3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ComponentName f7459a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzjl f7460b;

    d3(zzjl zzjl, ComponentName componentName) {
        this.f7460b = zzjl;
        this.f7459a = componentName;
    }

    public final void run() {
        zzjm.zzo(this.f7460b.zza, this.f7459a);
    }
}
