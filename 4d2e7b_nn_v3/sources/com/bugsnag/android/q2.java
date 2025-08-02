package com.bugsnag.android;

import c1.j;
import c1.q;
import com.bugsnag.android.v3;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class q2 extends n {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f18941a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f18942b;

    /* renamed from: c  reason: collision with root package name */
    private final s2 f18943c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q2(j jVar, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(jVar, (i10 & 2) != 0 ? new ScheduledThreadPoolExecutor(1) : scheduledThreadPoolExecutor);
    }

    /* access modifiers changed from: private */
    public static final void c(q2 q2Var) {
        q2Var.e();
    }

    public final boolean d() {
        return this.f18942b.get();
    }

    public final void e() {
        this.f18941a.shutdown();
        this.f18942b.set(false);
        if (!getObservers$bugsnag_android_core_release().isEmpty()) {
            v3.p pVar = new v3.p(false);
            for (q onStateChange : getObservers$bugsnag_android_core_release()) {
                onStateChange.onStateChange(pVar);
            }
        }
        this.f18943c.d("App launch period marked as complete");
    }

    public q2(j jVar, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f18941a = scheduledThreadPoolExecutor;
        this.f18942b = new AtomicBoolean(true);
        this.f18943c = jVar.r();
        long q10 = jVar.q();
        if (q10 > 0) {
            scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            try {
                scheduledThreadPoolExecutor.schedule(new p2(this), q10, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e10) {
                this.f18943c.c("Failed to schedule timer for LaunchCrashTracker", e10);
            }
        }
    }
}
