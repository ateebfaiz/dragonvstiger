package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LruBitmapPool implements BitmapPool {
    private static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    private static final String TAG = "LruBitmapPool";
    private final Set<Bitmap.Config> allowedConfigs;
    private long currentSize;
    private int evictions;
    private int hits;
    private final long initialMaxSize;
    private long maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;
    private final BitmapTracker tracker;

    private interface BitmapTracker {
        void add(Bitmap bitmap);

        void remove(Bitmap bitmap);
    }

    private static final class NullBitmapTracker implements BitmapTracker {
        NullBitmapTracker() {
        }

        public void add(Bitmap bitmap) {
        }

        public void remove(Bitmap bitmap) {
        }
    }

    private static class ThrowingBitmapTracker implements BitmapTracker {
        private final Set<Bitmap> bitmaps = Collections.synchronizedSet(new HashSet());

        private ThrowingBitmapTracker() {
        }

        public void add(Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                this.bitmaps.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }

        public void remove(Bitmap bitmap) {
            if (this.bitmaps.contains(bitmap)) {
                this.bitmaps.remove(bitmap);
                return;
            }
            throw new IllegalStateException("Cannot remove bitmap not in tracker");
        }
    }

    LruBitmapPool(long j10, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.initialMaxSize = j10;
        this.maxSize = j10;
        this.strategy = lruPoolStrategy;
        this.allowedConfigs = set;
        this.tracker = new NullBitmapTracker();
    }

    @TargetApi(26)
    private static void assertNotHardwareConfig(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @NonNull
    private static Bitmap createBitmap(int i10, int i11, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = DEFAULT_CONFIG;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    private void dump() {
        if (Log.isLoggable(TAG, 2)) {
            dumpUnchecked();
        }
    }

    private void dumpUnchecked() {
        Log.v(TAG, "Hits=" + this.hits + ", misses=" + this.misses + ", puts=" + this.puts + ", evictions=" + this.evictions + ", currentSize=" + this.currentSize + ", maxSize=" + this.maxSize + "\nStrategy=" + this.strategy);
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> getDefaultAllowedConfigs() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i10 = Build.VERSION.SDK_INT;
        hashSet.add((Object) null);
        if (i10 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static LruPoolStrategy getDefaultStrategy() {
        return new SizeConfigStrategy();
    }

    @Nullable
    private synchronized Bitmap getDirtyOrNull(int i10, int i11, @Nullable Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap bitmap;
        try {
            assertNotHardwareConfig(config);
            LruPoolStrategy lruPoolStrategy = this.strategy;
            if (config != null) {
                config2 = config;
            } else {
                config2 = DEFAULT_CONFIG;
            }
            bitmap = lruPoolStrategy.get(i10, i11, config2);
            if (bitmap == null) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Missing bitmap=" + this.strategy.logBitmap(i10, i11, config));
                }
                this.misses++;
            } else {
                this.hits++;
                this.currentSize -= (long) this.strategy.getSize(bitmap);
                this.tracker.remove(bitmap);
                normalize(bitmap);
            }
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Get bitmap=" + this.strategy.logBitmap(i10, i11, config));
            }
            dump();
        } catch (Throwable th) {
            throw th;
        }
        return bitmap;
    }

    @TargetApi(19)
    private static void maybeSetPreMultiplied(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    private static void normalize(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        maybeSetPreMultiplied(bitmap);
    }

    private synchronized void trimToSize(long j10) {
        while (this.currentSize > j10) {
            try {
                Bitmap removeLast = this.strategy.removeLast();
                if (removeLast == null) {
                    if (Log.isLoggable(TAG, 5)) {
                        Log.w(TAG, "Size mismatch, resetting");
                        dumpUnchecked();
                    }
                    this.currentSize = 0;
                    return;
                }
                this.tracker.remove(removeLast);
                this.currentSize -= (long) this.strategy.getSize(removeLast);
                this.evictions++;
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Evicting bitmap=" + this.strategy.logBitmap(removeLast));
                }
                dump();
                removeLast.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void clearMemory() {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "clearMemory");
        }
        trimToSize(0);
    }

    public long evictionCount() {
        return (long) this.evictions;
    }

    @NonNull
    public Bitmap get(int i10, int i11, Bitmap.Config config) {
        Bitmap dirtyOrNull = getDirtyOrNull(i10, i11, config);
        if (dirtyOrNull == null) {
            return createBitmap(i10, i11, config);
        }
        dirtyOrNull.eraseColor(0);
        return dirtyOrNull;
    }

    public long getCurrentSize() {
        return this.currentSize;
    }

    @NonNull
    public Bitmap getDirty(int i10, int i11, Bitmap.Config config) {
        Bitmap dirtyOrNull = getDirtyOrNull(i10, i11, config);
        if (dirtyOrNull == null) {
            return createBitmap(i10, i11, config);
        }
        return dirtyOrNull;
    }

    public long getMaxSize() {
        return this.maxSize;
    }

    public long hitCount() {
        return (long) this.hits;
    }

    public long missCount() {
        return (long) this.misses;
    }

    public synchronized void put(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.strategy.getSize(bitmap)) <= this.maxSize) {
                        if (this.allowedConfigs.contains(bitmap.getConfig())) {
                            int size = this.strategy.getSize(bitmap);
                            this.strategy.put(bitmap);
                            this.tracker.add(bitmap);
                            this.puts++;
                            this.currentSize += (long) size;
                            if (Log.isLoggable(TAG, 2)) {
                                Log.v(TAG, "Put bitmap in pool=" + this.strategy.logBitmap(bitmap));
                            }
                            dump();
                            evict();
                            return;
                        }
                    }
                    if (Log.isLoggable(TAG, 2)) {
                        Log.v(TAG, "Reject bitmap from pool, bitmap: " + this.strategy.logBitmap(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.allowedConfigs.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    public synchronized void setSizeMultiplier(float f10) {
        this.maxSize = (long) Math.round(((float) this.initialMaxSize) * f10);
        evict();
    }

    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i10) {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "trimMemory, level=" + i10);
        }
        if (i10 >= 40 || i10 >= 20) {
            clearMemory();
        } else if (i10 >= 20 || i10 == 15) {
            trimToSize(getMaxSize() / 2);
        }
    }

    public LruBitmapPool(long j10) {
        this(j10, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    public LruBitmapPool(long j10, Set<Bitmap.Config> set) {
        this(j10, getDefaultStrategy(), set);
    }
}
