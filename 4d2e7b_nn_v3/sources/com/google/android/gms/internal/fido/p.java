package com.google.android.gms.internal.fido;

import java.util.NoSuchElementException;

final class p extends zzcb {

    /* renamed from: a  reason: collision with root package name */
    boolean f7079a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Object f7080b;

    p(Object obj) {
        this.f7080b = obj;
    }

    public final boolean hasNext() {
        return !this.f7079a;
    }

    public final Object next() {
        if (!this.f7079a) {
            this.f7079a = true;
            return this.f7080b;
        }
        throw new NoSuchElementException();
    }
}
