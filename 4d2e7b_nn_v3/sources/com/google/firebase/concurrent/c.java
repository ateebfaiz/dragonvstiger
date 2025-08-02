package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class c implements p.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f9025a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f9026b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f9027c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f9028d;

    public /* synthetic */ c(o oVar, Runnable runnable, long j10, TimeUnit timeUnit) {
        this.f9025a = oVar;
        this.f9026b = runnable;
        this.f9027c = j10;
        this.f9028d = timeUnit;
    }

    public final ScheduledFuture a(p.b bVar) {
        return this.f9025a.p(this.f9026b, this.f9027c, this.f9028d, bVar);
    }
}
