package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class o implements ScheduledExecutorService {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f9063a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f9064b;

    o(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.f9063a = executorService;
        this.f9064b = scheduledExecutorService;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void n(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
            bVar.set((Object) null);
        } catch (Exception e10) {
            bVar.a(e10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(Runnable runnable, p.b bVar) {
        this.f9063a.execute(new m(runnable, bVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture p(Runnable runnable, long j10, TimeUnit timeUnit, p.b bVar) {
        return this.f9064b.schedule(new j(this, runnable, bVar), j10, timeUnit);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void q(Callable callable, p.b bVar) {
        try {
            bVar.set(callable.call());
        } catch (Exception e10) {
            bVar.a(e10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Future r(Callable callable, p.b bVar) {
        return this.f9063a.submit(new n(callable, bVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture s(Callable callable, long j10, TimeUnit timeUnit, p.b bVar) {
        return this.f9064b.schedule(new k(this, callable, bVar), j10, timeUnit);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void t(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
        } catch (Exception e10) {
            bVar.a(e10);
            throw e10;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u(Runnable runnable, p.b bVar) {
        this.f9063a.execute(new d(runnable, bVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture v(Runnable runnable, long j10, long j11, TimeUnit timeUnit, p.b bVar) {
        return this.f9064b.scheduleAtFixedRate(new i(this, runnable, bVar), j10, j11, timeUnit);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(Runnable runnable, p.b bVar) {
        this.f9063a.execute(new e(runnable, bVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture x(Runnable runnable, long j10, long j11, TimeUnit timeUnit, p.b bVar) {
        return this.f9064b.scheduleWithFixedDelay(new l(this, runnable, bVar), j10, j11, timeUnit);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void z(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
        } catch (Exception e10) {
            bVar.a(e10);
        }
    }

    public boolean awaitTermination(long j10, TimeUnit timeUnit) {
        return this.f9063a.awaitTermination(j10, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.f9063a.execute(runnable);
    }

    public List invokeAll(Collection collection) {
        return this.f9063a.invokeAll(collection);
    }

    public Object invokeAny(Collection collection) {
        return this.f9063a.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.f9063a.isShutdown();
    }

    public boolean isTerminated() {
        return this.f9063a.isTerminated();
    }

    public ScheduledFuture schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        return new p(new c(this, runnable, j10, timeUnit));
    }

    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return new p(new f(this, runnable, j10, j11, timeUnit));
    }

    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return new p(new g(this, runnable, j10, j11, timeUnit));
    }

    public void shutdown() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    public List shutdownNow() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    public Future submit(Callable callable) {
        return this.f9063a.submit(callable);
    }

    public List invokeAll(Collection collection, long j10, TimeUnit timeUnit) {
        return this.f9063a.invokeAll(collection, j10, timeUnit);
    }

    public Object invokeAny(Collection collection, long j10, TimeUnit timeUnit) {
        return this.f9063a.invokeAny(collection, j10, timeUnit);
    }

    public ScheduledFuture schedule(Callable callable, long j10, TimeUnit timeUnit) {
        return new p(new h(this, callable, j10, timeUnit));
    }

    public Future submit(Runnable runnable, Object obj) {
        return this.f9063a.submit(runnable, obj);
    }

    public Future submit(Runnable runnable) {
        return this.f9063a.submit(runnable);
    }
}
