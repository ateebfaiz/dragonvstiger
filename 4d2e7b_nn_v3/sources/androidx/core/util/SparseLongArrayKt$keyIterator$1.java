package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.collections.g0;

public final class SparseLongArrayKt$keyIterator$1 extends g0 {
    final /* synthetic */ SparseLongArray $this_keyIterator;
    private int index;

    SparseLongArrayKt$keyIterator$1(SparseLongArray sparseLongArray) {
        this.$this_keyIterator = sparseLongArray;
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

    public int nextInt() {
        SparseLongArray sparseLongArray = this.$this_keyIterator;
        int i10 = this.index;
        this.index = i10 + 1;
        return sparseLongArray.keyAt(i10);
    }

    public final void setIndex(int i10) {
        this.index = i10;
    }
}
