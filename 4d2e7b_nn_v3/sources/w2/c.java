package w2;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class c extends AbstractExecutorService {
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final Class f24489h = c.class;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f24490a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f24491b;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f24492c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final BlockingQueue f24493d;

    /* renamed from: e  reason: collision with root package name */
    private final a f24494e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f24495f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicInteger f24496g;

    private class a implements Runnable {
        public void run() {
            AtomicInteger b10;
            boolean isEmpty;
            try {
                Runnable runnable = (Runnable) c.this.f24493d.poll();
                if (runnable != null) {
                    runnable.run();
                } else {
                    z2.a.w(c.f24489h, "%s: Worker has nothing to run", c.this.f24490a);
                }
                if (isEmpty) {
                    z2.a.x(c.f24489h, "%s: worker finished; %d workers left", c.this.f24490a, Integer.valueOf(b10.decrementAndGet()));
                }
            } finally {
                int decrementAndGet = c.this.f24495f.decrementAndGet();
                if (!c.this.f24493d.isEmpty()) {
                    c.this.f();
                } else {
                    z2.a.x(c.f24489h, "%s: worker finished; %d workers left", c.this.f24490a, Integer.valueOf(decrementAndGet));
                }
            }
        }

        private a() {
        }
    }

    public c(String str, int i10, Executor executor, BlockingQueue blockingQueue) {
        if (i10 > 0) {
            this.f24490a = str;
            this.f24491b = executor;
            this.f24492c = i10;
            this.f24493d = blockingQueue;
            this.f24494e = new a();
            this.f24495f = new AtomicInteger(0);
            this.f24496g = new AtomicInteger(0);
            return;
        }
        throw new IllegalArgumentException("max concurrency must be > 0");
    }

    /* access modifiers changed from: private */
    public void f() {
        int i10 = this.f24495f.get();
        while (i10 < this.f24492c) {
            int i11 = i10 + 1;
            if (this.f24495f.compareAndSet(i10, i11)) {
                z2.a.y(f24489h, "%s: starting worker %d of %d", this.f24490a, Integer.valueOf(i11), Integer.valueOf(this.f24492c));
                this.f24491b.execute(this.f24494e);
                return;
            }
            z2.a.w(f24489h, "%s: race in startWorkerIfNeeded; retrying", this.f24490a);
            i10 = this.f24495f.get();
        }
    }

    public boolean awaitTermination(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        } else if (this.f24493d.offer(runnable)) {
            int size = this.f24493d.size();
            int i10 = this.f24496g.get();
            if (size > i10 && this.f24496g.compareAndSet(i10, size)) {
                z2.a.x(f24489h, "%s: max pending work in queue = %d", this.f24490a, Integer.valueOf(size));
            }
            f();
        } else {
            throw new RejectedExecutionException(this.f24490a + " queue is full, size=" + this.f24493d.size());
        }
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    public List shutdownNow() {
        throw new UnsupportedOperationException();
    }
}
