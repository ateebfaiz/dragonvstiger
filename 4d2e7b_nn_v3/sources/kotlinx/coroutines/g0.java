package kotlinx.coroutines;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import kotlinx.coroutines.r0;

public final class g0 extends r0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: g  reason: collision with root package name */
    public static final g0 f1085g;

    /* renamed from: h  reason: collision with root package name */
    private static final long f1086h;

    static {
        Long l10;
        g0 g0Var = new g0();
        f1085g = g0Var;
        q0.L(g0Var, false, 1, (Object) null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f1086h = timeUnit.toNanos(l10.longValue());
    }

    private g0() {
    }

    private final synchronized void h0() {
        if (k0()) {
            debugStatus = 3;
            b0();
            m.d(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    private final synchronized Thread i0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean j0() {
        if (debugStatus == 4) {
            return true;
        }
        return false;
    }

    private final boolean k0() {
        int i10 = debugStatus;
        if (i10 == 2 || i10 == 3) {
            return true;
        }
        return false;
    }

    private final synchronized boolean l0() {
        if (k0()) {
            return false;
        }
        debugStatus = 1;
        m.d(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    private final void m0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    /* access modifiers changed from: protected */
    public Thread P() {
        Thread thread = _thread;
        if (thread == null) {
            return i0();
        }
        return thread;
    }

    /* access modifiers changed from: protected */
    public void Q(long j10, r0.c cVar) {
        m0();
    }

    public void V(Runnable runnable) {
        if (j0()) {
            m0();
        }
        super.V(runnable);
    }

    public void run() {
        w1.f1199a.c(this);
        b.a();
        try {
            if (l0()) {
                long j10 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long Z = Z();
                    if (Z == LocationRequestCompat.PASSIVE_INTERVAL) {
                        b.a();
                        long nanoTime = System.nanoTime();
                        if (j10 == LocationRequestCompat.PASSIVE_INTERVAL) {
                            j10 = f1086h + nanoTime;
                        }
                        long j11 = j10 - nanoTime;
                        if (j11 <= 0) {
                            _thread = null;
                            h0();
                            b.a();
                            if (!Y()) {
                                P();
                                return;
                            }
                            return;
                        }
                        Z = l.g(Z, j11);
                    } else {
                        j10 = Long.MAX_VALUE;
                    }
                    if (Z > 0) {
                        if (k0()) {
                            _thread = null;
                            h0();
                            b.a();
                            if (!Y()) {
                                P();
                                return;
                            }
                            return;
                        }
                        b.a();
                        LockSupport.parkNanos(this, Z);
                    }
                }
            }
        } finally {
            _thread = null;
            h0();
            b.a();
            if (!Y()) {
                P();
            }
        }
    }

    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    public m0 w(long j10, Runnable runnable, CoroutineContext coroutineContext) {
        return e0(j10, runnable);
    }
}
