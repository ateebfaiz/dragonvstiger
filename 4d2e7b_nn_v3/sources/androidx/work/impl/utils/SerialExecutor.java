package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class SerialExecutor implements Executor {
    private volatile Runnable mActive;
    private final Executor mExecutor;
    private final Object mLock = new Object();
    private final ArrayDeque<a> mTasks = new ArrayDeque<>();

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final SerialExecutor f17068a;

        /* renamed from: b  reason: collision with root package name */
        final Runnable f17069b;

        a(SerialExecutor serialExecutor, Runnable runnable) {
            this.f17068a = serialExecutor;
            this.f17069b = runnable;
        }

        public void run() {
            try {
                this.f17069b.run();
            } finally {
                this.f17068a.scheduleNext();
            }
        }
    }

    public SerialExecutor(@NonNull Executor executor) {
        this.mExecutor = executor;
    }

    public void execute(@NonNull Runnable runnable) {
        synchronized (this.mLock) {
            try {
                this.mTasks.add(new a(this, runnable));
                if (this.mActive == null) {
                    scheduleNext();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    @NonNull
    public Executor getDelegatedExecutor() {
        return this.mExecutor;
    }

    public boolean hasPendingTasks() {
        boolean z10;
        synchronized (this.mLock) {
            z10 = !this.mTasks.isEmpty();
        }
        return z10;
    }

    /* access modifiers changed from: package-private */
    public void scheduleNext() {
        synchronized (this.mLock) {
            try {
                Runnable poll = this.mTasks.poll();
                this.mActive = poll;
                if (poll != null) {
                    this.mExecutor.execute(this.mActive);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
