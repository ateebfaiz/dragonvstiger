package com.geetest.core;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class f3<T> implements Iterator<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T[] f5974a;

    /* renamed from: b  reason: collision with root package name */
    public int f5975b = 0;

    public f3(T[] tArr) {
        this.f5974a = tArr;
    }

    public boolean hasNext() {
        if (this.f5975b < this.f5974a.length) {
            return true;
        }
        return false;
    }

    public T next() {
        int i10 = this.f5975b;
        T[] tArr = this.f5974a;
        if (i10 != tArr.length) {
            this.f5975b = i10 + 1;
            return tArr[i10];
        }
        throw new NoSuchElementException("Out of elements: " + this.f5975b);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove element from an Array.");
    }
}
