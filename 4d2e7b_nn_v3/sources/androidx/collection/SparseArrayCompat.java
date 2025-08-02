package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SparseArrayCompat<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    public SparseArrayCompat() {
        this(10);
    }

    private void gc() {
        int i10 = this.mSize;
        int[] iArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != DELETED) {
                if (i12 != i11) {
                    iArr[i11] = iArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.mGarbage = false;
        this.mSize = i11;
    }

    public void append(int i10, E e10) {
        int i11 = this.mSize;
        if (i11 == 0 || i10 > this.mKeys[i11 - 1]) {
            if (this.mGarbage && i11 >= this.mKeys.length) {
                gc();
            }
            int i12 = this.mSize;
            if (i12 >= this.mKeys.length) {
                int e11 = a.e(i12 + 1);
                int[] iArr = new int[e11];
                Object[] objArr = new Object[e11];
                int[] iArr2 = this.mKeys;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.mValues;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.mKeys = iArr;
                this.mValues = objArr;
            }
            this.mKeys[i12] = i10;
            this.mValues[i12] = e10;
            this.mSize = i12 + 1;
            return;
        }
        put(i10, e10);
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

    public boolean containsKey(int i10) {
        if (indexOfKey(i10) >= 0) {
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
    public void delete(int i10) {
        remove(i10);
    }

    @Nullable
    public E get(int i10) {
        return get(i10, (Object) null);
    }

    public int indexOfKey(int i10) {
        if (this.mGarbage) {
            gc();
        }
        return a.a(this.mKeys, this.mSize, i10);
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

    public int keyAt(int i10) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i10];
    }

    public void put(int i10, E e10) {
        int a10 = a.a(this.mKeys, this.mSize, i10);
        if (a10 >= 0) {
            this.mValues[a10] = e10;
            return;
        }
        int i11 = ~a10;
        int i12 = this.mSize;
        if (i11 < i12) {
            Object[] objArr = this.mValues;
            if (objArr[i11] == DELETED) {
                this.mKeys[i11] = i10;
                objArr[i11] = e10;
                return;
            }
        }
        if (this.mGarbage && i12 >= this.mKeys.length) {
            gc();
            i11 = ~a.a(this.mKeys, this.mSize, i10);
        }
        int i13 = this.mSize;
        if (i13 >= this.mKeys.length) {
            int e11 = a.e(i13 + 1);
            int[] iArr = new int[e11];
            Object[] objArr2 = new Object[e11];
            int[] iArr2 = this.mKeys;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = iArr;
            this.mValues = objArr2;
        }
        int i14 = this.mSize;
        if (i14 - i11 != 0) {
            int[] iArr3 = this.mKeys;
            int i15 = i11 + 1;
            System.arraycopy(iArr3, i11, iArr3, i15, i14 - i11);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, i11, objArr4, i15, this.mSize - i11);
        }
        this.mKeys[i11] = i10;
        this.mValues[i11] = e10;
        this.mSize++;
    }

    public void putAll(@NonNull SparseArrayCompat<? extends E> sparseArrayCompat) {
        int size = sparseArrayCompat.size();
        for (int i10 = 0; i10 < size; i10++) {
            put(sparseArrayCompat.keyAt(i10), sparseArrayCompat.valueAt(i10));
        }
    }

    @Nullable
    public E putIfAbsent(int i10, E e10) {
        E e11 = get(i10);
        if (e11 == null) {
            put(i10, e10);
        }
        return e11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r3.mValues;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(int r4) {
        /*
            r3 = this;
            int[] r0 = r3.mKeys
            int r1 = r3.mSize
            int r4 = androidx.collection.a.a(r0, r1, r4)
            if (r4 < 0) goto L_0x0017
            java.lang.Object[] r0 = r3.mValues
            r1 = r0[r4]
            java.lang.Object r2 = DELETED
            if (r1 == r2) goto L_0x0017
            r0[r4] = r2
            r4 = 1
            r3.mGarbage = r4
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.SparseArrayCompat.remove(int):void");
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

    public void removeAtRange(int i10, int i11) {
        int min = Math.min(this.mSize, i11 + i10);
        while (i10 < min) {
            removeAt(i10);
            i10++;
        }
    }

    @Nullable
    public E replace(int i10, E e10) {
        int indexOfKey = indexOfKey(i10);
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

    public SparseArrayCompat(int i10) {
        this.mGarbage = false;
        if (i10 == 0) {
            this.mKeys = a.f14470a;
            this.mValues = a.f14472c;
            return;
        }
        int e10 = a.e(i10);
        this.mKeys = new int[e10];
        this.mValues = new Object[e10];
    }

    public SparseArrayCompat<E> clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.mKeys = (int[]) this.mKeys.clone();
            sparseArrayCompat.mValues = (Object[]) this.mValues.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r3 = r2.mValues[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E get(int r3, E r4) {
        /*
            r2 = this;
            int[] r0 = r2.mKeys
            int r1 = r2.mSize
            int r3 = androidx.collection.a.a(r0, r1, r3)
            if (r3 < 0) goto L_0x0014
            java.lang.Object[] r0 = r2.mValues
            r3 = r0[r3]
            java.lang.Object r0 = DELETED
            if (r3 != r0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            return r3
        L_0x0014:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.SparseArrayCompat.get(int, java.lang.Object):java.lang.Object");
    }

    public boolean replace(int i10, E e10, E e11) {
        int indexOfKey = indexOfKey(i10);
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

    public boolean remove(int i10, Object obj) {
        int indexOfKey = indexOfKey(i10);
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
