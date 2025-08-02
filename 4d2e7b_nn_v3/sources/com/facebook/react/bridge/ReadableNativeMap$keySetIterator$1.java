package com.facebook.react.bridge;

public final class ReadableNativeMap$keySetIterator$1 implements ReadableMapKeySetIterator {
    final /* synthetic */ String[] $iteratorKeys;
    private int currentIndex;

    ReadableNativeMap$keySetIterator$1(String[] strArr) {
        this.$iteratorKeys = strArr;
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public boolean hasNextKey() {
        if (this.currentIndex < this.$iteratorKeys.length) {
            return true;
        }
        return false;
    }

    public String nextKey() {
        String[] strArr = this.$iteratorKeys;
        int i10 = this.currentIndex;
        this.currentIndex = i10 + 1;
        return strArr[i10];
    }

    public final void setCurrentIndex(int i10) {
        this.currentIndex = i10;
    }
}
