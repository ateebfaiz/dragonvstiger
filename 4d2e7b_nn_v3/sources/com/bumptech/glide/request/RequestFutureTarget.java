package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {
    private static final Waiter DEFAULT_WAITER = new Waiter();
    private final boolean assertBackgroundThread;
    @GuardedBy("this")
    @Nullable
    private GlideException exception;
    private final int height;
    @GuardedBy("this")
    private boolean isCancelled;
    @GuardedBy("this")
    private boolean loadFailed;
    @GuardedBy("this")
    @Nullable
    private Request request;
    @GuardedBy("this")
    @Nullable
    private R resource;
    @GuardedBy("this")
    private boolean resultReceived;
    private final Waiter waiter;
    private final int width;

    @VisibleForTesting
    static class Waiter {
        Waiter() {
        }

        /* access modifiers changed from: package-private */
        public void notifyAll(Object obj) {
            obj.notifyAll();
        }

        /* access modifiers changed from: package-private */
        public void waitForTimeout(Object obj, long j10) throws InterruptedException {
            obj.wait(j10);
        }
    }

    public RequestFutureTarget(int i10, int i11) {
        this(i10, i11, true, DEFAULT_WAITER);
    }

    private synchronized R doGet(Long l10) throws ExecutionException, InterruptedException, TimeoutException {
        try {
            if (this.assertBackgroundThread && !isDone()) {
                Util.assertBackgroundThread();
            }
            if (this.isCancelled) {
                throw new CancellationException();
            } else if (this.loadFailed) {
                throw new ExecutionException(this.exception);
            } else if (this.resultReceived) {
                return this.resource;
            } else {
                if (l10 == null) {
                    this.waiter.waitForTimeout(this, 0);
                } else if (l10.longValue() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long longValue = l10.longValue() + currentTimeMillis;
                    while (!isDone() && currentTimeMillis < longValue) {
                        this.waiter.waitForTimeout(this, longValue - currentTimeMillis);
                        currentTimeMillis = System.currentTimeMillis();
                    }
                }
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                } else if (this.loadFailed) {
                    throw new ExecutionException(this.exception);
                } else if (this.isCancelled) {
                    throw new CancellationException();
                } else if (this.resultReceived) {
                    return this.resource;
                } else {
                    throw new TimeoutException();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        if (r1 == null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        r1.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isDone()     // Catch:{ all -> 0x000a }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r2)     // Catch:{ all -> 0x000a }
            r3 = 0
            return r3
        L_0x000a:
            r3 = move-exception
            goto L_0x0023
        L_0x000c:
            r0 = 1
            r2.isCancelled = r0     // Catch:{ all -> 0x000a }
            com.bumptech.glide.request.RequestFutureTarget$Waiter r1 = r2.waiter     // Catch:{ all -> 0x000a }
            r1.notifyAll(r2)     // Catch:{ all -> 0x000a }
            r1 = 0
            if (r3 == 0) goto L_0x001c
            com.bumptech.glide.request.Request r3 = r2.request     // Catch:{ all -> 0x000a }
            r2.request = r1     // Catch:{ all -> 0x000a }
            r1 = r3
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x000a }
            if (r1 == 0) goto L_0x0022
            r1.clear()
        L_0x0022:
            return r0
        L_0x0023:
            monitor-exit(r2)     // Catch:{ all -> 0x000a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.RequestFutureTarget.cancel(boolean):boolean");
    }

    public R get() throws InterruptedException, ExecutionException {
        try {
            return doGet((Long) null);
        } catch (TimeoutException e10) {
            throw new AssertionError(e10);
        }
    }

    @Nullable
    public synchronized Request getRequest() {
        return this.request;
    }

    public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }

    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    public synchronized boolean isDone() {
        boolean z10;
        if (this.isCancelled || this.resultReceived || this.loadFailed) {
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }

    public void onDestroy() {
    }

    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    public synchronized void onLoadFailed(@Nullable Drawable drawable) {
    }

    public void onLoadStarted(@Nullable Drawable drawable) {
    }

    public synchronized void onResourceReady(@NonNull R r10, @Nullable Transition<? super R> transition) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    public synchronized void setRequest(@Nullable Request request2) {
        this.request = request2;
    }

    public String toString() {
        Request request2;
        String str;
        String str2 = super.toString() + "[status=";
        synchronized (this) {
            try {
                request2 = null;
                if (this.isCancelled) {
                    str = "CANCELLED";
                } else if (this.loadFailed) {
                    str = "FAILURE";
                } else if (this.resultReceived) {
                    str = "SUCCESS";
                } else {
                    str = "PENDING";
                    request2 = this.request;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (request2 != null) {
            return str2 + str + ", request=[" + request2 + "]]";
        }
        return str2 + str + "]";
    }

    RequestFutureTarget(int i10, int i11, boolean z10, Waiter waiter2) {
        this.width = i10;
        this.height = i11;
        this.assertBackgroundThread = z10;
        this.waiter = waiter2;
    }

    public synchronized boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<R> target, boolean z10) {
        this.loadFailed = true;
        this.exception = glideException;
        this.waiter.notifyAll(this);
        return false;
    }

    public synchronized boolean onResourceReady(R r10, Object obj, Target<R> target, DataSource dataSource, boolean z10) {
        this.resultReceived = true;
        this.resource = r10;
        this.waiter.notifyAll(this);
        return false;
    }

    public R get(long j10, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return doGet(Long.valueOf(timeUnit.toMillis(j10)));
    }
}
