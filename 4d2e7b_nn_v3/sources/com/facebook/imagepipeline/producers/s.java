package com.facebook.imagepipeline.producers;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import k5.b;
import kotlin.jvm.internal.m;

public final class s implements d1 {

    /* renamed from: a  reason: collision with root package name */
    private final d1 f20237a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f20238b;

    public s(d1 d1Var, ScheduledExecutorService scheduledExecutorService) {
        m.f(d1Var, "inputProducer");
        this.f20237a = d1Var;
        this.f20238b = scheduledExecutorService;
    }

    /* access modifiers changed from: private */
    public static final void d(s sVar, n nVar, e1 e1Var) {
        m.f(sVar, "this$0");
        m.f(nVar, "$consumer");
        m.f(e1Var, "$context");
        sVar.f20237a.b(nVar, e1Var);
    }

    public void b(n nVar, e1 e1Var) {
        m.f(nVar, "consumer");
        m.f(e1Var, "context");
        b b10 = e1Var.b();
        ScheduledExecutorService scheduledExecutorService = this.f20238b;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.schedule(new r(this, nVar, e1Var), (long) b10.e(), TimeUnit.MILLISECONDS);
        } else {
            this.f20237a.b(nVar, e1Var);
        }
    }
}
