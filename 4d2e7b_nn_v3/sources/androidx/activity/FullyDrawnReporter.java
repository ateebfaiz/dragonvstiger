package androidx.activity;

import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;

public final class FullyDrawnReporter {
    private final Executor executor;
    private final Object lock = new Object();
    @GuardedBy("lock")
    private final List<Function0<Unit>> onReportCallbacks = new ArrayList();
    private final Function0<Unit> reportFullyDrawn;
    @GuardedBy("lock")
    private boolean reportPosted;
    private final Runnable reportRunnable = new y(this);
    @GuardedBy("lock")
    private boolean reportedFullyDrawn;
    @GuardedBy("lock")
    private int reporterCount;

    public FullyDrawnReporter(Executor executor2, Function0<Unit> function0) {
        m.f(executor2, "executor");
        m.f(function0, "reportFullyDrawn");
        this.executor = executor2;
        this.reportFullyDrawn = function0;
    }

    private final void postWhenReportersAreDone() {
        if (!this.reportPosted && this.reporterCount == 0) {
            this.reportPosted = true;
            this.executor.execute(this.reportRunnable);
        }
    }

    /* access modifiers changed from: private */
    public static final void reportRunnable$lambda$2(FullyDrawnReporter fullyDrawnReporter) {
        m.f(fullyDrawnReporter, "this$0");
        synchronized (fullyDrawnReporter.lock) {
            try {
                fullyDrawnReporter.reportPosted = false;
                if (fullyDrawnReporter.reporterCount == 0 && !fullyDrawnReporter.reportedFullyDrawn) {
                    fullyDrawnReporter.reportFullyDrawn.invoke();
                    fullyDrawnReporter.fullyDrawnReported();
                }
                Unit unit = Unit.f12577a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void addOnReportDrawnListener(Function0<Unit> function0) {
        boolean z10;
        m.f(function0, "callback");
        synchronized (this.lock) {
            if (this.reportedFullyDrawn) {
                z10 = true;
            } else {
                this.onReportCallbacks.add(function0);
                z10 = false;
            }
        }
        if (z10) {
            function0.invoke();
        }
    }

    public final void addReporter() {
        synchronized (this.lock) {
            try {
                if (!this.reportedFullyDrawn) {
                    this.reporterCount++;
                }
                Unit unit = Unit.f12577a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void fullyDrawnReported() {
        synchronized (this.lock) {
            try {
                this.reportedFullyDrawn = true;
                for (Function0 invoke : this.onReportCallbacks) {
                    invoke.invoke();
                }
                this.onReportCallbacks.clear();
                Unit unit = Unit.f12577a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isFullyDrawnReported() {
        boolean z10;
        synchronized (this.lock) {
            z10 = this.reportedFullyDrawn;
        }
        return z10;
    }

    public final void removeOnReportDrawnListener(Function0<Unit> function0) {
        m.f(function0, "callback");
        synchronized (this.lock) {
            this.onReportCallbacks.remove(function0);
            Unit unit = Unit.f12577a;
        }
    }

    public final void removeReporter() {
        int i10;
        synchronized (this.lock) {
            try {
                if (!this.reportedFullyDrawn && (i10 = this.reporterCount) > 0) {
                    this.reporterCount = i10 - 1;
                    postWhenReportersAreDone();
                }
                Unit unit = Unit.f12577a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
