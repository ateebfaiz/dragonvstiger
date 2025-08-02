package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

final class d0 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final String f7450a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzfo f7451b;

    public d0(zzfo zzfo, String str) {
        this.f7451b = zzfo;
        Preconditions.checkNotNull(str);
        this.f7450a = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f7451b.zzt.zzay().zzd().zzb(this.f7450a, th);
    }
}
