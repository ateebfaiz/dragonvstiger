package com.google.android.gms.internal.common;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class f implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private Object f7034a;

    /* renamed from: b  reason: collision with root package name */
    private int f7035b = 2;

    protected f() {
    }

    /* access modifiers changed from: protected */
    public abstract Object a();

    /* access modifiers changed from: protected */
    public final Object b() {
        this.f7035b = 3;
        return null;
    }

    public final boolean hasNext() {
        int i10 = this.f7035b;
        if (i10 != 4) {
            int i11 = i10 - 1;
            if (i10 == 0) {
                throw null;
            } else if (i11 == 0) {
                return true;
            } else {
                if (i11 != 2) {
                    this.f7035b = 4;
                    this.f7034a = a();
                    if (this.f7035b != 3) {
                        this.f7035b = 1;
                        return true;
                    }
                }
                return false;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public final Object next() {
        if (hasNext()) {
            this.f7035b = 2;
            Object obj = this.f7034a;
            this.f7034a = null;
            return obj;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
