package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class e implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private int f7146a = 0;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzat f7147b;

    e(zzat zzat) {
        this.f7147b = zzat;
    }

    public final boolean hasNext() {
        return this.f7146a < this.f7147b.zza.length();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        int i10 = this.f7146a;
        if (i10 < this.f7147b.zza.length()) {
            this.f7146a = i10 + 1;
            return new zzat(String.valueOf(i10));
        }
        throw new NoSuchElementException();
    }
}
