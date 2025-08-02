package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import wb.a;

public final class SparseArrayKt$valueIterator$1 implements Iterator<T>, a {
    final /* synthetic */ SparseArray<T> $this_valueIterator;
    private int index;

    SparseArrayKt$valueIterator$1(SparseArray<T> sparseArray) {
        this.$this_valueIterator = sparseArray;
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
        SparseArray<T> sparseArray = this.$this_valueIterator;
        int i10 = this.index;
        this.index = i10 + 1;
        return sparseArray.valueAt(i10);
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i10) {
        this.index = i10;
    }
}
