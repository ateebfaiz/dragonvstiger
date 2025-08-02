package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

public final class ErrorRequestCoordinator implements RequestCoordinator, Request {
    private volatile Request error;
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState errorState;
    @Nullable
    private final RequestCoordinator parent;
    private volatile Request primary;
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState primaryState;
    private final Object requestLock;

    public ErrorRequestCoordinator(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.primaryState = requestState;
        this.errorState = requestState;
        this.requestLock = obj;
        this.parent = requestCoordinator;
    }

    @GuardedBy("requestLock")
    private boolean isValidRequestForStatusChanged(Request request) {
        RequestCoordinator.RequestState requestState;
        RequestCoordinator.RequestState requestState2 = this.primaryState;
        RequestCoordinator.RequestState requestState3 = RequestCoordinator.RequestState.FAILED;
        if (requestState2 != requestState3) {
            return request.equals(this.primary);
        }
        if (!request.equals(this.error) || ((requestState = this.errorState) != RequestCoordinator.RequestState.SUCCESS && requestState != requestState3)) {
            return false;
        }
        return true;
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
        synchronized (this.requestLock) {
            try {
                RequestCoordinator.RequestState requestState = this.primaryState;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.primaryState = requestState2;
                    this.primary.begin();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean canNotifyCleared(Request request) {
        boolean z10;
        synchronized (this.requestLock) {
            try {
                if (!parentCanNotifyCleared() || !request.equals(this.primary)) {
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
                if (!parentCanNotifyStatusChanged() || !isValidRequestForStatusChanged(request)) {
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
        boolean parentCanSetImage;
        synchronized (this.requestLock) {
            parentCanSetImage = parentCanSetImage();
        }
        return parentCanSetImage;
    }

    public void clear() {
        synchronized (this.requestLock) {
            try {
                RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
                this.primaryState = requestState;
                this.primary.clear();
                if (this.errorState != requestState) {
                    this.errorState = requestState;
                    this.error.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
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
                if (!this.primary.isAnyResourceSet()) {
                    if (!this.error.isAnyResourceSet()) {
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
            try {
                RequestCoordinator.RequestState requestState = this.primaryState;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
                if (requestState == requestState2 && this.errorState == requestState2) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public boolean isComplete() {
        boolean z10;
        synchronized (this.requestLock) {
            try {
                RequestCoordinator.RequestState requestState = this.primaryState;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
                if (requestState != requestState2) {
                    if (this.errorState != requestState2) {
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

    public boolean isEquivalentTo(Request request) {
        if (!(request instanceof ErrorRequestCoordinator)) {
            return false;
        }
        ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
        if (!this.primary.isEquivalentTo(errorRequestCoordinator.primary) || !this.error.isEquivalentTo(errorRequestCoordinator.error)) {
            return false;
        }
        return true;
    }

    public boolean isRunning() {
        boolean z10;
        synchronized (this.requestLock) {
            try {
                RequestCoordinator.RequestState requestState = this.primaryState;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    if (this.errorState != requestState2) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestFailed(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.requestLock
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.error     // Catch:{ all -> 0x001d }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x001d }
            if (r3 != 0) goto L_0x0021
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x001d }
            r2.primaryState = r3     // Catch:{ all -> 0x001d }
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.errorState     // Catch:{ all -> 0x001d }
            com.bumptech.glide.request.RequestCoordinator$RequestState r1 = com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING     // Catch:{ all -> 0x001d }
            if (r3 == r1) goto L_0x001f
            r2.errorState = r1     // Catch:{ all -> 0x001d }
            com.bumptech.glide.request.Request r3 = r2.error     // Catch:{ all -> 0x001d }
            r3.begin()     // Catch:{ all -> 0x001d }
            goto L_0x001f
        L_0x001d:
            r3 = move-exception
            goto L_0x002e
        L_0x001f:
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            return
        L_0x0021:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x001d }
            r2.errorState = r3     // Catch:{ all -> 0x001d }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.parent     // Catch:{ all -> 0x001d }
            if (r3 == 0) goto L_0x002c
            r3.onRequestFailed(r2)     // Catch:{ all -> 0x001d }
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            return
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ErrorRequestCoordinator.onRequestFailed(com.bumptech.glide.request.Request):void");
    }

    public void onRequestSuccess(Request request) {
        synchronized (this.requestLock) {
            try {
                if (request.equals(this.primary)) {
                    this.primaryState = RequestCoordinator.RequestState.SUCCESS;
                } else if (request.equals(this.error)) {
                    this.errorState = RequestCoordinator.RequestState.SUCCESS;
                }
                RequestCoordinator requestCoordinator = this.parent;
                if (requestCoordinator != null) {
                    requestCoordinator.onRequestSuccess(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void pause() {
        synchronized (this.requestLock) {
            try {
                RequestCoordinator.RequestState requestState = this.primaryState;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState == requestState2) {
                    this.primaryState = RequestCoordinator.RequestState.PAUSED;
                    this.primary.pause();
                }
                if (this.errorState == requestState2) {
                    this.errorState = RequestCoordinator.RequestState.PAUSED;
                    this.error.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setRequests(Request request, Request request2) {
        this.primary = request;
        this.error = request2;
    }
}
