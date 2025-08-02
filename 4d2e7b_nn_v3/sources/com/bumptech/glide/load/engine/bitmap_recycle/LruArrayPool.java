package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class LruArrayPool implements ArrayPool {
    private static final int DEFAULT_SIZE = 4194304;
    @VisibleForTesting
    static final int MAX_OVER_SIZE_MULTIPLE = 8;
    private static final int SINGLE_ARRAY_MAX_SIZE_DIVISOR = 2;
    private final Map<Class<?>, ArrayAdapterInterface<?>> adapters;
    private int currentSize;
    private final GroupedLinkedMap<Key, Object> groupedMap;
    private final KeyPool keyPool;
    private final int maxSize;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> sortedSizes;

    private static final class Key implements Poolable {
        private Class<?> arrayClass;
        private final KeyPool pool;
        int size;

        Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (this.size == key.size && this.arrayClass == key.arrayClass) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            int i11 = this.size * 31;
            Class<?> cls = this.arrayClass;
            if (cls != null) {
                i10 = cls.hashCode();
            } else {
                i10 = 0;
            }
            return i11 + i10;
        }

        /* access modifiers changed from: package-private */
        public void init(int i10, Class<?> cls) {
            this.size = i10;
            this.arrayClass = cls;
        }

        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return "Key{size=" + this.size + "array=" + this.arrayClass + '}';
        }
    }

    private static final class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* access modifiers changed from: package-private */
        public Key get(int i10, Class<?> cls) {
            Key key = (Key) get();
            key.init(i10, cls);
            return key;
        }

        /* access modifiers changed from: protected */
        public Key create() {
            return new Key(this);
        }
    }

    @VisibleForTesting
    public LruArrayPool() {
        this.groupedMap = new GroupedLinkedMap<>();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = 4194304;
    }

    private void decrementArrayOfSize(int i10, Class<?> cls) {
        NavigableMap<Integer, Integer> sizesForAdapter = getSizesForAdapter(cls);
        Integer num = sizesForAdapter.get(Integer.valueOf(i10));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i10 + ", this: " + this);
        } else if (num.intValue() == 1) {
            sizesForAdapter.remove(Integer.valueOf(i10));
        } else {
            sizesForAdapter.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() - 1));
        }
    }

    private void evict() {
        evictToSize(this.maxSize);
    }

    private void evictToSize(int i10) {
        while (this.currentSize > i10) {
            Object removeLast = this.groupedMap.removeLast();
            Preconditions.checkNotNull(removeLast);
            ArrayAdapterInterface adapterFromObject = getAdapterFromObject(removeLast);
            this.currentSize -= adapterFromObject.getArrayLength(removeLast) * adapterFromObject.getElementSizeInBytes();
            decrementArrayOfSize(adapterFromObject.getArrayLength(removeLast), removeLast.getClass());
            if (Log.isLoggable(adapterFromObject.getTag(), 2)) {
                Log.v(adapterFromObject.getTag(), "evicted: " + adapterFromObject.getArrayLength(removeLast));
            }
        }
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromObject(T t10) {
        return getAdapterFromType(t10.getClass());
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromType(Class<T> cls) {
        ArrayAdapterInterface<T> arrayAdapterInterface = this.adapters.get(cls);
        if (arrayAdapterInterface == null) {
            if (cls.equals(int[].class)) {
                arrayAdapterInterface = new IntegerArrayAdapter();
            } else if (cls.equals(byte[].class)) {
                arrayAdapterInterface = new ByteArrayAdapter();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.adapters.put(cls, arrayAdapterInterface);
        }
        return arrayAdapterInterface;
    }

    @Nullable
    private <T> T getArrayForKey(Key key) {
        return this.groupedMap.get(key);
    }

    private <T> T getForKey(Key key, Class<T> cls) {
        ArrayAdapterInterface<T> adapterFromType = getAdapterFromType(cls);
        T arrayForKey = getArrayForKey(key);
        if (arrayForKey != null) {
            this.currentSize -= adapterFromType.getArrayLength(arrayForKey) * adapterFromType.getElementSizeInBytes();
            decrementArrayOfSize(adapterFromType.getArrayLength(arrayForKey), cls);
        }
        if (arrayForKey != null) {
            return arrayForKey;
        }
        if (Log.isLoggable(adapterFromType.getTag(), 2)) {
            Log.v(adapterFromType.getTag(), "Allocated " + key.size + " bytes");
        }
        return adapterFromType.newArray(key.size);
    }

    private NavigableMap<Integer, Integer> getSizesForAdapter(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.sortedSizes.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.sortedSizes.put(cls, treeMap);
        return treeMap;
    }

    private boolean isNoMoreThanHalfFull() {
        int i10 = this.currentSize;
        if (i10 == 0 || this.maxSize / i10 >= 2) {
            return true;
        }
        return false;
    }

    private boolean isSmallEnoughForReuse(int i10) {
        if (i10 <= this.maxSize / 2) {
            return true;
        }
        return false;
    }

    private boolean mayFillRequest(int i10, Integer num) {
        if (num == null || (!isNoMoreThanHalfFull() && num.intValue() > i10 * 8)) {
            return false;
        }
        return true;
    }

    public synchronized void clearMemory() {
        evictToSize(0);
    }

    public synchronized <T> T get(int i10, Class<T> cls) {
        Key key;
        try {
            Integer ceilingKey = getSizesForAdapter(cls).ceilingKey(Integer.valueOf(i10));
            if (mayFillRequest(i10, ceilingKey)) {
                key = this.keyPool.get(ceilingKey.intValue(), cls);
            } else {
                key = this.keyPool.get(i10, cls);
            }
        } catch (Throwable th) {
            throw th;
        }
        return getForKey(key, cls);
    }

    /* access modifiers changed from: package-private */
    public int getCurrentSize() {
        int i10 = 0;
        for (Class next : this.sortedSizes.keySet()) {
            for (Integer num : this.sortedSizes.get(next).keySet()) {
                i10 += num.intValue() * ((Integer) this.sortedSizes.get(next).get(num)).intValue() * getAdapterFromType(next).getElementSizeInBytes();
            }
        }
        return i10;
    }

    public synchronized <T> T getExact(int i10, Class<T> cls) {
        return getForKey(this.keyPool.get(i10, cls), cls);
    }

    @Deprecated
    public <T> void put(T t10, Class<T> cls) {
        put(t10);
    }

    public synchronized void trimMemory(int i10) {
        if (i10 >= 40) {
            try {
                clearMemory();
            } catch (Throwable th) {
                throw th;
            }
        } else if (i10 >= 20 || i10 == 15) {
            evictToSize(this.maxSize / 2);
        }
    }

    public synchronized <T> void put(T t10) {
        Class<?> cls = t10.getClass();
        ArrayAdapterInterface<?> adapterFromType = getAdapterFromType(cls);
        int arrayLength = adapterFromType.getArrayLength(t10);
        int elementSizeInBytes = adapterFromType.getElementSizeInBytes() * arrayLength;
        if (isSmallEnoughForReuse(elementSizeInBytes)) {
            Key key = this.keyPool.get(arrayLength, cls);
            this.groupedMap.put(key, t10);
            NavigableMap<Integer, Integer> sizesForAdapter = getSizesForAdapter(cls);
            Integer num = sizesForAdapter.get(Integer.valueOf(key.size));
            Integer valueOf = Integer.valueOf(key.size);
            int i10 = 1;
            if (num != null) {
                i10 = 1 + num.intValue();
            }
            sizesForAdapter.put(valueOf, Integer.valueOf(i10));
            this.currentSize += elementSizeInBytes;
            evict();
        }
    }

    public LruArrayPool(int i10) {
        this.groupedMap = new GroupedLinkedMap<>();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = i10;
    }
}
