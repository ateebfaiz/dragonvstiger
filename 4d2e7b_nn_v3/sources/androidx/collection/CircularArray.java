package androidx.collection;

public final class CircularArray<E> {
    private int mCapacityBitmask;
    private E[] mElements;
    private int mHead;
    private int mTail;

    public CircularArray() {
        this(8);
    }

    private void doubleCapacity() {
        E[] eArr = this.mElements;
        int length = eArr.length;
        int i10 = this.mHead;
        int i11 = length - i10;
        int i12 = length << 1;
        if (i12 >= 0) {
            E[] eArr2 = new Object[i12];
            System.arraycopy(eArr, i10, eArr2, 0, i11);
            System.arraycopy(this.mElements, 0, eArr2, i11, this.mHead);
            this.mElements = eArr2;
            this.mHead = 0;
            this.mTail = length;
            this.mCapacityBitmask = i12 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void addFirst(E e10) {
        int i10 = (this.mHead - 1) & this.mCapacityBitmask;
        this.mHead = i10;
        this.mElements[i10] = e10;
        if (i10 == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(E e10) {
        E[] eArr = this.mElements;
        int i10 = this.mTail;
        eArr[i10] = e10;
        int i11 = this.mCapacityBitmask & (i10 + 1);
        this.mTail = i11;
        if (i11 == this.mHead) {
            doubleCapacity();
        }
    }

    public void clear() {
        removeFromStart(size());
    }

    public E get(int i10) {
        if (i10 < 0 || i10 >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.mElements[this.mCapacityBitmask & (this.mHead + i10)];
    }

    public E getFirst() {
        int i10 = this.mHead;
        if (i10 != this.mTail) {
            return this.mElements[i10];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getLast() {
        int i10 = this.mHead;
        int i11 = this.mTail;
        if (i10 != i11) {
            return this.mElements[(i11 - 1) & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        if (this.mHead == this.mTail) {
            return true;
        }
        return false;
    }

    public E popFirst() {
        int i10 = this.mHead;
        if (i10 != this.mTail) {
            E[] eArr = this.mElements;
            E e10 = eArr[i10];
            eArr[i10] = null;
            this.mHead = (i10 + 1) & this.mCapacityBitmask;
            return e10;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E popLast() {
        int i10 = this.mHead;
        int i11 = this.mTail;
        if (i10 != i11) {
            int i12 = this.mCapacityBitmask & (i11 - 1);
            E[] eArr = this.mElements;
            E e10 = eArr[i12];
            eArr[i12] = null;
            this.mTail = i12;
            return e10;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int i10) {
        int i11;
        int i12;
        if (i10 > 0) {
            if (i10 <= size()) {
                int i13 = this.mTail;
                if (i10 < i13) {
                    i11 = i13 - i10;
                } else {
                    i11 = 0;
                }
                int i14 = i11;
                while (true) {
                    i12 = this.mTail;
                    if (i14 >= i12) {
                        break;
                    }
                    this.mElements[i14] = null;
                    i14++;
                }
                int i15 = i12 - i11;
                int i16 = i10 - i15;
                this.mTail = i12 - i15;
                if (i16 > 0) {
                    int length = this.mElements.length;
                    this.mTail = length;
                    int i17 = length - i16;
                    for (int i18 = i17; i18 < this.mTail; i18++) {
                        this.mElements[i18] = null;
                    }
                    this.mTail = i17;
                    return;
                }
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void removeFromStart(int i10) {
        if (i10 > 0) {
            if (i10 <= size()) {
                int length = this.mElements.length;
                int i11 = this.mHead;
                if (i10 < length - i11) {
                    length = i11 + i10;
                }
                while (i11 < length) {
                    this.mElements[i11] = null;
                    i11++;
                }
                int i12 = this.mHead;
                int i13 = length - i12;
                int i14 = i10 - i13;
                this.mHead = this.mCapacityBitmask & (i12 + i13);
                if (i14 > 0) {
                    for (int i15 = 0; i15 < i14; i15++) {
                        this.mElements[i15] = null;
                    }
                    this.mHead = i14;
                    return;
                }
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }

    public CircularArray(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        } else if (i10 <= 1073741824) {
            i10 = Integer.bitCount(i10) != 1 ? Integer.highestOneBit(i10 - 1) << 1 : i10;
            this.mCapacityBitmask = i10 - 1;
            this.mElements = new Object[i10];
        } else {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
    }
}
