package com.google.android.gms.internal.auth;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class z1 implements Iterator {
    z1() {
    }

    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
