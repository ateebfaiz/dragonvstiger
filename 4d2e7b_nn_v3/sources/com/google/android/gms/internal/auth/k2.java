package com.google.android.gms.internal.auth;

import java.util.Iterator;

final class k2 implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    final Iterator f6948a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzhd f6949b;

    k2(zzhd zzhd) {
        this.f6949b = zzhd;
        this.f6948a = zzhd.zza.iterator();
    }

    public final boolean hasNext() {
        return this.f6948a.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f6948a.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
