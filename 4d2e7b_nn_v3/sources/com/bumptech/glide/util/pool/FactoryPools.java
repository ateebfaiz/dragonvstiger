package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

public final class FactoryPools {
    private static final int DEFAULT_POOL_SIZE = 20;
    private static final Resetter<Object> EMPTY_RESETTER = new Resetter<Object>() {
        public void reset(@NonNull Object obj) {
        }
    };
    private static final String TAG = "FactoryPools";

    public interface Factory<T> {
        T create();
    }

    private static final class FactoryPool<T> implements Pools.Pool<T> {
        private final Factory<T> factory;
        private final Pools.Pool<T> pool;
        private final Resetter<T> resetter;

        FactoryPool(@NonNull Pools.Pool<T> pool2, @NonNull Factory<T> factory2, @NonNull Resetter<T> resetter2) {
            this.pool = pool2;
            this.factory = factory2;
            this.resetter = resetter2;
        }

        public T acquire() {
            T acquire = this.pool.acquire();
            if (acquire == null) {
                acquire = this.factory.create();
                if (Log.isLoggable(FactoryPools.TAG, 2)) {
                    Log.v(FactoryPools.TAG, "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof Poolable) {
                ((Poolable) acquire).getVerifier().setRecycled(false);
            }
            return acquire;
        }

        public boolean release(@NonNull T t10) {
            if (t10 instanceof Poolable) {
                ((Poolable) t10).getVerifier().setRecycled(true);
            }
            this.resetter.reset(t10);
            return this.pool.release(t10);
        }
    }

    public interface Poolable {
        @NonNull
        StateVerifier getVerifier();
    }

    public interface Resetter<T> {
        void reset(@NonNull T t10);
    }

    private FactoryPools() {
    }

    @NonNull
    private static <T extends Poolable> Pools.Pool<T> build(@NonNull Pools.Pool<T> pool, @NonNull Factory<T> factory) {
        return build(pool, factory, emptyResetter());
    }

    @NonNull
    private static <T> Resetter<T> emptyResetter() {
        return EMPTY_RESETTER;
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> simple(int i10, @NonNull Factory<T> factory) {
        return build(new Pools.SimplePool(i10), factory);
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> threadSafe(int i10, @NonNull Factory<T> factory) {
        return build(new Pools.SynchronizedPool(i10), factory);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> threadSafeList() {
        return threadSafeList(20);
    }

    @NonNull
    private static <T> Pools.Pool<T> build(@NonNull Pools.Pool<T> pool, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
        return new FactoryPool(pool, factory, resetter);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> threadSafeList(int i10) {
        return build(new Pools.SynchronizedPool(i10), new Factory<List<T>>() {
            @NonNull
            public List<T> create() {
                return new ArrayList();
            }
        }, new Resetter<List<T>>() {
            public void reset(@NonNull List<T> list) {
                list.clear();
            }
        });
    }
}
