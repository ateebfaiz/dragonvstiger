package com.bumptech.glide.load.engine;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
    private static final EngineResourceFactory DEFAULT_FACTORY = new EngineResourceFactory();
    private final GlideExecutor animationExecutor;
    final ResourceCallbacksAndExecutors cbs;
    DataSource dataSource;
    private DecodeJob<R> decodeJob;
    private final GlideExecutor diskCacheExecutor;
    private final EngineJobListener engineJobListener;
    EngineResource<?> engineResource;
    private final EngineResourceFactory engineResourceFactory;
    GlideException exception;
    private boolean hasLoadFailed;
    private boolean hasResource;
    private boolean isCacheable;
    private volatile boolean isCancelled;
    private boolean isLoadedFromAlternateCacheKey;
    private Key key;
    private boolean onlyRetrieveFromCache;
    private final AtomicInteger pendingCallbacks;
    private final Pools.Pool<EngineJob<?>> pool;
    private Resource<?> resource;
    private final EngineResource.ResourceListener resourceListener;
    private final GlideExecutor sourceExecutor;
    private final GlideExecutor sourceUnlimitedExecutor;
    private final StateVerifier stateVerifier;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorPool;

    private class CallLoadFailed implements Runnable {

        /* renamed from: cb  reason: collision with root package name */
        private final ResourceCallback f19205cb;

        CallLoadFailed(ResourceCallback resourceCallback) {
            this.f19205cb = resourceCallback;
        }

        public void run() {
            synchronized (this.f19205cb.getLock()) {
                synchronized (EngineJob.this) {
                    try {
                        if (EngineJob.this.cbs.contains(this.f19205cb)) {
                            EngineJob.this.callCallbackOnLoadFailed(this.f19205cb);
                        }
                        EngineJob.this.decrementPendingCallbacks();
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
        }
    }

    private class CallResourceReady implements Runnable {

        /* renamed from: cb  reason: collision with root package name */
        private final ResourceCallback f19206cb;

        CallResourceReady(ResourceCallback resourceCallback) {
            this.f19206cb = resourceCallback;
        }

        public void run() {
            synchronized (this.f19206cb.getLock()) {
                synchronized (EngineJob.this) {
                    try {
                        if (EngineJob.this.cbs.contains(this.f19206cb)) {
                            EngineJob.this.engineResource.acquire();
                            EngineJob.this.callCallbackOnResourceReady(this.f19206cb);
                            EngineJob.this.removeCallback(this.f19206cb);
                        }
                        EngineJob.this.decrementPendingCallbacks();
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
        }
    }

    @VisibleForTesting
    static class EngineResourceFactory {
        EngineResourceFactory() {
        }

        public <R> EngineResource<R> build(Resource<R> resource, boolean z10, Key key, EngineResource.ResourceListener resourceListener) {
            return new EngineResource(resource, z10, true, key, resourceListener);
        }
    }

    static final class ResourceCallbackAndExecutor {

        /* renamed from: cb  reason: collision with root package name */
        final ResourceCallback f19207cb;
        final Executor executor;

        ResourceCallbackAndExecutor(ResourceCallback resourceCallback, Executor executor2) {
            this.f19207cb = resourceCallback;
            this.executor = executor2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ResourceCallbackAndExecutor) {
                return this.f19207cb.equals(((ResourceCallbackAndExecutor) obj).f19207cb);
            }
            return false;
        }

        public int hashCode() {
            return this.f19207cb.hashCode();
        }
    }

    static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {
        private final List<ResourceCallbackAndExecutor> callbacksAndExecutors;

        ResourceCallbacksAndExecutors() {
            this(new ArrayList(2));
        }

        private static ResourceCallbackAndExecutor defaultCallbackAndExecutor(ResourceCallback resourceCallback) {
            return new ResourceCallbackAndExecutor(resourceCallback, Executors.directExecutor());
        }

        /* access modifiers changed from: package-private */
        public void add(ResourceCallback resourceCallback, Executor executor) {
            this.callbacksAndExecutors.add(new ResourceCallbackAndExecutor(resourceCallback, executor));
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            this.callbacksAndExecutors.clear();
        }

        /* access modifiers changed from: package-private */
        public boolean contains(ResourceCallback resourceCallback) {
            return this.callbacksAndExecutors.contains(defaultCallbackAndExecutor(resourceCallback));
        }

        /* access modifiers changed from: package-private */
        public ResourceCallbacksAndExecutors copy() {
            return new ResourceCallbacksAndExecutors(new ArrayList(this.callbacksAndExecutors));
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.callbacksAndExecutors.isEmpty();
        }

        @NonNull
        public Iterator<ResourceCallbackAndExecutor> iterator() {
            return this.callbacksAndExecutors.iterator();
        }

        /* access modifiers changed from: package-private */
        public void remove(ResourceCallback resourceCallback) {
            this.callbacksAndExecutors.remove(defaultCallbackAndExecutor(resourceCallback));
        }

        /* access modifiers changed from: package-private */
        public int size() {
            return this.callbacksAndExecutors.size();
        }

        ResourceCallbacksAndExecutors(List<ResourceCallbackAndExecutor> list) {
            this.callbacksAndExecutors = list;
        }
    }

    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener2, EngineResource.ResourceListener resourceListener2, Pools.Pool<EngineJob<?>> pool2) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener2, resourceListener2, pool2, DEFAULT_FACTORY);
    }

    private GlideExecutor getActiveSourceExecutor() {
        if (this.useUnlimitedSourceGeneratorPool) {
            return this.sourceUnlimitedExecutor;
        }
        if (this.useAnimationPool) {
            return this.animationExecutor;
        }
        return this.sourceExecutor;
    }

    private boolean isDone() {
        if (this.hasLoadFailed || this.hasResource || this.isCancelled) {
            return true;
        }
        return false;
    }

    private synchronized void release() {
        if (this.key != null) {
            this.cbs.clear();
            this.key = null;
            this.engineResource = null;
            this.resource = null;
            this.hasLoadFailed = false;
            this.isCancelled = false;
            this.hasResource = false;
            this.isLoadedFromAlternateCacheKey = false;
            this.decodeJob.release(false);
            this.decodeJob = null;
            this.exception = null;
            this.dataSource = null;
            this.pool.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void addCallback(ResourceCallback resourceCallback, Executor executor) {
        try {
            this.stateVerifier.throwIfRecycled();
            this.cbs.add(resourceCallback, executor);
            if (this.hasResource) {
                incrementPendingCallbacks(1);
                executor.execute(new CallResourceReady(resourceCallback));
            } else if (this.hasLoadFailed) {
                incrementPendingCallbacks(1);
                executor.execute(new CallLoadFailed(resourceCallback));
            } else {
                Preconditions.checkArgument(!this.isCancelled, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @GuardedBy("this")
    public void callCallbackOnLoadFailed(ResourceCallback resourceCallback) {
        try {
            resourceCallback.onLoadFailed(this.exception);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* access modifiers changed from: package-private */
    @GuardedBy("this")
    public void callCallbackOnResourceReady(ResourceCallback resourceCallback) {
        try {
            resourceCallback.onResourceReady(this.engineResource, this.dataSource, this.isLoadedFromAlternateCacheKey);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        if (!isDone()) {
            this.isCancelled = true;
            this.decodeJob.cancel();
            this.engineJobListener.onEngineJobCancelled(this, this.key);
        }
    }

    /* access modifiers changed from: package-private */
    public void decrementPendingCallbacks() {
        boolean z10;
        EngineResource<?> engineResource2;
        synchronized (this) {
            try {
                this.stateVerifier.throwIfRecycled();
                Preconditions.checkArgument(isDone(), "Not yet complete!");
                int decrementAndGet = this.pendingCallbacks.decrementAndGet();
                if (decrementAndGet >= 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                Preconditions.checkArgument(z10, "Can't decrement below 0");
                if (decrementAndGet == 0) {
                    engineResource2 = this.engineResource;
                    release();
                } else {
                    engineResource2 = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (engineResource2 != null) {
            engineResource2.release();
        }
    }

    @NonNull
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    /* access modifiers changed from: package-private */
    public synchronized void incrementPendingCallbacks(int i10) {
        EngineResource<?> engineResource2;
        Preconditions.checkArgument(isDone(), "Not yet complete!");
        if (this.pendingCallbacks.getAndAdd(i10) == 0 && (engineResource2 = this.engineResource) != null) {
            engineResource2.acquire();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized EngineJob<R> init(Key key2, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.key = key2;
        this.isCacheable = z10;
        this.useUnlimitedSourceGeneratorPool = z11;
        this.useAnimationPool = z12;
        this.onlyRetrieveFromCache = z13;
        return this;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        r4.engineJobListener.onEngineJobComplete(r4, r1, (com.bumptech.glide.load.engine.EngineResource<?>) null);
        r0 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r0.hasNext() == false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        r1 = r0.next();
        r1.executor.execute(new com.bumptech.glide.load.engine.EngineJob.CallLoadFailed(r4, r1.f19207cb));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        decrementPendingCallbacks();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0057, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void notifyCallbacksOfException() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.bumptech.glide.util.pool.StateVerifier r0 = r4.stateVerifier     // Catch:{ all -> 0x000f }
            r0.throwIfRecycled()     // Catch:{ all -> 0x000f }
            boolean r0 = r4.isCancelled     // Catch:{ all -> 0x000f }
            if (r0 == 0) goto L_0x0011
            r4.release()     // Catch:{ all -> 0x000f }
            monitor-exit(r4)     // Catch:{ all -> 0x000f }
            return
        L_0x000f:
            r0 = move-exception
            goto L_0x0068
        L_0x0011:
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r0 = r4.cbs     // Catch:{ all -> 0x000f }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x000f }
            if (r0 != 0) goto L_0x0060
            boolean r0 = r4.hasLoadFailed     // Catch:{ all -> 0x000f }
            if (r0 != 0) goto L_0x0058
            r0 = 1
            r4.hasLoadFailed = r0     // Catch:{ all -> 0x000f }
            com.bumptech.glide.load.Key r1 = r4.key     // Catch:{ all -> 0x000f }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r2 = r4.cbs     // Catch:{ all -> 0x000f }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r2 = r2.copy()     // Catch:{ all -> 0x000f }
            int r3 = r2.size()     // Catch:{ all -> 0x000f }
            int r3 = r3 + r0
            r4.incrementPendingCallbacks(r3)     // Catch:{ all -> 0x000f }
            monitor-exit(r4)     // Catch:{ all -> 0x000f }
            com.bumptech.glide.load.engine.EngineJobListener r0 = r4.engineJobListener
            r3 = 0
            r0.onEngineJobComplete(r4, r1, r3)
            java.util.Iterator r0 = r2.iterator()
        L_0x003b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0054
            java.lang.Object r1 = r0.next()
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbackAndExecutor r1 = (com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor) r1
            java.util.concurrent.Executor r2 = r1.executor
            com.bumptech.glide.load.engine.EngineJob$CallLoadFailed r3 = new com.bumptech.glide.load.engine.EngineJob$CallLoadFailed
            com.bumptech.glide.request.ResourceCallback r1 = r1.f19207cb
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x003b
        L_0x0054:
            r4.decrementPendingCallbacks()
            return
        L_0x0058:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x000f }
            java.lang.String r1 = "Already failed once"
            r0.<init>(r1)     // Catch:{ all -> 0x000f }
            throw r0     // Catch:{ all -> 0x000f }
        L_0x0060:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x000f }
            java.lang.String r1 = "Received an exception without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x000f }
            throw r0     // Catch:{ all -> 0x000f }
        L_0x0068:
            monitor-exit(r4)     // Catch:{ all -> 0x000f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.EngineJob.notifyCallbacksOfException():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        r5.engineJobListener.onEngineJobComplete(r5, r0, r2);
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
        if (r0.hasNext() == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0057, code lost:
        r1 = r0.next();
        r1.executor.execute(new com.bumptech.glide.load.engine.EngineJob.CallResourceReady(r5, r1.f19207cb));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006a, code lost:
        decrementPendingCallbacks();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void notifyCallbacksOfResult() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.bumptech.glide.util.pool.StateVerifier r0 = r5.stateVerifier     // Catch:{ all -> 0x0014 }
            r0.throwIfRecycled()     // Catch:{ all -> 0x0014 }
            boolean r0 = r5.isCancelled     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x0016
            com.bumptech.glide.load.engine.Resource<?> r0 = r5.resource     // Catch:{ all -> 0x0014 }
            r0.recycle()     // Catch:{ all -> 0x0014 }
            r5.release()     // Catch:{ all -> 0x0014 }
            monitor-exit(r5)     // Catch:{ all -> 0x0014 }
            return
        L_0x0014:
            r0 = move-exception
            goto L_0x007e
        L_0x0016:
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r0 = r5.cbs     // Catch:{ all -> 0x0014 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x0076
            boolean r0 = r5.hasResource     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x006e
            com.bumptech.glide.load.engine.EngineJob$EngineResourceFactory r0 = r5.engineResourceFactory     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.Resource<?> r1 = r5.resource     // Catch:{ all -> 0x0014 }
            boolean r2 = r5.isCacheable     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.Key r3 = r5.key     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.EngineResource$ResourceListener r4 = r5.resourceListener     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.EngineResource r0 = r0.build(r1, r2, r3, r4)     // Catch:{ all -> 0x0014 }
            r5.engineResource = r0     // Catch:{ all -> 0x0014 }
            r0 = 1
            r5.hasResource = r0     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r1 = r5.cbs     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r1 = r1.copy()     // Catch:{ all -> 0x0014 }
            int r2 = r1.size()     // Catch:{ all -> 0x0014 }
            int r2 = r2 + r0
            r5.incrementPendingCallbacks(r2)     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.Key r0 = r5.key     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.EngineResource<?> r2 = r5.engineResource     // Catch:{ all -> 0x0014 }
            monitor-exit(r5)     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.EngineJobListener r3 = r5.engineJobListener
            r3.onEngineJobComplete(r5, r0, r2)
            java.util.Iterator r0 = r1.iterator()
        L_0x0051:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x006a
            java.lang.Object r1 = r0.next()
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbackAndExecutor r1 = (com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor) r1
            java.util.concurrent.Executor r2 = r1.executor
            com.bumptech.glide.load.engine.EngineJob$CallResourceReady r3 = new com.bumptech.glide.load.engine.EngineJob$CallResourceReady
            com.bumptech.glide.request.ResourceCallback r1 = r1.f19207cb
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x0051
        L_0x006a:
            r5.decrementPendingCallbacks()
            return
        L_0x006e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = "Already have resource"
            r0.<init>(r1)     // Catch:{ all -> 0x0014 }
            throw r0     // Catch:{ all -> 0x0014 }
        L_0x0076:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = "Received a resource without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x0014 }
            throw r0     // Catch:{ all -> 0x0014 }
        L_0x007e:
            monitor-exit(r5)     // Catch:{ all -> 0x0014 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.EngineJob.notifyCallbacksOfResult():void");
    }

    public void onLoadFailed(GlideException glideException) {
        synchronized (this) {
            this.exception = glideException;
        }
        notifyCallbacksOfException();
    }

    public void onResourceReady(Resource<R> resource2, DataSource dataSource2, boolean z10) {
        synchronized (this) {
            this.resource = resource2;
            this.dataSource = dataSource2;
            this.isLoadedFromAlternateCacheKey = z10;
        }
        notifyCallbacksOfResult();
    }

    /* access modifiers changed from: package-private */
    public boolean onlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    /* access modifiers changed from: package-private */
    public synchronized void removeCallback(ResourceCallback resourceCallback) {
        try {
            this.stateVerifier.throwIfRecycled();
            this.cbs.remove(resourceCallback);
            if (this.cbs.isEmpty()) {
                cancel();
                if (!this.hasResource) {
                    if (this.hasLoadFailed) {
                    }
                }
                if (this.pendingCallbacks.get() == 0) {
                    release();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void reschedule(DecodeJob<?> decodeJob2) {
        getActiveSourceExecutor().execute(decodeJob2);
    }

    public synchronized void start(DecodeJob<R> decodeJob2) {
        GlideExecutor glideExecutor;
        try {
            this.decodeJob = decodeJob2;
            if (decodeJob2.willDecodeFromCache()) {
                glideExecutor = this.diskCacheExecutor;
            } else {
                glideExecutor = getActiveSourceExecutor();
            }
            glideExecutor.execute(decodeJob2);
        } catch (Throwable th) {
            throw th;
        }
    }

    @VisibleForTesting
    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener2, EngineResource.ResourceListener resourceListener2, Pools.Pool<EngineJob<?>> pool2, EngineResourceFactory engineResourceFactory2) {
        this.cbs = new ResourceCallbacksAndExecutors();
        this.stateVerifier = StateVerifier.newInstance();
        this.pendingCallbacks = new AtomicInteger();
        this.diskCacheExecutor = glideExecutor;
        this.sourceExecutor = glideExecutor2;
        this.sourceUnlimitedExecutor = glideExecutor3;
        this.animationExecutor = glideExecutor4;
        this.engineJobListener = engineJobListener2;
        this.resourceListener = resourceListener2;
        this.pool = pool2;
        this.engineResourceFactory = engineResourceFactory2;
    }
}
