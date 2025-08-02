package androidx.core.util;

import android.util.SparseArray;
import kotlin.collections.g0;

public final class SparseArrayKt$keyIterator$1 extends g0 {
    final /* synthetic */ SparseArray<T> $this_keyIterator;
    private int index;

    SparseArrayKt$keyIterator$1(SparseArray<T> sparseArray) {
        this.$this_keyIterator = sparseArray;
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
        SparseArray<T> sparseArray = this.$this_keyIterator;
        int i10 = this.index;
        this.index = i10 + 1;
        return sparseArray.keyAt(i10);
    }

    public final void setIndex(int i10) {
        this.index = i10;
    }
}
