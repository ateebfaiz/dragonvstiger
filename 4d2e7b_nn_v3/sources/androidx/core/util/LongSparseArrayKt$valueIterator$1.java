package androidx.core.util;

import android.util.LongSparseArray;
import java.util.Iterator;
import wb.a;

public final class LongSparseArrayKt$valueIterator$1 implements Iterator<T>, a {
    final /* synthetic */ LongSparseArray<T> $this_valueIterator;
    private int index;

    LongSparseArrayKt$valueIterator$1(LongSparseArray<T> longSparseArray) {
        this.$this_valueIterator = longSparseArray;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        if (this.index < this.$this_valueIterator.size()) {
            return true;
        }
        return false;
    }

    public T next() {
        LongSparseArray<T> longSparseArray = this.$this_valueIterator;
        int i10 = this.index;
        this.index = i10 + 1;
        return longSparseArray.valueAt(i10);
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i10) {
        this.index = i10;
    }
}
