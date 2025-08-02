package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.m;

public final class q1 implements p1 {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f20223a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f20224b;

    /* renamed from: c  reason: collision with root package name */
    private final Deque f20225c = new ArrayDeque();

    public q1(Executor executor) {
        m.f(executor, "executor");
        this.f20223a = executor;
    }

    public synchronized void a(Runnable runnable) {
        m.f(runnable, "runnable");
        this.f20225c.remove(runnable);
    }

    public synchronized void b(Runnable runnable) {
        try {
            m.f(runnable, "runnable");
            if (this.f20224b) {
                this.f20225c.add(runnable);
            } else {
                this.f20223a.execute(runnable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
