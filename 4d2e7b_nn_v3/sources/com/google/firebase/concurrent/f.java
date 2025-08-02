package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class f implements p.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f9033a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f9034b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f9035c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f9036d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f9037e;

    public /* synthetic */ f(o oVar, Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        this.f9033a = oVar;
        this.f9034b = runnable;
        this.f9035c = j10;
        this.f9036d = j11;
        this.f9037e = timeUnit;
    }

    public final ScheduledFuture a(p.b bVar) {
        return this.f9033a.v(this.f9034b, this.f9035c, this.f9036d, this.f9037e, bVar);
    }
}
