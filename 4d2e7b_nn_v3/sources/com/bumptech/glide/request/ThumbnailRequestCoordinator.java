package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {
    private volatile Request full;
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState fullState;
    @GuardedBy("requestLock")
    private boolean isRunningDuringBegin;
    @Nullable
    private final RequestCoordinator parent;
    private final Object requestLock;
    private volatile Request thumb;
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState thumbState;

    public ThumbnailRequestCoordinator(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.fullState = requestState;
        this.thumbState = requestState;
        this.requestLock = obj;
        this.parent = requestCoordinator;
    }

    @GuardedBy("requestLock")
    private boolean parentCanNotifyCleared() {
        RequestCoordinator requestCoordinator = this.parent;
        if (requestCoordinator == null || requestCoordinator.canNotifyCleared(this)) {
            return true;
        }
        return false;
    }

    @GuardedBy("requestLock")
    private boolean parentCanNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.parent;
        if (requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this)) {
            return true;
        }
        return false;
    }

    @GuardedBy("requestLock")
    private boolean parentCanSetImage() {
        RequestCoordinator requestCoordinator = this.parent;
        if (requestCoordinator == null || requestCoordinator.canSetImage(this)) {
            return true;
        }
        return false;
    }

    public void begin() {
        RequestCoordinator.RequestState requestState;
        RequestCoordinator.RequestState requestState2;
        synchronized (this.requestLock) {
            try {
                this.isRunningDuringBegin = true;
                if (!(this.fullState == RequestCoordinator.RequestState.SUCCESS || this.thumbState == (requestState2 = RequestCoordinator.RequestState.RUNNING))) {
                    this.thumbState = requestState2;
                    this.thumb.begin();
                }
                if (this.isRunningDuringBegin && this.fullState != (requestState = RequestCoordinator.RequestState.RUNNING)) {
                    this.fullState = requestState;
                    this.full.begin();
                }
                this.isRunningDuringBegin = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean canNotifyCleared(Request request) {
        boolean z10;
        synchronized (this.requestLock) {
            try {
                if (!parentCanNotifyCleared() || !request.equals(this.full) || this.fullState == RequestCoordinator.RequestState.PAUSED) {
                    z10 = false;
                } else {
                    z10 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public boolean canNotifyStatusChanged(Request request) {
        boolean z10;
        synchronized (this.requestLock) {
            try {
                if (!parentCanNotifyStatusChanged() || !request.equals(this.full) || isAnyResourceSet()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public boolean canSetImage(Request request) {
        boolean z10;
        synchronized (this.requestLock) {
            try {
                if (parentCanSetImage()) {
                    if (!request.equals(this.full)) {
                        if (this.fullState != RequestCoordinator.RequestState.SUCCESS) {
                        }
                    }
                    z10 = true;
                }
                z10 = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public void clear() {
        synchronized (this.requestLock) {
            this.isRunningDuringBegin = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.fullState = requestState;
            this.thumbState = requestState;
            this.thumb.clear();
            this.full.clear();
        }
    }

    public RequestCoordinator getRoot() {
        RequestCoordinator requestCoordinator;
        synchronized (this.requestLock) {
            try {
                RequestCoordinator requestCoordinator2 = this.parent;
                if (requestCoordinator2 != null) {
                    requestCoordinator = requestCoordinator2.getRoot();
                } else {
                    requestCoordinator = this;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return requestCoordinator;
    }

    public boolean isAnyResourceSet() {
        boolean z10;
        synchronized (this.requestLock) {
            try {
                if (!this.thumb.isAnyResourceSet()) {
                    if (!this.full.isAnyResourceSet()) {
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

    public boolean isCleared() {
        boolean z10;
        synchronized (this.requestLock) {
            if (this.fullState == RequestCoordinator.RequestState.CLEARED) {
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
            if (this.fullState == RequestCoordinator.RequestState.SUCCESS) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEquivalentTo(com.bumptech.glide.request.Request r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.bumptech.glide.request.ThumbnailRequestCoordinator
            r1 = 0
            if (r0 == 0) goto L_0x002e
            com.bumptech.glide.request.ThumbnailRequestCoordinator r4 = (com.bumptech.glide.request.ThumbnailRequestCoordinator) r4
            com.bumptech.glide.request.Request r0 = r3.full
            if (r0 != 0) goto L_0x0010
            com.bumptech.glide.request.Request r0 = r4.full
            if (r0 != 0) goto L_0x002e
            goto L_0x001a
        L_0x0010:
            com.bumptech.glide.request.Request r0 = r3.full
            com.bumptech.glide.request.Request r2 = r4.full
            boolean r0 = r0.isEquivalentTo(r2)
            if (r0 == 0) goto L_0x002e
        L_0x001a:
            com.bumptech.glide.request.Request r0 = r3.thumb
            if (r0 != 0) goto L_0x0023
            com.bumptech.glide.request.Request r4 = r4.thumb
            if (r4 != 0) goto L_0x002e
            goto L_0x002d
        L_0x0023:
            com.bumptech.glide.request.Request r0 = r3.thumb
            com.bumptech.glide.request.Request r4 = r4.thumb
            boolean r4 = r0.isEquivalentTo(r4)
            if (r4 == 0) goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.isEquivalentTo(com.bumptech.glide.request.Request):boolean");
    }

    public boolean isRunning() {
        boolean z10;
        synchronized (this.requestLock) {
            if (this.fullState == RequestCoordinator.RequestState.RUNNING) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestFailed(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.requestLock
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.full     // Catch:{ all -> 0x0011 }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x0011 }
            if (r3 != 0) goto L_0x0013
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x0011 }
            r2.thumbState = r3     // Catch:{ all -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0011:
            r3 = move-exception
            goto L_0x0020
        L_0x0013:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x0011 }
            r2.fullState = r3     // Catch:{ all -> 0x0011 }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.parent     // Catch:{ all -> 0x0011 }
            if (r3 == 0) goto L_0x001e
            r3.onRequestFailed(r2)     // Catch:{ all -> 0x0011 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.onRequestFailed(com.bumptech.glide.request.Request):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestSuccess(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.requestLock
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.thumb     // Catch:{ all -> 0x0011 }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x0011 }
            if (r3 == 0) goto L_0x0013
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x0011 }
            r2.thumbState = r3     // Catch:{ all -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0011:
            r3 = move-exception
            goto L_0x002d
        L_0x0013:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x0011 }
            r2.fullState = r3     // Catch:{ all -> 0x0011 }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.parent     // Catch:{ all -> 0x0011 }
            if (r3 == 0) goto L_0x001e
            r3.onRequestSuccess(r2)     // Catch:{ all -> 0x0011 }
        L_0x001e:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.thumbState     // Catch:{ all -> 0x0011 }
            boolean r3 = r3.isComplete()     // Catch:{ all -> 0x0011 }
            if (r3 != 0) goto L_0x002b
            com.bumptech.glide.request.Request r3 = r2.thumb     // Catch:{ all -> 0x0011 }
            r3.clear()     // Catch:{ all -> 0x0011 }
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.onRequestSuccess(com.bumptech.glide.request.Request):void");
    }

    public void pause() {
        synchronized (this.requestLock) {
            try {
                if (!this.thumbState.isComplete()) {
                    this.thumbState = RequestCoordinator.RequestState.PAUSED;
                    this.thumb.pause();
                }
                if (!this.fullState.isComplete()) {
                    this.fullState = RequestCoordinator.RequestState.PAUSED;
                    this.full.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setRequests(Request request, Request request2) {
        this.full = request;
        this.thumb = request2;
    }
}
