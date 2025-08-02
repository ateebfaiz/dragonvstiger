package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class g implements p.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f9038a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f9039b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f9040c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f9041d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f9042e;

    public /* synthetic */ g(o oVar, Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        this.f9038a = oVar;
        this.f9039b = runnable;
        this.f9040c = j10;
        this.f9041d = j11;
        this.f9042e = timeUnit;
    }

    public final ScheduledFuture a(p.b bVar) {
        return this.f9038a.x(this.f9039b, this.f9040c, this.f9041d, this.f9042e, bVar);
    }
}
