package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

public class ModelCache<A, B> {
    private static final int DEFAULT_SIZE = 250;
    private final LruCache<ModelKey<A>, B> cache;

    @VisibleForTesting
    static final class ModelKey<A> {
        private static final Queue<ModelKey<?>> KEY_QUEUE = Util.createQueue(0);
        private int height;
        private A model;
        private int width;

        private ModelKey() {
        }

        static <A> ModelKey<A> get(A a10, int i10, int i11) {
            ModelKey<A> poll;
            Queue<ModelKey<?>> queue = KEY_QUEUE;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new ModelKey<>();
            }
            poll.init(a10, i10, i11);
            return poll;
        }

        private void init(A a10, int i10, int i11) {
            this.model = a10;
            this.width = i10;
            this.height = i11;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ModelKey)) {
                return false;
            }
            ModelKey modelKey = (ModelKey) obj;
            if (this.width == modelKey.width && this.height == modelKey.height && this.model.equals(modelKey.model)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.height * 31) + this.width) * 31) + this.model.hashCode();
        }

        public void release() {
            Queue<ModelKey<?>> queue = KEY_QUEUE;
            synchronized (queue) {
                queue.offer(this);
            }
        }
    }

    public ModelCache() {
        this(250);
    }

    public void clear() {
        this.cache.clearMemory();
    }

    @Nullable
    public B get(A a10, int i10, int i11) {
        ModelKey modelKey = ModelKey.get(a10, i10, i11);
        B b10 = this.cache.get(modelKey);
        modelKey.release();
        return b10;
    }

    public void put(A a10, int i10, int i11, B b10) {
        this.cache.put(ModelKey.get(a10, i10, i11), b10);
    }

    public ModelCache(long j10) {
        this.cache = new LruCache<ModelKey<A>, B>(j10) {
            /* access modifiers changed from: protected */
            public void onItemEvicted(@NonNull ModelKey<A> modelKey, @Nullable B b10) {
                modelKey.release();
            }
        };
    }
}
