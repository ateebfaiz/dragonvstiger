package com.bumptech.glide.manager;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

public class RequestTracker {
    private static final String TAG = "RequestTracker";
    private boolean isPaused;
    private final Set<Request> pendingRequests = new HashSet();
    private final Set<Request> requests = Collections.newSetFromMap(new WeakHashMap());

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void addRequest(Request request) {
        this.requests.add(request);
    }

    public boolean clearAndRemove(@Nullable Request request) {
        boolean z10 = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.requests.remove(request);
        if (!this.pendingRequests.remove(request) && !remove) {
            z10 = false;
        }
        if (z10) {
            request.clear();
        }
        return z10;
    }

    public void clearRequests() {
        for (T clearAndRemove : Util.getSnapshot(this.requests)) {
            clearAndRemove(clearAndRemove);
        }
        this.pendingRequests.clear();
    }

    public boolean isPaused() {
        return this.isPaused;
    }

    public void pauseAllRequests() {
        this.isPaused = true;
        for (T t10 : Util.getSnapshot(this.requests)) {
            if (t10.isRunning() || t10.isComplete()) {
                t10.clear();
                this.pendingRequests.add(t10);
            }
        }
    }

    public void pauseRequests() {
        this.isPaused = true;
        for (T t10 : Util.getSnapshot(this.requests)) {
            if (t10.isRunning()) {
                t10.pause();
                this.pendingRequests.add(t10);
            }
        }
    }

    public void restartRequests() {
        for (T t10 : Util.getSnapshot(this.requests)) {
            if (!t10.isComplete() && !t10.isCleared()) {
                t10.clear();
                if (!this.isPaused) {
                    t10.begin();
                } else {
                    this.pendingRequests.add(t10);
                }
            }
        }
    }

    public void resumeRequests() {
        this.isPaused = false;
        for (T t10 : Util.getSnapshot(this.requests)) {
            if (!t10.isComplete() && !t10.isRunning()) {
                t10.begin();
            }
        }
        this.pendingRequests.clear();
    }

    public void runRequest(@NonNull Request request) {
        this.requests.add(request);
        if (!this.isPaused) {
            request.begin();
            return;
        }
        request.clear();
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "Paused, delaying request");
        }
        this.pendingRequests.add(request);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.requests.size() + ", isPaused=" + this.isPaused + "}";
    }
}
