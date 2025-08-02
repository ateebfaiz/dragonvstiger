package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.collections.h0;

public final class SparseLongArrayKt$valueIterator$1 extends h0 {
    final /* synthetic */ SparseLongArray $this_valueIterator;
    private int index;

    SparseLongArrayKt$valueIterator$1(SparseLongArray sparseLongArray) {
        this.$this_valueIterator = sparseLongArray;
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

    public long nextLong() {
        SparseLongArray sparseLongArray = this.$this_valueIterator;
        int i10 = this.index;
        this.index = i10 + 1;
        return sparseLongArray.valueAt(i10);
    }

    public final void setIndex(int i10) {
        this.index = i10;
    }
}
