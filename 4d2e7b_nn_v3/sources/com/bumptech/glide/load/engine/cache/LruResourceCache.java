package com.bumptech.glide.load.engine.cache;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.util.LruCache;

public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {
    private MemoryCache.ResourceRemovedListener listener;

    public LruResourceCache(long j10) {
        super(j10);
    }

    @Nullable
    public /* bridge */ /* synthetic */ Resource put(@NonNull Key key, @Nullable Resource resource) {
        return (Resource) super.put(key, resource);
    }

    @Nullable
    public /* bridge */ /* synthetic */ Resource remove(@NonNull Key key) {
        return (Resource) super.remove(key);
    }

    public void setResourceRemovedListener(@NonNull MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.listener = resourceRemovedListener;
    }

    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i10) {
        if (i10 >= 40) {
            clearMemory();
        } else if (i10 >= 20 || i10 == 15) {
            trimToSize(getMaxSize() / 2);
        }
    }

    /* access modifiers changed from: protected */
    public int getSize(@Nullable Resource<?> resource) {
        if (resource == null) {
            return super.getSize(null);
        }
        return resource.getSize();
    }

    /* access modifiers changed from: protected */
    public void onItemEvicted(@NonNull Key key, @Nullable Resource<?> resource) {
        MemoryCache.ResourceRemovedListener resourceRemovedListener = this.listener;
        if (resourceRemovedListener != null && resource != null) {
            resourceRemovedListener.onResourceRemoved(resource);
        }
    }
}
