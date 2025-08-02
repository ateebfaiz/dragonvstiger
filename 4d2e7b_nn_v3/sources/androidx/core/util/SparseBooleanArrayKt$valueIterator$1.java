package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.collections.p;

public final class SparseBooleanArrayKt$valueIterator$1 extends p {
    final /* synthetic */ SparseBooleanArray $this_valueIterator;
    private int index;

    SparseBooleanArrayKt$valueIterator$1(SparseBooleanArray sparseBooleanArray) {
        this.$this_valueIterator = sparseBooleanArray;
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

    public boolean nextBoolean() {
        SparseBooleanArray sparseBooleanArray = this.$this_valueIterator;
        int i10 = this.index;
        this.index = i10 + 1;
        return sparseBooleanArray.valueAt(i10);
    }

    public final void setIndex(int i10) {
        this.index = i10;
    }
}
