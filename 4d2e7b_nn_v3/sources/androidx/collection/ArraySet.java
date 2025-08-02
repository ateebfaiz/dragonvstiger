package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ArraySet<E> implements Collection<E>, Set<E> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final int[] INT = new int[0];
    private static final Object[] OBJECT = new Object[0];
    private static final String TAG = "ArraySet";
    @Nullable
    private static Object[] sBaseCache;
    private static int sBaseCacheSize;
    @Nullable
    private static Object[] sTwiceBaseCache;
    private static int sTwiceBaseCacheSize;
    Object[] mArray;
    private b mCollections;
    private int[] mHashes;
    int mSize;

    class a extends b {
        a() {
        }

        /* access modifiers changed from: protected */
        public void a() {
            ArraySet.this.clear();
        }

        /* access modifiers changed from: protected */
        public Object b(int i10, int i11) {
            return ArraySet.this.mArray[i10];
        }

        /* access modifiers changed from: protected */
        public Map c() {
            throw new UnsupportedOperationException("not a map");
        }

        /* access modifiers changed from: protected */
        public int d() {
            return ArraySet.this.mSize;
        }

        /* access modifiers changed from: protected */
        public int e(Object obj) {
            return ArraySet.this.indexOf(obj);
        }

        /* access modifiers changed from: protected */
        public int f(Object obj) {
            return ArraySet.this.indexOf(obj);
        }

        /* access modifiers changed from: protected */
        public void g(Object obj, Object obj2) {
            ArraySet.this.add(obj);
        }

        /* access modifiers changed from: protected */
        public void h(int i10) {
            ArraySet.this.removeAt(i10);
        }

        /* access modifiers changed from: protected */
        public Object i(int i10, Object obj) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public ArraySet() {
        this(0);
    }

    private void allocArrays(int i10) {
        if (i10 == 8) {
            synchronized (ArraySet.class) {
                try {
                    Object[] objArr = sTwiceBaseCache;
                    if (objArr != null) {
                        this.mArray = objArr;
                        sTwiceBaseCache = (Object[]) objArr[0];
                        this.mHashes = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        sTwiceBaseCacheSize--;
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (i10 == 4) {
            synchronized (ArraySet.class) {
                try {
                    Object[] objArr2 = sBaseCache;
                    if (objArr2 != null) {
                        this.mArray = objArr2;
                        sBaseCache = (Object[]) objArr2[0];
                        this.mHashes = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        sBaseCacheSize--;
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        this.mHashes = new int[i10];
        this.mArray = new Object[i10];
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                try {
                    if (sTwiceBaseCacheSize < 10) {
                        objArr[0] = sTwiceBaseCache;
                        objArr[1] = iArr;
                        for (int i11 = i10 - 1; i11 >= 2; i11--) {
                            objArr[i11] = null;
                        }
                        sTwiceBaseCache = objArr;
                        sTwiceBaseCacheSize++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                try {
                    if (sBaseCacheSize < 10) {
                        objArr[0] = sBaseCache;
                        objArr[1] = iArr;
                        for (int i12 = i10 - 1; i12 >= 2; i12--) {
                            objArr[i12] = null;
                        }
                        sBaseCache = objArr;
                        sBaseCacheSize++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private b getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new a();
        }
        return this.mCollections;
    }

    private int indexOf(Object obj, int i10) {
        int i11 = this.mSize;
        if (i11 == 0) {
            return -1;
        }
        int a10 = a.a(this.mHashes, i11, i10);
        if (a10 < 0 || obj.equals(this.mArray[a10])) {
            return a10;
        }
        int i12 = a10 + 1;
        while (i12 < i11 && this.mHashes[i12] == i10) {
            if (obj.equals(this.mArray[i12])) {
                return i12;
            }
            i12++;
        }
        int i13 = a10 - 1;
        while (i13 >= 0 && this.mHashes[i13] == i10) {
            if (obj.equals(this.mArray[i13])) {
                return i13;
            }
            i13--;
        }
        return ~i12;
    }

    private int indexOfNull() {
        int i10 = this.mSize;
        if (i10 == 0) {
            return -1;
        }
        int a10 = a.a(this.mHashes, i10, 0);
        if (a10 < 0 || this.mArray[a10] == null) {
            return a10;
        }
        int i11 = a10 + 1;
        while (i11 < i10 && this.mHashes[i11] == 0) {
            if (this.mArray[i11] == null) {
                return i11;
            }
            i11++;
        }
        int i12 = a10 - 1;
        while (i12 >= 0 && this.mHashes[i12] == 0) {
            if (this.mArray[i12] == null) {
                return i12;
            }
            i12--;
        }
        return ~i11;
    }

    public boolean add(@Nullable E e10) {
        int i10;
        int i11;
        if (e10 == null) {
            i11 = indexOfNull();
            i10 = 0;
        } else {
            int hashCode = e10.hashCode();
            i10 = hashCode;
            i11 = indexOf(e10, hashCode);
        }
        if (i11 >= 0) {
            return false;
        }
        int i12 = ~i11;
        int i13 = this.mSize;
        int[] iArr = this.mHashes;
        if (i13 >= iArr.length) {
            int i14 = 8;
            if (i13 >= 8) {
                i14 = (i13 >> 1) + i13;
            } else if (i13 < 4) {
                i14 = 4;
            }
            Object[] objArr = this.mArray;
            allocArrays(i14);
            int[] iArr2 = this.mHashes;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        int i15 = this.mSize;
        if (i12 < i15) {
            int[] iArr3 = this.mHashes;
            int i16 = i12 + 1;
            System.arraycopy(iArr3, i12, iArr3, i16, i15 - i12);
            Object[] objArr2 = this.mArray;
            System.arraycopy(objArr2, i12, objArr2, i16, this.mSize - i12);
        }
        this.mHashes[i12] = i10;
        this.mArray[i12] = e10;
        this.mSize++;
        return true;
    }

    public void addAll(@NonNull ArraySet<? extends E> arraySet) {
        int i10 = arraySet.mSize;
        ensureCapacity(this.mSize + i10);
        if (this.mSize != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                add(arraySet.valueAt(i11));
            }
        } else if (i10 > 0) {
            System.arraycopy(arraySet.mHashes, 0, this.mHashes, 0, i10);
            System.arraycopy(arraySet.mArray, 0, this.mArray, 0, i10);
            this.mSize = i10;
        }
    }

    public void clear() {
        int i10 = this.mSize;
        if (i10 != 0) {
            freeArrays(this.mHashes, this.mArray, i10);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        }
    }

    public boolean contains(@Nullable Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public void ensureCapacity(int i10) {
        int[] iArr = this.mHashes;
        if (iArr.length < i10) {
            Object[] objArr = this.mArray;
            allocArrays(i10);
            int i11 = this.mSize;
            if (i11 > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i11);
                System.arraycopy(objArr, 0, this.mArray, 0, this.mSize);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i10 = 0;
            while (i10 < this.mSize) {
                try {
                    if (!set.contains(valueAt(i10))) {
                        return false;
                    }
                    i10++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.mHashes;
        int i10 = this.mSize;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += iArr[i12];
        }
        return i11;
    }

    public boolean isEmpty() {
        if (this.mSize <= 0) {
            return true;
        }
        return false;
    }

    public Iterator<E> iterator() {
        return getCollection().m().iterator();
    }

    public boolean remove(@Nullable Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public boolean removeAll(@NonNull ArraySet<? extends E> arraySet) {
        int i10 = arraySet.mSize;
        int i11 = this.mSize;
        for (int i12 = 0; i12 < i10; i12++) {
            remove(arraySet.valueAt(i12));
        }
        if (i11 != this.mSize) {
            return true;
        }
        return false;
    }

    public E removeAt(int i10) {
        E[] eArr = this.mArray;
        E e10 = eArr[i10];
        int i11 = this.mSize;
        if (i11 <= 1) {
            freeArrays(this.mHashes, eArr, i11);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        } else {
            int[] iArr = this.mHashes;
            int i12 = 8;
            if (iArr.length <= 8 || i11 >= iArr.length / 3) {
                int i13 = i11 - 1;
                this.mSize = i13;
                if (i10 < i13) {
                    int i14 = i10 + 1;
                    System.arraycopy(iArr, i14, iArr, i10, i13 - i10);
                    Object[] objArr = this.mArray;
                    System.arraycopy(objArr, i14, objArr, i10, this.mSize - i10);
                }
                this.mArray[this.mSize] = null;
            } else {
                if (i11 > 8) {
                    i12 = i11 + (i11 >> 1);
                }
                allocArrays(i12);
                this.mSize--;
                if (i10 > 0) {
                    System.arraycopy(iArr, 0, this.mHashes, 0, i10);
                    System.arraycopy(eArr, 0, this.mArray, 0, i10);
                }
                int i15 = this.mSize;
                if (i10 < i15) {
                    int i16 = i10 + 1;
                    System.arraycopy(iArr, i16, this.mHashes, i10, i15 - i10);
                    System.arraycopy(eArr, i16, this.mArray, i10, this.mSize - i10);
                }
            }
        }
        return e10;
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        boolean z10 = false;
        for (int i10 = this.mSize - 1; i10 >= 0; i10--) {
            if (!collection.contains(this.mArray[i10])) {
                removeAt(i10);
                z10 = true;
            }
        }
        return z10;
    }

    public int size() {
        return this.mSize;
    }

    @NonNull
    public Object[] toArray() {
        int i10 = this.mSize;
        Object[] objArr = new Object[i10];
        System.arraycopy(this.mArray, 0, objArr, 0, i10);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.mSize * 14);
        sb2.append('{');
        for (int i10 = 0; i10 < this.mSize; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            Object valueAt = valueAt(i10);
            if (valueAt != this) {
                sb2.append(valueAt);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    @Nullable
    public E valueAt(int i10) {
        return this.mArray[i10];
    }

    public ArraySet(int i10) {
        if (i10 == 0) {
            this.mHashes = INT;
            this.mArray = OBJECT;
        } else {
            allocArrays(i10);
        }
        this.mSize = 0;
    }

    @NonNull
    public <T> T[] toArray(@NonNull T[] tArr) {
        if (tArr.length < this.mSize) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.mSize);
        }
        System.arraycopy(this.mArray, 0, tArr, 0, this.mSize);
        int length = tArr.length;
        int i10 = this.mSize;
        if (length > i10) {
            tArr[i10] = null;
        }
        return tArr;
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        boolean z10 = false;
        for (Object remove : collection) {
            z10 |= remove(remove);
        }
        return z10;
    }

    public ArraySet(@Nullable ArraySet<E> arraySet) {
        this();
        if (arraySet != null) {
            addAll(arraySet);
        }
    }

    public boolean addAll(@NonNull Collection<? extends E> collection) {
        ensureCapacity(this.mSize + collection.size());
        boolean z10 = false;
        for (Object add : collection) {
            z10 |= add(add);
        }
        return z10;
    }

    public int indexOf(@Nullable Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    public ArraySet(@Nullable Collection<E> collection) {
        this();
        if (collection != null) {
            addAll(collection);
        }
    }
}
