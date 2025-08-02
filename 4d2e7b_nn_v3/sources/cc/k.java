package cc;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.g;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.y;

public final class k extends y implements i0 {

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f78f = AtomicIntegerFieldUpdater.newUpdater(k.class, "runningWorkers");
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final y f79a;

    /* renamed from: b  reason: collision with root package name */
    private final int f80b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ i0 f81c;

    /* renamed from: d  reason: collision with root package name */
    private final p f82d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f83e;
    private volatile int runningWorkers;

    private final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Runnable f84a;

        public a(Runnable runnable) {
            this.f84a = runnable;
        }

        public void run() {
            int i10 = 0;
            while (true) {
                try {
                    this.f84a.run();
                } catch (Throwable th) {
                    a0.a(g.f679a, th);
                }
                Runnable H = k.this.I();
                if (H != null) {
                    this.f84a = H;
                    i10++;
                    if (i10 >= 16 && k.this.f79a.isDispatchNeeded(k.this)) {
                        k.this.f79a.dispatch(k.this, this);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public k(y yVar, int i10) {
        i0 i0Var;
        this.f79a = yVar;
        this.f80b = i10;
        if (yVar instanceof i0) {
            i0Var = (i0) yVar;
        } else {
            i0Var = null;
        }
        this.f81c = i0Var == null ? h0.a() : i0Var;
        this.f82d = new p(false);
        this.f83e = new Object();
    }

    /* access modifiers changed from: private */
    public final Runnable I() {
        while (true) {
            Runnable runnable = (Runnable) this.f82d.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f83e) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f78f;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f82d.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    private final boolean J() {
        synchronized (this.f83e) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f78f;
            if (atomicIntegerFieldUpdater.get(this) >= this.f80b) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable I;
        this.f82d.a(runnable);
        if (f78f.get(this) < this.f80b && J() && (I = I()) != null) {
            this.f79a.dispatch(this, new a(I));
        }
    }

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable I;
        this.f82d.a(runnable);
        if (f78f.get(this) < this.f80b && J() && (I = I()) != null) {
            this.f79a.dispatchYield(this, new a(I));
        }
    }

    public void j(long j10, CancellableContinuation cancellableContinuation) {
        this.f81c.j(j10, cancellableContinuation);
    }

    public y limitedParallelism(int i10) {
        l.a(i10);
        if (i10 >= this.f80b) {
            return this;
        }
        return super.limitedParallelism(i10);
    }

    public m0 w(long j10, Runnable runnable, CoroutineContext coroutineContext) {
        return this.f81c.w(j10, runnable, coroutineContext);
    }
}
