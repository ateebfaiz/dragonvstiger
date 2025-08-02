package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LongSparseArray<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    public LongSparseArray() {
        this(10);
    }

    private void gc() {
        int i10 = this.mSize;
        long[] jArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != DELETED) {
                if (i12 != i11) {
                    jArr[i11] = jArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.mGarbage = false;
        this.mSize = i11;
    }

    public void append(long j10, E e10) {
        int i10 = this.mSize;
        if (i10 == 0 || j10 > this.mKeys[i10 - 1]) {
            if (this.mGarbage && i10 >= this.mKeys.length) {
                gc();
            }
            int i11 = this.mSize;
            if (i11 >= this.mKeys.length) {
                int f10 = a.f(i11 + 1);
                long[] jArr = new long[f10];
                Object[] objArr = new Object[f10];
                long[] jArr2 = this.mKeys;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.mValues;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.mKeys = jArr;
                this.mValues = objArr;
            }
            this.mKeys[i11] = j10;
            this.mValues[i11] = e10;
            this.mSize = i11 + 1;
            return;
        }
        put(j10, e10);
    }

    public void clear() {
        int i10 = this.mSize;
        Object[] objArr = this.mValues;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public boolean containsKey(long j10) {
        if (indexOfKey(j10) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(E e10) {
        if (indexOfValue(e10) >= 0) {
            return true;
        }
        return false;
    }

    @Deprecated
    public void delete(long j10) {
        remove(j10);
    }

    @Nullable
    public E get(long j10) {
        return get(j10, (Object) null);
    }

    public int indexOfKey(long j10) {
        if (this.mGarbage) {
            gc();
        }
        return a.b(this.mKeys, this.mSize, j10);
    }

    public int indexOfValue(E e10) {
        if (this.mGarbage) {
            gc();
        }
        for (int i10 = 0; i10 < this.mSize; i10++) {
            if (this.mValues[i10] == e10) {
                return i10;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public long keyAt(int i10) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i10];
    }

    public void put(long j10, E e10) {
        int b10 = a.b(this.mKeys, this.mSize, j10);
        if (b10 >= 0) {
            this.mValues[b10] = e10;
            return;
        }
        int i10 = ~b10;
        int i11 = this.mSize;
        if (i10 < i11) {
            Object[] objArr = this.mValues;
            if (objArr[i10] == DELETED) {
                this.mKeys[i10] = j10;
                objArr[i10] = e10;
                return;
            }
        }
        if (this.mGarbage && i11 >= this.mKeys.length) {
            gc();
            i10 = ~a.b(this.mKeys, this.mSize, j10);
        }
        int i12 = this.mSize;
        if (i12 >= this.mKeys.length) {
            int f10 = a.f(i12 + 1);
            long[] jArr = new long[f10];
            Object[] objArr2 = new Object[f10];
            long[] jArr2 = this.mKeys;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = jArr;
            this.mValues = objArr2;
        }
        int i13 = this.mSize;
        if (i13 - i10 != 0) {
            long[] jArr3 = this.mKeys;
            int i14 = i10 + 1;
            System.arraycopy(jArr3, i10, jArr3, i14, i13 - i10);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, i10, objArr4, i14, this.mSize - i10);
        }
        this.mKeys[i10] = j10;
        this.mValues[i10] = e10;
        this.mSize++;
    }

    public void putAll(@NonNull LongSparseArray<? extends E> longSparseArray) {
        int size = longSparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            put(longSparseArray.keyAt(i10), longSparseArray.valueAt(i10));
        }
    }

    @Nullable
    public E putIfAbsent(long j10, E e10) {
        E e11 = get(j10);
        if (e11 == null) {
            put(j10, e10);
        }
        return e11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r4 = r2.mValues;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(long r3) {
        /*
            r2 = this;
            long[] r0 = r2.mKeys
            int r1 = r2.mSize
            int r3 = androidx.collection.a.b(r0, r1, r3)
            if (r3 < 0) goto L_0x0017
            java.lang.Object[] r4 = r2.mValues
            r0 = r4[r3]
            java.lang.Object r1 = DELETED
            if (r0 == r1) goto L_0x0017
            r4[r3] = r1
            r3 = 1
            r2.mGarbage = r3
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongSparseArray.remove(long):void");
    }

    public void removeAt(int i10) {
        Object[] objArr = this.mValues;
        Object obj = objArr[i10];
        Object obj2 = DELETED;
        if (obj != obj2) {
            objArr[i10] = obj2;
            this.mGarbage = true;
        }
    }

    @Nullable
    public E replace(long j10, E e10) {
        int indexOfKey = indexOfKey(j10);
        if (indexOfKey < 0) {
            return null;
        }
        E[] eArr = this.mValues;
        E e11 = eArr[indexOfKey];
        eArr[indexOfKey] = e10;
        return e11;
    }

    public void setValueAt(int i10, E e10) {
        if (this.mGarbage) {
            gc();
        }
        this.mValues[i10] = e10;
    }

    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.mSize * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.mSize; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(keyAt(i10));
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

    public E valueAt(int i10) {
        if (this.mGarbage) {
            gc();
        }
        return this.mValues[i10];
    }

    public LongSparseArray(int i10) {
        this.mGarbage = false;
        if (i10 == 0) {
            this.mKeys = a.f14471b;
            this.mValues = a.f14472c;
            return;
        }
        int f10 = a.f(i10);
        this.mKeys = new long[f10];
        this.mValues = new Object[f10];
    }

    public LongSparseArray<E> clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.mKeys = (long[]) this.mKeys.clone();
            longSparseArray.mValues = (Object[]) this.mValues.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r3 = r2.mValues[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E get(long r3, E r5) {
        /*
            r2 = this;
            long[] r0 = r2.mKeys
            int r1 = r2.mSize
            int r3 = androidx.collection.a.b(r0, r1, r3)
            if (r3 < 0) goto L_0x0014
            java.lang.Object[] r4 = r2.mValues
            r3 = r4[r3]
            java.lang.Object r4 = DELETED
            if (r3 != r4) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            return r3
        L_0x0014:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongSparseArray.get(long, java.lang.Object):java.lang.Object");
    }

    public boolean replace(long j10, E e10, E e11) {
        int indexOfKey = indexOfKey(j10);
        if (indexOfKey < 0) {
            return false;
        }
        E e12 = this.mValues[indexOfKey];
        if (e12 != e10 && (e10 == null || !e10.equals(e12))) {
            return false;
        }
        this.mValues[indexOfKey] = e11;
        return true;
    }

    public boolean remove(long j10, Object obj) {
        int indexOfKey = indexOfKey(j10);
        if (indexOfKey < 0) {
            return false;
        }
        Object valueAt = valueAt(indexOfKey);
        if (obj != valueAt && (obj == null || !obj.equals(valueAt))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }
}
