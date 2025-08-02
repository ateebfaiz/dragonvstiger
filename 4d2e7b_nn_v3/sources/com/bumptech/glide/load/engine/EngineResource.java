package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

class EngineResource<Z> implements Resource<Z> {
    private int acquired;
    private final boolean isMemoryCacheable;
    private final boolean isRecyclable;
    private boolean isRecycled;
    private final Key key;
    private final ResourceListener listener;
    private final Resource<Z> resource;

    interface ResourceListener {
        void onResourceReleased(Key key, EngineResource<?> engineResource);
    }

    EngineResource(Resource<Z> resource2, boolean z10, boolean z11, Key key2, ResourceListener resourceListener) {
        this.resource = (Resource) Preconditions.checkNotNull(resource2);
        this.isMemoryCacheable = z10;
        this.isRecyclable = z11;
        this.key = key2;
        this.listener = (ResourceListener) Preconditions.checkNotNull(resourceListener);
    }

    /* access modifiers changed from: package-private */
    public synchronized void acquire() {
        if (!this.isRecycled) {
            this.acquired++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    @NonNull
    public Z get() {
        return this.resource.get();
    }

    /* access modifiers changed from: package-private */
    public Resource<Z> getResource() {
        return this.resource;
    }

    @NonNull
    public Class<Z> getResourceClass() {
        return this.resource.getResourceClass();
    }

    public int getSize() {
        return this.resource.getSize();
    }

    /* access modifiers changed from: package-private */
    public boolean isMemoryCacheable() {
        return this.isMemoryCacheable;
    }

    public synchronized void recycle() {
        if (this.acquired > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.isRecycled) {
            this.isRecycled = true;
            if (this.isRecyclable) {
                this.resource.recycle();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    /* access modifiers changed from: package-private */
    public void release() {
        boolean z10;
        synchronized (this) {
            int i10 = this.acquired;
            if (i10 > 0) {
                z10 = true;
                int i11 = i10 - 1;
                this.acquired = i11;
                if (i11 != 0) {
                    z10 = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z10) {
            this.listener.onResourceReleased(this.key, this);
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.isMemoryCacheable + ", listener=" + this.listener + ", key=" + this.key + ", acquired=" + this.acquired + ", isRecycled=" + this.isRecycled + ", resource=" + this.resource + '}';
    }
}
