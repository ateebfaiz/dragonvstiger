package com.fasterxml.jackson.databind.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class c implements Iterator, Iterable {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f5668a;

    /* renamed from: b  reason: collision with root package name */
    private int f5669b = 0;

    public c(Object[] objArr) {
        this.f5668a = objArr;
    }

    public boolean hasNext() {
        if (this.f5669b < this.f5668a.length) {
            return true;
        }
        return false;
    }

    public Iterator iterator() {
        return this;
    }

    public Object next() {
        int i10 = this.f5669b;
        Object[] objArr = this.f5668a;
        if (i10 < objArr.length) {
            this.f5669b = i10 + 1;
            return objArr[i10];
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
