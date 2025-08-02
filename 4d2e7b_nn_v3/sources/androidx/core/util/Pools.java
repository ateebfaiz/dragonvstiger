package androidx.core.util;

import androidx.annotation.IntRange;
import kotlin.jvm.internal.m;

public final class Pools {

    public interface Pool<T> {
        T acquire();

        boolean release(T t10);
    }

    public static class SimplePool<T> implements Pool<T> {
        private final Object[] pool;
        private int poolSize;

        public SimplePool(@IntRange(from = 1) int i10) {
            if (i10 > 0) {
                this.pool = new Object[i10];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0".toString());
        }

        private final boolean isInPool(T t10) {
            int i10 = this.poolSize;
            for (int i11 = 0; i11 < i10; i11++) {
                if (this.pool[i11] == t10) {
                    return true;
                }
            }
            return false;
        }

        public T acquire() {
            int i10 = this.poolSize;
            if (i10 <= 0) {
                return null;
            }
            int i11 = i10 - 1;
            T t10 = this.pool[i11];
            m.d(t10, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
            this.pool[i11] = null;
            this.poolSize--;
            return t10;
        }

        public boolean release(T t10) {
            m.f(t10, "instance");
            if (!isInPool(t10)) {
                int i10 = this.poolSize;
                Object[] objArr = this.pool;
                if (i10 >= objArr.length) {
                    return false;
                }
                objArr[i10] = t10;
                this.poolSize = i10 + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!".toString());
        }
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object lock = new Object();

        public SynchronizedPool(int i10) {
            super(i10);
        }

        public T acquire() {
            T acquire;
            synchronized (this.lock) {
                acquire = super.acquire();
            }
            return acquire;
        }

        public boolean release(T t10) {
            boolean release;
            m.f(t10, "instance");
            synchronized (this.lock) {
                release = super.release(t10);
            }
            return release;
        }
    }

    private Pools() {
    }
}
