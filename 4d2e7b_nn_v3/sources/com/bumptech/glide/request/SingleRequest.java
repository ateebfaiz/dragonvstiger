package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.List;
import java.util.concurrent.Executor;

public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    private static final String GLIDE_TAG = "Glide";
    private static final boolean IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);
    private static final String TAG = "GlideRequest";
    private final TransitionFactory<? super R> animationFactory;
    private final Executor callbackExecutor;
    private final Context context;
    private int cookie;
    private volatile Engine engine;
    @GuardedBy("requestLock")
    @Nullable
    private Drawable errorDrawable;
    @GuardedBy("requestLock")
    @Nullable
    private Drawable fallbackDrawable;
    private final GlideContext glideContext;
    @GuardedBy("requestLock")
    private int height;
    @GuardedBy("requestLock")
    private boolean isCallingCallbacks;
    @GuardedBy("requestLock")
    private Engine.LoadStatus loadStatus;
    @Nullable
    private final Object model;
    private final int overrideHeight;
    private final int overrideWidth;
    @GuardedBy("requestLock")
    @Nullable
    private Drawable placeholderDrawable;
    private final Priority priority;
    private final RequestCoordinator requestCoordinator;
    @Nullable
    private final List<RequestListener<R>> requestListeners;
    private final Object requestLock;
    private final BaseRequestOptions<?> requestOptions;
    @Nullable
    private RuntimeException requestOrigin;
    @GuardedBy("requestLock")
    private Resource<R> resource;
    @GuardedBy("requestLock")
    private long startTime;
    private final StateVerifier stateVerifier;
    @GuardedBy("requestLock")
    private Status status;
    @Nullable
    private final String tag;
    private final Target<R> target;
    @Nullable
    private final RequestListener<R> targetListener;
    private final Class<R> transcodeClass;
    @GuardedBy("requestLock")
    private int width;

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private SingleRequest(Context context2, GlideContext glideContext2, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i10, int i11, Priority priority2, Target<R> target2, @Nullable RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator2, Engine engine2, TransitionFactory<? super R> transitionFactory, Executor executor) {
        this.tag = IS_VERBOSE_LOGGABLE ? String.valueOf(super.hashCode()) : null;
        this.stateVerifier = StateVerifier.newInstance();
        this.requestLock = obj;
        this.context = context2;
        this.glideContext = glideContext2;
        this.model = obj2;
        this.transcodeClass = cls;
        this.requestOptions = baseRequestOptions;
        this.overrideWidth = i10;
        this.overrideHeight = i11;
        this.priority = priority2;
        this.target = target2;
        this.targetListener = requestListener;
        this.requestListeners = list;
        this.requestCoordinator = requestCoordinator2;
        this.engine = engine2;
        this.animationFactory = transitionFactory;
        this.callbackExecutor = executor;
        this.status = Status.PENDING;
        if (this.requestOrigin == null && glideContext2.getExperiments().isEnabled(GlideBuilder.LogRequestOrigins.class)) {
            this.requestOrigin = new RuntimeException("Glide request origin trace");
        }
    }

    @GuardedBy("requestLock")
    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @GuardedBy("requestLock")
    private boolean canNotifyCleared() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 == null || requestCoordinator2.canNotifyCleared(this)) {
            return true;
        }
        return false;
    }

    @GuardedBy("requestLock")
    private boolean canNotifyStatusChanged() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 == null || requestCoordinator2.canNotifyStatusChanged(this)) {
            return true;
        }
        return false;
    }

    @GuardedBy("requestLock")
    private boolean canSetResource() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 == null || requestCoordinator2.canSetImage(this)) {
            return true;
        }
        return false;
    }

    @GuardedBy("requestLock")
    private void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        Engine.LoadStatus loadStatus2 = this.loadStatus;
        if (loadStatus2 != null) {
            loadStatus2.cancel();
            this.loadStatus = null;
        }
    }

    private void experimentalNotifyRequestStarted(Object obj) {
        List<RequestListener<R>> list = this.requestListeners;
        if (list != null) {
            for (RequestListener next : list) {
                if (next instanceof ExperimentalRequestListener) {
                    ((ExperimentalRequestListener) next).onRequestStarted(obj);
                }
            }
        }
    }

    @GuardedBy("requestLock")
    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            Drawable errorPlaceholder = this.requestOptions.getErrorPlaceholder();
            this.errorDrawable = errorPlaceholder;
            if (errorPlaceholder == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    @GuardedBy("requestLock")
    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            Drawable fallbackDrawable2 = this.requestOptions.getFallbackDrawable();
            this.fallbackDrawable = fallbackDrawable2;
            if (fallbackDrawable2 == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    @GuardedBy("requestLock")
    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            Drawable placeholderDrawable2 = this.requestOptions.getPlaceholderDrawable();
            this.placeholderDrawable = placeholderDrawable2;
            if (placeholderDrawable2 == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    @GuardedBy("requestLock")
    private boolean isFirstReadyResource() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 == null || !requestCoordinator2.getRoot().isAnyResourceSet()) {
            return true;
        }
        return false;
    }

    @GuardedBy("requestLock")
    private Drawable loadDrawable(@DrawableRes int i10) {
        Resources.Theme theme;
        if (this.requestOptions.getTheme() != null) {
            theme = this.requestOptions.getTheme();
        } else {
            theme = this.context.getTheme();
        }
        return DrawableDecoderCompat.getDrawable(this.context, i10, theme);
    }

    private void logV(String str) {
        Log.v(TAG, str + " this: " + this.tag);
    }

    private static int maybeApplySizeMultiplier(int i10, float f10) {
        if (i10 == Integer.MIN_VALUE) {
            return i10;
        }
        return Math.round(f10 * ((float) i10));
    }

    @GuardedBy("requestLock")
    private void notifyRequestCoordinatorLoadFailed() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 != null) {
            requestCoordinator2.onRequestFailed(this);
        }
    }

    @GuardedBy("requestLock")
    private void notifyRequestCoordinatorLoadSucceeded() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 != null) {
            requestCoordinator2.onRequestSuccess(this);
        }
    }

    public static <R> SingleRequest<R> obtain(Context context2, GlideContext glideContext2, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i10, int i11, Priority priority2, Target<R> target2, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator2, Engine engine2, TransitionFactory<? super R> transitionFactory, Executor executor) {
        return new SingleRequest(context2, glideContext2, obj, obj2, cls, baseRequestOptions, i10, i11, priority2, target2, requestListener, list, requestCoordinator2, engine2, transitionFactory, executor);
    }

    @GuardedBy("requestLock")
    private void setErrorPlaceholder() {
        Drawable drawable;
        if (canNotifyStatusChanged()) {
            if (this.model == null) {
                drawable = getFallbackDrawable();
            } else {
                drawable = null;
            }
            if (drawable == null) {
                drawable = getErrorDrawable();
            }
            if (drawable == null) {
                drawable = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(drawable);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ae, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void begin() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.requestLock
            monitor-enter(r0)
            r5.assertNotCallingCallbacks()     // Catch:{ all -> 0x0028 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r5.stateVerifier     // Catch:{ all -> 0x0028 }
            r1.throwIfRecycled()     // Catch:{ all -> 0x0028 }
            long r1 = com.bumptech.glide.util.LogTime.getLogTime()     // Catch:{ all -> 0x0028 }
            r5.startTime = r1     // Catch:{ all -> 0x0028 }
            java.lang.Object r1 = r5.model     // Catch:{ all -> 0x0028 }
            if (r1 != 0) goto L_0x0040
            int r1 = r5.overrideWidth     // Catch:{ all -> 0x0028 }
            int r2 = r5.overrideHeight     // Catch:{ all -> 0x0028 }
            boolean r1 = com.bumptech.glide.util.Util.isValidDimensions(r1, r2)     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x002b
            int r1 = r5.overrideWidth     // Catch:{ all -> 0x0028 }
            r5.width = r1     // Catch:{ all -> 0x0028 }
            int r1 = r5.overrideHeight     // Catch:{ all -> 0x0028 }
            r5.height = r1     // Catch:{ all -> 0x0028 }
            goto L_0x002b
        L_0x0028:
            r1 = move-exception
            goto L_0x00b7
        L_0x002b:
            android.graphics.drawable.Drawable r1 = r5.getFallbackDrawable()     // Catch:{ all -> 0x0028 }
            if (r1 != 0) goto L_0x0033
            r1 = 5
            goto L_0x0034
        L_0x0033:
            r1 = 3
        L_0x0034:
            com.bumptech.glide.load.engine.GlideException r2 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x0028 }
            java.lang.String r3 = "Received null model"
            r2.<init>(r3)     // Catch:{ all -> 0x0028 }
            r5.onLoadFailed(r2, r1)     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0040:
            com.bumptech.glide.request.SingleRequest$Status r2 = r5.status     // Catch:{ all -> 0x0028 }
            com.bumptech.glide.request.SingleRequest$Status r3 = com.bumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x0028 }
            if (r2 == r3) goto L_0x00af
            com.bumptech.glide.request.SingleRequest$Status r4 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch:{ all -> 0x0028 }
            if (r2 != r4) goto L_0x0054
            com.bumptech.glide.load.engine.Resource<R> r1 = r5.resource     // Catch:{ all -> 0x0028 }
            com.bumptech.glide.load.DataSource r2 = com.bumptech.glide.load.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x0028 }
            r3 = 0
            r5.onResourceReady(r1, r2, r3)     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0054:
            r5.experimentalNotifyRequestStarted(r1)     // Catch:{ all -> 0x0028 }
            java.lang.String r1 = "GlideRequest"
            int r1 = com.bumptech.glide.util.pool.GlideTrace.beginSectionAsync(r1)     // Catch:{ all -> 0x0028 }
            r5.cookie = r1     // Catch:{ all -> 0x0028 }
            com.bumptech.glide.request.SingleRequest$Status r1 = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x0028 }
            r5.status = r1     // Catch:{ all -> 0x0028 }
            int r2 = r5.overrideWidth     // Catch:{ all -> 0x0028 }
            int r4 = r5.overrideHeight     // Catch:{ all -> 0x0028 }
            boolean r2 = com.bumptech.glide.util.Util.isValidDimensions(r2, r4)     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x0075
            int r2 = r5.overrideWidth     // Catch:{ all -> 0x0028 }
            int r4 = r5.overrideHeight     // Catch:{ all -> 0x0028 }
            r5.onSizeReady(r2, r4)     // Catch:{ all -> 0x0028 }
            goto L_0x007a
        L_0x0075:
            com.bumptech.glide.request.target.Target<R> r2 = r5.target     // Catch:{ all -> 0x0028 }
            r2.getSize(r5)     // Catch:{ all -> 0x0028 }
        L_0x007a:
            com.bumptech.glide.request.SingleRequest$Status r2 = r5.status     // Catch:{ all -> 0x0028 }
            if (r2 == r3) goto L_0x0080
            if (r2 != r1) goto L_0x008f
        L_0x0080:
            boolean r1 = r5.canNotifyStatusChanged()     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x008f
            com.bumptech.glide.request.target.Target<R> r1 = r5.target     // Catch:{ all -> 0x0028 }
            android.graphics.drawable.Drawable r2 = r5.getPlaceholderDrawable()     // Catch:{ all -> 0x0028 }
            r1.onLoadStarted(r2)     // Catch:{ all -> 0x0028 }
        L_0x008f:
            boolean r1 = IS_VERBOSE_LOGGABLE     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x00ad
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0028 }
            r1.<init>()     // Catch:{ all -> 0x0028 }
            java.lang.String r2 = "finished run method in "
            r1.append(r2)     // Catch:{ all -> 0x0028 }
            long r2 = r5.startTime     // Catch:{ all -> 0x0028 }
            double r2 = com.bumptech.glide.util.LogTime.getElapsedMillis(r2)     // Catch:{ all -> 0x0028 }
            r1.append(r2)     // Catch:{ all -> 0x0028 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0028 }
            r5.logV(r1)     // Catch:{ all -> 0x0028 }
        L_0x00ad:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x00af:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0028 }
            java.lang.String r2 = "Cannot restart a running request"
            r1.<init>(r2)     // Catch:{ all -> 0x0028 }
            throw r1     // Catch:{ all -> 0x0028 }
        L_0x00b7:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.begin():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        r5.engine.release(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.requestLock
            monitor-enter(r0)
            r5.assertNotCallingCallbacks()     // Catch:{ all -> 0x0013 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r5.stateVerifier     // Catch:{ all -> 0x0013 }
            r1.throwIfRecycled()     // Catch:{ all -> 0x0013 }
            com.bumptech.glide.request.SingleRequest$Status r1 = r5.status     // Catch:{ all -> 0x0013 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.CLEARED     // Catch:{ all -> 0x0013 }
            if (r1 != r2) goto L_0x0015
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            return
        L_0x0013:
            r1 = move-exception
            goto L_0x0042
        L_0x0015:
            r5.cancel()     // Catch:{ all -> 0x0013 }
            com.bumptech.glide.load.engine.Resource<R> r1 = r5.resource     // Catch:{ all -> 0x0013 }
            r3 = 0
            if (r1 == 0) goto L_0x0020
            r5.resource = r3     // Catch:{ all -> 0x0013 }
            goto L_0x0021
        L_0x0020:
            r1 = r3
        L_0x0021:
            boolean r3 = r5.canNotifyCleared()     // Catch:{ all -> 0x0013 }
            if (r3 == 0) goto L_0x0030
            com.bumptech.glide.request.target.Target<R> r3 = r5.target     // Catch:{ all -> 0x0013 }
            android.graphics.drawable.Drawable r4 = r5.getPlaceholderDrawable()     // Catch:{ all -> 0x0013 }
            r3.onLoadCleared(r4)     // Catch:{ all -> 0x0013 }
        L_0x0030:
            java.lang.String r3 = "GlideRequest"
            int r4 = r5.cookie     // Catch:{ all -> 0x0013 }
            com.bumptech.glide.util.pool.GlideTrace.endSectionAsync(r3, r4)     // Catch:{ all -> 0x0013 }
            r5.status = r2     // Catch:{ all -> 0x0013 }
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            if (r1 == 0) goto L_0x0041
            com.bumptech.glide.load.engine.Engine r0 = r5.engine
            r0.release(r1)
        L_0x0041:
            return
        L_0x0042:
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.clear():void");
    }

    public Object getLock() {
        this.stateVerifier.throwIfRecycled();
        return this.requestLock;
    }

    public boolean isAnyResourceSet() {
        boolean z10;
        synchronized (this.requestLock) {
            if (this.status == Status.COMPLETE) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public boolean isCleared() {
        boolean z10;
        synchronized (this.requestLock) {
            if (this.status == Status.CLEARED) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public boolean isComplete() {
        boolean z10;
        synchronized (this.requestLock) {
            if (this.status == Status.COMPLETE) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public boolean isEquivalentTo(Request request) {
        int i10;
        int i11;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        Priority priority2;
        int i12;
        int i13;
        int i14;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        Priority priority3;
        int i15;
        Request request2 = request;
        if (!(request2 instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.requestLock) {
            try {
                i10 = this.overrideWidth;
                i11 = this.overrideHeight;
                obj = this.model;
                cls = this.transcodeClass;
                baseRequestOptions = this.requestOptions;
                priority2 = this.priority;
                List<RequestListener<R>> list = this.requestListeners;
                if (list != null) {
                    i12 = list.size();
                } else {
                    i12 = 0;
                }
            } finally {
                while (true) {
                }
            }
        }
        SingleRequest singleRequest = (SingleRequest) request2;
        synchronized (singleRequest.requestLock) {
            try {
                i13 = singleRequest.overrideWidth;
                i14 = singleRequest.overrideHeight;
                obj2 = singleRequest.model;
                cls2 = singleRequest.transcodeClass;
                baseRequestOptions2 = singleRequest.requestOptions;
                priority3 = singleRequest.priority;
                List<RequestListener<R>> list2 = singleRequest.requestListeners;
                if (list2 != null) {
                    i15 = list2.size();
                } else {
                    i15 = 0;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (i10 == i13 && i11 == i14 && Util.bothModelsNullEquivalentOrEquals(obj, obj2) && cls.equals(cls2) && baseRequestOptions.equals(baseRequestOptions2) && priority2 == priority3 && i12 == i15) {
            return true;
        }
        return false;
    }

    public boolean isRunning() {
        boolean z10;
        synchronized (this.requestLock) {
            try {
                Status status2 = this.status;
                if (status2 != Status.RUNNING) {
                    if (status2 != Status.WAITING_FOR_SIZE) {
                        z10 = false;
                    }
                }
                z10 = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public void onLoadFailed(GlideException glideException) {
        onLoadFailed(glideException, 5);
    }

    public void onResourceReady(Resource<?> resource2, DataSource dataSource, boolean z10) {
        String str;
        this.stateVerifier.throwIfRecycled();
        Resource<?> resource3 = null;
        try {
            synchronized (this.requestLock) {
                try {
                    this.loadStatus = null;
                    if (resource2 == null) {
                        onLoadFailed(new GlideException("Expected to receive a Resource<R> with an object of " + this.transcodeClass + " inside, but instead got null."));
                        return;
                    }
                    Object obj = resource2.get();
                    if (obj != null) {
                        if (this.transcodeClass.isAssignableFrom(obj.getClass())) {
                            if (!canSetResource()) {
                                try {
                                    this.resource = null;
                                    this.status = Status.COMPLETE;
                                    GlideTrace.endSectionAsync(TAG, this.cookie);
                                    this.engine.release(resource2);
                                    return;
                                } catch (Throwable th) {
                                    resource3 = resource2;
                                    th = th;
                                    throw th;
                                }
                            } else {
                                onResourceReady(resource2, obj, dataSource, z10);
                                return;
                            }
                        }
                    }
                    this.resource = null;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Expected to receive an object of ");
                    sb2.append(this.transcodeClass);
                    sb2.append(" but instead got ");
                    sb2.append(obj != null ? obj.getClass() : "");
                    sb2.append("{");
                    sb2.append(obj);
                    sb2.append("} inside Resource{");
                    sb2.append(resource2);
                    sb2.append("}.");
                    if (obj != null) {
                        str = "";
                    } else {
                        str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
                    }
                    sb2.append(str);
                    onLoadFailed(new GlideException(sb2.toString()));
                    this.engine.release(resource2);
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        } catch (Throwable th3) {
            if (resource3 != null) {
                this.engine.release(resource3);
            }
            throw th3;
        }
    }

    public void onSizeReady(int i10, int i11) {
        Object obj;
        this.stateVerifier.throwIfRecycled();
        Object obj2 = this.requestLock;
        synchronized (obj2) {
            try {
                boolean z10 = IS_VERBOSE_LOGGABLE;
                if (z10) {
                    logV("Got onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
                }
                if (this.status == Status.WAITING_FOR_SIZE) {
                    Status status2 = Status.RUNNING;
                    this.status = status2;
                    float sizeMultiplier = this.requestOptions.getSizeMultiplier();
                    this.width = maybeApplySizeMultiplier(i10, sizeMultiplier);
                    this.height = maybeApplySizeMultiplier(i11, sizeMultiplier);
                    if (z10) {
                        logV("finished setup for calling load in " + LogTime.getElapsedMillis(this.startTime));
                    }
                    Status status3 = status2;
                    boolean z11 = z10;
                    Status status4 = status3;
                    obj = obj2;
                    try {
                        this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this, this.callbackExecutor);
                        if (this.status != status4) {
                            this.loadStatus = null;
                        }
                        if (z11) {
                            logV("finished onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                obj = obj2;
                throw th;
            }
        }
    }

    public void pause() {
        synchronized (this.requestLock) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        Object obj;
        Class<R> cls;
        synchronized (this.requestLock) {
            obj = this.model;
            cls = this.transcodeClass;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }

    private void onLoadFailed(GlideException glideException, int i10) {
        boolean z10;
        this.stateVerifier.throwIfRecycled();
        synchronized (this.requestLock) {
            try {
                glideException.setOrigin(this.requestOrigin);
                int logLevel = this.glideContext.getLogLevel();
                if (logLevel <= i10) {
                    Log.w(GLIDE_TAG, "Load failed for [" + this.model + "] with dimensions [" + this.width + "x" + this.height + "]", glideException);
                    if (logLevel <= 4) {
                        glideException.logRootCauses(GLIDE_TAG);
                    }
                }
                this.loadStatus = null;
                this.status = Status.FAILED;
                notifyRequestCoordinatorLoadFailed();
                boolean z11 = true;
                this.isCallingCallbacks = true;
                List<RequestListener<R>> list = this.requestListeners;
                if (list != null) {
                    z10 = false;
                    for (RequestListener<R> onLoadFailed : list) {
                        z10 |= onLoadFailed.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource());
                    }
                } else {
                    z10 = false;
                }
                RequestListener<R> requestListener = this.targetListener;
                if (requestListener == null || !requestListener.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource())) {
                    z11 = false;
                }
                if (!z10 && !z11) {
                    setErrorPlaceholder();
                }
                this.isCallingCallbacks = false;
                GlideTrace.endSectionAsync(TAG, this.cookie);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ac A[Catch:{ all -> 0x0093 }] */
    @androidx.annotation.GuardedBy("requestLock")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onResourceReady(com.bumptech.glide.load.engine.Resource<R> r10, R r11, com.bumptech.glide.load.DataSource r12, boolean r13) {
        /*
            r9 = this;
            boolean r13 = r9.isFirstReadyResource()
            com.bumptech.glide.request.SingleRequest$Status r0 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE
            r9.status = r0
            r9.resource = r10
            com.bumptech.glide.GlideContext r10 = r9.glideContext
            int r10 = r10.getLogLevel()
            r0 = 3
            if (r10 > r0) goto L_0x006a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Finished loading "
            r10.append(r0)
            java.lang.Class r0 = r11.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r10.append(r0)
            java.lang.String r0 = " from "
            r10.append(r0)
            r10.append(r12)
            java.lang.String r0 = " for "
            r10.append(r0)
            java.lang.Object r0 = r9.model
            r10.append(r0)
            java.lang.String r0 = " with size ["
            r10.append(r0)
            int r0 = r9.width
            r10.append(r0)
            java.lang.String r0 = "x"
            r10.append(r0)
            int r0 = r9.height
            r10.append(r0)
            java.lang.String r0 = "] in "
            r10.append(r0)
            long r0 = r9.startTime
            double r0 = com.bumptech.glide.util.LogTime.getElapsedMillis(r0)
            r10.append(r0)
            java.lang.String r0 = " ms"
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            java.lang.String r0 = "Glide"
            android.util.Log.d(r0, r10)
        L_0x006a:
            r9.notifyRequestCoordinatorLoadSucceeded()
            r10 = 1
            r9.isCallingCallbacks = r10
            r6 = 0
            java.util.List<com.bumptech.glide.request.RequestListener<R>> r0 = r9.requestListeners     // Catch:{ all -> 0x0093 }
            if (r0 == 0) goto L_0x0095
            java.util.Iterator r7 = r0.iterator()     // Catch:{ all -> 0x0093 }
            r8 = r6
        L_0x007a:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x0093 }
            if (r0 == 0) goto L_0x0096
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x0093 }
            com.bumptech.glide.request.RequestListener r0 = (com.bumptech.glide.request.RequestListener) r0     // Catch:{ all -> 0x0093 }
            java.lang.Object r2 = r9.model     // Catch:{ all -> 0x0093 }
            com.bumptech.glide.request.target.Target<R> r3 = r9.target     // Catch:{ all -> 0x0093 }
            r1 = r11
            r4 = r12
            r5 = r13
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0093 }
            r8 = r8 | r0
            goto L_0x007a
        L_0x0093:
            r10 = move-exception
            goto L_0x00c1
        L_0x0095:
            r8 = r6
        L_0x0096:
            com.bumptech.glide.request.RequestListener<R> r0 = r9.targetListener     // Catch:{ all -> 0x0093 }
            if (r0 == 0) goto L_0x00a8
            java.lang.Object r2 = r9.model     // Catch:{ all -> 0x0093 }
            com.bumptech.glide.request.target.Target<R> r3 = r9.target     // Catch:{ all -> 0x0093 }
            r1 = r11
            r4 = r12
            r5 = r13
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0093 }
            if (r0 == 0) goto L_0x00a8
            goto L_0x00a9
        L_0x00a8:
            r10 = r6
        L_0x00a9:
            r10 = r10 | r8
            if (r10 != 0) goto L_0x00b7
            com.bumptech.glide.request.transition.TransitionFactory<? super R> r10 = r9.animationFactory     // Catch:{ all -> 0x0093 }
            com.bumptech.glide.request.transition.Transition r10 = r10.build(r12, r13)     // Catch:{ all -> 0x0093 }
            com.bumptech.glide.request.target.Target<R> r12 = r9.target     // Catch:{ all -> 0x0093 }
            r12.onResourceReady(r11, r10)     // Catch:{ all -> 0x0093 }
        L_0x00b7:
            r9.isCallingCallbacks = r6
            java.lang.String r10 = "GlideRequest"
            int r11 = r9.cookie
            com.bumptech.glide.util.pool.GlideTrace.endSectionAsync(r10, r11)
            return
        L_0x00c1:
            r9.isCallingCallbacks = r6
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.onResourceReady(com.bumptech.glide.load.engine.Resource, java.lang.Object, com.bumptech.glide.load.DataSource, boolean):void");
    }
}
