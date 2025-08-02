package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<T, Y> {
    private final Map<T, Entry<Y>> cache = new LinkedHashMap(100, 0.75f, true);
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    static final class Entry<Y> {
        final int size;
        final Y value;

        Entry(Y y10, int i10) {
            this.value = y10;
            this.size = i10;
        }
    }

    public LruCache(long j10) {
        this.initialMaxSize = j10;
        this.maxSize = j10;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public void clearMemory() {
        trimToSize(0);
    }

    public synchronized boolean contains(@NonNull T t10) {
        return this.cache.containsKey(t10);
    }

    @Nullable
    public synchronized Y get(@NonNull T t10) {
        Y y10;
        Entry entry = this.cache.get(t10);
        if (entry != null) {
            y10 = entry.value;
        } else {
            y10 = null;
        }
        return y10;
    }

    /* access modifiers changed from: protected */
    public synchronized int getCount() {
        return this.cache.size();
    }

    public synchronized long getCurrentSize() {
        return this.currentSize;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    /* access modifiers changed from: protected */
    public int getSize(@Nullable Y y10) {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void onItemEvicted(@NonNull T t10, @Nullable Y y10) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004b, code lost:
        return r4;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized Y put(@androidx.annotation.NonNull T r8, @androidx.annotation.Nullable Y r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r7.getSize(r9)     // Catch:{ all -> 0x0012 }
            long r1 = (long) r0     // Catch:{ all -> 0x0012 }
            long r3 = r7.maxSize     // Catch:{ all -> 0x0012 }
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r4 = 0
            if (r3 < 0) goto L_0x0014
            r7.onItemEvicted(r8, r9)     // Catch:{ all -> 0x0012 }
            monitor-exit(r7)
            return r4
        L_0x0012:
            r8 = move-exception
            goto L_0x004c
        L_0x0014:
            if (r9 == 0) goto L_0x001b
            long r5 = r7.currentSize     // Catch:{ all -> 0x0012 }
            long r5 = r5 + r1
            r7.currentSize = r5     // Catch:{ all -> 0x0012 }
        L_0x001b:
            java.util.Map<T, com.bumptech.glide.util.LruCache$Entry<Y>> r1 = r7.cache     // Catch:{ all -> 0x0012 }
            if (r9 != 0) goto L_0x0021
            r2 = r4
            goto L_0x0026
        L_0x0021:
            com.bumptech.glide.util.LruCache$Entry r2 = new com.bumptech.glide.util.LruCache$Entry     // Catch:{ all -> 0x0012 }
            r2.<init>(r9, r0)     // Catch:{ all -> 0x0012 }
        L_0x0026:
            java.lang.Object r0 = r1.put(r8, r2)     // Catch:{ all -> 0x0012 }
            com.bumptech.glide.util.LruCache$Entry r0 = (com.bumptech.glide.util.LruCache.Entry) r0     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0043
            long r1 = r7.currentSize     // Catch:{ all -> 0x0012 }
            int r3 = r0.size     // Catch:{ all -> 0x0012 }
            long r5 = (long) r3     // Catch:{ all -> 0x0012 }
            long r1 = r1 - r5
            r7.currentSize = r1     // Catch:{ all -> 0x0012 }
            Y r1 = r0.value     // Catch:{ all -> 0x0012 }
            boolean r9 = r1.equals(r9)     // Catch:{ all -> 0x0012 }
            if (r9 != 0) goto L_0x0043
            Y r9 = r0.value     // Catch:{ all -> 0x0012 }
            r7.onItemEvicted(r8, r9)     // Catch:{ all -> 0x0012 }
        L_0x0043:
            r7.evict()     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x004a
            Y r4 = r0.value     // Catch:{ all -> 0x0012 }
        L_0x004a:
            monitor-exit(r7)
            return r4
        L_0x004c:
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.LruCache.put(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Nullable
    public synchronized Y remove(@NonNull T t10) {
        Entry remove = this.cache.remove(t10);
        if (remove == null) {
            return null;
        }
        this.currentSize -= (long) remove.size;
        return remove.value;
    }

    public synchronized void setSizeMultiplier(float f10) {
        if (f10 >= 0.0f) {
            this.maxSize = (long) Math.round(((float) this.initialMaxSize) * f10);
            evict();
        } else {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void trimToSize(long j10) {
        while (this.currentSize > j10) {
            Iterator<Map.Entry<T, Entry<Y>>> it = this.cache.entrySet().iterator();
            Map.Entry next = it.next();
            Entry entry = (Entry) next.getValue();
            this.currentSize -= (long) entry.size;
            Object key = next.getKey();
            it.remove();
            onItemEvicted(key, entry.value);
        }
    }
}
