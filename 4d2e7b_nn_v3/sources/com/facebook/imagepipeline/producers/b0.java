package com.facebook.imagepipeline.producers;

import java.util.concurrent.Executor;
import kotlin.jvm.internal.m;

public final class b0 implements p1 {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f20033a;

    public b0(Executor executor) {
        if (executor != null) {
            this.f20033a = executor;
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public void a(Runnable runnable) {
        m.f(runnable, "runnable");
    }

    public void b(Runnable runnable) {
        m.f(runnable, "runnable");
        this.f20033a.execute(runnable);
    }
}
