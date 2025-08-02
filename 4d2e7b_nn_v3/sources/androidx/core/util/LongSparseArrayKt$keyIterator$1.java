package androidx.core.util;

import android.util.LongSparseArray;
import kotlin.collections.h0;

public final class LongSparseArrayKt$keyIterator$1 extends h0 {
    final /* synthetic */ LongSparseArray<T> $this_keyIterator;
    private int index;

    LongSparseArrayKt$keyIterator$1(LongSparseArray<T> longSparseArray) {
        this.$this_keyIterator = longSparseArray;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        if (this.index < this.$this_keyIterator.size()) {
            return true;
        }
        return false;
    }

    public long nextLong() {
        LongSparseArray<T> longSparseArray = this.$this_keyIterator;
        int i10 = this.index;
        this.index = i10 + 1;
        return longSparseArray.keyAt(i10);
    }

    public final void setIndex(int i10) {
        this.index = i10;
    }
}
