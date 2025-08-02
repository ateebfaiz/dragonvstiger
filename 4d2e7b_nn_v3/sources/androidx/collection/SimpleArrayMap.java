package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;

public class SimpleArrayMap<K, V> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    @Nullable
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    @Nullable
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public SimpleArrayMap() {
        this.mHashes = a.f14470a;
        this.mArray = a.f14472c;
        this.mSize = 0;
    }

    private void allocArrays(int i10) {
        if (i10 == 8) {
            synchronized (SimpleArrayMap.class) {
                try {
                    Object[] objArr = mTwiceBaseCache;
                    if (objArr != null) {
                        this.mArray = objArr;
                        mTwiceBaseCache = (Object[]) objArr[0];
                        this.mHashes = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        mTwiceBaseCacheSize--;
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (i10 == 4) {
            synchronized (SimpleArrayMap.class) {
                try {
                    Object[] objArr2 = mBaseCache;
                    if (objArr2 != null) {
                        this.mArray = objArr2;
                        mBaseCache = (Object[]) objArr2[0];
                        this.mHashes = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        mBaseCacheSize--;
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        this.mHashes = new int[i10];
        this.mArray = new Object[(i10 << 1)];
    }

    private static int binarySearchHashes(int[] iArr, int i10, int i11) {
        try {
            return a.a(iArr, i10, i11);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (SimpleArrayMap.class) {
                try {
                    if (mTwiceBaseCacheSize < 10) {
                        objArr[0] = mTwiceBaseCache;
                        objArr[1] = iArr;
                        for (int i11 = (i10 << 1) - 1; i11 >= 2; i11--) {
                            objArr[i11] = null;
                        }
                        mTwiceBaseCache = objArr;
                        mTwiceBaseCacheSize++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (SimpleArrayMap.class) {
                try {
                    if (mBaseCacheSize < 10) {
                        objArr[0] = mBaseCache;
                        objArr[1] = iArr;
                        for (int i12 = (i10 << 1) - 1; i12 >= 2; i12--) {
                            objArr[i12] = null;
                        }
                        mBaseCache = objArr;
                        mBaseCacheSize++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void clear() {
        int i10 = this.mSize;
        if (i10 > 0) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            this.mHashes = a.f14470a;
            this.mArray = a.f14472c;
            this.mSize = 0;
            freeArrays(iArr, objArr, i10);
        }
        if (this.mSize > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(@Nullable Object obj) {
        if (indexOfKey(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        if (indexOfValue(obj) >= 0) {
            return true;
        }
        return false;
    }

    public void ensureCapacity(int i10) {
        int i11 = this.mSize;
        int[] iArr = this.mHashes;
        if (iArr.length < i10) {
            Object[] objArr = this.mArray;
            allocArrays(i10);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i11);
                System.arraycopy(objArr, 0, this.mArray, 0, i11 << 1);
            }
            freeArrays(iArr, objArr, i11);
        }
        if (this.mSize != i11) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            int i10 = 0;
            while (i10 < this.mSize) {
                try {
                    Object keyAt = keyAt(i10);
                    Object valueAt = valueAt(i10);
                    Object obj2 = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
                        return false;
                    }
                    i10++;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i11 = 0;
            while (i11 < this.mSize) {
                try {
                    Object keyAt2 = keyAt(i11);
                    Object valueAt2 = valueAt(i11);
                    Object obj3 = map.get(keyAt2);
                    if (valueAt2 == null) {
                        if (obj3 != null || !map.containsKey(keyAt2)) {
                            return false;
                        }
                    } else if (!valueAt2.equals(obj3)) {
                        return false;
                    }
                    i11++;
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    @Nullable
    public V get(Object obj) {
        return getOrDefault(obj, (Object) null);
    }

    public V getOrDefault(Object obj, V v10) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return this.mArray[(indexOfKey << 1) + 1];
        }
        return v10;
    }

    public int hashCode() {
        int i10;
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i11 = this.mSize;
        int i12 = 1;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i11) {
            Object obj = objArr[i12];
            int i15 = iArr[i13];
            if (obj == null) {
                i10 = 0;
            } else {
                i10 = obj.hashCode();
            }
            i14 += i10 ^ i15;
            i13++;
            i12 += 2;
        }
        return i14;
    }

    /* access modifiers changed from: package-private */
    public int indexOf(Object obj, int i10) {
        int i11 = this.mSize;
        if (i11 == 0) {
            return -1;
        }
        int binarySearchHashes = binarySearchHashes(this.mHashes, i11, i10);
        if (binarySearchHashes < 0 || obj.equals(this.mArray[binarySearchHashes << 1])) {
            return binarySearchHashes;
        }
        int i12 = binarySearchHashes + 1;
        while (i12 < i11 && this.mHashes[i12] == i10) {
            if (obj.equals(this.mArray[i12 << 1])) {
                return i12;
            }
            i12++;
        }
        int i13 = binarySearchHashes - 1;
        while (i13 >= 0 && this.mHashes[i13] == i10) {
            if (obj.equals(this.mArray[i13 << 1])) {
                return i13;
            }
            i13--;
        }
        return ~i12;
    }

    public int indexOfKey(@Nullable Object obj) {
        if (obj == null) {
            return indexOfNull();
        }
        return indexOf(obj, obj.hashCode());
    }

    /* access modifiers changed from: package-private */
    public int indexOfNull() {
        int i10 = this.mSize;
        if (i10 == 0) {
            return -1;
        }
        int binarySearchHashes = binarySearchHashes(this.mHashes, i10, 0);
        if (binarySearchHashes < 0 || this.mArray[binarySearchHashes << 1] == null) {
            return binarySearchHashes;
        }
        int i11 = binarySearchHashes + 1;
        while (i11 < i10 && this.mHashes[i11] == 0) {
            if (this.mArray[i11 << 1] == null) {
                return i11;
            }
            i11++;
        }
        int i12 = binarySearchHashes - 1;
        while (i12 >= 0 && this.mHashes[i12] == 0) {
            if (this.mArray[i12 << 1] == null) {
                return i12;
            }
            i12--;
        }
        return ~i11;
    }

    /* access modifiers changed from: package-private */
    public int indexOfValue(Object obj) {
        int i10 = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (obj == null) {
            for (int i11 = 1; i11 < i10; i11 += 2) {
                if (objArr[i11] == null) {
                    return i11 >> 1;
                }
            }
            return -1;
        }
        for (int i12 = 1; i12 < i10; i12 += 2) {
            if (obj.equals(objArr[i12])) {
                return i12 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.mSize <= 0) {
            return true;
        }
        return false;
    }

    public K keyAt(int i10) {
        return this.mArray[i10 << 1];
    }

    @Nullable
    public V put(K k10, V v10) {
        int i10;
        int i11;
        int i12 = this.mSize;
        if (k10 == null) {
            i11 = indexOfNull();
            i10 = 0;
        } else {
            int hashCode = k10.hashCode();
            i10 = hashCode;
            i11 = indexOf(k10, hashCode);
        }
        if (i11 >= 0) {
            int i13 = (i11 << 1) + 1;
            V[] vArr = this.mArray;
            V v11 = vArr[i13];
            vArr[i13] = v10;
            return v11;
        }
        int i14 = ~i11;
        int[] iArr = this.mHashes;
        if (i12 >= iArr.length) {
            int i15 = 8;
            if (i12 >= 8) {
                i15 = (i12 >> 1) + i12;
            } else if (i12 < 4) {
                i15 = 4;
            }
            Object[] objArr = this.mArray;
            allocArrays(i15);
            if (i12 == this.mSize) {
                int[] iArr2 = this.mHashes;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
                }
                freeArrays(iArr, objArr, i12);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i14 < i12) {
            int[] iArr3 = this.mHashes;
            int i16 = i14 + 1;
            System.arraycopy(iArr3, i14, iArr3, i16, i12 - i14);
            Object[] objArr2 = this.mArray;
            System.arraycopy(objArr2, i14 << 1, objArr2, i16 << 1, (this.mSize - i14) << 1);
        }
        int i17 = this.mSize;
        if (i12 == i17) {
            int[] iArr4 = this.mHashes;
            if (i14 < iArr4.length) {
                iArr4[i14] = i10;
                Object[] objArr3 = this.mArray;
                int i18 = i14 << 1;
                objArr3[i18] = k10;
                objArr3[i18 + 1] = v10;
                this.mSize = i17 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(@NonNull SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i10 = simpleArrayMap.mSize;
        ensureCapacity(this.mSize + i10);
        if (this.mSize != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                put(simpleArrayMap.keyAt(i11), simpleArrayMap.valueAt(i11));
            }
        } else if (i10 > 0) {
            System.arraycopy(simpleArrayMap.mHashes, 0, this.mHashes, 0, i10);
            System.arraycopy(simpleArrayMap.mArray, 0, this.mArray, 0, i10 << 1);
            this.mSize = i10;
        }
    }

    @Nullable
    public V putIfAbsent(K k10, V v10) {
        V v11 = get(k10);
        if (v11 == null) {
            return put(k10, v10);
        }
        return v11;
    }

    @Nullable
    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int i10) {
        V[] vArr = this.mArray;
        int i11 = i10 << 1;
        V v10 = vArr[i11 + 1];
        int i12 = this.mSize;
        int i13 = 0;
        if (i12 <= 1) {
            freeArrays(this.mHashes, vArr, i12);
            this.mHashes = a.f14470a;
            this.mArray = a.f14472c;
        } else {
            int i14 = i12 - 1;
            int[] iArr = this.mHashes;
            int i15 = 8;
            if (iArr.length <= 8 || i12 >= iArr.length / 3) {
                if (i10 < i14) {
                    int i16 = i10 + 1;
                    int i17 = i14 - i10;
                    System.arraycopy(iArr, i16, iArr, i10, i17);
                    Object[] objArr = this.mArray;
                    System.arraycopy(objArr, i16 << 1, objArr, i11, i17 << 1);
                }
                Object[] objArr2 = this.mArray;
                int i18 = i14 << 1;
                objArr2[i18] = null;
                objArr2[i18 + 1] = null;
            } else {
                if (i12 > 8) {
                    i15 = i12 + (i12 >> 1);
                }
                allocArrays(i15);
                if (i12 == this.mSize) {
                    if (i10 > 0) {
                        System.arraycopy(iArr, 0, this.mHashes, 0, i10);
                        System.arraycopy(vArr, 0, this.mArray, 0, i11);
                    }
                    if (i10 < i14) {
                        int i19 = i10 + 1;
                        int i20 = i14 - i10;
                        System.arraycopy(iArr, i19, this.mHashes, i10, i20);
                        System.arraycopy(vArr, i19 << 1, this.mArray, i11, i20 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            i13 = i14;
        }
        if (i12 == this.mSize) {
            this.mSize = i13;
            return v10;
        }
        throw new ConcurrentModificationException();
    }

    @Nullable
    public V replace(K k10, V v10) {
        int indexOfKey = indexOfKey(k10);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, v10);
        }
        return null;
    }

    public V setValueAt(int i10, V v10) {
        int i11 = (i10 << 1) + 1;
        V[] vArr = this.mArray;
        V v11 = vArr[i11];
        vArr[i11] = v10;
        return v11;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.mSize * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.mSize; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            Object keyAt = keyAt(i10);
            if (keyAt != this) {
                sb2.append(keyAt);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            Object valueAt = valueAt(i10);
            if (valueAt != this) {
                sb2.append(valueAt);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public V valueAt(int i10) {
        return this.mArray[(i10 << 1) + 1];
    }

    public boolean remove(Object obj, Object obj2) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey < 0) {
            return false;
        }
        Object valueAt = valueAt(indexOfKey);
        if (obj2 != valueAt && (obj2 == null || !obj2.equals(valueAt))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public boolean replace(K k10, V v10, V v11) {
        int indexOfKey = indexOfKey(k10);
        if (indexOfKey < 0) {
            return false;
        }
        V valueAt = valueAt(indexOfKey);
        if (valueAt != v10 && (v10 == null || !v10.equals(valueAt))) {
            return false;
        }
        setValueAt(indexOfKey, v11);
        return true;
    }

    public SimpleArrayMap(int i10) {
        if (i10 == 0) {
            this.mHashes = a.f14470a;
            this.mArray = a.f14472c;
        } else {
            allocArrays(i10);
        }
        this.mSize = 0;
    }

    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }
}
