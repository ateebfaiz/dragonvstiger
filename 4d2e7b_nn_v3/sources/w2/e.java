package w2;

import android.os.Handler;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class e extends AbstractExecutorService implements ScheduledExecutorService {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f24498a;

    public e(Handler handler) {
        this.f24498a = handler;
    }

    public boolean a() {
        if (Thread.currentThread() == this.f24498a.getLooper().getThread()) {
            return true;
        }
        return false;
    }

    public boolean awaitTermination(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public f newTaskFor(Runnable runnable, Object obj) {
        return new f(this.f24498a, runnable, obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public f newTaskFor(Callable callable) {
        return new f(this.f24498a, callable);
    }

    /* renamed from: d */
    public ScheduledFuture submit(Runnable runnable) {
        return submit(runnable, (Object) null);
    }

    /* renamed from: e */
    public ScheduledFuture submit(Runnable runnable, Object obj) {
        runnable.getClass();
        f b10 = newTaskFor(runnable, obj);
        execute(b10);
        return b10;
    }

    public void execute(Runnable runnable) {
        this.f24498a.post(runnable);
    }

    /* renamed from: f */
    public ScheduledFuture submit(Callable callable) {
        callable.getClass();
        f c10 = newTaskFor(callable);
        execute(c10);
        return c10;
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public ScheduledFuture schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        f b10 = newTaskFor(runnable, (Object) null);
        this.f24498a.postDelayed(b10, timeUnit.toMillis(j10));
        return b10;
    }

    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    public List shutdownNow() {
        throw new UnsupportedOperationException();
    }

    public ScheduledFuture schedule(Callable callable, long j10, TimeUnit timeUnit) {
        f c10 = newTaskFor(callable);
        this.f24498a.postDelayed(c10, timeUnit.toMillis(j10));
        return c10;
    }
}
