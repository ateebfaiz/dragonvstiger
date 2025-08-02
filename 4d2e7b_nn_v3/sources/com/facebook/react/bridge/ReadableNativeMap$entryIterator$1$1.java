package com.facebook.react.bridge;

import java.util.Iterator;
import java.util.Map;
import wb.a;

public final class ReadableNativeMap$entryIterator$1$1 implements Iterator<Map.Entry<? extends String, ? extends Object>>, a {
    final /* synthetic */ String[] $iteratorKeys;
    final /* synthetic */ Object[] $iteratorValues;
    private int currentIndex;

    ReadableNativeMap$entryIterator$1$1(String[] strArr, Object[] objArr) {
        this.$iteratorKeys = strArr;
        this.$iteratorValues = objArr;
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public boolean hasNext() {
        if (this.currentIndex < this.$iteratorKeys.length) {
            return true;
        }
        return false;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setCurrentIndex(int i10) {
        this.currentIndex = i10;
    }

    public Map.Entry<String, Object> next() {
        int i10 = this.currentIndex;
        this.currentIndex = i10 + 1;
        return new ReadableNativeMap$entryIterator$1$1$next$1(this.$iteratorKeys, i10, this.$iteratorValues);
    }
}
