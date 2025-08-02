package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class z3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f7819a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7820b = "_err";

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Bundle f7821c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ a4 f7822d;

    z3(a4 a4Var, String str, String str2, Bundle bundle) {
        this.f7822d = a4Var;
        this.f7819a = str;
        this.f7821c = bundle;
    }

    public final void run() {
        this.f7822d.f7391a.zzF((zzaw) Preconditions.checkNotNull(this.f7822d.f7391a.zzv().zzz(this.f7819a, this.f7820b, this.f7821c, "auto", this.f7822d.f7391a.zzav().currentTimeMillis(), false, true)), this.f7819a);
    }
}
