package com.alibaba.pdns.pools;

public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    long f18177a;

    /* renamed from: b  reason: collision with root package name */
    public final Priority f18178b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f18179c;

    public c(Priority priority, Runnable runnable) {
        this.f18178b = priority == null ? Priority.DEFAULT : priority;
        this.f18179c = runnable;
    }

    public void run() {
        this.f18179c.run();
    }
}
