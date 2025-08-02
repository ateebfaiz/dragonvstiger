package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.collections.g0;

public final class SparseIntArrayKt$keyIterator$1 extends g0 {
    final /* synthetic */ SparseIntArray $this_keyIterator;
    private int index;

    SparseIntArrayKt$keyIterator$1(SparseIntArray sparseIntArray) {
        this.$this_keyIterator = sparseIntArray;
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
        SparseIntArray sparseIntArray = this.$this_keyIterator;
        int i10 = this.index;
        this.index = i10 + 1;
        return sparseIntArray.keyAt(i10);
    }

    public final void setIndex(int i10) {
        this.index = i10;
    }
}
