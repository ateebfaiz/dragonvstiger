package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class h implements p.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f9043a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f9044b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f9045c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f9046d;

    public /* synthetic */ h(o oVar, Callable callable, long j10, TimeUnit timeUnit) {
        this.f9043a = oVar;
        this.f9044b = callable;
        this.f9045c = j10;
        this.f9046d = timeUnit;
    }

    public final ScheduledFuture a(p.b bVar) {
        return this.f9043a.s(this.f9044b, this.f9045c, this.f9046d, bVar);
    }
}
