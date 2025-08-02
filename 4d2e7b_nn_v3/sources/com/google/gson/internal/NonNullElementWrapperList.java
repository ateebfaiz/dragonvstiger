package com.google.gson.internal;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

public class NonNullElementWrapperList<E> extends AbstractList<E> implements RandomAccess {
    private final ArrayList<E> delegate;

    public NonNullElementWrapperList(ArrayList<E> arrayList) {
        Objects.requireNonNull(arrayList);
        this.delegate = arrayList;
    }

    private E nonNull(E e10) {
        if (e10 != null) {
            return e10;
        }
        throw new NullPointerException("Element must be non-null");
    }

    public void add(int i10, E e10) {
        this.delegate.add(i10, nonNull(e10));
    }

    public void clear() {
        this.delegate.clear();
    }

    public boolean contains(Object obj) {
        return this.delegate.contains(obj);
    }

    public boolean equals(Object obj) {
        return this.delegate.equals(obj);
    }

    public E get(int i10) {
        return this.delegate.get(i10);
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    public int indexOf(Object obj) {
        return this.delegate.indexOf(obj);
    }

    public int lastIndexOf(Object obj) {
        return this.delegate.lastIndexOf(obj);
    }

    public E remove(int i10) {
        return this.delegate.remove(i10);
    }

    public boolean removeAll(Collection<?> collection) {
        return this.delegate.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return this.delegate.retainAll(collection);
    }

    public E set(int i10, E e10) {
        return this.delegate.set(i10, nonNull(e10));
    }

    public int size() {
        return this.delegate.size();
    }

    public Object[] toArray() {
        return this.delegate.toArray();
    }

    public boolean remove(Object obj) {
        return this.delegate.remove(obj);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.delegate.toArray(tArr);
    }
}
